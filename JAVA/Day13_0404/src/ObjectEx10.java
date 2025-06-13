/* 전달인자 순서를 다르게 한 메서드 오버로딩
 */
class Mt10 {
	//첫번째 메서드 : int, int, String
	public void pr(int a, int b, String c) {
		System.out.println(a+"\t"+b+"\t"+c);
	}
	//오버로딩 한 두번째 메서드 : String, int, int
	public void pr(String c, int a, int b) {
		System.out.println(c + "\t" + a + "\t" + b);
	}
}
public class ObjectEx10 {
	public static void main(String[] args) {
		Mt10 mt10 = new Mt10();
		mt10.pr(10, 20, "JAVA");
		mt10.pr("oracle", 100, 100);
	}
}
