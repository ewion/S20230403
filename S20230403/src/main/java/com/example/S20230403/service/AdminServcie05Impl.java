package com.example.S20230403.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.S20230403.Dao.AdminDao05;
import com.example.S20230403.model.JooJoin;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServcie05Impl implements AdminServcie05 {
	
	private final AdminDao05 ad;

//	일반 회원 정보 전체 조회
	@Override
	public int userTotal() {
		System.out.println("AdminServerImpl userTotal 시작");
		System.out.println("AdminServerImpl userTotal() : "+ad.userTotal());
		return ad.userTotal();
	}
	@Override
	public List<JooJoin> userlist(JooJoin jooJoin) {
		// TODO Auto-generated method stub
		return ad.userlist(jooJoin);
	}

//	사업자 회원 정보 전체 조회
	@Override
	public int accomTotal() {
		System.out.println("AdminServerImpl accomTotal 시작");
		System.out.println("AdminServerImpl accomTotal() : "+ad.accomTotal());
		return ad.accomTotal();
	}	
	@Override
	public List<JooJoin> accomlist(JooJoin jooJoin) {
		// TODO Auto-generated method stub
		return ad.accomlist(jooJoin);
	}

//	1대1 문의 / 불만접수 정보 전체 조회
	@Override
	public int qnaTotal() {
		// TODO Auto-generated method stub
		return ad.qnaTotal();
	}
	@Override
	public List<JooJoin> qnalist(JooJoin jooJoin) {
		// TODO Auto-generated method stub
		return ad.qnalist(jooJoin);
	}
	
//	리뷰 정보 전체 조회
	@Override
	public int reviewTotal() {
		// TODO Auto-generated method stub
		return ad.reviewTotal();
	}
	@Override
	public List<JooJoin> reviewlist(JooJoin jooJoin) {
		// TODO Auto-generated method stub
		return ad.reviewlist(jooJoin);
	}
	

//	---------------------------------------------------------------
	
//	일반 회원 비활성화
	@Override
	public int delUsers(JooJoin jooJoin) {
		System.out.println("AdminServcie05Impl delUsers start");
		return ad.delUsers(jooJoin);
	}

//	사업자 회원 비활성화
	@Override
	public int delAccom(JooJoin jooJoin) {
		System.out.println("AdminServcie05Impl delAccom start");
		return ad.delAccom(jooJoin);
	}

//	QnA 삭제
	@Override
	public int delQnA(int qna_id) {
		System.out.println("AdminServcie05Impl delQnA start");
		return ad.delQnA(qna_id);
	}

//	Review 삭제
	@Override
	public int delReview(int pay_id) {
		System.out.println("AdminServcie05Impl delReview start");
		return ad.delReview(pay_id);
	}

//	Event 삭제
//	@Override
//	public int delEvent(int event_id) {
//		System.out.println("AdminServcie05Impl delEvent start");
//		return ad.delEvent(event_id);
//	}

//	Notice 삭제
//	@Override
//	public int delNotice(int notice_id) {
//		System.out.println("AdminServcie05Impl delNotice start");
//		return ad.delNotice(notice_id);
//	}
	
//	---------------------------------------------------------------------

	
	
}
