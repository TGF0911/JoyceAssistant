<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<title>Obrigada!!!</title>
</head>
<body>
	<%-- 
	Esse exemplo n�o � necessario, j� que h� um jeito mais pratico
	<%
		String nome = (String) request.getAttribute("nome");
		String codigo = (String) request.getAttribute("codigo"); 

	%>
 --%>	
 
 
 	<h1>OBRIGADO!!!</h1>
	<p>Obrigada pelo cadastro!
	${aluno.nome}, O codigo que ira utilizar como cadastro �: ${aluno.codigo}</p>
	<p>Estamos te esperando!!!</p>
	
	<!-- isso � quando � do aluno -->
</body>
</html>