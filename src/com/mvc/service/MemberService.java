package com.mvc.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.mvc.model.dao.MemberDao;
import com.mvc.model.vo.Member;

import static common.JDBCTemplate.*;

public class MemberService {
	private Connection conn;
	private MemberDao dao;
	private ArrayList<Member> list;
	private int result;

	public MemberService() {
		conn = getConnect();
		dao=new MemberDao();
		list = null;
		result = 0;
	}

	public ArrayList<Member> selectAllMember() {
		list = dao.selectAllMember(conn);
		close(conn);
		return list;
	}

	public ArrayList<Member> searchMemberId(String id) {
		list = dao.searchMemberId(conn, id);
		close(conn);
		return list;
	}

	public int inertMember(Member member) {
		result = dao.inertMember(conn, member);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateMember(Member member) {
		result = dao.updateMember(conn, member);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Member> searchMemberName(String name) {
		list = dao.searchMemberName(conn, name);
		close(conn);
		return list;
	}

	public int deleteMember(String id) {
		result = dao.deleteMember(conn, id);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
