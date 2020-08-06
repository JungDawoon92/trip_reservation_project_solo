package admin.member.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aqua.module.Action;
import aqua.module.ActionForward;

public class MemberLoginAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		HttpSession session = request.getSession();
		String Id = "admin";
		String pass = "admin";
		
		System.out.println(request.getParameter("admin_id"));
		System.out.println(request.getParameter("admin_pass"));
		
		
		if (Id.equals(request.getParameter("admin_id")) && pass.equals(request.getParameter("admin_pass"))) {
			session.setAttribute("adminid", Id);
			forward.setRedirect(true);
			forward.setPath("./AdminBoardListAction.adr");
			
		} else {
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
			out.println("<p>아이디 및 비밀번호를 다시 확인해 주세요</p> </div>");
			out.println("<div class='modal-footer'>");
			out.println("<button type='button' class='btn btn-default' data-dismiss='modal' onClick='close_pop();'>확인</button>");
			out.println("</div></div></div>");
			out.println("<script>");
			out.println("jQuery(document).ready(function() { $('#myModal').show();});");
			out.println("function close_pop(flag) {location.href='./loginformM.ad';};  ");
			out.println("</script></body>");
			out.close();
			return null;
		}
		return forward;
	}
}