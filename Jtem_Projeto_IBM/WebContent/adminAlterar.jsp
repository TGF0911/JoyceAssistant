<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<title>Admin Disciplina</title>
</head>
<body>
<header>
<ul class="topnav">
  <li><a href="index.jsp">Página Inicial</a></li>
  <li><a href="login.jsp">Login</a></li>
  <li><a href="cadastro.jsp">Cadastro</a></li>
  <li class="sobre"><a href="aboutus.html">Sobre</a></li>
</ul>
</header>
<h1 style="font-size: 60px; color: black; text-decoration: underline;">Cadastro</h1><br>
<div class="idDivContent">
	<div style="text-align: center">
		<h2>Alterar Conteudo</h2>
		<form action="AlteracaoServlet" method="post">
			<input type="hidden" name="action" value="Alterar Conteudo">
			<label>Novo Conteúdo</label><input type="text" name="novoConteudo"><br>
			<input type="submit" value="atualizar"><br>
		</form>
		
		<h2>Alterar Senha Aluno</h2>
		<form action="AlteracaoServlet" method="post">
			<input type="hidden" name="action" value="Alterar Aluno">
			<label>Nova Senha</label><input type="text" name="novaSenha"><br>
			<input type="submit" value="atualizar"><br>
		</form>
		
		<h2>Alterar Senha Admin</h2>
		<form action="AlteracaoServlet" method="post">
			<input type="hidden" name="action" value="Alterar Adm">
			<label>Nova Senha</label><input type="text" name="novaSenha"><br>
			<input type="submit" value="atualizar"><br>
		</form>
		
		<h2>Alterar Questão</h2>
		<form action="AlteracaoServlet" method="post">
			<input type="hidden" name="action" value="Alterar Questao">
			<label>Novo Peso</label><input type="text" name="novoPeso"><br>
			<input type="submit" value="atualizar">
		</form>
	</div>
</div>
</body>
</html>