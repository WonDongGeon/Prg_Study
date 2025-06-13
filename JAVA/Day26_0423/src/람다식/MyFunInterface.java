package 람다식;

/* @FunctionalInterface 애노테이션 특징)
 * 1. 이 애노테이션은 자바 8에서 추가되었고 람다식을 위한 인터페이스이다. 추상메서드가 딱 하나만 올 수 있따.
 * 2. 이 애노테이션이 추가된 인터페이스를 함수형 인터페이스라고 한다. 함수형 인터페이스는 람다식 작성을 위한 인터페이스이다.
 * 3. 이 애노테이션이 없더라도 인터페이스에 추상메서드가 딱 하나만 온다면 람다식을 위한 인터페이스로 활용가능하다.
 */
@FunctionalInterface //람다식을 위한 함수형 인터페이스로 정의하면 추상메서드를 딱 하나 정의해야 한다.
public interface MyFunInterface {
	public abstract void method(); // abstract가 생략된 추상메서드 => 매개변수와 리턴값이 없다.
}
