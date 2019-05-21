package br.com.seniorSistemas;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.seniorSistemas.entities.Client;
import br.com.seniorSistemas.repositories.ClientRepository;
import br.com.seniorSistemas.security.entities.Usuario;
import br.com.seniorSistemas.security.enums.PerfilEnum;
import br.com.seniorSistemas.security.repositories.UsuarioRepository;
import br.com.seniorSistemas.utils.SenhaUtils;

@SpringBootApplication
public class SeniorSistemasApplication {

	@Autowired
	private ClientRepository repo;
	
	@Autowired
	private UsuarioRepository userRepo;
	
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
			
			Usuario user = new Usuario();
			user.setEmail("jardelkuhnen@gmail.com");
			user.setPerfil(PerfilEnum.ROLE_ADMIN);
			user.setSenha(SenhaUtils.gerarBCrypt("123456789"));
			
			this.userRepo.save(user);
			
		};
	}
	
	@Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

}
