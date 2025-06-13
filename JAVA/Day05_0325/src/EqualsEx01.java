/* 문자열 값 비교)
 * 1. String 문자열 내장 API클래스에 오버라이딩 된 equals()메소드를 가져와서 문자열 값 같다 다르다를 비교하면 객체주소가 달라도 
 * 문자열 값만 같다 다르다를 비교해서 문자열 내용값만 같으면 참, 다르면 거짓을 반환한다.
 * 
 * 2. 문자열 값 비교를 비교 연산자의  ==로 비교하면 문자열 값은 같아도 객체주소가 다르면 거짓을 반환하고 같으면 참을 반환한다. 결국 객체
 * 주소를 비교한다.
 * 
 * 가능하면 문자열 값 비교는 ==이 아닌 equals나 equalsIgnoreCase 사용
 */
public class EqualsEx01 {

	public static void main(String[] args) {
		
		String str01 = "1234"; // 새로운 객체주소를 생성하지 않고 문자열 상수를 가리킨다.
		String str02 = new String("1234"); // new 키워드로 새로운 객체주소 str02를 생성한다.
		// 즉 새로운 객체주소가 생성되고 결국 str01가 str02는 서로 다른 객체주소를 가진다.
		
		System.out.printf("\"abc\" == \"abc\" ? %b%n", "abc" == "abc"); // 같은 문자열 상수를 가리킨다. 즉 같은 주소이다.
		// 결국 == 문자열 비교는 같은 주소이면 참
		
		System.out.printf("str01 ==  \"1234\" ? %b\n", str01 == "1234" ); // 같은 주소이다. true
		System.out.printf("str02 == \"1234\" ? %b\n", str02 == "1234"); // str02는 new키워드로 새로운 객체(주소)를 생성함.
		//결국 서로 다른 주소라서 false
	
		System.out.printf("str01.equals(\"1234\") ? %b\n", str01.equals("1234")); // equals()메소는 주소 상관없이 그 문자열 값만 비교
		//해서 같으면 참, 다르면 거짓. 결국 문자열 값이 같아서 true, 객체 주소값은 같다.
		System.out.printf("str02.equals(\"1234\") ? %b\n" , str02.equals("1234")); // 객체주소는 다르지만 문자열 내용값이 같아서 true
		System.out.printf("str01.equals(str02) ? %b\n" , str01.equals(str02)); // true, str01과 str02는 객체주소는 다르지만 문자열 내용값이 같아서 참
		
		String str03 = new String("abc");
		System.out.printf("str03.equals(\"ABC\") ? %b\n", str03.equals("ABC")); // false, equals()메소드는 영문 대소문자는 구분
		System.out.println(str03.equalsIgnoreCase("ABC")); // true, equalsIgnoreCase() 내장 메소드는 영문 대소문자를 무시하고 비교함.
	
		/* 결론적으로 문자열 값만 같다/ 다르다 비교는 ==를 사용하지 않고 equals()메소드를 사용한다. */
		
		
		
	}

}
