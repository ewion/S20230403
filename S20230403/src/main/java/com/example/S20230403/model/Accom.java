package com.example.S20230403.model;

import lombok.Data;

@Data
public class Accom {
	private String biz_id;
	private String user_id;
	private String availability;
	private String accom_type;
	private String biz_name;
	private String addr;
	private String tel;
	private int    room_count;
	private String description;
	private String latitude;
	private String longitude;
	private String pool;
	private String parking;
	private String cafe;
	private String restaurant;
	private String store;
	private String sauna;
	private String laundry;
	private String fitness;
	
	// 재영
	private String content;
	private String user_status;
	
	// 찬규
	private String min_price_r2;
	private String r_img;
	private String avg_rating;
	
	

	//조회용
	private String search;
	private String keyword;

}
