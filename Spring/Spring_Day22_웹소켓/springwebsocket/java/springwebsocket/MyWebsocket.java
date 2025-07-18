package springwebsocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.Session;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebsocket extends TextWebSocketHandler implements InitializingBean{
	
	//static Set<WebSocketSession> sessions =new HashSet<WebSocketSession>();	
	//아래의 코드 변경
	static Set<WebSocketSession> sessions =new CopyOnWriteArraySet<>();	
	private volatile String msg;
	
	//open
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("spring socket open!!");		
		//접속한 클라이언트의 주소를 확인
		InetSocketAddress ipaddress=session.getRemoteAddress();
		System.out.println("Client IP : " + ipaddress.getAddress().getHostAddress());
		
		sessions.add(session);
	}
	/*
	//message
	@Override
	public void handleMessage(WebSocketSession session, 
			WebSocketMessage<?> message) throws Exception {
		System.out.println("spring socket message!!");
		super.handleMessage(session, message);
		//System.out.println("message:"+message);
		//System.out.println(message.getPayload());
		//String msg=(String) message.getPayload();//TextMessage  처리가능
		//System.out.println(msg);
		//session.sendMessage(msg); //오류발생
		//session.sendMessage(new TextMessage(msg));
		
		//위의 코드에서 하나만 보내는 메시지를 여러명에게 전송하는 방법
		//쓰레드를 이용하기 위해 함수를 호출하여 메시지 전송
		//sendMessage(msg);
		
		//수신된 텍스트를 추출하기
		
		if(message instanceof TextMessage) {
			String messagePayload=((TextMessage)message).getPayload();
			System.out.println(messagePayload);
			this.msg=messagePayload;
		}
		
	}
	*/
	
	//부분메시지를 처리할 경우
		@Override
		public boolean supportsPartialMessages() {
			System.out.println("부분메시지처리");
			return super.supportsPartialMessages();
		}
		
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("spring socket message!!");
		this.msg = message.getPayload(); //전역변수에 입력
	}
		
	public void sendMessage(String msg) {
		for(WebSocketSession s:sessions) {
			if(s.isOpen())
				try {
					s.sendMessage(new TextMessage(msg));} 
			    catch (IOException e) {	
			    	e.printStackTrace();
			    }
			}
	}
	//error
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println("spring socket message!!");
		super.handleTransportError(session, exception);
	}
	//close
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("spring socket close!!");
		super.afterConnectionClosed(session, status);
		sessions.remove(session);
	}
	//InitializingBean
	//aop사용해서 쓰레드 처리해주는 기능(실시간처리)
	/*
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("쓰레드 처리");
		Thread thread = new Thread() {
			@Override
			public void run() {
			 	while(true) {
			 		sendMessage(msg); //msg전역변수의 내용을 실시간으로 보내는 역할만 처리
			 		try {
						Thread.sleep(5000);
					} catch (Exception e) {
						e.printStackTrace();
					}
			 	}
			}
		};
		thread.start();
	}*/
	
	@Override
	public void afterPropertiesSet() {
		System.out.println("쓰레드 처리");
		Thread thread = new Thread(() -> {
			 	while(true) {
			 		if(msg != null && !msg.trim().isEmpty()) {
			 			sendMessage(msg); //msg전역변수의 내용을 실시간으로 보내는 역할만 처리
			 		}
			 		try {
						Thread.sleep(5000);
					} catch (Exception e) {
						Thread.currentThread().interrupt();
						e.printStackTrace();
					}
			 	}
		});
		thread.setDaemon(true); //JVM 종료시 
		thread.start();
	}
}