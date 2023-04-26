package com.example.S20230403.service.ljyService;

import java.util.List;

import com.example.S20230403.model.Accom;
import com.example.S20230403.model.Comm;
import com.example.S20230403.model.Room;
import com.example.S20230403.model.Users;

public interface SukbakService01 {

	void 			accomInsert(OwnerUser01 ownerUser);

	List<Accom>   	accomList(String id);

	List<Comm>		selectCommList(int i);

	Accom 			accomSelect(String biz_id);

	void 			accomUpdate(Accom accom);

	void 			accomDelete(String biz_id);

	String 			getDBPassword(String user_id);

	Users 			getNowLoginUser(String user_id);

	int 			userDelete(String user_id);

	void 			userUpdate(Users nowLoginUser);

	List<Room> 		roomList(String user_id);

	void 			roomInsert(Room room);


} 
         