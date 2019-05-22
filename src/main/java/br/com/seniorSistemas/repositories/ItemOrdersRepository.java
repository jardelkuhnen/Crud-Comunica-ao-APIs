package br.com.seniorSistemas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seniorSistemas.entities.ItemOrders;

public interface ItemOrdersRepository extends JpaRepository<ItemOrders, Long>{

}
