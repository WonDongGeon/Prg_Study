/* 길이가 10인 배열을 만들고 이 배열에 0~9까지의 임의의 정수 난수로 배열원소값을 초기화 한다.
 * 그리고 이 배열에 저장된 각 숫자가 몇 번 반복해서 나타나는지를 카운터(세어서) 또 다른 배열 counter에 담은 다음 출력하는 소스이다.
 * 
 */
public class ObjectArrEx01 {
	public static void main(String[] args) {
		int[] num = new int[10];
		int[] counter = new int[10];
		
		//정수 난수로 배열원소값을 초기화 한 다음 바로 출력
		for(int i = 0; i < num.length; i++) {
			int r = (int)(Math.random() * 10); 
			num[i] = r;
			System.out.print(" " + num[i]);
		}
		System.out.println("\n======================>\n");
	
		for(int i = 0; i < num.length; i++) {
			counter[num[i]]++;
		}
		for(int i = 0; i < num.length; i++) {
		System.out.println( i+ "의 개수 = " + counter[i]);
		}
	}

}
