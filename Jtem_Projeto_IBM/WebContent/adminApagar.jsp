<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<title>Admin Aluno</title>
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
		<h2>Apagar Disciplina</h2>
		<form action="AdmApagaServlet" method="post">
			<input type="hidden" name="action" value="Apagar Disciplina">
			<label>Código</label><input type="text" name="codDisciplina"><br>
			<input type="submit" value="deletar"><br>
		</form>
		
		<h2>Apagar Questão</h2>
		<form action="AdmApagaServlet" method="post">
			<input type="hidden" name="action" value="Apagar Questao">
			<label>Código</label><input type="text" name="codQuestao"><br>
			<input type="submit" value="deletar"><br>
		</form>
		
		<h2>Apagar Avaliação</h2>
		<form action="AdmApagaServlet" method="post">
			<input type="hidden" name="action" value="Apagar Avaliacao">
			<label>Código</label><input type="text" name="codAvaliacao"><br>
			<input type="submit" value="deletar"><br>
		</form>
		
		<h2>Apagar Conteúdo</h2>
		<form action="AdmApagaServlet" method="post">
			<input type="hidden" name="action" value="Apagar Conteudo">
			<label>Código</label><input type="text" name="codConteudo"><br>
			<input type="submit" value="deletar"><br>
		</form>
	</div>
</div>
</body>
</html>