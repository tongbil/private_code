$(function(){
	$(".addCharacter").on("click",function(){
		parent.parent.layer.open({
			id: "layerframe",
			area: ['80%','90%'],
			title:"消息发布",
			type: 2,
			skin: 'layui-layer-rim', //加上边框
			content: 'setSystem/textEdit.html',
			success:function(){
				var frameId=window.parent.parent.document.getElementById('layerframe').getElementsByTagName("iframe")[0].id;
				var _frame = window.parent.parent.document.getElementById(frameId).contentWindow;
				$(".skin-minimal input",_frame.document).each(function(){
					$(this).iCheck({
						checkboxClass: 'icheckbox-blue',
						radioClass: 'iradio-blue',
						increaseArea: '20%'
					});
				});
			},
			btn:["确定","取消"],
			yes:function(index){
				var frameId=window.parent.parent.document.getElementById('layerframe').getElementsByTagName("iframe")[0].id;
				var _frame = window.parent.parent.document.getElementById(frameId).contentWindow;
				var titleName = $("input[name='titleName']",_frame.document).val();		//获取input框的值
				var eeditVal = _frame.getContent();					//获取编辑器里面的内容
				
				//parent.parent.layer.close(index);
			}
		});
	});
	
	
	//datatable表格
	$('.table-sort').dataTable({
		"bStateSave": false, //状态保存
		"bLengthChange":false,
		"searching":false,
		'ordering'  :false,
		"aLengthMenu": [[5, 10, 15, -1]]
	});
});


function updateInfo(id){
	parent.parent.layer.open({
		id: "layerframe",
		area: ['80%','90%'],
		title:"消息编辑",
		type: 2,
		skin: 'layui-layer-rim', //加上边框
		content: 'setSystem/textEdit.html?id='+id,
		success:function(){
			var frameId=window.parent.parent.document.getElementById('layerframe').getElementsByTagName("iframe")[0].id;
			var _frame = window.parent.parent.document.getElementById(frameId).contentWindow;
			$(".skin-minimal input",_frame.document).each(function(){
				$(this).iCheck({
					checkboxClass: 'icheckbox-blue',
					radioClass: 'iradio-blue',
					increaseArea: '20%'
				});
			});
		},
		btn:["确定","取消"],
		yes:function(index){
			var frameId=window.parent.parent.document.getElementById('layerframe').getElementsByTagName("iframe")[0].id;
			var _frame = window.parent.parent.document.getElementById(frameId).contentWindow;
			var titleName = $("input[name='titleName']",_frame.document).val();		//获取input框的值
			var eeditVal = _frame.getContent();					//获取编辑器里面的内容
			
			//parent.parent.layer.close(index);
		}
	});
}


function delInfo(obj){
	parent.parent.layer.confirm('你确定要删除这条消息吗？', {
		time: 0, //不自动关闭
		btn: ['确定', '取消'],
		icon: 3,
		yes: function(index){
			parent.parent.layer.close(index);
		}
	});
}
