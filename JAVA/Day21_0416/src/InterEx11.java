/* java.util패키지에 있는 내장 추상클래스인 Calendar는 컴퓨터시스템의 년월일 시분초 값을 반환해 준다.
 * 
 */

import java.util.Calendar;
public class InterEx11 {
	public static void main(String[] args) {
		Calendar cal =Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR); //년도값
		int month = cal.get(Calendar.MONTH); //월값, +1을 하는 이유는 1월이 0으로 반환되기 때문이다.
		int date = cal.get(Calendar.DATE); //일값
		int hour = cal.get(Calendar.HOUR_OF_DAY); //24시간 값
		int minute = cal.get(Calendar.MINUTE); //분값
		int second = cal.get(Calendar.SECOND); //초값
		
		System.out.println(year + "년 " + month + "월 " + date + "일 ");
		System.out.println(hour + "시 " + minute + "분 " + second + "초 ");
	}

}
