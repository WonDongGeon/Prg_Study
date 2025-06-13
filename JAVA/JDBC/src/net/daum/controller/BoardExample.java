package net.daum.controller;

import java.util.List;
import java.util.Scanner;

import net.daum.dao.BoardDAOImpl;
import net.daum.dto.BoardDTO;

public class BoardExample { //게시판

	private Scanner scan = new Scanner(System.in);

	//게시판 목록(list)
	public void list() {
		System.out.println();
		System.out.println("[게시판 목록]");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		/* %-6s는 문자열 출력형태 지정자이다. -는 왼쪽 정렬, 6은 최소 출력 너비 6칸, %s는 문자열 출력형태 지시자
		 * 결국 %-6s는 문자열을 왼쪽 정렬하고 전체 너비를 6칸으로 맞추라느 의미이다. 빈 칸이 남으면 오른쪽 공백이 들어간다. 
		 */
		System.out.println("-------------------------------------------------------------------------------");
		
		BoardDAOImpl bdao = new BoardDAOImpl();
		List<BoardDTO> blist = bdao.getBoardList(); //게시판 목록
		
		if(blist != null && blist.size() > 0) {
			for(BoardDTO b : blist) {
				System.out.printf("%-6s%-12s%-16s%-40s\n", b.getBno(), b.getBwriter(), b.getBdate(), b.getBtitle());
			}
		}else {
			System.out.println("게시판 목록이 없습니다.");
		}
		mainMenu(); //메인 메뉴 메서드 호출
	}//list
	
	//메인 메뉴
	public void mainMenu() {
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("메인 메뉴 : 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택 : ");
		String menuNo = scan.nextLine();
		System.out.println();
		
		switch(menuNo) {
		case "1" : create(); break;  // 게시판 저장
		case "2" : read(); break; // 게시판 읽기
		case "3" : clear(); break; //게시판 삭제
		case "4" : exit(); break; // 게시판 종료
		
		}
	}//mainMenu()
	

	//게시판 저장(create)
	public void create() {
		BoardDTO board = new BoardDTO();
		System.out.println("[새 게시물 입력]");
		
		System.out.print("글쓴이 >> ");
		board.setBwriter(scan.nextLine());
		
		System.out.print("글제목 >> ");
		board.setBtitle(scan.nextLine());
		
		System.out.print("글내용 >> ");
		board.setBcontent(scan.nextLine());
		
		//보조 메뉴 출력
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("보조 메뉴 : 1. OK | 2. Cancel");
		System.out.print("메뉴 선택 >> ");
		String menuNo = scan.nextLine();
		
		if(menuNo.equals("1")) { //게시판 저장
			BoardDAOImpl bdao = new BoardDAOImpl();
			bdao.insertBoard(board); //실제 게시물 저장
			list(); //게시판 목록보기
		}else { //Cancel
			list();
		}
	}//clear()
	
	
	//게시판 읽기(read)
		public void read() {
			System.out.println("[게시물 읽기]");
			System.out.print("게시판 번호 입력 >> ");
			int bno = Integer.parseInt(scan.nextLine());
			
			BoardDAOImpl bdao = new BoardDAOImpl();
			BoardDTO findBno = bdao.getFindNo(bno); //db로 부터 게시판 번호를 검
			
			if(findBno != null) {
				BoardDTO bc = bdao.getBoardCont(bno); //번호에 해당하는 게시물 내용을 DB로 부터 가져오기
			
				System.out.println("#############################");
				System.out.println("게시판 번호 : " + bc.getBno());
				System.out.println("글쓴이 : " + bc.getBwriter());
				System.out.println("글제목 : " + bc.getBtitle());
				System.out.println("글내용 : " + bc.getBcontent());
				System.out.println("등록날짜 : " + bc.getBdate());
				
				//보조메뉴 출력
				System.out.println("--------------------------------------------------------");
				System.out.println("보조 메뉴 : 1.Update | 2.Delete | 3.List");
				System.out.print("메뉴 선택 >> ");
				String menuNo = scan.nextLine();
				
				if(menuNo.equals("1")) {
					update(bc); //게시판 수정
				}else if(menuNo.equals("2")) {
					delete(bc); //게시판 삭제
				}else if(menuNo.equals("3")) {
					list(); //게시판 목록
				}
				
			}else {
				System.out.println("해당 게시물 내용이 없습니다.");
				list();
			}
		}// read()
	
	

	//게시물 수정(update)
	private void update(BoardDTO eb) {
		
				System.out.println("[게시판 수정내용 입력]");
				System.out.print("수정 제목 >> ");
				eb.setBtitle(scan.nextLine());
				System.out.print("수정 내용 >> ");
				eb.setBcontent(scan.nextLine());
				System.out.print("수정 글쓴이 >> ");
				eb.setBwriter(scan.nextLine());
				
				System.out.println("------------------------------------------------------------------");
				System.out.println("보조 메뉴 : 1.Ok | 2.Cancel");
				System.out.print("메뉴 선택 >> ");
				String menuNo = scan.nextLine();
				
				if(menuNo.equals("1")) {
					BoardDAOImpl bdao = new BoardDAOImpl();
					bdao.updateBoard(eb);
					/* 문제)번호를 기준으로 작성자, 제목, 내용을 수정되게 만들어 보자.
					 * 
					 */
					list();
				}else {
					list();
				}
	}
	
	//게시물 삭제(delete)
		private void delete(BoardDTO bc) {
			System.out.println("[게시물 삭제]");
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("보조 메뉴 : 1.OK | 2.Cancel");
			System.out.print("메뉴 선택 >> ");
			String menuNo = scan.nextLine();
			
			if(menuNo.equals("1")) {
				BoardDAOImpl bdao = new BoardDAOImpl();
				bdao.deleteBoard(bc);
				/* 문제) 번호를 기준으로 게시물 삭제되는 메서드를 만들어 보자.
				 * 
				 */
				
				list();
			} else {
				list();
			}
		}

	//게시물 전체 삭제(deleteall)
	public void clear() {
		System.out.println("[게시판 전체 삭제]");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("보조 메뉴 : 1.OK | 2.Cancel");
	    System.out.print("메뉴 선택 >> ");
	    String menuNo = scan.nextLine();
	    
	    if(menuNo.equals("1")) {
	    	BoardDAOImpl bdao = new BoardDAOImpl();
	    	bdao.deleteAllBoard();
	    	/* 문제) 게시물이 전체 삭제되게 deleteAllBoard()메서드를 작성해본다.
	    	 * 
	    	 */
	    	list();
	    } else {
	    	list();
	    }
	}
	
	//게시판 종료(exit)
	public void exit() {
		System.out.println("**게시판 종료**");
		System.out.println(0); //게시판 프로그램 정상적인 종료
	}//exit()
	
	
	public static void main(String[] args) {
		BoardExample boardExample = new BoardExample();
		boardExample.list(); //게시판 목록보기
	}

}
