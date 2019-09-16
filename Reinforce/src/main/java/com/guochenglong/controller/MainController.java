package com.guochenglong.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.guochenglong.bean.City;
import com.guochenglong.bean.User;
import com.guochenglong.service.MainService;
import com.guochenglong.utils.CodeUtil;
import com.guochenglong.utils.Md5Util;

@Controller
public class MainController {

	
	@Autowired
	private MainService mainservice;
	
	
	
	//下载跳转页面的方法
	@RequestMapping(value = "xiazai")
	public String xiazai() {
		return "xiazia";
		
	}
	//下载
	@RequestMapping(value = "download")
	public void download(HttpServletRequest request,HttpServletResponse response ,String fileName) {
		try {						//在本地的路径
			DownFileUtils.download("D:\\1703A\\git\\Reinforce\\src\\main\\webapp\\WEB-INF\\view\\img\\", request, response, fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//动态加载
	@RequestMapping("dojiazai")
	@ResponseBody
	public List<City> list(@RequestParam(defaultValue="1")int pid,Model model) {
		System.err.println("ddddddddddddd0"+pid);
		List<City> list=mainservice.list(pid);
		model.addAttribute("list", list);
		System.out.println(list);

		return list;
	}
	
	
	//添加页面
	@RequestMapping("add")
	public String add() {
		return "add";
	}
	
	
	
	//register  注册页面
		@RequestMapping("register")
		public String register() {
			return "reg";
		}
		
		  //注册用户
	    @ResponseBody
		@RequestMapping("reg")
		public boolean reg(User user) {
	    	//对密码进行加密
	    	user.setPassword(Md5Util.md5Encoding(user.getPassword()));
			return mainservice.insert(user)>0;
		}
	    
	    
	    //校验用户唯一
	    @ResponseBody
		@RequestMapping("checkuser")
		public boolean reg(String username) {
	    	User user = mainservice.getByUsername(username);
	    	return user!=null;
	}
	
	    
	    
	//login  页面
	@RequestMapping(value="login" ,method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	 //登录
    @ResponseBody
	@RequestMapping(value="login" ,method = RequestMethod.POST)
	public Map<String, Object> login(@RequestParam(defaultValue="")String code,User user,HttpSession session,HttpServletRequest request) {
    	Map<String,Object> map =new HashMap<>();
    	HttpSession session2 = request.getSession();
    	String code1 = (String) session2.getAttribute("code");

    	if(code1.equals(code)) {
    		 //根据用户名查询用户
        	User user2 = mainservice.getByUsername(user.getUsername());
        	if(null!=user2) {	
        		//把当前登录的用户密码加密后和实际密码比较
        	   	if(Md5Util.md5Encoding(user.getPassword()).equals(user2.getPassword())) {
        	   			
        	   		////当密码成功时把用户存入reids
        	   	//	RedisTemplate.opsForHash().put("User", "User"+user.getId(), user);
        	   	//把用户存入session+
        	   		session.setAttribute("user", user2);
        	   		map.put("code", 10001);
        	   		map.put("msg", "用户名和密码正确");
        	   		
        	   	}
    	}else {
    		map.put("code", 10002);
			map.put("msg", "用户名或密码错误");
    	}
    		
    	}else {
    		map.put("code", 10003);
			map.put("msg", "验证码错误");
    	}
    	return map;

}
	
	//验证码
	@RequestMapping(path = "/code", method = RequestMethod.GET)
	public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1.创建验证码
		Map<String, Object> map = CodeUtil.generateCodeAndPic();
		// 获取session会话对象
		HttpSession session = request.getSession();
		// 2. 验证码存入到session会话
		session.setAttribute("code", map.get("code").toString());

		//2-3 可以设置浏览器缓存处理
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -1);

		
		
		//3. 设置响应的类型，以指定方式响应给客户端
		response.setContentType("image/jpeg");
		// 流对象
		ServletOutputStream sos = response.getOutputStream();
		// 获取的图片
		BufferedImage image = (BufferedImage) map.get("codePic");
		//写入到指定的流中
		ImageIO.write(image, "jpeg", sos);
		//关闭流
		sos.flush();
		sos.close();

	}
	
	
	//上传文件
	@RequestMapping("aaa")
	@ResponseBody
	public boolean shangchuang(MultipartFile file) throws IllegalStateException, IOException {

			try {
				if(!file.isEmpty()) {
					String name = file.getOriginalFilename();
					String newname=UUID.randomUUID()+name.substring(name.lastIndexOf("."));
					File cc=new File("E:/pic/"+newname);
					//写到硬盘
					file.transferTo(cc);
					return true;
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
	
	
	


}