/* 다양한 배열 생성법 */
import java.util.Arrays;
public class ArrayEx06 {
	public static void main(String[] args) {
		int[] iArr01 = new int[10]; //배열 크기가 10인 iArr01배열 생성
		int[] iArr02 = new int[] {100, 95, 80, 70, 100};
		int[] iArr03 = {100, 100, 85, 95, 90};
		char[] chArr = {'a', 'b', 'c', 'd'}; // 단일문자 타입 배열 chArr직접초기화 하면서 생성
		
		/* 문제 1) iArr01 배열원소값을 for반복문을 사용해서 정수 자연수 숫자 1부터 10까지 초기화하고 같은 반복문에서 바로 출력하는
		 * 코드를 작성해 보자.
		 */
		for(int i = 0; i < iArr01.length; i++) {
			iArr01[i] = i + 1;
			System.out.printf("iArr01[%d] = %d%n", i, iArr01[i]);
		}
		System.out.println("\n===================>\n");
		
		//자바 5에서 추가된 향상된 확장 for 반복문을 사용해서 배열원소값을 쉽게 읽어옴
		for(int a : iArr02) {
			System.out.print(" " + a);
		}
		System.out.println("\n===================>\n");
		
		//내장 API를 사용해서 배열원소값을 문자열로 반환(import java.util.Arrays;)
		System.out.println(Arrays.toString(iArr03));
		System.out.println(chArr); //단일문자 배열원소값 출력
	}
}
