<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>欢迎注册</title>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/resource/css/cms.css" />

<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"> </script>


<script type="text/javascript">


//动态加载
function change(obj,subObjId){
	var parentId=0;
	if(obj=='null'){
		parentId=1;
	}else{
		parentId=$(obj).val();
	}
	alert($(obj).val());
	$.ajax({
		url:"dojiazai?pid=" + parentId,
		type:"post",
		success:function(datas){
			
			$(subObjId).empty();
			$(subObjId).append('<option value="0">请选择</option>')
			for(var i in datas){
			
				$(subObjId).append('<option value="'+datas[i].cityid+'">'+datas[i].cityname+'</option>')
			}
		}
		
	})
}

$(function(){
	
	change('null','#sheng');
})





function validator(){
	var username =$.trim($("[name='username']").val());
	var password =$.trim($("[name='password']").val());
	var repassword =$.trim($("[name='repassword']").val());
	
	if(username =="" ||password ==""){
		$("#umsg").text("用户或密码不能为空");
		return;
	}
	
	
	var flag=0;
	//校验用户是否唯一
	$.post("checkuser",{username:username},function(obj){
		if(obj){
			$("#umsg").text("该用户名已经存在");
			flag=1;
			 return ;
		}else{
			$("#umsg").text("");
		}
	})
	
	if(password!=repassword){
		$("#pmsg").text("两次密码输入不一致");
		return;	
	}
	if(flag==0){
		$.post("reg",$("form").serialize(),function(obj){
			if(obj){
				alert("注册成功")
				location.href="login";
			}
			
			
		})
	}
	
	
}


</script>
</head>
<body>

	<!-- 登录注册页面 -->
	<div style="height: 50px;"></div>

	<div class="container">
		<div class="row passport_bg">
			<div class="col-md-6">
				<div class="passport_panel">
					<div class="card">
						<div class="card-header">欢迎注册</div>
						<div class="card-body">


							<form action="" method="post">
							<p class="w-100" align="center" style="color: red"> ${msg }</p>
								<div class="form-group">
									<label for="username">用户名:</label> <input type="text"
										class="form-control"  name ="username"id="username" placeholder="请输入用户名" >
								  <span id="umsg" style="color: red"></span>
								</div>
								<div class="form-group">
									<label for="password">密码:</label> <input type="password"
										class="form-control" name="password" id="password" placeholder="请输入密码">
								</div>
								<div class="form-group">
									<label for="repassword">确认密码:</label> <input type="password"
										class="form-control" name="repassword" id="repassword" placeholder="再次输入密码">
								 <span id="pmsg" style="color: red"></span>
								</div>
								<div class="form-group">
									<label for="gender">性别:</label> <input class="radio" type="radio"
										class="form-control" name="gender" id="gender" value="1" checked="checked">男 <input
										type="radio"  class="radio" name="gender" class="form-control" id="gender" value="2">女
								</div>
								<div>
								<tr>
								</label>地址：
				<td>省 <select  class="selectpicker show-tick form-control" data-live-search="true" id="sheng" onchange="change(this,'#shi')"></select></td>
				<td>市 <select  class="selectpicker show-tick form-control" data-live-search="true"  id="shi" onchange="change(this,'#xian')"></select></td>
				<td>县<select  class="selectpicker show-tick form-control" data-live-search="true" id="xian"></select></td>
			</tr>
								
								
								</div>
								<div class="form-group">
									<button type="button" onclick="validator()"  >注册</button>
								<p class="w-100" align="right">
									如果已有帐号，请<a href="login">点这里登录</a>
								</p>
								</div>

							</form>


						</div>
					</div>
				</div>
			</div>
		
		</div>
	</div>
	<div>
		<br /> <br />
	</div>

	<script type="text/javascript">
	</script>
</body>
</html>