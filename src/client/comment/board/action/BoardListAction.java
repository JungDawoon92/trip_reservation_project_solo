package client.comment.board.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aqua.module.Action;
import aqua.module.ActionForward;
import client.comment.board.db.BoardDAO;
import client.comment.like.db.BoardLikeDAO;

public class BoardListAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		BoardDAO boarddao = new BoardDAO();
		List boardlist = new ArrayList();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		BoardLikeDAO likedao = new BoardLikeDAO();

		int num1 = 0; // 게시글 번호 담을 그릇
		String id = null; // 좋아요 누른 사람의 아이디
		
		Object Onum = request.getParameter("num"); // 목록버튼을 눌렀을때 쓰는것. // 바로 후기게시판을 눌렀을때는 이걸 안탐.
		Object like = request.getParameter("like");
		
		if (Onum != null) {
			num1 = Integer.parseInt((String) Onum );
		}
		if (session.getAttribute("userid") != null) {
			id = (String) session.getAttribute("userid");
		}
		
		int paralike = 0;

		if (like != null) { // null이면 빠져나간다.
			
			paralike = Integer.parseInt((String)like);
			if(paralike == 0) { // 좋아요를 안눌렀을때 or 취소했을때.
				likedao.isNoLike(num1, id); // 검색이 되면 삭제 / 검색이 안되면 통과
			}
			else if(paralike == 1) { // 좋아요를 눌렀을때 or 기존에 눌렀을때.
				likedao.isYesLike(num1, id);		
			}
		}
		
		
		HashMap<Integer, Integer> likemap = new HashMap<Integer, Integer>();
		likemap = likedao.isLikecount();
		request.setAttribute("boardlikecount", likemap);
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		int page = 1;
		int limit = 5;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount = boarddao.getListCount();
		
		boardlist = boarddao.getBoardList(page);
		
		int maxpage = (int) Math.ceil((double) listcount/ 10);
		
		int currentRange = (int) Math.ceil((double) page / limit);
		int totalRanges = (int) Math.ceil((double) maxpage / limit);
		int startpage = (currentRange - 1) * limit + 1;
		
		///////////////////////페이징 prev,next처리//////////////////////////////////////
		
		int endpage =currentRange * limit;
		if (currentRange == totalRanges)
			endpage = maxpage;
		
		int prevpage = 0;
		
		if (currentRange != 1)
			prevpage = (currentRange - 2) * limit + 1;
		
		int nextpage = 0;
		
		if (currentRange != (int)Math.ceil((double) maxpage / limit))
			nextpage = currentRange * limit + 1;
		
		////////////////////////댓글 총 숫자 가져오기 ///////////////////////////////////

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map = boarddao.countcomment();
		request.setAttribute("boardcommentcount", map);
		
		////////////////////////////////////////////////////////////////////////
		
		

		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		////
		request.setAttribute("prevpage", prevpage);
		request.setAttribute("nextpage", nextpage);
		////
		session.removeAttribute("spager");
		
		
		///////////////////////////////////////////////////////
		Object sortrecent = session.getAttribute("sortrecent");
			int sort= 0;
			if (sortrecent != null) {
				sort = 0;
			}
			session.setAttribute("sortrecent", sort);
		///////////////////////////////////////////////////////
		
		

		forward.setRedirect(false);
		forward.setPath("./client/comment_client/board/review_board_list.jsp");
		return forward;
	}
}