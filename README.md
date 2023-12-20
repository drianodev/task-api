# Task Manager API

## Descrição
Projeto Task Manager desenvolvido como parte do desafio da Brickup. O aplicativo consiste em um gerenciador de tarefas, com funcionalidades para listar todas as tarefas, obter detalhes de uma tarefa específica, criar, atualizar e excluir tarefas.

## Tecnologias Utilizadas
- [Spring Boot](https://spring.io/projects/spring-boot) - Framework para a criação de aplicativos Java.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Facilita a interação com bancos de dados relacionais.
- [Spring Web](https://spring.io/guides/gs/spring-boot/) - Facilita o desenvolvimento de aplicativos web com Spring.
- [MySQL Connector/J](https://dev.mysql.com/doc/connector-j/en/) - Conector JDBC para MySQL.
- [Lombok](https://projectlombok.org/) - Biblioteca para reduzir a verbosidade do código.
- [ModelMapper](http://modelmapper.org/) - Facilita o mapeamento entre objetos.

## Pré-requisitos
- Java 17
- Maven
- MySQL

## Configuração do Banco de Dados
- Configure as propriedades do banco de dados no arquivo `application.properties` com as informações do seu banco MySQL.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Executando o Projeto
1. Clone o repositório.
2. Configure o banco de dados conforme descrito acima.
3. Execute a aplicação usando uma IDE.
4. O aplicativo estará disponível em [http://localhost:8080](http://localhost:8080).

## Endpoints

- **GET /tasks:** Retorna todas as tarefas.
- **GET /tasks/{id}:** Retorna os detalhes de uma tarefa específica.
- **POST /tasks:** Cria uma nova tarefa.
- **PUT /tasks/{id}:** Atualiza os detalhes de uma tarefa existente.
- **DELETE /tasks/{id}:** Exclui uma tarefa.
