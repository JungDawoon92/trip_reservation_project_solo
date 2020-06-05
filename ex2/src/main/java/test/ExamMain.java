package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ExamMain {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/test/test2.xml");
		ExamTest examTest = (ExamTest) context.getBean("exam");
		
		examTest.getMessage();
				

	}
}
