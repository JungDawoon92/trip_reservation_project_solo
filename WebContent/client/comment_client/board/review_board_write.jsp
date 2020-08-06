<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = (String) session.getAttribute("userid");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./client/css/review_write.css" />
    
    <title>AQUA</title>
    
  </head>
  <body>
    <jsp:include page="/client/include/nav.jsp"></jsp:include>
    
    <div class="container content_div">
	<form action="./BoardAddAction.bo" method="post" enctype="multipart/form-data"
		>
		<input type="hidden" name="BOARD_ID" value="<%=id%>">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div align="center">I D </div>
				</td>
				<td><%=id%></td>
			</tr>

			<tr>
				<td>
					<div align="center">제 목</div>
				</td>
				<td><input class="form-control write_subject" name="BOARD_SUBJECT" type="text" required minlength="2" maxlength="50" size="150"
					placeholder="50자 이내로 입력하세요." autofocus="autofocus"/></td>
			</tr>
			<tr>
				<td>
					<div align="center">내 용</div>
				</td>
				<td>
      				<textarea class="form-control write_content" name="BOARD_CONTENT" rows="35" id="comment"  placeholder="6000자 이내로 입력하세요." required minlength="2" maxlength="6000"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<div class="write_file" align="center">파일</div>
				</td>
				<td class="td_file"><input name="BOARD_FILE" type="file" /></td>
			</tr>
			<tr bgcolor="cccccc">
				<td colspan="2" style="height: 1px;"></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr align="center" valign="middle">
				<td colspan="5"><a href="javascript:history.go(-1)" class="btn btn-default pull-left" role="button">목록</a>
				<button type="submit" class="btn btn-info pull-right">POST</button></td>
			</tr>
		</table>
	</form>
	</div>
	
	<br />

    <footer class="container-fluid text-center">
      <p>Footer Text</p>
    </footer>
</body>
</html>