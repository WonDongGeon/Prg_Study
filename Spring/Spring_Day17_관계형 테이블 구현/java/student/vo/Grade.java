package student.vo;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Component
public class Grade {
	
	 private int gradeId;
	    private int studentId;  // 외래 키
	    private String subject;
	    private int score;
	    
	    public Grade() {
		System.out.println("Grade생성자 확인!!");
		}
	    
}
