# Prepararando o ambiente de Desenvolvimento 
Requisitos :
- Java  jdk
- Maven  
- Heroku

# Instalar
#### Windows

- JDK

  Instale o jdk ( se tiver o net-beans ou eclipse ja esta instalado).
  
- Maven

  Para instalar o Maven
      
  Baixe [esse arquivo](http://www-us.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip) e
Descompacte em uma pasta chamada starcode no disco C

- Variaveis de ambiente 

  Variavel : ``M2_HOME ``| Valor: ``c:\starcode\apache-maven-3.3.9 `` ( caminho da pasta do maven )
  
  Edite a variavel ``Path`` e adicione ``;%M2_HOME%\bin``
  
  Variavel: ``JAVA_HOME`` Valor : ``C:\Program Files\Java\jdk1.8.0_77`` ( caminho da pasta do jdk )

- Heroku


  Criar uma conta no [Heroku](https://signup.heroku.com/dc)


  Baixar [esse programa](https://cli-assets.heroku.com/branches/stable/heroku-windows-386.exe) e instalar


#### Linux
- JDK

  Instale o jdk ( se tiver o net-beans ou eclipse ja esta instalado).
  
- Maven

```sh
sudo apt-get install maven
```

- Heroku 

Criar uma conta no [Heroku](https://signup.heroku.com/dc)

```sh
sudo add-apt-repository "deb https://cli-assets.heroku.com/branches/stable/apt ./"
curl -L https://cli-assets.heroku.com/apt/release.key | sudo apt-key add -
sudo apt-get update
sudo apt-get install heroku
```

# Testando 
Os comandos sao executados via terminal no linux e cmd no windows 

Para testar o Maven

```sh
mvn -version
```

Heroku
```sh
heroku
```
Ele vai pedir seu usuario e senha 
