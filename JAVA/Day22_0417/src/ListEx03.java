/* java.util 패키지의 Iterator 인터페이스 특징)
 * 1. 자바 즉 jdk 1.2에서 추가됨
 * 2. 컬렉션에 저장된 복수개의 데이터를 읽어오는 용도로 활용된다. 저장되는 용도로는 사용하지 않는다.
 * 즉 저장되는 용도로 사용되는 컬렉션 자료구조가 아니다.
 * 3. 한번 읽어온 데이터는 다시 못읽어온다. 다시 읽어오기 위해서는 재 생성해야 한다.
 * 4. 단 방향으로만 데이터를 읽어들인다.
 * 5. 주로 자바 1.2에서 추가된 컬렉션과 궁합이 잘 맞는다.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListEx03 {
	public static void main(String[] args) {
	
		List list = new ArrayList();
		list.add("홍길동");
		list.add(100);
		list.add("강감찬");
		list.add("홍길동");
		list.add("서울시");
		
		Iterator elements = list.iterator();
		while(elements.hasNext()) { //다음 원소값이 있다면 참.
			System.out.println(elements.next()); //next()메서드로 다음 원소값을 가져온다.
		}
	}
}
