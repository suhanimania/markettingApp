<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create</title>
</head>
<body>
	<h2>Create Lead..</h2>
	<form action="SaveLead" method="get">
		<pre>
     First Name<input type="text" name="firstName" />
     Last Name<input type="text" name="lastName" />
     City<input type="text" name="city" />
     Email<input type="text" name="email" />
     Mobile<input type="text" name="mobile" />
     <input type="submit" value="save" />
     </pre>
		${msg}
	</form>

</body>
</html>