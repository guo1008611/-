package com.guochenglong.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guochenglong.bean.City;
import com.guochenglong.mapper.MainMapper;

@Service
public class MainService {

	
	@Autowired
	private MainMapper mainmapper;
	
	
	public List<City> list(int pid) {
		// TODO Auto-generated method stub
		return mainmapper.list(pid);
	}

}
