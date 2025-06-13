abstract class Hello{ //abstract class 키워드로 추상클래스 정의
public abstract void sayHello(String name); //추상클래스에서 추상메서드를 정의할때는 abstract키
//워드 생략못함.
} 
abstract class GoodBye{ 
	public abstract void sayGoodBye(String name); 
} 

/*
 * class SubClass extends GoodBye, Hello { //추상클래스는 하나의 부모로 부터 단일상속만 가능하고, 다 //중
 * 상속은 불가능하다. public void sayHello(String name){
 * System.out.println(name+"씨 안녕하세요!"); } public void sayGoodBye(String name){
 * System.out.println(name+"씨 안녕히 가세요!"); } }
 */
public class AbsEx08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
