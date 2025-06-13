/* 객체 배열 */
class Tv06 { //Tv03 class 설계
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
} // Tv06 class
public class ObjectEx06 {
	public static void main(String[] args) {
		Tv06[] tvArr = new Tv06[3]; //배열 크기 3인 객체배열 tvArr생성
		
		//Tv06객체를 생성해서 tvArr 객체 배열의 각 요소에 저장
		for(int i = 0; i<tvArr.length; i++) {
			tvArr[i] = new Tv06();
			tvArr[i].channel = i+10;
		}
		//채널번호 1증가하고 출력
		for(int i = 0; i < tvArr.length; i++) {
			tvArr[i].channelUP(); //채널번호 1증가
			System.out.printf("tvArr[%d].channel = %d%n", i, tvArr[i].channel); //11,12,13
		}
	}
}
