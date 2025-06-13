/* 자바의 산술(수학) 연산자 종류
 * +(덧셈), -(뺄셈), *(곱셈), /(나눗셈) 정수 숫자를 나눗셈 하면 몫만 구한다. 실수 숫자를 나눗셈 하면 몫과 나머지를 함께 구한다.)
 * %(나머지)
 */
public class WeekEx02 {

	public static void main(String[] args) {
		
		int a = 10, b = 3, result = 0; // 3개의 변수를 한줄로 선언하고 초기화
		
		result = a + b;
		System.out.printf("%d + %d = %d\n", a, b, result);
		
		System.out.println(a+"-"+b+"="+(a-b));
		
		result = a*b;
		System.out.println(a+"*"+b+"="+result);
		
		result=a/b; // 정수 숫자를 나눗셈 하면 몫만 구함.
		System.out.println(a+"/"+b+"="+result);
		
		
		result=a/b; // 정수 숫자를 나눗셈 하면 몫만 구함.
		System.out.println(a+"/"+b+"="+result);
		
		result=a%b;
		System.out.println(a+"%"+b+"="+result);
		
	}

}
