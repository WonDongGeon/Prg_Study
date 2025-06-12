package member;

public class Member {
	private String id;
	private String password;
	private String hp;
	private String email;
	private String address;
	private String pic;
	public Member() {}
	public Member(String id, String password, String hp, String email, String address, String pic) {
		this.id = id;
		this.password = password;
		this.hp = hp;
		this.email = email;
		this.address = address;
		this.pic = pic;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", hp=" + hp + ", email=" + email + ", address="
				+ address + ", pic=" + pic + "]";
	}
	
	
}
