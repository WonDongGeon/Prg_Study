//열거 타입을 사용한 소스

import java.util.Calendar;
public class ObjectArrEx08 {
	public static void main(String[] args) {
	
		Week today = null; //Week 열거 타입도 참조 타입이어서 today라는 참조변수 선언 가능. null로 대입
		
		Calendar cal = Calendar.getInstance();
		/* java.util 패키지에 있는 내장 추상클래스 Calendar는 년월일 시분초값 등을 반환한다.
		 * 컴퓨터의 날짜와 시간 정보를 가진다.
		 */
		int week = cal.get(Calendar.DAY_OF_WEEK); // 일요일은 1, ....., 토요일은 7까지 정수숫자 반환
		
		System.out.println("반환된 week값 : " + week);
		
		switch(week) {
		case 1: 
			today = Week.SUNDAY; //열거 타입 변수 today에 열거 상수 대입 가능하다. 열거타입이름. 열거상수 형태로 작성된다.
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUSEDAY;
			break;
		case 4:
			today = Week.WEDNESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		} //switch ~ case
		
		System.out.println("오늘 요일은 " + today);
		
		if(today == Week.SUNDAY) { // 열거타입 변수 today가 특정 열거 상수인지 비교할 때는 ==(같다 비교연산) 또는 
		// != (같지 않다 비교 연산)을 사용한다.
			System.out.println("일요일에는 축구를 합니다.");
		} else {
			System.out.println("자바 열공합니다.");
		}
	}
}
