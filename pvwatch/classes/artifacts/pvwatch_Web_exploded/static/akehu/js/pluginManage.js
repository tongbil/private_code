$(function(){
	//添加岗位
	$(".addGroup").click(function(){
		var boxHtml = "";
		boxHtml += "<div class='page-container'>";
		boxHtml += '	<form class="form form-horizontal" id="form-article-add">';
		boxHtml += '		<div class="row cl">';
		boxHtml += '			<label class="form-label col-md-3"><b>插件文件：</b></label>';
		boxHtml += "			<div class='col-md-8'>";
		boxHtml += '				<span class="btn-upload form-group">';
		boxHtml += '					<input id="uploadfile-1" class="input-text upload-url" name="uploadfile-1" readonly="" type="text" style="width:200px">';
		boxHtml += '					<a class="btn btn-primary" href="javascript:void();">';
		boxHtml += '						<i class="Hui-iconfont">&#xe642;</i> 浏览文件';
		boxHtml += '					</a>';
		boxHtml += '					<input class="input-file" multiple="" name="file-1" type="file">';
		boxHtml += '				</span>';
		boxHtml += "			</div>";
		boxHtml += "		</div>";
		boxHtml += '		<div class="row cl">';
		boxHtml += '			<label class="form-label col-md-3"><b class="c-red">说明：</b></label>';
		boxHtml += "			<div class='col-md-8'>";
		boxHtml += '				<p style="line-height:28px;">请上传正确的插件文件，文件格式为jar！</p>';
		boxHtml += "			</div>";
		boxHtml += "		</div>";
		boxHtml += "	</form>";
		boxHtml += "</div>";
		layer.open({
			area: ['540px'],
			title:"插件安装",
			type: 1,
			skin: 'layui-layer-rim', //加上边框
			content: boxHtml,
			btn:["确定","取消"],
			yes:function(index){
				layer.close(index);
			}
		});
	});
	
});

//查看插件
function viewplugin(obj){
	layer.open({
		area: ['640px'],
		title:"用户新增",
		type: 1,
		skin: 'layui-layer-rim', //加上边框
		content: "查看插件",
		btn:["确定","取消"],
		yes:function(index){
			var nodeName = $.trim($("input[name='stationName']").val());
			alert(nodeName)
			layer.close(index);
		}
	});
}

//暂停插件
function stopplugin(obj){
	layer.confirm('你确定要暂停插件吗？', {
		time: 0, //不自动关闭
		btn: ['确定', '取消'],
		icon: 3,
		yes: function(index){
			layer.close(index);
		}
	});
}


//卸载插件
function delplugin(obj){
	layer.confirm('你确定要卸载插件吗？', {
		time: 0, //不自动关闭
		btn: ['确定', '取消'],
		icon: 3,
		yes: function(index){
			layer.close(index);
		}
	});
}
