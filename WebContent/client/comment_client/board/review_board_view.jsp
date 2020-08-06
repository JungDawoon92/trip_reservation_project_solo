<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="client.comment.board.db.*"%>
<%@ page import="client.comment.comment.db.*"%>
<%@ page import="java.util.*"%>
<%@ page import="client.comment.board.action.encodeContent" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	encodeContent encode = new encodeContent();
	BoardBean board = (BoardBean) request.getAttribute("boarddata");
%>
<%
	String id = "null";
	if (session.getAttribute("userid") != null) {
		id = (String) session.getAttribute("userid");
	}
%>
<%	int likecheck = 0;
	if (request.getAttribute("likecheck") != null) {
		likecheck =  ((Integer) request.getAttribute("likecheck")).intValue();		
	}

	List commentlist = (List) request.getAttribute("commentlist");
	int commentlistcount = ((Integer) request.getAttribute("commentlistcount"))
			.intValue();
	int nowpage = ((Integer) request.getAttribute("page")).intValue();
	int maxpage = ((Integer) request.getAttribute("maxpage"))
			.intValue();
	int startpage = ((Integer) request.getAttribute("startpage"))
			.intValue();
	int endpage = ((Integer) request.getAttribute("endpage"))
			.intValue();
	int pager = ((Integer) request.getAttribute("pager")).intValue();
	
	String content = "";
	String subject = "";
	content =encode.encoding(board.getBOARD_CONTENT());
	subject =encode.encoding(board.getBOARD_SUBJECT());
