/* 캐스팅 형변환 연산자와 음의 정수를 이진수로 변환하는 예제
 *  
 */
public class WeekEx01 {

	public static void main(String[] args) {
		int i = 10;
		byte b = (byte)i; //(byte) 캐스팅 연산자를 사용해서 byte형으로 명시적인 형변환
		System.out.printf("[int -> byte] i =%d -> b=%d%n", i, b );

		i = 300;
		b =(byte)i; //300은 byte형 범위를 벗어나서 자료손실이 발생한다.
		System.out.printf("[int -> byte] i=%d -.> b=%d\n", i , b);
		
		// 음의 정수를 이진수로 변환(2진수 정수 출력형태는 자바에서 없다)
		i=-2;
		System.out.println("10진 음의정수값을 이진문자열로 변환 =" + Integer.toBinaryString(i));
	
		/* 자바의 자동산술법 이란?
		 * 자바는 작은 크기의 타입에서 큰 크기의 타입으로는 암시적인 자동형 변환을 해준다. 이유는 컴파일러가 값 손실 위험이 없기 때문에
		 * 캐스팅 연산자를 사용하지 않아도 자동형 변환한다.
		 * 
		 * byte(1 바이트) -> short(2바이트). char(2바이트) -> int(4바이트) -> long(8바이트) -> float(4바이트) -> double(8바이트)
		 * 결국 왼쪽에서 오른쪽으로 크기가 더 큰 타입으로 자동산술에 의해서 형변환을 해서 연산 수행을 한다.
		 * 예를 들면, 7+7,0은 int+double이다. 자동산술법에 의해서 double+double로 형변환 되어서 7.0+7.0 = 14.0이 됨.
		 * 덧셈 결과값은 8바이트 double 타입이 된다.
		 */
	}
}
