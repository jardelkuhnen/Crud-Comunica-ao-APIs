package br.com.seniorSistemas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seniorSistemas.entities.Order;

public interface OrderRepostory extends JpaRepository<Order, Long> {

}
