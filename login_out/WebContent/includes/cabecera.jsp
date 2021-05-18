<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<ul>
		</li><a href="principal.jsp">Principal</p></li>
		<li><a href="sobreNosotros.jsp">Sobre nosotros</a></li>
		<li>
		<c:choose>
				<c:when test="&{email!=null}" >
				<li>Bien venido a yepaaaaa ${userName}</li>
				<li><a href="logout">Log out</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="login.jsp">Login</a></li>
				</c:otherwise>
		</c:choose></li>
	</ul>

