package com.hzfc.web.service;

import java.util.List;

public interface NoticeService {
	
	public List<String> selectNoticeList();
	
	public String planquery(String name, String slbh);
}