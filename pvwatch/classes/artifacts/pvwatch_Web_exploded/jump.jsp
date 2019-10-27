<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link href="static/akehu/mainFile/h-ui/css/H-ui.min.css"  rel="stylesheet" type="text/css">
		<link href="static/akehu/mainFile/h-ui.admin/css/H-ui.admin.css"  rel="stylesheet" type="text/css">
		<link href="static/akehu/jsPlugin/icheck/icheck.css"  rel="stylesheet" type="text/css">
		<link href="static/akehu/font-awesome-4.7.0/css/font-awesome.min.css"  rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="static/akehu/css/productBaseInfo.css"/>
		<link href="static/akehu/css/bootstrap.min.css" rel="stylesheet">
		<link href="static/akehu1/Hui-iconfont/1.0.7/iconfont.css"  rel="stylesheet" type="text/css">
			<style>
			. label {
			width: 100px; 
			}
			
			
		#test{
		background:blue
	}		
	
</style>
	</head>
  
  <body>
    <!-- class="page-container" -->
   <!--  <div  style="padding:0px">
			<div class="row cl" > -->
				<div >
				<span>生产厂家 :</span>
				<select id="company" name="company" style="width:180px;height:30px;">
					<option value="YZJ">YZJ</option>
					<option value="lizhu">lizhu</option>
					<!--预留添加option  -->
				</select>	
							<!--  -->
				<button onclick="star()" class="btn btn-success radius" style="background-color:#1883D7;border:1px solid #1883D7;border:radius" type="button" >搜索</button>
				
				<!-- <input type="button"  id="test" value ="搜索"  onclick="star();"/>	 -->			
				</div>
	<div style="display:flex">			
			<!--嵌套select  -->
			<div style=" width:280px;display:flex">
			
			 	<div id="names0" style="width:66px;display:none">通用名称:</div>
			 	<div   id="n0"   style="display:none;width:200px;"   >							
						<select   style="width:210px;height:24px"   id="pro0" name="pro">	
															
						</select>
				</div>	
			</div>
			<div style="width: 140px;display:flex;">
				<div style="width:40px;display:none" id="s0" >数量 :</div>
				<input id="pro0s" style="display: none;width:100px;height: 24px;"/>		
			</div>
			<div style=" width:280px;display:flex;margin-left:20px;">	
				<div id="names1" style="width:66px;display:none">通用名称:</div>
				<div   id="n1"  style="display:none;width:200px;"  >							
						<select    style="width:210px;height:24px"  id="pro1" name="pro">	
							
																		
						</select>
				</div>
			</div>
			<div style=" width:140px;display:flex">
				<div  id="s1" style="width:40px;display:none;">数量 :</div>
				<input id="pro1s" style="width:100px;height: 24px;display:none"/>			
			</div>	
	</div>		
	
	<!--嵌套select  -->
	
	
	<div style="display:flex;margin-top:20px">	
			
			<div style=" width:280px;display:flex;">	
			<div id="names2" style="width:66px;display:none">通用名称:</div>	
				<div   id="n2"  style="display:none;width:200px;"  >							
						<select  style="width:210px;height:24px;"    id="pro2" name="pro">																		
						</select>
				</div>
			</div>
		
			<div style="width: 140px;display:flex;">	
				<div style="width: 40px;display:none;"  id="s2">数量 :</div>
				<input id="pro2s" style="width:100px;height: 24px;display:none"/>	
			</div>	
			
			<div style=" width:280px;display:flex;margin-left:20px;">	 	
			<div id="names3" style="width:66px;display:none">通用名称:</div>
			  	<div   id="n3"  style="display:none;width:204px" >							
						<select  style="width:210px;height:24px;"    id="pro3" name="pro">	
																	
						</select>
				</div>
			</div>
			
			<div style="width:140px;display:flex">	
				<div style="display:none;width:40px;"  id="s3" >数量 :</div>
				<input id="pro3s" style="display:none;width:100px"/>		
			</div>
		</div>	
			
			
			
			
		<div style="display:flex;margin-top:20px">			
			<!--嵌套select  -->
			<div style="width:280px;display:flex;">	
				<div id="names4" style="width:66px;display:none">通用名称:</div>
			  	<div   id="n4"   style="display:none;width:210px;" >							
						<select   style="width:210px;height:24px"    id="pro4" name="pro">	
																		
						</select>
				</div>
			</div>	
			<div style="width: 140px;display:flex;">	
				<div style="width: 40px;display: none;"  id="s4">数量 :</div><input id="pro4s" style="width:100px;display:none"/>	
			
			</div>
			
			
				<div style="width: 280px;display:flex;margin-left:20px">	
				<div id="names5" style="width:66px;display:none">通用名称:</div>
			  	<div   id="n5"   style="display:none;width:210px;" >							
						<select   style="width:210px;height:24px"    id="pro5" name="pro">	
																	
						</select>
				</div>
			</div>	
			<div style="width:140px;display:flex">	
				<div style="display:none;width: 40px;"  id="s5">数量 :</div><input id="pro5s" style="width:100px;display:none;"/>		
			</div>
		</div>		
		
		
		
		
		<div style="display:flex;margin-top:20px">			
			<!--嵌套select  -->
			<div style="width:280px;display:flex">	
			<div id="names6" style="width:66px;display:none">通用名称:</div>
		
			  	<div    id="n6"  style="display:none;width:210px;" >							
						<select   style="width:210px;height:24px"    id="pro6" name="pro">	
																		
						</select>
				</div>
			</div>
				<div style="width: 140px;display:flex;">	
				<div style="display:none;width: 40px;"  id="s6">数量 :</div><input id="pro6s" style="display: none;width: 100px;"/>		
				</div>
				
				
				
				
				
				<div style="width: 280px;display:flex;margin-left:20px">	
				<div id="names7" style="width:66px;display:none">通用名称:</div>
			  	<div    id="n7" style="display:none;width:210px;" >							
						<select    style="width: 210px;height:24px"  id="pro7" name="pro">	
																	
						</select>
				</div>
				</div>
				<div style="width:140px;display:flex">	
				<div style="display:none;width: 40px"  id="s7">数量 :</div><input id="pro7s" style="display:none;width: 100px"/>		
					</div>
		</div>		
			  	
			  	
			  	
			  	
		<div style="display:flex;margin-top:20px">			
			<!--嵌套select  -->
			<div style="width:280px;display:flex">	
				  	<div id="names8" style="width:66px;display:none">通用名称:</div>
			  	
			  	<div   id="n8" style="display:none;width:210px;" >							
						<select   style="width:210px;height:24px"   id="pro8" name="pro">	
																		
						</select>
				</div>
			</div>	
			<div style="width: 140px;display:flex;">	
			<div style="display:none;width:40px"  id="s8">数量 :</div><input id="pro8s" style="display:none;width:100px"/>		
			</div>
			
			
			
			
			
			<div style="width: 280px;display:flex;margin-left:20px">	
				<div id="names9"  style="width:66px;display:none">通用名称:</div>
			  	<div   style="display:none;width:210px;"  id="n9" >							
						<select    style="width:210px;height:24px"   id="pro9" name="pro">	
																		
						</select>
				</div>
			</div>	
			<div style="width:140px;display:flex">	
				<div style="display:none;width: 40px"  id="s9">数量 :</div><input id="pro9s" style="display:none;width:100px"/>		
			</div>
		</div>
		
		
		
		
		
		
		
		<div style="display:flex;margin-top:20px">			
			<!--嵌套select  -->
			<div style="width:280px;display:flex">		
				<div id="names10" style="width:66px;display:none">通用名称:</div>	
			  	<div   id="n10" style="display:none;width:210px;" >							
						<select   style="width:210px;height:24px"    id="pro10" name="pro">	
																		
						</select>
				</div>
			</div>	
			<div style="width: 140px;display:flex;">	
				<div style="display:none;width: 40px"  id="s10">数量 :</div><input id="pro10s" style="display:none;width:100px"/>			
			</div>
				<div style="width:280px;display:flex;margin-left:20px">		
			<div  id="names11" style="width:66px;display:none">通用名称:</div>
			  	<div   id="n11"  style="display:none;width:210px;" >							
						<select   style="width:210px;height:24px"    id="pro11" name="pro">	
																		
						</select>
				</div>
				</div>
			<div style="width:140px;display:flex">	
				<div style="display:none;width: 40px"  id="s11">数量 :</div><input id="pro11s" style="display:none;width:100px"/>		
			</div>
		</div>
			
			
			
			
			
			
			
			
		<div style="display:flex;margin-top:20px">			
			<!--嵌套select  -->
			<div style="width:280px;display:flex">		
			<div id="names12" style="width:66px;display:none">通用名称:</div>		
			  	<div   id="n12" style="display:none;width:210px;" >							
						<select   style="width:210px;height:24px"    id="pro12" name="pro">	
																		
						</select>
				</div>
			</div>	
			<div style="width: 140px;display:flex;">	
				<div style="display:none;width: 40px"  id="s12">数量 :</div><input id="pro12s" style="display:none;width:100px"/>			
			</div>	
			<div style="width:280px;display:flex;margin-left:20px">		
			<div id="names13" style="width:66px;display:none">通用名称:</div>
			  	<div   id="n13" style="display:none;width:210px;" >							
						<select   style="width:210px;height:24px"    id="pro13" name="pro">	
																		
						</select>
				</div>
			</div>	
			<div style="width:140px;display:flex">	
				<div style="display:none;width: 40px"  id="s13">数量 :</div><input id="pro13s" style="display:none;width:100px"/>			
			</div>
		</div>	
		
		
		
		
		
		
		
		<div style="display:flex;margin-top:20px">			
			<!--嵌套select  -->
			<div style="width:280px;display:flex">		
			<div id="names14" style="width:66px;display:none">通用名称:</div>	
				
			  	<div   id="n14"  style="display:none;width:210px;" >							
						<select   style="width:210px;height:24px"    id="pro14" name="pro">	
																	
						</select>
				</div>
				
				</div>
				
				<div style="width: 140px;display:flex;">		
				<div style="display:none;width: 40px"  id="s14">数量 :</div><input id="pro14s" style="display:none;width:100px"/>	
				</div>
				
		<div style="width:280px;display:flex;margin-left:20px">		
			<div id="names15" style="width:66px;display:none">通用名称:</div>		
			  	<div   id="n15" style="display:none;width:210px;" >							
						<select   style="width:210px;height:24px"    id="pro15" name="pro">	
																	
						</select>
				</div>
			</div>
			<div style="width:140px;display:flex">	
				<div style="display:none;width: 40px"  id="s15">数量 :</div><input id="pro15s" style="display:none;width:100px"/>	
			</div>
		</div>
		
		
		
		
		
		<div style="display:flex;margin-top:20px">			
			<!--嵌套select  -->
			<div style="width:280px;display:flex">		
			<div id="names16" style="width:66px;display:none">通用名称:</div>		
				
			  	<div   id="n16" style="display:none;width:210px;" >							
						<select   style="width:210px;height:24px"    id="pro16" name="pro">	
																		
						</select>
				</div>
			</div>
			
				<div style="width: 140px;display:flex;">		
				<div style="display:none;width: 40px"  id="s16">数量 :</div><input id="pro16s" style="display:none;width:100px"/>	
				</div>
				<div style="width:280px;display:flex;margin-left:20px">		
			<div id="names17" style="width:66px;display:none">通用名称:</div>		
			  	<div   id="n17" style="display:none;width:210px;" >							
						<select  style="width:210px;height:24px"     id="pro17" name="pro">	
																
						</select>
				</div>
				</div>
				<div style="width:140px;display:flex">	
				<div style="display:none;width: 40px"  id="s17">数量 :</div><input id="pro17s" style="display:none;width:100px"/>			
				</div>
		</div>
		
		
		
		
		
		
		
		
			<div style="display:flex;margin-top:20px">			
			<!--嵌套select  -->
			<div style="width:280px;display:flex">		
			<div id="names18" style="width:66px;display:none">通用名称:</div>		
			  	<div   id="n18" style="display:none;width:210px;" >	
			  							
						<select    style="width:210px;height:24px"   id="pro18" name="pro">	
																
						</select>
				</div>
				</div>
				<div style="width:140px;display:flex">	
				<div style="display:none;width: 40px"  id="s18">数量 :</div>
				
				<input id="pro18s" style="display:none;width:100px"/>	
				</div>	
				<div style="width:280px;display:flex;margin-left:20px">		
			<div id="names19" style="width:66px;display:none">通用名称:</div>
			  	<div   id="n19" style="display:none;width:210px;" >							
						<select  style="width:210px;height:24px;"    id="pro19" name="pro">	
																
						</select>
				</div>
				</div>
				<div style="width:140px;display:flex;">	
				<div style="display:none;width: 40px"  id="s19">数量 :</div>
				<input  id="pro19s" style="display:none;width:100px"/>		
					</div>		
		</div>	
					<input style="display:none;" value="0" id="num0"/>
					<input style="display:none;" value="0" id="num1"/>
					<input style="display:none;" value="0" id="num2"/>
					<input style="display:none;" value="0" id="num3"/>
					<input style="display:none;" value="0" id="num4"/>
					<input style="display:none;" value="0" id="num5"/>
					<input style="display:none;" value="0" id="num6"/>
					<input style="display:none;" value="0" id="num7"/>
					<input style="display:none;" value="0" id="num8"/>
					<input style="display:none;" value="0" id="num9"/>
					<input style="display:none;" value="0" id="num10"/>
					<input style="display:none;" value="0" id="num11"/>
					<input style="display:none;" value="0" id="num12"/>
					<input style="display:none;" value="0" id="num13"/>
					<input style="display:none;" value="0" id="num14"/>
					<input style="display:none;" value="0" id="num15"/>
					<input style="display:none;" value="0" id="num16"/>
					<input style="display:none;" value="0" id="num17"/>
					<input style="display:none;" value="0" id="num18"/>
					<input style="display:none;" value="0" id="num19"/>
		<script type="text/javascript" src="static/akehu/jsPlugin/jquery-1.11.0.min.js" ></script>
		<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js" ></script>
		<script type="text/javascript" src="static/akehu/mainFile/h-ui/js/H-ui.js" ></script>
		<script type="text/javascript" src="static/akehu/mainFile/h-ui.admin/js/H-ui.admin.js" ></script>
		<script type="text/javascript" src="static/akehu/jsPlugin/icheck/jquery.icheck.min.js" ></script>
		<script src="static/akehu/jsPlugin/bootstrap.min.js" type="text/javascript"></script>
		<script src="static/akehu/jsPlugin/datePicker/WdatePicker.js" type="text/javascript"></script>
		<script type="text/javascript">
			
		$(function(){
			
			 			  
			 	getSession();
			  function getSession(){
					var mahSelect="";
						$.ajax({
							url :  "../../system/getSession",
						    type:"post",
						    async:false,
						    success:function(data){
						    	if(data!=null&& data!=""){
						    		data = JSON.parse(data);
							      	if(data.companyInfo!=null && data.companyInfo!=""){
							      		sessionStorage.setItem("userInfo", JSON.stringify(data));
							    		var companyValue = data.companyInfo;
							    		companyValue = JSON.parse(companyValue);
							    		for(var o=0;o<companyValue.length;o++){
											mahSelect+="<option value="+companyValue[o].caseIDCode+">"+companyValue[o].companyFullName+"</option>";
							    		}
										
										$("#company").html(mahSelect);
										
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
		});
		function star(){
			
			for(var i=0;i<20;i++){
				$("#pro"+i+"s").val("");
				$("#names"+i).css("display","block");
				$("#s"+i).css("display","block");
				$("#pro"+i+"s").css("display","block");
				$("#n"+i).css("display","block");
			}
			
			
			
			
			var companyId=$("#company").val();
			comPro(companyId);		
		}
		  $(function(){		
			  $("#pro0").change(function(){						  
					var pro0=$("#pro0").val();
					for(var i =0;i<20;i++){
						if(i == 0){
							continue;
						}
						if($("#pro"+i).val() == pro0){
							$("#pro0").val("");
							return  alert("已有此产品,请重新选择");
						}
						
					}
					//alert(pro0);
					 $.ajax({
						 url:"getNumber",
						 type:'post',
						 data:{
							 "productid":pro0,
						 },
						 success:function(data){
							 data = JSON.parse(data);
							
							
							 if(data.data!=null && data.data!=""){
								$("#pro0s").val(data.data.number);
								$("#num0").val(data.data.numProId);
								 //alert($("#num0").val());
							 }
						 }
					 });
					 
					 
					
				});	
			  
				  $("#pro1").change(function(){	
					  var pro0=$("#pro1").val();
					 
					  for(var i =0;i<20;i++){
							if(i == 1){
								continue;
							}
							if($("#pro"+i).val() == pro0){
								$("#pro1").val("");
								return  alert("已有此产品,请重新选择");
							}
							
						}
						
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								
								 if(data.data!=null && data.data!=""){
									$("#pro1s").val(data.data.number);	
									$("#num1").val(data.data.numProId);
								 }
							 }
						 });
					});	
				  $("#pro2").change(function(){						  
						var pro0=$("#pro2").val();
						 for(var i =0;i<20;i++){
								if(i == 2){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro2").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro2s").val(data.data.number);	
									$("#num2").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro3").change(function(){						  
						var pro0=$("#pro3").val();
						 for(var i =0;i<20;i++){
								if(i == 3){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro3").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro3s").val(data.data.number);
									$("#num3").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro4").change(function(){						  
						var pro0=$("#pro4").val();
						 for(var i =0;i<20;i++){
								if(i == 4){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro4").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro4s").val(data.data.number);
									$("#num4").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro5").change(function(){						  
						var pro0=$("#pro5").val();
						 for(var i =0;i<20;i++){
								if(i == 5){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro5").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro5s").val(data.data.number);	
									$("#num5").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro6").change(function(){						  
						var pro0=$("#pro6").val();
						 for(var i =0;i<20;i++){
								if(i == 6){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro6").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro6s").val(data.data.number);	
									$("#num6").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro7").change(function(){						  
						var pro0=$("#pro7").val();
						 for(var i =0;i<20;i++){
								if(i == 7){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro7").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro7s").val(data.data.number);
									$("#num7").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro8").change(function(){						  
						var pro0=$("#pro8").val();
						 for(var i =0;i<20;i++){
								if(i == 8){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro8").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro8s").val(data.data.number);
									$("#num8").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro9").change(function(){						  
						var pro0=$("#pro9").val();
						 for(var i =0;i<20;i++){
								if(i == 9){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro9").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro9s").val(data.data.number);
									$("#num9").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro10").change(function(){						  
						var pro0=$("#pro10").val();
						 for(var i =0;i<20;i++){
								if(i == 10){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro10").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro10s").val(data.data.number);
									$("#num10").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro11").change(function(){						  
						var pro0=$("#pro11").val();
						 for(var i =0;i<20;i++){
								if(i == 11){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro11").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro11s").val(data.data.number);	
									$("#num11").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro12").change(function(){						  
						var pro0=$("#pro12").val();
						 for(var i =0;i<20;i++){
								if(i == 12){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro12").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro12s").val(data.data.number);	
									$("#num12").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro13").change(function(){						  
						var pro0=$("#pro13").val();
						 for(var i =0;i<20;i++){
								if(i == 13){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro13").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro13s").val(data.data.number);
									$("#num13").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro14").change(function(){						  
						var pro0=$("#pro14").val();
						 for(var i =0;i<20;i++){
								if(i == 14){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro14").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro14s").val(data.data.number);	
									$("#num14").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro15").change(function(){
					  for(var i =0;i<20;i++){
							if(i == 15){
								continue;
							}
							if($("#pro"+i).val() == pro0){
								$("#pro15").val("");
								return  alert("已有此产品,请重新选择");
							}
							
						}					  
						var pro0=$("#pro15").val();
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro15s").val(data.data.number);	
									$("#num15").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro16").change(function(){						  
						var pro0=$("#pro16").val();
						 for(var i =0;i<20;i++){
								if(i == 16){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro16").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro16s").val(data.data.number);	
									$("#num16").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro17").change(function(){						  
						var pro0=$("#pro17").val();
						 for(var i =0;i<20;i++){
								if(i == 17){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro17").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro17s").val(data.data.number);
									$("#num17").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro18").change(function(){						  
						var pro0=$("#pro18").val();
						 for(var i =0;i<20;i++){
								if(i == 18){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro18").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
								 if(data.data!=null && data.data!=""){
									$("#pro18s").val(data.data.number);	
									$("#num18").val(data.data.numProId);
								 }
							 }
						 });
					});		
				  $("#pro19").change(function(){						  
						var pro0=$("#pro19").val();
						 for(var i =0;i<20;i++){
								if(i == 19){
									continue;
								}
								if($("#pro"+i).val() == pro0){
									$("#pro19").val("");
									return  alert("已有此产品,请重新选择");
								}
								
							}
						alert(pro0);
						//alert(pro0);
						 $.ajax({
							 url:"getNumber",
							 type:'post',
							 data:{
								 "productid":pro0,
							 },
							 success:function(data){
								 data = JSON.parse(data);
									if(data.data!=null && data.data!=""){
										$("#pro19s").val(data.data.number);	
										$("#num19").val(data.data.numProId);
									}
											 
							 }
						 });
					});		
		});  
		
		
		//搜索当前企业的产品
		function comPro(companyId){
			
			 $.ajax({
				 url:"getProduct",
				 type:'post',
				 data:{
					 "companyId":companyId,
				 },
				 success:function(data){
					 data = JSON.parse(data);
					
					 if(data!=null && data!=""&&data!="null"){
						 var mahSelect="";
						 if(data.items.length>0){
							for(var i = 0;i<data.items.length;i++){
								 
								 mahSelect+='<option value="'+data.items[i][1]+'">'+data.items[i][0]+'</option>';
							}
								 mahSelect+='<option selected value=""></option>';
							
						 }else{		
							 
							 for(var i=0;i<20;i++){									
									$("#pro"+i).find("option").remove();
								}
						 }						 							
							 $("select[name=pro]").html(mahSelect);
							 
							
					 }
				 }
			 });
		}
		
		function getInfo(){	
			 
			
			
		var formData = new FormData();
		for(var i=0;i<20;i++){
			if($.trim($("#pro"+i+"s").val()) == "" && $.trim($("#pro"+i).val()) != "" && $.trim($("#pro"+i).val()) !=null){
				return	alert("不能为空");
			}
			if($.trim($("#pro"+i+"s").val()) != "" && $.trim($("#pro"+i).val()) == ""){
				return	alert("不能为空");
			}
			
			formData.append("pro"+i,$("#pro"+i).val());
			formData.append("productName"+i,$("#pro"+i).find("option:selected").text());
			formData.append("num"+i,$("#num"+i).val());
			formData.append("pro"+i+"s",$("#pro"+i+"s").val());
		}
		
		
		
		
			return formData;
		}
		</script>
  </body>
</html>
