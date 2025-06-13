
/* 생성자 참조를 위한 소스 */

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferenceExample {
	public static void main(String[] args) {

		/* Function 내장 함수형 인터페이스 특징)
		 *  1. 인자값도 있고, 리턴값도 있다. 인자값을 리턴값으로 타입변환을 해준다.
		 */
		Function<Integer,Member2> function01 = Member2 :: new;//생성자 참조
		Member2 member01 = function01.apply(7);//함수형 인터페이스의 추상메서드인 apply(7)과 동일한 타입과 인자개수를 가진
		//Member2클래스에 정의된 오버로딩 된 생성자를 호출한다.
		
		BiFunction<String,Integer,Member2> function02 = Member2 :: new;
		Member2 member02 = function02.apply("홍길동", 25);
	}
}
