/* 17장 레퍼런스형 변환.pdf의 No.19 2번문제)
 * 문제) 다음 수행 결과값을 유추하시오.
 * 명시적인 다운캐스팅을 할 때 if 조건문과 형변환 유무 판단연산자를 추가 코딩해서 활용하자.
 */
class SubClass {
	int i = 3;
}
public class Ex17_01 {
	public static void main(String[] args) {
		Object obj = new SubClass(); //업캐스팅
		if(obj instanceof SubClass) { // 참 : 업캐스팅이 되어 있기 때문임
			SubClass foo = (SubClass)obj; //다운 캐스팅
			System.out.println("i = " + foo.i);
		}
	}
}
