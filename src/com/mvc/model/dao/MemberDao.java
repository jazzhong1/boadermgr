package com.mvc.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JEditorPane;

import com.mvc.model.vo.Member;

import static common.JDBCTemplate.*;

public class MemberDao {
	private PreparedStatement stmt;
	private Properties prop;
	private Member member;

	public MemberDao() {

		prop = new Properties();
		{
			try {
				prop.load(new BufferedReader(new FileReader("resource/member_query.properties")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		stmt = null;
		member = null;
	}

	public ArrayList<Member> selectAllMember(Connection conn) {
		ArrayList<Member> list = new ArrayList<Member>();
		ResultSet rs=null;
		try {
			stmt = conn.prepareStatement(prop.getProperty("selectAllMember"));
			rs = stmt.executeQuery();
			while (rs.next()) {
				member = new Member();
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pwd(rs.getString("member_pwd"));
				member.setMember_name(rs.getString("member_name"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setEnroll_date(rs.getDate("enroll_date"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt);
		}
		return list;

	}

	public ArrayList<Member> searchMemberId(Connection conn, String id) {

		ArrayList<Member> list = new ArrayList<Member>();
		ResultSet rs=null;
		try {
			stmt = conn.prepareStatement(prop.getProperty("searchMemberId"));
			stmt.setString(1, id);
			int result = stmt.executeUpdate();
			if (result > 0) {
				rs=stmt.executeQuery();
				rs.next();
				member = new Member();
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pwd(rs.getString("member_pwd"));
				member.setMember_name(rs.getString("member_name"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setEnroll_date(rs.getDate("enroll_date"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt);
		}
		return list;
	}

	public int inertMember(Connection conn, Member member) {
		int result=0;
		try {
			stmt = conn.prepareStatement(prop.getProperty("insertMember"));
			stmt.setString(1, member.getMember_id());
			stmt.setString(2, member.getMember_pwd());
			stmt.setString(3, member.getMember_name());
			stmt.setString(4, member.getEmail());
			stmt.setString(5, member.getAddress());
			stmt.setString(6, member.getPhone());
			stmt.setDate(7, member.getEnroll_date());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}

	public int updateMember(Connection conn, Member member) {
		int result=0;
		try {
			stmt = conn.prepareStatement(prop.getProperty("updateMember"));
			stmt.setString(1, member.getPhone());
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getMember_id());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}

	public ArrayList<Member> searchMemberName(Connection conn, String name) {
		int result=0;
		ArrayList<Member> list = new ArrayList<Member>();
		ResultSet rs=null;
		try {
			stmt = conn.prepareStatement(prop.getProperty("searchMemberName"));
			stmt.setString(1, name);
			result = stmt.executeUpdate();
			if (result > 0) {
				rs = stmt.executeQuery();
				rs.next();
				member = new Member();
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pwd(rs.getString("member_pwd"));
				member.setMember_name(rs.getString("member_name"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setEnroll_date(rs.getDate("enroll_date"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt);
		}
		return list;
	}

	public int deleteMember(Connection conn, String id) {
		int result=0;
		try {
			stmt = conn.prepareStatement(prop.getProperty("deleteMember"));
			stmt.setString(1, id);
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}

}
