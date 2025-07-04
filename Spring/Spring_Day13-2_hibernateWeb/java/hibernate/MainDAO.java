package hibernate;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class MainDAO {
	//db접속관련 객체과 존재했지만 하이브네이트에서는 별도로 설정하지 않고 처리할 예정
	public MainDAO() {
		System.out.println("dao 생성자 동작확인");
		//세션이 로드되는 확인
		//Session session=HibernateUtil.getCurrentSession();
		//System.out.println("=======session=======:"+session);
	}

	public void insert(Student student) {
		Session session=HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.save(student);//명령1
		//명령2
		//명령3 -오류가 발생할 경우 명령1, 명령2에서 입력한 데이터가 rollback처리
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}
}