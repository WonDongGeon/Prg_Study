package d0617_02;

import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Service {
	private DAO dao;
	
	public Service() {
		System.out.println("Service생성자 생성!!");
	}
	
	public void exec(){
		System.out.println("service에 exec 함수 실행!!!");
		dao.exec();
	}
}