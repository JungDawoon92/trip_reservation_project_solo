package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ExamMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/java/test/test7.xml");
		BeanTest beanTest1 = (BeanTest) context.getBean("beanTest");
		BeanTest beanTest2 = (BeanTest) context.getBean("beanTest");
		
		System.out.println("beanTest1 : " + beanTest1);
		System.out.println("beanTest2 : " + beanTest2);

	}
}
