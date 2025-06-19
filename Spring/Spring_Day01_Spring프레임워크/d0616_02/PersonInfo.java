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
public class PersonInfo {
	private String id; // 주민번호
	private String name; // 이름
	private String address; // 주소
}
