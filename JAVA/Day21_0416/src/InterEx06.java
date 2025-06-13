/* 자바 5버전에서 추가된 오토박싱과 오토언박싱)
 * 1. 오토박싱 : 기본 타입을 참조 레퍼클래스형으로 자동형 변환을 하는 것을 말한다.
 * 2. 오토언박싱 : 레퍼 클래스 타입을 기본타입으로 변경하는 것을 말한다.
 * 
 */
public class InterEx06 {
	public static void main(String[] args) {
		int n01 = 10;
		int n02;
		Integer num01;
		Integer num02 = new Integer(20);
		
		num01 = n01; //오토박싱
		System.out.println("오토박싱 된 값 = " + num01);
		
		n02 = num02; //오토언박싱
		System.out.println("오토언박싱 된 값 = " + n02);
	}
}
