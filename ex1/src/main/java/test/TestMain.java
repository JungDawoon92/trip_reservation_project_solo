package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestMain {
	/*
	 *@param args
	 */

	public static void main(String[] args) {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/test/test.xml");
		TestDao testDao = (TestDao) context.getBean("testDaoImp");
		
		System.out.println("START.....");
		testDao.printMessage();
		System.out.println("END......");
				
	}
}
