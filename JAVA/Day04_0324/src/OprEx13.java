// 소수점 네째자리에서 반올림을 하는 예제
public class OprEx13 {

	public static void main(String[] args) {
		
		double pi = 3.141592; // 값 뒤에 접미사 f or F가 생략됨.
		double shortPi = (int)(pi * 1000 + 0.5) / 1000.0;
		/* 3.141592 * 1000은 자동산술법에 의해서 double * double이 된다. 곱셉 결과값은 3141.592 + 0.5
		 *  = 3142.092가 된다.
		 *  이것을 (int)로 형변환 하면 소수점 이하는 버리고 3142가 된다. 3142 / 1000.0 -> 3142.0 / 1000.0 = 3.142
		 */
		System.out.println(shortPi);
		
		/* 자바의 내장 API를 사용해서 소수점 네째자리에서 반올림 해 본다. */
		double result = Math.round(pi*1000) / 1000.0; // round()메소드는 메소드 인자값으로 주어진 값을 소수점 첫째자리에서
		// 반올림해서 정수값으로 반환해 준다. 결국 3.141592 * 1000.0 == 3141.592에서 소수점 첫째자리에서 반올림해서 정수값 3142를 구한다.
		// 3142 / 1000.0은 자동 산술법에 의해서 3142.0d/ 1000.0d = 3.142d
		System.out.println("result = " + result);
	}
}
