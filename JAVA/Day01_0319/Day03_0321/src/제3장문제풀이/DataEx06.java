package 제3장문제풀이;
 
//6번 문제풀이 코드 
public class DataEx06 {

	public static void main(String[] args) {
		/* 6번문제는 에러가 발생한다. 에러가 나지 않도록 수정해보고,
		 * 에러가 나는 이유에 대해서 주석문을 달아본다. 그리고
		 * 덧셈한 결과값은 byte형 범위를 벗어난다. 벗어난 값도 출력해보고 소스를 수정
		 * 해서 정상적인 덧셈 결과값도 출력해 본다. */
		
		byte b = 127; 
		byte c = 126; 
		byte d = (byte)(b + c); // 자바는 덧셈연산을 수행할 때 가장 효율적이고 
		// 빠르고 갑 손실 위험이 없는 4바이트 int타입으로 byte형이 자동형변환이 됨. 
		// 이것이 자동산술법이라고도 한다. 결국 byte+byte-> int+int=int가 된다.
		// 덧셈 결과값은 4바이트 크기인 int타입이 된다.
		// 이것을 1바이트 크기에 대입할려고 하니 컴파일 에러가 발생하는 것이다. 그러므로 명시적인 캐스팅 형변환 연산자를 사용해야 한다.
		System.out.printf("%d+%d = %d\n", b,c,d); //덧셈 결과값은 byte형 범위를 벗어나서 이상한 값이 출력됨.
		
		int result = b + c;
		System.out.printf("%d+%d = %d\n", b,c,result); // 덧셈 결과값이 int범위 안에 있어서 정상적인 값이 출력된다.
		
	}

}
