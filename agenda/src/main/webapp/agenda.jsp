<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>
<%
     @SuppressWarnings ("unchecked")
     ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="stylesheet" type="text/css" href="Agenda.css">
</head>
<body>
	<h1>Agenda De Contatos</h1>
	<a href="novo.html" class="Botao1">Novo Contato</a>
	<table>
	<thead>
	<tr>
	<th>Id</th>
	<th>Nome</th>
	<th>Fone</th>
	<th>E-mail</th>
	<th>Opcões</th>
	</tr>
	
	</thead>
	<tbody>
	<%for (int i = 0 ; i< lista.size(); i++){%>
	<tr>
	<td><%= lista.get(i).getId() %></td>
	<td><%= lista.get(i).getNome() %></td>
	<td><%= lista.get(i).getFone() %></td>
	<td><%= lista.get(i).getEmail() %></td>
	<td><a href="select?Id=<%=lista.get(i).getId() %>" >Editar</a>
	<a href="javascript: confirmar(<%=lista.get(i).getId() %>)" >Excluir</a>
	</td>
	</tr>
	<%} %>
	</tbody>
	</table>
	<script src="Scripts/confirmador.js"> </script>
</body>
</html>