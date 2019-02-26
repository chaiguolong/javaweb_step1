package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService_001;

@Controller
public class CustomerController_001 {
	@Autowired
	private BaseDictService_001 baseDictService_001;

	//注解在成员变量上
	@Value("${fromType.code}")
	private String fromTypeCode;

	@RequestMapping(value="/customer/list_001")
	public String list(QueryVo vo,Model model){
		List<BaseDict> fromType = baseDictService_001.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService_001.selectBaseDictListByCode("001");
		List<BaseDict> levelType= baseDictService_001.selectBaseDictListByCode("006");
		model.addAttribute("fromType",fromType);
		model.addAttribute("industryType",industryType);
		model.addAttribute("levelType",levelType);
		return "customer_001";
	}
}



