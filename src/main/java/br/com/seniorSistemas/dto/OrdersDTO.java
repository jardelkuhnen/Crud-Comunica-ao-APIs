package br.com.seniorSistemas.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.seniorSistemas.entities.ItemOrders;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrdersDTO {

	private Long id;

	@NotNull(message = "O cliente do pedido não pode ser vazio!")
	private Long clientId;
	
	@NotEmpty(message = "O pedido não pode ser vazio!")
	private List<ItemOrders> itensOrder;

}
