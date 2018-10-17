package com.bluespace.tech.hrms.security.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.bluespace.tech.hrms.domain.client.Client;
import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;
import com.bluespace.tech.hrms.domain.general.Address;
import com.bluespace.tech.hrms.repositories.client.ClientRepository;
import com.bluespace.tech.hrms.security.domain.AccountApproval;
import com.bluespace.tech.hrms.security.domain.AccountCreationEmail;
import com.bluespace.tech.hrms.security.domain.CompanyRegistration;
import com.bluespace.tech.hrms.security.domain.DefaultResponse;
import com.bluespace.tech.hrms.security.domain.TokenVerification;
import com.bluespace.tech.hrms.security.domain.User;
import com.bluespace.tech.hrms.security.repositories.AccountApprovalRepository;
import com.bluespace.tech.hrms.security.repositories.CompanyRegistrationRepository;
import com.bluespace.tech.hrms.security.util.EmailHandler;
import com.bluespace.tech.hrms.security.util.MailTemplateConfiguration;
import com.bluespace.tech.hrms.service.client.ClientService;

public class RegistrationController {

	private static Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	private EmailHandler emailHandler;

//	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CompanyRegistrationRepository companyRegRepo;

	@Autowired
	private AccountApprovalRepository accountApprovalRepository;

	@Autowired
	private MailTemplateConfiguration mailTemplateConfiguration;

	@GetMapping(value = "")
	public ResponseEntity<DefaultResponse> welcomeNewRegistration() {
		return new ResponseEntity<>(getWelcomeResponse(), HttpStatus.OK);
	}

	private DefaultResponse getWelcomeResponse() {
		DefaultResponse response = new DefaultResponse();
		response.setResponseCode(200L);
		response.setResponseMessage("New Registration Controller");
		return response;
	}

