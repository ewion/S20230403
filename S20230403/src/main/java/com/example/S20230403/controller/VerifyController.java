package com.example.S20230403.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;

import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor


public class VerifyController {


	// 결제 API 클라이언트
	private final IamportClient iamportClient;

	// 생성자를 통한 의존성 주입

	public VerifyController() {
		this.iamportClient = new IamportClient("3567541117411507", "v7x5GodArYha47lEkBNFoJDXDoMd84p1wOqrkvrEkbDtuVwrW98gR3qgKrqydtwgd9ZoeAq54aENESVM"); // API key와 API secret key를 넣어야 함
	}

	@PostMapping("/{imp_uid}")
	public IamportResponse<Payment> paymentByImpUid(@PathVariable String imp_uid) throws IamportResponseException, IOException {
		log.info("paymentByImpUid 진입");
		return iamportClient.paymentByImpUid(imp_uid);
	}


}
