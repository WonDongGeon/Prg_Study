/* java 7버전에서 AutoCloseable 인터페이스가 추가되었다. 이 인터페이스를 구현 상속받는 자손 API는 try()내에서
 * 객체를 생성하면 굳이 finally문에서 명시적 코드로 close() 닫지 않아도 자동으로 닫힌다. <- ★★★★★
 */

import java.io.PrintWriter;
import java.util.ArrayList;

public class TryCatch14 {
	public static void main(String[] args) throws Exception {
		ArrayList<String> nameList = new ArrayList<>();
		
		nameList.add("hong gil dong");
		nameList.add("Lee sun shin");
		nameList.add("kang kam chan");
		
		//STS 나 이클립스에서 기본 경로로 인식하는 것은 프로젝트 경로이다. Day23_0418 경로를 기본경로 인식한다.
		// ./는 현재 프로젝트 경로를 의미한다. java.io 패키지의 PrintWriter는 문자 출력스트림 API이다.
		try(PrintWriter out = new PrintWriter("./src/result.txt")) {
			// java.io패키지의 PrintWriter 출력스트림 api는 AutoCloseable 인터페이스를 구현상속받은 자손 API이다
			for(String name : nameList) {
				out.println(name.toUpperCase()); //영문 대문자로 변경해서 result.txt에 기록한다.
			}//향상된 확장 for
		}//try
		
	}
}
