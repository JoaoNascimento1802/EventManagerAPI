# 📅 EventManagerAPI - Configuração e Entidades

Este branch contém a configuração inicial e as entidades principais do projeto **EventManagerAPI**, um sistema de gerenciamento de eventos para funcionários.

## 👤 Responsável

- João Nascimento – [@JoaoNascimento1802](https://github.com/JoaoNascimento1802)

---

## ✅ Tarefas Realizadas

- ✅ Criação do projeto Spring Boot
- ✅ Configuração inicial (`application.properties`, dependências, estrutura de pacotes)
- ✅ Implementação da entidade `Evento`
- ✅ Implementação da entidade `Participante`
- ✅ Mapeamento de relacionamento entre entidades (`@ManyToMany` ou via tabela intermediária)

---

## 🧰 Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Lombok
- MySQL

---

## ▶️ Como Executar

1. Configure o banco de dados MySQL no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/eventos
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

2. Execute a aplicação com:
   ```bash
   ./mvnw spring-boot:run
   ```

Ou rode a classe `EventManagerApiApplication.java` pela sua IDE.

---

## 🗂 Estrutura de Código Envolvida

- `model/Evento.java`
- `model/Participante.java`
- `resources/application.properties`

---
