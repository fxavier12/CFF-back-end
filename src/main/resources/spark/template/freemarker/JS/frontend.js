function Login(){
	//para viasualizar os logs aperte f12 no google-chrome na aba Console
	///valores de input
	var params ={};

	params.nome = document.getElementById("nome").value;
	params.email = document.getElementById("email").value;
	//requisicao POST
	$.post( "https://cffbackend.herokuapp.com/login", { nome: params.nome, email: params.email})
  		.done(function( data ) {
   		 alert( "Data Loaded: " + data );
  	});
}
function Cadastrar(){
	
	//valores de input
	var params ={};

	params.nome = document.getElementById("nome").value;
	params.email = document.getElementById("email").value;
	params.senha = document.getElementById("senha").value;
	//params 
	console.log("Enviando requisicao de Cadastro : "+params);

	//requisicao POST
	$.post( "https://cffbackend.herokuapp.com/cadastro", { nome: params.nome, email: params.email , senha: params.senha })
  		.done(function( data ) {
   		 alert( "Data Loaded: " + data );
  	});

	

}
