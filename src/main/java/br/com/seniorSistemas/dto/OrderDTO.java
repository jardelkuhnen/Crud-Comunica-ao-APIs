package br.com.seniorSistemas.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.seniorSistemas.entities.Client;
import br.com.seniorSistemas.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderDTO {

	private Long id;

	@NotNull(message = "O cliente do pedido não pode ser vazio!")
	private Client client;

	@NotEmpty(message = "O pedido não pode ser vazio!")
	private List<Product> products;

}
