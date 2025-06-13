/* 제네릭 타입간의 레퍼런간의 형변환은 허용되지 않는다.
 * 
 */

import java.util.ArrayList;

public class ListEx13 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("orange");
		
		ArrayList<Object> objlist;
		//objlist = list;
		
//		for(Object obj: objlist) {
//			System.out.println(obj);
//		}
	}

}
