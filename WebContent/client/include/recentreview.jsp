<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="client.comment.board.db.BoardBean,client.comment.board.db.BoardDAO" %>
<%@ page import="java.util.*"%>
<%@ page import="client.comment.board.action.encodeContent" %>
<%
	encodeContent encode = new encodeContent();
	BoardDAO boarddao = new BoardDAO();
	List boardlist = new ArrayList();
	boardlist = boarddao.recentreview();
	HashMap<Integer, Integer> boardcommentcount = new HashMap<Integer, Integer>();
	boardcommentcount = boarddao.countcomment();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <div>
  <h2>REVIEW<a href="./BoardList.bo" class="btn pull-right" role="button">전체보기</a></h2>
  <div class="list-group">
  		  <%
			for (int i = 0; i < boardlist.size(); i++) {
				BoardBean bl = (BoardBean) boardlist.get(i);
				String subject = "";
				subject =encode.encoding(bl.getBOARD_SUBJECT());
				
				if(subject.length() >= 15) { 
					subject=subject.substring(0,15)+"...";
				}
		  %>
		<a href="./BoardDetailAction.bo?num=<%=bl.getBOARD_NUM()%>" class="list-group-item">
      	<h5 class="list-group-item-heading">&nbsp;<%=subject%><font class="pull-right"><%=bl.getBOARD_DATE()%></font></h5>
    </a>
 	 <%} %>
  </div>
</div>

</body>
</html>