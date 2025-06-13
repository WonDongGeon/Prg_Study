/* java.util 패키지의 컬렉션 Set 인터페이스를 구현상속한 HashSet 컬렉션 클래스 특징)
 * 1. 저장되는 순서를 보장하지 않는다.
 * 2. 중복 원소값을 허용하지 않는다.
 */

import java.util.HashSet;
import java.util.Set;
public class ListEx01 {
	public static void main(String[] args) {
		Set set = new HashSet(); // 제네릭 타입을 명시하지 않았기 때문에 모든 값이 Object 타입으로 처리됨
		set.add(100); // 자바 최상위 클래스 Object타입으로 업캐스팅 하면서 저장
		set.add(100.6); //오토박싱과 업캐스팅
		set.add("Seoul"); //업캐스팅
		set.add("Seoul"); //중복 값 배제
		set.add("true");
		System.out.println("컬렉션 원소개수 : " + set.size()); //4
		System.out.println(set);
	}
}
