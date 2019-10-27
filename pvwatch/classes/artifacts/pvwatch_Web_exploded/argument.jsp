<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>重复项配置</title>
	<link href="static/akehu/mainFile/h-ui/css/H-ui.min.css"
	rel="stylesheet" type="text/css">
	<link href="static/akehu/mainFile/h-ui.admin/css/H-ui.admin.css"
		  rel="stylesheet" type="text/css">
	<link href="static/akehu/css/bootstrap.min.css" rel="stylesheet">	
	<link href="static/akehu/font-awesome-4.7.0/css/font-awesome.min.css"  rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<h2>重复项配置</h2>
			</div>
			<div class="col-md-10 col-md-offset-1">
				<table id="tab" class="table table-bordered table-hover text-center" border="" cellspacing="" cellpadding="">
					<tr>
					
						
					</tr>
				</table>
			</div>
			
		</div>
	</div>
	<script type="text/javascript"src="static/js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="static/akehu/mainFile/h-ui/js/H-ui.js" ></script>
	<script type="text/javascript" src="static/akehu/mainFile/h-ui.admin/js/H-ui.admin.js" ></script>
	<script src="static/akehu/jsPlugin/bootstrap.min.js" type="text/javascript"></script>
		
	
	<script type="text/javascript">
		$(function(){
			init();
		});
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
			
				success:function(data){
				  if(data!=null && data !=""){
					  data = JSON.parse(data);
					//  console.log(data);
				  }
				  if(data.items.length>0) {
					  for(var i=0;i<data.items.length;i++) {
						  if(data.items[i].status == '1'){
							  sli +='<tr>';
								sli +='<td ><input  onclick="ChangeStatus('+data.items[i].id+','+data.items[i].status+');"  type="checkbox" checked value='+data.items[i].id+'></td>';
								sli +='<td style="text-align:center" >'+data.items[i].name+'</td>';
								sli +='<td style="text-align:center" >'+data.items[i].filedName+'</td>';
					            sli +='</td>';
								sli +='</tr>';
						  }else{
							  sli +='<tr>';
								sli +='<td ><input  onclick="ChangeStatus('+data.items[i].id+','+data.items[i].status+');"  type="checkbox"  value='+data.items[i].id+'></td>';
								sli +='<td style="text-align:center" >'+data.items[i].name+'</td>';
								sli +='<td style="text-align:center" >'+data.items[i].filedName+'</td>';
					            sli +='</td>';
								sli +='</tr>';
						  }
					  }
					  $("#tab tbody").html(sli);
				  }
				}
			});
		}
		function ChangeStatus(obj,status){
			//alert(obj);
			$.ajax({
				url:"updateRepetion",
				type:'post',
				data:{
					"id":obj,
					"status":status
				},
				success:function(data){
					//console.log(data);
					if(data=='true'){
						init();
					}else{
						alert("失败");
					}
				}
			});
		}
			
	</script>
</body>
</html>