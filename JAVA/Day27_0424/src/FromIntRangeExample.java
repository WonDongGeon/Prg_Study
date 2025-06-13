/* 숫자 범위로 부터 스트림을 얻어서 1부터 100까지 누적합을 구한다. */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FromIntRangeExample {
	static int sum;//누적합
	public static void main(String[] args) {

		/* 문제) IntStream API를 활용해서 1부터 100까지의 자연수를 구한다음 람다식으로 누적합을 구해서 출력하는 코드를 만들어 보자. 
		 */		
		IntStream stream = IntStream.rangeClosed(1, 100);//1부터 100까지 순차적으로 제공하는 IntStream객체 생성
		//stream.forEach(k -> System.out.print(" " +k));
		stream.forEach(k -> sum += k);//1부터 100까지 누적합
		System.out.println("1부터 100까지 누적합="+sum);
		
		sum = 0;
		List<Integer> numList = new ArrayList<>();
		/*  문제)일반 for반복문을 사용해서 1부터 10사이의 임의의 정수숫자 난수를 발생한 다음 이것을 numList컬렉션에 저장하고 출력하는 
		 * 코드를 만들어 본다.
		 */
		for(int k=0;k<10;k++) {
			int number = (int)(Math.random()*10)+1;//random()메서드는 0.0 이상 1.0미만 사이의 실수숫자 난수=>*10하면
			//0.0이상 10.0미만 =>(int)로 형변환하면 0이상 10미만=>+1하면 1이상 11미만 즉 1부터 10사이의 임의의 정수숫자 난수발생
			numList.add(number);
			System.out.print(" "+numList.get(k));
		}
		System.out.println();
		
		/* 문제)향상된 확장for반복문을 사용해서 컬렉션 numList원소값의 누적합을 구해보자. 
		 */
		for(int num:numList) {
			sum += num;
		}
		System.out.println("\n 10개의 정수숫자 난수의 총합 = "+sum);
	}
}
