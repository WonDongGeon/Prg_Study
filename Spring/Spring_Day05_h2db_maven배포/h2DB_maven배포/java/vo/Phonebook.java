package vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Phonebook {
	private int id;
	private String name;
	private String hp;
	private String email;
	private String memo;
	
}
