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
	HashMap<Integer, Integer> boardlikecount = (HashMap) request.getAttribute("boardlikecount");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./client/css/review_searchlist.css" />
    <title>AQUA</title>
  
  </head>
  <body>
    <jsp:include page="../../include/nav.jsp"></jsp:include>

    <div class="container">
      <h1>Review</h1>
      <div class="dropdown pull-right">
    	<button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown">정렬방식
    	<span class="caret"></span></button>
    	<ul class="dropdown-menu">
      		<li class="disabled"><a href="#">기본게시판</a></li>
      		<li class="divider"></li>
      		<li><a href="./BoardrecentList.bo">현대식게시판</a></li>
    	</ul>
  	</div>
    </div>
    <br />
    <div class="container" align="right">글 개수 : ${listcount}</div>


    <div class="container content_div"> <!-- content_div class 추가로줌. 하얀색->검은색  -->
        <table class="table table-striped table-hover">
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>날짜</th>
              <th>조회수</th>
              <th>좋아요</th>
            </tr>
          </thead>
          
          <%
			for (int i = 0; i < boardList.size(); i++) {
				BoardBean bl = (BoardBean) boardList.get(i);
				String subject = "";
				subject =encode.encoding(bl.getBOARD_SUBJECT());
		  %>
		  
		<tr>
			<td><%=bl.getBOARD_NUM()%>
			</td>
		
			<td>
				<div>
					<a href="./BoardDetailAction.bo?num=<%=bl.getBOARD_NUM()%>&add=1&pager=<%=nowpage%>"> <%=subject%>
						<%
							if (!(bl.getBOARD_FILE() == null)) {
						%>&nbsp;<span class="glyphicon glyphicon-picture"></span> <%
 	}
 %>
 						<%
 						try{ 
 							if (boardcommentcount.get(bl.getBOARD_NUM()) != 0) {%>
 						<font color="#FF2F74">[<%=boardcommentcount.get(bl.getBOARD_NUM()) %>]</font> <%}
 						} catch (Exception ex) {
 						}%>
 						
					</a>
				</div>
			</td>

			<td>
				<div><%=bl.getBOARD_ID()%></div>
			</td>
			<td>
				<div><%=bl.getBOARD_DATE()%></div>
			</td>
			<td>
				<div><%=bl.getBOARD_READCOUNT()%></div>
			</td>
			<td>
				<%		try{ 
 							if (boardlikecount.get(bl.getBOARD_NUM()) != 0) {%>
 						<%=boardlikecount.get(bl.getBOARD_NUM()) %> <%}
 						} catch (Exception ex) {%>
 							0
 						<%}%>
			</td>
		</tr>
		<%
			}
		%>
		
		<tr>
			<td colspan="6">
				 
				 <% if(id != null) { %>
				 <form action="./BoardSearch.bo" method="post">
 					<div class="controls text-center margintop20">
    					<select class="form-control form-control-inline" name="search_select">
        					<option value="search_subject">제목</option>
        					<option value="search_id">작성자</option>
        					<option value="search_content">내용</option>
    					</select>
      				<input type="text" class="form-control form-control-inline" placeholder="Search" name="search_search" size="50" required minlength="1" maxlength="12">
      				<div class="input-group-btn form-control-inline">
        				<button class="btn btn-info" type="submit"><i class="glyphicon glyphicon-search"></i></button>
      				</div>
					</div>
  				</form>
			<div>
				<a href="./BoardWrite.bo" class="btn btn-default pull-right margintop20">글쓰기</a>
			</div>
			<% } else { %>
				<form action="./BoardSearch.bo" method="post">
	 					<div class="controls text-center margintop20">
	    					<select class="form-control form-control-inline" name="search_select">
	        					<option value="search_subject">제목</option>
	        					<option value="search_id">작성자</option>
	        					<option value="search_content">내용</option>
	    					</select>
	      				<input type="text" class="form-control form-control-inline" placeholder="Search" name="search_search" size="50" required minlength="1" maxlength="12">
	      				<div class="input-group-btn form-control-inline">
	        				<button class="btn btn-info" type="submit"><i class="glyphicon glyphicon-search"></i></button>
	      				</div>
						</div>
	  				</form>
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
			
			</td>
		</tr>
		</table>
			
		
		<div class="container content_div" align=center>	
			<ul class="pager pagination">
				<%
					if (prevpage != 0) {
				%> <li class="previous"><a href="./BoardSearch.bo?page=<%=prevpage%>">&lt;&lt;</a></li> <%
 					}
 				%>
 <%
					if (nowpage <= 1) {
				%> <li class="disabled"><a href="#">&lt;</a></li> <%
 	} else {
 %> <li><a href="./BoardSearch.bo?page=<%=nowpage - 1%>">&lt;</a></li> <%
 	}
 %>
 
 
  <%
 	for (int a = startpage; a <= endpage; a++) {
 		if (a == nowpage) {
 %> <li class="active"><a href="#"><%=a%></a></li> <%
 	} else {
 %> <li><a href="./BoardSearch.bo?page=<%=a%>"><%=a%>
			</a></li><%
 	}
 %> <%
 	}
 %> <%
 	if (nowpage >= maxpage) {
 %> <li class="disabled"><a href="#">&gt;</a></li> <%
 	} else {
 %> <li><a href="./BoardSearch.bo?page=<%=nowpage + 1%>">&gt;</a></li> <%
 	}
 %>
 
 <%
					if (nextpage != 0) {
				%> <li class="next"><a href="./BoardSearch.bo?page=<%=nextpage%>">&gt;&gt;</a></li> <%
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
