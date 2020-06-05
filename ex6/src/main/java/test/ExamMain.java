package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ExamMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/java/test/test6.xml");
		JdbcService service1 = (JdbcService) context.getBean("service");
		JdbcService service2 = (JdbcService) context.getBean("service");
		
		System.out.println("service1 : " + service1);
		System.out.println("service2 : " + service2);
		
		service1.serviceTest();

	}
}
