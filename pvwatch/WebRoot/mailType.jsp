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

<title>查询</title>
</head>

<body>	
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<span style="color:red">* </span><span>附件类型:</span>
			</div>
			
			<div class="col-md-4 col-md-offset-4">
			<input  type="radio" value="1"  name="rd_Grame" />说明书 &nbsp; &nbsp; &nbsp;
			<input  type="radio" value="2"  name="rd_Grame"/>病例 &nbsp; &nbsp; &nbsp;
			<input  type="radio" value="3"  name="rd_Grame"/>现场调查报告 &nbsp; &nbsp; &nbsp;
			<input  type="radio" value="4"  name="rd_Grame"/>尸检报告 &nbsp; &nbsp; &nbsp;
			<input  type="radio" value="5"  name="rd_Grame"/>药品检验报告 &nbsp; &nbsp; &nbsp;
			<input  type="radio" value="6"  name="rd_Grame"/>文献 &nbsp; &nbsp; &nbsp;
			<input  type="radio" value="99"  name="rd_Grame"/>其他 &nbsp; &nbsp; &nbsp;
			<input  type="radio" value="999" name="rd_Grame"/><span style="color:red">仅查看不上传直报系统</span> &nbsp; &nbsp; &nbsp;
			</div>
		</div>
		<input type="submit" value="按钮"  onclick="getInfos()"/ >
	</div>

	<script src="static/akehu/jsPlugin/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js" ></script>
	<script type="text/javascript"
		src="static/akehu/js/tool/jquery-1.11.0.js" ></script>
	<script type="text/javascript" src="static/akehu/jsPlugin/datatables/1.10.0/jquery.dataTables.min.js" ></script>
	<script type="text/javascript"
		src="static/akehu/mainFile/h-ui/js/H-ui.js" ></script>
	<script type="text/javascript"
		src="static/akehu/mainFile/h-ui.admin/js/H-ui.admin.js" ></script>
	<script type="text/javascript"
		src="static/akehu/jsPlugin/icheck/jquery.icheck.min.js" ></script>
	<script type="text/javascript"
		src="static/akehu/jsPlugin/layer-v3.0.1/layer/layer.js" ></script>
	<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js" ></script>
	<script type="text/javascript"
	src="static/akehu/jsPlugin/datePicker/WdatePicker.js" ></script>
	
	<script type="text/javascript" src="static/js/ImportAnticipationNeat.js" ></script>
		

	<script type="text/javascript">
	
function getInfos(){	
		 
		var val = $('input[name="rd_Grame"]:checked').val(); 
		console.log(val);
		if(val==undefined){
			alert("请选择一个文件类型")
			return false;
		}
		var formData = new FormData();
			
		formData.append("val",val);			
			return formData;
		}
	</script>
</body>
</html>