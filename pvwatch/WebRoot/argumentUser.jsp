<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<!--+" "+ data.items[i].manufactureTime.hours+":"+data.items[i].manufactureTime.minutes+":"+data.items[i].manufactureTime.seconds  -->
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

		<link rel="stylesheet" href="static/css/combo.select.css""/>
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

<title>查询</title>
</head>

<body>	
	<div class="container">
		<div class="row">
			<div class="iblock" id="cominfonamegs">
				 		<div style="float:left;padding-top: 2px;">审核人:</div>
						<select    style="width:200px;height:31px;" class="select  user" name="user" id="user" >
							<option value="-1"></option>
						</select>&nbsp;
			
			</div>
			
			<div style="float:left" >
				<div>申请理由:</div><textarea id="content" rows="10px" cols="64px" ></textarea> 
			</div>
		</div>
	
	</div>

		<script type="text/javascript"
		src="static/akehu/js/tool/jquery-1.11.0.js" ></script>
	<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js" ></script>
	
	<script type="text/javascript" src="static/akehu/jsPlugin/datatables/1.10.0/jquery.dataTables.min.js" ></script>
	<script type="text/javascript"
		src="static/akehu/mainFile/h-ui/js/H-ui.js" ></script>
<script src="static/akehu/jsPlugin/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript"
		src="static/akehu/mainFile/h-ui.admin/js/H-ui.admin.js" ></script>
	<script type="text/javascript"
		src="static/akehu/jsPlugin/icheck/jquery.icheck.min.js" ></script>
	<script type="text/javascript"
		src="static/akehu/jsPlugin/layer-v3.0.1/layer/layer.js" ></script>
	<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js" ></script>
	<script type="text/javascript"
	src="static/akehu/jsPlugin/datePicker/WdatePicker.js" ></script>
	<script type="text/javascript" src="static/js/jquery.combo.select.js"></script>

		

	<script type="text/javascript">
	$(function(){
		//init();
		sysUser();
		//getSession();
	});
	
	function sysUser(){
		$.ajax({
			url:"getUser",
			type:'post',
			anysc:false,
			success:function(data){
				if(data!=null && data !=""){
					var option="";
					 data = JSON.parse(data);
					// console.log(data);
					option+=' <option value="">-请选择-</option>';
					if(data.items.length>0){
					 	for(var i=0;i<data.items.length;i++){			 	
					 	 option += '<option value="'+data.items[i][0]+'">'+data.items[i][1]+'</option>';
					 	}
					 	$("#user").html(option);
					 	comboInputCompanygs();
					}
				}
			}
		})
	}
	
	//初始化用户样式
	function comboInputCompanygs(){
		$(".user").comboSelect();
		$('.combo-input').on('focus',function(){
		$(this).parent().addClass('combo-open');
		});
		$('#user option').each(function(){this.style='display:none'}); 
	}
	
	
	function getInfos(){	
		if($("#content").val()=="" || $("#user").val()==""){
			alert("审核人或理由不能为空");
			return false;
		}
		var formData = new FormData();
		formData.append("content",$("#content").val());		
		formData.append("userName",$("#user").val());	
			return formData;
		}
	</script>
</body>
</html>