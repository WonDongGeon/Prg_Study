/* 서로 다른 객체 주소 */
class Tv05 { //Tv03 class 설계
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
} // Tv05 class
public class ObjectEx05 {
	public static void main(String[] args) {
		Tv05 tv01 = new Tv05();
		Tv05 tv02 = new Tv05(); //tv01과 tv02는 서로 다른 객체주소를 가리킨다.
		
		tv02 = tv01; //tv01 객체주소가 tv02에 대입되고, 기존 tv02객체주소는 잃어 버린다. 결국 tv01과 tv02는 같은 객체주소를 가리킨다.
		// 가리키는 객체주소는 tv01주소가 된다.
		
		tv01.channel = 7; //채널번호를 0에서 7로 변경하면 tv02로 접근하는 채널번호도 같은 주소를 참조하기 때문에 7로 변경한다.
	
		System.out.println("tv01 = " + tv01.channel + "tv02 = " + tv02.channel);
	}
}
