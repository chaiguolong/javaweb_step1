package com.itheima.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.service.ItemService_003;

@Controller
public class ItemController_003 {
	// @Autowired
	// private ItemService_003 itemService_003;
	// @RequestMapping(value="/item/itemList.action")
	// public ModelAndView itemList(){
	// 	List<Items> list = new ArrayList<Items>();
	// 	list = itemService_003.selectItemsList();
	// 	ModelAndView mav = new ModelAndView();
	// 	mav.addObject("itemList",list);
	// 	mav.setViewName("itemList");
	// 	return mav;
	// }
    //
	// @RequestMapping(value="/itemEdit.action")
	// public ModelAndView toEdit(HttpServletRequest request){
	// 	String id = request.getParameter("id");
	// 	Items items = itemService_003.selectItemsById(Integer.parseInt(id));
	// 	ModelAndView mav = new ModelAndView();
	// 	mav.addObject("item",items);
	// 	mav.setViewName("editItem");
	// 	return mav;
	// }
    //
	// @RequestMapping(value="/updateitem.action")
	// public ModelAndView updateItemsById(Items items){
	// 	itemService_003.updateItemsById(items);
	// 	ModelAndView mav = new ModelAndView();
	// 	mav.setViewName("success");
	// 	return mav;
	// }

}



