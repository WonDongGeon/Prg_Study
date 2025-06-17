package d0616_02;

public class GridPrint implements Print {
	PersonInfo info;
	
	public GridPrint() {
		//info=new PersonInfo();
	}
	 
	public GridPrint(PersonInfo info) {
		this.info = info;
	}
	
	public void setInfo(PersonInfo info) {
		this.info = info;
	}

	public PersonInfo getInfo() {
		return info;
	}

	public void print() {
		System.out.println("+-----------------------------------+");
		System.out.println("|주민등록번호|     이름     |     주소    |");
		System.out.println("+-----------------------------------+");
		System.out.println("|"+info.getId()+"|"+info.getName()+"|"+info.getAddress()+"|");
		System.out.println("+-----------------------------------+");
	}
}
