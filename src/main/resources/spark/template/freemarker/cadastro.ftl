<!DOCTYPE html>
<html>
<head>
	<title>Cadastro</title>
	<link rel="stylesheet" type="text/css" href="CSS/estilo.css"> 
	
	<!-- Biblioteca JUERY-->
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.0.min.js"></script>
	<!--javascript front end-->
	<script type="text/javascript" src="JS/frontend.js"></script>	

</head>

  
<body >

	<div class="center">
	<h1>Controle Financeiro Facil</h1>

		<div class="login">
			<p>Preencha os campos abaixo</p>
			<form  onsubmit="return false">
			  Nome:<br>
			  <input type="text" name="nome" value="" id="nome">
			  <br>
			  E-mail:<br>
			  <input type="email" name="email" value="" id="email">
			  <br>
			  Senha:<br>
			  <input type="password" name="senha" value="" id="senha">
			  <br><br>
			  <input type="submit" class="botao-login" onclick="Cadastrar()" value="Cadastrar"></input>
			</form>
			<p id="demo"></p> 
		</div>

	</div>
	


</body>
</html>
