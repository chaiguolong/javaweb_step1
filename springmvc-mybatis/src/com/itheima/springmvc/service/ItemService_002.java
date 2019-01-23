package com.itheima.springmvc.service;

import java.util.List;

import com.itheima.springmvc.pojo.Items;

public interface ItemService_002 {
	//查询商品列表
	public List<Items> selectItemsList();

	//根据id查询商品
	public Items selectItemsById(Integer id);

	//更新items信息
	public void updateItemsById(Items items);
}
