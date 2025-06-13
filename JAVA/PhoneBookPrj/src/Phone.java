import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Phone {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("전화번호부 메뉴:");
			System.out.println("1. 연락처 추가");
			System.out.println("2. 연락처 보기");
			System.out.println("3. 종료");
			System.out.print("선택하세요 : ");
			String menuNo = scan.nextLine();
			System.out.println();
			
			switch(menuNo) {
			case "1" :
				System.out.println("언락처 추가하기");
				
				System.out.print("이름 : ");
		    	list.add(scan.nextLine());
		    	System.out.print("전화번호 : ");
		    	list2.add(scan.nextLine());
		    	System.out.print("이메일 : ");
		    	list3.add(scan.nextLine());
		    
		    	System.out.println("저장되었습니다.");
		    	System.out.println();
		    	
		    	break;
		    	
			case "2" :
				Iterator elements = list.iterator();
				Iterator elements2 = list2.iterator();
				Iterator elements3 = list3.iterator();
				
				System.out.println("연락처 목록 : ");
			    while(elements3.hasNext()) {
				     System.out.println("이름 : " + elements.next() + ", 전화번호 : " + elements2.next() + ", 이메일 : " + elements3.next());
			    }
			    System.out.println();
				break;
			case "3":
				System.exit(0);
				break;
			}
		}
	}
}
