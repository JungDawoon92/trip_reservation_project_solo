package client.comment.board.db;

import java.sql.Date;

public class BoardBean {
	private int BOARD_NUM;
	private String BOARD_ID;
	private String BOARD_SUBJECT;
	private String BOARD_CONTENT;
	private String BOARD_FILE;
	private int BOARD_READCOUNT;
	private Date BOARD_DATE;

	public int getBOARD_NUM() {
		return BOARD_NUM;
	}

	public void setBOARD_NUM(int board_num) {
		BOARD_NUM = board_num;
	}

	public String getBOARD_ID() {
		return BOARD_ID;
	}

	public void setBOARD_ID(String board_id) {
		BOARD_ID = board_id;
	}

	public String getBOARD_SUBJECT() {
		return BOARD_SUBJECT;
	}

	public void setBOARD_SUBJECT(String board_subject) {
		BOARD_SUBJECT = board_subject;
	}

	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}

	public void setBOARD_CONTENT(String board_content) {
		BOARD_CONTENT = board_content;
	}

	public String getBOARD_FILE() {
		return BOARD_FILE;
	}

	public void setBOARD_FILE(String board_file) {
		BOARD_FILE = board_file;
	}

	public int getBOARD_READCOUNT() {
		return BOARD_READCOUNT;
	}

	public void setBOARD_READCOUNT(int board_readcount) {
		BOARD_READCOUNT = board_readcount;
	}

	public Date getBOARD_DATE() {
		return BOARD_DATE;
	}

	public void setBOARD_DATE(Date board_date) {
		BOARD_DATE = board_date;
	}
}