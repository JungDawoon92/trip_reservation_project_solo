package test;

public class ExamTest { // SingleTon 패턴
	private static ExamTest instance;
	
	public static ExamTest getInstance() {
		if(instance == null) {
			instance = new ExamTest();
		}
		return instance;
	}
	
	public ExamTest() {
		
	}
	
	public void getMessage() {
		System.out.println("ExamTest.getMessage().....");
	}
}
