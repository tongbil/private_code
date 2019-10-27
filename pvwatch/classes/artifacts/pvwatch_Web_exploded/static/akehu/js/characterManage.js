$(function(){	
	//添加岗位
	$(".addCharacter").on("click",function(){
		var boxHtml = "";
		boxHtml += "<div class='page-container'>";
		boxHtml += '	<form class="form form-horizontal" id="form-article-add">';
		boxHtml += '		<div class="row cl">';
		boxHtml += '			<label class="form-label col-md-3"><b>角色名称：</b></label>';
		boxHtml += "			<div class='col-md-8'>";
		boxHtml += "				<input type='text' class='input-text' name='stationName'>";
		boxHtml += "			</div>";
		boxHtml += "		</div>";
		boxHtml += '		<div class="row cl">';
		boxHtml += '			<label class="form-label col-md-3"><b>角色描述：</b></label>';
		boxHtml += "			<div class='col-md-8'>";
		boxHtml += "				<textarea class='textarea' name='stationName'></textarea>";
		boxHtml += "			</div>";
		boxHtml += "		</div>";
		boxHtml += "	</form>";
		boxHtml += "</div>";
		parent.parent.layer.open({
			area: ['640px'],
			title:"填角色信息",
			type: 1,
			skin: 'layui-layer-rim', //加上边框
			content: boxHtml,
			btn:["确定","取消"],
			yes:function(index){
				parent.parent.layer.close(index);
			}
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

//编辑
function updateInfo(obj){
	var boxHtml = "";
	boxHtml += "<div class='page-container'>";
	boxHtml += '	<form class="form form-horizontal" id="form-article-add">';
	boxHtml += '		<div class="row cl">';
	boxHtml += '			<label class="form-label col-md-3"><b>角色名称：</b></label>';
	boxHtml += "			<div class='col-md-8'>";
	boxHtml += "				<input type='text' class='input-text' name='stationName' value='超级管理员'>";
	boxHtml += "			</div>";
	boxHtml += "		</div>";
	boxHtml += '		<div class="row cl">';
	boxHtml += '			<label class="form-label col-md-3"><b>角色描述：</b></label>';
	boxHtml += "			<div class='col-md-8'>";
	boxHtml += "				<textarea class='textarea' name='stationName'>超级管理员超级管理员超级管理员</textarea>";
	boxHtml += "			</div>";
	boxHtml += "		</div>";
	boxHtml += "	</form>";
	boxHtml += "</div>";
	parent.parent.layer.open({
		area: ['640px'],
		title:"填角色信息",
		type: 1,
		skin: 'layui-layer-rim', //加上边框
		content: boxHtml,
		btn:["确定","取消"],
		yes:function(index){
			parent.parent.layer.close(index);
		}
	});
}

//菜单
function menulist(obj){
	var boxHtml = '<ul id="treeDemo" class="ztree"></ul>';
	parent.parent.layer.open({
		area: ['440px','90%'],
		title:"菜单设置",
		type: 1,
		skin: 'layui-layer-rim', //加上边框
		content: boxHtml,
		btn:["确定","取消"],
		yes:function(index){
			parent.parent.layer.close(index);
		}
	});
	
	$.fn.zTree.init($("#treeDemo",parent.parent.document), setting, zNodes);
	setCheck();
	$("#py",parent.parent.document).bind("change", setCheck);
	$("#sy",parent.parent.document).bind("change", setCheck);
	$("#pn",parent.parent.document).bind("change", setCheck);
	$("#sn",parent.parent.document).bind("change", setCheck);
}

//人员
function peopleInfo(obj){
	var boxHtml = "";
	boxHtml += "<div class='page-container'>";
	boxHtml += '	<form class="form form-horizontal" id="form-article-add">';
	boxHtml += '		<div class="row cl">';
	boxHtml += '			<label class="form-label col-md-2"><b>用户<span class="c-red">*</span>：</b></label>';
	boxHtml += "			<div class='col-md-10'>";
	boxHtml += "				<div class='skin-minimal'>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-1'>";
	boxHtml += "						<label for='checkbox-1'>超级管理员</label>";
	boxHtml += "					</div>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-2'>";
	boxHtml += "						<label for='checkbox-2'>填报</label>";
	boxHtml += "					</div>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-3'>";
	boxHtml += "						<label for='checkbox-3'>审核</label>";
	boxHtml += "					</div>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-4'>";
	boxHtml += "						<label for='checkbox-4'>审核</label>";
	boxHtml += "					</div>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-5'>";
	boxHtml += "						<label for='checkbox-5'>审核</label>";
	boxHtml += "					</div>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-6'>";
	boxHtml += "						<label for='checkbox-6'>审核</label>";
	boxHtml += "					</div>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-7'>";
	boxHtml += "						<label for='checkbox-7'>审核</label>";
	boxHtml += "					</div>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-8'>";
	boxHtml += "						<label for='checkbox-8'>审核</label>";
	boxHtml += "					</div>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-9'>";
	boxHtml += "						<label for='checkbox-9'>审核</label>";
	boxHtml += "					</div>";
	boxHtml += "				</div>";
	boxHtml += "			</div>";
	boxHtml += "		</div>";
	boxHtml += "	</form>";
	boxHtml += "</div>";
	parent.parent.layer.open({
		area: ['640px'],
		title:"人员设置",
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

//删除
function delInfo(obj){
	parent.parent.layer.confirm('你确定要删除这个角色吗？', {
		time: 0, //不自动关闭
		btn: ['确定', '取消'],
		icon: 3,
		yes: function(index){
			parent.parent.layer.close(index);
		}
	});
}


var setting = {
	view: {
		showIcon: showIconForTree
	},
	check: {
		enable: true
	},
	data: {
		simpleData: {
			enable: true
		}
	}
};

var zNodes =[
	{ id:1, pId:0, name:"随意勾选 1", open:true},
	{ id:11, pId:1, name:"随意勾选 1-1", open:true},
	{ id:111, pId:11, name:"随意勾选 1-1-1"},
	{ id:112, pId:11, name:"随意勾选 1-1-2"},
	{ id:12, pId:1, name:"随意勾选 1-2", open:true},
	{ id:121, pId:12, name:"随意勾选 1-2-1"},
	{ id:122, pId:12, name:"随意勾选 1-2-2"},
	{ id:2, pId:0, name:"随意勾选 2", open:true},
	{ id:21, pId:2, name:"随意勾选 2-1"},
	{ id:22, pId:2, name:"随意勾选 2-2", open:true},
	{ id:221, pId:22, name:"随意勾选 2-2-1"},
	{ id:222, pId:22, name:"随意勾选 2-2-2"},
	{ id:23, pId:2, name:"随意勾选 2-3"}
];

var code;

function setCheck() {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
	py = $("#py").attr("checked")? "p":"",
	sy = $("#sy").attr("checked")? "s":"",
	pn = $("#pn").attr("checked")? "p":"",
	sn = $("#sn").attr("checked")? "s":"",
	type = { "Y":py + sy, "N":pn + sn};
	zTree.setting.check.chkboxType = type;
	showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
}
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}
function showIconForTree(treeId, treeNode) {
	return !treeNode.isParent;
}



function addGroup(obj){
	var cName = obj.parent().parent().children().eq(0).text();
	var groupHtml = "";
	groupHtml += '<div class="page-container s">';
	groupHtml += '	<div class="s1">';
	groupHtml += '		<ul>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="city1" name="groupVal" value="群组1群组1群组1群组1">';
	groupHtml += '					<label for="city1">群组1群组1群组1群组1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="city2" name="groupVal" value="群组1群组1">';
	groupHtml += '					<label for="city2">群组1群组1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="city3" name="groupVal" value="群组1群组1群组1">';
	groupHtml += '					<label for="city3">群组1群组1群组1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="city4" name="groupVal" value="群组1群组1群组1群组1群组1">';
	groupHtml += '					<label for="city4">群组1群组1群组1群组1群组1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="city5" name="groupVal" value="个群组1体群组11">';
	groupHtml += '					<label for="city5">个群组1体群组11</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="city6" name="groupVal" value="群组群组11">';
	groupHtml += '					<label for="city6">群组群组11</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="city7" name="groupVal" value="个群组1群组1体1">';
	groupHtml += '					<label for="city7">个群组1群组1体1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="city8" name="groupVal" value="个群组1群组1体1">';
	groupHtml += '					<label for="city8">个群组1群组1体1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="city9" name="groupVal" value="个群组1群组1体1">';
	groupHtml += '					<label for="city9">个群组1群组1体1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="city0" name="groupVal" value="个群组1群组1体1">';
	groupHtml += '					<label for="city0">个群组1群组1体1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="city11" name="groupVal" value="个群组1群组1体1">';
	groupHtml += '					<label for="city11">个群组1群组1体1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="city12" name="groupVal" value="个群组1群组1体1">';
	groupHtml += '					<label for="city12">个群组1群组1体1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '		</ul>';
	groupHtml += "	</div>";
	groupHtml += '	<div class="s2">';
	groupHtml += '		<input class="btn btn-primary size-MINI radius" type="button" onclick="addInfo()" value=">>" title="添加"><br />';
	groupHtml += '		<input class="btn btn-default size-MINI radius mt-10" type="button" onclick="removeInfo()" value="<<" title="移除">';
	groupHtml += "	</div>";
	groupHtml += '	<div class="s3">';
	groupHtml += '		<ul>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="citya" name="groupVal" value="群组1群组1群组1群组1">';
	groupHtml += '					<label for="citya">群组1群组1群组1群组1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="cityb" name="groupVal" value="群组1群组1">';
	groupHtml += '					<label for="cityb">群组1群组1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '			<li class="skin-minimal cl">';
	groupHtml += '				<div class="check-box">';
	groupHtml += '					<input type="checkbox" id="cityc" name="groupVal" value="群组1群组1群组1">';
	groupHtml += '					<label for="cityc">群组1群组1群组1</label>';
	groupHtml += '				</div>';
	groupHtml += '			</li>';
	groupHtml += '		</ul>';
	groupHtml += "	</div>";
	groupHtml += '	<span class="cl"></span>';
	groupHtml += "</div>";
	
	layer.open({
		area: ['90%', '90%'],
		title:cName,
		type: 1,
		move:true,
		skin: 'layui-layer-rim', //加上边框
		content: groupHtml,
		btn:["确定","取消"],
		yes:function(index){
			layer.close(index);
		}
	});
	$('.s1 .skin-minimal input,.qt .skin-minimal input,.s3 .skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
}




//个人用户往右侧添加
function addInfo(){
	var html = "";
	$("input[name='groupVal']").each(function(){
		if($(this).is(":checked")){
			html += '<li class="skin-minimal cl">';
			html += '	<div class="check-box">';
			html += '		<input type="checkbox" id="'+$(this).attr("id")+'" name="resultInfo" value="'+$(this).val()+'">';
			html += '		<label for="'+$(this).attr("id")+'">'+$(this).val()+'</label>';
			html += '	</div>';
			html += '</li>';
			$(this).parent().parent().parent().remove();
		}
	});
	$(".s3 ul").append(html);
	$('.s3 .skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
}

//个人用户右侧删除添加到左侧
function removeInfo(){
	var html = "";
	$("input[name='resultInfo']").each(function(){
		if($(this).is(":checked")){
			html += '<li class="skin-minimal cl">';
			html += '	<div class="check-box">';
			html += '		<input type="checkbox" id="'+$(this).attr("id")+'" name="groupVal" value="'+$(this).val()+'">';
			html += '		<label for="'+$(this).attr("id")+'">'+$(this).val()+'</label>';
			html += '	</div>';
			html += '</li>';
			$(this).parent().parent().parent().remove();
		}
	});
	$(".s1 ul").append(html);
	$('.s1 .skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
}
