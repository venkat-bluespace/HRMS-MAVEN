package com.bluespace.tech.hrms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bluespace.tech.hrms.repositories.client.ClientRepository;

@SpringBootApplication(scanBasePackages = "com.bluespace.tech.hrms")
public class HrmsApplication {

	private static Logger logger = LogManager.getLogger(HrmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
		logger.info("Loading HRMS Application");
	}
	
	@Bean
	public CommandLineRunner client(ClientRepository clientRepository) {
		return null;
		
	}

}