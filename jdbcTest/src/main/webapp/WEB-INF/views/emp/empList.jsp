<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body { font-size: 11pt; color: teal; }
	div { margin : 0 auto; }
</style>
</head>
<body>
<div>
	<h2>사원정보 리스트</h2>사번이름 <br/>
	<c:forEach var="emp" items="${ list }">
	${ emp.empno }
	<a href="info.do?empno=${emp.empno}">${emp.ename}</a> <br/>
	</c:forEach>
	<p><a href="insert.do">사원정보 추가</a></p>
	</div>

</body>
</html>