"# prova" 

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

