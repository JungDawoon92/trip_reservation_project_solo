package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ExamMain {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/java/test/test5.xml");
		
		IbatisService service = (IbatisService) context.getBean("service");
		
		service.daoTest();

	}
}
