package br.com.seniorSistemas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.seniorSistemas.entities.Client;
import br.com.seniorSistemas.entities.ItemOrders;
import br.com.seniorSistemas.entities.Orders;
import br.com.seniorSistemas.entities.Product;
import br.com.seniorSistemas.repositories.ClientRepository;
import br.com.seniorSistemas.repositories.ProductRepository;
import br.com.seniorSistemas.security.entities.Usuario;
import br.com.seniorSistemas.security.enums.PerfilEnum;
import br.com.seniorSistemas.security.repositories.UsuarioRepository;
import br.com.seniorSistemas.utils.SenhaUtils;
import br.com.seniorSistemas.utils.WriteJSon;

@SpringBootApplication
public class SeniorSistemasApplication {

	@Autowired
	private ClientRepository repo;

	@Autowired
	private UsuarioRepository userRepo;

	@Autowired
	private ProductRepository productRepo;

	public static void main(String[] args) {
		SpringApplication.run(SeniorSistemasApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandRunner() {
		return args -> {
			// Inserindo usuario inicial
			Usuario user = new Usuario();
			user.setEmail("seniorSistemas@email.com");
			user.setPerfil(PerfilEnum.ROLE_ADMIN);
			user.setSenha(SenhaUtils.gerarBCrypt("123456789"));
			userRepo.save(user);

			// Inserindo clientes
			Client c = new Client();
			c.setName("Cliente 1");
			c.setCpf("68674944043");
			repo.save(c);

			Client c2 = new Client();
			c2.setName("Cliente 2");
			c2.setCpf("02610424086");
			repo.save(c2);

			// Inserindo alguns produtos iniciais
			Product product = new Product();
			product.setDescription("Cerveja");
			product.setPriceBuy(2.0);
			product.setPriceSale(5.0);
			productRepo.save(product);

			Product product2 = new Product();
			product2.setDescription("Carne");
			product2.setPriceBuy(1.5);
			product2.setPriceSale(4.5);
			productRepo.save(product2);

			Product product3 = new Product();
			product3.setDescription("Carvão");
			product3.setPriceBuy(6.5);
			product3.setPriceSale(12.0);
			productRepo.save(product3);

			// Montando JSON do Pedido para teste
			Orders order = new Orders();
			order.setClient(c);

			ItemOrders item = new ItemOrders();
			item.setOrder(order);
			item.setProduct(product);

			List<ItemOrders> itens = new ArrayList<ItemOrders>();
			itens.add(item);
			order.setItensOrder(itens);

			WriteJSon.printJson(order);

		};
	}

}
