package d0617_03;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private Service service;
	
	public Controller() {
		System.out.println("Controller생성자 생성!!");
	}

	public void exec() {
		System.out.println("controller exec()함수 실행!!");
		service.exec();
	}
}