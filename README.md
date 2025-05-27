# 📅 EventManagerAPI

**EventManagerAPI** é um sistema completo de gerenciamento de eventos voltado para funcionários. Permite o cadastro de eventos, a inscrição de participantes, controle de vagas, e listagens detalhadas. Este projeto foi desenvolvido de forma colaborativa com divisão clara de responsabilidades.

---

## 🧠 Visão Geral

Este sistema permite:

- Criar eventos com informações completas
- Listar eventos disponíveis
- Atualizar ou excluir eventos
- Cadastrar participantes
- Realizar inscrição em eventos com controle de vagas
- Cancelar inscrição
- Listar participantes por evento

---

## 📌 Funcionalidades

### 📍 Eventos

- Criar evento (nome, descrição, data, local, vagas)
- Listar eventos disponíveis
- Atualizar dados do evento
- Excluir evento

### 📍 Participantes

- Cadastro de participante (nome, e-mail, telefone)
- Inscrição em evento (com verificação de vagas)
- Cancelamento de inscrição
- Listar participantes de um evento

### 📍 Relacionamentos

- Um evento pode ter vários participantes
- Um participante pode se inscrever em vários eventos

---

## 👥 Equipe & Divisão de Tarefas

### 👨‍💻 [@JoaoNascimento1802](https://github.com/JoaoNascimento1802)
- Organização do repositório no GitHub
- Documentação geral (`README.md`)
- Integração e configuração do Swagger
- Acompanhamento dos commits e progresso do projeto

### 👨‍💻 [@DevBernardo-Oliveira](https://github.com/DevBernardo-Oliveira)
- Criação dos DTOs
- Repositórios com Spring Data JPA
- Services das entidades
- Lógica de inscrição com verificação de vagas

### 👨‍💻 [@HiginoFernando](https://github.com/HiginoFernando)
- Implementação dos Controllers REST
- Criação de endpoints para todas as funcionalidades
- Testes de endpoints com Postman

### 👨‍💻 [@Thiago-P-Sampaio](https://github.com/Thiago-P-Sampaio)
- Configuração do projeto Spring Boot
- Criação das entidades `Evento` e `Participante`
- Mapeamento de relacionamento (`@ManyToMany` ou via tabela intermediária)

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Spring Web
- MySQL
- Lombok
- Swagger / OpenAPI
- Postman

---

## ⚙️ Como Executar Localmente

1. Clone o repositório:

```bash
git clone https://github.com/JoaoNascimento1802/EventManagerAPI.git
cd EventManagerAPI
```

2. Configure o banco de dados no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/eventos
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

3. Execute o projeto com Maven:

```bash
./mvnw spring-boot:run
```

4. Acesse a aplicação em `http://localhost:8080`

5. Documentação da API via Swagger:

```
http://localhost:8080/swagger-ui.html
```

---

## 🗃 Estrutura de Pacotes

```
src/
├── controller/
│   ├── EventoController.java
│   └── ParticipanteController.java
├── dto/
│   ├── EventoDTO.java
│   └── ParticipanteDTO.java
├── model/
│   ├── Evento.java
│   └── Participante.java
├── repository/
│   ├── EventoRepository.java
│   └── ParticipanteRepository.java
├── service/
│   ├── EventoService.java
│   └── ParticipanteService.java
├── EventManagerApiApplication.java
└── resources/
    └── application.properties
```

---

## 📄 Licença

Este projeto é apenas educacional e foi desenvolvido como parte de um desafio colaborativo. Não possui fins comerciais.

---

## 🤝 Contribuição

Fique à vontade para abrir issues ou pull requests para sugestões, correções ou melhorias futuras.

---
