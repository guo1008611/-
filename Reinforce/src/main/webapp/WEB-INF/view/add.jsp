<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.js"></script>


<title>Insert title here</title>
	

</head>
<script type="text/javascript">
	
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
	
	</script>
<body>
	<h1>添加</h1>
	
		<div>
		<table>
		<tr> <td><input type="text" name="name"><td></tr>
			<tr>
				<td>省 <select id="sheng" onchange="change(this,'#shi')"></select></td>
				<td>市 <select id="shi" onchange="change(this,'#xian')"></select></td>
				<td>县<select id="xian"></select></td>
			</tr>
		</table>
	</div>
	
	<form id="uploadForm"> 
   <p>上传文件：<input type="file" name="file" /></p> 
   
   <input type="button" value="上传" onclick="upload()" /> 
</form>
	<script type="text/javascript">
	function upload() { 
		   var formData = new FormData($("#uploadForm")[0]); 
		   $.ajax({ 
		     url: 'aaa', 
		     type: 'POST', 
		     data: formData, 
		     async: false,  //  异常
		     cache: false,   // 译高速缓存
		     contentType: false, 
		     processData: false,   //   处理
		     success: function(data) {
		    	alert("chengg");
		     }, 
		     error: function(data) {   
		    	 alert("dd");
		     } 
		   }); 
		}
	</script>

</body>
</html>