/* do ~ while 반복문 형식)
 *  do{
 *  	조건이 참일동안만 반복실행;
 *  	증감식:
 *  }while(조건식);
 *  나중에 조건식을 검사하기 때문에 조건식이 거짓이라도 무조건 한번은 반복실행한다.
 */
public class GuardEx07 {

	public static void main(String[] args) {
		
		int i = 0;
		do {
			System.out.println(i);
			i++;
		}while(i<0);
		
		i = 0;
		while(i<0) {
			System.out.println(i);
			i++;
		}
	}
}
