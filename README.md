# 🏎️ F1 Management API

> **Status do Projeto:** 🏗️ Em Desenvolvimento (Implementando Lógica de Campeonato e Integração de Endpoints)

Esta é uma API REST desenvolvida para gerenciar o ecossistema da Fórmula 1. O sistema organiza equipes, pilotos, carros e calendários de corridas, utilizando uma arquitetura robusta para garantir a integridade dos dados e a escalabilidade do sistema.

---

## 🛠️ Tecnologias e Ferramentas

* **Java 23**: Utilizando as funcionalidades mais recentes da linguagem.
* **Spring Boot 3.4**: Framework base para a criação da aplicação e inversão de controle.
* **Spring Data JPA**: Mapeamento objeto-relacional (ORM) para persistência de dados.
* **PostgreSQL**: Banco de dados relacional robusto para armazenamento de dados.
* **Lombok**: Utilizado em **Models** e **DTOs** para eliminar código boilerplate (Getters, Setters).
* **Bean Validation**: Validações rigorosas de entrada (ex: datas futuras, campos obrigatórios).
* **Maven**: Gerenciador de dependências e build do projeto.
* **Docker & Docker Compose**: Gerenciamento de containers para a aplicação e banco de dados.
* **JUnit 5 & Mockito**: Ferramentas para testes unitários e de integração.

---

## 🏗️ Arquitetura do Sistema

O projeto utiliza a **Arquitetura em Camadas** e o padrão **DTO**, visando a segurança e a separação de responsabilidades:

* **Controller**: Porta de entrada da API. Recebe as requisições e utiliza `@Valid` para disparar as validações dos DTOs.
* **Service**: Camada intermediária que contém a lógica de negócio e regras de validação antes de chegar ao banco.
* **Repository**: Camada de persistência que utiliza *Derived Queries* e consultas personalizadas.
* **Model/Entity**: Entidades JPA (`Team`, `Driver`, `Car`, `Races`, `Results`) que definem o esquema do banco de dados.
* **DTO (Data Transfer Object)**: Classes de entrada que garantem a segurança dos dados trafegados.
* **Infra (Tratador de Erros)**: Centralização do tratamento de exceções para retornos JSON amigáveis.

---

## 📊 Modelo de Dados e Relacionamentos

* **Teams (1) ↔ (N) Drivers**: Um time possui vários pilotos.
* **Teams (1) ↔ (1) Car**: Um time gerencia um modelo de carro específico.
* **Races ↔ Results**: Gerenciamento de resultados vinculados a Grandes Prêmios.

---

## 🏁 Funcionalidades Atuais

* [x] **Gerenciamento de Equipes**: Cadastro completo com validações de país e motor.
* [x] **Controle de Pilotos**: Vinculação obrigatória a uma equipe e controle de numeração única.
* [x] **Registro de Veículos**: Mapeamento One-to-One entre carro e escuderia.
* [x] **Calendário de Corridas**: Cadastro de circuitos e datas (validando datas passadas).
* [x] **Tratamento de Exceções**: Retornos de erro 400 e 404 padronizados.

---

## 🚀 Como Executar o Projeto

### 1. Clonar o repositório
```bash
git clone [https://github.com/seu-usuario/f1-management-api.git](https://github.com/seu-usuario/f1-management-api.git)
cd f1-management-api

2. Executar via Docker (Recomendado)
Certifique-se de que o Docker está em execução. O comando abaixo gera o pacote, constrói a imagem e sobe os serviços:

Bash
mvn clean package -DskipTests
docker-compose up --build
A API estará disponível em: http://localhost:8080

3. Executar via Maven (Local)
Bash
mvn spring-boot:run

🧪 Testes
Para validar as regras de negócio e garantir que os controllers estão respondendo corretamente:

Bash
mvn test

📮 Postman Collection
Para testar os endpoints de forma rápida e prática:

Localize o arquivo em: /docs/Projeto F1.postman_collection.json.

No Postman, clique em Import e selecione o arquivo.

Utilize os exemplos prontos para realizar os requests.

Exemplo de corpo JSON para o endpoint /teams:

JSON
{
  "name": "Red Bull Racing",
  "country": "Áustria",
  "engine": "Honda",
  "foundationYear": 2005,
  "sedeDaEquipe": "Milton Keynes",
  "chefeDeEquipe": "Christian Horner"
}
Desenvolvido por [Gustavo Borba]
