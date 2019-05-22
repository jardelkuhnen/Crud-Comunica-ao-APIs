package br.com.seniorSistemas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seniorSistemas.entities.ItemOrders;
import br.com.seniorSistemas.repositories.ItemOrdersRepository;

@Service
public class ItemOrdersService {

	@Autowired
	private ItemOrdersRepository itemOrderRepo;
	
	public void deleteItens(List<ItemOrders> itens) {
		itemOrderRepo.deleteInBatch(itens);
	}
}
