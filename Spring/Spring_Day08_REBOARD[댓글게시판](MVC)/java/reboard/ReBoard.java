package reboard;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
@Data
@Builder
public class ReBoard {
	private int id; 
	private String title; 
	private String author; 
	private Date createdate; 
	private String content; 
	private String attachment; 
	private int viewcnt; 
	private String type; 
	private int isdel;
	private Date updatedate;
	private int parentid; 
	private int tab; 
}
