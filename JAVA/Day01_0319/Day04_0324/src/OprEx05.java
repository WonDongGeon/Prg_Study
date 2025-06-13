// 증감 연산자
public class OprEx05 {

	public static void main(String[] args) {
			int i = 5, j = 0;
			j = i++; // 후행 증가, 먼저 i변수값 5를 좌측변수 j에 저장하고 나중에 1증가
			
			System.out.printf("i=%d, j=%d\n", i, j); // 6, 5
			
			i=5;
			j=0;
			
			j= ++i ; // 선행증가, 먼저 1증가한 6을 좌측변수 j에 저장
			System.out.println("i=" + i +  " ,j = " +  j);
			
			i = 5;
			j = 5;
			
			System.out.printf("i++ = %d%n", i++); // 먼저 i변수값 5를 출력하고 나중에 1증가
			System.out.printf("i=%d%n", i); // 6
			
			System.out.printf("++j = %d%n", ++j); // 먼저 1증가하고 j변수값 6을 출력
			
			
	}
}