# Projeto Back-end Usuarios

## Para executar: 
* Executar ddl.sql no mysql
* Na raiz da pasta api executar - mvn spring-boot:run

## Caso tenha algum erro envolvendo versão de Java:
* mvn clean

## Rotas Disponíveis

### Listar todos os usuários
* **Método:** GET
* **Endpoint:** `localhost:8080/usuario`

### Listar usuário por ID
* **Método:** GET
* **Endpoint:** `localhost:8080/usuario/{id}`

### Criar um novo usuário
* **Método:** POST
* **Endpoint:** `localhost:8080/usuario`
* **Corpo da Requisição:**
```json
{
	"username": "Teste",
	"senha": "123",
	"nome": "Teste",
	"email": "Teste@gmail.com",
	"role": "admin"
}
```

### Atualizar usuário
* **Método:** PUT
* **Endpoint:** `localhost:8080/usuario/{id}`
* **Corpo da Requisição:**
```json
{
	"username": "Teste",
	"senha": "123",
	"nome": "Teste",
	"email": "Teste@gmail.com",
	"role": "admin"
}
```

### Deletar usuário
* **Método:** DELETE
* **Endpoint:** `localhost:8080/usuario/{id}`

### Login
* **Método:** POST
* **Endpoint:** `localhost:8080/usuario/login`
* **Corpo da Requisição:**
```json
{
	"username": "Teste",
	"senha": "123"
	
}
```
