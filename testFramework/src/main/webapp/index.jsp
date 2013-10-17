<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
	<form action="loginAction.perform" method="post">
		Login :
		<input name="login" type="text"/>
		<br>
		Password :
		<input name="password" type="password"/>
		<br>
		<input type="submit" value="Submit">
		<br>
		
		<c:forEach items="${requestScope.messagesError}" var="message">
			<tr>
				<td><c:out value=" Error : ${message} " /></td><br>
			</tr>
		</c:forEach>
	</form>

</body>
</html>