class Car09 {
	String color; //차 색상
	String gearType; //변속기 종류 : auto(자동), manual(수동)
	int door;//문의 개수
	
	Car09() {
		this("blue", "auto", 4);
	} //기본 생성자 정의
	
	Car09(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	} //생성자 오버로딩
	public void pr() {
		System.out.println("차 색상 : " + color + ", 변속기 종류 : " + gearType + ", 문의 개수 : " + door);
	}
}
public class ConsEx09 {

	public static void main(String[] args) {
		Car09 c01 = new Car09();
		/* 문제01) 더 나은 자바 객체지향 프로그래밍 코드를 할려면 c01.color = "white"; c01.gearType ="auto"; c01.door = 4;
		 * 객체명.속성으로 접근하는 것은 보안상 위험하고 올바른 객체지향 자바 코드가 아니다.
		 * 
		 * 그러니 기본 생성자에 this(); 문법으로 오버로딩된 생성자를 호출해서 멤버변수 초기화를 하고, 사용자 정의 메서드 pr()를 만들어서
		 * 초기화 된 멤버변수 값을 출력되게 만들어보자
		 */
		c01.pr();
	}

}
