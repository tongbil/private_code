$(function(){
	//checkBox 样式js
	$("table input").iCheck({
		checkboxClass: 'icheckbox-green',
		increaseArea: '20%'
	});
	
	//添加群组
	$(".addGroup").click(function(){
		//群组信息
		var groupHtml = "";
		groupHtml += '<div class="page-container s">';
		groupHtml += '	<div class="row cl">';
		groupHtml += '		<div class="col-md-2 text-r" style="padding:3px 0 0 0;">群组名称：</div>';
		groupHtml += '		<div class="col-md-10"><input type="text" class="input-text" value="" placeholder="请输入群组名称" name="" style="width:400px"></div>';
		groupHtml += '	</div>';
		groupHtml += '	<div class="s1 mt-20">';
		groupHtml += '		<p><input type="text" class="input-text" value="" placeholder="请输入关键字搜索" name=""></p>';
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
		groupHtml += '	<div class="s2 mt-20">';
		groupHtml += '		<input class="btn btn-primary size-MINI radius" type="button" onclick="addInfo()" value=">>" title="添加"><br />';
		groupHtml += '		<input class="btn btn-default size-MINI radius mt-10" type="button" onclick="removeInfo()" value="<<" title="移除">';
		groupHtml += "	</div>";
		groupHtml += '	<div class="s3 mt-20">';
		groupHtml += '		<ul>';
		groupHtml += '		</ul>';
		groupHtml += "	</div>";
		groupHtml += '	<span class="cl"></span>';
		groupHtml += "</div>";
		
		layer.open({
			area: ['700px', '570px'],
			title:"创建群组",
			type: 1,
			skin: 'layui-layer-rim', //加上边框
			content: groupHtml,
			btn:["确定","取消"],
			yes:function(index){
				var valStrR = "";
//				$("input[name='cityValTitle']").each(function(){
//					if($(this).is(":checked")){
//						if(valStrR==""){
//							valStrR = $(this).val();
//						}else{
//							valStrR = valStrR + "," + $(this).val();
//						}
//					}
//				});
				layer.close(index);
			}
		});
		$('.s1 .skin-minimal input,.qt .skin-minimal input').iCheck({
			checkboxClass: 'icheckbox-blue',
			radioClass: 'iradio-blue',
			increaseArea: '20%'
		});
	});
	
	//datatable表格
	$('.table-sort').dataTable({
		"aaSorting": [
			[1, "desc"]		//默认第几个排序
		], 
		"bStateSave": true, //状态保存
		"aoColumnDefs": [
			{ "orderable": false, "aTargets": [0, 7] } // 制定列不参与排序
		]
	});
});



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