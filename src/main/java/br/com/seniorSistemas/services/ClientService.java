package br.com.seniorSistemas.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seniorSistemas.dto.ClientDTO;
import br.com.seniorSistemas.entities.Client;
import br.com.seniorSistemas.repositories.ClientRepository;

@Service
public class ClientService {

	private ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public void save(@Valid ClientDTO clientDTO) {

		Client client = new Client();
		client.setCpf(clientDTO.getCpf());
		client.setName(clientDTO.getName());

		clientRepository.save(client);
	}

	public List<Client> listAll() {
		return clientRepository.findAll();
	}

	public Client loadById(Long id) {
		return clientRepository.getOne(id);
	}

	public void update(@Valid ClientDTO clientDTO) {
		Client client = clientRepository.findById(clientDTO.getId()).get();

		client.setCpf(clientDTO.getCpf());
		client.setName(clientDTO.getName());

		clientRepository.save(client);
	}

	public void delete(Long id) {
		Client client = clientRepository.findById(id).get();
		clientRepository.delete(client);
	}
	
	public Boolean checkIfExists(Client client) {
		
		Client c = clientRepository.getOne(client.getId());

		if(c != null) {
			return true;
		}else {
			return false;
		}
		
	}

}
