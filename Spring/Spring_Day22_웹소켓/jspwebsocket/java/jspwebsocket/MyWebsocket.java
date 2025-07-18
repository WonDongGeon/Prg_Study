package jspwebsocket;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class MyWebsocket {
	
	//세션 리스트를 무엇으로 관리할 것인가?
	//array, list(중복o), set(중복x), map
	//map은 key와 value로 이루어진 컬렉션 프레임워크
	//최종적으로 set을 이용(중복이 되지 않으므로)
	static Set<Session> sessions = new HashSet<Session>();
	
	
	@OnOpen
	public void open(Session session) {
		System.out.println("소켓 open");
		sessions.add(session);
		System.out.println("현재 접속자수 : " + sessions.size());
		//접속은 종료도 고려, 종료시 session제거(close함수처리)
	}
	
	@OnMessage
	public void message(String message, Session session) {
		System.out.println("소켓 메시지 수신");
		System.out.println("client에서 온 메시지" + message);
		//메시지 보내는 방법
		try {
			//여러명의 사용자에게 메시지 보내기
			for(Session s:sessions) {
				//if(s.isOpen() && session!=s)
				if(s.isOpen()) s.getBasicRemote().sendText(message);
				//전송되는 값이 json형태의 문자열인 경우 문자열이므로 단순하게 전송하면 되지만
				//값의 가공이 발생할 경우 JSON객체로 변환 후 다시 문자열로 변환하여 처리해야함.
				//자바에서 JSONObject를 이용하여 
			}
			//자신에게는 메시지를 전송하지 않도록 처리
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//보내온 클라이언트의 정보 확인
		System.out.println(session);
		//여러 세션을 관리(함수안에서 리스트를 선언하면 한번 실행 후 정보가 삭제가 되므로 전역변수로 선언
	}
	
	@OnError
	public void error(Throwable throwable) {
		System.out.println("소켓 error 발생");
	}
	
	@OnClose
	public void close(Session session) {
		System.out.println("소켓 닫음");
		sessions.remove(session);
		System.out.println("현재 접속자수 : " + sessions.size());
	}
	
}
