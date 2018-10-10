package com.bluespace.tech.hrms.domain.member.history;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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

@Document(collection="workhistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkHistory {

	@Getter @Setter @Id private int id;
	@Getter @Setter private Date startDate;
	@Getter @Setter private Date endDate;
	@Getter @Setter private String company;
	@Getter @Setter private String jobTitle;
	@Getter @Setter private List<Address> address;
	@Getter @Setter private String jobDuties;
	@Getter @Setter private List<Lead> lead;
	@Getter @Setter private Boolean currentEmployer=false;
	@Getter @Setter private Date dateCreated;
	@Getter @Setter private Date lastUpdatedDate;
	@Getter @Setter private List<CurrentStatus> status;

	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
	
	public void setStartDate(int month, int year) {
		try {
			if (month > 0 && month < 13 && year > 1900 && year < (LocalDateTime.now().getYear())) {
				startDate = (Date) dateFormatter.parse("01/" + month + "" + year);
			}
		} catch (Exception exec) {
		}
	}
	
	public void setEndDate(int month, int year) {
		try {
			if (month > 0 && month < 13 && year > 1900 && year < (LocalDateTime.now().getYear())) {
				endDate = (Date) dateFormatter.parse("01/" + month + "" + year);
			}
		} catch (Exception exec) {
		}
	}
	
}
