<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<!--+" "+ data.items[i].manufactureTime.hours+":"+data.items[i].manufactureTime.minutes+":"+data.items[i].manufactureTime.seconds  -->
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link href="static/akehu/jsPlugin/icheck/icheck.css" rel="stylesheet" type="text/css">
    <link href="static/akehu/mainFile/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css">
    <link href="static/akehu/mainFile/h-ui.admin/css/H-ui.admin.css" rel="stylesheet" type="text/css">
    <link href="static/akehu/jsPlugin/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css">
    <link href="static/akehu/css/groupManage.css" rel="stylesheet" id="skin" type="text/css">
    <link href="static/akehu/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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
    }</style>
    <title>文件上传</title></head>
   <div class='row cl'>
   								<form class='form form-horizontal' id='layForm'>
									<label class='form-label col-xs-3'><b>源文件：</b></label>
									<span class='btn-upload form-group'>
										<input id='uploadfile-1' class='input-text upload-url' name='uploadfile-1' readonly='' type='text' style='width: 250px;'>
									<input class='input-file' multiple='' id='file-1' name='file-1' type='file' >
										<input type='hidden' id='picAddress' name='picAddress' value=''>
									</span>
								</div>
								</form>
								<input  type="button" value="下载"  onclick="down()"/>
<body>

<script type="text/javascript" src="static/akehu/js/tool/jquery-1.11.0.js"></script>
<script src="static/akehu/jsPlugin/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js"></script>
<script type="text/javascript" src="static/akehu/jsPlugin/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="static/akehu/mainFile/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/akehu/mainFile/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="static/akehu/jsPlugin/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="static/akehu/jsPlugin/layer-v3.0.1/layer/layer.js"></script>
<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js"></script>
<script type="text/javascript" src="static/akehu/jsPlugin/datePicker/WdatePicker.js"></script>
<script type="text/javascript">
 
	 function down(){
	       location.href = "http://localhost:8080/pvwatch/downloadFile.htm?fileId=2";
	   }


$(document).on("change",".input-file",function(){
	var uploadVal=$(this).val();	
	var file=$("#file-1")[0].files[0];
	console.log("uploadVal="+uploadVal);
	 ok= false;
	if (uploadVal!= '') {
		/* var houzui=uploadVal.substring(uploadVal.length-4,uploadVal.length);
		 if(houzui=="xlsx"){
			layer.msg("请上传07版本的excel文件!");
			 ok = false;
			return false;
		}else{
			  var reg = /^.*\.(?:xls|xlsx)$/i;//文件名可以带空格
			  if (!reg.test(uploadVal)) {//校验不通过
                    layer.alert("请上传excel格式的文件!");
                    ok = false;
                    return;
                }else {
                	ok = true;
                	$(this).parent().find(".upload-url").val(uploadVal).focus().blur();
					 form = new FormData(document.getElementById("layForm"));
                }
		}  */
		ok = true;
    	$(this).parent().find(".upload-url").val(uploadVal).focus().blur();
    	var formData = new FormData();
    	formData.append("file",file);
    }else {
    	ok = false;
    	layer.alert("请上传文件");
    }
	if(ok) {
		$.ajax({
    	url:"testUpload",
        type:"post",
        data:formData,
        processData:false,
        contentType:false,
        success:function(data){
			
		/* 	document.getElementById("importReport").style.display = "inline"; */
        },
        error:function(e){
        	layer.alert("错误！！");
        }
	}); 
	}
	}); 
	 </script>
</body>
</html>