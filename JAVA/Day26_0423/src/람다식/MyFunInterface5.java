package 람다식;

/* @FunctionalInterface를 굳이 사용하지 않아도 추상메서드가 하나가 오면 람다식을 위한 함수형 인터페이스로 사용가능하다.
 * 이 인터페이스로 외부클래스 메서드내의 람다식 익명객체 구현에 사용한다.
 */
public interface MyFunInterface5 {
	void method();
}
