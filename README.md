# Comida.com

Aplicação full stack de delivery com foco em portfólio, composta por uma API REST em Spring Boot e uma interface web em Next.js.

O projeto separa a experiência em dois fluxos:

- `Cliente`: visualizar restaurantes, abrir cardápio, selecionar produto e realizar pedidos
- `Dono`: cadastrar e editar usuários, restaurantes e produtos

## Stack

### Backend

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Bean Validation
- Lombok
- MySQL
- Swagger / Springdoc OpenAPI

### Frontend

- Next.js 16
- React 19
- TypeScript
- Axios
- CSS customizado

## Funcionalidades

- Cadastro de usuários com papel `CUSTOMER` ou `OWNER`
- Criação e edição de restaurantes
- Criação e edição de produtos
- Listagem de restaurantes e produtos
- Criação de pedidos com itens
- Separação visual entre área de cliente e área de dono
- Integração com imagens locais no frontend

## Estrutura

```text
order-management-api/
├─ src/                        # API Spring Boot
├─ order-management-frontend/  # Frontend Next.js
├─ build.gradle
└─ README.md
```

## Como rodar

### 1. Banco de dados

Crie um banco MySQL chamado `order_db`.

Configuração atual da API em [application.yaml](C:/Users/biele/Desktop/order%20management/order-management-api/src/main/resources/application.yaml):

```yaml
server:
  port: 8081

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/order_db
    username: admin
    password: pass123
  jpa:
    hibernate:
      ddl-auto: update
```

Se necessário, ajuste usuário e senha do MySQL para a sua máquina.

### 2. Rodar o backend

Na raiz do projeto:

```bash
./gradlew bootRun
```

No Windows:

```powershell
.\gradlew.bat bootRun
```

API disponível em:

- [http://localhost:8081](http://localhost:8081)
- Swagger: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

### 3. Rodar o frontend

Entre na pasta do frontend:

```bash
cd order-management-frontend
npm install
npm run dev
```

Interface disponível em:

- [http://localhost:3000](http://localhost:3000)

## Fluxos principais

### Cliente

- Escolher restaurante
- Visualizar cardápio
- Selecionar produto
- Criar pedido
- Consultar histórico de pedidos

### Dono

- Criar usuário
- Criar restaurante
- Editar restaurante
- Criar produto
- Editar produto

## Principais endpoints

### Usuários

- `GET /users`
- `POST /users`

### Restaurantes

- `GET /restaurants`
- `POST /restaurants`
- `PUT /restaurants/{id}`

### Produtos

- `GET /products`
- `POST /products`
- `PUT /products/{id}`

### Pedidos

- `GET /orders`
- `POST /orders`

## Exemplo de criação de pedido

```json
{
  "description": "Combo Biel - sem cebola",
  "userId": 1,
  "restaurantId": 1,
  "items": [
    {
      "productId": 1,
      "quantity": 1
    }
  ]
}
```

## Destaques para portfólio

- Modelagem de entidades com relacionamentos JPA
- API REST organizada em camadas (`controller`, `service`, `repository`, `dto`)
- Regras de negócio simples com `role`
- Integração entre backend e frontend
- Interface com fluxo guiado por etapas

## Próximas melhorias

- Autenticação e autorização com JWT
- Carrinho com múltiplos itens no frontend
- Upload real de imagens
- Deploy da aplicação
- Testes automatizados

## Autor

Desenvolvido por Gabriel como projeto de estudo e portfólio.
