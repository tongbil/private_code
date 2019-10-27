$(function(){
	
	//添加岗位
	$(".addCharacter").on("click",function(){
		var boxHtml = "";
		boxHtml += "<div class='page-container'>";
		boxHtml += '	<form class="form form-horizontal" id="form-article-add">';
		boxHtml += '		<div class="row cl">';
		boxHtml += '			<div class="col-md-8">';
		boxHtml += '				<div class="row cl">';
		boxHtml += '					<label class="form-label col-md-5"><b>用户姓名<span class="c-red">*</span>：</b></label>';
		boxHtml += "					<div class='col-md-7'>";
		boxHtml += "						<input type='text' class='input-text' name='stationName'>";
		boxHtml += "					</div>";
		boxHtml += "				</div>";
		boxHtml += '				<div class="row cl">';
		boxHtml += '					<label class="form-label col-md-5"><b>登录帐号<span class="c-red">*</span>：</b></label>';
		boxHtml += "					<div class='col-md-7'>";
		boxHtml += "						<input type='text' class='input-text' name='stationName'>";
		boxHtml += "					</div>";
		boxHtml += "				</div>";
		boxHtml += '				<div class="row cl">';
		boxHtml += '					<label class="form-label col-md-5"><b>登录密码：</b></label>';
		boxHtml += "					<div class='col-md-7'>";
		boxHtml += "						<input type='text' class='input-text' name='stationName' placeholder='默认密码为123456'>";
		boxHtml += "					</div>";
		boxHtml += "				</div>";
		boxHtml += '				<div class="row cl">';
		boxHtml += '					<label class="form-label col-md-5"><b>手机号码：</b></label>';
		boxHtml += "					<div class='col-md-7'>";
		boxHtml += "						<input type='text' class='input-text' name='stationName'>";
		boxHtml += "					</div>";
		boxHtml += "				</div>";
		boxHtml += '				<div class="row cl">';
		boxHtml += '					<label class="form-label col-md-5"><b>Email：</b></label>';
		boxHtml += "					<div class='col-md-7'>";
		boxHtml += "						<input type='text' class='input-text' name='stationName'>";
		boxHtml += "					</div>";
		boxHtml += "				</div>";
		boxHtml += '				<div class="row cl">';
		boxHtml += '					<label class="form-label col-md-5"><b>部门：</b></label>';
		boxHtml += "					<div class='col-md-7'>";
		boxHtml += "						<input type='text' class='input-text' name='stationName'>";
		boxHtml += "					</div>";
		boxHtml += "				</div>";
		boxHtml += "			</div>";
		boxHtml += '			<div class="col-md-4">';
		boxHtml += '				<div class="row cl">';
		boxHtml += '					<div class="col-md-12"><b>角色<span class="c-red">*</span>：</b></div>';
		boxHtml += "					<div class='col-md-12'>";
		boxHtml += "						<div class='skin-minimal'>";
		boxHtml += "							<div class='check-box'>";
		boxHtml += "								<input type='checkbox' id='checkbox-1'>";
		boxHtml += "								<label for='checkbox-1'>超级管理员</label>";
		boxHtml += "							</div>";
		boxHtml += "						</div>";
		boxHtml += "					</div>";
		boxHtml += "					<div class='col-md-12'>";
		boxHtml += "						<div class='skin-minimal'>";
		boxHtml += "							<div class='check-box'>";
		boxHtml += "								<input type='checkbox' id='checkbox-2'>";
		boxHtml += "								<label for='checkbox-2'>填报</label>";
		boxHtml += "							</div>";
		boxHtml += "						</div>";
		boxHtml += "					</div>";
		boxHtml += "					<div class='col-md-12'>";
		boxHtml += "						<div class='skin-minimal'>";
		boxHtml += "							<div class='check-box'>";
		boxHtml += "								<input type='checkbox' id='checkbox-3'>";
		boxHtml += "								<label for='checkbox-3'>审核</label>";
		boxHtml += "							</div>";
		boxHtml += "						</div>";
		boxHtml += "					</div>";
		boxHtml += "					<div class='col-md-12'>";
		boxHtml += "						<div class='skin-minimal'>";
		boxHtml += "							<div class='check-box'>";
		boxHtml += "								<input type='checkbox' id='checkbox-3'>";
		boxHtml += "								<label for='checkbox-3'>审核审核审核</label>";
		boxHtml += "							</div>";
		boxHtml += "						</div>";
		boxHtml += "					</div>";
		boxHtml += "					<div class='col-md-12'>";
		boxHtml += "						<div class='skin-minimal'>";
		boxHtml += "							<div class='check-box'>";
		boxHtml += "								<input type='checkbox' id='checkbox-3'>";
		boxHtml += "								<label for='checkbox-3'>审核审核</label>";
		boxHtml += "							</div>";
		boxHtml += "						</div>";
		boxHtml += "					</div>";
		boxHtml += "				</div>";
		boxHtml += "			</div>";
		boxHtml += "		</div>";
		boxHtml += "	</form>";
		boxHtml += "</div>";
		parent.parent.layer.open({
			area: ['640px'],
			title:"用户新增",
			type: 1,
			skin: 'layui-layer-rim', //加上边框
			content: boxHtml,
			success:function(){
				$(parent.parent.document).find(".skin-minimal input").each(function(){
					$(this).iCheck({
						checkboxClass: 'icheckbox-blue',
						radioClass: 'iradio-blue',
						increaseArea: '20%'
					});
				});
			},
			btn:["确定","取消"],
			yes:function(index){
				parent.parent.layer.close(index);
			}
		});
		
		$('.skin-minimal input').iCheck({
			checkboxClass: 'icheckbox-blue',
			radioClass: 'iradio-blue',
			increaseArea: '20%'
		});
	});
	
	
	//datatable表格
	$('.table-sort').dataTable({
		"bStateSave": false, //状态保存
		"bLengthChange":false,
		"searching":false,
		'ordering'  :false,
		"aLengthMenu": [[8, 16, 24, -1], [8, 16, 24, "All"]]
	});
});


