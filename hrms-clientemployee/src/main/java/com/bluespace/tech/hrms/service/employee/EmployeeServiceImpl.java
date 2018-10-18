package com.bluespace.tech.hrms.service.employee;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;
import com.bluespace.tech.hrms.dto.EmployeeDetailsDTO;
import com.bluespace.tech.hrms.exception.EntityNotFoundException;
import com.bluespace.tech.hrms.repositories.employee.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.Updates.combine;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	private static long employeeId = 0;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private MongoClient mongoClient;

	public long getNextSequence() {
		return employeeId++;
	}

	public EmployeeDetails createNewEmployee(@ModelAttribute EmployeeDetails newEmployee) {
		EmployeeDetails newEmployeeDetails = null;
		mongoClient = new MongoClient("localhost", 27017);
		/*
		 * MongoDatabase db = mongoClient.getDatabase("hrms"); MongoCollection<Document>
		 * collection = db.getCollection("employeeDetails");
		 */
		try {
			long x = getNextSequenceId();
			
			newEmployee.setEmployeeId(x + 1);
			Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			newEmployee.setCreatedOn(currentTime.getTime());
			newEmployeeDetails = employeeRepository.save(newEmployee);
		} catch (MongoException e) {
			logger.error("Connection failed due to " + e);
		} finally {
			mongoClient.close();
		}
		return newEmployeeDetails;
	}
	
	public long getNextSequenceId() {
		Document empIdDoc = null;
		long empId = 0;
		mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("hrms");

		MongoCollection<Document> collection1 = db.getCollection("employeeDetails");

		FindIterable<Document> fi = collection1.find().sort(new BasicDBObject("employeeId", -1)).limit(1);
		MongoCursor<Document> cursor = fi.iterator();

		while (cursor.hasNext()) {
			empIdDoc = cursor.tryNext();
		}
		if (empIdDoc != null) {
			empId = (long) empIdDoc.get("employeeId");
		}
		return empId;
	}

	@Override
	public EmployeeDetails getEmployeeById(long employeeId) {
		EmployeeDetails employeeDetails = employeeRepository.getEmployeeByEmployeeId(employeeId);
		if (employeeDetails == null) {
			throw new EntityNotFoundException(
					"There is no record of employee in the system with the id: " + employeeId);
		}
		return employeeRepository.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
/*	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeDetails> updateEmployee(long id, List<EmployeeDetails> employeeDetails) {
		
		mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("hrms");
		MongoCollection<Document> collection = db.getCollection("employeeDetails");
		ObjectMapper mapper=new ObjectMapper();
		//Query query = new Query();
		try {
			String json = null;
			Bson filter = eq("employeeId", id);
			employeeDetails = new ArrayList<EmployeeDetails>();
			employeeDetails = (List<EmployeeDetails>) new ObjectMapper().readValue(json, EmployeeDetails.class);
			collection.updateOne(filter, combine(set("employeeDetails", employeeDetails)));
			return (List<EmployeeDetails>) collection;
		} catch (Exception e) {
			logger.error("Unable to find the employee id so failed with exception: "+e);
		}
		

		try {
			Bson filter = eq("employeeId", id);
			
		} catch (Exception e) {
			logger.error("Error in updating employee info, failed with exception: " + e);
		}
		return employeeDetails;
	}*/
	

	@Override
	public boolean updateEmployee(EmployeeDetailsDTO employeeDetails, long id) {

		mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("hrms");
		MongoCollection<Document> collection = db.getCollection("employeeDetails");
		ObjectMapper mapper = new ObjectMapper();

		EmployeeDetails empId = employeeRepository.getEmployeeByEmployeeId(id);
		if (empId == null) {
			throw new EntityNotFoundException("There is no record of employee in the system with the id: " + id);
		}

		try {
			Bson filter = null;
			filter = eq("employeeId", id);

			@SuppressWarnings("unchecked")
			Map<String, Object> requestMap = mapper.convertValue(employeeDetails, Map.class);
			List<Bson> combinations = new ArrayList<Bson>();

			for (String key : requestMap.keySet()) {
				Object value = requestMap.get(key);
				if (value != null && value != (Integer) 0 && value != (Double) 0.0) {
					combinations.add(set(key, value));
				}
			}
			Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			combinations.add(set("employeeId", id));
			combinations.add(set("modifiedOn", currentTime.getTime()));
			Bson x = combine(combinations);

			UpdateResult result = collection.updateOne(filter, x);
			logger.info("No. of documents updated for the Employee Update call is: " + result.getModifiedCount());
			if (result.getModifiedCount() > 0) {
				return true;
			}
		} catch (Exception e) {
			logger.error("There was no value found and hence failed with the exception: " + e);
		} finally {
			mongoClient.close();
		}
		return false;
	}
	
	@Override
	public boolean deleteByEmployeeId(long employeeId) throws EntityNotFoundException {
		mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("hrms");
		MongoCollection<Document> collection = db.getCollection("employeeDetails");

		EmployeeDetails empId = employeeRepository.getEmployeeByEmployeeId(employeeId);
		if (empId == null) {
			throw new EntityNotFoundException(
					"There is no record of employee in the system with the id: " + employeeId);
		}

		try {
			Bson filter = null;
			Bson query = null;
			filter = eq("employeeId", employeeId);
			query = combine(set("active", false));
			UpdateResult result = collection.updateOne(filter, query);
			logger.info("Documents deleted in the Delete Employee call(): " + result.getModifiedCount());
			if (result.getModifiedCount() > 0) {
				return true;
			}
		} catch (Exception e) {
			logger.error("There's no employee with the provided Employee Id hence failed with the exception: " + e);
		} finally {
			mongoClient.close();
		}
		return false;
	}

/*	@Override
	public EmployeeDetails createNewEmployee(EmployeeDetailsDTO newEmployeeDetails) {
		// TODO Auto-generated method stub
		return null;
	}*/

}