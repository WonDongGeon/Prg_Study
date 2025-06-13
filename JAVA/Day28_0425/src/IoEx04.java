/* java.io 패키지의 File클래스 api 특징)
 *  File클래스를 활용하면 일반 게시판에 파일 첨부기능이 들어간 자료실을 만들 수 있다. 여기서는 이 클래스 하위의 내장메서드인 list()를 활
 *  용해서 디렉토리에 있는 파일목록을 배열로 반환한다.
 */

import java.io.File;

public class IoEx04 {
	public static void main(String[] args) {

		File dirFile = new File("./src");//STS개발툴에서 인식하는 현재경로(./)는 프로젝트인 Day28_0425이다.
		String[] fileList = dirFile.list();
		
		//일반for 반복문으로 파일목록을 출력
		for(int i=0;i<fileList.length;i++) {
			System.out.println(fileList[i]);
		}
		System.out.println("\n ================== \n");
		
		//향상된 확장for 반복문으로 파일목록을 출력
		for(String fileName:fileList) {
			System.out.println(fileName);
		}
		System.out.println("\n ================\n");
	}
}
