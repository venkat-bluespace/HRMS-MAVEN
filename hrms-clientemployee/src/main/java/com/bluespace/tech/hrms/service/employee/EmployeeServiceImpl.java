package com.bluespace.tech.hrms.service.employee;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.DateOperators.IsoDateFromParts;
import org.springframework.data.mongodb.core.query.Update;
import static org.springframework.data.mongodb.core.query.Query.query;
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
import com.mongodb.client.model.IndexOptions;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired private EmployeeRepository employeeRepository;

	@Autowired private MongoConfig mongoConfig;

	@Autowired private MongoOperations mongoOp; 
	
	private static MongoClient mongoClient = null;


/*	public static Object getNextSequence(String name) throws Exception {
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
	}*/
	
	public long getNextSequence(String seqName) {
		EmployeeDetails employeeIdCounter = mongoOp.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("employeeId", 1), options().returnNew(true).upsert(true), EmployeeDetails.class);
		return employeeIdCounter.getEmployeeId();
	}

	public EmployeeDetails createNewEmployee(@ModelAttribute EmployeeDetails newEmployee) {
		try {
			/*MongoDatabase db = mongoConfig.db();
			MongoCollection<Document> collection = db.getCollection("employeeDetails");*/
			 
//			newEmployee.setEmployeeId(this.getNextSequence("counters"));
			Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			newEmployee.setCreatedOn(currentTime.getTime());
			return employeeRepository.save(newEmployee);
		} catch (MongoException e) {
			logger.error("Connection failed due to " + e);
		} finally {
//			mongoClient.close();
		}
//		return newEmployee;
/*		Calendar currentTime = Calendar.getInstance();
		newEmployee.setCreatedOn(currentTime.getTime());*/
		return employeeRepository.save(newEmployee);
	}

	@Override
	public EmployeeDetails getEmployeeById(long employeeId) {
		return employeeRepository.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeDetails updateEmployee(@ModelAttribute EmployeeDetails employeeDetails) {
		employeeRepository.save(employeeDetails);
		return employeeDetails;
	}

	@Override
	public EmployeeDetails deleteByEmployeeId(@ModelAttribute EmployeeDetails employeeDetails, long employeeId) {
		Boolean status = false;
		Boolean empStatus = employeeDetails.isActive();
		if (!empStatus.equals(status))
			employeeDetails.setActive(false);
		return employeeRepository.deleteEmployeeByEmployeeId(employeeId);
	}
}
