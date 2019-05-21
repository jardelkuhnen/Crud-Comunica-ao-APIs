package br.com.seniorSistemas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seniorSistemas.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
