# Projeto Spring Boot - API REST de Gerenciamento de Comidas


## Descrição

Este projeto é uma API REST desenvolvida com Spring Boot para fins de **aprendizado e prática** dos fundamentos do ecossistema Spring Boot. 
Ele foi criado inicialmente como um exemplo básico para consolidar os conhecimentos adquiridos no framework Spring Boot, mas ao longo do desenvolvimento foram adicionados diversos recursos comuns em aplicações reais, como:

* Criação de APIs REST com Spring Boot.

* Boas práticas de tratamento de erros.

- Boas práticas de tratamento global de exceções.

- Documentação automática da API.

- Sistema de logs estruturado.

- Logs de acesso para monitoramento.

A aplicação permite o gerenciamento (CRUD) de uma lista de comidas, com persistência em banco de dados e documentação interativa.

---

## Objetivo do projeto

O objetivo principal do projeto é explorar boas práticas no desenvolvimento de APIs REST no ecossistema Spring Boot.

Ao longo do desenvolvimento, o projeto evoluiu de um exemplo básico até a implementação de **vários recursos comuns em ambientes reais de backend**.


## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.3.5**
* **Spring Data JPA**: Para persistência de dados
* **MySQL**: Banco de dados relacional
* **Hibernate**: Implementação do JPA
* **Validation**: Validação de dados de entrada com Bean Validation
* **Lombok**: Redução de código boilerplate
* **SpringDoc OpenAPI (Swagger)**: Documentação automatizada da API
* **Logback**: Sistema de logs customizado com rotação de arquivos
* **Maven**: Gerenciamento de dependências.

---

## 🛠️ Estrutura do Projeto

O projeto segue uma arquitetura em camadas bem definida:

* **Models**: Entidade `Comida` que representa a tabela no banco de dados.
* **Repository**: Interface `ComidasRepository` que herda do `JpaRepository`.
* **Services**: Camada de lógica de negócio `ComidasService`.
* **Controllers**: Camada de exposição dos endpoints REST `ComidasController`.
* **Config**: Configurações de documentação (Swagger) e interceptadores.
* **GerenciamentoErros**: Tratamento global de exceções para retornos padronizados.
* **Logging**: Interceptador para registro de acessos e performance da API.
* **Docs**: Customização de erros por campos inválidos.
* **DTOs**: Representa os parâmetros que contém a mensagem de erro mostrada ao usuário.

---

## Estrutura do Projeto

```
src/main/java/org/ProjetoSpringBoot
│
├── Config
│    └── WebConfig.java
│
├── Controller
│    └── ComidasController.java
│
├── Models
│    └── Comida.java
│
├───DTOs
│    └── RespostaError.java
│
├── Repository
│     └── ComidaRepository.java
│
├── Services
│     └── ComidasService.java
│
├─── Docs
│     └── ProblemResponse.java
│
├── Logging
│     └── InterceptorLoggingApiComidas.java
│
├── GerenciamentoErros
│   ├── ManipuladorExcecoesGlobais.java
│   └── RecursosNaoEncontradosException.java
│
└── PrimeiroProjetoSpringBootApplication.java

```

---

## 📋 Endpoints Principais

A API permite realizar operações CRUD sobre a entidade do tipo Comida.

A API está configurada no prefixo `/api/v1/comidas`:

**Endpoints disponíveis**

|   Método   |         Endpoint       |                 Descrição                  |
| ---------- | ---------------------- | ------------------------------------------ |
|  **GET**   |   `/api/v1/comidas`    |     Lista todas as comidas cadastradas.    |
|  **GET**   | `/api/v1/comidas/{id}` |    Busca uma comida específica pelo ID.    |
|  **POST**  |    `/api/v1/comidas`   |         Cadastra uma nova comida.          |
|  **PUT**   | `/api/v1/comidas/{id}` | Atualiza os dados de uma comida existente. |
| **DELETE** | `/api/v1/comidas/{id}` |       Remove uma comida do sistema.        |

---

## Tratamento Global de Erros

A API utiliza **`@RestControllerAdvice`** para tratar exceções globalmente.

As respostas seguem o padrão **RFC 7807 (`ProblemDetail`)**, contendo informações como:

* status HTTP
* título do erro
* descrição
* timestamp
* método HTTP
* endpoint acessado

Exemplo de resposta de erro:

```json
{
  "type": "about:blank",
  "title": "Recurso não encontrado",
  "status": 404,
  "detail": "Comida com id 2 não encontrada",
  "instance": "/api/v1/comidas/2",
  "timestamp": "08/03/2026 18:55:39",
  "method": "GET"
}

```

---

## 📖 Documentação (Swagger)

A API é documentada automaticamente utilizando **SpringDoc OpenAPI**.


### Acesso à documentação

Com a aplicação rodando, você pode acessar a interface interativa do Swagger para testar os endpoints em:

#### Swagger
```
http://localhost:8080/swagger-ui/index.html
```

#### OpenAPI JSON

```
http://localhost:8080/v3/api-docs
```

---

## ⚙️ Como Executar?

1. **Pré-requisitos**:
* Java 21 instalado.
* Maven.
* MySQL instalado e rodando.


2. **Clonar o repositório**:

```bash
git clone <repo-url>
```

3. **Acessar o diretório do projeto**:

```bash
cd projeto-springboot
```

4. **Configuração do Banco**:
* Crie um banco de dados chamado `PrimeiroProjetoSpringBoot`.
* Ajuste as credenciais no arquivo `src/main/resources/application.properties` se necessário.


5. **Execução**:
```bash
./mvnw spring-boot:run

```

ou

```bash
mvnw spring-boot:run

```

Ou executar a classe:

```
PrimeiroProjetoSpringBootApplication.java
```

---

## 📝 Logs

O sistema gera logs automaticamente na pasta `logs/`, utilizando a dependência **Logback** com rotação automática de arquivos, seguindo a seguinte estrutura:

```
logs/
├── app.log
├── error.log
└── api-access.log
```

* `app.log`: Contém os logs gerais do sistema.
* `error.log`: Registra apenas eventos de nível ERROR como exceções e erros internos da aplicação.
* `api-access.log`: Registra o IP do cliente, método HTTP requisitado, endpoint acessado, status da resposta e tempo de resposta de cada requisição.

**Exemplo de log:**

```
2026-03-08 15:12:21 IP=192.168.1.15 METHOD=GET URI=/api/v1/comidas STATUS=200 TIME=34ms
```

**Esses logs permitem:**

* Auditoria de requisições
* Análise de performance
* Identificação de comportamento suspeito

---

## Possíveis Melhorias Futuras

Algumas melhorias que poderiam ser adicionadas ao projeto:

* autenticação com **Spring Security**
* rate limiting
* métricas com **Spring Boot Actuator + Prometheus**
* logs estruturados em **JSON**
* testes automatizados
* integração com ferramentas de observabilidade

---

## Dados do autor

**🧑🏽‍💻 Autor:** Karli Munoz
**📧 Contato:** jesusvzlanz@gmail.com ou karli.manzano@estudantes.ifc.edu.br

---

**Licença:** MIT.  Veja o arquivo `LICENSE` para mais detalhes.

---

<p align="center">
  <em>Desenvolvido com ❤️ por kamuz-01</em><br>
  <strong><em>Todos os direitos reservados © 2026</em></strong>
</p>
