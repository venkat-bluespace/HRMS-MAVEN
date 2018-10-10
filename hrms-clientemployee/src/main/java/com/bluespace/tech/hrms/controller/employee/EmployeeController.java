package com.bluespace.tech.hrms.controller.employee;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bluespace.tech.hrms.domain.client.Client;
import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;
import com.bluespace.tech.hrms.service.employee.EmployeeService;
import com.mongodb.MongoException;

@RestController
@CrossOrigin
@RequestMapping("/")
public class EmployeeController {

	private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	public String getClientDetails(String clientName) {

		try {
			Client client = new Client();
			clientName = client.getClientName();
		} catch (MongoException e) {
			logger.error("Client " + clientName + " does not exist in the system.");
		}
		return clientName;
	}

/*	@PostMapping(path = "/employee/addNewEmployee", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE }, produces = "application/json" { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmployeeDetails> addEmployee(@Validated @RequestBody EmployeeDetails newEmployeeDetails,
			UriComponentsBuilder uriBuilder) {
		public ResponseEntity<EmployeeDetails> addEmployee(@Validated @RequestBody EmployeeDetails newEmployeeDetails,
				UriComponentsBuilder uriBuilder, @RequestParam String clientName) {
		logger.info("In Employee Controller -> Onboarding a new employee");

		// getClientDetails(clientName);
		EmployeeDetails addEmployee = employeeService.createNewEmployee(newEmployeeDetails);

		URI location = uriBuilder.path("employee/addNewEmployee/{id}").buildAndExpand(addEmployee.get_id()).toUri();

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);

		try {
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			logger.error("The employee was not created due to the exception " + e);
		}
		return new ResponseEntity<EmployeeDetails>(newEmployeeDetails, headers, HttpStatus.OK);
	}*/
	
	// This method creates/adds a new employee to a client
	@PostMapping(path = "employee/addNewEmployee", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeDetails addEmployee(@Validated @RequestBody EmployeeDetails newEmployeeDetails) {
		newEmployeeDetails = employeeService.createNewEmployee(newEmployeeDetails);
		return newEmployeeDetails;
	}
	
	// Get Employee details based off his id
	@GetMapping(path = "/employee/{employeeId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeDetails getEmployeeById(@PathVariable("employeeId") Integer id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping(path = "/employee")
	public List<EmployeeDetails> getAllEmployees() {
		return employeeService.getEmployeesList();
	}
	
	@GetMapping(path = "/hello", produces = "text/plain")
	public String hello() {
		return "Hello World";
	}
	
	@PostMapping(path = "/hello", produces = "text/plain")
	public String hellow() {
		return "Hello World";
	}
	
}
