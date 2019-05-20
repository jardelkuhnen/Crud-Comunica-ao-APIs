package br.com.seniorSistemas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seniorSistemas.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
