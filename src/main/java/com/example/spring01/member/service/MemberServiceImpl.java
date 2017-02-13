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
	
	// 01. 회원 목록
	@Override
	public List<MemberVO> memberList() {
		return memberDao.memberList();
	}
	
	// 02. 회원 등록
	@Override
	public void insertMember(MemberVO vo) {
		memberDao.insertMember(vo);
	}

	@Override
	public MemberVO viewMember() {
		return null;
	}

	@Override
	public void deleteMember(String userId) {
		
	}

	@Override
	public void updateMember(MemberVO vo) {
		
	}

}
