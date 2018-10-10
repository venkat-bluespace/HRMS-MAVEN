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

@Document(collection = "displaypreferences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisplayPreferences {

	static public enum DefaultPage {
		DASHBOARD_WALL, MESSAGE_WALL, FRIENDS_WALL
	}

	@Getter @Setter @Id private int id;
	@Getter @Setter private int noOfRecordsToDisplay;
	@Getter @Setter @DBRef private List<Lead> lead;
	@Getter @Setter private DefaultPage defaultPageToDisplay;
	@Getter @Setter private Date dateCreated;
	@Getter @Setter private Date lastUpdatedDate;

}
