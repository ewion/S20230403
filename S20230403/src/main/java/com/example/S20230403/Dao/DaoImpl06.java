package com.example.S20230403.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.AccomPayment;
import com.example.S20230403.model.NoticeFaq;
import com.example.S20230403.model.Payment;
import com.example.S20230403.model.Room;
import com.example.S20230403.model.Users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Repository
@RequiredArgsConstructor
@Slf4j
public class DaoImpl06 implements Dao06 {
	private final SqlSession session;

	@Override
	public int userTotal() {
		int userTotal=0;
		try {
			userTotal =session.selectOne("ysuserTotal");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userTotal;
	}

	@Override
	public List<NoticeFaq> listnofiFaq(NoticeFaq nf) {
		List<NoticeFaq> nfqlist =null;
		try {
			nfqlist =session.selectList("ysNotifaq",nf);
			System.out.println(" 다오 임플 노트"+nfqlist.size());
		} catch (Exception e) {
			System.out.println("다오 임플 노트쪽 에러 노트쪽 "+e.getMessage());
		}
		return nfqlist;	
	}

	@Override
	public List<NoticeFaq> listnc(NoticeFaq nf) {
		List<NoticeFaq> listnc =null;
		try {
			listnc =session.selectList("yslistnc",nf);
			System.out.println(" 다오 임플 노트"+listnc.size());
		} catch (Exception e) {
			System.out.println("다오 임플 노트쪽 에러 노트쪽 "+e.getMessage());
		}
		return listnc;	

	}

	@Override
	public List<NoticeFaq> listnt(NoticeFaq nf) {
		List<NoticeFaq> listnt =null;
		try {
			listnt =session.selectList("yslistnt",nf);
			System.out.println(" 다오 임플 노트"+listnt.size());
		} catch (Exception e) {
			System.out.println("다오 임플 노트쪽 에러 노트쪽 "+e.getMessage());
		}
		return listnt;	
	}

	@Override
	public List<Accom> searchAc(Accom accom) {
		List<Accom> searchAc =null;
		try {
			searchAc =session.selectList("yssearchAc",accom);
			System.out.println("다오 임플 시작 서치쪽 "+searchAc.size());
		} catch (Exception e) {
			System.out.println("다오 임플 서치쪽 에러 서치쪽 "+e.getMessage());
		}
		return searchAc;
	}

	@Override
	public List<Users> userlist(Users user_id) {
		List<Users> userlist =null;
		try {
			userlist =session.selectList("ysUserlist",user_id);
			System.out.println("다오 임플 시작 일반 유저 사이즈 "+userlist.size());
		} catch (Exception e) {
			System.out.println("userlist 쪽 에러 확잉용 다오 임플임 "+e.getMessage());
		}

		return userlist;
	}

	@Override
	public int userNum(Users user_id) {
		int userNum =0;
		try {
			userNum =session.selectOne("ysuserNum",user_id);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return userNum;
	}

	@Override
	public int coundTotalUser(Users user_id) {
		int condCount = 0;
		try {
			condCount = session.selectOne("condTotalUsers", user_id);
			System.out.println("dao 카운팅 사이즈-> "+condCount);

		} catch (Exception e) {
			System.out.println("dao coundTotalUser 에러 -> "+e.getMessage());
		}
		System.out.println("dao condTotalEmp 끝");
		return condCount;
	}

	@Override
	public List<Users> listSearchUsers(Users users) {
		List<Users> listSearchUsers=null;
		try {
			System.out.println("*DAo listSearchUsers users==*>"+users);
			// 키워드 검색
			listSearchUsers = session.selectList("ysSearchList",users);
			System.out.println("dao listSearchUsers 사이즈-> "+listSearchUsers.size());
		} catch (Exception e) {
			System.out.println("dao listSearchUsers 에러 -> "+e.getMessage());
		}

		return listSearchUsers;
	}


	@Override
	public List<Payment> getr_name(Payment pmt) {
		List<Payment> getr_name=null;
		try {
			getr_name=session.selectList("ysr_name",pmt);
			System.out.println("*DAo getr_name 업소명==*>"+getr_name);

		} catch (Exception e) {
			System.out.println("dao getr_name 에러 -> "+e.getMessage());
		}
		return getr_name;
	}

	@Override
	public List<AccomPayment> getapt(AccomPayment apt) {
		List<AccomPayment> getapt=null;
		try {
			getapt=session.selectList("ygetapt",apt);
			System.out.println("*DAo getr_name 업소명==*>"+getapt);

		} catch (Exception e) {
			System.out.println("dao getapt 에러 -> "+e.getMessage());
		}
		return getapt;		
	}

	@Override
	public List<Room> getR_price(AccomPayment apt) {
		List<Room> getR_price=null;
		try {
			getR_price=session.selectList("ygetR_pricet",apt);
			System.out.println("*DAo getr_name 업소명==*>"+getR_price);

		} catch (Exception e) {
			System.out.println("dao listSearchUsers 에러 -> "+e.getMessage());
		}
		return getR_price;		
	}

}
