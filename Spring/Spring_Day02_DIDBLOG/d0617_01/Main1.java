package d0617_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Main1 {

	public static void main(String[] args) throws IOException {
		File file=new File("D:/work/sts-3/workspace/springbasic/src/main/java/d0617_01/config.properties");
		FileInputStream in=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(in);
		System.out.println(prop);
		System.out.println(prop.getProperty("objectname1"));
		System.out.println(prop.getProperty("objectname2"));
		//반대로 설정파일 변경되었을 경우 파일에 저장하는 방법
		prop.setProperty("objectname2","myprint");
		System.out.println(prop);
		FileOutputStream out=new FileOutputStream(file);
		prop.save(out,"objectname2 value change");

	}

}