package school;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		// 하이버네이트 :JPA
		//이전 데이터베이스에서는 테이블 만들어했음.
		//하이버네이트는 테이블을 객체로 생성하면 자동으로 생성(@Entity)
		//hibernate.cfg.xml : db설정, 테이블 설정파일연결(member.xml)
		//member.xml :  테이블 명세서
		
		//1)설정파일 불러오기(등록하기/Registry)
		StandardServiceRegistry standardServiceRegistry
		=new StandardServiceRegistryBuilder()
		.configure("school/hibernate.cfg.xml")
		.build();
		
		//2)등록된 파일을 정보데이터에 저장(MetaData)
		Metadata metadata
		=new MetadataSources(standardServiceRegistry)
		.getMetadataBuilder()
		.build();
		
		//3)SessionFactory(연결설정 공장(bean의 집합))
		SessionFactory sessionFactory
		=metadata.getSessionFactoryBuilder().build();
		
		//4)3)으로부터 Session획득(연결)
		Session session
		=sessionFactory.openSession();
		
		//5)트랜잭션으로 처리(여러작업을 처리하고 중간에 에러가 발생하면 중단)
		session.beginTransaction();
		//Transaction tx=session.beginTransaction();
		//6)main함수를 실행(테이블이 자동으로 생성되게 됨)
		//7)sql문을 실행하게 됩니다.(sql문 없이 입력, 출력, 수정, 삭제가 가능)
		//입력
		
		Student student=new Student();
		student.setSid("25010122");
		student.setName("홍길동2");
		student.setHp("010-1111-2222");
		session.save(student);
		session.getTransaction().commit(); //tx.commit();		
		
		/*
		for(int i=1;i<50;i++) {
			MemberEntity member=new MemberEntity();
			member.setId("test"+i);
			member.setPassword("111"+i);
			session.save(member);
		}
		session.getTransaction().commit();

		*/
		
		//전체출력
		/*
		List<MemberEntity> list=session
				.createCriteria(MemberEntity.class).list();
		
		for(MemberEntity member:list) {
			System.out.println(member);
		}
		System.out.println(list);		
		*/
		
		//선택출력
		/*
		MemberEntity member=new MemberEntity();
		member=session.load(MemberEntity.class,"test1");
		System.out.println(member);
		*/
		
		//수정, 삭제는 이미 저장된 내용을 변경하는 사항
		//session.get함수를 통해서 데이터를 획득, 획득한 객체에 set함수를 실행
		/*
		MemberEntity member=session.get(MemberEntity.class, "test1");
		if(member!=null) {
			member.setPassword("0000");
		}
		session.getTransaction().commit();
		System.out.println(session.load(MemberEntity.class,"test1"));
		*/
		
		//삭제
		/*
		Student member=session.get(Student.class, "test1");
		if(member!=null) {
			session.delete(member);
		}
		session.getTransaction().commit();
		System.out.println(session
				.createCriteria(Student.class).list());
		*/
		
		
		
		//건들지말것		
		session.close();
	}

}