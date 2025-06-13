//File 클래스의 내장메서드 활용

import java.io.File;

public class IoEx12 {
	public static void main(String[] args) {

		String path="./src";
		File dir=new File(path);
		String[] fileNames = dir.list();//src 폴더의 파일목록을 문자열 배열로 반환
		for(String fileName:fileNames) {
			File f=new File(path+"/"+fileName);
			System.out.println("\n ==================== \n");
			System.out.println("파일이름: "+f.getName());
			System.out.println("경로: "+f.getPath());
			System.out.println("절대경로: "+ f.getAbsolutePath());
		    System.out.println("디렉토리 여부: "+ f.isDirectory()); //디렉토리이면 true, 아니면 false
		    System.out.println("파일 여부: "+ f.isFile());//파일이면 true, 아니면 false
		    System.out.println("\n =================== \n");
		}
	}
}
