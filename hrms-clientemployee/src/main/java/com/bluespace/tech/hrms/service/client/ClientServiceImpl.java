package com.bluespace.tech.hrms.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bluespace.tech.hrms.domain.client.Client;
import com.bluespace.tech.hrms.repositories.client.ClientRepository;
import com.bluespace.tech.hrms.security.domain.TokenVerification;
import com.bluespace.tech.hrms.security.repositories.TokenVerificationRepository;

@Service
@Component
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	//@Autowired
	private TokenVerificationRepository tokenVerificationRepository;

	@Override
	public Client addNewClient(Client client) {
		return this.clientRepository.save(client);
	}

	@Override
	public List<Client> listAllClients() {
		return this.clientRepository.findAll();
	}

	public void deleteClient(String clientName) {
		this.clientRepository.deleteByClientName(clientName);
	}

	@Override
	public void createTokenVerification(Client client, String token) {
		TokenVerification newToken = new TokenVerification(token, client);
		this.tokenVerificationRepository.save(newToken);
	}

	@Override
	public TokenVerification getTokenVerification(String token) {
		return this.tokenVerificationRepository.findByToken(token);
	}

	@Override
	public String getEncodedPassword(String rawPassword) {
		return this.passwordEncoder.encode(rawPassword);
	}

}
