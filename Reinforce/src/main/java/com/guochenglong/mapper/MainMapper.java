package com.guochenglong.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.guochenglong.bean.City;


@Mapper
public interface MainMapper {

	
	
	List<City> list(@Param("pid")int pid);

}
