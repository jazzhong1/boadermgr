package com.mvc.controller;

import java.sql.Connection;
import java.util.ArrayList;

import com.mvc.model.dao.BoardDao;
import com.mvc.model.vo.Board;
import com.mvc.model.vo.Member;
import com.mvc.service.BoardService;
import com.mvc.service.MemberService;
import com.mvc.view.BoardView;
import com.mvc.view.MemberView;

import static common.JDBCTemplate.*;

public class BoardController {
//
	private BoardService service;
	private BoardView view;
	public BoardController() {
		service = new BoardService();
		view = new BoardView();
	}

	public void inertBoard(Board board) {
		
		int result=service.inertBoard(board);
		if(result>0){
			view.displaySuccess("성공");
		}else{
			view.displayError("실패");
		}
	}

	public void selectAllBoard() {
		
		ArrayList<Board> list=service.selectAllBoard();
		if(list.size()>0&& list!=null){
			view.displayList(list);
		}
		else{
			view.displayError("실패");
		}
		
	}

	public void searchBoardWriter(String writer) {
		ArrayList<Board> list=service.searchBoardWriter(writer);
		if(list.size()>0&& list!=null){
			view.displayList(list);
		}
		else{
			view.displayError("작성자를 확인하세요");
		}
	}

	public void updateBoard(Board board) {
		
		int result=service.updateBoard(board);
		if(result>0){
			view.displaySuccess("성공");
		}else{
			view.displayError("실패");
		}
	}

	public void deleteBoard(String title) {
		
		int result=service.deleteBoard(title);
		if(result>0){
			view.displaySuccess("성공");
		}else{
			view.displayError("아이디를 확인하세요");
		}
	}

	public void searchBoardTitle(String title) {
		ArrayList<Board> list=service.searchBoardTitle(title);
		if(list.size()>0&& list!=null){
			view.displayList(list);
		}
		else{
			view.displayError("제목을 확인하세요");
		}
	}

}
