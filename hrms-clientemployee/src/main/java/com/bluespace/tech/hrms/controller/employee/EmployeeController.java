package com.bluespace.tech.hrms.controller.employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bluespace.tech.hrms.domain.client.Client;
import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;
import com.bluespace.tech.hrms.dto.EmployeeDetailsDTO;
import com.bluespace.tech.hrms.exception.EntityNotFoundException;
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

	// Get Employee details based off his id
	@GetMapping(path = "/employee/{employeeId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeDetails getEmployeeById(@PathVariable("employeeId") long id) {
		return employeeService.getEmployeeById(id);
	}

	// Update Employee details based on his employeeId
	@PutMapping(path = "/employee/{employeeId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Void> updateEmployee(@Validated @RequestBody EmployeeDetailsDTO employeeDetails,
			@PathVariable("employeeId") long id) {
		if (this.employeeService.updateEmployee(employeeDetails, id))
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/*
	 * public List<EmployeeDetails> updateEmployee(@PathVariable("employeeId") long
	 * id,
	 * 
	 * @Validated @RequestBody EmployeeDetails employeeDetails) { employeeDetails =
	 * employeeService.updateEmployee(id, employeeDetails); return employeeDetails;
	 * }
	 */

	// Creates/adds a new employee to a client
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/employee/create", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeDetails addEmployee(@Validated @RequestBody EmployeeDetails employeeDetails) {
		EmployeeDetails newEmployeeDetails = employeeService.createNewEmployee(employeeDetails);
		return newEmployeeDetails;
	}

	// Delete an employee based on his employeeId
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/employee/{employeeId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Void> deleteEmployee(@PathVariable long employeeId) throws EntityNotFoundException {
		if (this.employeeService.deleteByEmployeeId(employeeId))
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// Get the list of all Employees of a Client
	@GetMapping(path = "/employee", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public List<EmployeeDetails> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
}
