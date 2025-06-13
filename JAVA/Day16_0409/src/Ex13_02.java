/* 13장. 생성자.pdf No.20 2번 문제)
 *  Animal 클래스에 생성자를 추가하시오.(생성자 오버로딩)
 *  
 */
class Product2{ 
	String name; 
	int price; 
	Product2() {}
	Product2(String name) {
		this(name, 800);
	}
	Product2(int price) {
		this("물", price);
	}
	Product2(String name, int price) {
		this.name = name;
		this.price =price;
	}
} 
public class Ex13_02 {

	public static void main(String[] args) {
		Product2 p4 =new Product2( );
		Product2 p3 =new Product2(500); 
		Product2 p2 =new Product2("커피"); 
		Product2 p1=new Product2("웰치스", 700); 
		System.out.println(p1.name + ", " + p1.price); 
		System.out.println(p2.name + ", " + p2.price); 
		System.out.println(p3.name + ", " + p3.price);
	}

}
