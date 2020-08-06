package client.comment.like.db;

import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import aqua.module.FactoryService;
import client.comment.comment.db.CommentBean;

public class BoardLikeDAO {
	DataSource ds;
	
	public BoardLikeDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc_maria");

		} catch (Exception ex) {
			return;
		}
	}
	
	public void isNoLike(int num, String id) {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		int likecount = 0;
		
		map.put("LIKE_ID", id);
		map.put("LIKE_BOARD_NUM", num);
		
		likecount = ss.selectOne("likecount",map);
		System.out.println("여기타나?1");
		if (likecount == 1) { //검색 되면 삭제
			ss.delete("likedelete", map);
			ss.commit();
			System.out.println("여기타나?2");
		} 
		ss.close();
	}
	
	public void isYesLike(int num, String id) {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		int likecount = 1;
		
		map.put("LIKE_ID", id);
		map.put("LIKE_BOARD_NUM", num);
	
		likecount = ss.selectOne("likecount",map);
		System.out.println("여기타나?3");
		if (likecount == 0) { //검색이 안되면 추가
			ss.insert("likeinsert", map);
			ss.commit();
			System.out.println("여기타나?4");
		} 
		ss.close();
	}
	
	public int isLikeCheck(int num, String id) {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		int likecount = 1;
		
		map.put("LIKE_ID", id);
		map.put("LIKE_BOARD_NUM", num);
	
		likecount = ss.selectOne("likecount",map);
		ss.close();
		
		return likecount;
		
	}
	
	public HashMap<Integer, Integer> isLikecount() {
		
		SqlSession ss = FactoryService.getFactory().openSession();
		List<BoardLikeBean> list = null;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		list = ss.selectList("boardnumlikecount");
		
		for( int i =0; i<list.size(); i++){
			BoardLikeBean a = (BoardLikeBean) list.get(i);
				map.put(a.getLIKE_BOARD_NUM(),a.getLIKE_COUNT());
			}
		ss.close();
		return map;	
		
	}
}
