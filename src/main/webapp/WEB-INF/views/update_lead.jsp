<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
	<h2>Update Lead..</h2>
	<form action="updateLead" method="get">
     <pre>
     <input type="hidden" name="id" value="${lead.id}" />
     First Name<input type="text" name="firstName" value="${lead.firstName}" />		
     Last Name<input type="text" name="lastName" value="${lead.lastName}" />					
     City<input type="text" name="city" value="${lead.city}" />
     Email<input type="text" name="email" value="${lead.email}" />
     Mobile<input type="text" name="mobile" value="${lead.mobile}" />
     <input type="submit" value="update" />
     </pre>

	</form>
	${msg}
</body>
</html>