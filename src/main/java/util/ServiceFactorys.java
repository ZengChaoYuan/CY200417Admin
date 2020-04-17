package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceFactorys {
 
	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"application.xml");
	
	public static <T> T getService(Class<T> c) {
		return context.getBean(c);
	}
	
}
