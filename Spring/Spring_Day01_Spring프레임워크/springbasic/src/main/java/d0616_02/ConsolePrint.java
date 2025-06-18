package d0616_02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ConsolePrint implements Print {
	PersonInfo info;
	public void print() {
		System.out.println("주민등록번호 : " + info.getId());
		System.out.println("이      름 : " + info.getName());
		System.out.println("주      소 : " + info.getAddress());
	}
}
