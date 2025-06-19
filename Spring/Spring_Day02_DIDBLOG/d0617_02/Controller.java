package d0617_02;

import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//WEB MVC Model : Controller.java -  Service.java - DAO.java
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Controller {
	private Service service;
	public Controller() {
		System.out.println("Controller생성자 생성!!");
	}
	
	public void exec(){
		System.out.println("controller에 exec 함수 실행!!!");
		service.exec();
	}
}