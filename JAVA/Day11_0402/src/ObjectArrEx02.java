/* string 문자열 배열을 다루는 소스)
 */
public class ObjectArrEx02 {
	public static void main(String[] args) {
		String[] names = {"Kim", "Park", "Yi"};
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		System.out.println("\n========================>\n");
		
		for(String i : names) {
			System.out.println(i);
		}
		System.out.println("\n========================>\n");
		
		String tmp = names[2];
		System.out.printf("tmp=%s%n", tmp);
		
		names[0] = "Yang"; //첫번째 원소값 변경
		
		//향상된 확장 for로 names 배열원소값 출력
		for(String editName : names) {
			System.out.println(editName);
		}
	}
}
