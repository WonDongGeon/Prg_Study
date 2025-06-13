/* switch ~ case에서 case 레이블 작성 순서)
 *  레이블이 패턴인 경우 좁은 범위의 패턴을 먼저 기술하고, 넓은 범위 패턴을 나중에 기술한다. 부모 자식 관계나 부모 인터페이스를 구현한 자손 클래스
 *  클래스인 경우 부모는 자손보다 더 넓은 범위를 가진다. 그러므로 자손을 먼저 기술하고 부모 클래스나 인터페이스는 나중에 기술한다.
 * 
 */
public class GuardEx03 {
	private static void method01(Integer obj) { // 오토박싱, 업캐스팅은 적용 안됨.
		switch(obj) { // 표현식이 참조(레퍼런스 : Wrapper)냐 아니냐에서 레이블에 패턴이 사용됐다는 것을 판단할 수 있음
			case 0 -> System.out.println(0); // 자바 5에서 추가된 오토언박싱(참조 레퍼 Integer  타입이 기본 int타입으로 자동형변환) 
			//레이블이 패턴을 사용한 경우 좁은 범위의 패턴을 먼저 기술하고, 넓은 범위의 패턴을 나중에 기술한다.
			case Integer  i when  i > 0 -> System.out.println("양수이다.");
			case Integer i -> System.out.println("음수이다.");
		}
		
	}//method01
	private static class A{ // extends Object가 생략됨. 즉 최고 조상 Oject클래스로 부터 확장 상속(extends)
		// 정적 부모클래스 A
	}
	private static class B extends A {
		// 범위가 좁은 자손클래스 B
	}
	private static void method02(Object obj) { // 업캐스팅 -> A클래스의 부모클래스가 Object이기 떄문에
		switch(obj) { // 무조건 자손 클래스를 먼저 기술해야됨.
			case B b -> System.out.println("obj is B type "); //레이블 패턴이 사용되면 부모가 자손보다 항상 더 넓은 범위를 가진다.
			// 그러므로 좁은 범위의 자손 B를 먼저 기술 / 그러지 않으면 오류가 발생한다.
			case A a -> System.out.println("obj is A type");
			case null, default -> System.out.println("obj is null or unknown type");
		}
	}
	public static void main(String[] args) {
		method01(10); method01(-10); method02(new A());
	}

}
