/* double 타입 실수숫자값을 (int)로 캐스팅 연산자인 형변환 연산자를 사용한 예 */
public class VarTest10 {

	public static void main(String[] args) {
		
		double score = 89.9;
		int result_score = (int)score; // 89.9에서 소수점 이하에서 반올림 하지 않고 버리고 89정수값만 구함.
		
		System.out.printf("실제 취득한 점수 : %f %n", score);
		System.out.println("공무원 합격점수(90점 이상이면 합격, 90점 미만이면 불합격) = " + result_score);
	}

}
