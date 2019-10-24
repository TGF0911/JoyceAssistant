<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<title>Exercícios</title>
</head>
<body>
<header>
<ul class="topnav">
  <li><a href="index.jsp">Página Inicial</a></li>
  <li><a href="listaconteudo.html">Lista de Conteudo</a></li>
  <li><a class="active" href="exercicios.jsp">Exercícios</a></li>
  <li><a href="prova.jsp">Prova</a></li>
  <li class="sobre"><a href="aboutus.html">Sobre</a></li>
</ul>
</header><br>
<div class="idDivContentSmall">
	<h1>Exercícios</h1><br>
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
<div class="idBot">
	<section class="container">
		<h2 class="title">Chatbot Example w/ Watson API and Java</h2>
		<div class="chat-container"></div>
		<input type="text" name="question" class="field"
			placeholder="Insira a sua mensagem" />
		<div class="controle">
			<button class="buttonBot">Send</button>
			<button class="buttonBot">Get Voice</button>
			<button class="buttonBot">Record</button>
		</div>
	</section>
</div>
<script src="https://cdn.rawgit.com/mattdiamond/Recorderjs/08e7abd9/dist/recorder.js"></script>
	<script type="text/javascript" src="scripts/bot.js"></script>
	<script type="text/javascript" src="scripts/tts.js"></script>
	<script type="text/javascript" src="scripts/stt.js"></script>
</body>
</html>