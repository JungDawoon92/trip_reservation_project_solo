package client.comment.like.db;

public class BoardLikeBean {
	
	private String LIKE_ID;
	private int LIKE_BOARD_NUM;
	private int LIKE_COUNT;
	
	
	public String getLIKE_ID() {
		return LIKE_ID;
	}
	public void setLIKE_ID(String LIKE_ID) {
		this.LIKE_ID = LIKE_ID;
	}
	public int getLIKE_BOARD_NUM() {
		return LIKE_BOARD_NUM;
	}
	public void setLIKE_BOARD_NUM(int LIKE_BOARD_NUM) {
		this.LIKE_BOARD_NUM = LIKE_BOARD_NUM;
	}
	public int getLIKE_COUNT() {
		return LIKE_COUNT;
	}
	public void setLIKE_COUNT(int LIKE_COUNT) {
		this.LIKE_COUNT = LIKE_COUNT;
	
	}
}
