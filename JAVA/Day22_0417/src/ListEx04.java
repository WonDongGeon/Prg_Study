/* java.util 패키지의 Iterator 인터페이스를 구현 상속한 ListIterator 인터페이스 특징)
 * 1. jdk 1.2에서 추가됨.
 * 2. Iterator를 상속받아서 기능을 추가한 것으로 컬렉션 원소값을 읽어올 때 양방향 이동이 모두 가능하다.
 * 다만 ArrayList 또는 LinkedList 컬렉션 클래스의 List 컬렉션 인터페이스를 구현 상속한 컬렉션에서만 사용 가능하다.
 * 
 */

import java.util.ArrayList;
import java.util.ListIterator;

public class ListEx04 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add("1"); list.add("2"); list.add("3");
		list.add("4"); list.add("5");
		
		ListIterator it = list.listIterator();
		
		//순방향으로 읽어옴
		while(it.hasNext()) { // 다음 원소값이 있따면 참
			System.out.print(" " + it.next());// next()메서드로 다음 원소값을 읽어옴.
		}
		System.out.println("\n====================\n");
		
		//역방향으로 읽어옴
		while(it.hasPrevious() ) { // 이전 원소값이 있다면 true
			System.out.print(" " + it.previous()); //이전 원소값을 읽어옴.
		}
	}
}