%>
	
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="https://kit.fontawesome.com/2d323a629b.js" crossorigin="anonymous"></script>
  	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="./client/css/review_view.css" />
    <title>AQUA</title>
    <script language="javascript">
	function Replyform(i) {
		document.forms[i].submit();
	}
	
	$(document).ready(function(){
		$(function () {
		$('#homeup').click(function () {
			$('body,html').animate({
				scrollTop: 0
			}, 300);
			return false;
		});
	var scrollHeight = $(document).height();
		$('#homedown').click(function () {
			$('body,html').animate({
				scrollTop: scrollHeight
			}, 300);
			return false;
		});
		});
	});
	</script>
	
  </head>
  <body>
    <nav class="navbar">
      <!-- Logo with text -->
      <div class="navbar__logo">
       <a href="Index.me" title="홈페이지" alt="홈페이지로 이동"><i class="fab fa-accusoft"></i> AQUA</a>
      </div>
      <!-- Menu -->
      <ul class="navbar__menu">
        <li onclick='location.href="Index.me"' title="Home" alt="홈페이지로 이동">홈페이지</li>
        <li onclick='"#"'>예약신청</li>
        <li onclick='"#"' title="Notice" alt="공지게시판으로 이동">공지게시판</li>
        <li onclick='"#"' title="QnA" alt="질문게시판으로 이동">질문게시판</li>
        <li id="link1" onclick='location.href="BoardList.bo"' title="ReplyBoard" alt="후기게시판으로 이동">후기게시판</li>
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

	<div class="container">
      <h2 align="left">Reivew</h2>
    </div>
    <br />
    
	<nav class="col-xs-1 content_div pull-right updownCont">
      <ul class="nav nav-pills nav-stacked">
        <li><a href="#homeup" id="homeup"><span class="glyphicon glyphicon-triangle-top"></span></a></li>
        <li><a href="#homedown" id="homedown"><span class="glyphicon glyphicon-triangle-bottom"></span></a></li>
      </ul>
    </nav>


	<div class="container content_div"> <!-- content_div class 추가로줌. 하얀색->검은색  -->
	<table class="table" cellpadding="0" cellspacing="0">

		<tr>
			<td width="80">
				<div>제 목&nbsp; &nbsp;:</div>
			</td>
			<td align="left"><%=subject%>
			</td>
		</tr>

		<tr>
			<td colspan="2" style="height: 1px;"></td>
		</tr>

		<tr>
			<td>
				<div>내 용&nbsp; &nbsp;:</div>
			</td>
			<td>
				<table>
					<tr>
						<%
							if (!(board.getBOARD_FILE() == null)) {
						%> <img src="./boardupload/<%=board.getBOARD_FILE()%>" class="img-thumbnail"></span> <%
 						}
 						%> 
						<td class="comment_td" valign=top>
							<pre class="comment"><%=content%></pre>
						</td>
					</tr>
				</table>
			</td>
			
		</tr>


		
		<tr align="right" valign="middle">
			<td colspan="5">
			<% if(!(id.equals("null"))) { 
				if(likecheck ==1) {%>
					<button type="button" class="btn btn-sm btn-danger button-class1" data-toggle="popover" data-trigger="hover" data-content="'좋아요' 는 큰 힘이됩니다!"><span class="glyphicon glyphicon-heart-empty"></span></button>
					<%} else {%>
					<button type="button" class="btn btn-sm button-class1" data-toggle="popover" data-trigger="hover" data-content="'좋아요' 는 큰 힘이됩니다!"><span class="glyphicon glyphicon-heart-empty"></span></button>	
					<% } %>
    		<% } else { %>
    		<button type="button" class="btn btn-sm" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-heart-empty"></span></button>
		 			    <div class="modal fade" id="myModal" role="dialog">
						    <div class="modal-dialog">
						      <div class="modal-content">
						        <div class="modal-header">
						          <button type="button" class="close" data-dismiss="modal">&times;</button>
						          <h4 class="modal-title pull-left">Alert</h4>
						        </div>
						        <div class="modal-body" style="margin-bottom: 10px;">
						          <p><font class="pull-left">로그인이 필요한 서비스입니다.</font></p>
						        </div>
						        <div class="modal-footer">
						          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						        </div>
						      </div>
						    </div>
						  </div>
					<% } %>
		<%if (id.equals(board.getBOARD_ID())) {%>
		<a href="./BoardDeleteAction.bo?num=<%=board.getBOARD_NUM()%>" class="btn btn-default pull-right btn-sm"> 삭제 </a>&nbsp;&nbsp;
		<a href="./BoardModify.bo?num=<%=board.getBOARD_NUM()%>&pager=<%=pager%>" class="btn btn-default pull-right btn-sm modify_botton"> 수정 </a>&nbsp;&nbsp;
 		<%} %>			
			</td>
		</tr>
		
	</table>
	</div>
	
	<div class="container content_div">
		<p>댓글 : ${commentlistcount}</p>
		<hr>
		<%
			for (int i = 0; i < commentlist.size(); i++) {
				CommentBean bl = (CommentBean) commentlist.get(i);
				String commentcontent = "";
				commentcontent =encode.encoding(bl.getCOMMENT_CONTENT());
		%>
		<div class="media">
			<%   if (bl.getCOMMENT_RE_LEV() != 0) {
					%>
					<div class="media-left">
					<img class="comment_img" src="./client/comment_client/img/img_comment1.png" class="media-object">
					</div>
					<%
						} else {
					%>
					<%
						}
					%>
			<div class="media-body">
			<h4 class="media-heading"><%if(bl.getCOMMENT_RE_LEV()!=0){%><font color="#31B0D5">┗</font><%=bl.getCOMMENT_ID()%><%}else{%><%=bl.getCOMMENT_ID()%><%}%><small><i>&nbsp;<%=bl.getCOMMENT_DATE()%></i></small>
			&nbsp; &nbsp;<%if (id.equals(bl.getCOMMENT_ID())) {%><small><a href="./Commentdelete.co?num=<%=bl.getCOMMENT_NUM()%>&numB=<%=board.getBOARD_NUM()%>&numC=<%=bl.getCOMMENT_RE_LEV()%>&numD=<%=bl.getCOMMENT_RE_REF()%>" class="btn pull-right">삭제</a></small>
 		<%}%><a href="#commentreview<%=i%>" class="btn" data-toggle="collapse">답글</a></h4>
					&nbsp; &nbsp;<pre class="comment_comment"><%=commentcontent%></pre>
					<!--내가 스타일을 위해 <pre>에 감싸진 <p>태그를 삭제함.(기본속성의 마진이 맘에안듬) bootstrap mediaobject의 규칙성에 어긋남. 나중에 스타일깨지면 <p>태그로 감싸주자   -->
			</div>
			<hr class="hr1">
		</div>
		<div class="container content_div">
			<div id="commentreview<%=i%>" class="collapse">
				<form action="./Commentreply.co" method="post" name="Replyform"+<%=i%>>
  					<input type="hidden" name="COMMENT_RE_REF" value="<%=bl.getCOMMENT_RE_REF()%>">
  					<input type="hidden" name="COMMENT_BOARD_NO" value="<%=board.getBOARD_NUM()%>">
  					<input type="hidden" name="COMMENT_ID" value="<%=id%>">
    				<% if(id.equals("null")) { %>
    				<div class="form-group">
      					<label for="comment">Comment:</label>
      					<textarea class="form-control" name="COMMENT_CONTENT" rows="5" placeholder="로그인이 필요합니다."></textarea>
    				</div>
    				<a href="javascript:Replyform(<%=i%>)" class="btn btn-info pull-right disabled" role="button">Reply</a>
    				<% } else { %>
    				<div class="form-group">
      					<label for="comment">Comment:</label>
      					<textarea class="form-control" name="COMMENT_CONTENT" rows="5"></textarea>
    				</div>
    				<a href="javascript:Replyform(<%=i%>)" class="btn btn-info pull-right" role="button">Reply</a>
    			 <%} %>
  				</form>
  			</div>
  		</div>	
		<%
			}
		%>
	</div>
	
