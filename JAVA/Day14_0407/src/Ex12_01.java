/* 문제)12장.메서드살피기.pdf No.19의 1번 문제  
 * p() 메소드를 오버로딩하여 두 int 변수에 대해서 두 double 변수에 대해서 최대
 * 값을 구하는 메소드를 정의하시오. (Ex12_01.java)
 * (단, 매개변수 타입을 다르게 한 메서드 오버로딩)
 */
public class Ex12_01 {
	static void p(int a, int b) {
		int max = a > b ? a : b;
		System.out.println("최대값(int) = " + max); // void일 경우
		
	}
	static void p(double a, double b) {
		double max = a > b ? a : b;
		System.out.println("최대값(double) = " + max); // void일 경우
	}
	public static void main(String[] args) {
		p(10, 20);
		p(10.4, 10.1);
	}
}
