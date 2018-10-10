package com.bluespace.tech.hrms.domain.general;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.member.details.Lead;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "recommendations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendations {

	static public enum Status {
		APPROVED, DENIED, DELETED
	}

	@Getter @Setter @Id private int id;
	@Getter @Setter @DBRef private List<Lead> lead;
	@Getter @Setter @DBRef private List<Lead> recommendedLead;
	@Getter @Setter @DBRef private List<Status> status;
	@Getter @Setter private Date dateCreated;
	@Getter @Setter private Date recommendedDate;

}