<div class="container content_div" align=center>	
<ul class="pagination pagination-sm">
				<%
					if (nowpage <= 1) {
				%> <li class="disabled"><a href="#">&#60;</a></li> <%
 	} else {
 %> <li><a href="./BoardDetailAction.bo?page=<%=nowpage - 1%>&num=<%=board.getBOARD_NUM()%>">&#60;</a></li><%
 	}
 %> <%
 	for (int a = startpage; a <= endpage; a++) {
 		if (a == nowpage) {
 %> <li class="active"><a href="#"><%=a%></a></li> <%
 	} else {
 %> <li><a href="./BoardDetailAction.bo?page=<%=a%>&num=<%=board.getBOARD_NUM()%>"><%=a%>
			</a></li><%
 	}
 %> <%
 	}
 %> <%
 	if (nowpage >= maxpage) {
 %> <li class="disabled"><a href="#">&#62;</a></li> <%
 	} else {
 %> <li><a href="./BoardDetailAction.bo?page=<%=nowpage + 1%>&num=<%=board.getBOARD_NUM()%>">&#62;</a></li> <%
 	}
 %>
</ul>
</div>
	
	
	
	<div class="container content_div">
  		<form action="./CommentAdd.co" method="post">
  		<input type="hidden" name="COMMENT_BOARD_NO" value="<%=board.getBOARD_NUM()%>">
  		<input type="hidden" name="COMMENT_ID" value="<%=id%>">
    		<div class="form-group">
      			<label for="comment">Comment:</label>
      			<% if(!(id.equals("null"))) { %>
      			<textarea class="form-control comment_content" name="COMMENT_CONTENT" rows="5" required minlength="1" maxlength="1500"></textarea>
      			<% } else { %>
      			<textarea class="form-control comment_content" name="COMMENT_CONTENT" rows="5" required minlength="1" maxlength="1500" placeholder="로그인이 필요합니다."></textarea>
      			<% } %>
      			<div></div>
      			<a id="link2" href="<% try{if(((Integer)(session.getAttribute("sortrecent"))).intValue() == 1) { %>./BoardrecentList.bo?page=<% } else { %>./BoardList.bo?page=<%}} catch(Exception ex){%>./BoardList.bo?page=<%}%><%=pager%>&num=<%=board.getBOARD_NUM()%>" class="btn btn-default pull-left" role="button">목록</a>
    		<% if(!(id.equals("null"))) { %>
    		<button type="submit" class="btn btn-info pull-right">Reply</button>
    		<% } else { %>
		    <button type="button" class="btn btn-default pull-right margintop20" data-toggle="modal" data-target="#myModal">Reply</button>
		 			    <div class="modal fade" id="myModal" role="dialog">
						    <div class="modal-dialog">
						      <div class="modal-content">
						        <div class="modal-header">
						          <button type="button" class="close" data-dismiss="modal">&times;</button>
						          <h4 class="modal-title">Alert</h4>
						        </div>
						        <div class="modal-body">
						          <p>로그인이 필요한 서비스입니다.</p>
						        </div>
						        <div class="modal-footer">
						          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						        </div>
						      </div>
						    </div>
						  </div>
					<% } %>

    		</div>
  		</form>
	</div>
	
	<br />

    <footer class="container-fluid text-center">
      <p>Footer Text</p>
    </footer>
    
    <script>
    var like = document.getElementById("link2").getAttribute("href");
    
    var likechange ="";
    var like2change ="";
    
    var like1 = {
    	    get x() {
    	      return likechange;
    	    },
    	    set x(v) {
    	    	likechange = like+v;
    	    }
    	  }
    var like2 = {
    	    get x() {
    	      return like2change;
    	    },
    	    set x(v) {
    	    	like2change ="location.href="+"\""+v+"\"";
    	    }
    	  }
    
	$(document).ready(function(){
	    $('[data-toggle="popover"]').popover();   
	});
	
	$(".button-class1").click(function(){
	     $(this).toggleClass("btn-danger");
	     
	     if( $(this).hasClass('btn-danger') ) 
	    	{  
	    	 	like1.x = "&like=1";
	    		document.getElementById("link2").setAttribute("href",like1.x);
	    		like2.x = like1.x;
	    		document.getElementById("link1").setAttribute("onclick",like2.x);
	    		$.ajax({
		    	    url: "./BoardAjaxLike.bo?like=1"
		    	});
	         }
	     if( !$(this).hasClass('btn-danger') ) 
	    	{
	    	 	like1.x = "&like=0";
		    	document.getElementById("link2").setAttribute("href",like1.x);
		    	like2.x = like1.x;
		    	document.getElementById("link1").setAttribute("onclick",like2.x);
		    	$.ajax({
		    	    url: "./BoardAjaxLike.bo?like=0"
		    	});
	         }
	}); 
	</script>

</body>
</html>