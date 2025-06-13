/* 명호가한 반복횟수가 정해진 경우 사용하는 for 반복문 형식)
 * 	for(초기식; 조건식; 증감식){
 *		문장1;
 *		문장2;
 *		...
 *		문장n;
 *}
 *다음 문장;
 */
public class GuardEx04 {
	public static void main(String[] args) {
		// 반복문을 사용한 효율적인 방법, Hello Java! 열번 출력
		int  i; // 반복문 제어변수
		for(i = 1; i <= 10; i++) {
			System.out.println("Hello Java!");
		}
		System.out.println("\n ===================\n");
		
		// 1부터 5까지 반복
		for(i = 1 ; i <= 5; i++) {
			System.out.print(i + "\t"); // \t는 텝키만큼 수평으로 띄움
		}
		System.out.println(" \n ============== \n");
		
		//짝수 값 출력
		for(i = 2; i <= 10; i += 2) {
			System.out.println(" " + i);
		}
		System.out.println("\n ==============> \n");
		
		// 1씩 감소
		for(i =5; i>=1; i--) {
			System.out.println(" " + i);
		}
	}
}
