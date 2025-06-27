package reboard;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
//입력을 하는 필드의 name을 확인하고 그에 맞춰 vo객체를 생성한다.
public class UpdateBoardForm {
	private int id;
	private String title;
	private String content;
	//private String attachment;
	private String author;
}
