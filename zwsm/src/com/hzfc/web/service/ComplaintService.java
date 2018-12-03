package com.hzfc.web.service;

import java.util.List;
import java.util.Map;

import com.hzfc.web.entity.Complaint;

public interface ComplaintService {

	public List<Object> selectComplaintList(Map<Object, Object> argMap);
	
	public Complaint selectComplaintByComplaintid(Long complaintid);
	
	public void insertComplaint(Complaint complaint);
}
