/* 11장. 클래스와 객체.pdf No.14의 2번 문제)
 * 1.속성으로 자판기에서 취급하는 제품의 정보,가격을 저장하는 변수와 이를 다루기 위한 메서드를 
 * 갖는 자판기 클래스를 선언하고 다음과 같은 결과가 나오도록 객체(p) 생성 후 메소드를 호출하시오.
(Ex11_02.java) 
출력: 자판기 => 제품목록:
커피 150원, 
비타500 500원
 */

class Product {
	private String name;
	private int price;
	
	public void setName(String new_name) {
		name = new_name;
	}
	public void setPrice(int new_price) {
		price = new_price;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	void stop() { //return 종료 기능
		for(int i = 1; i <= 10; i++) {
			if(i == 4) {
				return; // 종료
			}
			System.out.println("\t"+i); // 1 2 3
		}//for
	}//stop
}
public class Ex11_02 {
	public static void main(String[] args) {
		Product p = new Product();
		Product p2 = new Product();
		p.setName("커피");
		p.setPrice(150);
		System.out.print("자판기 => 제품목록 : " + p.getName() + " " + p.getPrice() + "원, ");
		p.setName("비타500");
		p.setPrice(500);
		System.out.print(p.getName() + " " + p.getPrice() + "원, ");
		System.out.println();
		
		p.stop();
	}
}
