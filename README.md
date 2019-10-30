# CrudComunicacaoAPIs

Projeto API para cadastro de produtos, fornecedores, clientes e pedidos.

## Execução do projeto

Para executar o projeto basta executar `mvn spring-boot:run` no pronpt de comando ou importar a aplicação em uma ide como Spring Tools Suite(https://spring.io/tools) e executar a aplicação como Sprint Boot App.


## Tecnologias

 - Java 1.8
 - Spring Boot 
 - H2 Database
 - Autenticaçao com JWT
 - JPA 
 - Swagger para documentação
 
 ## Documentação
 
 Para acessar a documentação basta executar o projeto e acessar a url: (http://localhost:8080/swagger-ui.html).
 Nessa página serão listados todos os endpoints da api com exemplos de JSON a ser enviado para a correta utilização.
 
 ## Testes da Api
 
 Ao iniciar a aplicação já serão inseridos na base de dados alguns registros de cliente, produto e um usuário para testes. 
 
 Para visualizar os dados inseridos basta acesar na url(http://localhost:8080/console).
 
 
## Aplicação disponibilizada no Heroku

UrlBase: https://crud-vendas-api.herokuapp.com/

Autenticação: 
POST:
UrlBase/auth
{
	"email": "seniorSistemas@email.com",
	"senha": "123456789"
}

Demais urls acessíveis após autenticação.
 
