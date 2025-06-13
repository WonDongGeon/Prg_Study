package 람다식;

/* MyFunInterface2 함수형 인터페이스를 활용해서 람다식을 구현한 소스예) */
public class MyFunInterfaceExample2 {

	public static void main(String[] args) {
		MyFunInterface2 fi2;
		fi2 = (var data) -> {
			int result = data * 7;
			System.out.println("7 x 7 = " + result);
		};
		fi2.method(7);
		
		fi2 = x -> System.out.println("7 x 7 = " + (x + 7));
		fi2.method(7);
	}
}
