package com.bluespace.tech.hrms.security.core;

import java.util.Properties;

//import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationFailure authenticationFailure;
	@Autowired
	private AuthenticationSuccess authenticationSuccess;
	@Autowired
	private EntryPointUnauthorizedHandler unauthorizedHandler;

/*	@Bean
	public VelocityEngine velocityEngine() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("input.encoding", "UTF-8");
		properties.setProperty("output.encoding", "UTF-8");
		properties.setProperty("resource.loader", "class");
		properties
				.setProperty("class.resource.loader.class",
						"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		VelocityEngine velocityEngine = new VelocityEngine(properties);
		return velocityEngine;
	}*/

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}

	protected void configure(HttpSecurity http) throws Exception {
/*		http.csrf().csrfTokenRepository(csrfTokenRepository()).and()
				.exceptionHandling()
				.authenticationEntryPoint(this.unauthorizedHandler).and()
				.formLogin().successHandler(this.authenticationSuccess)
				.failureHandler(this.authenticationFailure).and().logout()
				.permitAll().and().authorizeRequests().antMatchers("/")
				.permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.permitAll();*/
	    http.csrf().disable().authorizeRequests() 
        .antMatchers("/register").permitAll()      
        .antMatchers("/login").permitAll()
        .antMatchers("/employee").permitAll();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void AuthorityReactiveAuthorizationManager() {

	}
}