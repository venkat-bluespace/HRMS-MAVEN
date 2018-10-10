package com.bluespace.tech.hrms.repositories.employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;

@Repository("employeeService")
public interface EmployeeRepository extends MongoRepository<EmployeeDetails, String> {

	public abstract EmployeeDetails findByEmailId(String paramString);

	public EmployeeDetails getEmployeeByEmployeeId(long employeeId);
}