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
			<div class="text-l pd-20 bg-1 bk-gray radius">
					企业dd：<select type="text"  type="text" style="width:200px;" class="input-text" id="evBatch-code"  >
								<option ></option>
								<option  value="lizhu">lizhu</option>
								<option value="YZJ">YZJ</option>
					</select>&nbsp;
					通用名称：<select   style="width:200px;" class="input-text" id="genericFunction" >
								
					</select>&nbsp;
					规格：<input  type="text" style="width:100px;" class="input-text" id="strength" />&nbsp;
					开始时间：<input  type="text" style="width:100px;" class="input-text" id="starTime" />&nbsp;
					结束时间：<input  type="text" style="width:100px;" class="input-text" id="endTime" />&nbsp;
					<button onclick="conditions()" class="btn btn-success radius" type="button" style="float:right;"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
					<!-- <input type="button" style="margin-left:70px" onclick="conditions();" class="btn btn-primary " value="查询"  /> -->
			</div>
		<div class="cl mt-20"> 
				<span class="l">
					<a href="javascript:void(0);" onclick="addCharacter();" class="btn btn-primary "><i class="Hui-iconfont">&#xe600;</i> 录入</a>
				</span>	
			</div>
	<div class="cl mt-15"></div>
	<div class="mt-15" id="allInfo">
	</div>
	</div>
	<script type="text/javascript"
		src="static/akehu/js/tool/jquery-1.11.0.js" ></script>
	<script src="static/akehu/jsPlugin/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js" ></script>
	
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
		/* getSession();
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
								
								$("#evBatch-code").html(mahSelect);
									tyName($("#evBatch-code").val());
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
			};   */
			
			
		getAllUser();
		laydate.render({elem: '#starTime'});
		laydate.render({elem: '#endTime'});
		
	});
	$(function(){
		laydate.render({elem: '#manufactureTime'});
		//切换生产厂家select选择框选择通用类型		
		$("#evBatch-code").change(function(){				
			var  comPany =$("#evBatch-code").val();
			tyName(comPany);
		});	
	});		
	function conditions(){
		
		var startDate =$("#starTime").val();
		var endDate=$("#endTime").val();
		
		var startNum = parseInt(startDate.replace(/-/g,''),10);
		var endNum = parseInt(endDate.replace(/-/g,''),10);
		if(startNum>endNum){
			alert("结束时间不能在开始时间之前！");
			return false;
			}
		
		
		
		var sli = "";
		sli +='<table class="table table-border table-bordered table-bg table-hover table-sort">';
		sli +='<thead><tr class="text-c">';
		sli +='<th style="height: 35px;width: 154px;">通用名称</th>';
		sli +='<th style="height: 35px; width: 180px;">规格</th>';
		sli +='<th style="height: 35px; width: 136px;">批准文号</th>';
		sli +='<th style="height: 35px; width: 36px;">销量</th>';
		sli +='<th style="height: 35px; width: 59px;">销售单位</th>';
		sli +='<th style="height: 35px; width: 205px;">地区</th>';
		sli +='<th >售出日期</th>';
	/* 	sli +='<th>生产厂家</th>'; */
	/* 	sli +='<th width="100">操作</th>'; */
		sli +='	</tr></thead>';
		sli +='<tbody id="viewReport">';
		$.ajax({
			url:"selectSales",	
			type:"post",
			data:{
				qiyeId:$("#evBatch-code").val(),
				proName:$("#genericFunction").val(),
				strength:$("#strength").val(),
				starTime:$("#starTime").val(),
				endTime:$("#endTime").val(),
				
			},
			success: function(data){
				if(data!=null&&data!="null"&&data!=""){
					data = JSON.parse(data);
					 console.log(data);
				
					var numberAll=0;
	 				if(data.items.length>0) {
	 					var  month;	
	 				
						for(var i=0;i<data.items.length;i++) {
							numberAll+=parseInt(data.items[i][4]);
							 month =data.items[i][7].month+1;
							 if(month<10){
								 month="0"+month;
							 }
							 
							 if(data.items[i][7].date<10){
								 data.items[i][7].date ="0"+data.items[i][7].date;
							 }
							 data.items[i][7].year=data.items[i][7].year+1900;
							 
							
							sli +='<tr class="text-c">';
							sli +='<td>'+data.items[i][2]+'</td>';
							sli +='<td>'+data.items[i][8]+'</td>';
							sli +='<td>'+data.items[i][3]+'</td>';
							sli +='<td>'+data.items[i][4]+'</td>';
							sli +='<td>'+data.items[i][9]+'</td>'; 
							sli +='<td>'+data.items[i][5]+'</td>';
							sli +='<td>'+data.items[i][7].year+"-"+month+"-"+data.items[i][7].date+'</td>';
						
						/* 	sli +='<td>'+data.items[i].manufacturer+'</td>'; */
							
				         /*    sli +='<td class="td-manage">'; */
				            /* sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="编辑" onclick="update('+data.items[i].batchId+')"><i class="Hui-iconfont">&#xe6df;</i></a>'; */
					      /*   sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="删除" onclick="del('+data.items[i].batchId+')"><i class="Hui-iconfont">&#xe6e2;</i></a>'; */
				            sli +='</td>';
							sli +='</tr>';
						}
		     		}else {
		     			sli +='<tr class="text-c"><td colspan="8">暂无数据</td></tr>';
			     	}
				}else {
	     			sli +='<tr class="text-c"><td colspan="8">暂无数据</td></tr>';
		     	}
 				sli +='</tbody>';
				sli +='</table>';
				sli +='<div style="width:1560px;">'+'汇总销量:<span style="color:red">'+numberAll+'</span></div>';
 				document.getElementById("allInfo").innerHTML = sli;
 			
 				if(data.items.length>0) {
     				$('.table-sort').dataTable({
     					"bStateSave": false, //状态保存
     					"bLengthChange":false,
     					"searching":false,
     					'ordering'  :false,
     					"aLengthMenu": [[10, 20, 30, -1]]
     				});
 				} 
			}
		});
	}
	
		function getAllUser(){
			var sli = "";
			sli +='<table class="table table-border table-bordered table-bg table-hover table-sort">';
			sli +='<thead><tr class="text-c">';
			sli +='<th>通用名称</th>';
			sli +='<th>规格</th>';
			sli +='<th>批准文号</th>';
			sli +='<th>销量</th>';
			sli +='<th>销售单位</th>';
			sli +='<th>地区</th>';
			sli +='<th>售出日期</th>';
			
		/* 	sli +='<th width="100">操作</th>'; */
			sli +='	</tr></thead>';
			sli +='<tbody id="viewReport">';
				$.ajax({
					url:"getAllListSales",
		            type:"post",
					success: function (data) {
						var numberAll =0;
						if(data!=null && data!=""&&data!="null"){
							data = JSON.parse(data);
							
		     				if(data.items.length>0) {
		     					var  month;	
		     					 
								for(var i=0;i<data.items.length;i++) {
									numberAll+=parseInt(data.items[i].numbers);
									 month =data.items[i].outtime.month+1;
									 if(month<10){
										 month="0"+month;
									 }
									 
									 if(data.items[i].outtime.date<10){
										 data.items[i].outtime.date ="0"+data.items[i].outtime.date;
									 }
									 data.items[i].outtime.year=data.items[i].outtime.year+1900;
									 
									
									sli +='<tr  class="text-c">';
									sli +='<td>'+data.items[i].proName+'</td>';
									sli +='<td>'+data.items[i].strength+'</td>';
									sli +='<td>'+data.items[i].CFDACode+'</td>';
									sli +='<td>'+data.items[i].numbers+'</td>';
									sli +='<td>'+data.items[i].danwei+'</td>'; 
									sli +='<td>'+data.items[i].adress+'</td>';
									sli +='<td>'+data.items[i].outtime.year+"-"+month+"-"+data.items[i].outtime.date+'</td>';
									
									/* sli +='<td>'+data.items[i].manufacturer+'</td>';  */
									
						          /*   sli +='<td class="td-manage">'; */
						            /* sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="编辑" onclick="update('+data.items[i].batchId+')"><i class="Hui-iconfont">&#xe6df;</i></a>'; */
							      /*   sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="删除" onclick="del('+data.items[i].batchId+')"><i class="Hui-iconfont">&#xe6e2;</i></a>'; */
						            sli +='</td>';
									sli +='</tr>';
								}
				     		}else {
				     			sli +='<tr class="text-c"><td colspan="8">暂无数据</td></tr>';
					     	}
						}else {
			     			sli +='<tr class="text-c"><td colspan="8">暂无数据</td></tr>';
				     	}
	     				sli +='</tbody>';
	     				
						sli +='</table>';
							
						sli +='<div style="float:right;">'+'汇总销量:<span style="color:Red">'+numberAll+'</span></div>';
	     				document.getElementById("allInfo").innerHTML = sli;
	     		
	     				if(data!=null&&data!=""&&data.items.length>0) {
		     				$('.table-sort').dataTable({
		     					"bStateSave": false, //状态保存
		     					"bLengthChange":false,
		     					"searching":false,
		     					'ordering'  :false,
		     					"aLengthMenu": [[10, 20, 30, -1]]
		     				});
	     				} 
					}
				}); 
			}		
				$(function(){
					
			
			});
	///===》
				
				//分页新增批次
			function addCharacter(){ 
		/* 	if(obj==-1){ */
			 
				layer.open({
					area: ['880px','550px'],
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
								url: "saveSales",
								type: 'post',
								data:formData1,
								processData:false,
				                contentType: false,
								success: function(data){
									
									
									
										layer.alert('新增成功');
										layer.close(index);
										getAllUser();
									
									
									
								}
							});
						/* } */
						
						
					}
				});
			/* }else{
				//alert(obj);
				////不等于0
				 $.ajax({
					 url: "selectBatchId",
						type: 'post',
						data:{"batchId":obj},
						success:function(data){
							data = JSON.parse(data);
							
							//时间格式化
							data.data.manufactureTime.year=data.data.manufactureTime.year+1900;
							data.data.manufactureTime.month=data.data.manufactureTime.month+1;
							
							 if(data.data.manufactureTime.month<10){
								 data.data.manufactureTime.month="0"+data.data.manufactureTime.month;
							 }
							 
							 if( data.data.manufactureTime.date<10){
								 data.data.manufactureTime.date ="0"+ data.data.manufactureTime.date;
							 }
							 
							
							var boxHtml = "";
					boxHtml +=	'<div class="page-container">';
					boxHtml +=	    '<div class="row cl">';
					boxHtml +=	 '<div class="col-md-12 col-xs-12">';
					boxHtml +=	'	<form class="form form-horizontal" id="batchForm">';
					boxHtml +=	'						<div class="row">';
					boxHtml +=	'								<div class="col-sm-3 col-xs-12 mt-5">';
					boxHtml +=	'										<label class="form-label textl"><span class="c-red">*</span>生产厂家：</label>';
					boxHtml +=	'										<span class="select-box">';
					boxHtml +=	'												<input type="hidden" value=""  id="mahCodess">';
					boxHtml +=	'												<select   class="select"  id="mahCode"  name="mahCode">';
					
														
					boxHtml +=	'												</select>';
					boxHtml +=	'										</span>';
					boxHtml +=	'								</div>';							
					boxHtml +=	'								<div class="col-sm-3 col-xs-12 mt-5">';
					boxHtml +=	'										<label class="form-label textl"><span class="c-red">*</span>通用名称：</label>';
					boxHtml +=	'									<select  class="input-text inputNewCss" onclick="tyName()" value=""  id="productName" name="productName">';
					boxHtml +=	'											<option value="'+data.data.productId+'">'+data.data.productName+'</option>';
					boxHtml +=	'										</select>';
					boxHtml +=	'										</div>';
																	
					boxHtml +=	'													<div class="col-sm-3 col-xs-12 mt-5" >';
					boxHtml +=	'															<label class="form-label textl"><span class="c-red">*</span>批准文号：</label>';
					boxHtml +=	'															<select  class="input-text inputNewCss" onclick="selPc(-1);"   id="CFDACode" name="CFDACode">';
					boxHtml +=	'															<option value="'+data.data.CFDACode+'">'+data.data.CFDACode+'</option>';
					boxHtml +=	'																		</select>';
					boxHtml +=	'													</div>';
					boxHtml +=	'												<div class="col-sm-3 col-xs-12 mt-5">';
					boxHtml +=	'														<label class="form-label textl"><span class="c-red">*</span>批次号：</label>';
					boxHtml +=	'															<input type="text" class="input-text inputNewCss" value="'+data.data.batchNum+'"   id="batchNum" name="batchNum" />';														
					boxHtml +=	'								</div>';						
					boxHtml +=	'								<div class="col-sm-3 col-xs-12 mt-5">';
					boxHtml +=	'										<label class="form-label textl"><span class="c-red">*</span>剂型：</label>';
					boxHtml +=	'									<span class="select-box">';
					boxHtml +=	'										<input type="hidden"   id="dosageSelect">';
					boxHtml +=	'											<select  class="select"  id="dosage" onclick="selJx(-1)" name="dosage">';
					boxHtml +=	'											<option value="'+data.data.dosage+'">'+data.data.dosage+'</option>';													
					boxHtml +=	'											</select>';
					boxHtml +=	'										</span>';
					boxHtml +=	'								</div>';									
					boxHtml +=	'							<div class="col-sm-3 col-xs-12 mt-5" >';
					boxHtml +=	'										<label class="form-label textl"><span class="c-red">*</span>规格：</label>';
					boxHtml +=	'										<select  class="input-text inputNewCss"  onclick="selJx(-1)" id="strength"  name="strength">';
					boxHtml +=	'												<option value="'+data.data.strength+'">'+data.data.strength+'</option>';
					boxHtml +=	'									</select>';
					boxHtml +=	'						</div>';
							
					boxHtml +=	'					<div class="col-sm-3 col-xs-12 mt-5">';
					boxHtml +=	'						<label class="form-label textl"><span class="c-red">*</span>生产日期：</label>';
					boxHtml +=	'							<input type="text" onclick="WdatePicker({readOnly:true})" class="input-text inputNewCss" value="'+data.data.manufactureTime.year+"-"+data.data.manufactureTime.month+"-"+data.data.manufactureTime.date+'"  id="manufactureTime" name="manufactureTime">';
					boxHtml +=	'				</div>';
						
					boxHtml +=	'				<div class="col-sm-3 col-xs-12 mt-5">';
					boxHtml +=	'						<label class="form-label textl"><span class="c-red">*</span>数量：</label>';
																											
					boxHtml +=	'						<input type="text" class="input-text inputNewCss" value="'+data.data.number+'" id="number" name="number">';
					boxHtml +=	'			</div>';
				
					boxHtml +=	'		<div class="col-sm-3 col-xs-12 mt-5">';
					boxHtml +=	'	<label class="form-label textl"><span class="c-red">*</span>包装单位：</label>';
				    boxHtml +=	'	<input type="text" class="input-text inputNewCss" value="'+data.data.packaging+'" id="packaging" name="packaging">';
					boxHtml +=	'</div>';
					
					boxHtml +=	'		<div style="display:none" class="col-sm-3 col-xs-12 mt-5">';
					boxHtml +=	'	<label class="form-label textl"><span class="c-red">*</span>产品id：</label>';
				    boxHtml +=	'	<input type="text" class="input-text inputNewCss" value="'+data.data.productId+'" id="productId" name="productId">';
					boxHtml +=	'</div>';
			
			
					boxHtml +=	'		<div style="display:none" class="col-sm-3 col-xs-12 mt-5">';
					boxHtml +=	'		<label class="form-label textl"><span class="c-red">*</span>生产厂家：</label>';
					boxHtml +=	'<input type="text" class="input-text inputNewCss" value="" id="manufacturer" name="manufacturer">';
					boxHtml +=	'	</div>';
					
					boxHtml +=	'		<div style="display:none" class="col-sm-3 col-xs-12 mt-5">';
					boxHtml +=	'		<label class="form-label textl"><span class="c-red">*</span>主键</label>';
					boxHtml +=	'<input type="text" class="input-text inputNewCss" value="'+data.data.batchId+'" id="batchId" name="batchId">';
					boxHtml +=	'	</div>';
					
					
					
					boxHtml +=	'		</div>';
					boxHtml +=	'	</form>';
					boxHtml +=	'	</div>';
					boxHtml +=	'	</div>';
					boxHtml +=	'	</div>';
					getSession(data.data.mahId);				
					//弹页面
					layer.open({
						area: ['800px','350px'],
						title:"修改批次",
						type: 1,
						skin: 'layui-layer-rim', //加上边框
						content:boxHtml,
						btn:["确定","取消"],				 
						yes:function(index,layero){
								$.ajax({
									url: "update",
									type: 'post',
									data:{"batchId":$("#batchId").val(),
										  "batchNum":$("#batchNum").val(),
										  "productName":$("#productName").val(),
										  "CFDACode":$("#CFDACode").val(),
										  "dosage":$("#dosage").val(),
										  "strength":$("#strength").val(),
										  "manufactureTime":$("#manufactureTime").val(),
										  "number":$("#number").val(),
										  "packaging":$("#packaging").val(),
										  "manufacturer":$("#manufacturer").val(),
										  "productId":$("#productId").val(),
										  "mahCode":$("#mahCode").val(),
										   
										  },
									success: function(data){
										data = JSON.parse(data);
											if(data.result == 'true'){
												layer.alert('修改成功');
												layer.close(index);
												getAllUser();
											}
											else{
												layer.alert(修改失败);
											}
										}	  
									
								});
						}
					});
                           }
					  });
				
					
				////不等于0
			}					 */		
				};
	///===》	
			//删除
			function del(obj){
				layer.confirm('确定要删除这个信息吗？', {
					time: 0, //不自动关闭
					btn: ['确定', '取消'],
					icon: 3,
					yes: function(index){
						$.ajax({
							url: "del",
							type: 'post',
							data:{"batchId":obj},
							success: function(data){
								if(data!=null && data!=""&&data!="null"){
								data = JSON.parse(data);
								if(data.result == 'true'){
									layer.alert('删除成功');
									layer.close(index);
									getAllUser();
								}
								else{
									layer.alert(删除失败);
								}
								}
							}
						});
					}
				});
			}

			
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
									option+='<option></option>';
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