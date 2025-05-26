# 📅 EventManagerAPI - Lógica de Negócio e Serviços

Este branch contém a implementação da lógica de negócio, incluindo DTOs, Repositórios e Serviços das entidades do projeto **EventManagerAPI**.

## 👤 Responsável

- Bernardo Oliveira – [@DevBernardo-Oliveira](https://github.com/DevBernardo-Oliveira)

---

## ✅ Tarefas Realizadas

- ✅ Criação dos `DTOs` para `Evento` e `Participante`
- ✅ Criação dos `Repository` com Spring Data JPA
- ✅ Implementação dos `Service` para gerenciamento de eventos e participantes
- ✅ Lógica de inscrição em evento com verificação de vagas
- ✅ Lógica para cancelamento de inscrição
- ✅ Métodos para listar participantes por evento

---

## 🧰 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Lombok
- MySQL

---

## ▶️ Como Executar

1. Certifique-se de que as entidades estão criadas no projeto.
2. Execute o projeto com:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## 📄 Estrutura de Código Envolvida

- `dto/EventoDTO.java`
- `dto/ParticipanteDTO.java`
- `repository/EventoRepository.java`
- `repository/ParticipanteRepository.java`
- `service/EventoService.java`
- `service/ParticipanteService.java`

---
