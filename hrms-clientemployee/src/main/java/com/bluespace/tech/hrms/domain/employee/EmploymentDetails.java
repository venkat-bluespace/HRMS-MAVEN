package com.bluespace.tech.hrms.domain.employee;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentDetails {

	@DBRef private List<EmployeeDetails> employeeDetails;
	private String jobTitle;
	private String salary;
	private String department;
	private Date hiredDate;
	private Date startDate;
	private Date endDate;
	private String employmentType;
	private String employmentStatus;
	
}
