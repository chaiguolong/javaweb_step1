package com.itheima.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.itheima.springmvc.dao.ItemsMapper;
import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.service.ItemService_003;

@Service
public class ItemServiceImpl_003 implements ItemService_003{
	@Autowired
	private ItemsMapper itemsMapper;


	@Override
	public List<Items> selectItemsList() {
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
}



