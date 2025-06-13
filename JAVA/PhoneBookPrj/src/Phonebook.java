// value object(vo객체)
public class Phonebook {
	private String name;
	private String hp;
	private String email;
	
	//기본생성자, 필드생성자, get, set함수, toString함수
	public Phonebook() {
		// TODO Auto-generated constructor stub
	}
	
	public Phonebook(String name, String hp, String email) {
		super();
		this.name = name;
		this.hp = hp;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Phonebook [name=" + name + ", hp=" + hp + ", email=" + email + "]";
	}
	
	
}
