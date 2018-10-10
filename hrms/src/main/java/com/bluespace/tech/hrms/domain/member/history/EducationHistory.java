package com.bluespace.tech.hrms.domain.member.history;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.general.Address;
import com.bluespace.tech.hrms.domain.general.CurrentStatus;
import com.bluespace.tech.hrms.domain.member.details.Lead;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="educationhistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationHistory {

	@Getter @Setter @Id private int id;
	@Getter @Setter private List<Address> address;
	@Getter @Setter private List<Lead> lead;
	@Getter @Setter private String schoolName;
	@Getter @Setter private String universityName;
	@Getter @Setter private DegreeType degreeType;
	@Getter @Setter private String specilization;
	@Getter @Setter private int startYear;
	@Getter @Setter private int endYear;
	@Getter @Setter private Date dateCreated;
	@Getter @Setter private Date lastUpdatedDate;
	@Getter @Setter private CurrentStatus status;
	
}
