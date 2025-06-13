package 람다식;

/* 람다식 매개변수 타입을 var로 정의 */
//함수형 인터페이스
@FunctionalInterface
interface Greeting {
	void greet(String name);
}
public class LambdaVarExample {

	public static void main(String[] args) {
		Greeting greeting = (var name) -> {
			System.out.println("Hello, " + name);
		};
		greeting.greet("홍길동");
		
		Greeting greeting2 = (name) -> System.out.println("안녕하세요. " + name);
		greeting2.greet("신사임당님");
	}

}
