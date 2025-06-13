/* ! 논리 부정 */
public class EqualsEx03 {

	public static void main(String[] args) {
		boolean flag = true;
		
		System.out.printf("flag = %b\n", flag);
		System.out.printf("!flag=%b\n", !flag); // !true -> false
		System.out.printf("!!flag = %b\n", !!flag); // !!true -> !false -> true
		
	}
}
