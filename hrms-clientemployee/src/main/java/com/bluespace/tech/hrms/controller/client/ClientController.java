package com.bluespace.tech.hrms.controller.client;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bluespace.tech.hrms.domain.client.Client;
import com.bluespace.tech.hrms.service.client.ClientService;

@Component
@RestController
@RequestMapping("/")
public class ClientController {

	private ClientService clientService;

	@PostMapping(value = "/clients/addNewClient")
	public Client addNewClient(@Validated @RequestBody Client newClientDetails) {
		newClientDetails = this.clientService.addNewClient(newClientDetails);
		return newClientDetails;
	}

	@GetMapping(value = "/clients/{clientId}")
	public List<Client> listAllClients() {
		return this.clientService.listAllClients();
	}

	@PostMapping(value = "/clients/{clientName}")
	public String deleteClient(@RequestParam("clientName") String clientName) {
		this.clientService.deleteClient(clientName);
		return "redirect:/clients";
	}

}
