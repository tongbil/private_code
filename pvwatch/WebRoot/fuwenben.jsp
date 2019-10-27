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
<link href="static/akehu/font-awesome-4.7.0/css/font-awesome.min.css"  rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="static/akehu/css/productBaseInfo.css"/>
<link href="static/akehu/css/bootstrap.min.css" rel="stylesheet">	

<link href="static/akehu/mainFile/h-ui/css/H-ui.min.css"
	rel="stylesheet" type="text/css">
<link href="static/akehu/mainFile/h-ui.admin/css/H-ui.admin.css"
	rel="stylesheet" type="text/css">
<link href="static/akehu/jsPlugin/Hui-iconfont/1.0.7/iconfont.css"
	rel="stylesheet" type="text/css">
<link href="static/akehu/css/groupManage.css" rel="stylesheet"
	id="skin" type="text/css">
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
	li{
	float:left
	}
	.iblock{display: inline-block}
</style>

<title>查询</title>
		
		
</head>

<body>	
	
			<div class="text-l pd-20 bg-1 bk-gray radius">
					企业：<select  style="width:200px;" class="input-text" id="evBatch-code"  >
					
								<option  value="lizhu">lizhu</option>
								<option value="YZJ">YZJ</option>
					</select>&nbsp;
					通用名称：<select   style="width:200px;" class="input-text" id="genericFunction" ></select>&nbsp;
				 	 组成成分：<select   style="width:200px;" class="input-text" id="zccf"></select>&nbsp;  
						<!--  <div class="iblock" id="addhyyy" >
									<span class="f-l">通用名称</span>
									<select onchange="c();" id="zccf" name="zccf" class="select products">
									<option value="0"></option>
									
									</select>
								</div>  -->
						不良反应名称：<select   style="width:200px;" class="input-text" id="blName" ></select>&nbsp;
				
					<a href="javascript:void(0);" onclick="conditions()"  class="btn btn-primary "><i class="Hui-iconfont"></i> 搜索</a>
				
			
			<div class="cl mt-20"> 
		
					<ol  id="optips">
						<li><select name='blfy' id="s1" style='width:200px;display:none' class='input-text' ></select></li>
					
					</ol>
				
				
					<div class="col-md-12 col-xs-12">
						<div class="form-group">
							<!-- <label style="margin-bottom: 5px;" for="detailInfo" >文档内容</label> -->
						<script id="editor"  type="text/plain" style="width:100%;height:200px;display:none" name="helpPageContent"></script>
						</div>
					</div>		
					<span class="l">
					<a href="javascript:void(0);"  onclick="update(-1);" class="btn btn-primary "><i class="Hui-iconfont">&#xe600;</i> 录入</a>
				</span>			
			</div>
	<div class="cl mt-15"></div>
	<div class="mt-15" id="allInfo">
	</div>
	</div>
	<script type="text/javascript"src="static/akehu1/jquery/jquery-1.11.0.min.js" ></script>
	<script src="static/akehu/jsPlugin/bootstrap.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="static/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="static/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="static/ueditor/lang/zh-cn/zh-cn.js"></script>				
	<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js" ></script>
		<script type="text/javascript"
		src="static/akehu/jsPlugin/layer-v3.0.1/layer/layer.js" ></script>

	<script type="text/javascript">
	var ue ;
	$(function(){
		ue= UE.getEditor('editor', {
			toolbars: [
				['fullscreen', 'source', '|', 'undo', 'redo', 
					'bold', 'italic', 'underline', 'fontborder', 'strikethrough', '|', 'forecolor', 'backcolor',
					'fontfamily', 'fontsize', '|',
					'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|',
					'link', 'unlink', '|', 'simpleupload','inserttable'
				]
			],
			wordCount:false,
			elementPathEnabled : false
		});	
		
		/* $('#datetimepickers').datetimepicker({}); */
	
		
	
			
			
			
			
		});
		
		


