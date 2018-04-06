package com.mvc.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnect;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.mvc.model.dao.BoardDao;
import com.mvc.model.vo.Board;
import com.mvc.model.vo.Member;
import com.mvc.view.BoardView;

public class BoardService {
	private Connection conn;
	private BoardDao dao;

	public BoardService() {
		dao=new BoardDao();
	}

	public ArrayList<Board> selectAllBoard() {
		conn = getConnect();
		 ArrayList<Board> list = dao.selectAllBoard(conn);
		close(conn);
		return list;
	}

	public int inertBoard(Board board) {
		conn = getConnect();
		int result = dao.inertBoard(conn, board);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public ArrayList<Board> searchBoardWriter(String writer) {

		conn = getConnect();
		 ArrayList<Board> list = new BoardDao().searchBoardWriter(conn, writer);
		close(conn);
		return list;
	}

	public int updateBoard(Board board) {
		conn = getConnect();
		int result = new BoardDao().updateBoard(conn, board);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	public int deleteBoard(String title) {
		conn = getConnect();
		int result = dao.deleteBoard(conn, title);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	public ArrayList<Board> searchBoardTitle(String title) {
		conn = getConnect();
		 ArrayList<Board> list = dao.searchBoardTitle(conn, title);
		close(conn);
		return list;
	}
}
