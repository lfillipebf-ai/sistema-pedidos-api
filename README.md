# Sistema de Pedidos API

API REST para gerenciamento de pedidos, clientes, produtos e itens de pedido.

## Tecnologias
- Java 17
- Spring Boot 3.5.6
- Spring Data JPA
- PostgreSQL
- Maven
- Docker / Docker Compose
- REST API

## Funcionalidades
- Cadastro de clientes
- Cadastro de produtos
- Controle de estoque
- Criação de pedidos com múltiplos itens
- Cálculo automático do total
- Atualização de status do pedido
- Consulta de pedidos por cliente
- Persistência em PostgreSQL

## Endpoints

### Clientes
- GET /api/customers
- POST /api/customers

### Produtos
- GET /api/products
- GET /api/products/{id}
- POST /api/products
- PUT /api/products/{id}

### Pedidos
- GET /api/orders
- GET /api/orders/{id}
- GET /api/orders/customer/{customerId}
- POST /api/orders
- PATCH /api/orders/{id}/status

## Exemplo de criação de pedido

```json
{
  "customer": {"id": 1},
  "items": [
    {"product": {"id": 1}, "quantity": 2},
    {"product": {"id": 2}, "quantity": 1}
  ]
}
```

O sistema busca os preços dos produtos no banco, calcula o total e reduz o estoque após a criação do pedido.

## Execução

```bash
docker compose up --build
```

API: `http://localhost:8080`

Projeto educacional/portfólio.

**Autor:** Luis Fillipe Backer Faria  
**GitHub:** lfillipebf-ai
