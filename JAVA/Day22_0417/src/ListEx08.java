/* 컬렉션에서 제네릭이 나온 배경에 대해서 살펴 볼 수 있는 예제)
 * <제네릭 타입>은 참조 타입만 가능하고 기본타입으로는 지정할 수 없다. <제네릭타입>은 자바 5버전에서 추가되었다.
 * 제네릭 타입을 지정하면 지정한 자료형으로만 저장 가능하다.
 * 제네릭 타입을 지정하지 않으면 불필요한 레퍼런스간의 업캐스팅과 다운캐스팅을 해야 하는 불편함이 있다. 
 * 그만큼 프로그램 실행 속도가 떨어지고 데이터 안정성도 떨어진다.
 */

import java.util.ArrayList;
import java.util.List;
public class ListEx08 {

	public static void main(String[] args) {
		List cityList = new ArrayList(); // 아직까지는 제네릭 타입을 지정하지 않은 상태
		
		cityList.add("seoul"); //Object 타입으로 업캐스팅 하면서 저장
		cityList.add("busan");
		cityList.add("daejeon");
		
		String temp = null;
		
		for(int i = 0; i < cityList.size(); i++) {
			if(cityList.get(i) instanceof String) { // 다운캐스팅이 가능한가?
				temp = (String)cityList.get(i); // 명시적인 다운캐스팅, get(i)메서드로 해당 주소 인덱스 번호의 원소값을 가져옴
			}
			System.out.println(temp.toUpperCase()); //영문대문자로 변경해서 출력
		}
	}
}
