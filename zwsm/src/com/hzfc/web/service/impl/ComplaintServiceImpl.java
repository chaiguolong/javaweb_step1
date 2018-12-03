package com.hzfc.web.service.impl;

import java.util.List;
import java.util.Map;

import com.hzfc.utils.TablesNameConstants;
import com.hzfc.web.dao.ComplaintDAO;
import com.hzfc.web.entity.Complaint;
import com.hzfc.web.service.ComplaintService;

public class ComplaintServiceImpl implements ComplaintService {

	private ComplaintDAO _complaintDao;

	public ComplaintDAO getComplaintDao() {
		return _complaintDao;
	}

	public void setComplaintDao(ComplaintDAO complaintDao) {
		_complaintDao = complaintDao;
	}

	@Override
	public void insertComplaint(Complaint complaint) {
		_complaintDao.insert(TablesNameConstants.WEB_WEB_COMPLAINT, complaint);
	}

	@Override
	public Complaint selectComplaintByComplaintid(Long complaintid) {
		return (Complaint) _complaintDao.selectByPrimaryKey(
				TablesNameConstants.WEB_WEB_COMPLAINT, complaintid);
	}

	@Override
	public List<Object> selectComplaintList(Map<Object, Object> argMap) {
		return _complaintDao.selectAllByMapParam(
				TablesNameConstants.WEB_WEB_COMPLAINT + "_selectByMap", argMap);
	}

}