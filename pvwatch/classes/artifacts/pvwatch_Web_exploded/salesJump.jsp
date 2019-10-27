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
 	<div class="page-container" style="padding: 10px 10px 50px 10px;background: #FFFFFF;">
			<!-- <div class="text-l pd-20 bg-1 bk-gray radius">
					企业：<input type="text"  type="text" style="width:200px;" class="input-text" id="evBatch-code"  />&nbsp;
					通用名称：<select   style="width:200px;" class="input-text" id="genericFunction" ></select>&nbsp;
					规格：<input  type="text" style="width:100px;" class="input-text" id="strength" />&nbsp;
					开始时间：<input  type="text" style="width:100px;" class="input-text" id="starTime" />&nbsp;
					结束时间：<input  type="text" style="width:100px;" class="input-text" id="endTime" />&nbsp;
					<button onclick="conditions()" class="btn btn-success radius" type="button" style="float:right;"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
					<input type="button" style="margin-left:70px" onclick="conditions();" class="btn btn-primary " value="查询"  />
			</div> -->
		<div class="cl mt-20"> 
			<!-- 	<span class="l">
					<a href="javascript:void(0);" onclick="addCharacter();" class="btn btn-primary "><i class="Hui-iconfont">&#xe600;</i> 录入</a>
				</span>	 -->
			</div>
	<div class="cl mt-15"></div>
	<div class="mt-15" id="allInfo">
	</div>
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
		

	<script type="text/javascript">
	
	
	$(document).ready(function() {
	
			
		getAllUser();
		
		
		
	});
	$(function(){
		laydate.render({elem: '#manufactureTime'});
		//切换生产厂家select选择框选择通用类型		
		$("#evBatch-code").change(function(){				
			var  comPany =$("#evBatch-code").val();
			tyName(comPany);
		});	
	});		

	
		function getAllUser(){
			var sli = "";
			sli +='<table class="table table-border table-bordered table-bg table-hover table-sort">';
			sli +='<thead><tr class="text-c">';
			sli +='<th style="width:300px;height:25px">通用名称+规格+批准文号</th>';
			sli +='<th style="width:100px">销售</th>';
			sli +='<th style="width:50px">销售单位</th>';
			sli +='<th style="width:70px">售出时间</th>';
			sli +='<th style="width:50px">省</th>';		
			sli +='<th style="width:50px">市</th>';	
			sli +='<th style="width:50px">区</th>';	
		/* 	sli +='<th width="100">操作</th>'; */
			sli +='	</tr></thead>';
			sli +='<tbody id="viewReport">';
		
					sli +='<tr  class="text-c">';
					sli +='<td><select  id="tgp0" style="width:300px;height:25px"></selected></td>';
					sli +='<td><input   id="numbers0"  style="width:100px;height:25px"/></td>';
					sli +='<td><input   id="danwei0" style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime0" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select  id="sheng0"  style="width:70px;height:25px"><select></td>';
					sli +='<td><select  id="shi0"  style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select   id="qu0" style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select id="tgp1" style="width:300px;height:25px"></selected></td>';
					sli +='<td><input  id="numbers1" style="width:100px;height:25px"/></td>';
					sli +='<td><input  id="danwei1"  style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime1" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select  id="sheng1" style="width:70px;height:25px"><select></td>';
					sli +='<td><select  id="shi1" style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select  id="qu1" style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select id="tgp2" style="width:300px;height:25px"></selected></td>';
					sli +='<td><input id="numbers2" style="width:100px;height:25px"/></td>';
					sli +='<td><input id="danwei2"  style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime2" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select  id="sheng2" style="width:70px;height:25px"><select></td>';
					sli +='<td><select  id="shi2" style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select  id="qu2" style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select id="tgp3" style="width:300px;height:25px"></selected></td>';
					sli +='<td><input id="numbers3"  style="width:100px;height:25px"/></td>';
					sli +='<td><input id="danwei3"  style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime3" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select  id="sheng3" style="width:70px;height:25px"><select></td>';
					sli +='<td><select   id="shi3" style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select  id="qu3"  style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select id="tgp4" style="width:300px;height:25px"></selected></td>';
					sli +='<td><input id="numbers4" style="width:100px;height:25px"/></td>';
					sli +='<td><input  id="danwei4"   style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime4" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select  id="sheng4" style="width:70px;height:25px"><select></td>';
					sli +='<td><select  id="shi4" style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select  id="qu4"  style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select id="tgp5" style="width:300px;height:25px"></selected></td>';
					sli +='<td><input  id="numbers5" style="width:100px;height:25px"/></td>';
					sli +='<td><input  id="danwei5"  style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime5" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select  id="sheng5"  style="width:70px;height:25px"><select></td>';
					sli +='<td><select  id="shi5" style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select  id="qu5" style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select  id="tgp6"  style="width:300px;height:25px"></selected></td>';
					sli +='<td><input  id="numbers6" style="width:100px;height:25px"/></td>';
					sli +='<td><input  id="danwei6" style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime6" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select id="sheng6" style="width:70px;height:25px"><select></td>';
					sli +='<td><select  id="shi6"   style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select id="qu6" style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select  id="tgp7" style="width:300px;height:25px"></selected></td>';
					sli +='<td><input  id="numbers7"  style="width:100px;height:25px"/></td>';
					sli +='<td><input id="danwei7" style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime7" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select id="sheng7" style="width:70px;height:25px"><select></td>';
					sli +='<td><select  id="shi7"  style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select id="qu7" style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select id="tgp8"  style="width:300px;height:25px"></selected></td>';
					sli +='<td><input id="numbers8" style="width:100px;height:25px"/></td>';
					sli +='<td><input id="danwei8"  style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime8" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select   id="sheng8" style="width:70px;height:25px"><select></td>';
					sli +='<td><select   id="shi7"   style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select id="qu7"  style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select   id="tgp9"  style="width:300px;height:25px"></selected></td>';
					sli +='<td><input  id="numbers9"  style="width:100px;height:25px"/></td>';
					sli +='<td><input id="danwei9"   style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime9" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select  id="sheng9"  style="width:70px;height:25px"><select></td>';
					sli +='<td><select  id="shi9"  style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select id="qu9" style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select   id="tgp10"  style="width:300px;height:25px"></selected></td>';
					sli +='<td><input  id="numbers10" style="width:100px;height:25px"/></td>';
					sli +='<td><input  id="danwei10"  style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime10" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select  id="sheng10"  style="width:70px;height:25px"><select></td>';
					sli +='<td><select  id="shi10" style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select  id="qu10"  style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select  id="tgp11"   style="width:300px;height:25px"></selected></td>';
					sli +='<td><input  id="numbers11"  style="width:100px;height:25px"/></td>';
					sli +='<td><input   id="danwei11"  style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime11" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select  id="sheng11"   style="width:70px;height:25px"><select></td>';
					sli +='<td><select  id="shi11" style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select    id="qu11" style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select  id="tgp12"    style="width:300px;height:25px"></selected></td>';
					sli +='<td><input   id="numbers12"  style="width:100px;height:25px"/></td>';
					sli +='<td><input   id="danwei12"  style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime12" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select   id="sheng12"   style="width:70px;height:25px"><select></td>';
					sli +='<td><select  id="shi12"  style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select   id="qu12"  style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select  id="tgp13"   style="width:300px;height:25px"></selected></td>';
					sli +='<td><input   id="numbers13"   style="width:100px;height:25px"/></td>';
					sli +='<td><input   id="danwei13"   style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime13"  onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select   id="sheng13"  style="width:70px;height:25px"><select></td>';
					sli +='<td><select  id="shi13"   style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select   id="qu13" style="width:70px;height:25px"><select></td>';
					sli +='</tr>';
					sli +='<tr  class="text-c">';
					sli +='<td><select id="tgp14" style="width:300px;height:25px"></selected></td>';
					sli +='<td><input  id="numbers14"  style="width:100px;height:25px"/></td>';
					sli +='<td><input   id="danwei14"   style="width:50px;height:25px"/></td>';
					sli +='<td><input   id="outtime14" onclick="WdatePicker({readOnly:true})"; style="width:70px;height:25px"/></td>';
					sli +='<td><select   id="sheng14"  style="width:70px;height:25px"><select></td>';
					sli +='<td><select   id="shi14"  style="width:70px;height:25px"><select></td>'; 
					sli +='<td><select  id="qu14"  style="width:70px;height:25px"><select></td>';
					sli +='</tr>';		
					sli +='</tbody>';
					sli +='</table>';
					
					
			 	document.getElementById("allInfo").innerHTML = sli; 
			 		 getTgp();
			 	
			}		
				$(function(){
					
					 $("#shi0").change(function(){
						 qu0();
					 });
					 $("#shi1").change(function(){
						 qu1();
					 });
					 $("#shi2").change(function(){
						 qu2();
					 });
					 $("#shi3").change(function(){
						 qu3();
					 });
					 $("#shi4").change(function(){
						 qu4();
					 });
					 $("#shi5").change(function(){
						 qu5();
					 });
					 $("#shi6").change(function(){
						 qu6();
					 });
					 $("#shi7").change(function(){
						 qu7();
					 });
					 $("#shi8").change(function(){
						 qu8();
					 });
					 $("#shi9").change(function(){
						 qu9();
					 });
					 $("#shi10").change(function(){
						 qu10();
					 });
					 $("#shi11").change(function(){
						 qu11();
					 });
					 $("#shi12").change(function(){
						 qu12();
					 });
					 $("#shi13").change(function(){
						 qu13();
					 });
					 $("#shi14").change(function(){
						 qu14();
					 });
					
					
					
						 $("#sheng0").change(function(){	
							var shen=$("#sheng0").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										//
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi0").html(op);
											qu0();
										}else{
											 $("#shi0").val("");
											 $("#qu0").val("");
										}
									}
								});					
						});	
						
						 
						 $("#sheng1").change(function(){	
							 	var shen=$("#sheng1").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										//
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi1").html(op);
											qu1();
										}else{
											 $("#shi1").val("");
											 $("#qu1").val("");
										}
									}
								});					
						});		
						 $("#sheng2").change(function(){	
							 	var shen=$("#sheng2").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										//
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi2").html(op);
											qu2();
										}else{
											 $("#qu2").val("");
											 $("#shi2").val("");
										}
									}
								});					
						});		
						 $("#sheng3").change(function(){	
							 	var shen=$("#sheng3").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										//
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi3").html(op);
											qu3();
										}else{
											 $("#qu3").val("");
											 $("#shi3").val("");
										}
									}
								});						
						});		
						
						 $("#sheng4").change(function(){	
							 	var shen=$("#sheng4").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi4").html(op);
											qu4();
										}else{
											 $("#qu4").val("");
											 $("#shi4").val("");
										}
									}
								});						
						});		
						 $("#sheng5").change(function(){	
							 	var shen=$("#sheng5").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi5").html(op);
											qu5();
										}else{
											 $("#qu5").val("");
											 $("#shi5").val("");
										}
									}
								});					
						});		
						 $("#sheng6").change(function(){	
							 	var shen=$("#sheng6").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi6").html(op);
											qu6();
										}else{
											 $("#qu6").val("");
											 $("#shi6").val("");
										}
									}
								});					
						});		
						 $("#sheng7").change(function(){	
							 	var shen=$("#sheng7").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi7").html(op);
											qu7();
										}else{
											 $("#qu7").val("");
											 $("#shi7").val("");
										}
									}
								});				
						});		
						 $("#sheng8").change(function(){	
							 	var shen=$("#sheng8").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi8").html(op);
											qu8();
										}else{
											 $("#qu8").val("");
											 $("#shi8").val("");
										}
									}
								});					
						});		
						 $("#sheng9").change(function(){	
							 	var shen=$("#sheng9").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi9").html(op);
											qu9();
										}else{
											 $("#qu9").val("");
											 $("#shi9").val("");
										}
									}
								});					
						});		
						 $("#sheng10").change(function(){	
							 	var shen=$("#sheng10").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi10").html(op);
											qu10();
										}else{
											 $("#qu10").val("");
											 $("#shi10").val("");
										}
									}
								});				
						});		
						 $("#sheng11").change(function(){	
							 	var shen=$("#sheng11").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi11").html(op);
											qu11();
										}else{
											 $("#qu11").val("");
											 $("#shi11").val("");
										}
									}
								});					
						});		
						 $("#sheng12").change(function(){	
							 	var shen=$("#sheng12").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi12").html(op);
											qu12();
										}else{
											 $("#qu12").val("");
											 $("#shi12").val("");
										}
									}
								});					
						});		
						 $("#sheng13").change(function(){	
							 	var shen=$("#sheng13").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi13").html(op);
											qu13();
										}else{
											 $("#qu13").val("");
											 $("#shi13").val("");
										}
									}
								});						
						});	
						 $("#sheng14").change(function(){	
							 	var shen=$("#sheng14").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
												
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					
											}
											$("#shi14").html(op);
											qu14();
										}else{
											 $("#qu14").val("");
											 $("#shi14").val("");
										}
									}
								});				
						});	
						 
						 $("#shi0").change(function(){
								var shen=$("#shi0").val();
							 	$.ajax({
									url:"selShi",
									type:'post',
									data:{
										obj:shen
									},
									success:function(data){
										data = JSON.parse(data);
										
										if(data.items.length>0){
											var op="";
											for(var i=0;i<data.items.length;i++){
			
													op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';			
											}
											$("#qu0").html(op);
											qu0();
										}else{
											 $("#qu0").val("");
										}
									}
								});	
						 });
			
			});
	///===》
	 	
			
		
				
 		function getTgp(){
		$.ajax({
			url:"selProduct",
			type:'post',
			
			success:function(data){
				data = JSON.parse(data);
				
				var xx=data.items;
				var op="";
				op+='<option secletd></option>';
				for(var i=0;i<xx.length;i++){
					/* var aa=xx[i][0]; */
					op+='<option value="'+xx[i][0]+'">'+xx[i][1]+","+xx[i][2]+","+xx[i][3]+'</option>';
					
				}
				for(var j=0;j<15;j++){
					$("#tgp"+j).html(op);
				}
				
			
			}
		});
				getSheng();
		
	}
	
		function getSheng(){
			$.ajax({
				url:"getSheng",
				type:'post',
				success:function(data){
				data = JSON.parse(data);
					
					var op="";
					op+='<option selected ></option>';
					for(var i=0;i<data.items.length;i++){
						op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
					}
					
					for(var j=0;j<15;j++){
						$("#sheng"+j).html(op);
					}
					 
				}
				
			});
		}
		 
				//分页新增批次
			function addCharactersss(){ 
		/* 	if(obj==-1){ */
			 
				layer.open({
					area: ['800px','350px'],
					title:"录入",
					type: 2,
					skin: 'layui-layer-rim', //加上边框
					content:'salesJump',
					btn:["确定","取消"],
					yes:function(index,layero){
						/* if($("#userName").val() == "" && $("#userSex").val()=="" && $("#userAdd").val()== "" ) {
							lasalesJumpyer.alert("请补全信息");
						}else { */
							
							var formData1=$(layero).find("iframe")[0].contentWindow.getInfo();
						
						
							$.ajax({
								url: "saveOne",
								type: 'post',
								data:formData1,
								processData:false,
				                contentType: false,
								success: function(data){
									if(data!=null && data!=""&&data!="null"){
									data = JSON.parse(data);
									if(data.result == 'true'){
										layer.alert('新增成功');
										layer.close(index);
										getAllUser();
									}
									else{
										layer.alert(新增失败);
									}
									}
								}
							});
						/* } */
						
						
					}
				});
			
				};
	///===》	
	
			//获取getSession
			 function getSession(obj){
					var mahSelect="";
					//alert(obj);
						$.ajax({	
							url :  "../../system/getSession",
						    type:"post",
						    async:false,
						    success:function(data){
			
						    	if(data!=null&& data!=""){
						    		data = JSON.parse(data);
						    		alert(data);
							      	if(data.companyInfo!=null && data.companyInfo!=""){
							      		sessionStorage.setItem("userInfo", JSON.stringify(data));
							    		var companyValue = data.companyInfo;
							    		companyValue = JSON.parse(companyValue);
							    		for(var o=0;o<companyValue.length;o++){
							    			alert(o);
							    		
							    				mahSelect+="<option     value='+companyValue[o].CaseIdCode+'>companyValue[o].companyFullName</option>";
							    			
							    				
							    			
											
							    		}
										
										$("#mahCode").html(mahSelect);
							    	}
							      		
							      		
						    	}else{
						    		parent.layer.alert("获取用户信息失败,请重新登录！" , {
										icon:2
									},function(){
										window.parent.location.href="/system/login?bs=1";
										  parent.layer.closeAll();
									});
						    	}
						    }
						});
					}; 
					
					//获取通用名称
					function tyName(obj){		
							var option="";
							$.ajax({
								url:"salesName",
								type: 'post',
								data:{
									"obj":obj,
								},
							success:function(data){
								if(data!=null && data!=""&&data!="null"){
								
								data = JSON.parse(data);
								
								if(data.items.length>0){
								 	for(var i=0;i<data.items.length;i++){			 	
								 	 option += '<option value="'+data.items[i][1]+'">'+data.items[i][0]+'</option>';
								 	
								 	}
								 	$("#genericFunction").html(option);
								}
								}
									
							}
								
							});
					}
			//获取批准文号
			function selPc(obj){
				if(obj == -1){
					obj =$("#productName").val();
				}
								var option ="";
								//alert(obj);
								$.ajax({
									url:"selPc",
									type: 'post',
									data:{
										"obj":obj,
									},
								success:function(data){
									if(data!=null && data!=""&&data!="null"){
									
									data = JSON.parse(data);
									if(data.items.length>0){
									 	for(var i=0;i<data.items.length;i++){			 	
									 	option += '<option value="'+data.items[i]+'">'+data.items[i]+'</option>';
									 	
									 	}
									 	$("select[name=CFDACode]").html(option);
									 	
									 		selJx(data.items[0]);
									}
									}	
								}
									
								});					
							}
			
			function qu0(){
			 	var shen=$("#shi0").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu0").html(op);
						}else{
							 $("#qu0").val("");
							 $("#qu0").val("");
						}
					}
				});	
			 }
			function qu1(){
			 	var shen=$("#shi1").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu1").html(op);
						}else{
							 $("#qu1").val("");
							 $("#qu1").val("");
						}
					}
				});	
			 }
			function qu2(){
			 	var shen=$("#shi2").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu2").html(op);
						}else{
							 $("#qu2").val("");
							 $("#qu2").val("");
						}
					}
				});	
			 }
			function qu3(){
			 	var shen=$("#shi3").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu3").html(op);
						}else{
							 $("#qu3").val("");
							 $("#qu3").val("");
						}
					}
				});	
			 }
			function qu4(){
			 	var shen=$("#shi4").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu4").html(op);
						}else{
							 $("#qu4").val("");
							 $("#qu4").val("");
						}
					}
				});	
			 }
			function qu5(){
			 	var shen=$("#shi5").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu5").html(op);
						}else{
							 $("#qu5").val("");
							 $("#qu5").val("");
						}
					}
				});	
			 }
			function qu6(){
			 	var shen=$("#shi6").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu6").html(op);
						}else{
							 $("#qu6").val("");
							 $("#qu6").val("");
						}
					}
				});	
			 }
			function qu7(){
			 	var shen=$("#shi7").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu7").html(op);
						}else{
							 $("#qu7").val("");
							 $("#qu7").val("");
						}
					}
				});	
			 }
			function qu8(){
			 	var shen=$("#shi8").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu8").html(op);
						}else{
							 $("#qu8").val("");
							 $("#qu8").val("");
						}
					}
				});	
			 }
			function qu9(){
			 	var shen=$("#shi9").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu9").html(op);
						}else{
							 $("#qu9").val("");
							 $("#qu9").val("");
						}
					}
				});	
			 }
			function qu10(){
			 	var shen=$("#shi10").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu10").html(op);
						}else{
							 $("#qu10").val("");
							 $("#qu10").val("");
						}
					}
				});	
			 }
			function qu11(){
			 	var shen=$("#shi11").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu11").html(op);
						}else{
							 $("#qu11").val("");
							 $("#qu11").val("");
						}
					}
				});	
			 }
			function qu12(){
			 	var shen=$("#shi12").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu12").html(op);
						}else{
							 $("#qu12").val("");
							 $("#qu12").val("");
						}
					}
				});	
			 }
			function qu13(){
			 	var shen=$("#shi13").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu13").html(op);
						}else{
							 $("#qu13").val("");
							 $("#qu13").val("");
						}
					}
				});	
			 }
			function qu14(){
			 	var shen=$("#shi14").val();
			 	$.ajax({
					url:"selShi",
					type:'post',
					data:{
						obj:shen
					},
					success:function(data){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							var op="";
							for(var i=0;i<data.items.length;i++){
								
									op+='<option value="'+data.items[i][1]+'">'+data.items[i][2]+'</option>';
	
							}
							$("#qu14").html(op);
						}else{
							 $("#qu14").val("");
							 $("#qu14").val("");
						}
					}
				});	
			 }
			
			
			function getInfo(){	
				
			
				var formData = new FormData();
			
				for(var i=0;i<15;i++){
					if($("#numbers"+i).val()=="" && $("#tgp"+i).val()!=""){
						return	alert("销售不能为空");
					}
					if($("#danwei"+i).val()=="" && $("#tgp"+i).val()!=""){
						return	alert("销售单位不能为空");
					}
					if($("#outtime"+i).val()=="" && $("#tgp"+i).val()!=""){
						return	alert("时间不能为空");
					}
						
					
					formData.append("productId"+i,$("#tgp"+i).val());				
					formData.append("name"+i,$("#tgp"+i).find("option:selected").text());
					formData.append("numbers"+i,$("#numbers"+i).val());					
					formData.append("danwei"+i,$("#danwei"+i).val());
					formData.append("outtime"+i,$("#outtime"+i).val());
					
					
				}
				var adress="";
				adress+=$("#sheng0").find("option:selected").text();
				adress+=$("#shi0").find("option:selected").text();
				adress+=$("#qu0").find("option:selected").text();					
				formData.append("adress0",adress);
				var adress1="";
				adress1+=$("#sheng1").find("option:selected").text();
				adress1+=$("#shi1").find("option:selected").text();
				adress1+=$("#qu1").find("option:selected").text();					
				formData.append("adress1",adress1);
				var adress2="";
				adress2+=$("#sheng2").find("option:selected").text();
				adress2+=$("#shi2").find("option:selected").text();
				adress2+=$("#qu2").find("option:selected").text();					
				formData.append("adress2",adress2);
				var adress3="";
				adress3+=$("#sheng3").find("option:selected").text();
				adress3+=$("#shi3").find("option:selected").text();
				adress3+=$("#qu3").find("option:selected").text();					
				formData.append("adress3",adress3);
				var adress4="";
				adress4+=$("#sheng4").find("option:selected").text();
				adress4+=$("#shi4").find("option:selected").text();
				adress4+=$("#qu4").find("option:selected").text();					
				formData.append("adress4",adress4);
				var adress5="";
				adress5+=$("#sheng5").find("option:selected").text();
				adress5+=$("#shi5").find("option:selected").text();
				adress5+=$("#qu5").find("option:selected").text();					
				formData.append("adress5",adress5);
				var adress6="";
				adress6+=$("#sheng6").find("option:selected").text();
				adress6+=$("#shi6").find("option:selected").text();
				adress6+=$("#qu6").find("option:selected").text();					
				formData.append("adress6",adress6);
				var adress7="";
				adress7+=$("#sheng7").find("option:selected").text();
				adress7+=$("#shi7").find("option:selected").text();
				adress7+=$("#qu7").find("option:selected").text();					
				formData.append("adress7",adress7);
				var adress8="";
				adress8+=$("#sheng8").find("option:selected").text();
				adress8+=$("#shi8").find("option:selected").text();
				adress8+=$("#qu8").find("option:selected").text();					
				formData.append("adress8",adress8);
				var adress9="";
				adress9+=$("#sheng9").find("option:selected").text();
				adress9+=$("#shi9").find("option:selected").text();
				adress9+=$("#qu9").find("option:selected").text();					
				formData.append("adress9",adress9);
				var adress10="";
				adress10+=$("#sheng10").find("option:selected").text();
				adress10+=$("#shi10").find("option:selected").text();
				adress10+=$("#qu10").find("option:selected").text();					
				formData.append("adress10",adress10);
				var adress11="";
				adress11+=$("#sheng11").find("option:selected").text();
				adress11+=$("#shi11").find("option:selected").text();
				adress11+=$("#qu11").find("option:selected").text();					
				formData.append("adress11",adress11);
				var adress12="";
				adress12+=$("#sheng12").find("option:selected").text();
				adress12+=$("#shi12").find("option:selected").text();
				adress12+=$("#qu12").find("option:selected").text();					
				formData.append("adress12",adress12);
				var adress13="";
				adress13+=$("#sheng13").find("option:selected").text();
				adress13+=$("#shi13").find("option:selected").text();
				adress13+=$("#qu13").find("option:selected").text();					
				formData.append("adress13",adress13);
				var adress14="";
				adress14+=$("#sheng14").find("option:selected").text();
				adress14+=$("#shi14").find("option:selected").text();
				adress14+=$("#qu14").find("option:selected").text();					
				formData.append("adress14",adress14);
					
					return formData; 
				}
		
			
			//查剂型规格
			 function selJx(obj){
				if(obj == -1){
					obj=$("#CFDACode").val();
				}
				 var option ="";
				 var options="";
					//alert(obj);
					$.ajax({
						url:"selJx",
						type: 'post',
						data:{
							"obj":obj,
						},
					success:function(data){
						if(data!=null && data!=""&&data!="null"){
						data = JSON.parse(data);
						
						if(data.items.length>0){
							for(var i=0;i<data.items.length;i++){	 												
									option += '<option value="'+data.items[i][0]+'">'+data.items[i][0]+'</option>';
							 		options += '<option value="'+data.items[i][1]+'">'+data.items[i][1]+'</option>';										 		
							}
						 	$("select[name=dosage]").html(option);
						 	$("select[name=strength]").html(options);							 	
						}
						}
							
					}
						
					});	
			}	
	</script>
</body>
</html>