🏎️ F1 Management API

Status do Projeto: ✅ MVP Concluído (em evolução com validações)

API REST desenvolvida em Java com Spring Boot para o gerenciamento de equipes e pilotos da Fórmula 1.
O projeto foi criado com foco em aprendizado prático, aplicando conceitos usados no mercado como arquitetura em camadas, JPA/Hibernate, DTOs e boas práticas de backend.

🎯 Objetivo do Projeto

Simular um sistema real de gerenciamento de dados da Fórmula 1, permitindo:

Cadastro e gerenciamento de equipes

Cadastro e gerenciamento de pilotos

Relacionamento entre entidades (Piloto → Equipe)

Organização do código seguindo padrões profissionais

Este projeto também serve como item de portfólio, demonstrando domínio de Spring Boot e API REST.

🚀 Tecnologias Utilizadas

Java 17

Spring Boot 3

Spring Web

Spring Data JPA

H2 Database (banco em memória para desenvolvimento e testes)

Maven (gerenciamento de dependências)

🧱 Arquitetura do Projeto

O projeto segue o padrão de arquitetura em camadas, separando responsabilidades:

controller  → Camada de entrada (API REST / HTTP)
service     → Regras de negócio
repository  → Acesso ao banco de dados
model       → Entidades JPA
dto         → Objetos de transferência de dados


Essa abordagem facilita a manutenção, leitura do código e futuras evoluções.

🛠️ Funcionalidades Implementadas
🏎️ Equipes (Teams) — ✅ Concluído

Cadastro de equipes (nome, país, motor)

Listagem de todas as equipes

Atualização de dados

Remoção de equipes

Tratamento de erro para registros inexistentes

👨‍✈️ Pilotos (Drivers) — ✅ Concluído

Cadastro de pilotos vinculados a uma equipe

Listagem de pilotos

Atualização de informações

Remoção de pilotos

🔜 Evolução próxima: validações de campos e verificação de ID de equipe inexistente.

🌐 Endpoints Principais
Equipes

POST /teams → Criar equipe

GET /teams → Listar equipes

PUT /teams/{id} → Atualizar equipe

DELETE /teams/{id} → Remover equipe

Pilotos

POST /drivers → Criar piloto

GET /drivers → Listar pilotos

PUT /drivers/{id} → Atualizar piloto

DELETE /drivers/{id} → Remover piloto

As requisições e respostas utilizam o formato JSON.

📋 Como Executar o Projeto
1️⃣ Clonar o repositório
git clone https://github.com/seu-usuario/f1-management-api.git

2️⃣ Acessar o diretório
cd f1-management-api

3️⃣ Executar o projeto
./mvnw spring-boot:run


Ou execute diretamente pela IDE (IntelliJ, Eclipse, etc.).

🗄️ Banco de Dados H2

Console disponível em:

http://localhost:8080/h2-console


Configurações padrão:

JDBC URL: jdbc:h2:mem:testdb

Usuário: sa

Senha: (em branco)

🧪 Testes da API

A API pode ser testada utilizando:

Postman

Insomnia

HTTP Client da IDE

🚀 Próximas Evoluções Planejadas

Validações com @NotNull, @NotBlank, @Size

Exception Handler global (@ControllerAdvice)

DTOs de resposta

Paginação com Pageable

Versionamento da API (/api/v1)

Migração para PostgreSQL com Docker

Autenticação (JWT) em versões futuras

📚 Aprendizados com o Projeto

✔️ API REST com Spring Boot
✔️ Arquitetura em camadas
✔️ JPA / Hibernate
✔️ Relacionamento entre entidades
✔️ DTOs e boas práticas
✔️ Organização de código profissional
✔️ Projeto sólido para portfólio
