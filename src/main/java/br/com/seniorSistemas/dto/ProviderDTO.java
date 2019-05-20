package br.com.seniorSistemas.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProviderDTO {

private Long id;
	
	@NotEmpty(message = "O nome do fornecedor não pode ser vazio!")	
	private String name;
	
	@CNPJ(message = "CNPJ inválido!")
	private String CNPJ;
	
}
