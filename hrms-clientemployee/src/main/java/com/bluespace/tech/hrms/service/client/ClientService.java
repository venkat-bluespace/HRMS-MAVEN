package com.bluespace.tech.hrms.service.client;

import java.util.List;

import com.bluespace.tech.hrms.domain.client.Client;
import com.bluespace.tech.hrms.security.domain.TokenVerification;

public abstract interface ClientService {

	public abstract Client addNewClient(Client paramUserAccount);

	public abstract void createTokenVerification(Client paramUserAccount, String paramString);

	public abstract TokenVerification getTokenVerification(String paramString);

	public abstract String getEncodedPassword(String paramString);

	public abstract void deleteClient(String paramString);

	public abstract List<Client> listAllClients();

}
