/* 1차원 배열원소값중에서 최대값을 구한다.
 */
public class ArrayEx03 {
	public static void main(String[] args) {
		double data[] = {9,5,7,0,5,0,10,0,12,0,13,0};
		//배열 크기가 6인 data배열 생성
		double max = 0.0; //배열 원소 최대값을 저장할 변수
		
		for(int i = 0; i<data.length; i++) {
			if(data[i] > max) { //배열 원소값이 최대값보다 크면 실행
				max = data[i]; // 해당 배열원소값이 최대값으로 새롭게 저장
			}
		} //for
		
		System.out.printf("배열원소 최대값 = %f%n", max);
	}

}
