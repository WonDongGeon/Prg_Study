//InterfaceB는 non-sealed 키워드로 비봉인 인터페이스로 정의 => 다른 자손 인터페이스를 만들 수 있다.
public non-sealed interface InterfaceB extends InterfaceA {
	void methodB(); //public abstract 생략
}
