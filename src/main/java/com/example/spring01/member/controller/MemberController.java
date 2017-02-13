package com.example.spring01.member.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring01.member.model.dto.MemberVO;
import com.example.spring01.member.service.MemberService;

@Controller // 현재의 클래스를 controller bean에 등록시킴
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// MemberService 객체를 스프링에서 생성하여 주입시킴
	@Inject
	MemberService memberService;
	
	// 01 회원 목록
	// url pattern mapping
	@RequestMapping("member/list.do")
	public String memberList(Model model){
	// controller => service => dao 요청
		List<MemberVO> list = memberService.memberList();
		model.addAttribute("list", list);
		return "member/member_list";
	}
	
	// 02_01 회원 등록 페이지로 이동
	@RequestMapping("member/write.do")
	public String memberWrite(){
		
		return "member/member_write";
	}
	
	// 02_02 회원 등록 처리 후 ==> 회원목록으로 리다이렉트
	// @ModelAttribute에 폼에서 입력한 데이터가 저장된다.
	@RequestMapping("member/insert.do")
	// * 폼에서 입력한 데이터를 받아오는 법 3가지 
	//public String memberInsert(HttpServlet request){
	//public String memberInsert(String userId, String userPw, String userName, String userEmail){
	public String memberInsert(@ModelAttribute MemberVO vo){
		// 테이블에 레코드 입력
		memberService.insertMember(vo);
		// * (/)의 유무에 차이
		// /member/list.do : 루트 디렉토리를 기준
		// member/list.do : 현재 디렉토리를 기준
		// member_list.jsp로 리다이렉트
		return "redirect:/member/list.do";
	}
	
	// 03 회원 상세정보 조회
	@RequestMapping("member/view.do")
	public String memberView(String userId, Model model){
		// 회원 정보를 model에 저장
		model.addAttribute("dto", memberService.viewMember(userId));
		//System.out.println("클릭한 아이디 확인 : "+userId);
		logger.info("클릭한 아이디 : "+userId);
		// member_view.jsp로 포워드
		return "member/member_view";
	}
	// 04. 회원 정보 수정 처리
	@RequestMapping("member/update.do")
	public String memberUpdate(@ModelAttribute MemberVO vo){
		memberService.updateMember(vo);
		return "redirect:/member/list.do";
	}
}
