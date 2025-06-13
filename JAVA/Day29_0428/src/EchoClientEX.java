/*
 *  멀티쓰레드 기능이 없는 네트워크 클라이언트 프로그램
 */
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientEX {
	Socket client = null; //서버와 통신하기 위한 소켓
	String ip = null; //서버 ip주소를 저장하기 위한 변수
	static final int PORT = 7000; //서버와 동일한 포트번호를 지정
	
	Scanner scan  = null;
	
	InputStream is;
	ObjectInputStream ois; //입력스트림
	
	OutputStream os;
	ObjectOutputStream oos; //출력스트림
	
	String sendData; //서버로 보낼 메시지를 저장할 변수
	String receiveData; //서버에서 받은 메시지를 저장할 변수
	
	public EchoClientEX(String ip) {
		this.ip = ip;
		try {
			System.out.println("####### 클라이언트 채팅 프로그램 #######");
			client = new Socket(ip, PORT); // 사용자 소켓 생성
			scan = new Scanner(System.in);
			
			os = client.getOutputStream();
			oos = new ObjectOutputStream(os);
			
			is = client.getInputStream();
			ois = new ObjectInputStream(is);
			
			System.out.println("데이터 입력>>");
			
			while((sendData = scan.nextLine()) != null) {
				oos.writeObject(sendData); //서버로 전송
				oos.flush(); //출력스트림 비움
				
				if(sendData.equals("exit")) {
					break;
				}
				receiveData = (String)ois.readObject(); //서버로 부터 전송받은 메시지를 저장
				System.out.println(client.getInetAddress() + "로 부터 전송받은 메시지 : " + receiveData);
				System.out.print("입력 >>");
			}// while 반복문
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}finally {
			try {
				if(ois != null) ois.close();
				if(is != null) is.close();
				if(oos != null) oos.close();
				if(os != null) os.close();
				if(client != null) client.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new EchoClientEX("172.16.15.87"); //생성자 인자값으로 서버 ip주소가 들어간다. localhost는 모든 내 자신 컴퓨터를 의미
		//호스트 이름이다. 127.0.0.1도 모든 내 자신 컴퓨터를 의미하는 ip주소이다. => 이것은 결국 내 자신 컴퓨터가 채팅프로그램 서버이고
		//클라이언트가 되기 때문이다.
	}
}
