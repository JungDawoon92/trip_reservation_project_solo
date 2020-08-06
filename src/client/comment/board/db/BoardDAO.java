package client.comment.board.db;

import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import aqua.module.FactoryService;
import client.comment.comment.db.CommentBean;

public class BoardDAO {
	DataSource ds;

	public BoardDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc_maria");

		} catch (Exception ex) {
			return;
		}
	}

	public List getSearchList_id(int page, String search_id) {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		List list = null;
		int startrow = (page - 1) * 10;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("startrow", startrow);
		map.put("BOARD_ID", search_id);
		
		list = ss.selectList("getSearchList_id", map);
		ss.close();
		return list;
	}
	
	public int getSearchIdListCount(String search_id) {
		int x = 0;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		x = ss.selectOne("getSearchIdListCount", search_id);
		ss.close();
		return x;
	}
	
	public List getSearchList_Subject(int page, String search_subject) {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		List list = null;
		int startrow = (page - 1) * 10;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("startrow", startrow);
		map.put("BOARD_SUBJECT", search_subject);
		
		list = ss.selectList("getSearchList_Subject", map);
		ss.close();
		return list;
	}
	
	public int getSearchSubjectListCount(String search_subject) {
		int x = 0;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		x = ss.selectOne("getSearchSubjectListCount", search_subject);
		ss.close();
		return x;
	}
	
	
	
	
public List getSearchList_Content(int page, String search_content) {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		List list = null;
		int startrow = (page - 1) * 10;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("startrow", startrow);
		map.put("BOARD_CONTENT", search_content);
		
		list = ss.selectList("getSearchList_Content", map);
		ss.close();
		return list;
	}
	
	public int getSearchContentListCount(String search_content) {
		int x = 0;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		x = ss.selectOne("getSearchContentListCount", search_content);
		ss.close();
		return x;
	}
	
	public int getListCount() {
		int x = 0;
		SqlSession ss = FactoryService.getFactory().openSession();
		x = ss.selectOne("getListCount");
		ss.close();
		return x;
	}

	public List getBoardList(int page) {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		List list = null;
		int startrow = (page - 1) * 10;
		list = ss.selectList("getBoardList", startrow);
		ss.close();
		return list;
	}
	// index에 쓰는 로직
	public List recentreview() {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		List list = null;
		list = ss.selectList("recentreview");
		ss.close();
		return list;
	}
	

	public BoardBean getDetail(int num) throws Exception {
		BoardBean board = null;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		board = ss.selectOne("getDetail",num);
		ss.close();
		return board;
	}

	public int boardInsert(BoardBean board) {
		int num = 0;
		int result = 0;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		num = ss.selectOne("getListmaxnum");
		
		if (num != 0)
			num = num+1;
		else
			num = 1;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("BOARD_NUM", num);
		map.put("BOARD_ID", board.getBOARD_ID());
		map.put("BOARD_SUBJECT", board.getBOARD_SUBJECT());
		map.put("BOARD_CONTENT", board.getBOARD_CONTENT());
		map.put("BOARD_FILE", board.getBOARD_FILE() );
		result = ss.insert("boardInsert", map);
		ss.commit();
		ss.close();
		
		return num;
		
	}

	public boolean boardModify(BoardBean modifyboard) throws Exception {
		
		int result = 0;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("BOARD_SUBJECT", modifyboard.getBOARD_SUBJECT());
		map.put("BOARD_CONTENT", modifyboard.getBOARD_CONTENT());
		map.put("BOARD_FILE", modifyboard.getBOARD_FILE());
		map.put("BOARD_NUM", modifyboard.getBOARD_NUM());
		
		result = ss.update("boardModify",map);
		
		ss.commit();
		ss.close();
		
		return (result > 0) ? true : false;
		
	}

	public boolean boardDelete(int num) {
		
		int result = 0;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		result = ss.delete("boardDelete",num);
		
		ss.commit();
		ss.close();
		
		return (result > 0) ? true : false;
	}

	public void setReadCountUpdate(int num) throws Exception {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		ss.update("setReadCountUpdate",num);
		ss.commit();
		ss.close();

	}

//	public boolean isBoardWriter(int num, String id) {
//		
//		String ssresult="";
//		
//		SqlSession ss = FactoryService.getFactory().openSession();
//		ssresult = ss.selectOne("isBoardWriter",num);
//		ss.close();
//		if (id.equals(ssresult)) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
	public void commentAllDelete(int num) {
		
	
		SqlSession ss = FactoryService.getFactory().openSession();
		ss.delete("commentAllDelete",num);
		
		ss.commit();
		ss.close();

			
	}
	
	public HashMap<Integer, Integer> countcomment() {
		
		
		SqlSession ss = FactoryService.getFactory().openSession();
		List<CommentBean> list = null;
//		CommentBean a;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		list = ss.selectList("boardnumcommentcount");
		
		for( int i =0; i<list.size(); i++){
			CommentBean a = (CommentBean) list.get(i);
				map.put(a.getCOMMENT_BOARD_NO(),a.getCOMMENT_NUM());
			}
		
//		count(*) 임시로 담아놓을곳 get comment_num임. 이거짜려고 실험을 얼마나했는지..밑은 이터레이터로 하다가 자꾸오류나서 그냥 위에껄로함 나중에 변경해보자.
		
//		for(Iterator<CommentBean> itr = list.iterator(); itr.hasNext(); ) {
//			a=itr.next();
//			map.put(a.getCOMMENT_BOARD_NO(),a.getCOMMENT_NUM());
//		}
		ss.close();
		return map;	
	}
}
