<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tarefas</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
		<div id="content" class="container_16 clearfix">
		<div class="grid_16">
			<h2>Seja bem vindo ${usuarioLogado.login}</h2>
		</div>
		<div class="grid_5">
			<div class="box">
				<h2>Tarefas</h2>
				<div class="utils">
					<a href="#">Ver mais</a>
				</div>
				<table>
					<tbody>
						<tr>
							<td><a href="listar">Listar tarefas</a></td>
							<td>-</td>
						</tr>
						<tr>
							<td><a href="nova">Cadastrar tarefa</a></td>
							<td>-</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="box">
				<h2>Produtos</h2>
				<div class="utils">
					<a href="#">Ver mais</a>
				</div>
				<table>
					<tbody>
						<tr>
							<td><a href="listarProdutos">Listar produtos</a></td>
							<td>-</td>
						</tr>
						<tr>
							<td><a href="cadastrarProdutos">Cadastrar produtos</a></td>
							<td>-</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<c:import url="rodape.jsp" />
</body>
</html>