			$(function(){
					$("#ImportAnticipationNeat").click(function(){
						var mahSelect="";
						mahSelect+="<option value='YZJ'>YZJ</option>"
					/*	$.ajax({
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
						});*/
						
						
						
						
						
						var html = "";
						html += "<div class='page-container'>";
						html += "	<form class='form form-horizontal' id='layForm'>";
						html += "		<div class='row cl'>";
						html += "			<label class='form-label col-xs-3'><b>生产厂家:</b></label>";
						html += "				<span class='select-box' style='width:250px'>";
						html +="					<select  class='select' id='neatType'>";
						html +=mahSelect;
						html +="					</select>";
						html +="				</span>";
						html += "		</div>";
						html += "		<div class='row cl'>";
						html += "			<label class='form-label col-xs-3'><b>源文件：</b></label>";
						html += "			<span class='btn-upload form-group'>";
						html +="				<input id='uploadfile-1' class='input-text upload-url' name='uploadfile-1' readonly='' type='text' style='width: 250px;' placeholder='暂只支持07版本的excel文件'>";
						html +="				<input class='input-file' multiple='' id='file-1' name='file-1' type='file' >";
						html +="				<input type='hidden' id='picAddress' name='picAddress' value=''>";
						html +="			</span>";
						html += "		</div>";
						html += "	</form>";
						html += "</div>"; 
						
					
						
						layer.tab({
							area: ['50%', '50%'],
							tab: [{
						    	title: '批次导入', 
								content: html
							} ],
							success:function(index,layero){
								console.log("成功后的回调");
							},
							btn:["导入","取消"],
							yes:function(index,layero){
									var uploadVal=$("#file-1").val();	
									if(uploadVal!=null &&uploadVal!=""){
										var index22 = layer.msg('正在导入数据，请稍后....', {
											icon: 16,
											shade: [0.5,'#000'],
											time:0
										});
									
										$.ajax({
											url:"addAnticipationNeatFromExcl.htm",
											data:{"fileName":$("#picAddress").val(),
												  "mahId":$("#neatType").val()
													},
											type:"post",
											async:false,
											success:function(data){
												console.log("data="+data);
												if(data!=null ||data!=""){
													if(data=="true"||data==true){
														layer.msg("导入成功",{time:1500},function(){
															layer.close(index22);
															layer.close(index);
															window.location.reload();
														});
													}else{
														layer.msg("导入失败",{time:2500},function(){
															layer.close(index22);
														});
													}
												}
											},error:function(e){
								            	layer.close(index22);
								            	alert("错误！！");
								            }
										});
										
									}
							}
						});
						
						
						$(document).on("change",".input-file",function(){
							var uploadVal=$(this).val();	
							console.log("uploadVal="+uploadVal);
							 ok= false;
							if (uploadVal!= '') {
								var houzui=uploadVal.substring(uploadVal.length-4,uploadVal.length);
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
								}
				            }else {
				            	ok = false;
				            	layer.alert("请上传文件");
				            }
							if(ok) {
								$.ajax({
					        	url:"uploadAnticipationNeatExcl",
					            type:"post",
					            data:form,
					            processData:false,
					            contentType:false,
					            success:function(data){
					    			data = JSON.parse(data);
					    			$("#uploadfile-1").val(data.result);
					    			$("#picAddress").val(data.label);
					    			layer.alert(data.resume);
					    		/* 	document.getElementById("importReport").style.display = "inline"; */
					            },
					            error:function(e){
					            	layer.alert("错误！！");
					            }
							}); 
							}
						}); 
						
					});
				});
				