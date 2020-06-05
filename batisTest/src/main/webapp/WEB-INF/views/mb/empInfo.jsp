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
	<script type="text/javascript">
		function empDelete(empno){
			if(confirm('정말로 사원정보를 삭제하시겠어요?')) {
				location.href='empDelete?empno='+empno;
			}
		}
	</script>
</head>
<body>
	<div>
		<h2>사원정보 상제 페이지</h2>
		사번${empInfo.empno} <br>
		이름 ${empInfo.ename } <br>
		부서 ${empInfo.deptno } <br>
		직무 ${empInfo.job } <br>
		급여 ${empInfo.sal } <br>
		<p><a href="empEdit?empno=${empInfo.empno}">사원정보 수정</a>
		<a href="javascript:empDelete(${empInfo.empno})">사원정보 삭제</a></p>
		<p><a href="empList">사원정보 리스트 보기</a></p>
	</div>
</body>
</html>