	@PostMapping(value = { "/register" }, consumes = { "application/json" }, produces = { "application/json" })
	public void registerNewUser(@RequestBody Map<String, Object> registrationDetails, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			HttpStatus status = null;
			response.setContentType("application/json");
			if ((registrationDetails == null) || (registrationDetails.isEmpty())) {
				response.setStatus(400);
				response.getOutputStream().println("{ \"error\": \" Blank form received \"}");
			}
			String firstName = (String) registrationDetails.get("firstName");
			String lastName = (String) registrationDetails.get("lastName");
			String emailAddress = (String) registrationDetails.get("emailAddress");
			String companyName = (String) registrationDetails.get("clientName");
			String companyURL = (String) registrationDetails.get("companyURL");
			String zipCode = (String) registrationDetails.get("zipCode");
			String contactNumber = (String) registrationDetails.get("contactNumber");
			Long employeeStrength = (Long) registrationDetails.get("employeeStrength");
//			String registeredUserRole = (String) registrationDetails.get("registeredUserRole");
			
/*			String clientStatus = (String) registrationDetails.get("clientStatus");
			String federalId = (String) registrationDetails.get("federalId");
			String address = (String) registrationDetails.get("address");
			String currentStatus = (String) registrationDetails.get("currentStatus");
			String addressLine1 = (String) registrationDetails.get("addressLine1");
			String addressLine2 = (String) registrationDetails.get("addressLine2");
			String city = (String) registrationDetails.get("city");
			String stateCode = (String) registrationDetails.get("stateCode");
			String state = (String) registrationDetails.get("state");
			String country = (String) registrationDetails.get("country");
			String zipCode = (String) registrationDetails.get("zipCode");*/

			String password = (String) registrationDetails.get("password");
			String confirmPassword = (String) registrationDetails.get("confirmPassword");
			// Comment out the below Debug log statements before pushing it to Production
			logger.debug("Received details of the registered user are {}, {} and {}", emailAddress, password,
					contactNumber);

			if (!password.equals(confirmPassword)) {
				// Comment out the below Debug log statements before pushing it to Production
				logger.debug("Passwords given in the fields Password and Confirm Password do not match");
				response.setStatus(400);
				response.getOutputStream().println("{ \"error\": \" Passwords do not match \"}");
				return;
			}
			logger.debug("Creating the user account");

			CompanyRegistration company = this.companyRegRepo
					.findCompanyRegistrationByCompanyNameIgnoreCase(companyName);
			if (company == null) {
				logger.info("Company is not yet Registered with us. Creating a new record to be sent for approval");

				CompanyRegistration record = new CompanyRegistration();
				record.setCompanyName(companyName);
				record.setDescription("To be Updated");
				company = (CompanyRegistration) this.companyRegRepo.save(record);
			}

			Address clientAddress = new Address();
			clientAddress.setZipCode(zipCode);
			Client clientAccount = new Client();
			clientAccount.setEmailAddress(emailAddress);
			clientAccount.setClientName(companyName);
			clientAccount.setCompanyURL(companyURL);
			clientAccount.setPhoneNumber(contactNumber);
			clientAccount.setEmployeeStrength(employeeStrength);
			
			
			
			User newUser = new User();
			newUser.setUserName(emailAddress);
			newUser.setPassword(password);
			
			
			EmployeeDetails empClientDetails = new EmployeeDetails();
			empClientDetails.setFirstName(firstName);
			empClientDetails.setLastName(lastName);
			//empClientDetails.setClient(companyName);
			
/*			clientAccount.setAddress(address);
			clientAccount.setCurrentStatus(currentStatus);
			clientAccount.setAddressLine1(addressLine1);
			clientAccount.setAddressLine2(addressLine2);
			clientAccount.setCity(city);
			clientAccount.setStatecode(stateCode);
			clientAccount.setState(state);
			clientAccount.setCountry(country);
			clientAccount.setZipcode(zipCode);*/

			Client newClient = this.clientService.addNewClient(clientAccount);

			AccountApproval approval = new AccountApproval();
			approval.setStatus("PENDING");
//			approval.setIdPendingApproval(newClient.getId());
			approval.setEmail(newClient.getEmailAddress());

			Client adminAccount = this.clientRepository
					.findByEmailAddress(this.mailTemplateConfiguration.getMailSuperAdmins().trim());
			approval.setClientAccount(adminAccount);

			this.accountApprovalRepository.save(approval);
			logger.info("Pending Approval stats saved successfully");

			AccountCreationEmail mail = new AccountCreationEmail();
			mail.setMailTo(this.mailTemplateConfiguration.getMailSuperAdmins());
			mail.setMailFrom("<no-reply>@hrms.net");
			mail.setMailSubject("New User Accout Created");

			Map<String, Object> model = new HashMap<String, Object>();
//			model.put("userName", newClient.getUsername());
			model.put("signature", "www.hrms.com");
			mail.setModel(model);

			this.emailHandler.sendEmailToAdmin(mail);

			logger.debug("Return status : " + status);
			response.setStatus(200);
			response.getOutputStream().println("{ \"Success\": \" Account creation successful. \"}");
		} catch (IOException ex) {
			response.setStatus(500);
			try {
				response.getOutputStream().println("{ \"Error\": \" Internal Server Error. " + ex.getMessage() + "\"}");
			} catch (IOException e) {
				logger.error(e.getMessage());
				return;
			}
		}
	}

	@GetMapping(value = { "/regitrationConfirm" })
	public void confirmRegistration(WebRequest request, @RequestParam("token") String token,
			HttpServletResponse response) throws IOException {
		logger.info("Activing profile..");
		TokenVerification tokenVerification = this.clientService.getTokenVerification(token);
		if (tokenVerification == null) {
			response.setStatus(400);
			response.getOutputStream().println("{ \"Error\": \" Invalid token (null) \"}");
		}
		Client clientUser = tokenVerification.getClientAccount();
		Calendar cal = Calendar.getInstance();
		if (tokenVerification.getExpirationDate().getTime() - cal.getTime().getTime() <= 0L) {
			logger.error("user expired already on " + tokenVerification.getExpirationDate().getTime());
			response.setStatus(400);
			response.getOutputStream().println("{ \"Error\": \" user expired already on "
					+ tokenVerification.getExpirationDate().getTime() + " \"}");
		}
		clientUser.setActive(true);
		clientUser.setAccountExpired(false);
		clientUser.setAccountLocked(false);
		this.clientService.addNewClient(clientUser);
		logger.info("Profile activated successfully, the user can now login..");
		response.setStatus(200);
		response.getOutputStream()
				.println("{ \"Success\": \" Account acivated successfully, the user can now login \"}");
	}
}
