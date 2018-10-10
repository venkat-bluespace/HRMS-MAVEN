package com.bluespace.tech.hrms.security.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.client.Client;

import lombok.Getter;
import lombok.Setter;

@Document(collection="accountapproval")
public class AccountApproval extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private Client clientAccount;
	@Getter @Setter private Long idPendingApproval;
	@Getter @Setter private String status;
	@Getter @Setter private String email;

	public String toString() {
		return "AccountApproval [clientAccount=" + this.clientAccount + ", idPendingApproval=" + this.idPendingApproval
				+ ", status=" + this.status + ", email=" + this.email + "]";
	}

}
