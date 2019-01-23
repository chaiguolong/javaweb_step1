package com.itheima.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;

@Controller
public class ItemController_003 {
	@RequestMapping(value="/item/itemList.action")
	public ModelAndView itemList(){
    // public Items(Integer id, String name, Float price, Date createtime, String detail) {
		List<Items> list = new ArrayList<Items>();
		list.add(new Items(1,"11华为荣耀",2399.99f,new Date(),"华1111为荣耀手机真的很好"));
		list.add(new Items(2,"22华为荣耀",2399.99f,new Date(),"华2222为荣耀手机真的很好"));
		list.add(new Items(3,"33华为荣耀",2399.99f,new Date(),"华3333为荣耀手机真的很好"));
		list.add(new Items(4,"44华为荣耀",2399.99f,new Date(),"华4444为荣耀手机真的很好"));
		list.add(new Items(5,"55华为荣耀",2399.99f,new Date(),"华5555为荣耀手机真的很好"));
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList",list);
		mav.setViewName("itemList");
		return mav;
	}

}



