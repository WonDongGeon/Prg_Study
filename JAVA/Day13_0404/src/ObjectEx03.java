/* 클래스와 객체 관계인 객체지향 프로그래밍에 관한 소스 */
class Tv03 { //Tv03 class 설계
	String color; //Tv 색상
	boolean power; //전원상태(on/off)
	int channel; //채널번호
	
	/* 클래스 소속 멤버변수인 속성 기본값)
	 * 		멤버변수만 선언하고 초기화를 하지 않으면 속성(멤버변수)은 기본값으로 알아서 초기화가 된다. 초기값에 대해서 알아본다.
	 * 		int 타입 속성은 0으로 초기화
	 * 		boolean 타입 멤버변수는 false 기본값으로 초기화
	 * 		String을 참조타입변수를 선언만하고 명시적인 코드로 초기화 하지 않으면 null기본값으로 초기화가 된다.
	 * 		double 실수타입 속성은 0.0 기본값으로 초기화
	 * 
	 */
	// 3개의 Tv03클래스 메서드 정의
	 void power() {
		 power = !power; // !false => true
	 }
	 void channelUP() {
		 ++channel; //채널 선행증가
	 }
	 void channelDown() {
		 --channel; //채널 선행감소
	 }
} // Tv03 class
public class ObjectEx03 {
	public static void main(String[] args) {
		Tv03 tv; //객체 주소가 저장안된 참조변수
		tv = new Tv03(); //객체 주소가 저장된 참조변수 tv(객체명)
		
		tv.channel = 7;
		tv.channelDown();
		System.out.println("채널번호 = " + tv.channel);
		tv.power();
		System.out.println("Tv on/off = " + tv.power);
	}
}
