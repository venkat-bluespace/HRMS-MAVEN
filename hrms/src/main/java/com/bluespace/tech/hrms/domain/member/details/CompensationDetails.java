package com.bluespace.tech.hrms.domain.member.details;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="compensationdetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompensationDetails {

    enum EmploymentType {
        FULLTIME,HOURLY
    }
    
    @Getter @Setter @Id private int id;
    @Getter @Setter private List<Lead> lead;
    @Getter @Setter private String currencyCode;
    @Getter @Setter private Double hourlyRate;
    @Getter @Setter private EmploymentType  employmentDetail;
	
}
