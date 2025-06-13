/* 1. 문자열을 다루는 String 내장 api클래스는 자기 자신 내용을 수정할 수 없다.
 * 2. StringBuffer 내장 api는 자기 자신값을 수정할 수 있다.
 * 
 */
public class InterEx12 {
	public static void main(String[] args) {
		String cityName = "seoul";
		System.out.println("도시 이름을 영문대문자로 : " + cityName.toUpperCase()); 
		System.out.println("cityName : " + cityName);
		System.out.println("문자길이 : " + cityName.length());
		System.out.println("\'seoul\'의 세번째 문자 : " + cityName.charAt(2)); //o, charAt(2)메서드는 첫문자를 0부터 시작해서
		//세번째 단일문자를 구함.
		System.out.println("\'seoul\'에서 u가 몇번째 저장되었는가?" + (cityName.indexOf('u')+1));
		//indexOf('u')메서드는 단일문자 u를 맨 왼쪽에서 부터 찾아서 가장 먼저 나오는 해당문자 위치번호를 첫문자를 0부터 카운터
		//해서 구한다.
		
		StringBuffer str01 = new StringBuffer();
		str01.append("Java"); //Java문자 추가
		str01.append("Programming"); 
		System.out.println("추가된 문자 : " + str01.toString());
		
		//0이상 4미만 사이의 문자반환
		String str02 = str01.substring(0, 4); 
		System.out.println("0이상 4미만 사이의 문자 반환 : " + str02); //Java
		
		str01.replace(0, 4, "JSP"); //0이상 4미만 사이의 문자를 JSP로 변경
		System.out.println("0이상 4미만 사이의 문자 변경 : " + str01.toString());
	}
}
