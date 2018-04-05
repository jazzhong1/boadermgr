package com.mvc.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnect;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.mvc.model.dao.BoardDao;
import com.mvc.model.vo.Board;
import com.mvc.view.BoardView;

public class BoardService {
	private Connection conn;

	public BoardService() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Board> selectAllBoard() {
		conn=getConnect();
		ArrayList<Board> list=new BoardDao().selectAllBoard(conn);
		close(conn);
		return list;
	}

	public int inertBoard() {
		conn = getConnect();
		Board b = new BoardView().insertBoard();
		int result = new BoardDao().inertBoard(conn, b);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		
		return result;
	}

	public ArrayList<Board>  searchBoardWriter() {

		conn=getConnect();
		String writer= new BoardView().find_wirter();
		ArrayList<Board> list=new BoardDao().searchBoardWriter(conn, writer);
		if(list.size()>0&& list!=null){
			new BoardView().displayList(list);
		}
		else{
			new BoardView().displayError("실패");
		}
		
		close(conn);
		return list;
	}

	public int updateBoard() {
		conn=getConnect();
		Board board=new BoardView().updateBoard();
		String writer=new BoardView().find_wirter();
		int result=new BoardDao().updateBoard(conn, board,writer);
		if(result>0){
			commit(conn);
		}
		else{
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteBoard() {
		conn = getConnect();
		String title = new BoardView().find_title();
		int result = new BoardDao().deleteBoard(conn, title);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public ArrayList<Board> searchBoardTitle() {
		conn=getConnect();
		String title= new BoardView().find_title();
		ArrayList<Board> list=new BoardDao().searchBoardTitle(conn, title);
		if(list.size()>0&& list!=null){
			new BoardView().displayList(list);
		}
		else{
			new BoardView().displayError("실패");
		}
		
		close(conn);
		return list;
	}
}
