<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>重复项配置</title>
	
	<link href="static/akehu/mainFile/h-ui.admin/css/H-ui.admin.css"
		  rel="stylesheet" type="text/css">
	<link href="static/akehu/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="static/css/combo.select.css""/>	
	<link href="static/akehu/font-awesome-4.7.0/css/font-awesome.min.css"  rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div style="padding-top:74px" class="col-md-4 col-md-offset-4">
				<h2>重复项配置</h2>
			</div>
			
			<!-- <div class="iblock" id="cominfonamegs">
				 		<div style="float:left;padding-top: 2px;">审核人:</div>
						<select    style="width:200px;height:31px;" class="select  user" name="user" id="user" >
							<option value="-1"></option>
						</select>&nbsp;
			
			</div> -->
			<!-- <div style="float:left" >
				<div>申请理由:</div><textarea id="content" rows="5px" cols="35px" ></textarea> 
			</div> -->
			
			<div class="col-md-10 col-md-offset-1">
				<table id="tab" class="table table-bordered table-hover text-center" border="" cellspacing="" cellpadding="">
					<tr>
					</tr>
				</table>
			</div>
			<div class="cl mt-20" style="width:200px;float:right"> 
				<span class="l">
				<a  onclick="ChangeStatuslayOpen();" class="btn btn-primary ">提交审核</a>
			</span>	
				<input type="hidden"  id="userid"/>
		</div>
	</div>
	</div>
	<script type="text/javascript"src="static/js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="static/akehu/mainFile/h-ui/js/H-ui.js" ></script>
	<script type="text/javascript" src="static/akehu/mainFile/h-ui.admin/js/H-ui.admin.js" ></script>
	<script src="static/akehu/jsPlugin/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="static/js/jquery.combo.select.js"></script>
			<script type="text/javascript"
		src="static/akehu/jsPlugin/layer-v3.0.1/layer/layer.js" ></script>
	
	<script type="text/javascript">
		$(function(){
			init();
			sysUser();
			//getSession();
		});
		function getSession(){
			$.ajax({
				url :  "../../system/getSession",
			    type:"post",
			    async:false,
			    success:function(data){
			    	if(data!=null&&data!=undefined&&data!="null"&&data!=""){
			    		data = JSON.parse(data);
				    	if(data.companyInfo!=null && data.companyInfo!=""){
				    		$("#userid").val(data.userId);
				    		
				    		companyValue = data.companyInfo;
				    		companyValue = JSON.parse(companyValue);
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
		} 
		
		//初始化用户样式
		function comboInputCompanygs(){
			$(".user").comboSelect();
			$('.combo-input').on('focus',function(){
			$(this).parent().addClass('combo-open');
			});
			$('#user option').each(function(){this.style='display:none'}); 
		}
		
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
		function init(){
			var sli = "";
			sli += '<tr>';
			sli += '<th class="text-center">勾选</th>';
			sli += '<th class="text-center">中文名字</th>';
			sli += '<th class="text-center">英文名字</th>';
			sli += '</tr>';
			$.ajax({
				url:"getAllRepetion",
				type:"post",
				anysc:false,
				success:function(data){
				  if(data!=null && data !=""){
					  data = JSON.parse(data);
					//  console.log(data);
				  //onclick="ChangeStatus('+data.items[i].id+','+data.items[i].status+');"
				  if(data.items.length>0) {
					  for(var i=0;i<data.items.length;i++) {
						  if(data.items[i].status == '1'){
							  sli +='<tr>';
								sli +='<td ><input  name="cbServerType"  type="checkbox" checked value='+data.items[i].id+'></td>';
								sli +='<td style="text-align:center" >'+data.items[i].name+'</td>';
								sli +='<td style="text-align:center" >'+data.items[i].filedName+'</td>';
					            sli +='</td>';
								sli +='</tr>';
						  }else{
							  sli +='<tr>';
								sli +='<td ><input type="checkbox"  value='+data.items[i].id+'></td>';
								sli +='<td style="text-align:center" >'+data.items[i].name+'</td>';
								sli +='<td style="text-align:center" >'+data.items[i].filedName+'</td>';
					            sli +='</td>';
								sli +='</tr>';
						  }
					  }
					  $("#tab tbody").html(sli);
				  	}
				  }
				}
			});
		}
		function ChangeStatuslayOpen(){
			layer.open({
				area: ['500px','350px'],
				title:"审核",
				type: 2,
				skin: 'layui-layer-rim', //加上边框
				content:'argumentUser.htm',
				btn:["确定","取消"],
				yes:function(index,layero){
					layer.alert('提交成功');
					layer.close(index);
					var formData1=$(layero).find("iframe")[0].contentWindow.getInfos();
					
					ChangeStatus(formData1.get("content"),formData1.get("userName"));
			},
			});
		}
		function ChangeStatus(content,userName){
			if(content=="" || userName==""){
				alert("审核人或理由不能为空");
				return false;
			}
			var number="";
		       $.each($('input:checkbox'),function(){
	                if(this.checked){
	                	number+= $(this).val()+',';
	                }
	            });
			$.ajax({
				url:"updateRepetion",
				type:'post',
				anysc:false,
				data:{
				"number":number,
				"content":content,
				"userName":userName,
				"userid":$("#userid").val()
				},
				success:function(data){
					//console.log(data);
						//init();
				}
			});
		}
			
	</script>
</body>
</html>