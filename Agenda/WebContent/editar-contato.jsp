<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="br.com.cepep.agenda.entidades.Pessoa,java.util.List,java.sql.SQLException" %>
    <jsp:useBean id="pessoa" type="br.com.cepep.agenda.entidades.Pessoa" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Editar Contato</title>
	</head>
	<body>
		<form action="contatos" method="POST">
			Nome: <input type="text" name="nome" value="${pessoa.nome}" /><br />
			Celular: <input type="text" name="endereco" value="${pessoa.celular}" /><br />
			Fixo: <input type="text" name="endereco" value="${pessoa.fixo}" /><br />
			E-mail: <input type="text" name="email" value="${pessoa.email}" /><br />
			Data Nascimento: <input type="text" name="dataNascimento" value="${pessoa.dataNascimento}"/><br />
			<input type="hidden" name="id" value="${pessoa.id}">
			<input type="hidden" name="acao" value="AtualizarContato">
			<input type="submit" value="Atualizar" />
		</form>
	</body>
</html>