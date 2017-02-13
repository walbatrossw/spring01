package com.example.spring01.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring01.member.model.dao.MemberDAOImpl;
import com.example.spring01.member.model.dto.MemberVO;

// 현재 클래스를 스프링에서 관리하는 service bean으로 등록
@Service
public class MemberServiceImpl implements MemberService {
	
	// MemberDAOImpl 객체를 스프링에서 생성하여 주입시킴
	@Inject
	MemberDAOImpl memberDao;
	
	// 01. 전체 회원 목록 조회
	@Override
	public List<MemberVO> memberList() {
		return memberDao.memberList();
	}
	
	// 02. 회원 등록
	@Override
	public void insertMember(MemberVO vo) {
		memberDao.insertMember(vo);
	}
	// 03. 회원 정보 상세 조회 
	@Override
	public MemberVO viewMember(String userId) {
		return memberDao.viewMember(userId);
	}
	// 04. 회원 정보 수정 처리
	@Override
	public void deleteMember(String userId) {
		memberDao.deleteMember(userId);
	}
	// 05. 회원 정보 삭제 처리
	@Override
	public void updateMember(MemberVO vo) {
		memberDao.updateMember(vo);
	}
	// 06. 회원 정보 수정 및 삭제를 위한 비밀번호 체크
	@Override
	public boolean checkPw(String userId, String userPw) {
		return memberDao.checkPw(userId, userPw);
	}

}
