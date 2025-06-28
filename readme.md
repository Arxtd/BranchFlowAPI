# 🗃️ IN DEVELOPMENT - Controle de Versão de Arquivos

Este projeto é uma API REST construída em **Java Spring Boot** com **MongoDB** que simula um sistema de controle de versão semelhante ao Git, permitindo gerenciar:

- 📁 Repositórios
- 🌿 Branches
- 📄 Arquivos
- 💾 Commits
- 📜 Histórico de alterações

---

## 📌 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.x
- Spring Data MongoDB
- MongoDB
- Lombok
- Swagger OpenAPI
- Maven

---

## 📦 Como Executar

### 📥 Pré-requisitos:

- Java 21 ou superior
- Maven 3.9+
- MongoDB (local ou Atlas)

### 🔧 Configuração `application.properties`

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/version-control-db
server.port=8080
