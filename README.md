# viavarejo_mongodb
ViaVarejo Projeto API CRUD em Spring Boot com mongodb 4.4.3 ultima versao e Docker
<br>Dica: testar no link de CI de action de github(https://github.com/ooleon/viavarejo_mongodb/actions)

##1. EndsPoints Clientes

Indicacao CRUD    | Comando Endpoint
------------- | -------------
<strong>buscar todos</strong><br> _Na <strong>URL</strong> do postman pode retornar tudas as fila de clientes_ | <strong>GET</strong>http://localhost:8095/rest/clientes/all
<br>_Para testar a API pode usar o seguinte comando_ 			|		`mvn test -q -B -Dtest=ClientesServiceTests test`
_A solucao está na clase_		|		`./src/main/java/main/localhost/mongodb/springbootmongodbexample/service/ClientesServiceTests.java`<br><br>
<strong>buscar por id do documento de Cliente</strong><br> _Na <strong>URL</strong> do postman pode retornar a fila de cliente que bate com o id indicado | <strong>GET</strong>http://localhost:8095/rest/clientes/id/{id}
<br>_Para testar a API pode usar o seguinte comando_ 			|		`mvn test -q -B -Dtest=ClientesServiceTests test`
_A solucao está na clase_ ClientesService.java		|		`./src/main/java/main/localhost/mongodb/springbootmongodbexample/service/ClientesServiceTests.java`<br><br>


##2. EndsPoints Apolices

Indicacao CRUD    | Comando Endpoint
------------- | -------------
<strong>buscar todos</strong><br> _Na <strong>URL</strong> do postman pode retornar tudas as fila de apolices_ | <strong>GET</strong>http://localhost:8095/rest/apolices/all
<br>_Para testar a API pode usar o seguinte comando_ 			|		`mvn test -q -B -Dtest=ApolicesServiceTests test`
_A solucao está na clase_		|		`./src/main/java/main/localhost/mongodb/springbootmongodbexample/service/ApolicesService.java`<br><br>
<strong>buscar por numero de apolice</strong><br> _Na <strong>URL</strong> do postman pode retornar a fila de apolices por numero_ | <strong>GET</strong>http://localhost:8095/rest/apolices/numero/{numero}
<br>_Para testar a API pode usar o seguinte comando_ 			|		`mvn test -q -B -Dtest=ApolicesServiceTests test`
_A solucao está na clase_		|		`./src/main/java/main/localhost/mongodb/springbootmongodbexample/service/ApolicesService.java`<br><br>
<strong>buscar apolices por numero de cpf</strong><br> _Na <strong>URL</strong> do postman pode retornar uma lista de apolices por numero do documento do cliente_ |  <strong>GET</strong>http://localhost:8095/rest/apolices/cpf/{numeroCpf}
<br>_Para testar a API pode usar o seguinte comando_ 			|		`mvn test -q -B -Dtest=ApolicesServiceTests test`
_A solucao está na clase_		|		`./src/main/java/main/localhost/mongodb/springbootmongodbexample/service/ApolicesService.java`<br><br>
<strong>Salvar apolice com numero aleatorio</strong><br> _Na <strong>URL</strong> do postman pode usar o metodo post e escrever no corpo (body) a estrutura do apolice com numero 0, o sistema asignará um numero aleatorio_ | <strong>POST</strong>http://localhost:8095/rest/apolices/salvarAleatorio
<br>_Para testar a API pode usar o seguinte comando_ 			|		`mvn test -q -B -Dtest=ApolicesServiceTests test`
_A solucao está na clase_		|		`./src/main/java/main/localhost/mongodb/springbootmongodbexample/service/ApolicesService.java`<br><br>
<strong>Salvar apolice</strong><br> _Na <strong>URL</strong> do postman pode usar o metodo post e escrever no corpo (body) a estrutura do apolice _ | <strong>POST</strong>http://localhost:8095/rest/apolices/salvar
<br>_Para testar a API pode usar o seguinte comando_ 			|		`mvn test -q -B -Dtest=ApolicesServiceTests test`
_A solucao está na clase_		|		`./src/main/java/main/localhost/mongodb/springbootmongodbexample/service/ApolicesService.java`<br><br>
<strong>buscar apolices por numero de cpf</strong><br> _Na <strong>URL</strong> do postman pode retornar uma lista de apolices por numero do documento do cliente_ | http://localhost:8095/rest/apolices/cpf/{numeroCpf}
<br>_Para testar a API pode usar o seguinte comando_ 			|		`mvn test -q -B -Dtest=ApolicesServiceTests test`
_A solucao está na clase_		|		`./src/main/java/main/localhost/mongodb/springbootmongodbexample/service/ApolicesService.java`


