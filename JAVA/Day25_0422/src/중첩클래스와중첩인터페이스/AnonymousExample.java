package 중첩클래스와중첩인터페이스;

public class AnonymousExample {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.wake(); //익명객체 필드 사용
		anony.method(); //익명객체 지역변수 사용
		
		//익명객체 매개값으로 사용
		anony.method02 (
			new Person() {
				void study() {
					System.out.println("공부합니다.");
				}

				@Override
				void wake() {
					System.out.println("8시에 일어납니다.");
					study();
				}
			}//AnonymousExample$1.class
		);
	}
}
