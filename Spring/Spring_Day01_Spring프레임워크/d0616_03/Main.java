package d0616_03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//최종적으로 무엇을 할 것인가? Student객체를 이용하여 print를 실행할 것이다.
		ApplicationContext app = new ClassPathXmlApplicationContext("d0616_03/setting.xml");
		Student student = (Student)app.getBean("student");
		student.getPrint().print();
	}
}
