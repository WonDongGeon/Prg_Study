/* java.util 패키지의 컬렉션 List 인터페이스를 구현한 ArrayList 컬렉션 클래스 특징)
 * 1. 저장되는 순서를 보장한다.
 * 2. 중복 원소값을 허용한다.
 * 3. jdk 1.2에서 추가됨.
 * 
 */

import java.util.ArrayList;
import java.util.List;
public class ListEx02 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(7); //오토박싱 + 업캐스팅
		list.add("홍길동"); //업캐스팅
		list.add("홍길동"); //add()메서드로 컬렉션 원소값 추가
		list.add(100.7);
		list.add(true);
		
		System.out.println("컬렉션 원소개수 : " + list.size());
		System.out.println(list);
		
		//일반 for 반복문으로 출력
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)); //get()메서드로 컬렉션 원소값을 가져옴.
		}
	}
}
