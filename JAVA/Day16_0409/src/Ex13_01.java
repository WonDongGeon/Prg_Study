/* 13장. 생성자.pdf No.19 1번 문제)
 *  Animal 클래스에 생성자를 추가하시오.(생성자 오버로딩)
 *  
 */
class Animal {
	String name;
	int age;
	Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void show() {
		System.out.println(name + "는(은) " + age + "살입니다.");
	}
}
public class Ex13_01 {
	public static void main(String[] args) {
		Animal a1 = new Animal("원숭이", 26);
		a1.show();
	}

}
