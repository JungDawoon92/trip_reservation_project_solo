<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body { font-size: 11pt; color: teal; }
	div { margin: 0 auto; }
</style>
</head>
<body>
	<div>
		<h2>사원정보 수정 페이지</h2>
		<form:form method="post" action="update.do" modelAttribute="empInfo">
		<form:hidden path="empno" />
			사번 ${empInfo.empno } <br>
			이름 ${empInfo.ename } <br>
			부서 <form:input path="deptno"/> <br>
			입사 ${empInfo.hiredate } <br>
			직무 ${empInfo.job } <br>
			급여 <form:input path="sal"/> <br>
			<p><input type="submit" value="변경사항 적용"></p>
			<p><a href="list">사원정보 리스트 보기</a></p>
		</form:form>
	</div>
</body>
</html>