<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${sampleData}</h3>
	<form action="formProc" method="post">
		번호: <input type="text" name="num" value="7369"><br>
		이름: <input type="text" name="name" value="SMITH"><br>
		<input type="submit" value="SEND">
	</form>
</body>
</html>