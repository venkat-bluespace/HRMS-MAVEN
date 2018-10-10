package com.bluespace.tech.hrms.domain.member.details;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

// IMP NOTE: This document (table in RDBMS terminology needs to be vetted out)
public class LeadPreferences {
	
    static public enum SmsOptInStatus
	{
		NOT_SENT,
        SENT,
        ACCEPTED,
        DECLINED
	}
    
	@Getter @Setter private boolean emailOptIn;
	@Getter @Setter private boolean smsOptIn;
	@Getter @Setter private boolean wantsHtml;
	@Getter @Setter private Date dateEmailOptedIn;
	@Getter @Setter private Date dateEmailOptedOut;
	@Getter @Setter private Date dateSmsOptedIn;
	@Getter @Setter private SmsOptInStatus smsOptInStatus = SmsOptInStatus.NOT_SENT ;
	@Getter @Setter private Date dateSmsOptedOut;
	@Getter @Setter private String ipAddressEmailOptIn;
	@Getter @Setter private String ipAddressEmailOptOut;

}
