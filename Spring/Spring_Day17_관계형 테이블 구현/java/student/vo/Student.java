package student.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Component
public class Student {
    private int studentId;
    private String name;
    private String major;
    private List<Grade> grades;  // 1:N 관계
    
    public Student() {
    	System.out.println("student생성자 확인!");
	}
}