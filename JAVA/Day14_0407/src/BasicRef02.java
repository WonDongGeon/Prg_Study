/* 기본자료형과 레퍼런스 자료형의 차이점 01)
 *  기본자료형으로 선언된 변수는 값을 저장하고, 참조타입으로 선언된 변수에는 객체주소를 저장해서 주소값을 공유해서 값도 수정할 수 있다.
 * 
 */
class MyDate02{
	int year = 2024;
	int month = 12;
	int day = 20;
	
}
public class BasicRef02 {
	public static void main(String[] args) {
		int x =7;
		int y = x;
		MyDate02 d = new MyDate02();
		MyDate02 t = d; //  t 참조변수도 d와 함께 같은 객체주소를 가리킨다, 즉 주소값을 공유함.
		
		System.out.println("x=>" + x+ ", y=>"+y);
		System.out.println(d.year+"년 "+d.month+ "월 " + d.day + "일" );
		System.out.println(t.year+"년 "+t.month+ "월 " + t.day + "일" );
		
		y = 10;
		System.out.println("x=" + x + ", y = " + y); // 7, 10
		
		t.year = 2025; t.month = 4; t.day = 7;
		System.out.println(d.year+"년 "+d.month+ "월 " + d.day + "일" ); //t와 d는 주소값을 공유해서 값도 함께 변경한다.
		System.out.println(t.year+"년 "+t.month+ "월 " + t.day + "일" ); //2025년 4월 7일
	}
}
