/* 13장. 생성자.pdf No.21 3번 문제)
 *  3. 다음은 Thing 클래스를 설계한 것입니다. new Thing()와 같이 기술해서 성
 *	공적으로 생성자를 호출하는 Thing 클래스를 다음 중에서 고르시오.
 *  가. class Thing { //그리고 정답이 아닌 이유를 주석문과 코드로 작성
	Thing(){}
	} 
	나. class Thing { 
	public Thing(void) {} //전달인자 값으로 void가 들어감(말이 안됨)
	} 
	다. class Thing { 
	public Thing(String s) {} //생성자 오버로딩
	} 
	라.public class Thing { 
	public void Thing() {} //이건 생성자가 아니라 메서드임
	} 
 */
class Thing { //그리고 정답이 아닌 이유를 주석문과 코드로 작성
	Thing(){}
} 
public class Ex13_03 {
	public static void main(String[] args) {
		new Thing();
	}
}
