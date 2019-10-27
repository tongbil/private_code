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
    <title>查询d</title></head>
<body>
<div class="page-container" style="padding: 10px 10px 50px 10px;background: #FFFFFF;">
   

        <button onclick="conditions(1)" class="btn btn-success radius" type="button" style="float:right;"><i class="Hui-iconfont">&#xe665;</i> 收取邮件</button>
  
   
						<div class="mt-15" style="float:left;width: 15%;">
							<ul class="glvq" >
						
								<ol style="border-bottom: 1px solid rgb(204, 204, 204);margin-top:28px; ">
									<a onclick="conditions(10);" href="javascript:void(0);"><i></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;未读</a>
								</ol>
								
								<ol style="border-bottom: 1px solid rgb(204, 204, 204);">
									<a onclick="conditions(20);" href="javascript:void(0);"  ><i></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已读</a>
								</ol>
								
								<ol style="border-bottom: 1px solid rgb(204, 204, 204);">
									<a onclick="conditions(30);"  href="javascript:void(0);"  ><i></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已录入</a>
								</ol>
								
		
								<ol style="border-bottom: 1px solid rgb(204, 204, 204);">
									<a onclick="conditions(2);" href="javascript:void(0);" ><i></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;回收站</a>
								</ol>
							
								<ol style="border-bottom: 1px solid rgb(204, 204, 204);">
									<!-- <button style="float:right" class="btn btn-primary" type="button" id="saveMailConfig">菜单</button>	 -->						
									<a id="saveMailConfig"  href="javascript:void(0);" ><i></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮箱账户</a>
								</ol>
							</ul>
						</div>
		
					
    
    
    <div class="mt-15" id="allInfo" style="float:left;width: 75%;margin-left: 70px;">
  
    </div>
    <input  id="userid" type="hidden"/>
    <input  id="userName" type="hidden"/>
