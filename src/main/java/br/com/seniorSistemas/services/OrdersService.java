package br.com.seniorSistemas.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seniorSistemas.dto.OrdersDTO;
import br.com.seniorSistemas.entities.ItemOrders;
import br.com.seniorSistemas.entities.Orders;
import br.com.seniorSistemas.repositories.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository orderRepository;
	
	@Autowired
	private ItemOrdersService itemOrderService;
	
	public List<Orders> listAll() {
		return orderRepository.findAll();
	}

	public Orders loadById(Long id) {
		return orderRepository.findById(id).get();
	}

	public void save(@Valid OrdersDTO orderDTO) {
		Orders order = new Orders();
		order.setClient(orderDTO.getClient());
		order.setItensOrder(orderDTO.getItensOrder());
		
		order = orderRepository.save(order);
		updateItensOrder(order);
		
	}

	public void update(@Valid OrdersDTO orderDTO) {
		Orders order = orderRepository.findById(orderDTO.getId()).get();
		
		order.setClient(orderDTO.getClient());
		order.setItensOrder(orderDTO.getItensOrder());
		
		order = orderRepository.save(order);
		updateItensOrder(order);
	}

	public void delete(Long id) {
		Orders order = orderRepository.findById(id).get();
		itemOrderService.deleteItens(order.getItensOrder());
		orderRepository.delete(order);
	}
	
	private void updateItensOrder(Orders order) {
		for (ItemOrders item : order.getItensOrder()) {
			item.setOrder(order);
		}
		orderRepository.save(order);
	}

}
