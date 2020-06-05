<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>글쓰기</h1>
		<form method="post" action="board_insert_form.do">
			<table board="1">
				<tr>
					<td>제목</td><td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>작성자</td><td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<td>내용</td><td><textarea name="content" rows="5" cols="30"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="입력">
						<input type="button" value="목록" onclick="location.href='board_list.do'">
					</td>
			</table>
		</form>
	</div>
</body>
</html>