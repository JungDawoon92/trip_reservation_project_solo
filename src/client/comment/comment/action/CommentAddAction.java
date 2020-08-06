package client.comment.comment.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aqua.module.Action;
import aqua.module.ActionForward;
import client.comment.comment.db.CommentBean;
import client.comment.comment.db.CommentDAO;

public class CommentAddAction implements Action {
	public ActionForward execute(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		CommentDAO commentdao = new CommentDAO();
		CommentBean commentdata = new CommentBean();
		ActionForward forward = new ActionForward();
		
		int num = Integer.parseInt(request.getParameter("COMMENT_BOARD_NO"));
		
		boolean result = false;
		
		commentdata.setCOMMENT_ID(request.getParameter("COMMENT_ID"));
		commentdata.setCOMMENT_CONTENT(request.getParameter("COMMENT_CONTENT"));
		commentdata.setCOMMENT_BOARD_NO(num);
		result = commentdao.commentInsert(commentdata);
		
		if (result == false) {
			return null;
		}

		forward.setRedirect(true);
		forward.setPath("./BoardDetailAction.bo?num="+num);
		return forward;
		
		
			
		}
}
