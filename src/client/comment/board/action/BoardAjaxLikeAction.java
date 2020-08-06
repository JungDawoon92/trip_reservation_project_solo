package client.comment.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.comment.like.db.BoardLikeDAO;

public class BoardAjaxLikeAction {
	
	
public void ajax(HttpServletRequest request) throws Exception  {
		request.setCharacterEncoding("UTF-8");
	
		BoardLikeDAO likedao = new BoardLikeDAO();
		HttpSession session = request.getSession();
		
		int num1 = 0; 
		String id = null;
		
		num1 = ((Integer)(session.getAttribute("likenum"))).intValue();
		
		id = (String) session.getAttribute("userid");
		
		int paralike = 0;

		paralike=Integer.parseInt((String)request.getParameter("like"));
		
		if(paralike == 0) { // 좋아요를 안눌렀을때 or 취소했을때.
			likedao.isNoLike(num1, id); // 검색이 되면 삭제 / 검색이 안되면 통과
		}
		else if(paralike == 1) { // 좋아요를 눌렀을때 or 기존에 눌렀을때.
			likedao.isYesLike(num1, id);		
		}
	}
}
