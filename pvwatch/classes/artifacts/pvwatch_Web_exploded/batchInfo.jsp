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
		
	</head>
	<style>
	. label {
	width: 100px; 
	}
	
</style>
	<body>
		<div class="page-container">
			<div class="row cl">
				<div class="col-md-12 col-xs-12">
					<form class="form form-horizontal" id="batchForm">
							<div class="row">
									<div class="col-sm-3 col-xs-12 mt-5">
											<label class="form-label textl"><span class="c-red">*</span>生产厂家：</label>
											<span class="select-box">
													<input type="hidden" value=""  id="mahCodess">
													<select  class="select"  id="mahCode"  name="mahCode">
													<option  value="HL">111</option>
													<option  value="YZJ">YZJ</option>
													<!-- <option value="YZj">YZj测试1</option>
													
													<option value="lizhu">lizhu测试2</option> -->
													</select>
											</span>
									</div>
									
									<div class="col-sm-3 col-xs-12 mt-5">
											<label class="form-label textl"><span class="c-red">*</span>通用名称：</label>
											<select  class="input-text inputNewCss"  value=""  id="productName" name="productName">
											</select>
									</div>
									
									<div class="col-sm-3 col-xs-12 mt-5" >
											<label class="form-label textl"><span class="c-red">*</span>批准文号：</label>
											<select  class="input-text inputNewCss"    id="CFDACode" name="CFDACode">
													
											</select>
									</div>
									<div class="col-sm-3 col-xs-12 mt-5">
											<label class="form-label textl"><span class="c-red">*</span>批次号：</label>
											<input type="text" class="input-text inputNewCss"    id="batchNum" name="batchNum" />
											
									</div>
					
									<div class="col-sm-3 col-xs-12 mt-5">
											<label class="form-label textl"><span class="c-red">*</span>剂型：</label>
											<span class="select-box">
													<input type="hidden" value=""  id="dosageSelect">
													<select  class="select"  id="dosage"  name="dosage">
													<option value="1">测试1</option>
													<option value="2">测试2</option>
													</select>
											</span>
									</div>
						
									<div class="col-sm-3 col-xs-12 mt-5" >
											<label class="form-label textl"><span class="c-red">*</span>规格：</label>
											<select  class="input-text inputNewCss" value=""  id="strength"  name="strength">
											</select>
									</div>
						
									<div class="col-sm-3 col-xs-12 mt-5">
											<label class="form-label textl"><span class="c-red">*</span>生产日期：</label>
											<input type="text" onclick="WdatePicker({readOnly:true})" class="input-text  inputNewCss "  id="manufactureTime" name="manufactureTime">
									</div>
								
									<div class="col-sm-3 col-xs-12 mt-5">
											<label class="form-label textl"><span class="c-red">*</span>数量：</label>
											<input type="text" class="input-text inputNewCss" value="" id="number" name="number">
									</div>
									
									<div class="col-sm-3 col-xs-12 mt-5">
											<label class="form-label textl"><span class="c-red">*</span>包装单位：</label>
											<input type="text" class="input-text inputNewCss" value="" id="packaging" name="packaging">
									</div>
					
					
									<div style="display:none" class="col-sm-3 col-xs-12 mt-5">
											<label class="form-label textl"><span class="c-red">*</span>生产厂家：</label>
											<input type="text" class="input-text inputNewCss" value="" id="manufacturer" name="manufacturer">
									</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<script type="text/javascript" src="static/akehu/jsPlugin/jquery-1.11.0.min.js" ></script>
		<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js" ></script>
		<script type="text/javascript" src="static/akehu/jsPlugin/icheck/jquery.icheck.min.js" ></script>
		<script src="static/akehu/jsPlugin/bootstrap.min.js" type="text/javascript"></script>
		<script src="static/akehu/jsPlugin/datePicker/WdatePicker.js" type="text/javascript"></script>
		<script type="text/javascript">
	
			$(function(){		


				
				//切换通用类型select选择框选择批准文号				
				$("#productName").change(function(){	
					var  tName =$("#productName").val();
					selPc(tName);
				});
				//切换生产厂家select选择框选择通用类型		
				$("#mahCode").change(function(){	
					
					var  comPany =$("#mahCode").val();
					tyName(comPany);
				});	
				
				var as ="HL";
				tyName(as);
				
				/* laydate.render({elem: '#manufactureTime'}); */
				  
					//  getSession();   
				//>>>>>>>>.获取session	
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
											mahSelect+="<option value='+companyValue[o].CaseIdCode+'>companyValue[o].companyFullName</option>";
							    		}
										
										$("#mahCode").html(mahSelect);
							    	}
							      		tyName(companyValue[o].CaseIdCode);
							      		
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
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
							//获取通用名称
						function tyName(obj){
								
								var option="";
								$.ajax({
									url:"tName",
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
									 	$("select[name=productName]").html(option);
									 	
									 		selPc(data.items[0][0]);
									}else{
										$("#productName").val("");
										$("#productName").find("option").remove();
									}
									
									}	
								}
									
								});
						}
							//查询批准文号
							function selPc(obj){
								var option ="";
								
								$.ajax({
									url:"selPc",
									type: 'post',
									data:{
										"obj":obj,
									},
								success:function(data){
									//console.log(data);
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
							//查剂型 数量
							 function selJx(obj){
								 var option ="";
								 var options="";
									
									$.ajax({
										url:"selJx",
										type: 'post',
										data:{
											"obj":obj,
										},
									success:function(data){
										if(data!=null && data!=""&&data!="null"){
										data = JSON.parse(data);
										//console.log(data.items[0]);
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
			});
						
			function getInfo(){
				
				
					 if($.trim($("#batchNum").val()) == ""){
						return	alert("不能为空");
					 }
					 if($.trim($("#packaging").val())== "" ){
							return	alert("不能为空");
						 }
					 if($.trim($("#manufactureTime").val())== "" ){
							return	alert("不能为空");
						 }
					 if( $.trim($("#number").val()) == "" ){
							return	alert("不能为空");
					 }  	
				var formData = new FormData();
				formData.append("batchNum",$("#batchNum").val());			
				formData.append("productId",$("#productName").val());
				formData.append("productName",$("#productName").find("option:selected").text());
				formData.append("CFDACode",$("#CFDACode").val());
				formData.append("dosage",$("#dosage").val());
				formData.append("strength",$("#strength").val());			
				formData.append("manufactureTime",$("#manufactureTime").val());			
				formData.append("number",$("#number").val());					
				formData.append("packaging",$("#packaging").val());
				formData.append("manufacturer",$("#manufacturer").val());
				formData.append("mahCode",$("#mahCode").val());
				console.log(formData);
				return formData;
			}
			
		</script>
	</body>
</html>
