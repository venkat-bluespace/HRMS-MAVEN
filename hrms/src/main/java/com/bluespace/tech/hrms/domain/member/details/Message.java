package com.bluespace.tech.hrms.domain.member.details;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.general.CurrentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

	static enum Type {
		 PRIVATE,PUBLIC
	}
	
	@Getter @Setter @Id private int id;
	@Getter @Setter private String message;
	@Getter @Setter private Date dateCreated;
	@Getter @Setter private Type  messageType;
	@Getter @Setter private Lead lead;
	@Getter @Setter private List<CurrentStatus> messageStatus;
	@Getter @Setter private Date lastUpdatedDate;
	
}
