/* 메서드 리턴타입을 참조형인 경우
 * 
 */
class Data13 {
	int x;
}
public class BasicRef13 {
	public static void main(String[] args) {
		Data13 d = new Data13();
		d.x = 10;
		
		Data13 d2 = copy(d); // d와 d2는 서로 다른 객체 주소를 가짐 왜냐하면 d2에 저장된 객체 주소는 반환된 값 tmp임.
		System.out.println("d.x = " +d.x);
		System.out.println("d2.x = " + d2.x);
	}
	static Data13 copy(Data13 d) { //메서드 반한타입이 Data13 클래스형 참조타입
		Data13 tmp = new Data13(); // 새로운 객체를 생성하면 tmp에는 새로운 주소가 할당된다.
		tmp.x = d.x;  //tmp와 d는 서로 다른 객체 주소를 가지고, 값만 복사 된다.
		
		return tmp; //tmp 객체 주소가 반환
	}
}
