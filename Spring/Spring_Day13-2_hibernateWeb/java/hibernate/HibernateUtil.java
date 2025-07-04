package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	//하이브네이트에서 datasource역할은 sessionFactory가 그 역할을 함
	public static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration()
					.configure()
					.buildSessionFactory();
		}catch (Throwable e) {
			System.out.println("sessionFactory fail!!");
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static final ThreadLocal<Session> sessions = new ThreadLocal<Session>();
	
	
	//static final로 선언된 멤버변수는 get형식으로 객체 생성(new(x) -> getxxx())
	public static Session getCurrentSession() throws HibernateException {
		Session s = sessions.get();
		if(s==null) {
			s=sessionFactory.openSession();
			sessions.set(s);
		}
		return s;
	}
	
	//static final로 선언된 멤버변수는 get형식으로 객체 생성(new(x) -> getxxx())
	//sessionFactory부터 하나의 세션을 얻는 작업
	public static Session closeSession() throws HibernateException {
		Session s = sessions.get();
		if(s==null) {
			s=sessionFactory.openSession();
			sessions.set(s);
		}
		return s;
	}
}
