package br.com.seniorSistemas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.seniorSistemas.services.ClientService;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	
}
