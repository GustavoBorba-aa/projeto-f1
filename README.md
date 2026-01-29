🏎️ F1 Management API (Em Desenvolvimento 🚧)
Esta é uma API REST desenvolvida para gerenciar equipes e pilotos do universo da Fórmula 1. O projeto foca em aplicar conceitos de Relacionamento entre Entidades (ManyToOne) e padrões de projeto como DTO (Data Transfer Object) e Service Layer.

🚀 Tecnologias Utilizadas
Java 17

Spring Boot 3

Spring Data JPA

H2 Database: Banco de dados em memória para testes rápidos.

Maven: Gerenciador de dependências.

🛠️ Status das Funcionalidades
Equipes (Teams) — ✅ Concluído
[x] Cadastro de equipes (Nome, País, Motor).

[x] Listagem completa.

[x] Atualização de dados.

[x] Deleção com tratamento de erro.

Pilotos (Drivers) — 🏗️ Em progresso
[x] Cadastro de piloto associado a uma equipe existente.

[x] Listagem de pilotos.

[x] Atualização de informações básicas.

[x] Deleção de registros.

[ ] Próximo passo: Validação de ID de equipe inexistente no cadastro.

📋 Como Executar o Projeto
Clonar o repositório:

Bash
git clone https://github.com/seu-usuario/f1-management-api.git
Importar no IntelliJ:

Abra o IntelliJ, vá em File > Open e selecione a pasta.

Configuração do Banco:

O projeto utiliza H2 Database. Ao rodar, o console do banco fica disponível em http://localhost:8080/h2-console.

Execução:

Execute a classe ManagementApplication.
