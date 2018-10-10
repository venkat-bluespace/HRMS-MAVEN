package com.bluespace.tech.hrms.domain.employee;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Immigration {

	@Id private ObjectId _id;
	@DBRef private EmployeeDetails employeeId;
	private String visaStatus;
	private Date visaValidFrom;
	private Date visaValidUntil;
	private String workLocation;
	private Integer socTitleCode;
	private String socJobTitle;
	private Double lcsSalary;
	private Double lcsHourlyBilling;
	private String wageLevel;
	private Double salaryPerImmigration;
	private Date lca_Filed_Date;
	private Date lca_Approval_Date;
	private Date h1_Amend_Filing_Date;
	private Date h1_Approval_Date;
	private Date gc_Filed_Date;
	private Date gc_Approval_Date;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;
	
}