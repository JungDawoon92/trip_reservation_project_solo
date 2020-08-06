package client.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aqua.module.Action;
import aqua.module.ActionForward;
import client.member.db.MemberBean;
import client.member.db.MemberDAO;

public class MemberLoginAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();

		HttpSession session = request.getSession();
		MemberDAO memberdao = new MemberDAO();
		MemberBean member = new MemberBean();
		
		member.setId(request.getParameter("id"));
		member.setPass(request.getParameter("pass"));
		
		//System.out.println(member.getId()+"확인겟");
		
		String id = request.getParameter("id");
		
		member = MemberDAO.isMember(id);
		
		if (member == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 일치하지 않습니다.');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
			return null;
		} else if(!member.getPass().equals(request.getParameter("pass"))) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
			return null;
		}
		
		session.setAttribute("userid", id);
		
		System.out.println(member.getId()+"로그인");
		forward.setRedirect(true);
		forward.setPath("./Index.me");
		return forward;
	}
}