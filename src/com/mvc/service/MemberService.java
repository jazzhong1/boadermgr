package com.mvc.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.mvc.model.dao.MemberDao;
import com.mvc.model.vo.Member;

import static common.JDBCTemplate.*;

public class MemberService {
	private Connection conn;
	private MemberDao dao;

	public MemberService() {
		conn = getConnect();
		dao=new MemberDao();
	}

	public ArrayList<Member> selectAllMember() {
		ArrayList<Member> list = dao.selectAllMember(conn);
		close(conn);
		return list;
	}

	public ArrayList<Member> searchMemberId(String id) {
		ArrayList<Member> list = dao.searchMemberId(conn, id);
		close(conn);
		return list;
	}

	public int inertMember(Member member) {
		int result = dao.inertMember(conn, member);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateMember(Member member) {
		int result = dao.updateMember(conn, member);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Member> searchMemberName(String name) {
		ArrayList<Member> list = dao.searchMemberName(conn, name);
		close(conn);
		return list;
	}

	public int deleteMember(String id) {
		int result = dao.deleteMember(conn, id);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
