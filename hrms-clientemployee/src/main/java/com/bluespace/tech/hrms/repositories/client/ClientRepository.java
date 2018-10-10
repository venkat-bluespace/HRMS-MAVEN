package com.bluespace.tech.hrms.repositories.client;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bluespace.tech.hrms.domain.client.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

	/*public abstract Client findUserAccountByUserName(String paramString);*/

	public abstract Client findByEmailAddress(String paramString);

	//public abstract Client findClientAccountById(long paramLong);

	public abstract String deleteByClientName(String clientName);

}
