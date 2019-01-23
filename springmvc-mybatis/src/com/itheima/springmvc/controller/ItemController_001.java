package com.itheima.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService_001;

@Controller
public class ItemController_001 {
	// @Autowired
	// private ItemService_001 itemService_001;
	// @RequestMapping(value="/item/itemList.action")
	// public ModelAndView itemList(){
	// 	List<Items> list = itemService_001.selectItemsList();
	// 	ModelAndView mav = new ModelAndView();
	// 	mav.addObject("itemList",list);
	// 	mav.setViewName("itemList");
	// 	return mav;
    //
	// }
    //
	// @RequestMapping(value="/itemEdit.action")
	// public ModelAndView toEdit(HttpServletRequest request){
	// 	System.out.println("-----------");
	// 	String id = request.getParameter("id");
	// 	System.out.println(id);
	// 	Items items = itemService_001.selectItemsById(Integer.parseInt(id));
	// 	ModelAndView mav = new ModelAndView();
	// 	mav.addObject("item",items);
	// 	mav.setViewName("editItem");
	// 	return mav;
	// }
    //
	// @RequestMapping(value="/updateitem.action")
	// public ModelAndView updateItemsById(Items items){
	// // public ModelAndView updateItemsById(QueryVo queryVo){
	// 	// Items items = queryVo.getItems();
	// 	System.out.println(items.toString());
	// 	itemService_001.updateItemsById(items);
	// 	ModelAndView mav = new ModelAndView();
	// 	mav.setViewName("success");
	// 	return mav;
	// }
    //
}



