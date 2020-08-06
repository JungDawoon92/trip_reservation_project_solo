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

public class BoardSearchAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
	
		BoardDAO boarddao = new BoardDAO();
		List boardlist = new ArrayList();

		int page = 1;
		int limit = 5;
		int listcount = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		/////////////////////////////////////////////////////////////////////
		
		
		String search_select = ""; //검색창을 먼저 구분한다. search_select
		String search_id="";
		String search_subject="";
		String session_search = "";
		String search_content = "";
		
		if (request.getParameter("search_select") != null) { //검색이 들어온것.
			
			search_select =request.getParameter("search_select");
			
			if(search_select.equals("search_id")) {
				
				search_id = request.getParameter("search_search");
				session.setAttribute("search", "search_id");// 나중에 최적화를위해 map에 넣고 session을 한번만 써도될꺼같음.
				session.setAttribute("search_id",search_id);
				listcount = boarddao.getSearchIdListCount(search_id);
				boardlist = boarddao.getSearchList_id(page,search_id);
			
			}else if(search_select.equals("search_subject")) {
				
				search_subject = request.getParameter("search_search");
				session.setAttribute("search", "search_subject");
				session.setAttribute("search_subject",search_subject);
				listcount = boarddao.getSearchSubjectListCount(search_subject);
				boardlist = boarddao.getSearchList_Subject(page,search_subject);
				
				
			}else if(search_select.equals("search_content")) {
				
				search_content = request.getParameter("search_search");
				session.setAttribute("search", "search_content");
				session.setAttribute("search_content",search_content);
				listcount = boarddao.getSearchContentListCount(search_content);
				boardlist = boarddao.getSearchList_Content(page,search_content);
			}
			
			
		} else { // 검색이 안들어온것 //이건 세션을 구분한후 진행한다.
			session_search = (String) session.getAttribute("search");
			
			if(session_search.equals("search_id")) {
				
				search_id = (String) session.getAttribute("search_id");
				listcount = boarddao.getSearchIdListCount(search_id);
				boardlist = boarddao.getSearchList_id(page,search_id);
				
			} else if(session_search.equals("search_subject")) {
				
				search_subject = (String) session.getAttribute("search_subject");
				listcount = boarddao.getSearchSubjectListCount(search_subject);
				boardlist = boarddao.getSearchList_Subject(page,search_subject);
				
			} else if(session_search.equals("search_content")) {
				
				search_content = (String) session.getAttribute("search_content");
				listcount = boarddao.getSearchContentListCount(search_content);
				boardlist = boarddao.getSearchList_Content(page,search_content);
				
			}
		}
		
		//////////////////////////////////////////////////////////////////////////
		BoardLikeDAO likedao = new BoardLikeDAO();
		HashMap<Integer, Integer> likemap = new HashMap<Integer, Integer>();
		likemap = likedao.isLikecount();
		request.setAttribute("boardlikecount", likemap);
		/////////////////////////////////////////////////////////////////////////
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
		forward.setPath("./client/comment_client/board/review_board_searchlist.jsp");
		return forward;
	}
}