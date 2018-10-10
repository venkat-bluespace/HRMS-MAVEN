package com.bluespace.tech.hrms.domain.attachment;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "searchtext")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchableText {

	@Getter @Setter @Id private int id;
	@Getter @Setter private int leadAttachment_id;
	@Getter @Setter private String searchableText;
	@Getter @Setter private int lead_id;
	@Getter @Setter private String documentType;
}
