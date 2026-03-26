# 🏎️ F1 Management API

Esta é uma API REST desenvolvida para gerenciar o ecossistema da Fórmula 1. O sistema organiza equipes, pilotos, carros e calendários de corridas, utilizando uma arquitetura robusta para garantir a integridade dos dados e a escalabilidade do sistema.

---

## 🛠️ Tecnologias e Ferramentas

* **Java 21/23**: Utilizando as funcionalidades mais recentes da linguagem.
* **Spring Boot 3.4**: Framework base para a aplicação e inversão de controle.
* **Spring Data JPA**: Mapeamento objeto-relacional (ORM) para persistência de dados.
* **PostgreSQL**: Banco de dados relacional para armazenamento persistente.
* **Lombok**: Utilizado em **Models** e **DTOs** para eliminar código boilerplate.
* **Bean Validation**: Validações de entrada (ex: `@NotNull`, `@NotBlank`).
* **Maven**: Gerenciador de dependências e build do projeto.
* **Docker & Docker Compose**: Gerenciamento de containers para a aplicação e banco de dados.

---

## 🏗️ Arquitetura do Sistema

O projeto utiliza a **Arquitetura em Camadas** e o padrão **DTO (Data Transfer Object)**, visando a separação de responsabilidades:

* **Controller**: Porta de entrada da API. Gerencia os endpoints e valida as entradas.
* **Service**: Camada de regras de negócio e comunicação com o repositório.
* **Repository**: Interface de comunicação direta com o banco de dados via JPA.
* **Model/Entity**: Entidades que representam as tabelas no banco de dados (`Team`, `Driver`, etc).
* **DTO**: Garante a segurança e flexibilidade no tráfego de dados entre cliente e servidor.

---

## 🏁 Funcionalidades Atuais

* [x] **Gerenciamento de Equipes**: Cadastro completo com validações (País, Motor, Sede, Chefe).
* [x] **Persistência de Dados**: Integração total com PostgreSQL.
* [x] **Tratamento de Erros**: Retornos de erro 400 e 404 padronizados via `TratadorDeErros`.
* [ ] **Controle de Pilotos**: Vinculação a equipes (Em desenvolvimento).
* [ ] **Registro de Veículos**: Mapeamento de carros por escuderia (Em desenvolvimento).

---

## 🚀 Como Executar o Projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/GustavoBorba-aa/projeto-f1.git
cd projeto-f1
```

---

### 2. Executar via Docker (Recomendado)

Certifique-se de que o Docker está em execução e execute:

```bash
docker-compose up --build
```

A API estará disponível em:  
👉 http://localhost:8080

---

### 3. Executar via Maven (Local)

Caso prefira rodar localmente (necessita PostgreSQL configurado no `application.properties`):

```bash
mvn spring-boot:run
```

---

## 📮 Postman Collection

Para facilitar os testes, utilize a collection do Postman incluída no repositório.

### 📂 Localização

O arquivo está localizado em:

```
./docs/Projeto F1.postman_collection.json
```

---

### 🚀 Como importar

1. Abra o **Postman**
2. Clique em **Import**
3. Arraste o arquivo:
   ```
   Projeto F1.postman_collection.json
   ```
4. Clique em **Import**

---

### ▶️ Como usar

1. A collection aparecerá no menu lateral
2. Selecione um endpoint (ex: `POST /teams`)
3. Clique em **Send**

⚠️ Certifique-se de que a API está rodando em:
```
http://localhost:8080
```

---

### 📌 Exemplo de JSON (POST /teams)

```json
{
  "name": "Red Bull Racing",
  "country": "Áustria",
  "engine": "Honda",
  "foundationYear": 2005,
  "sedeDaEquipe": "Milton Keynes",
  "chefeDeEquipe": "Christian Horner"
}
```

---

## 👨‍💻 Autor

Desenvolvido por **Gustavo Borba**
