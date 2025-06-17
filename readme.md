# 📘 Projeto Spring Boot - Sistema de Questionário com JWT e Swagger

Este projeto é uma API REST para gerenciamento de questões e respostas com autenticação via JWT. Inclui documentação via Swagger e acesso ao banco de dados em memória (H2).

## 👥 Integrantes do Grupo
- Gustavo Vegi / RM550188
- Pedro Henrique Silva de Morais / RM98804
- Lucas Rodrigues Delfino / RM550196
- Luisa Cristina dos Santos Neves / RM551889
- Gabriel Aparecido Cassalho Xavier / RM99794

---

## 🔧 Tecnologias utilizadas

- Java 17
- Spring Boot 3.5.0
- Spring Security
- Spring Data JPA
- H2 Database
- JWT (JSON Web Token)
- Swagger (springdoc-openapi)

---

## 🚀 Como rodar o projeto

### 1. Clone o repositório

```bash
git clone <url-do-repositorio>
cd demo
```

### 2. Compile e rode a aplicação com Maven

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

### 3. Acesse o H2 Console

- URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: *(deixe em branco)*

### 4. Inserir usuário para testes

Execute no console do H2:

```sql
INSERT INTO usuario (id, email, senha) 
VALUES (1, 'teste@exemplo.com', '$2a$10$LIbFEyxJ7/Ii36siEbHRLO7Zqt2o8M/dcYjFZFw5yYZ6VnE7i8Sx2');
```

> 🔐 A senha correspondente é: `123456`

### 5. Autenticar

Faça um `POST` para:

```
POST /api/auth/login
```

Com o seguinte body JSON:

```json
{
  "email": "teste@exemplo.com",
  "senha": "123456"
}
```

O retorno será um `token JWT` para ser usado nas requisições protegidas.

### 6. Criar Perguntas e Respostas

Após se autenticar e receber um token JWT na resposta da requisição.

Envie esse token nas próximas rotas na header com o parâmetro Authorization.

O ideal, para o bom funcionamento da aplicação é começar setando algumas perguntas
e repostas.

Para isso faça uma requisição `POST` para: 

```
POST /api/questoes
```
E no corpo da requisição, segue alguns exemplos que pode enviar:

```json
{
  "enunciado": "Como você reagiria se seus investimentos sofressem uma queda de 10% em um mês?",
  "alternativas": [
    { "texto": "Venderia imediatamente para evitar mais perdas", "perfil": "leve" },
    { "texto": "Esperaria um tempo para ver se recupera", "perfil": "moderado" },
    { "texto": "Aproveitaria para investir mais, buscando retorno no longo prazo", "perfil": "agressivo" }
  ]
}
```
```json
{
  "enunciado": "Qual seu objetivo principal com os investimentos?",
  "alternativas": [
    { "texto": "Preservar meu capital com segurança", "perfil": "leve" },
    { "texto": "Ter crescimento consistente, mesmo com algumas oscilações", "perfil": "moderado" },
    { "texto": "Maximizar o retorno, mesmo assumindo altos riscos", "perfil": "agressivo" }
  ]
}
```
```json
{
  "enunciado": "Por quanto tempo você pretende manter seus investimentos?",
  "alternativas": [
    { "texto": "Menos de 1 ano", "perfil": "leve" },
    { "texto": "De 1 a 5 anos", "perfil": "moderado" },
    { "texto": "Mais de 5 anos", "perfil": "agressivo" }
  ]
}
```
---

## 📚 Documentação Swagger

Acesse em:

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- ou
- [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)