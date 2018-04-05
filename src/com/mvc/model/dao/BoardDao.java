package com.mvc.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.mvc.model.vo.Board;
import com.mvc.model.vo.Member;

import static common.JDBCTemplate.*;

public class BoardDao {
	private PreparedStatement stmt;
	private ResultSet rs;
	private ArrayList<Board> list;
	private int result;
	private Properties prop;
	private Board board;

	public BoardDao() {
		prop = new Properties();
		{
			try {
				prop.load(new BufferedReader(new FileReader("resource/board_query.properties")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		stmt = null;
		rs = null;
		list = null;
		result = 0;
		board = null;
	}

	public int inertBoard(Connection conn, Board b) {
		try {
			stmt = conn.prepareStatement(prop.getProperty("inertBoard"));
			stmt.setString(1, b.getDiv());
			stmt.setString(2, b.getTitle());
			stmt.setString(3, b.getComments());
			stmt.setString(4, b.getWriter());
			stmt.setDate(5, b.getWrite_date());

			result = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}

		return result;
	}

	public ArrayList<Board> selectAllBoard(Connection conn) {
		try {
			stmt = conn.prepareStatement(prop.getProperty("selectAllBoard"));
			rs = stmt.executeQuery();
			list = new ArrayList<Board>();
			while (rs.next()) {
				Board board = new Board();
				board.setDiv(rs.getString("div"));
				board.setTitle(rs.getString("title"));
				board.setComments(rs.getString("comments"));
				board.setWriter(rs.getString("writer"));
				board.setWrite_date(rs.getDate("write_date"));

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt);
		}

		return list;

	}

	public ArrayList<Board> searchBoardWriter(Connection conn, String writer) {

		try {
			list = new ArrayList<Board>();
			stmt = conn.prepareStatement(prop.getProperty("searchBoardWriter"));
			stmt.setString(1, writer);
			result = stmt.executeUpdate();
			if (result > 0) {
				rs = stmt.executeQuery();
				rs.next();
				board = new Board();
				board.setDiv(rs.getString("div"));
				board.setTitle(rs.getString("title"));
				board.setComments(rs.getString("comments"));
				board.setWriter(rs.getString("writer"));
				board.setWrite_date(rs.getDate("write_date"));

				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt);
		}

		return list;

	}

	public ArrayList<Board> searchBoardTitle(Connection conn, String Title) {

		try {
			list = new ArrayList<Board>();
			stmt = conn.prepareStatement(prop.getProperty("searchBoardTitle"));
			stmt.setString(1, Title);
			result = stmt.executeUpdate();
			if (result > 0) {
				rs = stmt.executeQuery();
				rs.next();
				board = new Board();
				board.setDiv(rs.getString("div"));
				board.setTitle(rs.getString("title"));
				board.setComments(rs.getString("comments"));
				board.setWriter(rs.getString("writer"));
				board.setWrite_date(rs.getDate("write_date"));

				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt);
		}

		return list;
	}

	public int updateBoard(Connection conn, Board b) {
		try {
			stmt = conn.prepareStatement(prop.getProperty("updateBoard"));
			stmt.setString(1, b.getDiv());
			stmt.setString(2, b.getComments());
			stmt.setString(3, b.getTitle());
			result = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}

		return result;

	}

	public int deleteBoard(Connection conn, String title) {
		try {
			stmt = conn.prepareStatement(prop.getProperty("deleteBoard"));
			stmt.setString(1, title);
			result = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}

		return result;
	}
}
