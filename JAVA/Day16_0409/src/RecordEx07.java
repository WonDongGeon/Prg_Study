/* java 14버전에서 추가된 레코드 타입
 * 
 */
record Member(String id, String name, int age) {
	/* 자바 14버전에서 추가된 레코드 선언함. id, name, age필드(속성명, 멤버변수명 : 인스턴스 변수명)에
	
	 * private final String id, private final String name, private final int age 상수로 변경되고 private final이 자동추가된다.
	
	 * 변수개수만큼 생성자가 오버로딩이 되고, 필드 이름과 같은 getter()메서드(id(), name(), age())가 자동으로 추가된다.
	 
	 * 그리고 동등 비교를 위한 hashCode(), equals()메서드가 오버라이딩 되면 자동추가된다. 
	 * 또한 문자열 출력을 위해서 toString()메서드가 오버라이딩이 되면서 자동 추가된다.
	 */
}
public class RecordEx07 {
	public static void main(String[] args) {
		Member member = new Member("kkkkk", "홍길동", 26); //오버로딩 된 생성자를 호출하면서 초기화
		
		System.out.println("아이디 : " + member.id()); //필드명과 같은 getter()메서드 자동추가
		System.out.println("회원이름 : " + member.name()); 
		System.out.println("나이 : " + member.age());
		
		System.out.println("\n==================\n");
		
		Member m01 = new Member("spring", "벚꽃", 28);
		Member m02 = new Member("spring", "벚꽃", 28);
	
		System.out.println("m01.equals(m02) : " + m01.equals(m02)); //동등비교 equals() 메서드 오버라이딩을 해서 자동추가
	}
}
