package d0616_03;

public class GridPrint implements Print {
	PrintInfo info;
	
	public GridPrint() {
		// TODO Auto-generated constructor stub
	}
	
	public PrintInfo getInfo() {
		return info;
	}

	public void setInfo(PrintInfo info) {
		this.info = info;
	}

	public GridPrint(PrintInfo info) {
		this.info = info;
	}

	public void print() {
		System.out.println("+-----------------------------------+");
		System.out.println("|주민등록번호|     이름     |     주소    |");
		System.out.println("+-----------------------------------+");
		System.out.println("|"+info.getId()+"|"+info.getName()+"|"+info.getSungjuk()+"|");
		System.out.println("+-----------------------------------+");
	}
	
	public void print(int id, String name, Sungjuk sungjuk) {
		System.out.println("+-------------------------------------+");
		System.out.println("|   아이디   |     이름     |     성적    |");
		System.out.println("+-------------------------------------+");
		System.out.println("|"+id+"|"+name+"|"+sungjuk+"|");
		System.out.println("+-------------------------------------+");
	}
}
