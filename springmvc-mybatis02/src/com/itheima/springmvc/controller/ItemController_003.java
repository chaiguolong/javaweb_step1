package com.itheima.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value="/json_003.action")
	public @ResponseBody Items json(@RequestBody Items items){
		return items;
	}

	@RequestMapping(value="/login_003.action",method=RequestMethod.GET)
	public String login(){
		return "login_003";
	}

	@RequestMapping(value="/login_003.action",method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,HttpSession httpSession){
		httpSession.setAttribute("USER_SESSION",username);
		return "redirect:/item/itemList_003.action";
	}


}



