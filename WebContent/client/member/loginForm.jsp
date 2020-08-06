<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link
      href="https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap"
      rel="stylesheet"
    />
    
    <link rel="stylesheet" href="./client/css/member.css" />
<title>로그인</title>
	<script
      src="https://kit.fontawesome.com/2d323a629b.js"
      crossorigin="anonymous"
    ></script>
<script type="text/javascript">
$(document).ready(function(){
	  $("#id").focus();
	});
</script>
    <script type="text/javascript">
     
    	function check_onclick() {
			theForm = document.loginform
			
			if(theForm.id.value==""){
				alert("아이디가 비어있습니다. 확인해주세요.");
				theForm.id.focus();
				return false;
			}else if(theForm.pass.value==""){
				alert("비밀번호가 비어있습니다. 확인해주세요.");
				theForm.pass.focus();
				return false;
			}
			theForm.submit();
		}
    </script>
</head>
<body class="gray-body">
	<jsp:include page="/client/include/nav.jsp"></jsp:include>
    <div class="wrap vcenter">
    <div class="container">
    <div class="row">
    <section class="col-md-3"></section>
    <section class="col-md-6">
    <div class="col-sm-12 marg-bott"><img class="img-responsive center-block logo" title="로그인로고" src="./img/aqua.png"></div>
<form role="form" class="form-horizontal" name="loginform" action="./MemberLoginAction.me" method="post" onsubmit="return check_onclick()">
	<div class="form-group">
	<div class="col-sm-12">
		<input class="form-control login" type="text" id="id" name="id" placeholder="아이디" title="아이디" alt="아이디 입력란"
		onkeypress="if(event.keyCode == 13){ return false; }"/>
	</div></div>
	<div class="form-group">
	<div class="col-sm-12">
			<input class="form-control login" type="password" name="pass" placeholder="비밀번호" title="비밀번호" alt="비밀번호 입력란"
			/>
	</div></div>
	<div class="form-group">
		<div class="col-sm-12">
			<input type="submit" id="submit" class="submit" value="로그인" title="로그인" alt="로그인 버튼"/>
	</div></div>
	<div class="form-group">
		<div class="col-sm-12">
			<input type="button" class="join button" onclick="location.href='MemberJoinView.me'" value="회원가입" title="회원가입" alt="회원가입 페이지로 이동 버튼"/>
	</div></div>
</form>
</section>
<section class="col-md-3"></section>
</div>
</div>
</div>
<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>
</body>
</html>