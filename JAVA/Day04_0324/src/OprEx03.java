// 비트 연산자
public class OprEx03 {

	public static void main(String[] args) {
		int a  = 12;
		int b = 20;
		int c;
		
		c =  a & b;
		System.out.println(a+ " & " + b + "  : "+ c); // 4
		// 1100 % 10100 -> 00000100 
		c =  a | b;
		System.out.println(a + " | " + b +" : " + c); // 28
		// 1100 | 10100 -> 00011100
		c = a ^ b;
		System.out.println(a + " ^ "  + b + " : " + c); //  24
		// 1100 ^ 10100 -> 00011000
		
		c = ~a; // 비트 전환
		System.out.println("~a : " + c);
		// ~ ->  00001100 -> 11110011 
		// 2의 보수 -> 00001100 -> 00001101 -> 00001101 -> ~으로 음수가 되었기 때문에 -> -13

	}
}
