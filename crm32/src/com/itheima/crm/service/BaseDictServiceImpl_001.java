package com.itheima.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.BaseDictDao_001;
import com.itheima.crm.pojo.BaseDict;

@Service
public class BaseDictServiceImpl_001 implements BaseDictService_001{
	@Autowired
	private BaseDictDao_001 baseDictDao_001;

	@Override
	public List<BaseDict> selectBaseDictListByCode(String code) {
		return baseDictDao_001.selectBaseDictListByCode(code);
	}
}
