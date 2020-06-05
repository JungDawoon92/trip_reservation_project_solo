<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>방명록 리스트</h2>
	<p><a href="writeform.htm">방명록 쓰기</a>
	<a href="index.html">메인</a></p><br>
	<c:forEach var="g" items="${list }">
		<!-- listController 에서 넘어오는 list -->
		${ g.NAME } (${g.EMAIL }) home : ${ g.HOME } <br>
		${ g.CONTENT }<br>
		<hr>
	</c:forEach>
</body>
</html>