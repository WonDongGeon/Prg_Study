//main() 메서드도 단일 스레드이다. 이 스레드 이름을 출력해 본다.
public class ThreadEx02 {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()); //현재 실행중인 스레드 이름을 반환
	}
}
