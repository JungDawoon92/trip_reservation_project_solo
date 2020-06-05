<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
<h1>게시판 리스트</h1>
<a href="board_insert_form.do">글쓰기</a>
<table border="1"><tr>
	<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
	</tr>
<c:forEach var="vo" items="${boardList }">
<tr><td>${vo.seq }</td>
<td><a href="board_detail.do?seq=${vo.seq }">${vo.title }</a></td>
<td>${vo.writer }</td>
<td>${vo.regdate }</td>
</tr>
</c:forEach>
</table>
</body>
</html>