package board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
*/
@Data
@ToString
public class Board {
	private int id;
	private String title;
	private String author;
	private Date createdate;
	private String content;
	private String attachment;
	private int viewcnt;
	private String type;
}