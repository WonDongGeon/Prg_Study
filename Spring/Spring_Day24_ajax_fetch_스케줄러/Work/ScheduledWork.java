package Work;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import restapi.Member;
//@Component
public class ScheduledWork {
	int i=1;
public ScheduledWork() {
System.out.println("*******스케줄러 객체 실행******");
}

//@Test
//@Scheduled(cron = "0/5 * * * * ?")
public void work1() {
System.out.println("scheduled execute : "+ (i++));
}

@Test
public void work2() throws MalformedURLException, IOException {
	String address="http://172.16.15.87:8888/api/members";
	URL url=new URL(address);
	//System.out.println(url.getProtocol());
	//System.out.println(url.getHost());
	//System.out.println(url.getPort());
	//System.out.println(url.getPath());
	InputStream in=url.openStream();
	int read=0;
	String data="";
	while((read=in.read())!=-1) {
		//System.out.print((char)read);
		data+=(char)read;
	}
	System.out.println(data);
	//위의 문자열 데이터를 파싱하세요.
	//1)순수코드를 이용하여 분해
	//(String 문자열 함수중에서 indexOf, length, substring, split)
	//[]를 없애라
	
	data=data.substring(1); // [삭제
	System.out.println(data);
	data=data.substring(0,data.length()-1); //]삭제
	System.out.println(data);
	String[] objs=data.split("},"); //객체의 내용을 문자열로 표시하는 방법
	System.out.println("objs"+objs);
	for(String s:objs) {
		System.out.println(s);
	}
	objs[0]+="}";
	System.out.println("char array:"+objs[0]);
	//코드완성해볼것
	
	//내가 생각하는 모든 코드는 함수로 만들어져 있다.
	List<Member> list=new ArrayList<Member>();
	ObjectMapper mapper=new ObjectMapper();
	System.out.println(objs[0]);
	Member member=mapper.readValue(objs[0],Member.class);
	System.out.println("object:"+member);
	list.add(member); //반복해서 처리
}
}




