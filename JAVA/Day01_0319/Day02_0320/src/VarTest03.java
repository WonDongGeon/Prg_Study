// 큰따옴표로 묶여진 "문자열" 값은 자바의 기본타입이 아니라 레퍼런스 참조타입에 해당하는 String형이다.
public class VarTest03 {

	public static void main(String[] args) {
		
		String subject = "자바책";
		System.out.println(subject);
		
		String cityName="서울시";
		System.out.println("도시이름 : " + cityName);

		cityName = "부산시"; //변수에는 단 하나의 값만 저장할 수 있다. 마지막에 저장된 값만 남는다.
		System.out.println("변경된 도시 이름 : " + cityName);
		
		String address; // 문자열 변수 선언
		address = "서울특별시 중랑구 면목동 서일대학교 배양관 211호"; //  변수값 초기화9변수에 최초값 저장하는 것을 말한다.
		System.out.printf("%s\n", address); // %s는 문자열 출력형태 지시자이다.
		
	}

}
