package com.bluespace.tech.hrms.service.employee;

import java.util.List;

import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;

public abstract interface EmployeeService {

	public abstract EmployeeDetails createNewEmployee(EmployeeDetails newEmployeeDetails);

	public abstract EmployeeDetails getEmployeeById(long employeeId);

	public abstract List<EmployeeDetails> getAllEmployees();
	
	public abstract boolean updateEmployee(long id, EmployeeDetails employeeDetails);
	
	/*public abstract List<EmployeeDetails> updateEmployee(long id, List<EmployeeDetails> employeeDetails);*/
	
	public abstract boolean deleteByEmployeeId(long employeeId);

}
