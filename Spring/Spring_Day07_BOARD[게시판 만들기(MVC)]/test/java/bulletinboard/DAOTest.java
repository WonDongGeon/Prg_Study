package bulletinboard;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DAOTest {

	@Test
	public void test() {
		Date now=new Date();
		System.out.println(now);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년MM월dd일");
		System.out.println(sdf);
		System.out.println(sdf.format(now));
	}

}


