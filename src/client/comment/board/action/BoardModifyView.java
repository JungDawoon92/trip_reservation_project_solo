package client.comment.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aqua.module.Action;
import aqua.module.ActionForward;
import client.comment.board.db.BoardBean;
import client.comment.board.db.BoardDAO;

public class BoardModifyView implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");

		BoardDAO boarddao = new BoardDAO();
		BoardBean boarddata = new BoardBean();
		
		int pager=1;
		if (request.getParameter("pager") != null) {
			pager = Integer.parseInt(request.getParameter("pager"));
		}
		request.setAttribute("pager", pager);

		int num = Integer.parseInt(request.getParameter("num"));
		boarddata = boarddao.getDetail(num);

		if (boarddata == null) {
			return null;
		}

		request.setAttribute("boarddata", boarddata);
		forward.setRedirect(false);
		forward.setPath("./client/comment_client/board/review_board_modify.jsp");
		return forward;
	}
}