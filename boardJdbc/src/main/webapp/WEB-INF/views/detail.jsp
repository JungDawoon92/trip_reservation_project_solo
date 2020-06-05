<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fnList() {
		location.href = "board_list.do";
	}
	function fnUpdate() {
		location.href = "board_update.do?seq=" + ${ board.seq };
	}
	function fnDelete() {
		location.href = "board_delete.do?seq=" + ${ board.seq };
	}
</script>
</head>
<body>
	<div align="center">
		<h1>상세보기</h1>
		<table border="1">
				<tr>
					<td>번호</td>
					<td>${ board.seq }</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>${ board.title }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>${ board.content }</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="button" value="수정" onclick="fnUpdate()">
					<input type="button" value="삭제" onclick="fnDelete()">
					<input type="button" value="목록" onclick="fnList()">
					</td>
				</tr>
			</table>
	</div>
</body>
</html>