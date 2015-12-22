<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Criar nova tarefa</title>
</head>
<body>
	<c:import url="../cabecalho.jsp" />
	<div id="content" class="container_16 clearfix">
		<form action="adicionar" method="post">
			<div class="grid_10">
				<p>
					<label for="title">Descrição:</label> 
					<textarea name="descricao" rows="5" cols="100"></textarea>
				</p>
			</div>
			<div class="grid_16">
				<p class="submit">
					<input type="reset" value="Cancelar" />
					<input type="submit" value="Salvar" />
				</p>
			</div>
		</form>
	</div>
	<c:import url="../rodape.jsp" />
</body>
</html>