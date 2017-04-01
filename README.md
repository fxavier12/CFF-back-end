


# Core da aplicacao 		
 -    O projeto pode ser aberto pelo netbeans 		
 -    Os arquivos java estao na pasta src/main/java		
#   		

- O arquivo ``pom.xml`` define as dependencias(bibliotecas) do projeto.	
     [**Neste Repositorio** ](https://mvnrepository.com/) do maven podem ser encontrados os		
     codigos das bibliotecas. 		
     Para adicionar uma nova biblioteca inclua o codigo <dependency></dependency> e		
     inclua na seccao <dependencies> do arquivo ``pom.xml``		
- O arquivo ``main.java`` e o reponsavel por receber a requisicao do navegador e enviar a resposta html ou String 

## Executando Localmente		
Entre na pasta do projeto pelo terminal :		
- selecione a branch exemplo1
```sh		
$ git checkout exemplo1
```
- Compile 
```sh		
$ mvn clean install				
```
- Start 
```sh		
$ heroku local web				
```
## Testando
Abra o navegador e acesse
- [INDEX](http://localhost:5000).
- [STRING](http://localhost:5000/hello).
