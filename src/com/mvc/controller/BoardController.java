package com.mvc.controller;

import java.sql.Connection;
import java.util.ArrayList;

import com.mvc.model.dao.BoardDao;
import com.mvc.model.vo.Board;
import com.mvc.service.BoardService;
import com.mvc.view.BoardView;

import static common.JDBCTemplate.*;

public class BoardController {
	private Connection conn;
	public BoardController() {
		
	}

	public void inertBoard() {
		
		int result=new BoardService().inertBoard();
		if(result>0){
			new BoardView().displaySuccess("성공");
		}else{
			new BoardView().displayError("실패");
		}
	}

	public void selectAllBoard() {
		
		ArrayList<Board> list=new BoardService().selectAllBoard();
		if(list.size()>0&& list!=null){
			new BoardView().displayList(list);
		}
		else{
			new BoardView().displayError("실패");
		}
		
	}

	public void searchBoardWriter() {
		ArrayList<Board> list=new BoardService().searchBoardWriter();
		if(list.size()>0&& list!=null){
			new BoardView().displayList(list);
		}
		else{
			new BoardView().displayError("실패");
		}
	}

	public void updateBoard() {
		
		int result=new BoardService().updateBoard();
		if(result>0){
			new BoardView().displaySuccess("성공");
		}else{
			new BoardView().displayError("실패");
		}
	}

	public void deleteBoard() {
		
		int result=new BoardService().deleteBoard();
		if(result>0){
			new BoardView().displaySuccess("성공");
		}else{
			new BoardView().displayError("실패");
		}
	}

	public void searchBoardTitle() {
		ArrayList<Board> list=new BoardService().searchBoardTitle();
		if(list.size()>0&& list!=null){
			new BoardView().displayList(list);
		}
		else{
			new BoardView().displayError("실패");
		}
	}

}
