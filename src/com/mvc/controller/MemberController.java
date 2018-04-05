package com.mvc.controller;

import java.util.ArrayList;

import com.mvc.model.vo.Member;
import com.mvc.service.MemberService;
import com.mvc.view.MemberView;

public class MemberController {

	private ArrayList<Member> list;
	private MemberService service;
	private MemberView view;
	private int result;

	public MemberController() {
		service = new MemberService();
		view = new MemberView();
	}

	public void selectAllMember() {
		list = service.selectAllMember();
		if (list != null && list.size() > 0) {
			view.displayList(list);
		} else {
			view.displayError("실패");
		}

	}

	public void searchMemberId(String id) {
		list = service.searchMemberId(id);
		if (list != null && list.size() > 0) {
			view.displayList(list);
		} else {
			view.displayError("아이디를 확인하세요");
		}
	}

	public void inertMember(Member member) {
		result = service.inertMember(member);
		if (result > 0) {
			view.displaySuccess("성공");
		} else {
			view.displayError("실패");
		}

	}

	public void updateMember(Member member) {
		result = service.updateMember(member);
		if (result > 0) {
			view.displaySuccess("성공");
		} else {
			view.displayError("실패");
		}
	}

	public void searchMemberName(String name) {
		list = service.searchMemberName(name);
		if (list != null && list.size() > 0) {
			view.displayList(list);
		} else {
			view.displayError("이름을 확인하세요");
		}
	}

	public void deleteMember(String id) {
		result = service.deleteMember(id);
		if (result > 0) {
			view.displaySuccess("성공");
		} else {
			view.displayError("실패");
		}
	}

}
