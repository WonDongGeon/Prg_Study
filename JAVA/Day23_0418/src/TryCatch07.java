/* 배열주소 인덱스 번호 범위를 벗어나면 ArrayIndexOutOfBoundsException 예외 오류를 발생시킨다.
 * 
 */
public class TryCatch07 {
	public static void main(String[] args) {
		int[] score = {1, 2, 3};
		
		try {
			System.out.println("Test - 1");
			score[4] = 5; //배열 주소 범위를 벗어나서 예외를 발생시킴
			System.out.println("Test - 2"); // 이 문장 수행 안하고 해당 catch 블록으로 이동해서 예외 처리를 합니다.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
