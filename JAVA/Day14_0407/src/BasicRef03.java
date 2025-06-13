/*	레퍼런스 타입 변수가 객체주소를 공유해도 new키워드로 새로운 객체를 생성하면 다른 주소값을 가진다. 이런 경우는 값도 공유 못한다.
 */
class MyDate03{
	int year=2023;
	int month = 10;
	int day = 31;
}
public class BasicRef03 {
	public static void main(String[] args) {
		MyDate03 d = new MyDate03();
		MyDate03 t = d; //d객체 주소가 t참조변수에 대입되어서 t,d는 같은 d 객체주소를 가리킨다.
	
		t= new MyDate03(); //새로운 객체를 생성하면 다른 주소값이 저장되어서 d와 다른 주소를 가진다. 값도 공유 못한다.
		t.year = 2024; t.month=11; t.day = 10;
		
		System.out.println(d.year+"년 "+d.month+ "월 " + d.day + "일" ); //2023년 10월 31일
		System.out.println(t.year+"년 "+t.month+ "월 " + t.day + "일" ); //다른 년월일이 출력, 2024년 11월 10일
	}
}
