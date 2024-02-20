<%@page import="com.marketing1.entity.Lead"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>leads</title>
</head>
<body>
<h2>List of Leads..</h2>
	<table>
		<tr>
			<th>firstName</th>
			<th>lastName</th>
			<th>City</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Action</th>
			<th>Action</th>
		</tr>

		<c:forEach var="Ld" items="${lead}">
			<tr>
				<td>${Ld.firstName}</td>
				<td>${Ld.lastName}</td>
				<td>${Ld.city}</td>
				<td>${Ld.email}</td>
				<td>${Ld.mobile}</td>
				<td><a href="delete?id=${Ld.id}">delete</a></td>
				<td><a href="update?id=${Ld.id}">update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>