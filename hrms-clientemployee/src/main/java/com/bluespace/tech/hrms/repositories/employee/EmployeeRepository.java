package com.bluespace.tech.hrms.repositories.employee;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;
import com.mongodb.client.result.UpdateResult;

@Repository("employeeService")
public interface EmployeeRepository extends MongoRepository<EmployeeDetails, Long> {

	public abstract EmployeeDetails findByEmailId(String paramString);

	public List<EmployeeDetails> getEmployeeByEmployeeId(long employeeId);
	
	public EmployeeDetails save(UpdateResult result);
	
	public EmployeeDetails deleteEmployeeByEmployeeId(long employeeId);
	
}