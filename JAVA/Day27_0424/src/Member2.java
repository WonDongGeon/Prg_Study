
public class Member2 {//생성자 참조를 위한 클래스 설계

	private String name;
	private Integer  id;
	
	public Member2() {
		System.out.println("Member2() 실행");
	}
	
	public Member2(Integer id) {
		System.out.println("Member2(Integer id) 실행");
		this.id = id;
	}
	
	public Member2(String name, Integer id) {
		System.out.println("Member2(String name,Integer id) 실행");
		this.name=name;
		this.id=id;
	}
	
	public Integer getId() {
		return id;
	}
}
