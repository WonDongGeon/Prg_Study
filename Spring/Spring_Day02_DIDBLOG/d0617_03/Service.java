package d0617_03;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private DAO dao;
	
	public Service() {
		System.out.println("Service 생성자 생성!!");
	}
	public void exec() {
		System.out.println("service exec()함수 실행!!");
		dao.exec();		
	}
}