</div>
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
	$(document).ready(function() {
		  
	    /* 	$(function(){
				$.ajax({
					url:"getMailAccept",
					type:"post",
					async:false,
					success:function(data){
						$("input[name='mailAccount']").val(data.emilName);
						$("input[name='mailPassword']").val(data.emilPassword);
						$("input[name='mailHost']").val(data.server);
						$("input[name='mailPort']").val(data.port);
					}
				});
			}); */
			//getCurrentUser();
			conditions(10);
	 });
	/* $("#saveMailConfig").bind("click",function(){
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
	}); */



		$("#saveMailConfig").bind("click",function(){
			layer.open({
				area: ['600px','420px'],
				title:"配置",
				type: 2,
				skin: 'layui-layer-rim', //加上边框
				content:'mailConfig.htm',
				btn:["确定","取消"],
				yes:function(index,layero){			
					
					var formData1=$(layero).find("iframe")[0].contentWindow.getInfos();
					//console.log(formData1);
					$.ajax({
						url:"saveMailAccept",
						type:'post',
						data:formData1,
						processData:false,
		                contentType: false,
						success:function(data){
							layer.alert('配置成功');
							layer.close(index);
							conditions(10);
						},
					});
				}
			});
		});

	 
	function getCurrentUser(){
		$.ajax({
			url :  "../../system/getSession",
		    type:"post",
		    async:false,
		    success:function(data){
		    	if(data!=null&&data!=undefined&&data!="null"&&data!=""){
		    		data = JSON.parse(data);
			    	if(data.companyInfo!=null && data.companyInfo!=""){
			    		$("#userid").val(data.userId);
			    		$("#userName").val(data.realName);
			    		
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
	 function conditions(obj){
	     if(obj == "10") {
	            var sli = "";
	            sli +='<table  class="table table-border table-bordered table-bg table-hover table-sort">';
	            sli +='<thead><tr class="text-c">';
	            sli +='<th style="height: 35px;width: 154px;">发件人</th>';
	            sli +='<th style="height: 35px; width: 180px;">标题</th>';
	         
	            sli +='<th style="height: 35px; width: 136px;">时间↓</th>';
	          //  sli +='<th width="100">操作</th>';
	            sli +='	</tr></thead>';
	            sli +='<tbody id="viewReport">';
	            $.ajax({
	                url:"localMail",
	                type:"post",
	                async:false,
	                data:{
	                  
	                    userId:"1"
	                },
	                success: function(data){
	                    if(data!=null&&data!="null"&&data!=""){
	                        data = JSON.parse(data);
	                      //  console.log(data);
	                        if(data.items.length>0) {
	                            for(var i=0;i<data.items.length;i++) {
	                                sli +='<tr class="text-c" ondblclick="update('+data.items[i].id+')">';
	                                sli +='<td style="font-weight:bold">'+data.items[i].fName+'</td>';
	                                sli +='<td style="font-weight:bold">'+data.items[i].title+'</td>';
	                               
	                                sli +='<td style="font-weight:bold">'+data.items[i].time+'</td>';
	                            //    sli +='<td class="td-manage">';
	                            //    sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="编辑" onclick="update('+data.items[i].id+')"><i class="Hui-iconfont">&#xe6df;</i></a>';
	                            //    sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="删除" onclick="del('+data.items[i].id+')"><i class="Hui-iconfont">&#xe6e2;</i></a>';
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
	        }else if(obj == "20"){
	        	 /*   sli +='<th style="height: 35px; width: 180px;">状态</th>'; */
	            var sli = "";
	            sli +='<table  class="table table-border table-bordered table-bg table-hover table-sort">';
	            sli +='<thead><tr class="text-c">';
	            sli +='<th style="height: 35px;width: 124px;">发件人</th>';
	            sli +='<th style="height: 35px; width: 150px;">标题</th>';
	         
	            sli +='<th style="height: 35px; width: 42px;">时间↓</th>';
	            
	            sli +='<th style="height: 35px; width: 42px;">收件时间</th>';
	            sli +='<th style="height: 35px; width: 42px;">收件人</th>';
	            
	          //  sli +='<th width="100">操作</th>';
	            sli +='	</tr></thead>';
	            sli +='<tbody id="viewReport">';
	            $.ajax({
	                url:"oldReader",
	                type:"post",
	                data:{
	                   
	                    userId:"1"
	                },
	                success: function(data){
	                    if(data!=null&&data!="null"&&data!=""){
	                        data = JSON.parse(data);
	                      //  console.log(data);
	                        if(data.items.length>0) {
	                            for(var i=0;i<data.items.length;i++) {
	                                sli +='<tr class="text-c" ondblclick="update('+data.items[i].id+')">';
	                                sli +='<td>'+data.items[i].fName+'</td>';
	                                sli +='<td>'+data.items[i].title+'</td>';
	                             
	                                sli +='<td>'+data.items[i].time+'</td>';
	                                sli +='<td>'+data.items[i].sjTime+'</td>';
	                                sli +='<td>'+data.items[i].sjUser+'</td>';
	                            //    sli +='<td class="td-manage">';
	                            //    sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="编辑" onclick="update('+data.items[i].id+')"><i class="Hui-iconfont">&#xe6df;</i></a>';
	                            //    sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="删除" onclick="del('+data.items[i].id+')"><i class="Hui-iconfont">&#xe6e2;</i></a>';
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
	        	
	        }else if(obj == '30'){
	        	  var sli = "";
	              sli +='<table  class="table table-border table-bordered table-bg table-hover table-sort">';
	              sli +='<thead><tr class="text-c">';
	              sli +='<th style="height: 35px;width: 50px;">发件人</th>';
	              sli +='<th style="height: 35px; width: 50px;">标题</th>';
	              sli +='<th style="height: 35px; width: 50px;">报告编码</th>';
	              sli +='<th style="height: 35px; width: 42px;">时间↓</th>';
	              sli +='<th style="height: 35px; width: 42px;">收件时间</th>';
	              sli +='<th style="height: 35px; width: 42px;">收件人</th>';
	              sli +='<th style="height: 35px; width: 42px;">录入人</th>';
	              sli +='<th style="height: 35px; width: 42px;">录入时间</th>';
	              
	            //  sli +='<th width="100">操作</th>';
	              sli +='	</tr></thead>';
	              sli +='<tbody id="viewReport">';
	              $.ajax({
	                  url:"srMail",
	                  type:"post",
	                  data:{
	                     
	                      userId:$("#userName").val()
	                  },
	                  success: function(data){
	                      if(data!=null&&data!="null"&&data!=""){
	                          data = JSON.parse(data);
	                        //  console.log(data);
	                          if(data.items.length>0) {
	                              for(var i=0;i<data.items.length;i++) {
	                                  sli +='<tr class="text-c" ondblclick="updateReport('+data.items[i].id+','+data.items[i].reportId+')">';
	                                  sli +='<td>'+data.items[i].fName+'</td>';
	                                  sli +='<td>'+data.items[i].title+'</td>';
	                                  sli +='<td><a onclick="seeBg('+data.items[i].id+','+data.items[i].reportId+')" href="javascript:void(0);">'+data.items[i].bgCode+'</a></td>';
	                               
	                                  sli +='<td>'+data.items[i].time+'</td>';
	                                  sli +='<td>'+data.items[i].sjTime+'</td>';
	                                  sli +='<td>'+data.items[i].sjUser+'</td>';
	                                  sli +='<td>'+data.items[i].srUser+'</td>';
	                                  sli +='<td>'+data.items[i].srTime+'</td>';
	                              //    sli +='<td class="td-manage">';
	                              //    sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="编辑" onclick="update('+data.items[i].id+')"><i class="Hui-iconfont">&#xe6df;</i></a>';
	                              //    sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="删除" onclick="del('+data.items[i].id+')"><i class="Hui-iconfont">&#xe6e2;</i></a>';
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
	        }else if(obj == '1'){
	        	var index = layer.msg('正在收取邮件，请稍后....', {
					icon: 16,
					shade: [0.5,'#000'],
					time:0
				});
	                 $.ajax({
	                     url:"selectMail",
	                     type:"post",
	                     data:{
	                        
	                         userId:"1",
	                         userName:$("#userName").val()
	                     },
	                     success: function(data){
	                         if(data!=null&&data!="null"&&data!=""){
	                             data = JSON.parse(data);
	                            // console.log("?")
	                          // console.log(data);
	                             if(data.items.length>0) {
	                            	 layer.close(index);
	                            	 alert("收取成功");
	                            	 conditions("10");
	                             }else {
	                            	 alert("邮件箱暂无最新未读邮件")
	                            	 layer.close(index);
	                            	 conditions("10");
	                             }
	                         }
	                     }
	                 });
	            
	            
	     }else if (obj == '2'){
	         var sli = "";
	         sli +='<table class="table table-border table-bordered table-bg table-hover table-sort">';
	         sli +='<thead><tr class="text-c">';
	         sli +='<th style="height: 35px;width: 80px;">发件人</th>';
	         sli +='<th style="height: 35px; width: 100px;">标题</th>';
	         sli +='<th style="height: 35px; width: 100px;">删除理由</th>';
	         sli +='<th style="height: 35px; width: 78px;">时间↓</th>';
	         sli +='<th style="height: 35px; width: 50px;">收件时间</th>';
	         sli +='<th style="height: 35px; width: 50px;">操作人</th>';
	        // sli +='<th width="100">操作</th>';
	         sli +='	</tr></thead>';
	         sli +='<tbody id="viewReport">';
	         $.ajax({
	             url:"hsMail",
	             type:"post",
	             data:{
	            
	                 userId:"1"
	             },
	             success: function(data){
	                 if(data!=null&&data!="null"&&data!=""){
	                     data = JSON.parse(data);
	                     // console.log(data);
	                     if(data.items.length>0) {
	                         for(var i=0;i<data.items.length;i++) {
	                             sli +='<tr class="text-c" ondblclick="updateDel('+data.items[i].id+')">';
	                             sli +='<td>'+data.items[i].fName+'</td>';
	                             sli +='<td>'+data.items[i].title+'</td>';
	                             sli +='<td>'+data.items[i].delWhy+'</td>';
	                             sli +='<td>'+data.items[i].time+'</td>';
	                             sli +='<td>'+data.items[i].sjTime+'</td>';
	                             sli +='<td>'+data.items[i].ljUser+'</td>';
	                           //  sli +='<td class="td-manage">';
	                          //   sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="编辑" onclick="update('+data.items[i].id+')"><i class="Hui-iconfont">&#xe6df;</i></a>';
	                         //    sli +='<a style="text-decoration:none" class="ml-5" href="javascript:;" title="删除" onclick="del('+data.items[i].id+')"><i class="Hui-iconfont">&#xe6e2;</i></a>';
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
	 }
	//查看回收站邮件
	function updateDel(obj){
	    layer.open({
	        area: ['900px','450px'],
	        title:"查看",
	        type: 2,
	        skin: 'layui-layer-rim', //加上边框
	        content:'emailJump?id='+obj,
	        btn:["恢复","取消"],
	        yes:function(index,layero){
	        	 $.ajax({
	                 url: "updateDel",
	                 type: 'post',
	                 data:{"id":obj},
	                 success: function(data){
	                     if(data!=null && data!=""&&data!="null"){
	                         data = JSON.parse(data);
	                         if(data.result == 'true'){
	                             layer.alert('恢复成功');
	                             layer.close(index);
	                            
	                         }else{
	                             layer.alert(恢复失败);
	                         }
	                     }
	                 }
	             });
	              
	        }
	    });

	};

	//a链接查看报告
	function seeBg(obj,reportId){
		 window.open("Srport.htm?reportId="+reportId+"&emailId="+obj); 
	}
	//查看报告
	function updateReport(obj,reportId){
	    layer.open({
	        area: ['100%','100%'],
	        title:"查看",
	        type: 2,
	        skin: 'layui-layer-rim', //加上边框
	        content:'emailJump?id='+obj,
	      //  btn:["查看报告","取消"],
	       	btn:["关闭","删除"],
	        yes:function(index,layero){
	        	
	        		//console.log(reportId);
	        	  //  window.open("Srport.htm?reportId="+reportId+"&emailId="+obj); 
	        	  layer.close(index);
	              
	        },btn2: function(index,layero){
	            deleteKs(obj);
	            //  console.log("删除")
	          }
	    });

	};

	//查看邮件
	function update(obj){
	    layer.open({
	        area: ['100%','100%'],
	        title:"查看",
	        type: 2,
	        skin: 'layui-layer-rim', //加上边框
	        content:'emailJump?id='+obj,
	        btn:["录入","删除"],
	        yes:function(index,layero){
	       	 var formData1=$(layero).find("iframe")[0].contentWindow.getInfo();
	            var as=formData1.get("as");
	            if(as == "0"){
	               alert("没有文件")
	                return false;
	            }else{
	                var formData1=$(layero).find("iframe")[0].contentWindow.getInfo();
	                var emailId=formData1.get("emailId");
	               // console.log(emailId+">>>>>>>");
	               //弹窗开始》》》》》》》》》		
	            window.open("Srport.htm?emailId="+emailId); 
	               
	               	
	               	 
	               		 //》》》》弹窗结束
	            }     
	              
	        },btn2: function(index,layero){
	            deleteKs(obj);
	          //  console.log("删除")
	        }
	    });

	};
	 
	 //删除跳弹窗
	 function deleteKs(obj){
	     layer.prompt({
	         formType: 2,
	         placeholder: '输入删除原因',
	         title: '请输入删除原因',
//	                 area: ['800px', '350px'] //自定义文本域宽高
	     }, function(value, index, elem){

	             //   alert(value); //得到value
	         del(value,obj);
	         layer.close(index);
	     });
	 }

	 //删除
	 function del(value,obj){
	     $.ajax({
	         url: "delEmail",
	         type: 'post',
	         data:{"id":obj,"value":value,"userId":$("#userName").val()},
	         success: function(data){
	             if(data!=null && data!=""&&data!="null"){
	                 data = JSON.parse(data);
	                 if(data.result == 'true'){
	                     layer.alert('删除成功');
						
	                     conditions("0")
	                 }
	                 else{
	                     layer.alert(删除失败);
	                 }
	             }
	         }
	     });
	 }
	 </script>
</body>
</html>