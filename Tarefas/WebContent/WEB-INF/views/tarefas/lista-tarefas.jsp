<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar tarefas</title>
</head>
<body>
	<table>
		<c:forEach var="tarefa" items="${tarefas}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
				<td>${tarefa.descricao}</td>
				<td>${tarefa.finalizado}</td>
				<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="deletarTarefa?id=${tarefa.id}">excluir</a></td>
				<td><a href="editarTarefa?id=${tarefa.id}">editar</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="nova">Nova tarefa</a>
</body>
</html>