package br.com.seniorSistemas.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClientDTO {

	private Long id;
	
	@NotEmpty(message = "O nome do cliente não pode ser vazio!")
	private String name;
	
	@CPF(message = "CPF inválido!")
	private String cpf;

	
}
