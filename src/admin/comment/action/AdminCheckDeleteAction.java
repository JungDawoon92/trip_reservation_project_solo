package admin.comment.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aqua.module.Action;
import aqua.module.ActionForward;
import client.comment.board.db.BoardDAO;

public class AdminCheckDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		
		String[] checkdelete = request.getParameterValues("boarddelete");
		
		if(checkdelete == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<head><meta charset='UTF-8'>");
			out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>");
			out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
			out.println("</head><style>");
			out.println(".modal { display: none; position: fixed; z-index: 1; left: 0;");
			out.println("top: 0;  width: 100%;  height: 100%; overflow: auto;  background-color: rgb(0,0,0); ");
			out.println("background-color: rgba(0,0,0,0.4); }");
			out.println(".modal-content { background-color: #fefefe;  margin: 15% auto;   padding: 20px;");
			out.println("border: 1px solid #888;  width: 30%  } </style> <body>");
			out.println("<div id='myModal' class='modal'>  <div class='modal-content'> <div class='modal-header'>");
			out.println("<h4 class='modal-title'>알람</h4> </div>");
			out.println("<div class='modal-body'>");
			out.println("<p>체크박스를 선택해주세요</p> </div>");
			out.println("<div class='modal-footer'>");
			out.println("<button type='button' class='btn btn-default' data-dismiss='modal' onClick='close_pop();'>확인</button>");
			out.println("</div></div></div>");
			out.println("<script>");
			out.println("jQuery(document).ready(function() { $('#myModal').show();});");
			out.println("function close_pop(flag) {location.href='./AdminBoardListAction.adr';};  ");
			out.println("</script></body>");
			out.close();
		}
		 
		boolean result = false;
		int num=0;
		BoardDAO boarddao = new BoardDAO();
		for(String a : checkdelete) {
			
			num=Integer.parseInt(a);
		
			boarddao.commentAllDelete(num); 
					
			result = boarddao.boardDelete(num);
			
			if (result == false) {
				return null;
			}
		}

	
		forward.setRedirect(true);
		forward.setPath("./AdminBoardListAction.adr");
		return forward;
	}
}