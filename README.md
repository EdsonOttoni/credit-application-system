# Bootcamp Api Rest Kotlin

Este projeto foi desenvolvido como parte do curso "Desenvolvimento Backend com Kotlin" da DIO, oferecido pela NTT Data.

## Sobre o Projeto
O objetivo deste projeto é simular uma empresa de empréstimo, fornecendo um sistema de análise de solicitação de crédito. A API REST foi construída utilizando Spring Boot e Kotlin 🍃.
![](https://camo.githubusercontent.com/33acbb87760a5320ad4ad00fa6a49db79fc8c9142114d93c147e270b23236d48/68747470733a2f2f692e696d6775722e636f6d2f377068796131362e706e67)

### Funcionalidades
#### Cliente (Customer):
- Cadastrar:
  - Request: firstName, lastName, cpf, income, email, password, zipCode e street
  - Response: String

- Editar cadastro:
  - Request: id, firstName, lastName, income, zipCode, street
  - Response: firstName, lastName, income, cpf, email, income, zipCode, street

- Visualizar perfil:
    - Request: id
    - Response: firstName, lastName, income, cpf, email, income, zipCode, street

- Deletar cadastro:
  - Request: id
  - Response: sem retorno

#### Solicitação de Empréstimo (Credit):
- Cadastrar:
  - Request: creditValue, dayFirstOfInstallment, numberOfInstallments e customerId
  - Response: String

- Listar todas as solicitações de empréstimo de um cliente:
  - Request: customerId
  - Response: creditCode, creditValue, numberOfInstallment

- Visualizar um empréstimo:
  - Request: customerId e creditCode
  - Response: creditCode, creditValue, numberOfInstallment, status, emailCustomer e incomeCustomer

## Autenticação JWT com Spring Security:
Implementei a autenticação usando JWT (JSON Web Token) com o Spring Security para poder criar uma sistema de login.

## Regras de Negócio para Solicitação de Empréstimo:
Implementei as seguintes regras de negócio para a solicitação de empréstimo:

- O máximo de parcelas permitido será 48.
- A data da primeira parcela deverá ser no máximo 3 meses após o dia atual.

## Como Usar
1. Clone o repositório.
2. Configure as dependências.
3. Execute a aplicação.

## Documentação Swagger
A documentação Swagger está disponível para facilitar a compreensão e interação com os endpoints da API. Você pode acessá-la através da rota: ```http://localhost:8080/swagger-ui.html```

### Melhorias Futuras
- Tratamento aprimorado de erros e logs para facilitar a depuração.
- Escrita de testes unitários e de integração para garantir a qualidade do código.
- Sinta-se à vontade para contribuir, reportar problemas ou sugerir melhorias!
