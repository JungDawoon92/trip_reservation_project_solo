<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="client.comment.board.db.*"%>
<%@ page import="client.comment.board.action.encodeContent" %>
<%
	encodeContent encode = new encodeContent();

	String id = null;
	if (session.getAttribute("userid") != null) {
		id = (String) session.getAttribute("userid");
	}
	List boardList = (List) request.getAttribute("boardlist");
	int listcount = ((Integer) request.getAttribute("listcount"))
			.intValue();
	int nowpage = ((Integer) request.getAttribute("page")).intValue();
	int maxpage = ((Integer) request.getAttribute("maxpage"))
			.intValue();
	int startpage = ((Integer) request.getAttribute("startpage"))
			.intValue();
	int endpage = ((Integer) request.getAttribute("endpage"))
			.intValue();
	
	//확넘기는거
	int prevpage = ((Integer) request.getAttribute("prevpage"))
			.intValue();
	int nextpage = ((Integer) request.getAttribute("nextpage"))
			.intValue();
	
	HashMap<Integer, Integer> boardcommentcount = (HashMap) request.getAttribute("boardcommentcount");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./client/css/review_recentlist.css" />

    <title>AQUA</title>
    
    <script language="javascript">
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
    <jsp:include page="../../include/nav.jsp"></jsp:include>

	<nav class="col-xs-1 content_div pull-right updownCont">
      <ul class="nav nav-pills nav-stacked">
        <li><a href="#homeup" id="homeup"><span class="glyphicon glyphicon-triangle-top"></span></a></li>
        <li><a href="#homedown" id="homedown"><span class="glyphicon glyphicon-triangle-bottom"></span></a></li>
      </ul>
    </nav>
    
    <div class="container">
      <h1>Review</h1>
      <div class="dropdown pull-right">
    	<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-th-list"></span>
    	<span class="caret"></span></button>
    	<ul class="dropdown-menu">
      		<li><a href="./BoardList.bo">기본게시판</a></li>
      		<li class="divider"></li>
      		<li class="disabled"><a href="#">현대식게시판</a></li>
    	</ul>
  	</div>
    </div>
    <br />
    <div class="container" align="right">글 개수 : ${listcount}</div>
    <div class="container content_div">
    	<div>
    	<h2>후기글</h2>
    	</div>
    	<hr>
    	<%
			for (int i = 0; i < boardList.size(); i++) {
				BoardBean bl = (BoardBean) boardList.get(i);
				String content = "";
				String subject = "";
				content =encode.encoding(bl.getBOARD_CONTENT());
				subject =encode.encoding(bl.getBOARD_SUBJECT());
				if(content.length() >= 200) { 
					content=content.substring(0,200)+"...";
				}
		  %>
		  <div class="media">
   			 <div class="media-body">
     		 <h4 class="media-heading">
     		 	<a href="./BoardDetailAction.bo?num=<%=bl.getBOARD_NUM()%>&add=1&pager=<%=nowpage%>"> <%=subject%>
     		 		<%try{ 
 							if (boardcommentcount.get(bl.getBOARD_NUM()) != 0) {%>
 						<font color="#FF2F74">[<%=boardcommentcount.get(bl.getBOARD_NUM()) %>]</font> <%}
 						} catch (Exception ex) {
 						}%></a></h4>
      		 <p><%=content%></p>
   		 </div>
   		 <div class="media-right">
      		<%
							if (!(bl.getBOARD_FILE() == null)) {
						%> <img src="./boardupload/<%=bl.getBOARD_FILE()%>" class="thumbnail" width="100" height="100"> <%	} %> 
    	</div>
    		<span class="glyphicon glyphicon-user"></span>&nbsp;<small><%=bl.getBOARD_ID()%></small>&nbsp; &nbsp;<span class="glyphicon glyphicon-time"></span>&nbsp;<small><%=bl.getBOARD_DATE()%></small>&nbsp; &nbsp;<span class="glyphicon glyphicon-eye-open"></span>&nbsp;<small><%=bl.getBOARD_READCOUNT()%></small>
    		<hr>
 		</div>
		  
		  <%
			}
		%>
    </div>
    
    <div class="container content_div">
    <% if(id != null) { %>
    	<a href="./BoardWrite.bo" class="btn btn-default pull-right write">글쓰기</a>
    <% } else { %>
    <button type="button" class="btn btn-default pull-right margintop20" data-toggle="modal" data-target="#myModal">글쓰기</button>
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
    
    

		<div class="container content_div" align=center>	
			<ul class="pager pagination">
				<%
					if (prevpage != 0) {
				%> <li class="previous"><a href="./BoardrecentList.bo?page=<%=prevpage%>">&lt;&lt;</a></li> <%
 					}
 				%>
 <%
					if (nowpage <= 1) {
				%> <li class="disabled"><a href="#">&lt;</a></li> <%
 	} else {
 %> <li><a href="./BoardrecentList.bo?page=<%=nowpage - 1%>">&lt;</a></li> <%
 	}
 %>
 
 
  <%
 	for (int a = startpage; a <= endpage; a++) {
 		if (a == nowpage) {
 %> <li class="active"><a href="#"><%=a%></a></li> <%
 	} else {
 %> <li><a href="./BoardrecentList.bo?page=<%=a%>"><%=a%>
			</a></li><%
 	}
 %> <%
 	}
 %> <%
 	if (nowpage >= maxpage) {
 %> <li class="disabled"><a href="#">&gt;</a></li> <%
 	} else {
 %> <li><a href="./BoardrecentList.bo?page=<%=nowpage + 1%>">&gt;</a></li> <%
 	}
 %>
 
 <%
					if (nextpage != 0) {
				%> <li class="next"><a href="./BoardrecentList.bo?page=<%=nextpage%>">&gt;&gt;</a></li> <%
 					}
 				%>
 
			</ul>
		</div>
    </div>
    

    <br />

    <footer class="container-fluid text-center">
      <p>Footer Text</p>
    </footer>
  </body>
</html>


</body>
</html>