package d0616_03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student  {
	private int id;
	private String name;
	private Sungjuk sungjuk;
	private Print print;
}

//객체 같은 경우 단순히 데이터를 전달하는 객체(VO)-기본생성자, 필드생성자, get, set, toString
//기능 객체가 주가될 경우 별도의 객체로 생각
//Print는 인터페이스(단순하게 연결), 연결시 데티러르 별도로 전달
