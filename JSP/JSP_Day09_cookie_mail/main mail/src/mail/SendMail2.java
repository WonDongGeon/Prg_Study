package mail;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail2 {

	public static void main(String[] args) {
		//메일을 보낼 때 필요한 일반 사항(보내는주소, 받는 주소, 메일내용)
		//정보를 한번에 저장하는 객체
		Properties props=System.getProperties();
		props.put("mail.smtp.host","smtp.naver.com");
		props.put("mail.smtp.port","587");
		props.put("defaultEncoding","utf-8");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.auth","true");
		
		try {
		String userid="계정명";
		String userpw="비밀번호";
		
		//위의 정보를 이용하여 서버연결(session)
		//라이브러리 추가(javax activation, javax mail)
		//Session session=Session.getInstance(props,인증관련객체);
		Session session=Session.getInstance(props, 
new Authenticator() {
protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
return new PasswordAuthentication(userid, userpw);			 
}
}
);
		/*
		Authenticator auth=new Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(userid, userpw);			 
			}
		};
		Session session=Session.getInstance(props,auth);
		*/
		//메일 보내기(보내는주소, 받는 주소, 메일내용)
		String sendemail="자신의 이메일주소";
		String recvemail="자신의 이메일주소";
		String title="test 메일제목";
		String content="테스트메일입니다.";
		session.setDebug(false);
		
		//콘솔로부터 데이터 입력
		Scanner scan=new Scanner(System.in);
		System.out.println("보내는 메일주소를 입력하세요?");
		recvemail=scan.nextLine();
		System.out.println("제목을 입력하세요?");
		title=scan.nextLine();
		System.out.println("내용을 입력하세요?");
		content=scan.nextLine();
		
		Message msg=new MimeMessage(session); //연결이 설정된 객체주입
		
		msg.setFrom(new InternetAddress(sendemail));
		//msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recvmail));
		InternetAddress[] recvs=new InternetAddress[1];
		recvs[0]=new InternetAddress(recvemail);
		msg.setRecipients(Message.RecipientType.TO, recvs);
		msg.setSubject(title);
		msg.setText(content);
		
		Transport.send(msg); //메일보내기
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
// 받는주소와 제목, 내용을 콘솔에 입력하여 메일 발송하는 코드로 변경
//new Scanner(System.in)