function updateInfo(obj){
	var boxHtml = "";
	boxHtml += "<div class='page-container'>";
	boxHtml += '	<form class="form form-horizontal" id="form-article-add">';
	boxHtml += '		<div class="row cl">';
	boxHtml += '			<div class="col-md-8">';
	boxHtml += '				<div class="row cl">';
	boxHtml += '					<label class="form-label col-md-5"><b>用户姓名<span class="c-red">*</span>：</b></label>';
	boxHtml += "					<div class='col-md-7'>";
	boxHtml += "						<input type='text' class='input-text' name='stationName'>";
	boxHtml += "					</div>";
	boxHtml += "				</div>";
	boxHtml += '				<div class="row cl">';
	boxHtml += '					<label class="form-label col-md-5"><b>登录帐号<span class="c-red">*</span>：</b></label>';
	boxHtml += "					<div class='col-md-7'>";
	boxHtml += "						32011288";
	boxHtml += "					</div>";
	boxHtml += "				</div>";
	boxHtml += '				<div class="row cl">';
	boxHtml += '					<label class="form-label col-md-5"><b>登录密码：</b></label>';
	boxHtml += "					<div class='col-md-7'>";
	boxHtml += "						<input type='text' class='input-text' name='stationName' placeholder='默认密码为123456'>";
	boxHtml += "					</div>";
	boxHtml += "				</div>";
	boxHtml += '				<div class="row cl">';
	boxHtml += '					<label class="form-label col-md-5"><b>手机号码：</b></label>';
	boxHtml += "					<div class='col-md-7'>";
	boxHtml += "						<input type='text' class='input-text' name='stationName'>";
	boxHtml += "					</div>";
	boxHtml += "				</div>";
	boxHtml += '				<div class="row cl">';
	boxHtml += '					<label class="form-label col-md-5"><b>Email：</b></label>';
	boxHtml += "					<div class='col-md-7'>";
	boxHtml += "						<input type='text' class='input-text' name='stationName'>";
	boxHtml += "					</div>";
	boxHtml += "				</div>";
	boxHtml += '				<div class="row cl">';
	boxHtml += '					<label class="form-label col-md-5"><b>部门：</b></label>';
	boxHtml += "					<div class='col-md-7'>";
	boxHtml += "						<input type='text' class='input-text' name='stationName'>";
	boxHtml += "					</div>";
	boxHtml += "				</div>";
	boxHtml += "			</div>";
	boxHtml += '			<div class="col-md-4">';
	boxHtml += '				<div class="row cl">';
	boxHtml += '					<div class="col-md-12"><b>角色<span class="c-red">*</span>：</b></div>';
	boxHtml += "					<div class='col-md-12'>";
	boxHtml += "						<div class='skin-minimal'>";
	boxHtml += "							<div class='check-box'>";
	boxHtml += "								<input type='checkbox' id='checkbox-1'>";
	boxHtml += "								<label for='checkbox-1'>超级管理员</label>";
	boxHtml += "							</div>";
	boxHtml += "						</div>";
	boxHtml += "					</div>";
	boxHtml += "					<div class='col-md-12'>";
	boxHtml += "						<div class='skin-minimal'>";
	boxHtml += "							<div class='check-box'>";
	boxHtml += "								<input type='checkbox' id='checkbox-2' checked='checked'>";
	boxHtml += "								<label for='checkbox-2'>填报</label>";
	boxHtml += "							</div>";
	boxHtml += "						</div>";
	boxHtml += "					</div>";
	boxHtml += "					<div class='col-md-12'>";
	boxHtml += "						<div class='skin-minimal'>";
	boxHtml += "							<div class='check-box'>";
	boxHtml += "								<input type='checkbox' id='checkbox-3'>";
	boxHtml += "								<label for='checkbox-3'>审核</label>";
	boxHtml += "							</div>";
	boxHtml += "						</div>";
	boxHtml += "					</div>";
	boxHtml += "					<div class='col-md-12'>";
	boxHtml += "						<div class='skin-minimal'>";
	boxHtml += "							<div class='check-box'>";
	boxHtml += "								<input type='checkbox' id='checkbox-3'>";
	boxHtml += "								<label for='checkbox-3'>审核审核审核</label>";
	boxHtml += "							</div>";
	boxHtml += "						</div>";
	boxHtml += "					</div>";
	boxHtml += "					<div class='col-md-12'>";
	boxHtml += "						<div class='skin-minimal'>";
	boxHtml += "							<div class='check-box'>";
	boxHtml += "								<input type='checkbox' id='checkbox-3'>";
	boxHtml += "								<label for='checkbox-3'>审核审核</label>";
	boxHtml += "							</div>";
	boxHtml += "						</div>";
	boxHtml += "					</div>";
	boxHtml += "				</div>";
	boxHtml += "			</div>";
	boxHtml += "		</div>";
	boxHtml += "	</form>";
	boxHtml += "</div>";
	parent.parent.layer.open({
		area: ['640px'],
		title:"用户编辑",
		type: 1,
		skin: 'layui-layer-rim', //加上边框
		content: boxHtml,
		success:function(){
			$(parent.parent.document).find(".skin-minimal input").each(function(){
				$(this).iCheck({
					checkboxClass: 'icheckbox-blue',
					radioClass: 'iradio-blue',
					increaseArea: '20%'
				});
			});
		},
		btn:["确定","取消"],
		yes:function(index){
			parent.parent.layer.close(index);
		}
	});
}


function delInfo(obj){
	parent.parent.layer.confirm('你确定要删除这个用户吗？', {
		time: 0, //不自动关闭
		btn: ['确定', '取消'],
		icon: 3,
		yes: function(index){
			parent.parent.layer.close(index);
		}
	});
}
