package d0617_04;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main1 {
	//private static final Logger Log = Logger.getLogger(d0617_04.Main1.class.getName()); 
	
	private static final Logger Log = Logger.getLogger("d0617_04.Main1");
	
	public static void main(String[] args) {
		//System.out.println(d0617_04.Main1.class.getName());
		//System.out.println(d0617_04.Main1.class.getSimpleName);
		//System.out.println(Log);
		//log의 기본 단계 : info(정보제공), warning(경고), severe(심각)
		Log.info("정보제공 로그");
		Log.warning("경고 로그");
		Log.severe("심각 로그");
		System.out.println("--------------------");
		Log.setLevel(Level.SEVERE); // Level.ALL이 기본 값(전체) -> Level.SEVERE로 하면 심각로그만 나옴
		Log.info("정보제공 로그");
		Log.warning("경고 로그");
		Log.severe("심각 로그");
	}
}
