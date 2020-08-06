<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="client.comment.board.db.BoardBean"%>
<%@ page import="client.comment.board.action.encodeContent" %>


<c:set var="encode" value="<%=new encodeContent()%>" />


<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
		    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
		    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		    
			<title>관리자모드 게시판</title>
			
		</head>
<body>

	<jsp:include page="/admin/module/Navbar.jsp" />

	<div class="container">
      <h1>관리자모드</h1>
    </div>
    <br />
    <div class="container" align="right">글 개수 : ${listcount}</div>


    <div class="container content_div"> <!-- content_div class 추가로줌. 하얀색->검은색  -->
        <form action="./AdminCheckDeleteAction.adr" method="post">
        <table class="table table-striped table-hover">
          <thead>
            <tr>
              <th>체크</th>
              <th>번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>날짜</th>
              <th>조회수</th>
            </tr>
          </thead>
		  <c:forEach items="${boardlist}" var="bl">
		  	<c:set var="subject" value="${encode.encoding(bl.getBOARD_SUBJECT())}" />
		  	<tr>
				<td>
					<input type="checkbox" name="boarddelete" value="${bl.getBOARD_NUM()}">
				</td>
				<td>
					${bl.getBOARD_NUM()}
				</td>
				<td>
					<div>
						<a href="./AdminBoardViewAction.adr?num=${bl.getBOARD_NUM()}&add=1&pager=${page}">${subject}
							<c:if test="${bl.getBOARD_FILE() != null}">
								&nbsp; <span class="glyphicon glyphicon-picture"></span>
							</c:if>
							<c:if test="${boardcommentcount.get(bl.getBOARD_NUM()) != null}">
								<font color="#FF2F74">[${boardcommentcount.get(bl.getBOARD_NUM())}]</font>
							</c:if>
						</a>
					</div>
				</td>
				<td>
					<div>${bl.getBOARD_ID()}</div>
				</td>
				<td>
					<div>${bl.getBOARD_DATE()}</div>
				</td>
				<td>
					<div>${bl.getBOARD_READCOUNT()}</div>
				</td>
			</tr>	
		  </c:forEach>
		</table>
		<button type="submit" class="btn btn-info pull-left">체크박스삭제</button>
		</form>	
		<div class="container content_div" align=center>	
			<ul class="pager pagination">
			<c:if test="${prevpage != 0}">
				<li class="previous"><a href="./AdminBoardListAction.adr?page=${prevpage}%>">&lt;&lt;</a></li> 
			</c:if>
			<c:choose>
				<c:when test="${page <= 1}">
					<li class="disabled"><a href="#">&lt;</a></li>
				</c:when>
				<c:otherwise>
					 <li><a href="./AdminBoardListAction.adr?page=${page - 1}">&lt;</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
				<c:choose>
				<c:when test="${a == page}">
					<li class="active"><a href="#">${a}</a></li>
				</c:when>
				<c:otherwise>
					 <li><a href="./AdminBoardListAction.adr?page=${a}">${a}</a></li>
				</c:otherwise>
			</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${page >= maxpage}">
					<li class="disabled"><a href="#">&gt;</a></li>
				</c:when>
				<c:otherwise>
					 <li><a href="./AdminBoardListAction.adr?page=${page + 1}">&gt;</a></li>
				</c:otherwise>
			</c:choose>
			<c:if test="${nextpage ne 0}">
				<li class="next"><a href="./AdminBoardListAction.adr?page=${nextpage}">&gt;&gt;</a></li>
			</c:if>
 
			</ul>
		</div>
    </div>
    <br />
</body>
</html>