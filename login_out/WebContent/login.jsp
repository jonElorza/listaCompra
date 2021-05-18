<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>BIEN VENIDO A TU LISTA DE LA COMPRA</h1>
<form action="login" method="post">
	<div>
		<label for="userName">Introduce tu nombre</label>
		 <input name="userName" id="userName" />
	</div>

	<div>
		<label for="email">Introduce tu email</label>
		 <input name="email" id="email" />
	</div>
	<div>
		<label for="password">Introduce tu contraseña</label>
		<input name ="password" id="password" />
	</div>
	<button type="submit">Entrar</button>
</form>
<%@include file="/includes/pie.jsp"%>
