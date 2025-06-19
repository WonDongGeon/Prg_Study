package d0617_02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//Controller를 실행
		ApplicationContext app
		=new ClassPathXmlApplicationContext("d0617_02/setting.xml");
		Controller controller=(Controller)app.getBean("controller");
		controller.exec();
	}

}