/*16장 상속.pdf의 No.26 4번문제)
 * 4. 다음과 같은 상속 관계를 갖는 두개의 클래스를 설계하시오. 설계된 클래스로 다음과 같이 객체 생성하여 메서드를 호출
하면 실행결과와 같이 출력되도록 합시다.
 */
class HandPhone {
	protected String model;
	protected String number;
	public HandPhone() {}
	public HandPhone(String model, String number) {
		this.model = model;
		this.number = number;
	}
	public String getModel() {
		return model;
	}
	public String getNumber() {
		return number;
	}
}
class DicaPhone extends HandPhone {
	protected String pixel;
	public DicaPhone() {};
	public DicaPhone(String model, String number, String pixel) {
		super(model, number);
		this.pixel = pixel;
	}
	public void prnDicaphone() {
		System.out.println("모델명 : " + model + " 번호 : " + number + " 화소수 : " + pixel);
	} 
}
public class Ex16_05 {

	public static void main(String[] args) {
		DicaPhone dp=new DicaPhone("갤럭시", "010", "1024"); 
		dp.prnDicaphone( );
	}

}
