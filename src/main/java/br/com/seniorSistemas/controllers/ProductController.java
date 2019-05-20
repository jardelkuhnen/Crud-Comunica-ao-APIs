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

import br.com.seniorSistemas.dto.ProductDTO;
import br.com.seniorSistemas.entities.Product;
import br.com.seniorSistemas.services.ProductService;
import br.com.seniorSistemas.utils.Response;

@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/listAll")
	public List<Product> listAll() {
		return productService.listAll();
	}

	@GetMapping("/loadById/{id}")
	public ResponseEntity<?> loadById(@PathVariable Long id) {
		Response<?> response = new Response<>();

		if (id == null) {
			response.getErrors().add("Cliente não localizado");
			return ResponseEntity.badRequest().body(response);
		}

		Product productMatched = productService.loadById(id);

		return ResponseEntity.ok(productMatched);
	}

	@PostMapping("/save")
	public ResponseEntity<Response<ProductDTO>> save(@Valid @RequestBody ProductDTO productDTO, BindingResult result) {

		Response<ProductDTO> response = new Response<ProductDTO>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		productService.save(productDTO);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/update")
	public ResponseEntity<Response<ProductDTO>> update(@Valid @RequestBody ProductDTO productDTO, BindingResult result) {
		Response<ProductDTO> response = new Response<ProductDTO>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		productService.update(productDTO);

		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Response<?> response = new Response<>();
		
		if (id == null) {
			response.getErrors().add("Produto não localizado");
			return ResponseEntity.badRequest().body(response);
		}
		
		productService.delete(id);
		
		return ResponseEntity.ok().build();
		
	}
	
}
