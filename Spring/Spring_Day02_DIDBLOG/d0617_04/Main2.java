package d0617_04;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main2 {
	
	private static final Logger Log = Logger.getLogger(d0617_04.Main2.class.getName());
	
	public static void main(String[] args) {
		try {
			FileHandler handler = new FileHandler("app.log");
			handler.setFormatter(new SimpleFormatter());
			Log.addHandler(handler);
			Log.info("info log");
			Log.warning("warning log");
			int result = 1/0;
		}catch (Exception e) {
			Log.severe("severe log");
		}
	}
}
