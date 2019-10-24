<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<title>Prova</title>
</head>
<body>
<header>
<ul class="topnav">
  <li><a href="index.jsp">Página Inicial</a></li>
  <li><a href="listaconteudo.html">Lista de Conteúdo</a></li>
  <li><a href="exercicios.jsp">Exercícios</a></li>
  <li><a class="active" href="prova.jsp">Prova</a></li>
  <li class="sobre"><a href="aboutus.html">Sobre</a></li>
</ul>
</header><br>
<div class="idDivContentSmall">
	<h1>Prova</h1><br>
	<form action="exercicios.html" method="post">
	<label class="small">Pergunta 1</label><br>
		<input type="radio" name="pergunta1" value="1-1"> Alt 1<br>
		<input type="radio" name="pergunta1" value="1-2"> Alt 2<br>
		<input type="radio" name="pergunta1" value="1-3"> Alt 3<br>
		<input type="radio" name="pergunta1" value="1-4"> Alt 4<br><br>
	<label class="small">Pergunta 2</label><br>
		<input type="radio" name="pergunta2" value="2-1"> Alt 1<br>
		<input type="radio" name="pergunta2" value="2-2"> Alt 2<br>
		<input type="radio" name="pergunta2" value="2-3"> Alt 3<br>
		<input type="radio" name="pergunta2" value="2-4"> Alt 4<br><br>
		
		<input type="submit" value="Finalizar">
	</form>
</div>
</body>
</html>