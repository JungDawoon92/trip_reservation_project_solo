package client.comment.comment.db;

import java.sql.Date;

public class CommentBean {
	private int COMMENT_NUM;
	private String COMMENT_ID;
	private String COMMENT_PW;
	private String COMMENT_CONTENT;
	private int COMMENT_RE_REF;
	private int COMMENT_RE_LEV;
	private int COMMENT_BOARD_NO;
	private Date COMMENT_DATE;
	
	public int getCOMMENT_NUM() {
		return COMMENT_NUM;
	}
	public void setCOMMENT_NUM(int comment_num) {
		COMMENT_NUM = comment_num;
	}
	public String getCOMMENT_ID() {
		return COMMENT_ID;
	}
	public void setCOMMENT_ID(String comment_id) {
		COMMENT_ID = comment_id;
	}
	public String getCOMMENT_PW() {
		return COMMENT_PW;
	}
	public void setCOMMENT_PW(String comment_pw) {
		COMMENT_PW = comment_pw;
	}
	public String getCOMMENT_CONTENT() {
		return COMMENT_CONTENT;
	}
	public void setCOMMENT_CONTENT(String comment_content) {
		COMMENT_CONTENT = comment_content;
	}
	public int getCOMMENT_RE_REF() {
		return COMMENT_RE_REF;
	}
	public void setCOMMENT_RE_REF(int comment_re_ref) {
		COMMENT_RE_REF = comment_re_ref;
	}
	public int getCOMMENT_RE_LEV() {
		return COMMENT_RE_LEV;
	}
	public void setCOMMENT_RE_LEV(int comment_re_lev) {
		COMMENT_RE_LEV = comment_re_lev;
	}
	public int getCOMMENT_BOARD_NO() {
		return COMMENT_BOARD_NO;
	}
	public void setCOMMENT_BOARD_NO(int comment_board_no) {
		COMMENT_BOARD_NO = comment_board_no;
	}
	public Date getCOMMENT_DATE() {
		return COMMENT_DATE;
	}
	public void setCOMMENT_DATE(Date comment_date) {
		COMMENT_DATE = comment_date;
	}

	
}
