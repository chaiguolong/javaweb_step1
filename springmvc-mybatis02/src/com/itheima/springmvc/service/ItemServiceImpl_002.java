package com.itheima.springmvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.itheima.springmvc.dao.ItemsMapper;
import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.service.ItemService_002;

@Service
public class ItemServiceImpl_002 implements ItemService_002{
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> selectItemsList() {
		return itemsMapper.selectByExampleWithBLOBs(null);
	}

	public Items selectItemsById(Integer id){
		Items items = new Items();
		items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	public void updateItemsById(Items items){
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}



