<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/includes/cabecera.jsp"%>

<h3>Usuarios</h3>
<p>Aqui encontaras los usuarios y tambien podras crear editar y borrarlos</p>

<table>
	<caption>Usuarios</caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Email</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="usuarios" var="usuario">
			
		</c:forEach>
	</tbody>
	</table>
<%@ include file="/includes/pie.jsp"%>
