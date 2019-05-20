package br.com.seniorSistemas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.seniorSistemas.dto.ProviderDTO;
import br.com.seniorSistemas.entities.Provider;
import br.com.seniorSistemas.services.ProviderService;
import br.com.seniorSistemas.utils.Response;

@RestController
@RequestMapping("api/provider")
public class ProviderController {

	@Autowired
	private ProviderService providerService;

	@GetMapping("/listAll")
	public List<Provider> listAll() {
		return providerService.listAll();
	}

	@GetMapping("/loadById/{id}")
	public ResponseEntity<?> loadById(@PathVariable Long id) {
		Response<?> response = new Response<>();

		if (id == null) {
			response.getErrors().add("Cliente não localizado");
			return ResponseEntity.badRequest().body(response);
		}

		Provider providerMatched = providerService.loadById(id);

		return ResponseEntity.ok(providerMatched);
	}

	@PostMapping("/save")
	public ResponseEntity<Response<ProviderDTO>> save(@Valid @RequestBody ProviderDTO providerDTO, BindingResult result) {

		Response<ProviderDTO> response = new Response<ProviderDTO>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		providerService.save(providerDTO);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/update")
	public ResponseEntity<Response<ProviderDTO>> update(@Valid @RequestBody ProviderDTO providerDTO, BindingResult result) {
		Response<ProviderDTO> response = new Response<ProviderDTO>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		providerService.update(providerDTO);

		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Response<?> response = new Response<>();
		
		if (id == null) {
			response.getErrors().add("Produto não localizado");
			return ResponseEntity.badRequest().body(response);
		}
		
		providerService.delete(id);
		
		return ResponseEntity.ok().build();
		
	}
	
}
