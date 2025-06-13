/* == 같다 비교연산자와 equals()메서드에 관한 예제)
 */
public class InterEx08 {
	public static void main(String[] args) {
		int a=10, b=10;
		if(a==b) { //값을 비교
			System.out.println(a+"와(과) " + b + "은 같다.");
		} else {
			System.out.println(a+"과(와) " + b + "은 다르다.");
		}
		
		String pwd01 = new String("56789");
		String pwd02 = new String("56789"); //new 키워드로 생성된 객체 pwd01과 pwd02는 객체주소가 다르다.
		if(pwd01 ==pwd02) { //String 클래스(레퍼런스 참조타입)을 ==로 비교하면 객체 주소값을 비교
			System.out.println("비번이 같다.");
		} else {
			System.out.println("비번이 다르다.");
		}
		
		//문자열 값만 비교하기 위해서는 내장 String api클래스에 오버라이딩 된 equals()메서드를 사용해야 한다.
		if(pwd01.equals(pwd02)) {
			System.out.println("비번이 같다.");
		} else {
			System.out.println("비번이 다르다.");
		}		
	}
}
