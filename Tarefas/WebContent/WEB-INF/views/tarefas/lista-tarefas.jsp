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
	<c:import url="../cabecalho.jsp" />
	<script type="text/javascript">
		function finalizarAgora(id) {
			$.post("finalizarTarefa", {'id' : id}, function (resposta) {
				$("#tarefa_"+id).html("Finalizado");
				$("#datatarefa_"+id).html(resposta);
			})
		}
	</script>
	<div id="content" class="container_16 clearfix">
		<div class="grid_16">
			<h2>Lista de tarefas</h2>
		</div>
		<div class="grid_16">
			<table>
				<th>ID</th>
				<th>Descrição</th>
				<th>Finalizado?</th>
				<th>Data de Finalização</th>
				<th></th>
				<th></th>
				<c:forEach var="tarefa" items="${tarefas}" varStatus="id">
					<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
						<td>${tarefa.id}</td>
						<td>${tarefa.descricao}</td>
						<c:if test="${tarefa.finalizado eq false}">
							<td id="tarefa_${tarefa.id}"><a href="#" onclick="finalizarAgora(${tarefa.id})">Finalizar agora!</a></td>
						</c:if>
						<c:if test="${tarefa.finalizado eq true}">
							<td>Finalizado</td>
						</c:if>
						<td id="datatarefa_${tarefa.id}"><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
								pattern="dd/MM/yyyy" /></td>
						<td><a href="excluir?id=${tarefa.id}">excluir</a></td>
						<td><a href="editar?id=${tarefa.id}">editar</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="utils">
			<a href="nova">Nova tarefa</a>
		</div>
	</div>
</body>
</html>