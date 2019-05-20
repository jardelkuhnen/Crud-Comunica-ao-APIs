package br.com.seniorSistemas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.seniorSistemas.entities.Client;
import br.com.seniorSistemas.repositories.ClientRepository;

@SpringBootApplication
public class SeniorSistemasApplication {

	@Autowired
	private ClientRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SeniorSistemasApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandRunner() {
		return args -> {

			Client c = new Client();
			c.setName("jardel");
			c.setCpf("09717775940");
			repo.save(c);
			
			Client c2 = new Client();
			c2.setName("jardel");
			c2.setCpf("09717775940");
			repo.save(c2);
		};
	}

}
