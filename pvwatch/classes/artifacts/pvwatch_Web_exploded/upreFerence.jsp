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
</style>

<title>查询</title>
</head>

<body>	
	<input id="temp" type="hidden" value="ukeys"/>
	
			<div class="text-l pd-20 bg-1 bk-gray radius">
				企业：<select  style="width:200px;" class="input-text" id="evBatch-code"  >		
								<option  value="lizhu">lizhu</option>
								<option value="YZJ">YZJ</option>
					</select>&nbsp;
					通用名称：<select   style="width:120px;" class="input-text" id="genericFunction" ></select>&nbsp;
					组成成分：<select   style="width:120px;" class="input-text" id="zccf" ></select>&nbsp;
					不良反应名称：<select   style="width:120px;" class="input-text" id="blName" ></select>&nbsp;
				 <input type="hidden"  id="ids"/>
				  <input type="hidden"  id="userid"/>
			<div class="cl mt-20"> 
		
					
				
				
					<div class="col-md-12 col-xs-12">
						<div class="form-group">
							<!-- <label style="margin-bottom: 5px;" for="detailInfo" >文档内容</label> -->
						<script id="editor"  type="text/plain" style="width:100%;height:200px;display:block" name="helpPageContent"></script>
						</div>
					</div>		
					<span class="l">
					<!-- <a href="javascript:void(0);"  onclick="update(-1);" class="btn btn-primary "><i class="Hui-iconfont">&#xe600;</i> 录入</a> -->
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
 	$(document).ready(function() {
		/*  getSession();
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
					    			if(companyValue[o].caseIDCode == ${list}.items[0][0]){
					    				mahSelect+="<option selected value="+companyValue[o].caseIDCode+">"+companyValue[o].companyFullName+"</option>";
					    			}
									mahSelect+="<option value="+companyValue[o].caseIDCode+">"+companyValue[o].companyFullName+"</option>";
					    		}
					    			$("#userid").val(companyValue[0].userId);
									$("#evBatch-code").html(mahSelect);
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
		
	});
	 
	
	
	var ue ;
	$(function(){
		ue= UE.getEditor('editor', {
			toolbars: [
				['anchor', //锚点
			        'undo', //撤销
			        'redo', //重做
			        'bold', //加粗
			        'indent', //首行缩进
			        'snapscreen', //截图
			        'italic', //斜体
			        'underline', //下划线
			        'strikethrough', //删除线
			        'subscript', //下标
			        'fontborder', //字符边框
			        'superscript', //上标
			        'formatmatch', //格式刷
			        'source', //源代码
			        'blockquote', //引用
			        'pasteplain', //纯文本粘贴模式
			        'selectall', //全选
			        'print', //打印
			        'preview', //预览
			        'horizontal', //分隔线
			        'removeformat', //清除格式
			        'time', //时间
			        'date', //日期
			        'unlink', //取消链接
			        'insertrow', //前插入行
			        'insertcol', //前插入列
			        'mergeright', //右合并单元格
			        'mergedown', //下合并单元格
			        'deleterow', //删除行
			        'deletecol', //删除列
			        'splittorows', //拆分成行
			        'splittocols', //拆分成列
			        'splittocells', //完全拆分单元格
			        'deletecaption', //删除表格标题
			        'inserttitle', //插入标题
			        'mergecells', //合并多个单元格
			        'deletetable', //删除表格
			        'cleardoc', //清空文档
			        'insertparagraphbeforetable', //"表格前插入行"
			        'insertcode', //代码语言
			        'fontfamily', //字体
			        'fontsize', //字号
			        'paragraph', //段落格式
			        'simpleupload', //单图上传
			        'insertimage', //多图上传
			        'edittable', //表格属性
			        'edittd', //单元格属性
			        'link', //超链接
			        'emotion', //表情
			        'spechars', //特殊字符
			        'searchreplace', //查询替换
			        'map', //Baidu地图
			        'gmap', //Google地图
			        'insertvideo', //视频
			        'help', //帮助
			        'justifyleft', //居左对齐
			        'justifyright', //居右对齐
			        'justifycenter', //居中对齐
			        'justifyjustify', //两端对齐
			        'forecolor', //字体颜色
			        'backcolor', //背景色
			        'insertorderedlist', //有序列表
			        'insertunorderedlist', //无序列表
			        'fullscreen', //全屏
			        'directionalityltr', //从左向右输入
			        'directionalityrtl', //从右向左输入
			        'rowspacingtop', //段前距
			        'rowspacingbottom', //段后距
			        'pagebreak', //分页
			        'insertframe', //插入Iframe
			        'imagenone', //默认
			        'imageleft', //左浮动
			        'imageright', //右浮动
			        'attachment', //附件
			        'imagecenter', //居中
			        'wordimage', //图片转存
			        'lineheight', //行间距
			        'edittip ', //编辑提示
			        'customstyle', //自定义标题
			        'autotypeset', //自动排版
			        'webapp', //百度应用
			        'touppercase', //字母大写
			        'tolowercase', //字母小写
			        'background', //背景
			        'template', //模板
			        'scrawl', //涂鸦
			        'music', //音乐
			        'inserttable', //插入表格
			        'drafts', // 从草稿箱加载
			        'charts', // 图表
				]
			],
			wordCount:false,
			elementPathEnabled : false
		});	
		
		/* $('#datetimepickers').datetimepicker({}); */
		
			
		});
	$(function(){
		/* var testlist = ${list};
		testlist = eval(testlist); */
		
		//先获取当前的数据
		//selectRefone(${obj});
		/*  $("#testcon").append(${list}.items[0][5]);
		   window.setTimeout(setContent,1000);
		   function setContent(){
			    UE.getEditor('editor').execCommand('insertHtml', $('#testcon').html());
			 } 	   */ 
		   
		
		if(${list}.items[0][0] !=null && ${list}.items[0][0] !="" && ${list}.items[0][0] !="null"){
			 $("#evBatch-code").val(${list}.items[0][0]);
		}
			
			 $("#ids").val(${list}.items[0][1]);
		tyName(-1);
		zc();
		blfy(-1);
		
	});
	
	$(function(){
			//百度富文本框回显
			if(${list}.items[0][5] !=null && ${list}.items[0][5] !=""){
				$("#temp").val(${list}.items[0][5]);
				var content=UE.getEditor('editor');
				
				 content.ready(function(){
					content.setContent($("#temp").val()); 
				 });
				
			}
		
	
		
		
	});
