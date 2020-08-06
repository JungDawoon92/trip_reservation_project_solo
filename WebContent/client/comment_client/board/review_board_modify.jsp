<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="client.comment.board.db.*"%>
<%
	String id = (String) session.getAttribute("userid");
	BoardBean board = (BoardBean) request.getAttribute("boarddata");
	int pager = ((Integer) request.getAttribute("pager")).intValue();
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./client/css/review_modify.css" />
    <title>AQUA</title>
    <script type="text/javascript">
	function modifyboard() {
		modifyform.submit();
	}
	</script>
	
	
  </head>
  <body>
    <jsp:include page="/client/include/nav.jsp"></jsp:include>
    

	<div class="container content_div">
	<form action="BoardModifyAction.bo?pager=<%=pager%>" method="post" name="modifyform" enctype="multipart/form-data">
		<input type="hidden" name="BOARD_NUM" value="<%=board.getBOARD_NUM()%>">
		<input type="hidden" name="BOARD_ID" value="<%=id%>">
		<input type="hidden" name="H_BOARD_FILE" value="<%=board.getBOARD_FILE()%>">

		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div align="center">제 목</div>
				</td>
				<td><input class="form-control subject" name="BOARD_SUBJECT" type="text" required minlength="2" maxlength="50" size="150" value="<%=board.getBOARD_SUBJECT()%>"></td>
			</tr>
			<tr>
				<td>
					<div align="center">내 용</div>
				</td>
				<td><textarea class="form-control content" name="BOARD_CONTENT" rows="35" required minlength="2" maxlength="6000"><%=board.getBOARD_CONTENT()%></textarea>
				</td>
			</tr>
			
			<%
				if (!(board.getBOARD_FILE() == null)) {
			%>
			<tr>
				<td>
					<div class="paddingbottom20 pr20" align="center">파일</div>
				</td>
				<td class="paddingbottom20">
					<label class="btn btn-info">
						사진변경<input class="picture" name="BOARD_FILE" type="file" style="display: none;">
					</label>
				</td>
			</tr>
				<%}else{%>
				<tr>
					<td>
						<div class="paddingbottom20 pr20" align="center">파일</div>
					</td>
					<td class="paddingbottom20">
						<label class="btn btn-info">
							사진추가<input name="BOARD_FILE" type="file" style="display: none;" />
						</label>
					</td> <%}%>
				</tr>

			<tr bgcolor="cccccc">
				<td colspan="2" style="height: 1px;"></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>

			<tr align="center" valign="middle">
				<td colspan="5"><a href="javascript:history.go(-1)" class="btn btn-default pull-right btn-sm">취소</a>&nbsp;&nbsp;<a href="javascript:modifyboard()" class="btn btn-default pull-right btn-sm complete">완료</a>&nbsp;&nbsp;
				</td>
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

