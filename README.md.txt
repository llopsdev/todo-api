# ✅ To-Do List API

Uma API moderna para gerenciamento de tarefas, desenvolvida como projeto de estudo e portfólio.

## 📌 Sobre o Projeto
O projeto traz um CRUD completo com filtros personalizados, utilizando boas práticas de desenvolvimento.

## 🛠️ Tecnologias
- Java 17
- Spring Boot
- PostgreSQL
- Swagger / OpenAPI
- Maven

## ⚙️ Funcionalidades
- Criar tarefa
- Listar todas as tarefas
- Filtrar tarefas por status e prioridade
- Atualizar tarefa
- Deletar tarefa

## 📦 Dependências
- spring-boot-starter-data-jpa
- spring-boot-starter-validation
- spring-boot-starter-web
- springdoc-openapi-starter-webmvc-ui
- postgresql
- lombok

## 🚀 Destaques
- Arquitetura RESTful
- Código limpo e organizado em camadas
- DTOs para separação de entrada e saída
- Tratamento global de erros
- Documentação automática com Swagger

## 🧠 Conceitos Aplicados
- CRUD completo
- Boas práticas de API REST
- Tratamento de erros com GlobalExceptionHandler
- Validação de dados com Bean Validation
- Padrão de commits Conventional Commits

## 📋 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | /tasks | Lista todas as tarefas |
| GET | /tasks?status=NOT_STARTED&priority=HIGH | Lista com filtro |
| GET | /tasks/{id} | Busca tarefa por ID |
| POST | /tasks | Cria nova tarefa |
| PUT | /tasks/{id} | Atualiza tarefa |
| DELETE | /tasks/{id} | Deleta tarefa |

### Exemplo de payload — POST /tasks
```json
{
  "title": "Estudar Spring Boot",
  "description": "Completar o módulo de JPA",
  "status": "NOT_STARTED",
  "priority": "HIGH",
  "dueDate": "2025-12-31T23:59:59"
}
```

## 🖥️ Como rodar localmente

### Pré-requisitos
- Java 17+
- PostgreSQL
- Maven

### Variáveis de ambiente
Crie um arquivo `.env` na raiz com:

...
DB_USER=seu_usuario
DB_PASS=sua_senha
...

### Executando
```bash
git clone https://github.com/llopsdev/todo-api.git
cd todo-api
./mvnw spring-boot:run
```

## 📚 Documentação
Após subir o projeto, acesse a documentação completa em:

http://localhost:8080/swagger-ui/index.html