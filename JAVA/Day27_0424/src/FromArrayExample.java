/* 배열로 부터 스트림 얻기 */

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayExample {
	public static void main(String[] args) {

		String[] strArray = {"홍길동","이순신","강감찬"};
		Stream<String> strStream = Arrays.stream(strArray);//배열로부터 문자열 요소를 처리하는 스트림을 생성
		strStream.forEach(name -> System.out.println(name));
		
		System.out.println("\n ====================> \n");
		
		int[] intArray = {10,20,30};
		IntStream intStream = Arrays.stream(intArray);//배열로 부터 기본 int타입 요소를 처리하는 스트림 생성
		intStream.forEach( number -> System.out.println(number));
	}
}
