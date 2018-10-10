package com.bluespace.tech.hrms.domain.client;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;

import lombok.Data;

@Document
@Data
public class ReportingStructure {
	
	@Id private ObjectId _id;
	@DBRef private EmployeeDetails employeeInfo;
	@DBRef private EmployeeDetails reportingManager;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;

}
