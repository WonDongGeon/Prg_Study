/* java.util 패키지의 컬렉션 Map인터페이스를 구현한 컬렉션 클래스 HashMap)
 * 1. Map과 HashMap은 자바 1.2에서 추가됨.
 * 2. 키, 값 쌍으로 저장되는 영어 사전적인 컬렉션 자료구조이다.
 * 3. 키를 통해서 값을 검색해서 검색 속도가 빠르다.
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class ListEx11 {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>(); //앞 부분 제네릭 타입만 봐도 추정이 가능해서 자바 7버전 부터는 뒷부분
		// 제네릭 타입<>은 생략 가능하다.
		
		String[] sample = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};
		
		//문자열 키에 포함된 단어 빈도수 계산
		for(String k : sample) { //향상된 확장 for
			Integer freq = m.get(k); //키에 대한 값을 구함
			m.put(k, (freq == null)?1:freq+1); //값으로 단어 빈도수가 저장
		}
		System.out.println(m.size() + " 단어가 있습니다."); // 7
		System.out.println(m.containsKey("to")); // to키가 맵에 포함되어 있다면 참, 없다면 거짓 => true
		System.out.println(m); //맵 자료 출력
	}
}
