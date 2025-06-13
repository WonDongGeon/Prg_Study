/* 제네릭 타입간의 레퍼런스 형변환은 와일드 카드 문법을 사용하면 제한적으로 허용한다.
 * 
 */

import java.util.ArrayList;

public class ListEx14 {
	public static void main(String[] args) {
		ArrayList<String> cityList = new ArrayList<>();
		
		cityList.add("서울시");
		cityList.add("부산시");
		cityList.add("대전시");
		
		ArrayList<? extends Object> objlist;
		/* <? extends Object> 제네릭 타입간의 형변환 와일드 카드문법 특징)
		 * Object를 상속받은 자손은 제네릭 타입간의 형변환을 제한적 허용한다.(상한 제한 와일드 카드)
		 */
		objlist = cityList;
		
		for(Object obj : objlist) {
			System.out.println(obj);
		}
		
	}
}
