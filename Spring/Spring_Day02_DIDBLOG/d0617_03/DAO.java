package d0617_03;

import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	public DAO() {
		System.out.println("DAO생성자 생성!!");
	}

	public void exec() {
		System.out.println("dao exec()함수 호출!!");		
	}

}