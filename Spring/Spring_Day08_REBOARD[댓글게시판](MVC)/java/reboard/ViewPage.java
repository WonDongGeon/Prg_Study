package reboard;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViewPage {
	private int id;
	private String title;
	private String author;
	private Date createdate; //수정일시 해당 내용을 날짜로(updatedate값이 null인 경우 creaetedate사용하고, 그렇지 않은 경우는 updatedate를 사용)
	private Date updatedate; //수정일시 해당 내용을 날짜로(updatedate값이 null인 경우 creaetedate사용하고, 그렇지 않은 경우는 updatedate를 사용)
	private int viewcnt;
	private String content;
	private String attachment;
	private int tab;
	//아래코드가 필요한가? 
	//댓글쓰기를 누를 떄 폼이 생성되는데 이때 아이디를 전달하여 parentid, tab내용 획득 후 사용
	//또는 아래의 코드를 전달받아 폼으로 전송해서 사용하는 방법
	//private int parentid; 
	//private int tab; 
}
