package com.bluespace.tech.hrms.config;

import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.bluespace.tech.hrms")
/*@ComponentScan({ "com.bluespace.tech.hrms", "com.bluespace.tech.hrms.repositories", "com.bluespace.tech.hrms.domain",
	"com.bluespace.tech.hrms.services", "com.bluespace.tech.hrms.endpoint" })*/
@PropertySource("file:src/main/resources/application.properties")
@EnableMongoRepositories(basePackages = "com.bluespace.tech.hrms.repositories")
public class MongoConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.database}")
	private String mongoDBName;

	@Value("${spring.data.mongodb.uri}")
	private String mongoDBURI;

	@Resource
	private Environment environment;
	private static final Logger logger = LoggerFactory.getLogger(MongoConfig.class);

	@Bean
	@Override
	public MongoClient mongoClient() {

		// MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoDBURI));
		// logger.info("Connecting to MongoDB with the provided URI: " + mongoDBURI);

		// Creating a mongo instance for Dev Environment
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		logger.info("Creating a Mongo instance based on the host and port details provided: " + mongoClient);
		return mongoClient;
	}
	
	@Bean
	public MongoDbFactory mongoDBFactory() throws UnknownHostException {
		return new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "hrms");
	}

	@Override
	protected String getDatabaseName() {
		logger.info("Retreiving the database " + mongoDBName);
		return mongoDBName;
	}

	@Bean
	public MongoDatabase db() {
		logger.info("Retreiving database name using getDatabase method in MongoClient");
		MongoDatabase db = mongoClient().getDatabase(mongoDBName);
		return db;
	}

	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}

}