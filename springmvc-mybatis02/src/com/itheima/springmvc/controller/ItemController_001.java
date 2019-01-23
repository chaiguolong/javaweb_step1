package com.itheima.springmvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService_001;

@Controller
public class ItemController_001 {
	@Autowired
	private ItemService_001 itemService_001;


	@RequestMapping(value="/item/itemList_001.action")
	public String itemList(Model model){
		List<Items> list = itemService_001.selectItemsList();
		model.addAttribute("itemList",list);
		return "itemList_001";
	}

	@RequestMapping(value="/itemEdit_001.action")
	public String toEdit(@RequestParam("id") Integer id,Model model){
		Items items = itemService_001.selectItemsById(id);
		model.addAttribute("items",items);
		return "editItem_001";
	}

	@RequestMapping(value="/updateitem_001.action")
	public String updateitem(Items items,HttpServletRequest request,Model model) throws Exception{
		request.setCharacterEncoding("UTF-8");
		itemService_001.updateItemsById(items);
		return "success";
	}

	@RequestMapping(value="/deletes_001.action")
	public ModelAndView deletes(@RequestParam("ids") Integer[] ids){
		for (int i=0; i<ids.length; i++) {
			System.out.println(ids[i]);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}

	//修改
	@RequestMapping(value="/updates_001.action")
	public String updates(QueryVo vo){
		for (int i=0; i < vo.getItemsList().size(); i++) {
			System.out.println(vo.getItemsList().get(i).getId());
			itemService_001.updateItemsById(vo.getItemsList().get(i));
		}
		return "success";
	}


	


}


