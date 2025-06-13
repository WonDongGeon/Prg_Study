/* 확장된 대입(복합대입) 연산자 종류)
 *  a+=10은 a=a+10을 의미한다.
 *  a-=2은  a= a-2을 의미한다.
 */
public class OprEx01 {

	public static void main(String[] args) {
		int i = 1;
		i = i +5;
		System.out.printf("%d\n",  i); // %d 10진수 출력 형태, \n은 줄바꿈(개행)
		
		i -= 3; // i = i - 3;과 같다.
		System.out.println("i = " + i);
		
		i += 7; // i = i+7; 과 같다.
		System.out.printf("%d%n", i); // %n은 줄바꿈
		
	}

}
