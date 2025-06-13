package 중첩클래스와중첩인터페이스;

/* Person 클래스를 활용한 익명객체 구현 소스 */
public class Anonymous {
	
	//필드 초기값으로 대입
	Person field = new Person() {
		void work() {
			System.out.println("출근을 합니다.");
		}

		@Override
		void wake() {
			System.out.println("6시에 일어납니다.");
			work();
		}
	}; //첫번째 익명 클래스(외부클래스명$번호.class => Anonymous$1.class)
	
	void method() {
		//지역변수값으로 대입
		Person localVar = new Person() {
			void walk() {
				System.out.println("아침 산택을 합니다.");
			}

			@Override
			void wake() {
				System.out.println("7시에 일어납니다.");
				walk();
			}
		}; //두번째 익명클래스  => Anonymous$2.class
		localVar.wake();
	}//method()
	
	void method02(Person person) {
		person.wake();
	}
}
