<<<<<<< HEAD
# 📅 EventManagerAPI

Repositório do sistema **EventManagerAPI**, um projeto desenvolvido para gerenciar **eventos corporativos **, com funcionalidades completas de CRUD para eventos e controle de inscrições de eventos.

🔗 Acesse o repositório: [github.com/JoaoNascimento1802/EventManagerAPI](https://github.com/JoaoNascimento1802/EventManagerAPI)

---

## 🚀 Funcionalidades Mínimas

### 📌 Eventos
- Criar evento (nome, descrição, data, local, vagas)
- Listar eventos disponíveis
- Atualizar dados do evento
- Excluir evento

### 👥 Participantes
- Cadastro de participante (nome, e-mail, telefone)
- Inscrição em evento (com verificação de vagas disponíveis)
- Cancelamento de inscrição
- Listar participantes de um evento

### 🔄 Relacionamentos
- Um evento pode ter vários participantes
- Um participante pode se inscrever em vários eventos

---

## 🧠 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger (Documentação automática)
- Postman (Testes)
- Git & GitHub

---

## 📂 Estrutura do Projeto

O projeto segue a estrutura padrão do Spring Boot, organizada da seguinte forma:

```
src/
 └── main/
     ├── java/
     │   └── api.manager.senai/
     │       └── 
     │           ├── controller/
     │           ├── dto/
     │           ├── entities/
     │           ├── repository/
     │           └── service/
     └── resources/
         ├── application.properties
         └── ...
```

---

## ⚙️ Como Executar o Projeto

1. **Clone o repositório**
=======
# EventManagerAPI

**EventManagerAPI** é uma API REST desenvolvida em Java com Spring Boot para gerenciar eventos e participantes. O sistema permite criar, ler, atualizar e deletar (CRUD) eventos e usuários, além de realizar inscrições e cancelamentos de participação em eventos e listar os participantes de cada evento. A arquitetura do projeto segue boas práticas, utilizando camadas de controllers, services, repositories, DTOs e entidades JPA, com testes de funcionalidade realizados via Postman.

## Tecnologias Utilizadas

* **Java 21 (OpenJDK 21)** – versão LTS do Java (suportada pelo Spring Boot 3.2).
* **Spring Boot 3.2+** – framework para APIs REST, compatível com Java 21.
* **Spring Data JPA (Hibernate)** – para persistência de dados usando JPA.
* **MySQL 8.x** – banco de dados relacional (versão 8.0 ou superior).
* **Maven** – gerenciador de dependências e build do projeto.
* **Postman** (ou Insomnia) – ferramenta para testar e documentar chamadas HTTP.

## Requisitos de Ambiente

Para executar o projeto localmente, são necessários:

* **Java 21 (JDK 21)** – instalar e configurar a variável `JAVA_HOME`.
* **Maven 3.x** – (pode usar o Maven Wrapper incluso).
* **MySQL 8.x** – servidor MySQL rodando localmente (padrão na porta 3306).
* **Ferramenta de API** – Postman/Insomnia para testes das requisições.

## Instalação e Execução

1. **Clonar o repositório** do projeto:

>>>>>>> dev_JoaoE
   ```bash
   git clone https://github.com/JoaoNascimento1802/EventManagerAPI.git
   cd EventManagerAPI
   ```

<<<<<<< HEAD
2. **Configure o banco de dados** no arquivo `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/eventos
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. **Compile e execute o projeto**
   - Via terminal:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Ou execute a classe `EventManagerApiApplication.java` na IDE (IntelliJ, VSCode ou Eclipse)

4. **Acesse a documentação Swagger**:
   - Após iniciar o projeto, abra: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 👨‍💻 Divisão de Tarefas

### @Thiago-P-Sampaio
- Configuração inicial do projeto
- Criação das entidades `Evento` e `Participante`
- Definição dos relacionamentos (`@ManyToMany` ou tabela intermediária)

### @DevBernardo-Oliveira
- Criação dos `Repository`, `DTO` e `Service` das entidades
- Implementação da lógica de inscrição com controle de limite de vagas

### @HiginoFernando
- Implementação dos `Controllers` e endpoints REST
- Testes de funcionalidades com o Postman

### @JoaoNascimento1802
- Organização do repositório no GitHub
- Documentação com `README.md` e Swagger
- Acompanhamento de commits e divisão clara das tarefas

---

## ✅ Status

✔️ Projeto em desenvolvimento com todas as funcionalidades mínimas implementadas.

---

## 📝 Licença

Este projeto está sob a  [LICENÇA](LICENSE.md). Sinta-se à vontade para usar, modificar e distribuir.
=======
2. **Configurar o banco de dados**: no arquivo `src/main/resources/application.properties`, defina a URL, usuário e senha do MySQL. Por exemplo:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/event_manager_db
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

   É importante criar o banco de dados antes de executar a aplicação. Por exemplo, usando o cliente MySQL ou Workbench:

   ```sql
   CREATE DATABASE event_manager_db;
   ```

   Estas configurações garantem que o Spring Boot conecte ao banco correto.

3. **Rodar o projeto**: use o Maven para compilar e executar a aplicação:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   Ou execute diretamente a classe principal com sua IDE. Por padrão, a API ficará disponível em `http://localhost:8080`.

## Testando os Endpoints

Para testar a API, utilize o Postman ou outra ferramenta de requisições HTTP, ou use comandos `curl` no terminal. Abaixo estão exemplos genéricos (ajuste as rotas conforme a implementação):

* **Listar eventos** (GET):

  ```bash
  curl -X GET http://localhost:8080/api/events
  ```
* **Criar um evento** (POST):

  ```bash
  curl -X POST http://localhost:8080/api/events \
    -H "Content-Type: application/json" \
    -d '{
      "name": "Nome do Evento",
      "location": "Local do evento",
      "date": "2025-10-12"
    }'
  ```
* **Criar um usuário** (POST):

  ```bash
  curl -X POST http://localhost:8080/api/users \
    -H "Content-Type: application/json" \
    -d '{
      "name": "João Silva",
      "email": "joao@example.com"
    }'
  ```
* **Inscrever usuário em evento** (POST):

  ```bash
  curl -X POST http://localhost:8080/api/events/1/participants \
    -H "Content-Type: application/json" \
    -d '{"userId": 1}'
  ```
* **Cancelar inscrição** (DELETE):

  ```bash
  curl -X DELETE http://localhost:8080/api/events/1/participants/1
  ```
* **Listar participantes de um evento** (GET):

  ```bash
  curl -X GET http://localhost:8080/api/events/1/participants
  ```

Cada endpoint pode variar de acordo com o mapeamento definido nos controllers (`EventController`, `UserController`, etc.). Use o Postman para verificar os parâmetros e corpo (JSON) esperado em cada rota.

## Estrutura de Pastas

O projeto segue a convenção Maven padrão. A seguir, um resumo simplificado da estrutura de diretórios:

```
EventManagerAPI/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/eventmanager/api (pacote principal)
│   │   │       ├── controllers/      (rotas da API)
│   │   │       ├── entities/         (entidades JPA)
│   │   │       ├── dto/              (objetos de transferência de dados)
│   │   │       ├── repositories/     (interfaces de acesso a dados)
│   │   │       └── services/         (lógica de negócio)
│   │   └── resources/
│   │       └── application.properties (configurações, ex.: banco de dados)
│   └── test/
│       └── java/                     (testes automatizados)
├── pom.xml
└── README.md
```

Cada pacote agrupa componentes da aplicação: *controllers* para endpoints REST, *services* para regras de negócio, *repositories* para acesso ao banco, *entities* para mapeamento das tabelas e *dto* para models de entrada/saída.


**Referências:** Informações sobre compatibilidade Java 21 e Spring Boot, e MySQL 8 com Java; configuração de datasource em Spring Boot.
>>>>>>> dev_JoaoE
