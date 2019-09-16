<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/cms.css?v=1.1" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.js"></script>


<title>Insert title here</title>

</head>
<body>

<div style="height: 50px;"></div>
	
	<div class="container">
		<div class="row passport_bg">
			<div class="col-md-6">
				<div class="passport_panel">
					<div class="card">
					  <div class="card-header">欢迎回来</div>
					  <div class="card-body">
					  
					    <form id="form">
							<p  align="center" style="color: red"> ${msg } ${error }</p>
								
								<div class="form-group">
									<label for="username">用户名:</label> <input type="text"
										class="form-control"  name ="username"id="username" placeholder="请输入用户名">
								 <span id="umsg" style="color: red"></span>
								</div>
								
								<div class="form-group">
									<label for="password">密码:</label> <input type="password"
										class="form-control" name="password" id="password" placeholder="请输入密码">
								</div>
								
								
									<!-- 验证码 -->				
								<div class="form-group row">
									<label class="col-sm-3">验证码</label>
									<div class="col-sm-5">
										<input type="text" name="code" id="code" class="form-control"
											placeholder="请输入验证码" />
									</div>
									<div class="col-sm-3">
										<img src="${pageContext.request.contextPath}/code" onclick="changeCode(this)" width="80px" height="38px" />
									</div>
								</div>
								
									<!-- 登录 -->	
								<div class="form-group">
									<button type="button"   class="btn btn-info" onclick="login()">登录</button>
								<p class="w-100" align="right">
									如果没有有帐号，请<a href="register">点这里注册</a>
								</p>
								</div>

							</form>
					    
					  </div>
					</div>
				</div>
			</div>
			
			
			<!--右边俩头像  -->
			 <div class="col-md-6">
				<div class="passport_r">
					<h3>最新加入的用户：</h3>
					<p align="center">
					<img src="/resource/images/guest.jpg" alt="..." class="rounded-circle img-thumbnail"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<img src="/resource/images/guest1.jpg" alt="..." class="rounded-circle img-thumbnail"/>
					</p>
				</div>
			</div>
			
			
		</div>
	</div>
	<div><br/><br/></div>
	
	<script type="text/javascript">
			//登录
			function login(){
					var username =$.trim($("[name='username']").val());
					var password =$.trim($("[name='password']").val());
					if(username =="" ||password ==""){
						$("#umsg").text("用户或密码不能为空");
						return;
					}
					
					$.post("login",$("#form").serialize(),function(obj){
						if(obj.code==10001){
							alert("登录成功");
							location.href="/index/";//进入个人页面
						}else{
							$("#umsg").text("登录失败.用户或密码有误");
						}
					})
					
				}
			
			
			//更换验证码
			function changeCode(obj){
		        $(obj).attr("src","/code?time="+new Date().getTime());
			  }
	</script>
</body>
</html>