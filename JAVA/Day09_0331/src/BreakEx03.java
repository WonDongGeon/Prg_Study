/*
 *  continue 문 특징)
 *  반복문내에서 continue문을 만나면 아래 문장을 수행하지 않고, 다음 반복문을 위해서 반복문 처음으로 돌아가 반복을 계속한다.
 */
public class BreakEx03 {
	public static void main(String[] args) {
		int i; //반복문 제어변수
		
		//1부터 10까지 반복하는데 4의 배수만 제외하고 반복한다.
		for(i=1; i<=10; i++) {
			if(i%4==0) {
				continue;
			}
			System.out.print(i + " ");
		} //for
	}
}
