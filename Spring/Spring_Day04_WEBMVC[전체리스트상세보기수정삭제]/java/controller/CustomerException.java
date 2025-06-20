package controller;

public class CustomerException extends RuntimeException {
	
	public CustomerException() {
		System.out.println("수정오류발생!!");
	}
}
