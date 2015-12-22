<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar tarefa - ${tarefa.id}</title>
</head>
<body>
	<c:import url="../cabecalho.jsp" />
	<div id="content" class="container_16 clearfix">
		<form action="alterar" method="post">
			<input type="hidden" name="id" value="${tarefa.id}" />
			<div class="grid_10">
				<p>
					<label for="title">Descrição:</label>
					<textarea name="descricao" rows="5" cols="100">
						${tarefa.descricao}
					</textarea>
				</p>
			</div>
			<div class="grid_3">
				<p>
					<label for="title"> Finalizado? </label> 
					<input type="checkbox"
						name="finalizado" value="true"
						${tarefa.finalizado ? 'checked' : '' } />
				</p>
			</div>
			<div class="grid_5">
				<p>
					<label for="title"> Data finalizado </label> 
					<input type="text"
						name="dataFinalizacao"
						value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>" />
				</p>
			</div>
			<div class="grid_16">
				<p class="submit">
					<input type="reset" value="Cancelar" /> 
					<input type="submit" value="Alterar" />
				</p>
			</div>
		</form>
	</div>
	<c:import url="../rodape.jsp" />
</body>
</html>