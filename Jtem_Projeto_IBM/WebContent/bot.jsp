<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IBM Watson w/ Java SDK</title>
<link rel="icon" href="img/favicon.png">
<link rel="stylesheet" type="text/css" href="css/bot.css" />
</head>
<body>
<header>
<ul class="topnav">
  <li><a href="index.html">Página Inicial</a></li>
  <li><a href="listaconteudo.html">Lista de Conteúdo</a></li>
  <li><a class="active" href="bot.jsp">Chatbot</a></li>
  <li><a href="exercicios.html">Exercícios</a></li>
  <li><a href="prova.html">Prova</a></li>
  <li class="sobre"><a href="aboutus.html">Sobre</a></li>
</ul>
</header><br>

	<section class="container">
		<h2 class="title">Chatbot Example w/ Watson API and Java</h2>
		<div class="chat-container"></div>
		<input type="text" id="question" name="question" class="field"
			placeholder="Type your question or message to convert in audio" />
		<div class="controls">
			<button id="sendQuestion">Send</button>
			<button id="getVoiceButton">Get Voice</button>
			<button id="recordButton">Record</button>
			<button id="pauseButton" disabled>Pause</button>
			<button id="stopButton" disabled>Stop</button>
		</div>
	</section>
	<script src="https://cdn.rawgit.com/mattdiamond/Recorderjs/08e7abd9/dist/recorder.js"></script>
	<script type="text/javascript" src="scripts/bot.js"></script>
	<script type="text/javascript" src="scripts/tts.js"></script>
	<script type="text/javascript" src="scripts/stt.js"></script>
</body>
</html>