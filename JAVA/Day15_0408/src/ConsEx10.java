/* 생성자를 이용한 인스턴스(객체) 복사 */
class Car10 {
	String color;
	String gearType;
	int door;
	/* 클래스 소속 멤버변수를 명시적 초기화를 하지 않으면 자바는 다음과 같은 기본값으로 초기화를 한다.
	 * 참조타입 : null, boolean타입 : false, byte
	 *  byte, short, int = 0
	 *  long : 0L
	 *  flaot 0.0f
	 *  double : 0.0d or 0.0
	 */
	Car10() {
		this("white", "auto", 4);
	}
	Car10(Car10 c ) { //생성자를 이용한 인스턴스 복사 (즉 c와 car는 같은
		// 객체 주소를 가지고 값도 공유되니 c를 이용해 얻은 인스턴스 객체 값을
		// car2 객체에 대입함(값만 복사 car2와 객체 주소는 다름)
		color = c.color;
		gearType = c.gearType;
		door = c.door;
	}
	Car10(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	void print() {
		System.out.println("차 색상 : " + color + ", 변속기 종류 : " + gearType + ", 문 개수 : " + door);
	}
}
public class ConsEx10 {
	public static void main(String[] args) {
		Car10 car = new Car10();
		Car10 car2 = new Car10(car);
		car.print();
		car.door = 6;
		car.print();
		car2.print();
	}
}
