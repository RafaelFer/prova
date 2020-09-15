"# prova" 

Para rodar o projeto por favor seguir os seguintes comandos na raiz do projeto

mvn clean install

mvn spring-boot:run

Link do Swagger
http://localhost:8080/swagger-ui.html


Para acessar o banco de dados em memoria
http://localhost:8080/h2-console 



Para utilizar API bloqueadas por favor gerar um token de acessos em 
localhost:8080/auth/
{
	"email":"rafael22fs@gmail.com",
	"pass":"123456"
}

é possivel inserir usuarios tbm pelo data.sql


#Cadastrando um pedido
http://localhost:8080/request/
{
	"description":"TEste",
	"products":[1,2],
	"client": 1
}

