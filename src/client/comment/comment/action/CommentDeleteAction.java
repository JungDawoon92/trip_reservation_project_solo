package client.comment.comment.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aqua.module.Action;
import aqua.module.ActionForward;
import client.comment.comment.db.CommentBean;
import client.comment.comment.db.CommentDAO;

public class CommentDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		CommentDAO commentdao = new CommentDAO();
		CommentBean commentdata = new CommentBean();
		
		boolean result = false;
		
		boolean deletecheck = false;		
		
		int num = Integer.parseInt(request.getParameter("num")); //그 댓글의 번호를 받아온다.
		int numB = Integer.parseInt(request.getParameter("numB")); //그 게시글의 번호를 받아온다.
		int numC = Integer.parseInt(request.getParameter("numC")); //그 댓글의 RE_LEV를 받아온다.
		int numD = Integer.parseInt(request.getParameter("numD")); //그 댓글의 RE_REF를 받아온다.	
		
		//최상위부모 삭제시 작동 로직
		if(numC==0) {
			deletecheck=commentdao.commentLevDel(num);
			if (deletecheck == false) {
				//최상위부모삭제
				forward.setRedirect(true);
				forward.setPath("./BoardDetailAction.bo?num="+numB);
				return forward;
			} else {
				//최상위부모 밑에 댓글이 있으므로 "삭제된 댓글입니다. 표시"
				forward.setRedirect(true);
				forward.setPath("./BoardDetailAction.bo?num="+numB);
				return forward;
				}
			}
		
		//lev가 1일때만 아래 로직 실행. 즉 "댓글의 답글"이라는 소리		
		
		result = commentdao.commentDelete(num);
		
		//////////////안전장치 나중에 필요할것 같음?/////////////////////
		if (result == false) {
			return null;
		}
		
		//////////////////////////////////////
		
		commentdao.mothercheck(numD); //최상위 부모가 혼자인 동시에 삭제되었습니다면 삭제/ 아니면 남기는 로직.
		
		forward.setRedirect(true);
		forward.setPath("./BoardDetailAction.bo?num="+numB);
		return forward;	
	}
}
