/* 단일문자 char[] 배열과 string 문자열 클래스
 */
public class ObjectArrEx03 {
	public static void main(String[] args) {
		String str = "Java";
		str = str + 8; //문자열 + 숫자에서 자바는 문자를 우선해서 숫자 8이 문자열 "8"로 변경된다. 결국 +는 문자열 연결 연산기호가 된다.
		System.out.printf("%s\n", str);
		
		String str01 = "ABCDE";
		char ch = str01.charAt(3); //charAt(3)내장메서드는 첫문자를 0부터 시작해서 네번째 단일문자 'D'를 구함.
		System.out.println("구해진 단일문자 : \'"+ch+"\'");
		
		String str02 = "012345";
		String result = str02.substring(1,4); //substring(1, 4)내장메서드는 첫문자를 0부터 시작해서 1이상 4미만 사이의
		// 문자열을 반환 => "123"
		System.out.println(result);
		
		String src = "ABCDE";
		
		System.out.println("src문자열 길이 : " + src.length()); // length()메서드는 첫문자를 1부터 카운터 해서 문자길이를 반환
		
		for(int i = 0; i < src.length(); i++) {
			char ch02 = src.charAt(i); // 첫문자를 0부터 시작해서 i번째 단일문자를 구함
			System.out.println("src.charAt("+i+") : " + ch02);
		}
		
		char[] chArr = src.toCharArray(); //string 문자열을 단일문자 char[]배열로 반환
		System.out.println(chArr);
	}
}