//blog.csdn.net/qq_36639124/article/details/81221164 

		
/* 		laydate.render({elem: '#manufactureTime'});
		//切换生产厂家select选择框选择通用类型		
		$("#evBatch-code").change(function(){				
			var  comPany =$("#evBatch-code").val();
			tyName(comPany);
		});	 */
		
		
	
	$(function(){
	//	getSession();
		getAllUser();
		zc();
	});
		
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
			};  
		
		
			
		

		function getAllUser(){
			var sli = "";
			sli +='<table class="table table-border table-bordered table-bg table-hover table-sort">';
			sli +='<thead><tr class="text-c">';
			sli +='<th>创建人</th>';
			sli +='<th>通用名称</th>';
			sli +='<th>不良反应名称</th>';
			sli +='<th>不良反应名称编码</th>';		
			sli +='<th>组成成分</th>';
			sli +='<th>录入的信息</th>';
			sli +='<th>上次修改日期</th>';
			
		 	sli +='<th >操作</th>'; 
			sli +='	</tr></thead>';
			sli +='<tbody id="viewReport">';
				$.ajax({
					url:"getAllblfy",
		            type:"post",
					success: function (data) {
					
						if(data!=null && data!=""&&data!="null"){
							data = JSON.parse(data);
							
		     				if(data.items.length>0) {
		     					var  month;	
		     					
								for(var i=0;i<data.items.length;i++) {
									data.items[i][7] = data.items[i][7].substring(3, data.items[i][7].length-4);
									data.items[i][7]+="...";
									 month =data.items[i][8].month+1;
									 if(month<10){
										 month="0"+month;
									 }
									 
									 if(data.items[i][8].date<10){
										 data.items[i][8].date ="0"+data.items[i][8].date;
									 }
									 data.items[i][8].year=data.items[i][8].year+1900;
									 
									
									sli +='<tr onDblClick="shuangji('+data.items[i][1]+')" class="text-c">';
									sli +='<td>'+data.items[i][0]+'</td>';
									sli +='<td>'+data.items[i][2]+'</td>';
									sli +='<td>'+data.items[i][3]+'</td>';
									sli +='<td>'+data.items[i][4]+'</td>';
									sli +='<td>'+data.items[i][6]+'</td>';
									sli +='<td>'+data.items[i][7]+'</td>'; 
								
									sli +='<td>'+data.items[i][8].year+"-"+month+"-"+data.items[i][8].date+'</td>';
									
									/* sli +='<td>'+data.items[i].manufacturer+'</td>';  */
									
						            sli +='<td class="td-manage">'; 
						            sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="编辑" onclick="update('+data.items[i][1]+')"><i class="Hui-iconfont">&#xe6df;</i></a>'; 
							        sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="删除" onclick="del('+data.items[i][1]+')"><i class="Hui-iconfont">&#xe6e2;</i></a>'; 
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
							
						/* sli +='<div style="float:right;">'+'汇总销量:<span style="color:Red">'+numberAll+'</span></div>'; */
	     				document.getElementById("allInfo").innerHTML = sli;
	     		
	     				 
					}
				}); 
			};
	
	function conditions(){
	
	
		var sli = "";
		sli +='<table class="table table-border table-bordered table-bg table-hover table-sort">';
		sli +='<thead><tr class="text-c">';
		sli +='<th>创建人</th>';
		sli +='<th>通用名称</th>';
		sli +='<th>不良反应名称</th>';
		sli +='<th>不良反应名称编码</th>';		
		sli +='<th>组成成分</th>';
		sli +='<th>录入的信息</th>';
		sli +='<th>上次修改日期</th>';		
	 	sli +='<th >操作</th>'; 
		sli +='	</tr></thead>';
		sli +='<tbody id="viewReport">';
		$.ajax({
			url:"seclittle",	
			type:"post",
			data:{		
				qiyeId:$("#evBatch-code").val(),
				proName:$("#genericFunction").find("option:selected").text(),
				zccf:$("#zccf").val(),			
				blName:$("#blName").find("option:selected").text(),
			},
			success: function(data){
				data = JSON.parse(data);
			
				if(data!=null&&data!="null"&&data!=""){
					
					
						if(data.items.length>0) {
	     					var  month;	
	     					
							for(var i=0;i<data.items.length;i++) {
								data.items[i][7] = data.items[i][7].substring(3, data.items[i][7].length-4);
								data.items[i][7]+="...";
								 month =data.items[i][8].month+1;
								 if(month<10){
									 month="0"+month;
								 }
								 
								 if(data.items[i][8].date<10){
									 data.items[i][8].date ="0"+data.items[i][8].date;
								 }
								 data.items[i][8].year=data.items[i][8].year+1900;
								 if(data.items[i][3] !=""){
									 data.items[i][3]=data.items[i][3];
								 }
								
								sli +='<tr onDblClick="shuangji('+data.items[i][1]+')" class="text-c">';
								sli +='<td>'+data.items[i][0]+'</td>';
								sli +='<td>'+data.items[i][2]+'</td>';
								sli +='<td>'+data.items[i][3]+'</td>';
								sli +='<td>'+data.items[i][4]+'</td>';
								sli +='<td>'+data.items[i][6]+'</td>';
								sli +='<td>'+data.items[i][7]+'</td>'; 
							
								sli +='<td>'+data.items[i][8].year+"-"+month+"-"+data.items[i][8].date+'</td>';
								
								/* sli +='<td>'+data.items[i].manufacturer+'</td>';  */
								
					            sli +='<td class="td-manage">'; 
					            sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="编辑" onclick="update('+data.items[i][1]+')"><i class="Hui-iconfont">&#xe6df;</i></a>'; 
						        sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="删除" onclick="del('+data.items[i][1]+')"><i class="Hui-iconfont">&#xe6e2;</i></a>'; 
					            sli +='</td>';
								sli +='</tr>';
							}
			     		}else {
		     			sli +='<tr class="text-c"><td colspan="8">暂无数据</td></tr>';
		     				
		     			$.ajax({
							url: "saveRef",
							type: 'post',
							async:false,
							data:{
								content:"",
								zhujian:"-1",
								genericFunction:$("#genericFunction").find("option:selected").text(),
								zccf:$("#zccf").val(),
								blNameCode:$("#blName").val(),
								blName:$("#blName").find("option:selected").text(),
								userid:"1",
								
							},	
						 	success: function(data){
						 		data = JSON.parse(data);
						 	
						 		update(data.items[0]);
						 		
						 		
						 	}
		     			});
		     			
		     			
		     			
		     			
		     			
		     			
			     	}
				}else {
	     			sli +='<tr class="text-c"><td colspan="8">暂无数据</td></tr>';
		     	}
 				sli +='</tbody>';
				sli +='</table>';
				/* sli +='<div style="float:right;">'+'汇总销量:<span style="color:red">'+numberAll+'</span></div>'; */
 				document.getElementById("allInfo").innerHTML = sli;
 			
 				if(data.items.length>0) {
     				
 				} 
			}
		});
	};
	
	
	$("#evBatch-code").change(function(){				
		var  comPany =$("#evBatch-code").val();
		tyName(comPany);
	});	
	$("#genericFunction").change(function(){				
		var  comPany =$("#genericFunction").val();
		blfy(comPany);
	});	
	
	function zc(){
		var option="";
		$.ajax({
			url:"zccf",
			type:'post',
			success:function(data){
				data = JSON.parse(data);
				option +='<option secleted><option>';
				if(data.items.length>0){
				 	for(var i=0;i<data.items.length;i++){			 	
				 	 option += '<option value="'+data.items[i]+'">'+data.items[i]+'</option>';
				 	
				 	}
				 	$("#zccf").html(option);
				}
			}
		});
	}		
	
	
	
	function addCharacter(){
		
		$("#editor").css("display","block");


		console.log(content);
	}
	
	
	
	
	function update(obj){
		if(obj == -1){
			 layer.open({
					area: ['1000px','550px'],
					title:"添加数量",
					type: 2,
					skin: 'layui-layer-rim', //加上边框
					content:'reFerence.htm',
					btn:["确定","取消"],
					yes:function(index,layero){

						var formData1=$(layero).find("iframe")[0].contentWindow.getInfo();
					console.log(formData1);
										
						$.ajax({
							url: "saveRef",
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
				},
				});
		}else{
			
			 layer.open({
					area: ['1000px','550px'],
					title:"添加数量",
					type: 2,
					skin: 'layui-layer-rim', //加上边框
					content:'upreFerence.htm?obj='+obj,
					btn:["确定","取消"],
					yes:function(index,layero){

					//	var formData1=$(layero).find("iframe")[0].contentWindow.getInfo();
							var formData1=$(layero).find("iframe")[0].contentWindow.getInfo();
					
										
						$.ajax({
							url: "saveRef",
							type: 'post',
							data:formData1,
							processData:false,
			                contentType: false,
							success: function(data){
								layer.alert('修改成功');
								layer.close(index);
								getAllUser(); 
								
							}
						});	
				
				},
				});
		}
	
	}
	
	//获取通用名称
	function tyName(obj){		
							var option="";
							$.ajax({
								url:"blfyName1",
								type: 'post',
								data:{
									"obj":obj,
								},
							success:function(data){
								if(data!=null && data!=""&&data!="null"){
									
								data = JSON.parse(data);
									option+='<option></option>'
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
					function blfy(obj){		
						if(obj=-1){
							obj=$("#genericFunction").val();
						}
						var option="";
						$.ajax({
							url:"blfy",
							type: 'post',
							data:{
								"obj":obj,
							},
						success:function(data){
							if(data!=null && data!=""&&data!="null"){
								
							data = JSON.parse(data);
							option+='<option ></option>';
							if(data.items.length>0){
							 	for(var i=0;i<data.items.length;i++){			 	
							 	 option += '<option value="'+data.items[i][2]+'">'+data.items[i][1]+'</option>';
							 	
							 	}
								$("#blName").html(option);
							}
							}
								
						}
							
						});
				}
	
		//删除
		function del(obj){
			layer.confirm('确定要删除这个信息吗？', {
				time: 0, //不自动关闭
				btn: ['确定', '取消'],
				icon: 3,
				yes: function(index){
					$.ajax({
						url: "delRe",
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
		};
		
	</script>
</body>
</html>