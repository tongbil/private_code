$(function() {
	//右击菜单选项
	var rightMenu = [
		[{
			text: "添加子节点",
			func: function() {
				var nextContent = $(this).next().html();
				var html = "";
				var obj = $(this);
				var boxHtml = "";
				boxHtml += "<div class='page-container'>";
				boxHtml += '	<form class="form form-horizontal" id="form-article-add">';
				boxHtml += '		<div class="row cl">';
				boxHtml += '			<label class="form-label col-md-3"><b>节点名称：</b></label>';
				boxHtml += "			<div class='col-md-8'>";
				boxHtml += "				<input type='text' class='input-text' name='nodeName'>";
				boxHtml += "			</div>";
				boxHtml += "		</div>";
				boxHtml += "	</form>";
				boxHtml += "</div>";
				parent.parent.layer.open({
					area: ['440px'],
					title:"填写节点信息",
					type: 1,
					skin: 'layui-layer-rim', //加上边框
					content: boxHtml,
					btn:["确定","取消"],
					yes:function(index){
						var nodeName = $.trim($("input[name='nodeName']",parent.parent.document).val());
						if(nodeName==""){
							nodeName = "默认节点名";
						}
						if(nextContent!=undefined && nextContent!="" && nextContent!=null){
							html += "	<li>";
							html += "		<a href='#'>"+nodeName+"</a>";
							html += "		";
							html += "	</li>";
							obj.next().append(html);
						}else{
							html += "<ul>";
							html += "	<li>";
							html += "		<a href='#'>"+nodeName+"</a>";
							html += "	</li>";
							html += "</ul>";
							obj.parent().append(html);	
						}
						
						$(".tree").find("a").each(function() {
							$(this).smartMenu(rightMenu, {
								name: "departMenu"
							});
						});
						parent.parent.layer.close(index);
					}
				});
			}
		}, {
			text: "修改节点",
			func: function() {
				var obj = $(this);
				var conctext = $.trim($(this).text());
				var boxHtml = "";
				boxHtml += "<div class='page-container'>";
				boxHtml += '	<form class="form form-horizontal" id="form-article-add">';
				boxHtml += '		<div class="row cl">';
				boxHtml += '			<label class="form-label col-md-3"><b>节点名称：</b></label>';
				boxHtml += "			<div class='col-md-8'>";
				boxHtml += "				<input type='text' class='input-text' name='nodeName' value='"+conctext+"'>";
				boxHtml += "			</div>";
				boxHtml += "		</div>";
				boxHtml += "	</form>";
				boxHtml += "</div>";
				parent.parent.layer.open({
					area: ['440px'],
					title:"填写节点信息",
					type: 1,
					skin: 'layui-layer-rim', //加上边框
					content: boxHtml,
					btn:["确定","取消"],
					yes:function(index){
						var nodeName = $.trim($("input[name='nodeName']",parent.parent.document).val());
						if(nodeName==""){
							nodeName = conctext;
						}
						obj.text(nodeName);
						parent.parent.layer.close(index);
					}
				});
			}
		}, {
			text: "删除节点",
			func: function() {
				var obj = $(this);
				parent.parent.layer.confirm('你确定要删除这个节点吗？', {
					icon:3,
					btn: ['确定','取消'] //按钮
				}, function(index){
					if(obj.parent().parent().children().length==1){
						obj.parent().parent().remove();
					}else{
						obj.parent().remove();
					}
					parent.parent.layer.close(index);
				});
			}
		}]
	];

	$(".tree").find("a").each(function() {
		$(this).smartMenu(rightMenu, {
			name: "departMenu"
		});
	});
});