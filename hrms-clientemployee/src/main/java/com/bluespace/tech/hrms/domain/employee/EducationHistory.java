package com.bluespace.tech.hrms.domain.employee;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.general.Address;

import lombok.Data;

@Document
@Data
public class EducationHistory {

	@Id private ObjectId _id;
	@DBRef private EmployeeDetails employeeId;
	private String degreeType;
	private String instituteName;
	private Date startDate;
	private Date endDate;
	@DBRef private Address addressId;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;
	
}