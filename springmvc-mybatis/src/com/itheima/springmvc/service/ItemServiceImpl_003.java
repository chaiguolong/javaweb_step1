package com.itheima.springmvc.service;

import java.util.ArrayList;
import java.util.Date;
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
	public List<Items> selectItemsList(){
		List<Items> list = new ArrayList<Items>();
		list = itemsMapper.selectByExampleWithBLOBs(null);
		return list;
	}


	public Items selectItemsById(Integer id){
		Items items = new Items();
		items = itemsMapper.selectByPrimaryKey(id);
		return items;

	}


	public void  updateItemsById(Items items){
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}



