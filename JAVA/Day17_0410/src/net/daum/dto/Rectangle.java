package net.daum.dto;

public record Rectangle(int width, int height) { // 레코드 선언 => 멤버변수 타입 앞에 private final 이 자동으로 추가되고,
	//멤버변수를 초기화 하기 위해서 개수만큼 생성자가 오버로딩이 된 것이 자동으로 추가, 멤버변수명과 같은 getter()메서드가 자동으로 추가되고
	//동등비교를 위한 equals()와 hashCode()메서드가 오버라이딩 되어서 자동으로 추가되고, 문자열 반환을 위한 toString()메서드가
	//오버라이딩이 되어서 추가된다.
}
