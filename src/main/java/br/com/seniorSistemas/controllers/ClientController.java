package br.com.seniorSistemas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.seniorSistemas.dto.ClientDTO;
import br.com.seniorSistemas.entities.Client;
import br.com.seniorSistemas.services.ClientService;
import br.com.seniorSistemas.utils.Response;

@RestController
@RequestMapping("api/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/listAll")
//	@PreAuthorize("hasAnyRole('ADMIN')")
	public List<Client> listAll() {
		return clientService.listAll();
	}

	@GetMapping("/loadById/{id}")
	public ResponseEntity<?> loadById(@PathVariable Long id) {
		Response<?> response = new Response<>();

		if (id == null) {
			response.getErrors().add("Cliente não localizado");
			return ResponseEntity.badRequest().body(response);
		}

		Client clientMatched = clientService.loadById(id);

		return ResponseEntity.ok(clientMatched);
	}

	@PostMapping("/save")
	public ResponseEntity<Response<ClientDTO>> save(@Valid @RequestBody ClientDTO clientDTO, BindingResult result) {

		Response<ClientDTO> response = new Response<ClientDTO>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		clientService.save(clientDTO);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/update")
	public ResponseEntity<Response<ClientDTO>> update(@Valid @RequestBody ClientDTO clientDTO, BindingResult result) {
		Response<ClientDTO> response = new Response<ClientDTO>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		clientService.update(clientDTO);

		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Response<?> response = new Response<>();
		
		if (id == null) {
			response.getErrors().add("Cliente não localizado");
			return ResponseEntity.badRequest().body(response);
		}
		
		clientService.delete(id);
		
		return ResponseEntity.ok().build();
		
	}

}
