package com.bluespace.tech.hrms.domain.generic;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;

import lombok.Data;

@Document
@Data
public class Projects {

	@Id private ObjectId _id;
	private String projectName;
	private String projectDescription;
	private String jobTitle;
	private String jobDuties;
	private String workLocation;
	private Date projectStartDate;
	private Date projectEndDate;
	private String customerName;
	private String customerEmail;
	private String customerPhone;
	private String customerAltPhone;
	private String implPartnerName;
	private String implPartnerEmail;
	private String implPartnerPhone;
	private String implPartnerAltPhone;
	private String primaryVendorName;
	private String primaryVendorEmail;
	private String primaryVendorPhone;
	private String primaryVendorAltPhone;
	private String secondaryVendorName;
	private String secondaryVendorEmail;
	private String secondaryVendorPhone;
	private String secondaryVendorAltPhone;
	@DBRef private EmployeeDetails employeeName;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;
	
}