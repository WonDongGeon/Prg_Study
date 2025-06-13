/* 소수점 이하 넷째 자리에서 반올림을 하지 않고 버림하는 경우 */
public class OprEx12 {

	public static void main(String[] args) {
		
		float pi = 3.141592f;
		float shortpi = (int)(pi*1000)/1000f;
		/* float * int는 자동산술법에 의해서 float*float가 된다. 즉 3.141592 * 1000.0f = 3141.592f가 된다.
		 * 이것을 (int)로 명시적인 형변환을 하면 소수점이하는 반올림을 하지 않고 버림을 한다.
		 * 결국 결과값은 3141이 된다. 3141/1000f는 자동산술법에 의해서 3141f/1000f
		 * = 3.141f가 된다.
		 */
		System.out.println("shortpi = " + shortpi);
		
	}

}
