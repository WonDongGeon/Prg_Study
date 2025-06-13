/*	생성자 특징)
 * 1. 생성자 이름은 클래스 이름과 같게 정의한다. new 클래스명();에 의해서 생성자를 호출한다.
 * 2. 생성자의 주된 기능은 클래스 소속 멤버변수중 인스턴스 변수 초기화 기능이다.
 */
class MyDate21 {
	private int year; //년
	private int month; //월
	private int day; //일 3개의 속성정의(클래스 소속의 멤버변수 중 인스턴스 변수가 된다.)
	
	public MyDate21() { //전달인자와 자료형이 없는 기본 생성자 정의
		year = 2025; month = 4; day = 7; // 생성자의 주된 기능인 인스턴스 변수 초기화 기능이다.
		System.out.println("기본 생성자 호출");
	}
	public void pr() {
		System.out.println(year + " 년 " + month + "월 " + day +"일 ");
	}
}
public class ConsEx01 {
	public static void main(String[] args) {
 		MyDate21 d = new MyDate21(); // new 클래스명();에 이해서 10번줄 기본 생성자를 호출함.
 		d.pr(); // 객체명.메서드()에 의해서 해당 메서드를 호출해서 초기화 한 인스턴스 변수값을 출력
		
		
	}
}
