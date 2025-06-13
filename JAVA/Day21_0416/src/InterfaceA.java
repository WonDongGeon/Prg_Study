// sealed 키워드로 봉인된 인터페이스 interfaceA 정의 => permits 키워드 다음에 정의된 InterfaceB만 자손 인터페이스로 정의 가능
public sealed interface InterfaceA permits InterfaceB {
	void methodA(); 
}
