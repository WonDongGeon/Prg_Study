/* 문제)12장.메서드살피기.pdf No.20의 2번 문제  
 * 2. 속성으로 메모리 용량과 회사명을 저장하는 변수를 갖는
 * Mp3 클래스를 설계하고 다음과 같은 결과가 나오도록 객체
 * 생성 후 메소드를 호출하시오.(Ex12_02.java)
 */
class Mp3 {
	private String comp;
	private int size;
	public void setComp(String new_comp) {
		 comp = new_comp;
	}
	public String getComp() {
		return comp;
	}
	public void setSize(int new_size) {
		size = new_size;
	}
	public int getSize() {
		return size;
	}
}
public class Ex12_02 {
	public static void main(String[] args) {
		Mp3 mp3 = new Mp3();
		
		mp3.setComp("갑을회사");
		mp3.setSize(8);
		System.out.printf("회사명 : %s\n메모리 용량 : %dG%n", mp3.getComp(), mp3.getSize());
	}

}
