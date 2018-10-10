package com.bluespace.tech.hrms.security.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Configuration
@PropertySource("file:src/main/resources/mail_template.properties")
public class MailTemplateConfiguration {

	@Value("${footer.light-text}")
	@Getter @Setter private String footerLightText;
	@Value("${footer.dark-text}")
	@Getter @Setter private String footerDarkText;
	@Value("${mail.superadmins}")
	@Getter @Setter private String mailSuperAdmins;
	@Value("${mail.ignoreList}")
	@Getter @Setter private String ignoreList;
	@Value("${mail.prohibited_content}")
	@Getter private String prohibitedContent;
	  
	public String toString() {
		return "MailTemplateConfiguration [footerLightText=" + this.footerLightText + ", footerDarkText="
				+ this.footerDarkText + ", mailSuperAdmins=" + this.mailSuperAdmins + ", ignoreList=" + this.ignoreList
				+ "]";
	}

}
