<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</head>
<body>
	
	<div class="page-container" style="padding: 10px 10px 50px 10px;background: #FFFFFF;">
			<!-- <div class="text-l pd-20 bg-1 bk-gray radius">
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
					<input type="button" style="margin-left:70px" onclick="conditions();" class="btn btn-primary " value="查询"  />
			</div> -->
		<!-- <div class="cl mt-20"> 
				<span class="l">
					<a href="javascript:void(0);" onclick="addCharacter();" class="btn btn-primary "><i class="Hui-iconfont">&#xe600;</i> 录入</a>
				</span>	
			</div> -->
	<div class="cl mt-15"></div>
	 <table style="width:20%;float:right;display:none" id="sd"  class="table table-border table-bordered table-bg table-hover mt-10">
						<thead>
							<tr>
								<th colspan="2">ADR报告</th>
							</tr>
						</thead>
						<tbody>
							<tr class="text-c">
								<th width="25%" >ADR描述：</th>
								<td id="describeAndDeal"></td>
							</tr>
						</tbody>
					</table> 	
	<div class="mt-15" id="allInfo" style="width:70%;float:left">
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
	
	<script type="text/javascript"
	src="static/akehu/jsPlugin/datePicker/WdatePicker.js" ></script>
		
	
	<script type="text/javascript">
		$(function(){
			init();
		});
		function init(){
			
			var index = layer.msg('正在查询规整，请稍后....', {
				icon: 16,
				shade: [0.5,'#000'],
				time:0
			});
			
			var sli = "";
			sli +='<table style="" id="tab" class="table-sort table table-bordered table-hover text-center " border="" cellspacing="" cellpadding="">';
			sli +='<thead><tr class="text-c">';
			sli += '<tr>';
			sli += '<th class="text-center">企业病例编码</th>';
			sli += '<th class="text-center">发生时间</th>';
			sli += '<th class="text-center">出生日期</th>';
			
			sli += '<th class="text-center">性别</th>';
			sli += '<th class="text-center">年龄</th>';
			sli += '<th class="text-center">单位</th>';
			sli +='<th style="width:60px" class="text-center">操作</th>'; 
			sli +='	</tr></thead>';
			sli +='<tbody id="viewReport">';
			$.ajax({
				url:"putReportAll",
				type:"post",
			
				success:function(data){
				  if(data!=null && data !=""){
					  data = JSON.parse(data);
					  console.log(data);
				  }
				  if(data.items.length>0) {
					  for(var i=0;i<data.items.length;i++) {
						  if(data.items[i][2] !=null && data.items[i][3]!=null){
							  var times=DateDiff(data.items[i][2],data.items[i][3]);
							  console.log(times+"????");
							//  console.log(times+"?");
							  if(times/365>1){
								  var as=times/365;
								 // console.log(as+"!");
								var sa=  decimal(as,0)
									//console.log(sa+"?");
								  data.items[i][5]=sa;
								  data.items[i][6]="年";
							  } 
							  if(times<=30){
								  data.items[i][5]=times;
								  data.items[i][6]="天";
							  }
							  if(times/30>1 && times/365<1){
								  var as=times/30;
									var sa=  decimal(as,0)
									  data.items[i][5]=sa;
									  data.items[i][6]="月";
							  }
							  
							  
						  }
						  
							  sli +='<tr onDblClick="show('+data.items[i][0]+')" >';
								sli +='<td style="text-align:center" >'+data.items[i][1]+'</td>';
								if(data.items[i][2] == null){
									sli +='<td style="text-align:center" ><a href="javascript:void(0);" onclick="WdatePicker({readOnly:true})">请输入时间</a></td>';
								}else{
									sli +='<td style="text-align:center" >'+data.items[i][2]+'</td>';
								}
								
								if(data.items[i][3] == null){
									sli +='<td style="text-align:center" ><a href="javascript:void(0);" onclick="WdatePicker({readOnly:true})">请输入时间</a></td>';
								}else{
									sli +='<td style="text-align:center" >'+data.items[i][3]+'</td>';
								}
								
								
								
								if(data.items[i][4] == '1'){
									sli +='<td  style="text-align:center" contenteditable="true">男</td>';
								}
								if(data.items[i][4] == '2'){
									sli +='<td  style="text-align:center" contenteditable="true">女</td>';
								}
								if(data.items[i][4] == '0'){
									sli +='<td  style="text-align:center" onclick="noneText(this)" contenteditable="true"><span style="color:red">点击输入性别<span></td>';
								}
								if(data.items[i][5] == null){
									sli +='<td  style="text-align:center" ></td>';
								}else{
									sli +='<td  style="text-align:center" >'+data.items[i][5]+'</td>';
								}
								
								sli +='<td  style="text-align:center" >'+data.items[i][6]+'</td>';
								
								sli +='<td style="text-align:center" class="td-manage">'; 
					             sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="更新" onclick="update(this,'+data.items[i][0]+')"><i class="Hui-iconfont">&#xe6df;</i></a>'; 
						      
					            sli +='</td>';
					            
								sli +='</tr>';
						 
					  }
					
					//  $("#tab tbody").html(sli);
					//  layer.close(index);
				  }else{
					  sli +='<tr class="text-c"><td colspan="8">暂无数据</td></tr>';
					 
				  }
				  sli +='</tbody>';
					sli +='</table>';
					layer.close(index);
					
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
		function show(obj){
			$.ajax({
				url:"getContent",
					type:"post",
					data:{
						"obj":obj
					},
					success:function(data){
						 data = JSON.parse(data);
						 $("#sd").show();
						 $("#describeAndDeal").html(data.data)
					
					}
			})
		}
		
		function decimal(num,v){
			var vv = Math.pow(10,v);
			return Math.round(num*vv)/vv;
			}
		
		//判断时间差
		function DateDiff(sDate1, sDate2) {  
			  
		    var aDate, oDate1, oDate2, iDays;
		    aDate = sDate1.split("-");
		    oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);  //转换为yyyy-MM-dd格式
		    aDate = sDate2.split("-");
		    oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
		    iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒数转换为天数
		  
		    return iDays;  //返回相差天数
		}
		function noneText(thisObj){
			 var $td = $(thisObj).parents('tr').children('td');
			if($td.eq(3).text()!='男'&& $td.eq(3).text()!='女'){
				$td.eq(3).text("");
			}
		}
		
		function update(thisObj, thisObjID){
			    var $td = $(thisObj).parents('tr').children('td');
			   // alert($td.eq(3).text()); //第一个td的内容
			   // alert($td.eq(4).text());//第二个td的内容
				 // alert(thisObjID);
			   var age;
			   var sex;
			 
			   if($td.eq(4).text()=='女'){
				   sex='2';
			   }else if($td.eq(4).text()=='男'){
				   sex='1';
			   }else{
				   alert("性别输入有误"); 
				   return false;
			   }
			   if($td.eq(6).text()!='年' && $td.eq(4).text()!='月' && $td.eq(4).text()!='日'){
				   alert("输入年或者月或者日");
				   return false;
			   }
				/* //时间比大小
				var startDate =$td.eq(1).text();
				var endDate=$td.eq(2).text();
				if(startDate!="" && startDate!=null && endDate!=null && endDate!=""){
					var startNum = parseInt(startDate.replace(/-/g,''),10);
					var endNum = parseInt(endDate.replace(/-/g,''),10);
					if(startNum<endNum){
						alert("发生时间不能小于出生时间");
						return false;
						}
				} */
				
			   $.ajax({
				   url:"upOneReport",
				   type:'post',
				   data:{
						"obj":thisObjID,
						"sex":sex,
						"age":$td.eq(5).text(),
						"dw":$td.eq(6).text(),
					},
					success:function(data){
						data = JSON.parse(data);
						init();
					}
				   
			   })
			  
		
		}
		
	</script>
</body>
</html>