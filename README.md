# 🏎️ F1 Management API

> **Status do Projeto:** 🏗️ Em Desenvolvimento (Implementando Lógica de Campeonato)

Esta é uma API REST completa para gerenciar o universo da Fórmula 1. O sistema permite o controle total desde as escuderias e pilotos até o registro de carros, grandes prêmios e os resultados das corridas, aplicando conceitos avançados de engenharia de software com Java e Spring Boot.

---

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA**: Para persistência de dados e relacionamentos complexos.
* **PostgreSQL**: Banco de dados relacional (via Docker).
* **Docker**: Gerenciamento de containers para o banco de dados.
* **Maven**: Gerenciador de dependências.
* **Bean Validation**: Garantia da integridade dos dados de entrada.

---

## 🏗️ Estrutura e Arquitetura

O projeto foi construído seguindo o padrão de **arquitetura em camadas** para garantir uma separação clara de responsabilidades:

* **Controller**: Gerencia as requisições HTTP e as respostas JSON.
* **Service**: Onde reside a lógica de negócio (ex: validações de número de piloto).
* **Repository**: Interface para operações de CRUD no banco de dados.
* **Model/Entity**: Representação das tabelas e seus relacionamentos (JPA).
* **DTO (Data Transfer Object)**: Utilizado para a transferência segura de dados entre cliente e servidor.

---

## 📋 Módulos e Funcionalidades

### **Equipes (Teams) & Carros (Cars)** — ✅ Concluído
- Cadastro de equipes (Nome, País, Motor).
- Gerenciamento de Carros vinculados a cada escuderia.

### **Pilotos (Drivers)** — ✅ Concluído
- Cadastro de pilotos associados a equipes específicas.
- Controle de numeração única e nacionalidade.

### **Corridas (Races) & Calendário** — ✅ Concluído
- Registro de circuitos e datas de Grandes Prêmios.
- Organização do calendário por temporadas.

### **Resultados (Results)** — ✅ Concluído
- Registro da performance de cada piloto por corrida.
- Atribuição de pontos e registro de volta mais rápida.


---

## 🚀 Como Executar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/f1-management-api.git](https://github.com/seu-usuario/f1-management-api.git)
   
