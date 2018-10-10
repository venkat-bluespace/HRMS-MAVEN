package com.bluespace.tech.hrms.domain.member.details;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="leadtrackingdata")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadTrackingData {

	@Getter @Setter @Id private int id;
	@Getter @Setter private String source;
	@Getter @Setter private String visitorId;
	@Getter @Setter private String referrer;
	@Getter @Setter private Date createdDate;
	@Getter @Setter private List<Lead> lead;
	@Getter @Setter private String jobId;
	@Getter @Setter private List<LeadPreferences> preferences;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		LeadTrackingData that = (LeadTrackingData) o;

		if (!lead.equals(that.lead))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = lead.hashCode();
		return result;
	}
	
}
