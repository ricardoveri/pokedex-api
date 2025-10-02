Pokédex API
Uma API RESTful para gerenciar informações sobre Treinadores e seus Pokémons. Construída com Spring Boot, Spring Security (JWT), JPA/Hibernate e PostgreSQL.

✨ Features
Autenticação e Autorização com JWT: Endpoints protegidos para garantir que apenas treinadores autenticados possam gerenciar seus pokémons.

Gerenciamento de Treinadores: Cadastro (Registro) e Login de Treinadores.

CRUD de Pokémons:

Criar um novo Pokémon e associá-lo a um treinador.

Listar todos os Pokémons (endpoint público).

Buscar um Pokémon por ID (endpoint público).

Documentação da API: Interface Swagger UI para fácil exploração e teste dos endpoints.

Validação de Dados: Validação robusta nos dados de entrada para garantir a integridade.

🛠️ Tecnologias Utilizadas
Backend: Java 21+, Spring Boot 3.3.1, Spring Security 6, JPA / Hibernate

Banco de Dados: PostgreSQL

Autenticação: JSON Web Tokens (JWT)

Build & Dependências: Maven

Documentação: SpringDoc (Swagger UI)

🚀 Setup e Execução
Siga os passos abaixo para configurar e rodar a aplicação em seu ambiente de desenvolvimento local.

Pré-requisitos
Java 21+

Maven 3.8+

PostgreSQL

Um cliente de API como Postman ou Insomnia (opcional, pois o Swagger UI já serve para testes).

Passos para Instalação
Clone o repositório:

Bash

git clone <url-do-seu-repositorio>
cd pokedex-api
Configure o Banco de Dados PostgreSQL:

Certifique-se de que você tem uma instância do PostgreSQL rodando em sua máquina.

Crie um banco de dados chamado pokedex_db.

Configure a Aplicação:

Abra o arquivo src/main/resources/application.properties.

Ajuste as propriedades spring.datasource.username e spring.datasource.password de acordo com as suas credenciais do PostgreSQL.

Execute a Aplicação:

Via terminal, na raiz do projeto, execute o comando Maven:

Bash

mvn spring-boot:run
Via IDE (IntelliJ, Eclipse, etc.), encontre a classe PokedexApiApplication e execute o método main.

Acesse a Aplicação:

Após a inicialização, a API estará disponível em http://localhost:8080.

📖 Uso da API
A forma mais fácil de explorar e testar a API é através da documentação interativa do Swagger.

Acesse a documentação em: http://localhost:8080/swagger-ui.html

Fluxo de Autenticação
Registre um Treinador: Use o endpoint POST /auth/register para criar uma nova conta de treinador.

Faça o Login: Use o endpoint POST /auth/login com o nome de usuário e senha criados para obter um token JWT.

Acesse Rotas Protegidas: Para acessar endpoints que exigem autenticação (como criar um Pokémon), clique no botão "Authorize" no topo da página do Swagger, cole o seu token no formato Bearer <seu-token-aqui> e clique em "Authorize". A partir daí, todas as suas requisições incluirão o token de autorização.

Principais Endpoints
POST /auth/register: Registrar um novo treinador.

POST /auth/login: Autenticar e obter um token JWT.

GET /pokemons: Listar todos os Pokémons.

GET /pokemons/{id}: Buscar um Pokémon pelo seu ID.

POST /pokemons/trainer/{trainerId}: Criar um novo Pokémon para um treinador (requer autenticação).

⚙️ Configuração
As principais configurações da aplicação podem ser ajustadas no arquivo src/main/resources/application.properties:

spring.datasource.url: URL de conexão com o banco de dados.

spring.datasource.username: Usuário do banco de dados.

spring.datasource.password: Senha do banco de dados.

application.security.jwt.secret-key: Chave secreta para a assinatura dos tokens JWT.