/*      function selectRefone(obj){
	 		$.ajax({
	 			url:"selectRefone",
	 			type:'post',
	 			data:{
	 				obj:obj,
	 			},
	 			success:function(data){
	 				data = JSON.parse(data);
	 				
	 				$("#evBatch-code").val(data.items[0][0]);
	 				
	 				
	 				
	 			     //根据值让option选中 
	 			     $("#genericFunction option[value='"+data.items[0][2]+"']").attr("selected","selected"); 
	 			    $("#zccf option[value='"+data.items[0][8]+"']").attr("selected","selected"); 
	 			     
	 				
	 				
	 				$("#blName").val(data.items[0][4]);
	 				$("#blName").find("option:selected").text(data.items[0][4]);
	 				
	 				
	 			}
	 		
	 		});
     } */
     
	//组成成分
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
				 		if(${list}.items[0][8] == data.items[i] ){
				 			option += '<option selected value="'+data.items[i]+'">'+data.items[i]+'</option>';
				 		}else{
				 			 option += '<option value="'+data.items[i]+'">'+data.items[i]+'</option>';
				 		}
				 	
				 		
				 	}
				 	$("#zccf").html(option);
				}
			}
		});
	}		
	
		
	$("#evBatch-code").change(function(){				
		var  comPany =$("#evBatch-code").val();
	
		tyName(comPany);
	});	
	$("#genericFunction").change(function(){				
		var  comPany =$("#genericFunction").val();
		blfy(comPany);
	});	
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
									
								if(data.items.length>0){
								 	for(var i=0;i<data.items.length;i++){	
								 		 if(${list}.items[0][2] == data.items[i][0] ){
								 			 option += '<option selected value="'+data.items[i][1]+'">'+data.items[i][0]+'</option>';
								 		}else{
								 			 option += '<option value="'+data.items[i][1]+'">'+data.items[i][0]+'</option>';
								 		}
								 		 
								 	
								 	
								 	}
								 	$("#genericFunction").html(option);
								}
								}
									
							}
								
							});
					}
	//获取不良反应名称
	function blfy(obj){		
		
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
			 		if(${list}.items[0][3] == data.items[i][1]){
			 			 option += '<option  selected value="'+data.items[i][2]+'">'+data.items[i][1]+'</option>';
			 		}else{
			 			 option += '<option value="'+data.items[i][2]+'">'+data.items[i][1]+'</option>';
			 		}
			 	
			 	
			 	}
				$("#blName").html(option);
			}
			}
				
		}
			
		});
}		
			function getInfo(){
			var formData = new FormData();
			var content = ue.getContent();
			
		
			
			
			
			formData.append("content",content);			
			formData.append("genericFunction",$("#genericFunction").find("option:selected").text());
			formData.append("zccf",$("#zccf").val());
			formData.append("blNameCode",$("#blName").val());		
			formData.append("blName",$("#blName").find("option:selected").text());			
			formData.append("zhujian",$("#ids").val());		
			alert($("#ids").val());
		/* 	formData.append("userid",$("#userid").val()); */
		formData.append("userid",1);
			
				return formData;
			}
	
	

	</script>
</body>
</html>