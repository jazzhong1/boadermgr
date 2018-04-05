package com.mvc.model.vo;

import java.sql.Date;

public class Member {
	private String member_id;
	private String member_pwd;
	private String member_name;
	private String email;
	private String phone;
	private String address;
	private Date enroll_date;
	
	public Member() {
	}
	
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		
		return member_id+"\t"+member_pwd+"\t"+member_name+"\t"+email+"\t\t"+phone+"\t"+enroll_date;

	}



}
