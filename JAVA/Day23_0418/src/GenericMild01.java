/* 제네릭 와일드 카드 3번째 문법 형식)
 * <? super Integer 타입의 조상(부모)만 제네릭 타입간의 형변환을 제한적 허용한다.(하한 제한 와일드 카드)
 * 
 */

import java.util.Arrays;
import java.util.List;

public class GenericMild01 {
	static void addNumber(List <? super Integer> list) {
		for(int i = 0; i < list.size(); i++) { // size()메서드는 컬렉션 원소개수를 반환
			System.out.print(" " + list.get(i)); //get()메서드는 컬렉션 원소값을 가져온다.
		}
		System.out.println("\n======================\n");
	}
	public static void main(String[] args) {
		Number[] arr = {10, 20, 30};
		Object[] arr2 = {1000, 2000, 3000};
		List<Number> li = Arrays.asList(arr); // 배열을 컬렉션 List로 변환
		addNumber(li);
		List<Object> li02 = Arrays.asList(arr2);
		addNumber(li02);
	}
}
