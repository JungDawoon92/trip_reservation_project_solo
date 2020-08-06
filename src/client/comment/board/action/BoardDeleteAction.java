package client.comment.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aqua.module.Action;
import aqua.module.ActionForward;
import aqua.module.AdminCheck;
import client.comment.board.db.BoardDAO;

public class BoardDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");


		boolean result = false;

		int num = Integer.parseInt(request.getParameter("num"));

		BoardDAO boarddao = new BoardDAO();
		
		boarddao.commentAllDelete(num);    //내가 관리하기 편하게 commentdao에 넣을까 생각했지만 또 객체 생성해야하므로 뭔가느려질꺼같아서 boarddao에 쿼리문넣음.
				
		result = boarddao.boardDelete(num);
		
		if (result == false) {
			return null;
		}

		forward.setRedirect(true);
		forward.setPath("./BoardList.bo");
		return forward;
	}
}