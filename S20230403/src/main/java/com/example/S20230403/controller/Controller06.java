package com.example.S20230403.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.AccomPayment;
import com.example.S20230403.model.NoticeFaq;
import com.example.S20230403.model.Payment;
import com.example.S20230403.model.Room;
import com.example.S20230403.model.Users;
import com.example.S20230403.service.Paging;
import com.example.S20230403.service.Service06;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class Controller06 {

	private final Service06 s06;



	
	
	@GetMapping("main")
	public String main() {
		return "/views/main";
	}
	@GetMapping("noti")
	public String noti(Model model,NoticeFaq nf) {
		System.out.println("Qna Start Controller");

		List<NoticeFaq> nfqlist =s06.listNoticeFaq(nf);
		List<NoticeFaq> listnc =s06.listnc(nf);
		List<NoticeFaq> listnt =s06.listnt(nf);

		model.addAttribute("nfqlist",nfqlist);
		model.addAttribute("listnc",listnc);
		model.addAttribute("listnt",listnt);

		return "/views/noti";
	}
	@GetMapping("search")
	public String search(Model model,Accom accom,String sech) {
		List<Accom> searchAc =s06.searchAc(accom);
		System.out.println("검색 컨트롤라 시작");
		model.addAttribute("searchAc",searchAc);
		return "/views/search";
	}
	@GetMapping("payment")
	public String r_name(Model model, AccomPayment apt, String checkIn, String checkOut) {
		//List<Payment> r_name1=s06.getr_name(pmt);
		List<AccomPayment> getApt = s06.getapt(apt);
		List<Room> r_price=s06.getR_price(apt);
		apt.setBiz_id(apt.getBiz_id());
		apt.setCheck_in(checkIn);
		apt.setCheck_out(checkOut);
		System.out.println("첵인 첵아웃 ==>    "+checkIn+checkOut);


		String dateStr1 = "2023-04-21"; // 첫 번째 날짜 문자열
		String dateStr2 = "2023-05-02"; // 두 번째 날짜 문자열

		LocalDate date1 = LocalDate.parse(dateStr1); // 첫 번째 날짜 문자열을 LocalDate 객체로 변환
		LocalDate date2 = LocalDate.parse(dateStr2); // 두 번째 날짜 문자열을 LocalDate 객체로 변환

		long daysBetween = ChronoUnit.DAYS.between(date1, date2); // 두 날짜 사이의 일자 차이 계산

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd (E)"); // 날짜 포맷팅을 위한 DateTimeFormatter 생성
		String formattedDate1 = date1.format(formatter); // 첫 번째 날짜를 포맷팅
		String formattedDate2 = date2.format(formatter); // 두 번째 날짜를 포맷팅

		System.out.println("첫 번째 날짜: " + formattedDate1); // 첫 번째 날짜 출력
		System.out.println("두 번째 날짜: " + formattedDate2); // 두 번째 날짜 출력
		System.out.println("일자 차이: " + daysBetween + "일"); // 일자 차이 출력



		if (!r_price.isEmpty()) {
			Room r_price1 =r_price.get(0);
			apt.setR_price(r_price1.getR_price());
			apt.setR_name(r_price1.getR_name());

		}
		if (!getApt.isEmpty()) { // 리스트가 비어있지 않은 경우에만 처리
			AccomPayment payment = getApt.get(0); // 첫 번째 AccomPayment 객체 가져오기
			apt.setBiz_name(payment.getBiz_name());
		}

		model.addAttribute("formattedDate1",formattedDate1);
		model.addAttribute("formattedDate2",formattedDate2);
		model.addAttribute("daysBetween",daysBetween);
		model.addAttribute("pmt", apt);
		System.out.println("pmt =>" + apt);

		return "/views/payment";
	}

	// 전체 조회(기본)
	/*
	 * @GetMapping("adminPage") public String adminPage(Model model,String
	 * currentPage,Users users) { int userTotal =s06.userTotal(); Paging page = new
	 * Paging(userTotal, currentPage);
	 * System.out.println("컨트롤러 totalemp-> "+userTotal); // paging 작업 // 서비스이긴 하지만
	 * dao작업이 필요없는 서비스는 di를 하지 않고 클래식하게 쓰는게 편함.
	 * System.out.println("컨트롤러 시작 끝 page-> "+ page.getStart());
	 * System.out.println("컨트롤러 시작 끝 page-> "+ page.getEnd()); // parameter emp ->
	 * page만 추가 setting users.setStart(page.getStart()); // 시작시 1
	 * users.setEnd(page.getEnd()); // 시작시 10
	 * 
	 * 
	 * 
	 * List<Users> userlist= s06.userlist(users);
	 * 
	 * model.addAttribute("userTotal", userTotal);
	 * model.addAttribute("userlist",userlist); model.addAttribute("page", page);
	 * 
	 * return "/views/adminPage"; }
	 */
	@RequestMapping("userSeacrh1")
	public String userSeacrh1(Users users, Model model, String currentPage) {
		System.out.println("controller userSeacrh1 users->"+users);
		int totalUser =s06.conditionUserCount(users);

		Paging page =new Paging(totalUser, currentPage);

		users.setStart(page.getStart());
		users.setEnd(page.getEnd());

		List<Users> listSearchUser=s06.listSearchUsers(users);

		model.addAttribute("userTotal",totalUser);
		model.addAttribute("page",page);
		model.addAttribute("keyword",users.getKeyword());
		model.addAttribute("userlist",listSearchUser);
		return "/views/adminPage";

	}
	@RequestMapping("pay_modal")
	public String pay_modal() {



		return "/views/pay_modal";
	}

}
