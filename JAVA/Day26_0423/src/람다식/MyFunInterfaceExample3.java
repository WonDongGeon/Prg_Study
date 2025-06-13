package 람다식;

/* MyFunInterface3 함수형 인터페이스를 사용해서 람다식을 구현한 소스 예) */
public class MyFunInterfaceExample3 {
	public static int sum(int a, int b) {
		return a - b;
	}
	public static void main(String[] args) {
		
		MyFunInterface3 fi3;
		
		fi3 = (a,b) -> {
			int result = a + b;
			return result;
		};
		System.out.println("7 + 7 = " + fi3.method(7, 7));
		
		fi3 = (a,b) -> a * b; //return과 {}를 생략함.
		System.out.println("7 * 7 = " + fi3.method(7, 7));
		
		fi3 = (x,y) -> sum(x,y);
		System.out.println("10 - 5 = " + fi3.method(10, 5));
	}
	
}
