<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>방명록 쓰기</h2>
	<form action="write.htm" method="post">>
		<table width="600">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" size="12" maxlength="4"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" size="12" maxlength="12"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" size="50" maxlength="50"></td>
			</tr>
			<tr>
				<th>홈페이지</th>
				<td><input type="text" name="home" size="50" maxlength="50"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="30" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="쓰기">
				<input type="reset" value="취소">
				<input type="button" value="리스트" onclick="location.href='list.htm';"></td>
			</tr>
		</table>
	</form>
</body>
</html>