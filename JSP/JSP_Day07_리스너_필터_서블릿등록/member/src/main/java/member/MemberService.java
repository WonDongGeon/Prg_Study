package member;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class MemberService {
	MemberDAO dao;
	
	/*
	public MemberService() {
		System.out.println("MemberService생성!!!!!");
		dao=new MemberDAO();
	}
	*/
	
	public MemberService(ServletContext context) {
		System.out.println("MemberService생성!!!!!");
		//dao=new MemberDAO();
		dao=new MemberDAO(context);
	}

	public MemberService(ServletConfig config) {
		dao=new MemberDAO(config);
	}

	public int save(Member member) {
		//password를 암호화, etc작업수행(가공)
		return dao.save(member);
	}
	
	public boolean loginconfirm(String id,String password) {
		Member dbmember=dao.findById(id);
		if(id.equals(dbmember.getId()) 
				&& password.equals(dbmember.getPassword())) {
		return true;	
		}
		return false;
	}

}
