import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class IoEx09 {
	public static void main(String[] args) {

		String fileName;
		String buf;
		
		Reader myIn = new InputStreamReader(System.in);//업캐스팅
		/* 1. System.in 은 키보드 입력장치와 연결됨
		 * 2. InputStreamReader는 읽어들인 바이트를 문자로 변환
		 * 3. Reader는 문자 입력스트림의 최상위 추상클래스이다.
		 */
		BufferedReader keyBr = new BufferedReader(myIn);
		//BufferedReader는 읽어들인 문자를 버퍼링한 다음 효율적으로 읽어들임.
		
		try {
	        System.out.print("파일명 입력(./src/IoEx09.java)>>");
	        fileName = keyBr.readLine();
	        
	        FileReader fr = new FileReader(fileName);
	        //주어진 파일로 부터 문자단위로 읽어들임
	        BufferedReader fileBr = new BufferedReader(fr);
	        
	        while((buf = fileBr.readLine()) != null) {//더 이상 읽을 내용이 없다면 null
	        	System.out.println(buf);//읽어들인 파일내용을 출력
	        }
	        
	        fileBr.close(); fr.close();
		}catch(IOException ie) {ie.printStackTrace();}
		finally {
			try {
				if(keyBr != null) keyBr.close();
				if(myIn != null) myIn.close();
    		}catch(Exception e) {e.printStackTrace();}
		}
	}
}
