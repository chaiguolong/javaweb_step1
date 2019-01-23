package com.itheima.springmvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.itheima.springmvc.dao.ItemsMapper;
import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.service.ItemService_001;

@Service
public class ItemServiceImpl_001 implements ItemService_001{

	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> selectItemsList() {
		return itemsMapper.selectByExampleWithBLOBs(null);
	}

	public Items selectItemsById(Integer id){
		return itemsMapper.selectByPrimaryKey(id);
	}
	public void updateItemsById(Items items){
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);

	}
}



