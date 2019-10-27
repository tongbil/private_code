<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
  <head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="static/akehu/jsPlugin/icheck/icheck.css"  rel="stylesheet" type="text/css">
<link href="static/akehu/mainFile/h-ui/css/H-ui.min.css"
	rel="stylesheet" type="text/css">
<link href="static/akehu/mainFile/h-ui.admin/css/H-ui.admin.css"
	rel="stylesheet" type="text/css">
<link href="static/akehu/jsPlugin/Hui-iconfont/1.0.7/iconfont.css"
	rel="stylesheet" type="text/css">
<link href="static/akehu/css/groupManage.css" rel="stylesheet"
	id="skin" type="text/css">
<link href="static/akehu/font-awesome-4.7.0/css/font-awesome.min.css"  rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="static/akehu/css/productBaseInfo.css"/>
<link href="static/akehu/css/bootstrap.min.css" rel="stylesheet">	
<style type="text/css">
.progress-label {
	position: absolute;
	left: 50%;
	top: 5px;
	font-weight: bold;
	text-shadow: 1px 1px 0 #fff;
	margin-left: -80px;
}
	. label {
	width: 100px; 
	}

</style>
<script src="static/akehu/jsPlugin/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js" ></script>
	<script type="text/javascript"
		src="static/akehu/js/tool/jquery-1.11.0.js" />
	<script type="text/javascript" src="static/akehu/jsPlugin/datatables/1.10.0/jquery.dataTables.min.js" ></script>
	<script type="text/javascript"
		src="static/akehu/mainFile/h-ui/js/H-ui.js" />
	<script type="text/javascript"
		src="static/akehu/mainFile/h-ui.admin/js/H-ui.admin.js" />
	<script type="text/javascript"
		src="static/akehu/jsPlugin/icheck/jquery.icheck.min.js" />
	<script type="text/javascript"
		src="static/akehu/jsPlugin/layer-v3.0.1/layer/layer.js" />
	<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js" />
	<script type="text/javascript"
	src="static/akehu/jsPlugin/datePicker/WdatePicker.js" />
		<script type="text/javascript">
	 function jumpFor(){
		 layer.open({
				area: ['1000px','350px'],
				title:"添加数量",
				type: 2,
				skin: 'layui-layer-rim', //加上边框
				content:'numberLay.htm',
				btn:["继续录入","确定","取消"],
				btn1:function(index,layero){

					var formData1=$(layero).find("iframe")[0].contentWindow.getInfo();
					$(layero).find("iframe")[0].contentWindow.star();
									
					$.ajax({
						url: "saveNum",
						type: 'post',
						data:formData1,
						processData:false,
		                contentType: false,
						success: function(data){
							layer.alert('新增成功');
						/* 	if(data!=null && data!=""&&data!="null"){
							data = JSON.parse(data);
							} */
						}
					});	
			},
				btn2:function(index,layero){
					
					
					var formData1=$(layero).find("iframe")[0].contentWindow.getInfo();
					
									
					$.ajax({
						url: "saveNum",
						type: 'post',
						data:formData1,
						processData:false,
		                contentType: false,
						success: function(data){
							if(data!=null && data!=""&&data!="null"){
							data = JSON.parse(data);
								layer.alert('新增成功');
								layer.close(index);															
							}
						}
					});	
			},
			});
	 };
	</script>
  </head>
  
  <body>
  		<button onclick="jumpFor();" class="btn btn-success radius" style="background-color:#1883D7;border:1px solid #1883D7;border:radius" type="button" >销量</button>
 		
  </body>
</html>
