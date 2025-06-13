//스트림과 매개변수 메서드 참조를 활용해서 학생점수 평균을 실수숫자타입으로 구해본다.

import java.util.Arrays;
import java.util.List;

public class StreamLambdaExample {
	public static void main(String[] args) {

		List<Student> studentList = Arrays.asList(
				  new Student("홍길동",100),
				  new Student("이순신",96),
				  new Student("강감찬",98)
				);
		
		double avg= studentList.stream()
				    .mapToInt(Student :: getScore) //매개변수 메서드 참조를 활용해서 학생점수를 구함
				    .average() //점수 평균을 구함
				    .getAsDouble(); //평균을 실수숫자로 변경
		
		System.out.println("평균점수="+avg);
	}
}
