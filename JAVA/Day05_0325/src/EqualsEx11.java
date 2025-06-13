/* switch~case 문을 사용한 학점 구하기 )
 */

import java.util.Scanner;
public class EqualsEx11 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("0부터 100사이 수학점수 입력 >> ");
		int jumsu = Integer.parseInt(scan.nextLine());
		
		if(jumsu >= 0 && jumsu <= 100) {
			System.out.print("입력하신 점수 " + jumsu + "는(은) ");
			int a = jumsu / 10; // 10으로 나눈 몫만 구함.
			switch(a) {
			case 9 : System.out.println(" A학점입니다. "); break;
			case 8 : System.out.println(" B학점입니다. "); break;
			case 7 : System.out.println(" C학점입니다. "); break;
			case 6 : System.out.println(" D학점입니다. "); break;
			default : System.out.println(" F학점입니다. "); break;
			}
		} else {
			System.out.println("0부터 100사이 점수만 입력하세요!");
		}
	}

}
