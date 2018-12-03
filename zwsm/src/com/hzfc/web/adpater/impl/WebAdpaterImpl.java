package com.hzfc.web.adpater.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hzfc.utils.QueryCondition;
import com.hzfc.utils.TablesNameConstants;
import com.hzfc.web.adpater.WebAdpater;
import com.hzfc.web.entity.Category;
import com.hzfc.web.entity.Complaint;
import com.hzfc.web.entity.Content;
import com.hzfc.web.service.CategoryService;
import com.hzfc.web.service.ComplaintService;
import com.hzfc.web.service.ContentCategoryService;
import com.hzfc.web.service.ContentService;
import com.hzfc.web.service.ContractContinuousService;
import com.hzfc.web.service.ContractRevokeService;
import com.hzfc.web.service.D30Service;
import com.hzfc.web.service.DeveloperService;
import com.hzfc.web.service.NoticeService;
import com.hzfc.web.service.PresellService;

public class WebAdpaterImpl implements WebAdpater {

	private CategoryService _categoryService;
	private ContentService _contentService;
	private ContentCategoryService _contentCategoryService;
	private D30Service _d30Service;
	private ComplaintService _complaintService;
	private DeveloperService _developerService;
	private NoticeService _noticeService;
	private ContractContinuousService _contractContinuousService;
	private ContractRevokeService _contractRevokeService;
	private PresellService _presellService;
	
	public CategoryService getCategoryService() {
		return _categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		_categoryService = categoryService;
	}

	public ContentService getContentService() {
		return _contentService;
	}

	public void setContentService(ContentService contentService) {
		_contentService = contentService;
	}

	public ContentCategoryService getContentCategoryService() {
		return _contentCategoryService;
	}

	public void setContentCategoryService(
			ContentCategoryService contentCategoryService) {
		_contentCategoryService = contentCategoryService;
	}

	public D30Service getD30Service() {
		return _d30Service;
	}

	public void setD30Service(D30Service d30Service) {
		_d30Service = d30Service;
	}

	public ComplaintService getComplaintService() {
		return _complaintService;
	}

	public void setComplaintService(ComplaintService complaintService) {
		_complaintService = complaintService;
	}

	public DeveloperService getDeveloperService() {
		return _developerService;
	}

	public void setDeveloperService(DeveloperService developerService) {
		_developerService = developerService;
	}

	public NoticeService getNoticeService() {
		return _noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		_noticeService = noticeService;
	}

	public ContractContinuousService getContractContinuousService() {
		return _contractContinuousService;
	}

	public void setContractContinuousService(
			ContractContinuousService contractContinuousService) {
		_contractContinuousService = contractContinuousService;
	}

	public ContractRevokeService getContractRevokeService() {
		return _contractRevokeService;
	}

	public void setContractRevokeService(ContractRevokeService contractRevokeService) {
		_contractRevokeService = contractRevokeService;
	}

	public PresellService getPresellService() {
		return _presellService;
	}

	public void setPresellService(PresellService presellService) {
		_presellService = presellService;
	}

	public List<Object> selectCategoryList(Map<Object, Object> map) {
		List<Object> categorylist = _categoryService.selectCategoryListByMap(map);
		for (int i = 0; i < categorylist.size(); i++) {
			Category p = (Category) categorylist.get(i);
			if (p.getPid() == 0) {
				categorylist.remove(i--);
				continue;
			}
			for (int j = i + 1; j < categorylist.size(); j++) {
				Category son = (Category) categorylist.get(j);
				if (p.getCategoryid().longValue() == son.getPid().longValue()) {
					int size = 1;
					for(int k = i + 1; k < categorylist.size(); k++) {
						Category bro = (Category) categorylist.get(k);
						if(bro.getPid().longValue() != son.getPid().longValue()) {
							size++;
							break;
						}
					}
					categorylist.add(i + size, son);
					categorylist.remove(j + 1);
				}
			}
		}
		return categorylist;
	}
	
