package com.bluespace.tech.hrms.service.employee;

import java.util.List;


import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bluespace.tech.hrms.config.MongoConfig;
import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;
import com.bluespace.tech.hrms.repositories.employee.EmployeeRepository;
import com.mongodb.BasicDBObject;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private static MongoConfig mongoConfig;

	private static MongoClient mongoClient = null;
	


	public static Object getNextSequence(String name) throws Exception {
//		mongoClient = new MongoClient( "localhost" , 27017 );
		mongoClient = mongoConfig.mongoClient();
		try {
			//MongoDatabase db = mongoClient.getDatabase(mongoDBName);
			MongoDatabase db = mongoConfig.db();
			
			MongoCollection<Document> collection = db.getCollection("employeeDetails");
			BasicDBObject findDocument = new BasicDBObject();
			findDocument.put("employeeId", name);
			
			BasicDBObject updateDocument = new BasicDBObject();
			updateDocument.put("$inc", new BasicDBObject("seq", 1));
			DBObject obj = (DBObject) collection.findOneAndUpdate(findDocument, updateDocument);
			return obj.get("seq");			
		} catch (Exception e) {
			logger.error("Failed with exception: " + e);
		} finally {
			mongoClient.close();
		}
		return name;
	}
	
	public EmployeeDetails createNewEmployee(@ModelAttribute EmployeeDetails newEmployee) {
		try {
/*			MongoDatabase db = mongoConfig.db();
			
			MongoCollection<Document> collection = db.getCollection("employeeDetails");*/
			return employeeRepository.save(newEmployee);


		} catch (MongoException e) {
			logger.error("Connection failed due to " + e);
		} finally {
//			mongoClient.close();
		}
//		return newEmployee;
		return employeeRepository.save(newEmployee);
	}

	@Override
	public EmployeeDetails getEmployeeById(long employeeId) {
		return employeeRepository.getEmployeeByEmployeeId(employeeId);
	}

	public List<EmployeeDetails> getEmployeesList() {
		return employeeRepository.findAll();
	}

}
