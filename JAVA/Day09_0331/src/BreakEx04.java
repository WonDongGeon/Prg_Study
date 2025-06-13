/* 무한루프문이란? 반복문 조건식이 무조건 참이어서 영원히 반복문하는 반복문을 말합니다.
 * while(true) {
 * 		실행문장;
 * }
 */
public class BreakEx04 {
	public static void main(String[] args) {
		int i = 0;
		while(true) { // 조건식이 무조건 true이어서 무한루프문이 된다.
			System.out.print(i + "번 Spring\t");
			if(++i >= 10) 
				break; //무한루프문 종료
		} // while end
		System.out.println(i + "번 end");
		
		System.out.println("\n======================>");
		/*
		 * for반복문 무한루프문 형식)
		 * for(;;) {
		 *  초기식, 조건식, 증감식을 생략하면 무한루프문이 된다.
		 * }
		 */
		i = 0;
		for(;;) {
			System.out.print(i + "번노란개나리\t");
			if(++i >= 10)
				break;
		} //for
		System.out.println(i+"번끝");
	}
	
}
