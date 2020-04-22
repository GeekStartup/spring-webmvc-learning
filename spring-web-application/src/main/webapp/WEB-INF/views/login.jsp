<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yahoo!!!</title>
</head>
<body>
	<form action="/login" method="POST">
		<p><font color="red">${errorMessage}</font></p>
		Name:<input type="text" name="name"/>
		Password:<input type="password" name="password">
		<input type="submit" value="Submit">
	</form>
</body>
</html>