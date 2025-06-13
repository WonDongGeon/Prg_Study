/* non-sealed 비봉인 자손 클래스 Manager로 정의했기 때문에 또 다른 자손클래스 생성을 할 수 있다.
 * 
 */
public non-sealed class Manager extends Person {
	@Override
	public void wor() {
		System.out.println("생산 관리를 합니다.");
	}
}
