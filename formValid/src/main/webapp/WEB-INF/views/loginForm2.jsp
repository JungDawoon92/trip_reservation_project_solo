<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h2>로그인 폼 2</h2>
<form:form method="POST" commandName="loginBean" action="login.htm">
<form:errors path="*" cssClass="errorMsg" element="div"/>
<table>
	<tr>
		<td>I D : </td><td><form:input path="id"/></td>
		<td><form:errors path="id" cssClass="errorMsg"/></td>
	</tr>
	<tr>
		<td>PWD : </td><td><form:input path="pwd"/></td>
		<td><form:errors path="pwd" cssClass="errorMsg"/></td>
	</tr>
	<tr>
	<td colspan="3"><input type="submit"/></td>
	</tr>
</table>
</form:form>
</body>
</html>