package com.bluespace.tech.hrms.domain.general;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.member.details.Lead;
import com.bluespace.tech.hrms.security.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="communicationlogentry")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationLogEntry {

	@Getter @Setter @Id private int id;
	@Getter @Setter private String message;
	@Getter @Setter private Date dateSent;
	@Getter @Setter private Date dateViewed;
	@Getter @Setter @DBRef private List<User> sentBy;
	@Getter @Setter @DBRef private List<Lead> lead;
	@Getter @Setter private String link;
	@Getter @Setter private Date dateCreated;
	@Getter @Setter private Date lastUpdatedDate;

}
