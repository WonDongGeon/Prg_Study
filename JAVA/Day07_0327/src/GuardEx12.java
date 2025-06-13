/*
 *  이중 for 반복문 안에 if ~else 조건문을 넣는 실습)
 */
public class GuardEx12 {
	public static void main(String[] args) {
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(i==j) {
					System.out.printf("[%d, %d]", i, j);
				} else {
					System.out.printf("%5c", ' '); // %5c 출력형태 지시자는 총 5자리 단일문자로 표현하고 오른쪽 정렬을 기본으로 한다.
				} // if else
			} // inner for(안쪽 for)
			System.out.println(); // 줄바꿈
		} // outer for(바깥쪽 for)
	}
}
