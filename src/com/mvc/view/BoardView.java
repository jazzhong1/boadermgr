package com.mvc.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.mvc.controller.BoardController;
import com.mvc.model.vo.Board;
import com.mvc.model.vo.Member;

public class BoardView {
	
	private Scanner sc;
	public BoardView() {
		sc=new Scanner(System.in);
	}

	
	public void Board_view(){
		do {
			System.out.println("=========게시판관리========");
			System.out.println("1.게시판전체 검색");
			System.out.println("2.게시물 등록");
			System.out.println("3.작성자로 검색");
			System.out.println("4.제목으로 검색");
			System.out.println("5.게시물 수정(제목, 내용)");
			System.out.println("6.게시물 삭제");
			System.out.println("7.메인메뉴로");
			
			System.out.print("메뉴입력:");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				new BoardController().selectAllBoard();
				break;
			case 2:
				new BoardController().inertBoard(this.insertBoard());
				break;
			case 3:
				new BoardController().searchBoardWriter(this.find_wirter());

				break;
			case 4:
				new BoardController().searchBoardTitle(this.find_title());

				break;
			case 5:
				new BoardController().updateBoard(this.updateBoard());

				break;
			case 6:
				new BoardController().deleteBoard(this.find_title());
				break;
			case 7:
				new MainView().Main_view();
				break;
			default:
				System.out.println("다시입력");
				break;
			}
			
			
		} while (true);
	}
	
	public String find_wirter(){
		sc.nextLine();
		System.out.print("작성자:");
		String wirter=sc.next();
		return wirter;
	}
	
	public String find_title(){
		sc.nextLine();
		System.out.print("제목:");
		String title=sc.nextLine();
		return title;
	}
	
	public Board insertBoard(){
		Board board=new Board();
		sc.nextLine();
		System.out.print("종류:(공지,일반,비밀):");
		board.setDiv(sc.nextLine());
		sc.nextLine();
		System.out.print("제목:");
		board.setTitle(sc.nextLine());
		System.out.print("내용:");
		board.setComments(sc.nextLine());
		System.out.print("작성자:");
		board.setWriter(sc.nextLine());
		System.out.print("작성날자:");
		board.setWrite_date(Date.valueOf(sc.nextLine()));
		return board;
	}
	
	public Board updateBoard(){
		sc.nextLine();
		Board board=new Board();
		System.out.print("종류:(공지,일반,비밀):");
		board.setDiv(sc.nextLine());
		System.out.print("내용:");
		board.setComments(sc.nextLine());
		System.out.print("제목:");
		board.setTitle(sc.nextLine());
		return board;
	}
	
	public void displayList(ArrayList<Board> list) {
		System.out.println("=================================== 게시판 조회결과 =====================================================\n");
		System.out.println("공지\t제목\t내용\t\t\t작성자\t작성날짜");
		for(Board b: list){
			System.out.println(b.toString());
		}	
	}
	
	public void displayBoad(Board b) {
		System.out.println("=================================== 게시판 조회결과 =====================================================\n");
		System.out.println("공지\t제목\t내용\t\t\t작성자\t작성날짜");
			System.out.println(b.toString());
	}
	
	public void displayError(String msg) {
		System.out.println(msg);
	}

	public void displaySuccess(String msg) {
			System.out.println(msg);
		
	}

	
	
	
	
}
