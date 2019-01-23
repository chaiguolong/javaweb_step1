package com.whiteDream.service;

import java.util.List;

import com.whiteDream.dao.MessageBoardDao;
import com.whiteDream.entity.MessageInfo;

public class MessageBoardService {

	public boolean addMessage(MessageInfo m){
		MessageBoardDao dao = new MessageBoardDao();
		int update = 0;
		try {
			update = dao.addMessage(m);
		} catch(Exception e){
			e.printStackTrace();
		}

		return update > 0 ? true :false;
	}

	public List<MessageInfo> findListNewMessage(){
		MessageBoardDao dao = new MessageBoardDao();
		List<MessageInfo> messageList = null;
		try {
			messageList = dao.findListNewMessage();
		} catch(Exception e){
			e.printStackTrace();
		}
		return messageList;
	}

}
