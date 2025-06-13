/* printf() 메서드는 java5에서 추가된 것으로 다양한 출력형태 지시자를 통해서 여러종류의 값을 표현할 수 잇다.
 * 출력형태 지시자 종류)
 *  %d(십진수 정수), %c(단일문자)
 *  자세히 이해하기 위해선 ASCII코드를 보면서 하면 도움이 됨.
 */
public class VarTest02 {

	public static void main(String[] args) {
		char x;//단일문자 타입으로 x변수 선언, 단일 문자는 십진수 정수로 저장된다.
		x = 'A'; // 'A'는 십진수 정수 65로 저장
		System.out.printf("%c => %d\n", x, (int)x); // \n은 줄바꿈(개행), (int)는 캐스팅 형변환 연산자

		x = 'a'; // 'a' 십진수 정수 97로 저장
		System.out.printf("%c : %d\n", x, (int)x);
		
		x = '7'; // '7'은 십진수 정수 55로 저장
		System.out.printf("%c : %d\n", x, (int)x);
		}
}
