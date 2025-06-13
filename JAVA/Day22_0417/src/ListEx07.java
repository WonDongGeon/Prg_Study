/* java.util 패키지의 Queue 컬렉션 인터페이스를 구현한 컬렉션 클래스 LinkedList 특징)
 * 1. 입구와 출구가 달라서 먼저 입력된 자료가 먼저 나가는 구조이다.(First Input First output : FIFO)
 * 
 */

import java.util.LinkedList;

public class ListEx07 {

	public static void main(String[] args) {
		LinkedList myQue = new LinkedList();
		myQue.offer("1-java"); //offer()메서드로 큐에 원소값 추가
		myQue.offer("2-oracle");
		myQue.offer("3-jsp");
		
		while(myQue.peek() != null) { //큐가 비어 있지 않다면
			System.out.println(myQue.poll()); //큐에서 데이터를 꺼내온다.
		}
	}
}
