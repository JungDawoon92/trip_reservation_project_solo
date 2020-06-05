package test;

public class ExamDao {
	private String msg;
	
	public ExamDao() {
		
	}
	
	public ExamDao(String msg) {
		this.msg = msg;
	}
	
	public void printMessage() {
		System.out.println("ExamDao.msg : " + msg);
	}

}
