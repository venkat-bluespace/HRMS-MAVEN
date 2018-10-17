package com.bluespace.tech.hrms.repositories.employee;

import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;
import com.mongodb.client.MongoCollection;

@Repository("employeeService")
public interface EmployeeRepository extends MongoRepository<EmployeeDetails, Long> {

	public abstract EmployeeDetails findByEmailId(String paramString);

	public EmployeeDetails getEmployeeByEmployeeId(long employeeId);

	public List<EmployeeDetails> save(MongoCollection<Document> collection);

	public EmployeeDetails deleteEmployeeByEmployeeId(long employeeId);

}