package com.bluespace.tech.hrms.security.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public enum AccountTypeConstants {

	SUPER_ADMIN("SUPER_ADMIN"),  ADMIN("ADMIN"),  EMPLOYEE("EMPLOYEE"),  USER("USER");
	
	@Getter @Setter private String accountType;
	
	private AccountTypeConstants(String accountType)
	  {
	    this.accountType = accountType;
	  }
	
	public static Set<AccountTypeConstants> getAllUserAccountTypes() {
		return new HashSet<>(Arrays.asList(values()));
	}

	public static AccountTypeConstants[] getUserAccountTypesForNewUser() {
		AccountTypeConstants[] userAccountTypes = new AccountTypeConstants[3];
		userAccountTypes[0] = ADMIN;
		userAccountTypes[1] = EMPLOYEE;
		userAccountTypes[2] = USER;

		return userAccountTypes;
	}
}
