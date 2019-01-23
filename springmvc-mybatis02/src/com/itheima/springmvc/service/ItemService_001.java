package com.itheima.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itheima.springmvc.pojo.Items;

@Service
public interface ItemService_001 {
	//查询商品列表
	public List<Items> selectItemsList();

	//根据id查询商品
	public Items selectItemsById(Integer id);

	//修改商品信息
	public void updateItemsById(Items items);
}
