package d0617_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import d0616_02.Print;

public class Main2 {

	public static void main(String[] args) throws IOException {
		File file
		=new File("D:/work/sts-3/workspace/springbasic/src/main/java/d0617_01/config.properties");
		FileInputStream in=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(in);
		
		ApplicationContext app
		=new ClassPathXmlApplicationContext("d0617_01/setting.xml");
		Print print=(Print)app.getBean(prop.getProperty("print"));
		print.print();
	}

}