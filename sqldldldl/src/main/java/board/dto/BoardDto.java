package board.dto;

public class BoardDto {
	private int seq;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private int hitcount;
	private String password;
	public int getSeq() {
		return seq;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getWriter() {
		return writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public int getHitcount() {
		return hitcount;
	}
	public String getPassword() {
		return password;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "BoardDto [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regdate=" + regdate + ", hitcount=" + hitcount + ", password=" + password + "]";
	}
	
}
