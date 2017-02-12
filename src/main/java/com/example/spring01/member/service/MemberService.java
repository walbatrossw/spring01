package com.example.spring01.member.service;

import java.util.List;

import com.example.spring01.member.model.dto.MemberVO;

public interface MemberService {
	// 회원 목록 
	public List<MemberVO> memberList();
	// 회원 입력
	public void insertMember(MemberVO vo);
	// 회원 정보 상세보기
	public MemberVO viewMember();
	// 회원삭제
	public void deleteMember(String userId);
	// 회원정보 수정
	public void updateMember(MemberVO vo);
}
