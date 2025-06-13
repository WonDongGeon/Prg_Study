package net.daum.dto;

public class CustomerDTO { //데이터 저장빈 클래스

	private int cus_no; //고객 번호
	private String cus_name; //고객이름
	private String cus_phone; //고객폰번호
	private String cus_email; //고객이메일
	private String cus_date; //등록일자
	
	public int getCus_no() {
		return cus_no;
	}
	public void setCus_no(int cus_no) {
		this.cus_no = cus_no;
	}
	
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	
	public String getCus_phone() {
		return cus_phone;
	}
	public void setCus_phone(String cus_phone) {
		this.cus_phone = cus_phone;
	}
	
	public String getCus_email() {
		return cus_email;
	}
	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}
	
	public String getCus_date() {
		return cus_date;
	}
	public void setCus_date(String cus_date) {
		this.cus_date = cus_date;
	}
}
