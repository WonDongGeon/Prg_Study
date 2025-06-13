import java.util.Scanner;

public class PhoneBookMain extends PhoneBookImpl{
	public static void main(String[] args) {
		PhoneBookImpl pbfunc = new PhoneBookImpl();
		while(true) {
		
			switch(pbfunc.menu()) {
		
			case 1: //입력
				System.out.print("전화번호부에 입력할 이름을 입력하세요. : ");
				String name = new Scanner(System.in).nextLine();
				System.out.print("전화번호부에 입력할 전화번호을 입력하세요. : ");
				String hp = new Scanner(System.in).nextLine();
				System.out.print("전화번호부에 입력할 이메일을 입력하세요. : ");
				String email = new Scanner(System.in).nextLine();
				//next와 nextLine의 차이는
				//next는 뛰어쓰기 다음은 가져오지 않고, nextLine은 그것과 상관없이 한 줄을 가져옵니다.
				pbfunc.Insert(name, hp, email);
				break;
			case 2: //전체출력
				System.out.println("===================================");
				System.out.println("|	이름	 		|	 	전화번호		 |			 이메일 |");
				System.out.println("===================================");
				for(Phonebook pb : pbfunc.findAll()) {
					System.out.println("|  " + pb.getName() + " | " + pb.getHp() + " | " + pb.getEmail() + " |");
					System.out.println("----------------------------------------------------------------");
				}
				break;
			case 3: //선택출력		
				System.out.println("==전화번호부에 전화번호을 검색하여 이름찾기.==");
				System.out.print("전화번호를 입력하세요.");
				String searchhp = new Scanner(System.in).nextLine();
				Phonebook pb = pbfunc.findByHp(searchhp);
				System.out.print("이름 : " + pb.getName());
				System.out.print(" 전화번호 : " + pb.getHp());
				System.out.print(" 이메일 : " + pb.getEmail());
				System.out.println("");
				break;
			case 4: //수정
				System.out.println("=======전화번호부 수정=======");
			
				System.out.print("수정 이름 : ");
				String name1 = new Scanner(System.in).nextLine();
				System.out.print("수정 전화번호 : ");
				String phone1 = new Scanner(System.in).nextLine();
				System.out.print("수정 이메일 : ");
				String email1 = new Scanner(System.in).nextLine();
			
				pbfunc.Update(email1, name1, phone1);

				break;
			case 5: //삭제
				System.out.println("=======전화번호부 삭제=======");
			
				System.out.print("삭제할 전화번호부의 이메일 : ");
				String email2 = new Scanner(System.in).nextLine();
				pbfunc.delete(email2);
				break;
			default :
				
			}//switch
		}//while
	}//main
}
