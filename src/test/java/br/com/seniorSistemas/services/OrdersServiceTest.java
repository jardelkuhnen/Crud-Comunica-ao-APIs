package br.com.seniorSistemas.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.seniorSistemas.dto.OrdersDTO;
import br.com.seniorSistemas.entities.Client;
import br.com.seniorSistemas.entities.ItemOrders;
import br.com.seniorSistemas.entities.Orders;
import br.com.seniorSistemas.repositories.OrdersRepository;

@RunWith(MockitoJUnitRunner.class)
public class OrdersServiceTest {

	@InjectMocks
	private OrdersService orderService;

	@Mock
	private OrdersRepository orderRepository;
	@Mock
	private ItemOrdersService itemOrderService;
	@Mock
	private List<ItemOrders> itensOrder;
	@Mock
	private Client client;
	
	public OrdersDTO createOrdersDTO() {
		OrdersDTO dto = new OrdersDTO();
		
		dto.setId(1L);
		dto.setClient(client);
		dto.setItensOrder(itensOrder);

		return dto;
	}
	
	@Before
	public void init() {
		this.orderService = new OrdersService(this.orderRepository, this.itemOrderService);
	}

	@Test
	public void whenGetAll() {
		List<Orders> orders = orderService.listAll();
		assertNotNull(orders);

		verify(orderRepository, times(1)).findAll();
	}

	
	@Test
	public void whenSaveShouldNotNull() {
		
		OrdersDTO orderDTO = createOrdersDTO();
		
		assertNotNull(orderDTO.getClient());
		assertNotNull(orderDTO.getItensOrder());
		
	}
	
}
