package com.itheima.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService_002;

@Controller
public class ItemController_002 {
	// @Autowired
	// private ItemService_002 itemService_002;
    //
	// @RequestMapping(value="/item/itemList.action")
	// public ModelAndView itemList(){
	// 	System.out.println("--------1111-------");
	// 	List<Items> list = itemService_002.selectItemsList();
	// 	ModelAndView mav = new ModelAndView();
	// 	mav.addObject("itemList",list);
	// 	mav.setViewName("itemList");
	// 	return mav;
	// }
    //
	// @RequestMapping(value="/itemEdit.action")
	// public ModelAndView toEdit(HttpServletRequest request){
	// 	System.out.println("--------2222-------");
	// 	Items items = itemService_002.selectItemsById(Integer.parseInt(request.getParameter("id")));
	// 	ModelAndView mav = new ModelAndView();
	// 	mav.addObject("item",items);
	// 	mav.setViewName("editItem");
	// 	return mav;
	// }
    //
	// @RequestMapping(value="updateitem.action")
	// public ModelAndView updateItem(QueryVo queryVo){
	// // public ModelAndView updateItem(Items items){
	// 	System.out.println("--------3333-------");
	// 	Items items = queryVo.getItems();
	// 	System.out.println(items.toString());
	// 	itemService_002.updateItemsById(items);
	// 	ModelAndView mav = new ModelAndView();
	// 	mav.setViewName("success");
	// 	return mav;
	// }

}



