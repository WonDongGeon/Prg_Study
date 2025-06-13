package 중첩클래스;

public class AnonymousExample2 {

	public static void main(String[] args) {
		Anonymous2 anony = new Anonymous2();
		anony.field.turnOn(); //익명객체 필드 사용
		anony.method01(); //익명객체 로컬변수 사용
		
		
		anony.method02(new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("구글 유튜브를 켭니다.");
			}

			@Override
			public void turnOff() {
				System.out.println("구글 유튜브를 끕니다.");
			}
		}); //익명객체 매개값(익명클래스 => AnonymousExample2$1.class)
	}
}
