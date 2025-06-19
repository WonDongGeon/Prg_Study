package d0617_03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Main.java - Controller.java - Service.java - DAO.java
public class Main {

	public static void main(String[] args) {
		ApplicationContext app
		=new ClassPathXmlApplicationContext("d0617_03/setting.xml");
		Controller controller=(Controller)app.getBean("controller");
		
		controller.exec();

	}

}