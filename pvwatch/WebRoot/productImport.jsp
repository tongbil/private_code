<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品导入</title>
</head>
<link href="static/akehu/mainFile/h-ui/css/H-ui.min.css"  rel="stylesheet" type="text/css">
<link href="static/akehu/mainFile/h-ui.admin/css/H-ui.admin.css"  rel="stylesheet" type="text/css">
<link href="static/akehu/font-awesome-4.7.0/css/font-awesome.min.css"  rel="stylesheet" type="text/css">
<link href="static/akehu/jsPlugin/icheck/icheck.css"  rel="stylesheet" type="text/css">
<link href="static/akehu/css/iconfont.css"  rel="stylesheet" type="text/css">

<body>
	<input type="text" id="wsServer" class="hidden" value="${wsServer}"/>
	<div class="page-container">
		<div class="text-l pd-20 bg-1 bk-gray radius">
			<div>
				选择企业：
				<span class="select-box" style="width:303px">
					<select name="caseIdCode" id="caseIdCode" class="select">
						<option value="0" data-lang="0">请选择</option>
					</select>
				</span>&nbsp;&nbsp;&nbsp;
				数据来源：
				<span class="select-box" style="width:180px">
					<select name="sourceCode" id="sourceCode" class="select">
						<option value="0">请选择</option>
					</select>
				</span>&nbsp;&nbsp;&nbsp;
				账号：<input type="text" name="userAccount" placeholder="账号" style="width:150px" readOnly class="input-text">&nbsp;&nbsp;&nbsp;
				密码：<input type="password" name="password" placeholder="密码" style="width:150px" readOnly class="input-text">
			</div>
			<div style="margin-top: 10px;">
				<label>申请日期：</label>
				<input type="text" name="receiveTimeStart" id="receiveTimeStart" placeholder="开始时间" style="width:150px" class="input-text" >
				<input type="text" name="receiveTimeEnd" id="receiveTimeEnd" placeholder="结束时间" style="width:150px" class="input-text">
				&nbsp;&nbsp;&nbsp;
				<a href="javascript:void(0);" class="btn btn-primary" id="imporotProduct"><i class="Hui-iconfont">&#xe641;</i> 导入</a>
			</div>
		</div>
		<div>
			实时结果反馈：
			<div style="margin-left: 20px;" id="feedbackResult">
			
			</div>
		</div>
	</div>
	<script type="text/javascript" src="static/lib/jquery-1.8.js"></script>
	<script type="text/javascript" src="static/lib/layer-v3.0.1/layer/layer.js" ></script>
	<script type="text/javascript" src="static/lib/layDate/laydate.js" ></script>
	<script type="text/javascript" src="static/lib/h-ui/js/H-ui.js" ></script>
	<script type="text/javascript" src="static/lib/h-ui.admin/js/H-ui.admin.js" ></script>
	<script type="text/javascript" src="static/lib/icheck/jquery.icheck.min.js" ></script>	
	<script type="text/javascript">
		var ws;
		
		var userId="";
		var userName = "";
		$(function(){
			$.ajax({
				url:"../system/getSession",
				type:"post",
				dataType:"json",
				async:false,
				success:function(response){
					if(response==null){
						alert("获取用户信息失败！请重新登录");
						parent.location.href="/system/login";
						return false;
					}
					userId=response.userId;
					userName=response.loginName;
					ws = new WebSocket($("#wsServer").val());
					ws.onopen=function(){
						console.log("webSockerOpen");
						ws.send("@onLine:"+userName);
						console.log("bindUser is ok");
					}
					ws.onmessage=function(evt){
						if(evt.data.startsWith("消息推送!@#")){
							var rrr = evt.data.split("!@#")[1];
							if(rrr.indexOf("登录成功")>-1){
								$("#feedbackResult").append("<p style='color:green;'>"+rrr+"</p>");
							}else if(rrr.indexOf("账号或密码错误")>-1||rrr.indexOf("登录失败")>-1||rrr.indexOf("验证码解析有误")>-1){
								$("#feedbackResult").append("<p style='color:red;'>"+rrr+"</p>");
							}else{
								$("#feedbackResult").append("<p>"+rrr+"</p>");
							}
						}else{
							console.log(evt.data);
						}
					}
					ws.onclose=function(){
						ws.close();
						console.log("websocket is close");
					}
					var companyInfo = JSON.parse(response.companyInfo);
					$(companyInfo).each(function(i,item){
						$("#caseIdCode").append("<option value='"+item.caseIDCode+"' data-lang='"+item.mahCode+"'>"+item.companyFullName+"</option>");
					});
				}
			});
			$("#caseIdCode").on("change",function(){
				$("input[name='userAccount']").val("");
				$("input[name='password']").val("");
				var caseIdCodeSelectIndex = $("#caseIdCode")[0].selectedIndex;
				var mahId = $($("#caseIdCode")[0].options[caseIdCodeSelectIndex]).attr("data-lang");
				$.ajax({
					url:"/basedata/getGateWayForDownLod",
					type:"post",
					data:{"mahId":mahId},
					async:false,
					dataType:"json",
					success:function(source){
						$("#sourceCode").children("option").remove();
						$(source).each(function(i,item){
							$("#sourceCode").append("<option value='"+item.receiverCode+"'>"+item.receiverName+"</option>");
						});
						if(source.length==1){
							$.ajax({
								url:"/basedata/getGateAccountAndPasss",
								type:"POST",
								data:{"mahId":mahId,"receiverId":source[0].receiverCode},
								dataType:"json",
								success:function(response){
									$("input[name='userAccount']").val(response[0].senderSecretAccount);
									$("input[name='password']").val(response[0].senderSecretKey);
								}
							});
						}
					}
				});
			});
			$("#sourceCode").on("change",function(){
				$("input[name='userAccount']").val("");
				$("input[name='password']").val("");
				var caseIdCodeSelectIndex = $("#caseIdCode")[0].selectedIndex;
				var mahId = $($("#caseIdCode")[0].options[caseIdCodeSelectIndex]).attr("data-lang");
				if(mahId==0){
					alert("请先选择企业");
					return false;
				}
				var sourceCodeIndex = $("#sourceCode")[0].selectedIndex;
				var sourceCode = $($("#sourceCode")[0].options[sourceCodeIndex]).val();
				$.ajax({
					url:"/basedata/getGateAccountAndPasss",
					type:"POST",
					data:{"mahId":mahId,"receiverId":sourceCode},
					dataType:"json",
					success:function(response){
						$("input[name='userAccount']").val(response[0].senderSecretAccount);
						$("input[name='password']").val(response[0].senderSecretKey);
					}
				});
			});
			$("#imporotProduct").click(function(){
				if(userId==null||userId==""){
					alert("用户信息已过期，请重新登录");
					parent.location.href="/system/login";
					return false;
				}
				if($("input[name='userAccount']").val()==""||$("input[name='password']").val()==""){
					alert("请先配置直报系统登录账户和密码");
					return false;
				}
				
				productDownLoad();
			});
			function productDownLoad(){
				$("#imporotProduct").attr("disabled",true);
				$("#imporotProduct").css({"pointer-events":"none","background-color":"darkgray"});
				$("#feedbackResult").html("");
				$.ajax({
					url:"productDownload.htm",
					type:"post",
					data:{"startDate":$("input[name='receiveTimeStart']").val(),"endDate":$("input[name='receiveTimeEnd']").val(),"zhibaoUserName":$("input[name='userAccount']").val(),"zhibaoPassword":$("input[name='password']").val(),"userId":userId,"caseIdCode":$("#caseIdCode").val()},
					success:function(response){
						$("#imporotProduct").attr("disabled",false);
						$("#imporotProduct").attr("style","");
						console.log(response);
						alert("下载产品成功");
					},error:function(response){
						alert("下载产品出错，请稍后重试");
					}
				});
			}
			laydate.render({elem: '#receiveTimeStart',
							value:new Date(new Date().getTime()-30*24*3600*1000),
							done:function(value,date){
								var endDate = $("#receiveTimeEnd").val();
								if(endDate==null||endDate==""){
								}else{
									if(value>endDate){
										alert("开始时间不能大于结束时间");
										$("#receiveTimeStart").val("");
									}
								}
							}});
			
			laydate.render({elem: '#receiveTimeEnd',
							value:new Date(),
							done:function(value,date){
								var startDate = $("#receiveTimeStart").val();
								if(startDate==null||startDate==""){
								}else{
									if(value<startDate){
										alert("结束时间不能小于开始时间");
										$("#receiveTimeEnd").val("");
									}
								}
							}});
		});
	</script>
</body>
</html>