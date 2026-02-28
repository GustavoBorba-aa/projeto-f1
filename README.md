🏎️ F1 Management API
Status do Projeto: 🏗️ Em Desenvolvimento (Implementando Lógica de Campeonato e Integração de Endpoints)

Esta é uma API REST desenvolvida para gerenciar o ecossistema da Fórmula 1. O sistema organiza equipes, pilotos, carros e calendários de corridas, utilizando uma arquitetura robusta para garantir a integridade dos dados e a escalabilidade do sistema.

🛠️ Tecnologias e Ferramentas
Java 23: Utilizando as funcionalidades mais recentes da linguagem.

Spring Boot 3.4: Framework base para a criação da aplicação e inversão de controle.

Spring Data JPA: Mapeamento objeto-relacional (ORM) para persistência de dados.

PostgreSQL: Banco de dados relacional robusto para armazenamento de dados.

Lombok: Utilizado em Models e DTOs para eliminar código boilerplate (Getters, Setters, Construtores).

Bean Validation (Hibernate Validator): Validações rigorosas de entrada (ex: datas futuras, campos obrigatórios).

Maven: Gerenciamento de dependências e build do projeto.

🏗️ Arquitetura do Sistema
O projeto utiliza a Arquitetura em Camadas e o padrão DTO, visando a segurança e a separação de responsabilidades:

Controller: Porta de entrada da API. Recebe as requisições e utiliza @Valid para disparar as validações dos DTOs.

Service: Camada intermediária que contém a lógica de negócio e regras de validação customizadas antes de chegar ao banco.

Repository: Camada de persistência que utiliza Derived Queries e consultas personalizadas com @Query (JPQL).

Model/Entity: Entidades JPA (Team, Driver, Car, Races, Results) que definem o esquema do banco de dados.

DTO (Data Transfer Object): Classes como CreateTeamDTO e CreateDriverDTO que garantem que apenas os dados necessários sejam trafegados, protegendo a integridade das entidades.

Infra (Tratador de Erros): Centralização do tratamento de exceções (como erros de validação 400 ou 404).

📊 Modelo de Dados e Relacionamentos
Teams (1) ↔ (N) Drivers: Um time possui vários pilotos.

Teams (1) ↔ (1) Car: Um time gerencia um modelo de carro específico.

Races ↔ Results: Gerenciamento de resultados vinculados a Grandes Prêmios específicos.

🏁 Funcionalidades Atuais
[x] Gerenciamento de Equipes: Cadastro completo com validações de país e motor.

[x] Controle de Pilotos: Vinculação obrigatória a uma equipe e controle de numeração.

[x] Registro de Veículos: Mapeamento One-to-One entre carro e escuderia.

[x] Calendário de Corridas: Cadastro de circuitos e datas (validando para evitar datas passadas).

[x] Tratamento de Exceções: Retornos de erro amigáveis para o usuário da API.

🚀 Como Executar o Projeto
Clonar o repositório:

Bash
git clone https://github.com/seu-usuario/f1-management-api.git
cd f1-management-api
Configurar o Banco de Dados (Docker):
Certifique-se de que o Docker está em execução e inicie o banco de dados:

Bash
docker-compose up -d
Executar a aplicação:
Utilize o Maven para rodar o projeto:

Bash
mvn spring-boot:run
A API estará disponível em http://localhost:8080.

Testar com Postman:
Envie um POST para /teams com o seguinte corpo JSON:

JSON
{
  "name": "Red Bull Racing",
  "country": "Áustria",
  "engine": "Honda",
  "foundationYear": 2005,
  "sedeDaEquipe": "Milton Keynes",
  "chefeDeEquipe": "Christian Horner"
}
