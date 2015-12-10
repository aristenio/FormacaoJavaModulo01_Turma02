<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="br.com.cepep.agenda.dao.PessoaDao,br.com.cepep.agenda.entidades.Pessoa,java.util.List,java.sql.SQLException" %>
<jsp:useBean id="dao" class="br.com.cepep.agenda.dao.PessoaDao"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Contatos</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>
<table border="1px">
	<c:forEach var="contato" items="${dao.listaPessoas}" varStatus="id">
		<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
			<td>${contato.nome}</td>
			<c:if test="${not empty contato.celular}">
				<td>${contato.celular}</td>
			</c:if>
			<c:choose>
			<c:when test="${not empty contato.fixo}">
				<td>${contato.fixo}</td>
			</c:when>
			<c:otherwise>
				<td>N/C</td>
			</c:otherwise>
			</c:choose>
			<td>${contato.email}</td>
			<td>
				<fmt:formatDate value="${contato.dataNascimento}" pattern="dd/MM/yyyy"  />
			</td>
		</tr>
	</c:forEach>
</table>
<c:import url="rodape.jsp"/>
</body>
</html>