	public List<Object> selectFdcxhCategoryList(Map<Object, Object> map) {
		List<Object> categorylist = _categoryService.selectFdcxhCategoryListByMap(map);
		for (int i = 0; i < categorylist.size(); i++) {
			Category p = (Category) categorylist.get(i);
			if (p.getPid() == 0) {
				categorylist.remove(i--);
				continue;
			}
			for (int j = i + 1; j < categorylist.size(); j++) {
				Category son = (Category) categorylist.get(j);
				if (p.getCategoryid().longValue() == son.getPid().longValue()) {
					int size = 1;
					for(int k = i + 1; k < categorylist.size(); k++) {
						Category bro = (Category) categorylist.get(k);
						if(bro.getPid().longValue() != son.getPid().longValue()) {
							size++;
							break;
						}
					}
					categorylist.add(i + size, son);
					categorylist.remove(j + 1);
				}
			}
		}
		return categorylist;
	}

	public List<Object> selectZjxhCategoryList(Map<Object, Object> map) {
		List<Object> categorylist = _categoryService.selectZjxhCategoryListByMap(map);
		for (int i = 0; i < categorylist.size(); i++) {
			Category p = (Category) categorylist.get(i);
			if (p.getPid() == 0) {
				categorylist.remove(i--);
				continue;
			}
			for (int j = i + 1; j < categorylist.size(); j++) {
				Category son = (Category) categorylist.get(j);
				if (p.getCategoryid().longValue() == son.getPid().longValue()) {
					int size = 1;
					for(int k = i + 1; k < categorylist.size(); k++) {
						Category bro = (Category) categorylist.get(k);
						if(bro.getPid().longValue() != son.getPid().longValue()) {
							size++;
							break;
						}
					}
					categorylist.add(i + size, son);
					categorylist.remove(j + 1);
				}
			}
		}
		return categorylist;
	}
	
	public Content selectContentByContentid(Long contentid) {
		return _contentService.selectContentByContentid(contentid);
	}

	public List<Object> selectContentListByMap(Map<Object, Object> argMap) {
		return _contentService.selectContentListByMap(argMap);
	}
	
	public List<Object> selectContentinfoByMap(Map<Object, Object> map) {
		return _contentService.selectContentinfoByMap(map);
	}
	
	@Override
	public Category selectCategoryByCategoryid(Long categoryid) {
		return _categoryService.selectCategoryByCategoryid(categoryid);
	}

	@Override
	public List<Object> selectAgencyInfo() {
		// 加载详细页面
		List<Object> list = new ArrayList<Object>();
		Content content1 = new Content("基本信息");
		list.add(content1);
		Content content2 = new Content("工作职责");
		list.add(content2);
		Content content3 = new Content("领导班子");
		list.add(content3);
		Content content4 = new Content("内设机构");
		list.add(content4);
		Content content5 = new Content("直属单位");
		list.add(content5);
		Content content6 = new Content("咨询投诉");
		list.add(content6);
		return list;
	}

	@Override
	public List<Object> selectAgencyInfo(Long categoryid) {
		List<Object> list = selectAgencyInfo();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("categoryid", categoryid);
		List<Object> temp = _contentService.selectContentListByMap(map);
		// 详细与右上匹配
		for(int i = 0; i < list.size(); i++) {
			Content content = (Content) list.get(i);
			for(int j = 0; j < temp.size(); j++) {
				Content t = (Content) temp.get(j);
				if(content.getTitle().equals(t.getTitle())) {
					content = _contentService.selectContentByContentid(t.getContentid());
					list.set(i, content);
					temp.remove(j);
					break;
				}
			}
		}
		return list;
	}

	@Override
	public List<Object> selectStatisticForDay() {
		if(TablesNameConstants.IS_OUTER) {
			return _d30Service.selectStatisticForDayAtOuter();
		}
		else {
			return _d30Service.selectStatisticForDay();
		}
	}

