package d0616_02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("d0616_02/setting.xml");
		Print print = (Print)app.getBean("print");
		print.print();
	}
}
