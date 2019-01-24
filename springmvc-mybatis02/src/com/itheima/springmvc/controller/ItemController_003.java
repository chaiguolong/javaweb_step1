package com.itheima.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService_003;

@Controller
public class ItemController_003 {
	@Autowired
	private ItemService_003 itemService_003;
	
	@RequestMapping(value="/item/itemList_003.action")
	public String itemList(Model model) throws Exception{
		List<Items> list = itemService_003.selectItemsList();
		model.addAttribute("itemList",list);
		return "itemList_003";
	}

	@RequestMapping(value="/itemEdit_003.action")
	public String toEdit(Model model,HttpServletRequest request){
		String id = request.getParameter("id");
		System.out.println(id);
		Items items = itemService_003.selectItemsById(Integer.parseInt(id));
		model.addAttribute("items",items);
		return "editItem_003";
	}

	@RequestMapping(value="/updateitem_003.action")
	public String updateItemsById(Items items){
		itemService_003.updateItemsById(items);
		return "success";
	}


	@RequestMapping(value="/deletes_003.action")
	public ModelAndView deletes(@RequestParam("ids") Integer[] ids){
		for (int i = 0; i < ids.length; i++) {
			System.out.println(ids[i]);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}

	@RequestMapping(value="/updates_003.action")
	public String updates(QueryVo vo){
		for (int i = 0 ; i < vo.getItemsList().size() ; i++) {
			itemService_003.updateItemsById(vo.getItemsList().get(i));
		}
		return "success";
	}


}



