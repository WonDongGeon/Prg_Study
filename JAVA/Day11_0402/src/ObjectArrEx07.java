/* 2차원 배열을 사용한 영문자에 대한 한글 답안 찾는 예제)
 */
import java.util.Scanner;

public class ObjectArrEx07 {
	public static void main(String[] args) {
		String[][] words = {
				{"java", "자바"},
				{"int", "정수"},
				{"for", "반복문"}
		};
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < words.length; i++) { //words.length는 행의 길이 3을 반환
			System.out.printf("Q%d번 문제. %s의 뜻은?", i+1, words[i][0]);
			
			String answer = scan.nextLine(); //한글 답안을 문자열로 읽어들인다.
			
			if(answer.equals(words[i][1])) { //equals()메서드는 객체주소를 비교하지 않고 문자열 내용값만 비교해서 같으면 true
				//다르면 false
				System.out.printf("정답입니다, %n%n");
			} else { // 정답이 아닐 경우
				System.out.printf("틀렸습니다. 정답은 %s입니다. %n%n", words[i][1]);
			}// if else
		} // for
	}
}
