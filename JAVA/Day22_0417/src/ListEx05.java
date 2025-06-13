/* java.util 패키지의 Enumeration 인터페이스 특징)
 * 1. jdk 1.0에 추가된 인터페이스로 컬렉션에 저장된 복수개의 원소값을 순방향으로 쉽게 읽어오는 용도로 활용되고
 * 저장되는 쓰임새로는 사용되지 않는다.
 * 
 * 2. Iterator의 구버전으로 한번 사용된 것은 다시 사용못한다. 다시 사용할려면 재생성 해야 한다.
 * 3. jdk 1.0에서 추가된 컬렉션 api하고 잘 맞다.
 */

import java.util.Enumeration;
import java.util.Vector;

public class ListEx05 {
	public static void main(String[] args) {
		Vector vec = new Vector();
		
		for(int i = 1; i <= 5; i++) {
			vec.add(new Integer(i*10));
		}
		
		Enumeration enu2 = vec.elements();
		while(enu2.hasMoreElements()) { // 벡터에 요소가 있다면
			System.out.println(enu2.nextElement()); // 컬렉션 다음 원소값을 가져온다.
		}
	}
}
