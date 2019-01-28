package com.itheima.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService_002;


@Controller
public class ItemController_002 {
	@Autowired
	private ItemService_002 itemService_002;

	@RequestMapping(value="/item/itemList_002.action")
	public String itemList(Model model){
		List<Items> list = itemService_002.selectItemsList();
		model.addAttribute("itemList",list);
		return "itemList_002";
	}

	@RequestMapping(value="/itemEdit_002.action")
	public String toEdit(@RequestParam(value="id",required=false)Integer id,Model model){
		Items items = itemService_002.selectItemsById(id);
		model.addAttribute("items",items);
		return "editItem_002";
	}

	@RequestMapping(value="/updateitem_002.action")
	public String updateitem(Items items,Model model){
		itemService_002.updateItemsById(items);
		return "success";
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

	@RequestMapping(value="/updates_002.action")
	public String updates(QueryVo vo){
		for (int i = 0; i < vo.getItemsList().size(); i++) {
			System.out.println(vo.getItemsList().get(i).getName());
			itemService_002.updateItemsById(vo.getItemsList().get(i));
		}
		return "success";
	}

	@RequestMapping(value="/login_002.action",method = RequestMethod.GET)
	public String login(){
		return "login_002";
	}

	@RequestMapping(value="/login_002.action",method = RequestMethod.POST)
	public String login(@RequestParam("username")String username,HttpSession httpSession){
		System.out.println(username);
		httpSession.setAttribute("USER_SESSION",username);
		return "redirect:/item/itemList_002.action";
	}




}



