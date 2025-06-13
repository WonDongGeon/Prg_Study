class Animal01{ // Animal01 class
	String name;
	int age; //클래스 소속의 속성 2개인 name, age정의, 이것을 클래스 소속의 멤버변수 중 객체 생성해서 접근하는 인스턴스 변수라고 한다.
}
class Thing{
	int x;
}
public class ObjectEx01 {

	public static void main(String[] args) {
		Animal01 a; //객체 주소가 저장 안된 참조변수
		a = new Animal01(); //new 키워드로 객체를 생성하면 객체주소가 저장된 참조변수 a => 객체명
		
		a.name = "홍길동"; //객체명.속성
		a.age = 26;
		
		System.out.println("이름 : " + a.name + ", 나이 : " + a.age);
		
		Animal01 b = new Animal01();
		b.name = "펭귄";
		b.age = 12;
		
		System.out.println("이름 : " + b.name + ", 나이 : " + b.age);
		
		/*<문제 1> b 객체를 하나 더 생성하여 b로 접근하도록 하고 이름은 "펭귄" 나이는 12를 저장한 후 출력하시오.
		 */
		Thing thing = new Thing();
		thing.x = 10;
		System.out.println("숫자 : " + thing.x);
	}
}
