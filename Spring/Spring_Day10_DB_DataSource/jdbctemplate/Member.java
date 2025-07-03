package jdbctemplate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Member {
	private String id;
	private String password;
	private String name;
	private String address;
	private String hp;
	private String email;
}
