package 제3장문제풀이;

//3번 문제풀이 코드 
public class DataEx03 {

	public static void main(String[] args) {
		byte var1=127; 
		short var2=128; 
		int var3=128; 
		long var4=128L; 
		var4 = var1;  // 암묵적인 자동형변환(byte->long) 
		System.out.println(var1+ ", " + var4); 
		var1 = (byte)var3; // 캐스팅 연산자 (byte)를 사용해서 명시적인 형변환을 한다.  byte 최대값 범위를 벗어나서 최소값이 저장된다.
		System.out.println(var1+ ", " + var3); 
		 
		float var5=123456.789123f; // float타입은 접미사 f or F가 뒤에 붙어있어야됨.
		double var6=123456.789123;  // 접미사 d or D가 생략됨.
		var5 =(float)var6; // 캐스팅 연산자 (float)를 사용해서 명시적인 형변환을 한다. 
		System.out.println(var5+ ", " + var6); 
		var6 = var5; 
		System.out.println(var5+ ", " + var6); 
		
		// 13번줄, 16번줄, 18번줄
	}

}
