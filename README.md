# 📅 EventManagerAPI

Repositório do sistema **EventManagerAPI**, um projeto desenvolvido para gerenciar **eventos corporativos de funcionários**, com funcionalidades completas de CRUD para eventos e controle de inscrições de participantes.

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
   ```bash
   git clone https://github.com/JoaoNascimento1802/EventManagerAPI.git
   cd EventManagerAPI
   ```

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
