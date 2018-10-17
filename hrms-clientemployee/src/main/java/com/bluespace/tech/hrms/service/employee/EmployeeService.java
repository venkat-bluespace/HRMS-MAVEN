package com.bluespace.tech.hrms.service.employee;

import java.util.List;

import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;
import com.bluespace.tech.hrms.dto.EmployeeDetailsDTO;
import com.bluespace.tech.hrms.exception.EntityNotFoundException;

public abstract interface EmployeeService {

	/*public abstract EmployeeDetails createNewEmployee(EmployeeDetailsDTO newEmployeeDetails);*/
	
	public abstract EmployeeDetails createNewEmployee(EmployeeDetails newEmployeeDetails);

	public abstract EmployeeDetails getEmployeeById(long employeeId);

	public abstract List<EmployeeDetails> getAllEmployees();
	
	public abstract boolean updateEmployee(EmployeeDetailsDTO employeeDetails, long id);
	
//	public abstract List<EmployeeDetails> updateEmployee(long id, List<EmployeeDetails> employeeDetails);
	
	public abstract boolean deleteByEmployeeId(long employeeId) throws EntityNotFoundException;

}
