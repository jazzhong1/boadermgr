package com.mvc.view;

import java.util.Scanner;

public class MainView {
	private Scanner sc;
	
	
	public MainView() {
		sc=new Scanner(System.in);
	}
	
	
	public void Main_view() {
		do {
			System.out.println("======메인메뉴======");
			System.out.println("1. 회원관리");
			System.out.println("2. 게시판관리");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴입력:");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
					new MemberView().Member_view();;
				break;
			case 2:
					new BoardView().Board_view();;
				break;
			case 3:
				System.out.println("종료");
					return;
			default:
				System.out.println("다시입력");
				break;
			}
			
		} while (true);
	}
}
