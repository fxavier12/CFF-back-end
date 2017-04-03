# Back-end Controle Financeiro Facil

Web Service REST em java utilizando Maven 
Hospedado  no Heroku 
 
## Sobre a aplicacao

O Web Service tem como objetivo fornecer a api para desenvolvimento do fron-end
do projeto Controle Financeiro Facil da disciplina de oficina de Integracao

## Site

A aplicacao em desenvolcimento esta online no dominio 

[cffbackend.herokuapp.com](https://cffbackend.herokuapp.com)



## Hambiente de desenvolvimento 
Para rodar a aplicacao voce vai precisar :

- java JDK 
- Maven 
- Heroku cli 

para detelhes sobre a instacao leia o arquivo [Instalacao](https://github.com/fxavier12/CFF-back-end/blob/master/instalacao.md)


## Clonando o Projeto
Para baixar o projeto para seu computador  abra o terminal e digite :
```sh
$ git clone https://github.com/fxavier12/CFF-back-end.git
```
## Testando Localmente 
Pelo terminal entre na pasta do projeto

- compile o codigo java 
```sh
$ mvn clean install
```
- Rode o servidor na maquina local 

```sh
$ heroku local web
```
- Abra o navegar e entre em 
``localhost:5000``
``localhost:5000/hello``

## Branchs
Para editar os arquivos crie uma nova branch

```sh
$ git checkout -b nomedabranch
```
Para salvar as alteracoes feitas localmente no git 

```sh
$ git add .
$ git commit -a -m 'Meu Commit'
$ git push origin nomedabranch
```
Para adicionar novas funcionalidades a branch master envie um pull request


## Exemplos 

Foram criadas algumas branchs de exemplos de funcionalidades.

Para ver as branchs do projeto 

```sh
$ git branch -a
```

Para selecionar uma branch 

```sh
$ git checkout nomedabranch
```
