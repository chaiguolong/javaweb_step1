package com.itheima.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.service.ItemService_002;


@Controller
public class ItemController_002 {
	@Autowired
	private ItemService_002 itemService_002;


	// @RequestMapping(value="/item/itemList_002.action")
	// public ModelAndView itemList(){
	// 	List<Items> list  = itemService_002.selectItemsList();
	// 	ModelAndView mav = new ModelAndView();
	// 	mav.addObject("itemList",list);
	// 	mav.setViewName("itemList_002");
	// 	return mav;
	// }


	@RequestMapping(value="/item/itemList_002.action")
	public String itemList(Model model){
		List<Items> list = itemService_002.selectItemsList();
		model.addAttribute("itemList",list);
		return "itemList_002";
	}

	@RequestMapping(value="/deletes_002.action")
	public ModelAndView deletes(@RequestParam("ids") Integer[] ids){
		for (int i = 0; i<ids.length; i++) {
			System.out.println(ids[i]);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;

	}


}



