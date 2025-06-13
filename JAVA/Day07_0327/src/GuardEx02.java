/* 레이블 통과)
 *  switch ~ case 다중 조건문에서 레이블에 패턴이 사용되면 기본적으로 다음 레이블로 통과가 금지된다. 하지만 다음이 default 문이라면 통과가 가능하다.
 *  화살표 연산 ->이 사용되면 무조건 다음 통과가 금지된다.
 */
public class GuardEx02 {
	private static void method01(Object obj) {
		switch(obj) {
			case String s : // 레이블에 패턴 사용(참조타입 사용)
				System.out.println("String : " + s);
				break; // 생략하면 컴파일 에러가 발생(다음 case 레이블 통과 금지)
			case Integer i :
				System.out.println("Integer i : " + i); //단, 다음이 default문이면 레이블 통과 가능하다.
			case null, default :
				System.out.println("null or unknown");
		}
	}
	private static void method02(Object obj) {
		switch(obj) {
			case String s -> System.out.println("String s : " + s); //레이블 패턴이 사용되면 화살표 연산자 ->가 사용되면 다음
			// case 레이블 통과 금지
			case Integer i -> System.out.println("Integer i = " + i);
			case null, default -> System.out.println("null or unknown");
		}
	}
	public static void main(String[] args) {
		method01("seoul");
		System.out.println(); //개행, 줄바꿈
		method01(7);
		System.out.println();
		method02(7);
	}

}
