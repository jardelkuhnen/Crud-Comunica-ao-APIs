package br.com.seniorSistemas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seniorSistemas.entities.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

}
