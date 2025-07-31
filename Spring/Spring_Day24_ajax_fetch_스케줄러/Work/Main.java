package Work;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import restapi.Member;

public class Main {
	public static void main(String[] args) throws IOException {
		String address="http://172.16.15.87:8888/api/members";
		URL url=new URL(address);
		InputStream in=url.openStream();
		int read=0;
		String data="";
		while((read=in.read())!=-1) {
			//System.out.print((char)read);
			data+=(char)read;
		}
		
		ObjectMapper mapper=new ObjectMapper();
		List<Member> memberList = mapper.readValue(data, new TypeReference<List<Member>>() {});
        for (Member member : memberList) {
            System.out.println(
            		member.getUsername() 
            		+ " - " + member.getPassword()
            		+ " - " + member.getEmail()
            		);
        }
	}

}