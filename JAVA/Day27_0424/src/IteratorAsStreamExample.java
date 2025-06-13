/* 컬렉션에 저장된 복수개의 원소값을 java 2에서 추가된 Iterator인터페이스를 사용해서 다음 원소값을 읽어오는 경우와 자바 8에서 추가된
 * 스트림과 람다식을 사용해서 보다 더 간결하게 컬렉션 원소값을 읽어오는 비교 예제)
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorAsStreamExample {
	public static void main(String[] args) {

		List<String> list = Arrays.asList("홍길동","신사임당님","을지문덕님");//배열을 컬렉션 List로 변환
		
		//Iterator를 사용해서 컬렉션의 다음원소값을 읽어옴.
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {//다음 원소값이 있다면 참
			String name = iterator.next();//다음 원소값을 읽어옴
			System.out.println(name);
		}
		System.out.println("\n =================== \n");
		
		//스트림 사용
		Stream<String> stream = list.stream();
		stream.forEach(name -> System.out.println(name));//람다식
	}
}
