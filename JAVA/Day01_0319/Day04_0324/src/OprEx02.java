/* 증가/감소(증감) 연산자 종류)
 * ++i(먼저  1증가 : 선행 증가), i++(나중에 1 증가 : 후행증가)
 * - - i(먼저 1감소 : 선행 감소) , i- - (나중에 1 감소 : 후행감소)
 * 
 * 	참고로 i++은 복합대입연산자의 i+=1(i=i+1)과  같다. 또는 i--은 복합대입연산자의 i-=1(i=i-1)과 같다.
 */
public class OprEx02 {

	public static void main(String[] args) {
		int a =10, b =10;
		++a; // 선행 1 증가
		System.out.printf("%d%n", a);
		
		a--;// 후행 1감소
		System.out.printf("a = %d%n", a); // 10 
	
		System.out.println(b++); // 먼저 10을 출력하고 나중에 1증가
		System.out.printf("%d%n",b); // 11
	
		b = 10;
		int result = ++b; // 선행 증가 즉 먼저 1을 증가한 11을 좌측변수 result에 저장
		System.out.printf("result=%d\n", result);
		

	}
}
