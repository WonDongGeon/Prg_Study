//삼중 for 반복문
public class GuardEx11 {
	public static void main(String[] args) {
		int i , j, k; //반복문 제어변수
		for(i = 1; i <= 3; i++) {
			for(j=1; j<=3; j++) {
				for(k = 1; k<=3; k++) {
					System.out.println(""+i+j+k); //""+1에서 문자를 우선해서 숫자 1이 문자"1"로 변경된다. 그래서 덧셈연산을
					// 하지 않고 문자를 서로 연결(+)한다.
				}
			}
		}
	}
}
