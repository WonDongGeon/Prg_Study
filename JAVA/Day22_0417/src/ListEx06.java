/* Java.util 패키지의 컬렉션 클래스 Stack의 특징)
 * 1. jdk 1.0에 추가됨.
 * 2. 입구와 출구가 같기 떄문에 가장 먼저 입력된 데이터가 가장 나중에 나오는 구조이다. (First Input List Output 구조 : FILO)
 * 3. 가장 나중에 입력된 데이터가 가장 먼저 나오는 구조이다. (Last Input First Output구조 : LIFO)
 * 
 */

import java.util.Stack;
public class ListEx06 {
	public static void main(String[] args) {
		Stack myStack = new Stack();
		
		myStack.push("1-java"); //push()메서드는 스택의 맨 위에 원소값을 추가
		myStack.push("2-oracle"); 
		myStack.push("3-html");
		
		while(!myStack.isEmpty()) { // 현재 스택이 비어 있지 않다면
			System.out.println(myStack.pop()); //pop() 메서드는 스택의 맨 위에서 값을 제거하면서 반환 => 입력된 값 역순으로 출력
		}
	}
}
