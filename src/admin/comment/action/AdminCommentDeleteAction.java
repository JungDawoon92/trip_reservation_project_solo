package admin.comment.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aqua.module.Action;
import aqua.module.ActionForward;
import client.comment.comment.db.CommentBean;
import client.comment.comment.db.CommentDAO;

public class AdminCommentDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
	ActionForward forward = new ActionForward();
	request.setCharacterEncoding("UTF-8");
	
	HttpSession session = request.getSession();
	String id = (String) session.getAttribute("id");
	
	CommentDAO commentdao = new CommentDAO();
	
	boolean result = false;
	
	boolean deletecheck = false;
	
	
	int num = Integer.parseInt(request.getParameter("num")); //그 댓글의 번호를 받아온다.
	int numB = Integer.parseInt(request.getParameter("numB")); //그 게시글의 번호를 받아온다.
	int numC = Integer.parseInt(request.getParameter("numC")); //그 댓글의 RE_LEV를 받아온다.
	int numD = Integer.parseInt(request.getParameter("numD")); //그 댓글의 RE_REF를 받아온다.
	
	
	//최상위부모 삭제시 작동 로직
	if(numC==0) {
		deletecheck=commentdao.admincommentLevDel(num);
		if (deletecheck == false) {
			//최상위부모삭제
			forward.setRedirect(true);
			forward.setPath("./AdminBoardViewAction.adr?num="+numB);
			return forward;
		} else {
			//최상위부모 밑에 댓글이 있으므로 "삭제된 댓글입니다. 표시"
			forward.setRedirect(true);
			forward.setPath("./AdminBoardViewAction.adr?num="+numB);
			return forward;
			}
		}
	
	//lev가 1일때만 아래 로직 실행. 즉 "댓글의 답글"이라는 소리 
	
	result = commentdao.commentDelete(num);
	
	if (result == false) {
		return null;
	}
	
	commentdao.mothercheck(numD); 
	
	forward.setRedirect(true);
	forward.setPath("./AdminBoardViewAction.adr?num="+numB);
	return forward;
	
	
	}

}
