🏎️ F1 Management API
Esta é uma API REST desenvolvida para gerenciar equipes e pilotos do universo da Fórmula 1. 
O projeto permite realizar o cadastro completo (CRUD) de escuderias e seus respectivos competidores, mantendo o relacionamento entre eles.

🚀 Tecnologias Utilizadas
Java 17 ou superior.

Spring Boot 3: Framework base da aplicação.

Spring Data JPA: Para persistência de dados e integração com o banco.

H2 Database / MySQL: Banco de dados para armazenamento das informações.

Maven: Gerenciador de dependências.

Postman: Para testes dos endpoints.

🛠️ Funcionalidades
Equipes (Teams)
Cadastrar uma nova equipe (Nome, País, Motor).

Listar todas as equipes.

Atualizar dados de uma equipe existente.

Remover uma equipe do sistema.

Pilotos (Drivers)
Cadastrar um piloto associado a uma equipe.

Listar todos os pilotos cadastrados.

Atualizar informações do piloto (Nome, Nacionalidade, Número).

Remover um piloto.

📋 Como Executar o Projeto
Clonar o repositório:

Bash
git clone https://github.com/seu-usuario/f1-management-api.git
Importar no IntelliJ:

Abra o IntelliJ IDEA.

Vá em File > Open e selecione a pasta do projeto.

Aguarde o Maven baixar as dependências.

Rodar a aplicação:

Localize a classe principal (com a anotação @SpringBootApplication).

Clique com o botão direito e selecione Run.

Testar os Endpoints:

A API estará disponível em http://localhost:8080.
