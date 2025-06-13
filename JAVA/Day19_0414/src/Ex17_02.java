/* 17장 레퍼런스형 변환.pdf의 No.19 2번문제)
 * 문제) 다음 수행 결과값을 유추하시오.
 * 명시적인 다운캐스팅을 할 때 if 조건문과 형변환 유무 판단연산자를 추가 코딩해서 활용하자.
 */
class Super extends Object { // extends Object은 생략 가능함.
	public int getNumber(int a) {
		return a+1;
	}
}
class CastingEx03 extends Super {
	@Override
	public int getNumber(int a) { // 메서드 오버라이딩
		return a + 3;
	}
}
public class Ex17_02 {
	public static void main(String[] args) {
		Super sp = new CastingEx03(); //업캐스팅
		System.out.println(sp.getNumber(0)); // 3 => 업캐스팅 이후 오버라이딩 한 메서드 호출
	}
}
