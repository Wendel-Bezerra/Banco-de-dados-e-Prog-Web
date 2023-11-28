<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda De Contatos</title>
 <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<h1>Editar Contato</h1>
	<form name="frmContato" action="update">
		<table>
		<tr>
				<td><input type="text" name="id" readonly value ="<%out.print(request.getAttribute("Id")); %>"
					></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" value ="<%out.print(request.getAttribute("nome")); %>"
					></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" value ="<%out.print(request.getAttribute("fone")); %>" ></td>
			</tr>
			<tr>
				<td><input type="text" name="email" value ="<%out.print(request.getAttribute("email")); %>"
					></td>
			</tr>
		</table>
		<input type="button" value="Salvar" 
			onclick="validar()">
	</form>
	<script src="Scripts/validador.js"></script>
</body>
</html>