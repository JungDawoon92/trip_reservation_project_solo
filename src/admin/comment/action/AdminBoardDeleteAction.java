package admin.comment.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aqua.module.Action;
import aqua.module.ActionForward;
import aqua.module.AdminCheck;
import client.comment.board.db.BoardDAO;

public class AdminBoardDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");

		AdminCheck admin = new AdminCheck();
		if(admin.adminCheck(request, forward) == true) {
			boolean result = false;
		
			int num = Integer.parseInt(request.getParameter("num"));
	
			BoardDAO boarddao = new BoardDAO();
			
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