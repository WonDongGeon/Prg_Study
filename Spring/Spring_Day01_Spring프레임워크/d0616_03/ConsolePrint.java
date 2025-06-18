package d0616_03;

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
public class ConsolePrint implements Print {
	PrintInfo info;
	
	public void print() {
		System.out.println("주민등록번호 : " + info.getId());
		System.out.println("이      름 : " + info.getName());
		System.out.println("주      소 : " + info.getSungjuk());
	}
	
	public void print(int id, String name, Sungjuk sungjuk) {
		System.out.println("주민등록번호 : " + id);
		System.out.println("이      름 : " + name);
		System.out.println("국      어 : " + sungjuk.getKor());
		System.out.println("영      어 : " + sungjuk.getEng());
		System.out.println("수      학 : " + sungjuk.getMath());
	}
}
