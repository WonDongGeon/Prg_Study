/* 스트림과 람다식을 활용해서 컬렉션 원소값을 쉽게 읽어온다. */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaStreamExample {
	public static void main(String[] args) {

		List<Student> studentList = Arrays.asList(
				   new Student("홍길동", 100),
				   new Student("신사임당님", 99)
				);
		
		Stream<Student> stream = studentList.stream();//스트림 생성
		stream.forEach(s->{
			String name = s.getName();//학생명
			int score = s.getScore();//점수
			System.out.println("학생명 : "+name+", 점수="+score);		
		});
	}
}
