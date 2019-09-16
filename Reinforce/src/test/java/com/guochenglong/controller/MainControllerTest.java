package com.guochenglong.controller;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class MainControllerTest {

	@Test
	public void test(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException {
	
		DownFileUtils.download("E:\\pic\\", request, response, "5e1c5b5f-a023-4b93-84ce-df89a4c12dbc.jpg");
	}

}
