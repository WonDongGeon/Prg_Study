/* 자바 21에서 추가된 가상 스레드 생성법 3가지
 * 
 */
public class TwoEx03 {
	public static void main(String[] args) {
		
		//자바 21 : 첫번째 방법
		Thread.startVirtualThread(() -> {
			System.out.println("첫번째 가상 스레드 생성하는 법");
		});
		
		//자바 21 : 두번째 방법
		Thread.ofVirtual()
					.start(() -> {
						System.out.println("두번째 가상 스레드 생성");
		});
		
		//자바 21 : 스레드 이름을 설정하는 세번째 방법
		Thread virtualThread03 = Thread.ofVirtual()
					.name("downloadThread") //스레드 이름 설정
					.start(() -> {
						System.out.println("스레드 이름으 설정한 세번째 가상스레드 생성");
					});
		
		System.out.println("virtualThread03 스레드 이름 : " + virtualThread03.getName());
	}
}