	@Override
	public List<Object> selectUsedStatisticForDay() {
		if(TablesNameConstants.IS_OUTER) {
			return _d30Service.selectUsedStatisticForDayAtOuter();
		}
		else {
			return _d30Service.selectUsedStatisticForDay();
		}
	}
	
	@Override
	public List<Object> selectStatisticForMonth() {
		if(TablesNameConstants.IS_OUTER) {
			return _d30Service.selectStatisticForMonthAtOuter();
		}
		else {
			return _d30Service.selectStatisticForMonth();
		}
	}

	@Override
	public void insertComplaint(Complaint complaint) {
		_complaintService.insertComplaint(complaint);
	}

	@Override
	public Complaint selectComplaintByComplaintid(Long complaintid) {
		return _complaintService.selectComplaintByComplaintid(complaintid);
	}

	@Override
	public List<Object> selectComplaintList(Map<Object, Object> argMap) {
		return _complaintService.selectComplaintList(argMap);
	}

	@Override
	public List<Object> selectDeveloperList() {
		//if(TablesNameConstants.IS_OUTER) {
		//	return _developerService.selectDeveloperListOuter();
		//}
		//else {
			return _developerService.selectDeveloperList();
		//}
	}
	
	@Override
	public List<Object> selectPageByQueryCondition(String statementid, QueryCondition queryCondition) {
		return _contentService.selectPageByQueryCondition(statementid, queryCondition);
	}
	@Override
	public List<String> selectNoticeList() {
		return _noticeService.selectNoticeList();
	}

	@Override
	public List<Object> selectContentCategoryList(Map<Object, Object> argMap) {
		return _contentCategoryService.selectCategoryListByMap(argMap);
	}

	@Override
	public String planquery(String name, String slbh) {
		return _noticeService.planquery(name, slbh);
	}

	@Override
	public List<Object> selectContinuousList(Map<Object, Object> map) {
		if(TablesNameConstants.IS_OUTER) {
			return _contractContinuousService.selectAllByMapParam(TablesNameConstants.WEB_CONTRACT_CONTINUOUS + "_selectByMap", map, TablesNameConstants.SQLMAPCLIENTOUTER);
		}
		else {
			return _contractContinuousService.selectAllByMapParam(TablesNameConstants.WEB_CONTRACT_CONTINUOUS + "_selectByMap", map);
		}
	}

	@Override
	public List<Object> selectRevokeList(Map<Object, Object> map) {
		if(TablesNameConstants.IS_OUTER) {
			return _contractContinuousService.selectAllByMapParam(TablesNameConstants.WEB_CONTRACT_REVOKE + "_selectByMap", map, TablesNameConstants.SQLMAPCLIENTOUTER);
		}
		else {
			return _contractContinuousService.selectAllByMapParam(TablesNameConstants.WEB_CONTRACT_REVOKE + "_selectByMap", map);
		}
	}

	@Override
	public List<Object> selectPresellNew15() {
		if(TablesNameConstants.IS_OUTER) {
			return _presellService.selectByStatementid(TablesNameConstants.WEB_COH_PRESELL + "_selectNew15", TablesNameConstants.SQLMAPCLIENTOUTER);
		}
		else {
			return _presellService.selectByStatementid(TablesNameConstants.WEB_COH_PRESELL + "_selectNew15");
		}
	}
	
	@Override
	public List<Object> selectPresellAllNew() {
		if(TablesNameConstants.IS_OUTER) {
			return _presellService.selectByStatementid(TablesNameConstants.WEB_COH_PRESELL + "_selectallNew", TablesNameConstants.SQLMAPCLIENTOUTER);
		}
		else {
			return _presellService.selectByStatementid(TablesNameConstants.WEB_COH_PRESELL + "_selectallNew");
		}
	}

	
}
