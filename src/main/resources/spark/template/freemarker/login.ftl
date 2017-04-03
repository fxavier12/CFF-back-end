<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	
	<!-- Biblioteca JUERY-->
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.0.min.js"></script>
	<!--javascript front end-->
	<script type="text/javascript" src="JS/frontend.js"></script>
</head>

  <link rel="stylesheet" type="text/css" href="CSS/estilo.css"> 

<body >

	<div class="center">
	<h1>Controle Financeiro Facil</h1>

		<div class="login">
			<form onsubmit="return false">
			  e-mail:<br>
			  <input type="email" name="email" value="" id="email" required="required">
			  <br>
			  senha:<br>
			  <input type="password" name="senha" value="" id="senha" required="required">
			  <br><br>
			  <input type="submit" class="botao-login" onclick="Login()" value="Entrar"> </input>
			  <button class="botao-login" onclick=" Redirect('localhost:5000/cadastro') " >Cadastrar</button>
			</form>
			<p id="demo"></p> 
		</div>

	</div>
	


</body>
</html>
