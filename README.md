# 🏎️ F1 Management API

> **Status do Projeto:** 🚧 Em Desenvolvimento

Esta é uma API REST desenvolvida para gerenciar equipes e pilotos do universo da Fórmula 1. O foco do projeto é aplicar conceitos de Relacionamento entre Entidades (**ManyToOne**) e padrões de projeto como **DTO** (Data Transfer Object) e **Service Layer**.

---

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA**
* **H2 Database**: Banco de dados em memória para testes rápidos.
* **Maven**: Gerenciador de dependências.

---

## 🛠️ Status das Funcionalidades

### **Equipes (Teams)** — ✅ Concluído
- [x] Cadastro de equipes (Nome, País, Motor).
- [x] Listagem completa.
- [x] Atualização de dados.
- [x] Deleção com tratamento de erro.

### **Pilotos (Drivers)** — 🏗️ Em progresso
- [x] Cadastro de piloto associado a uma equipe existente.
- [x] Listagem de pilotos.
- [x] Atualização de informações básicas.
- [x] Deleção de registros.
- [ ] **Próximo passo:** Validação de ID de equipe inexistente no cadastro.

---

## 📋 Como Executar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/f1-management-api.git](https://github.com/seu-usuario/f1-management-api.git)
