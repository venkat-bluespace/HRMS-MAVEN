package com.bluespace.tech.hrms.domain.attachment;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "leadattachment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadAttachment {

	@Getter @Setter @Id private int id;
	@Getter @Setter private int leadId;
	@Getter @Setter private String filename;
	@Getter @Setter private byte[] filedata;
	@Getter @Setter private double fileSize;
	@Getter @Setter private String contentType;
	@Getter @Setter private String documentType;
	@Getter @Setter private String timestampString;
	@Getter @Setter private boolean processed = false;

	public String toString() {
		return "LeadAttachment{" + "id=" + id + ", leadId=" + leadId + ", filename='" + filename + '\'' + ", fileSize="
				+ fileSize + ", contentType='" + contentType + '\'' + ", timestampString='" + timestampString + '\''
				+ ", processed='" + processed + '\'' + '}';
	}
}
