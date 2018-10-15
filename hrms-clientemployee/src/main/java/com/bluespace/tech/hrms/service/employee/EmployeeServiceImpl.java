package com.bluespace.tech.hrms.service.employee;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.apache.http.util.EntityUtils;
import org.bson.BSONObject;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;
import com.bluespace.tech.hrms.repositories.employee.EmployeeRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
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
	private static long employeeId=0;

	@Autowired private EmployeeRepository employeeRepository;	
	
	@Autowired private MongoClient mongoClient;
	
	private EmployeeDetails employeeDetails;
	
	public long getNextSequence() {
		return employeeId++;
	}

	public EmployeeDetails createNewEmployee(@ModelAttribute EmployeeDetails newEmployee) {
		EmployeeDetails newEmployeeDetails=null;
		try {
			/*MongoDatabase db = mongoConfig.db();
			MongoCollection<Document> collection = db.getCollection("employeeDetails");*/
			
			long x=getNextSequenceId();
			
			newEmployee.setEmployeeId(x + 1);
			Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			newEmployee.setCreatedOn(currentTime.getTime());
			newEmployeeDetails = employeeRepository.save(newEmployee);
		} catch (MongoException e) {
			logger.error("Connection failed due to " + e);
		} finally {
//			mongoClient.close();
		}

		return newEmployeeDetails;
	}
	
	public long getNextSequenceId() {
		org.bson.Document empIdDoc=null;
		long empId=0;
		mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db =  mongoClient.getDatabase("hrms");
		
		MongoCollection<org.bson.Document> collection1 =  db.getCollection("employeeDetails");
		
		FindIterable<org.bson.Document> fi= collection1.find().sort(new BasicDBObject( "employeeId" , -1 ) ).limit(1);
		MongoCursor<org.bson.Document> cursor = fi.iterator();
		
		while (cursor.hasNext()) {
			empIdDoc = cursor.tryNext();
		}
		if (empIdDoc != null) {
			empId = (long) empIdDoc.get("employeeId");
		}
		return empId;
	  }

	@Override
	public List<EmployeeDetails> getEmployeeById(long employeeId) {
		return employeeRepository.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public EmployeeDetails updateEmployee(long id, EmployeeDetails employeeDetails) {
		//List<EmployeeDetails> empDetails = employeeRepository.getEmployeeByEmployeeId(id);

/*		mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("hrms");
		MongoCollection<org.bson.Document> collection = db.getCollection("employeeDetails");
		Bson filter = null;
		filter = eq("employeeId", id);
		BSONObject update = new BasicDBObject();
		MongoCursor<org.bson.Document> cursor = null;
		FindIterable<org.bson.Document> fi = collection.find(filter).returnKey(true);
		cursor = fi.iterator(); 
		while(cursor.hasNext()) {
			update.putAll(m);
			
		}
		UpdateResult result = collection.updateOne(filter, (Bson) update); */
		
/*		ObjectMapper mapper = new ObjectMapper();
		String requestEmpDetails = null;
		EmployeeDetails empInfo = null;*/
		
		 
/*		try {
			String currentEmpDetails = mapper.readValue
			requestEmpDetails = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeDetails);
			empInfo = mapper.readValue(requestEmpDetails, EmployeeDetails.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//String responseEmpDetails = mapper.
//		mapper.updateValue(employeeDetails, EmployeeDetails.class);
		//String responseEmpDetails = EntityUtils.
		//List<EmployeeDetails> empDetails = mapper.readValue(mapper, employeeDetails);
		
		return employeeRepository.save(employeeDetails);
		//return empDetails;
	}

/*	public EmployeeDetails updateEmployee(long id, EmployeeDetails employeeDetails) {
		return employeeDetails;
	}*/
	
	@Override
	public boolean deleteByEmployeeId(long employeeId) {
		mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("hrms");
		MongoCollection<org.bson.Document> collection = db.getCollection("employeeDetails");
	
		try {
			Bson filter = null;
			Bson query = null;
			filter = eq("employeeId", employeeId);
			query = combine(set("active", false));
			UpdateResult result = collection.updateOne(filter, query);
			logger.info("Documents updated count in Delete Employee call()" + result.getModifiedCount());
			if (result.getModifiedCount() > 0) {
				return true;
			}
		} catch (Exception e) {
			logger.error("There's no employee with the provided Employee Id hence failed with the exception: " + e);
		}
		return false;
	}
}