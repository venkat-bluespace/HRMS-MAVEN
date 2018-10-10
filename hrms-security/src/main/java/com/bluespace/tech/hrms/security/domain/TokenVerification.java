package com.bluespace.tech.hrms.security.domain;

import java.util.Calendar;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.client.Client;

@Document
public class TokenVerification {

	private static final int EXPIRATION = 1440;
	
	@Getter @Setter @Id private ObjectId _id;
	@Getter private String token;
	@Getter private Client clientAccount;
	@Getter private UserAccount userAccount;
	@Getter @Setter private Date expirationDate;

	private Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(cal.getTime().getTime()));
		cal.add(12, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

	public TokenVerification() {

	}

	public TokenVerification(String token, UserAccount user) {
		this.token = token;
		this.userAccount = user;
		this.expirationDate = calculateExpiryDate(EXPIRATION);
	}
	
	public TokenVerification(String token, Client client) {
		this.token = token;
		this.clientAccount = client;
		this.expirationDate = calculateExpiryDate(EXPIRATION);
	}
}