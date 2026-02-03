# 🏎️ F1 Management API

> **Status do Projeto:** 🚧 Em Desenvolvimento (Fase de Implementação de Regras de Negócio)

Esta é uma API REST robusta desenvolvida para gerenciar o ecossistema da Fórmula 1, permitindo o controle de equipes e pilotos. O projeto é focado em boas práticas de desenvolvimento backend, utilizando uma arquitetura organizada em camadas e padrões de projeto modernos.

---

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA**: Persistência de dados e consultas facilitadas.
* **PostgreSQL**: Banco de dados relacional para produção (via Docker).
* **H2 Database**: Utilizado para testes rápidos em memória.
* **Maven**: Gestão de dependências e build.
* **Docker**: Containerização do banco de dados.

---

## 🏗️ Arquitetura e Padrões

O projeto segue a separação de responsabilidades para garantir manutenção e escalabilidade:

* **Model/Entity**: Representação das tabelas do banco de dados (Relacionamento `@ManyToOne`).
* **Repository**: Interface de comunicação com o banco de dados.
* **Service**: Camada de lógica de negócio (onde as regras da F1 são aplicadas).
* **Controller**: Exposição dos endpoints REST da API.
* **DTO (Data Transfer Object)**: Segurança e controle no tráfego de dados entre as camadas.

---

## 📋 Status das Funcionalidades

### **Equipes (Teams)** — ✅ Concluído
- [x] Cadastro de equipes (Nome, País, Motor).
- [x] Listagem completa de escuderias.
- [x] Atualização de dados técnicos.
- [x] Deleção com tratamento de integridade.

### **Pilotos (Drivers)** — 🏗️ Em progresso
- [x] Cadastro de pilotos associados a uma equipe.
- [x] Listagem de pilotos por ordem alfabética/número.
- [x] Atualização de informações de carreira.
- [ ] **Próximo passo:** Validação para impedir números duplicados no grid.
- [ ] **Próximo passo:** Tratamento de exceção customizado para IDs inexistentes.

---

## 🚀 Como Executar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/f1-management-api.git](https://github.com/seu-usuario/f1-management-api.git)
