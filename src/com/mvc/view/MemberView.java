package com.mvc.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.mvc.controller.MemberController;
import com.mvc.model.vo.Member;

public class MemberView {
	private Scanner sc;
	
	public MemberView() {
		sc=new Scanner(System.in);
	}
	
	public void Member_view(){
		do {
			System.out.println("=========회원관리========");
			System.out.println("1.전체회원조회");
			System.out.println("2.회원 아이디로 조회");
			System.out.println("3.회원 이름으로 조회");
			System.out.println("4.회원가입");
			System.out.println("5.회원정보수정(주소,전화번호,이메일)");
			System.out.println("6.회원탈퇴");
			System.out.println("7.메인메뉴로");
			System.out.print("메뉴입력:");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				new MemberController().selectAllMember();
				break;
			case 2:
				new MemberController().searchMemberId(this.find_id());
				break;
			case 3:
				new MemberController().searchMemberName(this.find_name());
				break;
			case 4:
				new MemberController().inertMember(this.insertMember());
				break;
			case 5:
				new MemberController().updateMember(this.updateMember());
				break;
			case 6:
				new MemberController().deleteMember(this.find_id());
				break;
			case 7:
				new MainView().Main_view();
				break;
			default:
				System.out.println("다시입력");
				break;
			}
			
			
		} while (true);
		
	}
	
	public Member insertMember() {	
		
		Member member=new Member();
		sc.nextLine();
		System.out.println("=====회원정보입력======");
		System.out.print("아이디 : ");
		member.setMember_id(sc.nextLine());
		System.out.print("비밀번호 : ");
		member.setMember_pwd(sc.nextLine());
		System.out.print("이름 : ");
		member.setMember_name(sc.nextLine());
		System.out.print("이메일 : ");
		member.setEmail(sc.nextLine());
		System.out.print("주소: ");
		member.setAddress(sc.nextLine());
		System.out.print("전화번호 : ");
		member.setPhone(sc.nextLine());
		System.out.print("가입날짜 : ");
		member.setEnroll_date(Date.valueOf(sc.nextLine()));
		return member;
		}
		
		
		public Member updateMember() {	
			
			Member member=new Member();
			
			sc.nextLine();
			System.out.println("=====회원수정입력======");
			System.out.print("수정할 아이디:");
			member.setMember_id(sc.nextLine());
			System.out.print("전화번호 : ");
			member.setPhone(sc.nextLine());
			System.out.print("이메일 : ");
			member.setEmail(sc.nextLine());
			return member;
		
		}
		
		public String find_id(){
			sc.nextLine();
			System.out.print("아이디:");
			String id=sc.nextLine();
			return id;
		}
		
		public String find_name(){
			sc.nextLine();
			System.out.print("이름:");
			String name=sc.nextLine();
			return name;
		}
		
		public void displayList(ArrayList<Member> list) {
			System.out.println("================================================== 회원 조회결과 =====================================================\n");
			System.out.println("아이디\t비밀번호\t이름\t이메일\t\t\t전화번호\t\t\t가입일");
			//		return member_id+"\t"+member_pwd+"\t"+member_name+"\t"+email+"\t\t"+phone+"\t"+enroll_date;

			for(Member m: list){
				System.out.println(m.toString());
			}	
		}
		
		public void displayError(String msg) {
			System.out.println(msg);
		}

		public void displaySuccess(String msg) {
				System.out.println(msg);
			
		}


}
