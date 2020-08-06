<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./client/css/style.css" />
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap" rel="stylesheet"/>
<title>Insert title here</title>
    <script src="https://kit.fontawesome.com/2d323a629b.js" crossorigin="anonymous"></script>
</head>
<body>
	<!-- Nav container -->
    <nav class="navbar">
      <!-- Logo with text -->
      <div class="navbar__logo">
       <a href="Index.me" title="홈페이지" alt="홈페이지로 이동"><i class="fab fa-accusoft"></i> AQUA</a>
      </div>
      <!-- Menu -->
      <ul class="navbar__menu">
        <li onclick='location.href="Index.me"' title="Home" alt="홈페이지로 이동">홈페이지</li>
        <li onclick='location.href="#"' title="Book" alt="예약페이지로 이동">예약신청</li>
        <li onclick='location.href="#"' title="Notice" alt="공지게시판으로 이동">공지게시판</li>
        <li onclick='location.href="#"' title="QnA" alt="질문게시판으로 이동">질문게시판</li>
        <li onclick='location.href="BoardList.bo"' title="ReplyBoard" alt="후기게시판으로 이동">후기게시판</li>
      </ul>
      <!-- Icons -->
      <ul class="navbar__icons">
        <c:if test="${!empty sessionScope.userid}">
        	<li><a href="#"><i class="fas fa-user" title="my page" alt="내 정보 페이지"> 내 정보보기</i></a></li>
        	<li><a href="#" title="logout" alt="로그아웃"><i class="fas fa-sign-out-alt"> 로그아웃</i></a></li>
        </c:if>
        <c:if test="${empty sessionScope.userid}">
        	<li><a href="#" title="sign up" alt="회원가입하기"><i class="fas fa-user-plus" > 회원가입</i></a></li>
        	<li><a href="MemberLogin.me" title="sign in" alt="로그인하기"><i class="fas fa-sign-in-alt" > 로그인</i></a></li>
        </c:if>       
      </ul>
      <!-- Toggle button -->
      <a href="#" class="navbar__toggleBtn" title="모바일 메뉴" alt="모바일 메뉴">
        <i class="fas fa-bars"></i>
      </a>
      <!-- Toggle button -->
      	<script type="text/javascript">
		    const toggleBtn = document.querySelector('.navbar__toggleBtn');
	    	const menu = document.querySelector('.navbar__menu');
		    const icons = document.querySelector('.navbar__icons');
		    toggleBtn.addEventListener('click', () => {
		      menu.classList.toggle('active');
		      icons.classList.toggle('active');
		    });
	    </script>
    </nav>
</body>
</html>