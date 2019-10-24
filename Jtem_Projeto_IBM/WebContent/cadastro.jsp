<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<title>Cadastro</title>
</head>
<body>
<header>
<ul class="topnav">
  <li><a href="index.jsp">Página Inicial</a></li>
  <li><a href="login.jsp">Login</a></li>
  <li><a class="active" href="cadastro.jsp">Cadastro</a></li>
  <li class="sobre"><a href="aboutus.html">Sobre</a></li>
</ul>
</header>
<h1 style="font-size: 60px; color: black; text-decoration: underline;">Cadastro</h1><br>
<div class="idDivContentSmall">
<form action="ServletCadastro" method="post">
	<label class="small">RM:</label><input type="text" name="codigo"><br>
	<label class="small">Nome:</label><input type="text" name="nome"><br>
	<label class="small">Sobrenome:</label><input type="text" name="sobrenome"><br>
	<label class="small">Escolaridade:</label><select name="escolaridade"><option value="medio">Ensino Médio</option><option value="superior">Ensino Superior</option></select><br>
	<label class="small">Curso Superior</label><select name="curso"><option value="TDS">Análise de Sistemas</option><option value="SI">Sistemas de Informação</option><option value="CI">Ciências da Computação</option></select><br>
	<label class="small">Data de Nascimento:</label><input type="date" name="data"><br>
	<label class="small">Senha:</label><input type="text" name="senha"><br>
	<label class="small">E-Mail:</label><input type="text" name="email"><br>
	<input type="submit" value="Cadastrar">
</form>
</div>
</body>
</html>