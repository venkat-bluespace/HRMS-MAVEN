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
public class WorkHistory {

	@Id private ObjectId _id;
	@DBRef private EmployeeDetails employee;
	private Date startDate;
	private Date endDate;
	private String jobTitle;
	private String jobName;
	private String jobDescription;
	@DBRef private Address addressId;
	
}
