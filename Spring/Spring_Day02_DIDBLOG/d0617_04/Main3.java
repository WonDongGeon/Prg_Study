package d0617_04;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main3 {
	
	private static final Logger Log = Logger.getLogger(d0617_04.Main3.class.getName());
	
	public static void main(String[] args) {
		try {
			FileHandler handler = new FileHandler("login.log",true);
			handler.setFormatter(new SimpleFormatter());
			Log.addHandler(handler);
			
			String id = null;
			String password = "1234";
			
			if(id.equals("admin") && password.equals("1234")) {
				Log.info("login success!!");
			}else {
				Log.warning("login fail!! : " + id + ", " + password);
			}
		}catch (Exception e) {
			Log.severe(e.getMessage());
		}
	}
}

//로그파일이 새로 실행될 경우 누적하여 데이터를 처리하는 방법을 확인하시오.

