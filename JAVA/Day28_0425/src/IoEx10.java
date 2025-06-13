//객체 직렬화를 위해서 설계한 Customer.java를 활용해서 객체단위로 기록해 본다.

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class IoEx10 {
	public static void main(String[] args) {

		Customer cus = new Customer(7, "홍길동", 25, 177.7);
		
		try {
			System.out.println(cus.toString());
			FileOutputStream fos = new FileOutputStream("./src/output.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cus);//객체 단위로 기록
			
			oos.close();
			fos.close();		
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}
