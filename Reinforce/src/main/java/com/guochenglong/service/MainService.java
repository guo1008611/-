package com.guochenglong.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guochenglong.bean.City;
import com.guochenglong.bean.User;
import com.guochenglong.mapper.MainMapper;

@Service
public class MainService {

	
	@Autowired
	private MainMapper mainmapper;
	
	
	public List<City> list(int pid) {
		// TODO Auto-generated method stub
		return mainmapper.list(pid);
	}


	//查询姓名
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return mainmapper.getByUsername(username);
	}


	//注册
	public int insert(User user) {
		// TODO Auto-generated method stub
		return mainmapper.insert(user);
	}

}
