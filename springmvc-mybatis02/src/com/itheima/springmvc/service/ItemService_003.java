package com.itheima.springmvc.service;

import java.util.List;

import com.itheima.springmvc.pojo.Items;

public interface ItemService_003 {
	//查询所有商品
	public List<Items> selectItemsList();

	//根据id查询商品
	public Items selectItemsById(Integer id);
	
	//修改商品
	public void updateItemsById(Items items);
}
