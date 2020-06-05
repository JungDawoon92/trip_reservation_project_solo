<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
.errorMsg {color:red;}
</style>
<body>
<h2>로그인 폼</h2>
<div class="errorMsg">
	<spring:bind path="loginBean.id">
	${status.errorMessage }
	</spring:bind>
	<spring:bind path="loginBean.pwd">
	${status.errorMessage }
	</spring:bind>
</div>
<form action="login.htm" method="post">
	I D : <input type="text" name="id"><br>
	PWD : <input type="password" name="pwd"><br>
	<input type="submit" value="Login">
</form>
</body>
</html>