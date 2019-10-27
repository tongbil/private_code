<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>邮箱配置</title>
	<link href="static/akehu/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 columnn">
			<div class="page-header">
				<h1>邮件服务器配置</h1>
			</div>
		</div>
		<form action="" class="form-horizontal col-xs-12">
			<div class="form-group">
				<label for="" class="col-xs-2 control-label">账户：</label>
				<div class="col-xs-9"><input style="width:200px;" type="text" name="mailAccount" class="form-control" id="mailAccount" placeholder="请输入QQ邮箱账户" /></div>
			</div>
			<div class="form-group">
				<label for="" class="col-xs-2 control-label">密码：</label>
				<div class="col-xs-9"><input style="width:200px;" type="password" name="mailPassword" class="form-control" id="mailPassword" placeholder="请输入QQ邮箱授权码" /></div>
			</div>
			<div class="form-group">
				<label for="" class="col-xs-2 control-label">服务器：</label>
				<div class="col-xs-9"><input style="width:200px;" type="text" name="mailHost" class="form-control" id="mailHost" placeholder="请输入QQ邮箱地址" /></div>
			</div>
			<div class="form-group">
				<label for="" class="col-xs-2 control-label">端口号：</label>
				<div class="col-xs-9"><input style="width:200px;" type="text" name="mailPort" class="form-control" id="mailPort" placeholder="请输入QQ邮箱端口号" /></div>
			</div>
			<!-- <div class="form-group">
                <div class="col-xs-5 col-xs-offset-2">
                    <input type="text" id="testAccount" class="form-control" placeholder="请输入测试邮箱地址" />
                </div>
                <div class="col-xs-4" style="float:right">
                    <button class="btn btn-default" type="button" id="testConnection">测试</button>
                    <button class="btn btn-primary" type="button" id="saveMailConfig">保存</button>
                </div>
            </div> -->
		</form>
	</div>
</div>
<script type="text/javascript"src="static/akehu/js/tool/jquery-1.11.0.js" ></script>
<!-- 	<script src="static/jquery/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script> -->
<script src="static/akehu/jsPlugin/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript"
		src="static/akehu/jsPlugin/layer-v3.0.1/layer/layer.js" ></script>
<script type="text/javascript">
		$(function(){
			$.ajax({
				url:"getMailAccept",
				type:"post",
				success:function(data){
					$("input[name='mailAccount']").val(data.emilName);
					$("input[name='mailPassword']").val(data.emilPassword);
					$("input[name='mailHost']").val(data.server);
					$("input[name='mailPort']").val(data.port);
				}
			});
		});

function getInfos(){

	var formData = new FormData();


	formData.append("mailAccount",$("#mailAccount").val());
	formData.append("mailPassword",$("#mailPassword").val());
	formData.append("mailHost",$("#mailHost").val());
	formData.append("mailPort",$("#mailPort").val());

	return formData;

}




$("#saveMailConfig").bind("click",function(){
	$.ajax({
		url:"saveMailAccept",
		type:"post",
		data:{
			"mailAccount":$("#mailAccount").val(),
			"mailPassword":$("#mailPassword").val(),
			"mailHost":$("#mailHost").val(),
			"mailPort":$("#mailPort").val()

		},
		success:function(data){
			layer.alert(data);
		},
	});
});
/* 	$("#testConnection").bind("click",function(){
        var mailToAccount = $("#testAccount").val();
        $.ajax({
            url:"testMailConn.htm",
            type:"post",
            data:{"mailToAccount":mailToAccount},
            success:function(data){
                if(data=="true"){
                    layer.alert("邮件发送成功");
                }else{
                    layer.alert("邮件发送失败");
                }
            }
        });
    }); */
</script>
</body>
</html>