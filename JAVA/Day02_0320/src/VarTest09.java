/* short(허용값 32767 ~ -32768, char(허용값 0 ~ 65535) 기본타입 최대값, 최소값 범위를 벗어났을 때 어떤 값이 출력되는가? */
public class VarTest09 {

	public static void main(String[] args) {
		
		short sMin = -32768;// short타입 최소값을 저장
		System.out.println("sMin=" + sMin);
		System.out.println("sMin-1="+(sMin-1)); // sMin-1은 실제 short타입으로 뺄셈하는 것이 아니라 int - int, 즉 4바이트
		// int 타입으로 뺄셈을 한다. 결국은 int 타입 범위를 벗어나지 않아서 정상적인 뺄셈한 -32769가 출력된다.
		System.out.println("sMin-1="+(short)(sMin-1)); // short타입 최소값 범위를 벗어나서 최대값인 32767이 출력된다.
	
		short sMax = 32767; // short타입 최대값 저장
		System.out.println("sMax+1=" + (short)(sMax+1)); // short타입 최대값 범위를 벗어나서 최소값이 출력된다. -32768
		
		char cMin = 0; 
		System.out.println("--cMin =" + (int) --cMin); // --의 뜻은 1감소, char타입 최소값 범위를 벗어나서 최대값이 출력됨.
		
		
	}
}
