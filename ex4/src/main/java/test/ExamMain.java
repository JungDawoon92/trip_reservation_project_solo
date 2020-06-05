package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ExamMain {

	public static void main(String[] args) {

		ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/java/test/test4.xml");
		JdbcService service = (JdbcService) context.getBean("service");
		
		service.serviceTest();

	}
}
