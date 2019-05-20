package br.com.seniorSistemas.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDTO {

	private Long id;

	@NotEmpty(message = "A descrição do produto não pode ser vazia!")
	private String description;
	
	private Double priceSale;
	
	private Double priceBuy;
	
}
