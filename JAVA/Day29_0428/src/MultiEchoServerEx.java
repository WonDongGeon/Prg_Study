/* 멀티쓰레드 기능이 들어간 다중 사용자 접속을 받을 수 있는 네트워크 서버 프로그램이다.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiEchoServerEx {
	ServerSocket server; //서버상에서만 필요하고 클라이언트 접속을 기다리기 위한 클래스
	static final int PORT = 7000; //TCP 포트번호
	Socket child; //클라이언트와 통신하기 위해 필요한 소켓
	
	public MultiEchoServerEx() {
		try {
			server = new ServerSocket(PORT);
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0); //프로그램 정상적인 종료
		}
		System.out.println("#######다중 사용자 접속을 기다리기 위한 멀티채팅 서버 #######");
		System.out.println("멀티채팅서버는 사용자 접속을 항상 기다리고 있습니다.");
		
		while(true) {
			try {
				child = server.accept(); //클라이언트 접속이 이루어 지면 서버상에서도 소켓이 생성(사용자 소켓 객체가 생성되는 시점)
				
				//멀티쓰레드
				EchoServerThread childThread = new EchoServerThread(child);
				Thread th = new Thread(childThread);
				th.start(); //멀티스레드 시작
				
			}catch(Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}// 생성자
	public static void main(String[] args) {
		new MultiEchoServerEx(); //생성자 호출
	}
}
//멀티쓰레드 => 네트워크 서버에서 다중 사용자 동시 접속을 받기 위해서 이 코드를 한다.
class EchoServerThread implements Runnable {
	Socket child; //클라이언트(사용자)와 통신하기 위한 소켓
	
	InputStream is;
	ObjectInputStream ois;
	
	OutputStream os;
	ObjectOutputStream oos;
	
	String receiveData; //사용자로부터 전송받은 자료를 저장하기 위한 변수
	
	public EchoServerThread(Socket child) {
		this.child =child;
		
		try {
			System.out.println(child.getInetAddress() + "로 부터 연결 요청"); //사용자 컴 ip주소를 반환
			
			is = child.getInputStream();
			ois = new ObjectInputStream(is);
			
			os = child.getOutputStream();
			oos = new ObjectOutputStream(os);
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}// 생성자 오버로딩
	
	@Override
	public void run() {
		try {
			while(true) {
				receiveData =(String)ois.readObject(); //클라이언트로 부터 받은 데이터를 저장
				System.out.println(child.getInetAddress() + "로 부터 받은 메시지 : " + receiveData);
				oos.writeObject(receiveData); //다시 사용자에게 전송
				oos.flush(); //출력스트림을 비운다.
			}// while 무한루프문
		}catch(Exception e) {
			System.out.println("사용자 강제종료");
		}
		finally {
			try {
				if(oos != null) oos.close(); //ObjectOutputStream
				if(os != null) os.close(); //OutputStream
				if(ois != null) ois.close(); // ObjectInputStrean
				if(is != null) is.close(); //InputStream
				if(child != null) child.close(); 
			}catch(IOException ie) {
				ie.printStackTrace();
			}
		}
	} // 추상메서드 run() 오버라이딩
}
