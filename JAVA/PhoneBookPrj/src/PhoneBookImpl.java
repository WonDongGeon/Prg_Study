import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookImpl implements PhoneBookInter {
	
	//셋 중에서 하나 선택
	//Phonebook[] array;
	List<Phonebook> list;// 가장 많이 사용됨
	//List<Phonebook> list = new ArrayList<Phonebook>();  // <- 선언방법
	//String sarray;	
	public PhoneBookImpl() {
	    list = new ArrayList<>();
	}
	
	public int menu() {
		while(true) {
			System.out.println("=======MENU=======");
			System.out.println("1. 전화번호부 입력");
			System.out.println("2. 전화번호부 전체출력");
			System.out.println("3. 전화번호부 선택출력");
			System.out.println("4. 전화번호부 수정");
			System.out.println("5. 전화번호부 삭제");
			System.out.println("===================");
			
			int sel = new Scanner(System.in) .nextInt();
			return sel;
		}
	}
	
	@Override
	public int Insert(String name, String hp, String email) {
		//어떤 상황일 떄 오류가 발생하는지 확인
		//입력값 중 하나이상이 null값일 때 오류발생
		if(name == null || hp == null || email == null) {
			System.out.println("입력한 값 중 null값 발생하여 중지");
			return 0;
		}
		//입력한 값이 정규식에 일치하지 않을 때 오류 발생
		String regex = "^010-\\d{4}-\\d{4}$";
		if(!hp.matches(regex)) { // "010-XXXX-XXXX" 형식(regex)의 전화번호만 유효하다고 판단하는 패턴
			System.out.println("유요하지 않은 전화번호입니다.");
			return 0;
		}
		//오류발생할 때 리턴값을 0, 그렇지 않으면 1
		Phonebook pb = new Phonebook(name, hp, email);
		list.add(pb);
		return 1;
	}

	@Override
	public List<Phonebook> findAll() {
		list= new ArrayList<Phonebook>();
		return list;
	}

	//한명 찾기
	@Override
	public Phonebook findByHp(String hp) {
		for(Phonebook pb : list) {
			if(pb.getHp().equals(hp)) {
				return pb;
			}
		}
		return null;
	}
	
	//여러명 찾기
	public List<Phonebook> findByName(String name) {
		List<Phonebook> findlist = new ArrayList<Phonebook>();
		for(Phonebook pb : list) {
			if(pb.getHp().equals(name)) {
				findlist.add(pb);
			}
		}
		return findlist;
	}
	
	@Override
	public int Update(String email, String name, String hp) {
		
		if(name == null || hp == null || email == null) {
			System.out.println("입력한 값 중 null값 발생하여 중지");
			return 0;
		}
		String regex = "^010-\\d{4}-\\d{4}$";
		if(!hp.matches(regex)) { // "010-XXXX-XXXX" 형식(regex)의 전화번호만 유효하다고 판단하는 패턴
			System.out.println("유요하지 않은 전화번호입니다.");
			return 0;
		}
		
		System.out.println("수정할 전화번호부의 전화번호를 입력하세요.");
		String phone = new Scanner(System.in).nextLine();
		
		for (int i = 0; i < list.size(); i++) {
	        Phonebook pb = list.get(i);
	        if (pb.getHp().equals(phone)) {
	            // 업데이트할 새 정보를 반영
	            Phonebook updated = new Phonebook(name, hp, email);
	            list.set(i, updated);
	            System.out.println("전화번호부가 성공적으로 수정되었습니다.");
	            return 1;
	        }
	    }
		System.out.println("해당 전화번호를 가진 항목이 없습니다.");
		return 0;
	}

	@Override
	public int delete(String email) {
		
		for (int i = 0; i < list.size(); i++) {
	        Phonebook pb = list.get(i);
	        if (pb.getEmail().equals(email)) {
	            // 해당 정보를 삭제
	            list.remove(i);
	            System.out.println("전화번호부가 정상적으로 삭제되었습니다.");
	            return 1;
	        }
	    }
		System.out.println("해당 이메일은 없습니다.");
		return 0;
	}

}
