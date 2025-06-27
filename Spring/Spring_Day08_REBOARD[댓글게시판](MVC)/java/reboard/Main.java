package reboard;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		ReBoard board = new ReBoard.ReBoardBuilder().title("댓글게시글 제목1").content("댓글게시글 내용").build();
		System.out.println(board);
		ReBoard board2=new ReBoard.ReBoardBuilder().id(1).createdate(new Date()).build();
		System.out.println(board2);
	}
}
