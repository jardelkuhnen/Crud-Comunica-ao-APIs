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

import br.com.seniorSistemas.dto.OrdersDTO;
import br.com.seniorSistemas.entities.Orders;
import br.com.seniorSistemas.services.OrdersService;
import br.com.seniorSistemas.utils.Response;

@RestController
@RequestMapping("api/order")
public class OrderController {

	@Autowired
	private OrdersService orderService;
	

	@GetMapping("/listAll")
	public List<Orders> listAll() {
		return orderService.listAll();
	}

	@GetMapping("/loadById/{id}")
	public ResponseEntity<?> loadById(@PathVariable Long id) {
		Response<?> response = new Response<>();

		if (id == null) {
			response.getErrors().add("Pedido não localizado");
			return ResponseEntity.badRequest().body(response);
		}

		Orders orderMatched = orderService.loadById(id);

		return ResponseEntity.ok(orderMatched);
	}

	@PostMapping("/save")
	public ResponseEntity<Response<OrdersDTO>> save(@Valid @RequestBody OrdersDTO orderDTO, BindingResult result) {

		Response<OrdersDTO> response = new Response<OrdersDTO>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		orderService.save(orderDTO);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/update")
	public ResponseEntity<Response<OrdersDTO>> update(@Valid @RequestBody OrdersDTO orderDTO, BindingResult result) {
		Response<OrdersDTO> response = new Response<OrdersDTO>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		orderService.update(orderDTO);

		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Response<?> response = new Response<>();
		
		if (id == null) {
			response.getErrors().add("Produto não localizado");
			return ResponseEntity.badRequest().body(response);
		}
		
		orderService.delete(id);
		
		return ResponseEntity.ok().build();
		
	}
	
	
}
