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
public class BoardViewPage {
	private int id;
	private String title;
	private String author;
	private Date createdate;
	private int viewcnt;
	private String content;
	private String attachment;
}