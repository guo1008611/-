package com.guochenglong.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guochenglong.bean.City;
import com.guochenglong.service.MainService;

@Controller
public class MainController {

	
	@Autowired
	private MainService mainservice;
	
	
	@RequestMapping("dojiazai")
	@ResponseBody
	public List<City> list(@RequestParam(defaultValue="1")int pid,Model model) {
		System.err.println("ddddddddddddd0"+pid);
		List<City> list=mainservice.list(pid);
		model.addAttribute("list", list);
		System.out.println(list);

		return list;
	}
	
	@RequestMapping("add")
	public String add() {
		
		return "add";
	}
}
