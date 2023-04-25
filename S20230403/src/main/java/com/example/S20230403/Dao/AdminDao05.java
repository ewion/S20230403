package com.example.S20230403.Dao;

import java.util.List;

import com.example.S20230403.model.JooJoin;

public interface AdminDao05 {
	int 			delUsers(JooJoin jooJoin);
	int 			delAccom(JooJoin jooJoin);
	int				delQnA(int qna_id);
	int				delReview(int pay_id);
//	For Paging
	int userTotal();
	int accomTotal();
	int qnaTotal();
	int reviewTotal();
	List<JooJoin> userlist(JooJoin jooJoin);
	List<JooJoin> accomlist(JooJoin jooJoin);
	List<JooJoin> qnalist(JooJoin jooJoin);
	List<JooJoin> reviewlist(JooJoin jooJoin);
}
