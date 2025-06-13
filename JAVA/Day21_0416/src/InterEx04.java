//봉인된 / 비봉인된 인터페이스를 활용하는 예제
public class InterEx04 {
	public static void main(String[] args) {
		ImpClass imp =new ImpClass();
		
		InterfaceA ia = imp; //업캐스팅
		ia.methodA();
		
		System.out.println("\n=====================>\n");
		
		InterfaceB ib = imp;
		ib.methodA();
		ib.methodB();
		
		System.out.println("\n=====================>\n");
		
		InterfaceC ic =imp;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}
