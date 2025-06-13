package 중첩클래스와중첩인터페이스;

public class Outter {
	public void method01(final int arg) {
		final int localVariable = 1;
		//arg = 100;
		//localVariable = 100;
		
		/* 로컬 클래스 객체는 외부클래스 method01() 메서드 실행이 끝나도 힙 메모리 영역에 존재하게 된다.
		 * 하지만 외부클래스 method01() 소속의 매개변수 arg와 지역변수 localVariable은 메서드 실행이 끝나면
		 * 스택메모리에서 사라지게 된다.

		 * 이런 경우 로컬 클래스 객체를 계속 사용하고자 할 경우에는 외부클래스 메서드 소속의 매개변수와 지역변수 값을 로컬클래스 내부에
		 * 복사해 놓고 사용한다.
		 
		 * 외부 클래스 소속 메서드의 매개변수나 지역변수 값이 수정되면 로컬 클래스에 복사해 놓은 값과 달라지는 문제가 발생한다.
		 * 이것을 해결하기 위해서 매개변수나 지역변수를 수정할 수 없는 final로 선언해서 값 변경을 막아야 한다.
		 * 
		 * 결론으로 로컬 클래스에서 사용 가능한 것은 final로 선언된 매개변수와 지역변수 뿐이라는 것이다. 그러므로 자바 7버전까지는
		 * final 키워드가 없는 매개변수나 지역변수를 로컬 클래스에서 사용하면 컴파일 에러가 발생했다. 
		 * 하지만 자바 8버전 이후부터는 final을 생략해도 final 특성을 가진 상수로 인식한다.
		 */
		//로컬 클래스
		class Inner {
			public void method() {
				int result = arg+localVariable;
			}
		}//Outter$1Inner.class
	} //method01()
	
	//자바 8버전 이후
	public void method02(int arg) { //int arg 앞에 final이 생략됨.
		int localVariable = 1; //int 앞에 final이 생략됨.
		
		//arg = 10;
		//localVariable =100;
		
		class Inner {
			public void mehod() {
				int result = arg + localVariable;
			}
		}//Outter$2Inner.class
	}//method02()
}
