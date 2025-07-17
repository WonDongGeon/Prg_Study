package board;

import java.util.Date;

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
public class Writing {
	int id;
	String title;
	String author;
	Date createdate;
	String content;
	String attatchement;
	int viewcnt;
	String type;
}