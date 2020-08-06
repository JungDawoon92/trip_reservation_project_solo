package client.comment.comment.db;

import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import aqua.module.FactoryService;

public class CommentDAO {
	
	DataSource ds;
	
	public CommentDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc_maria");

		} catch (Exception ex) {
			return;
		}
	}
	
	public boolean commentInsert(CommentBean comment) {
		
		int num = 0;
		int result = 0;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		num = ss.selectOne("getcommentmaxnum"); 
		
		if (num != 0)
			num = num+1;
		else
			num = 1;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("COMMENT_NUM", num);
		map.put("COMMENT_ID", comment.getCOMMENT_ID());
		map.put("COMMENT_CONTENT", comment.getCOMMENT_CONTENT() );
		map.put("COMMENT_RE_REF", num);
		map.put("COMMENT_BOARD_NO", comment.getCOMMENT_BOARD_NO() );
		int cnt = ss.insert("insertcomment", map);
		ss.commit();
		ss.close();

		return (cnt > 0) ? true : false;
		
	}
	
	public int commentListCount(int num) {
		int x = 0;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		x = ss.selectOne("commentListCount",num);
		ss.close();
		return x;
	}
	
	public List getCommentList(int page, int num) {
			
		SqlSession ss = FactoryService.getFactory().openSession();
		List list = null;
		int startrow = (page - 1) * 10;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		map.put("COMMENT_BOARD_NO", num);
		list = ss.selectList("getCommentList", map);
		ss.close();
		return list;
	}
	
	public boolean isCommentWriter(int num, String id) {
		
		String ssresult="";
		
		SqlSession ss = FactoryService.getFactory().openSession();
		ssresult = ss.selectOne("isCommentWriter",num);
		ss.close();
		
		if (id.equals(ssresult)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean commentDelete(int num) {
		
		int result = 0;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		result = ss.delete("commentDelete",num);
		ss.commit();
		ss.close();
		
		return (result > 0) ? true : false;
	}
	
	public boolean commentLevDel(int num) {
		
		int result = 0;
		int result2= 0;//1일경우 최상위부모 혼자있으므로 삭제한다.
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		result2 = ss.selectOne("refcount",num);
		
		if(result2 == 1) {
			ss.delete("commentDelete",num);
			ss.commit();
			ss.close();
			return false;
		}
		
		result = ss.update("commentLevDel",num);
		
		ss.commit();
		ss.close();
		
		return (result > 0) ? true : false;
	}
	
	public boolean admincommentLevDel(int num) {
		
		int result = 0;
		int result2= 0;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		result2 = ss.selectOne("refcount",num);
		
		if(result2 == 1) {
			ss.delete("commentDelete",num);
			ss.commit();
			ss.close();
			return false;
		}
		
		result = ss.update("admincommentLevDel",num);
		
		ss.commit();
		ss.close();
		
		return (result > 0) ? true : false;
	}
	
	public void mothercheck(int numD) {
		
		int refcount=0;
		String admincheck="";
		SqlSession ss = FactoryService.getFactory().openSession();
		
		refcount = ss.selectOne("refcount",numD);
		
		if(refcount == 1) {
			admincheck = ss.selectOne("admincheck",numD);

			if (admincheck.equals("삭제된 댓글입니다") || admincheck.equals("관리자 권한에 의해 삭제된 댓글입니다.")) {
				ss.delete("commentDelete",numD);
				ss.commit();
				ss.close();
			} 
		}
		ss.close();
	}
	
	
	public boolean commentReply(CommentBean comment) {
		
		int num = 0;
		int result = 0;
		
		SqlSession ss = FactoryService.getFactory().openSession();
		
		num = ss.selectOne("getcommentmaxnum"); 
		
		if (num != 0)
			num = num+1;
		else
			num = 1;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("COMMENT_NUM", num);
		map.put("COMMENT_ID", comment.getCOMMENT_ID());
		map.put("COMMENT_CONTENT", comment.getCOMMENT_CONTENT() );
		map.put("COMMENT_RE_REF", comment.getCOMMENT_RE_REF());
		map.put("COMMENT_BOARD_NO", comment.getCOMMENT_BOARD_NO() );
		int cnt = ss.insert("replycomment", map);
		ss.commit();
		ss.close();

		return (cnt > 0) ? true : false;
		
		
		
	}

}
