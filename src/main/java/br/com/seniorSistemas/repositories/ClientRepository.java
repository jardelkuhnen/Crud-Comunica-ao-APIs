package br.com.seniorSistemas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seniorSistemas.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
