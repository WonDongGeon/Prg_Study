package member;

public class MemberService {
	MemberDAO dao;
	
	public MemberService() {
		System.out.println("MemberService생성!!!!!");
		dao=new MemberDAO();
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
