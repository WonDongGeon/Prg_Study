//객체 직렬화에서 객체단위로 읽어오기

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class IoEx11 {
	public static void main(String[] args) {

		try {
			FileInputStream fis=new FileInputStream("./src/output.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Customer cus = (Customer)ois.readObject();//객체단위로 읽어오기
			System.out.println(cus.toString());
			
			ois.close();
			fis.close();
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}
