<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<title>Login</title>
</head>
<body>
<header>
<ul class="topnav">
  <li><a href="index.jsp">Página Inicial</a></li>
  <li><a class="active" href="login.jsp">Login</a></li>
  <li><a href="cadastro.jsp">Cadastro</a></li>
  <li class="sobre"><a href="aboutus.html">Sobre</a></li>
</ul>
</header>
<h1 style="font-size: 60px; color: black; text-decoration: underline;">Cadastro</h1><br>
<div class="idDivContentSmall">
	<div style="text-align: center">
		<form action="ServletLogin" method="post">
			<label>Usuário:</label> <input type="text" name="usuario"><br>
			<label>Senha:</label> <input type="text" name="senha"><br><br>
			<input type="radio" name="lembrarsenha">Manter Conectado<br>
			<input type="submit" value="Login"><br>
			<a href="redefsenha.jsp">Esqueceu sua Senha?</a><br>
			<a href="cadastro.jsp">Desejo me cadastrar</a>
		</form>
	</div>
</div>
</body>
</html>
