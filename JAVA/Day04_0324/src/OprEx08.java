// int * int 결과값이 int타입 범위 벗어난 예를 수정한 것)
public class OprEx08 {

	public static void main(String[] args) {
		
		int a = 1000000;
		int b = 1000000;
		long c = a * b; // int * int = int는 int 타입범위를 벗어난 값을 long타입 변수 c에 저장
		System.out.printf("%d * %d = %d%n", a, b, c);
		
		c = (long)a*b; // long * int는 자동산술법에 의해서 값 손실 위험이 없는 더 큰 타입으로 자동형 변환이 되어서 long*long=long이 된다.
		System.out.println(c);
		
	}

}
