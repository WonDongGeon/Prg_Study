package net.daum.dto;

public class MemberDTO { //회원 관리 데이터 저장빈(bean) 클래스
	private String mem_id;//회원 아이디
	private String mem_pwd; //비번
	private String mem_name;//회원이름
	private String mem_addr; //주소
	private String mem_phone; //폰번호
	
	//기본 생성자 생략
	
	public String getMem_id() { //값반환 메서드(getter 메서드)
		return mem_id;
	}
	public void setMem_id(String mem_id) { //값저장 메서드(setter 메서드)
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

}
