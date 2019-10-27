$(function(){
	//datatable表格
	$('.table-sort').dataTable({
		"bStateSave": false, //状态保存
		"bLengthChange":false,
		"searching":false,
		'ordering'  :false,
		"aLengthMenu": [[8, 16, 24, -1], [8, 16, 24, "All"]]
	});
	
	$("#viewReport tr").each(function(){
		$(this).dblclick(function(){
			parent.layer.open({
				title:"报告详情",
			  	type: 2,
			  	area: ['90%', '90%'],
			  	fixed: false, //不固定
			  	maxmin: false,
			  	move:false,
			  	content: 'report/reportDetail.html?id=1'
			});
		});
	});
});


function applyFuhe(obj){
	var boxHtml = "";
	boxHtml += "<div class='page-container'>";
	boxHtml += '	<form class="form form-horizontal" id="form-article-add">';
	boxHtml += '		<div class="row cl">';
	boxHtml += '			<label class="form-label col-md-3"><b>申请复核的内容：</b></label>';
	boxHtml += "			<div class='col-md-8'>";
	boxHtml += '				<textarea class="textarea radius" placeholder="" rows="2" cols="" name=""></textarea>';
	boxHtml += "			</div>";
	boxHtml += "		</div>";
	boxHtml += '		<div class="row cl">';
	boxHtml += '			<label class="form-label col-md-3"><b>申请复核理由：</b></label>';
	boxHtml += "			<div class='col-md-8'>";
	boxHtml += "				<div class='skin-minimal'>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-1'>";
	boxHtml += "						<label for='checkbox-1'>怀疑药品未生产</label>";
	boxHtml += "					</div>";
	boxHtml += "				</div>";
	boxHtml += "				<div class='skin-minimal'>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-2' checked='checked'>";
	boxHtml += "						<label for='checkbox-2'>怀疑药品未上市销售</label>";
	boxHtml += "					</div>";
	boxHtml += "				</div>";
	boxHtml += "				<div class='skin-minimal'>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-3'>";
	boxHtml += "						<label for='checkbox-3'>怀疑药品非本企业注册产品</label>";
	boxHtml += "					</div>";
	boxHtml += "				</div>";
	boxHtml += "				<div class='skin-minimal'>";
	boxHtml += "					<div class='check-box'>";
	boxHtml += "						<input type='checkbox' id='checkbox-4'>";
	boxHtml += "						<label for='checkbox-4'>药品生产企业有足够证据说明反馈数据涉及的怀疑药品非本企业产品并且影响产品风险管理的情况</label>";
	boxHtml += "					</div>";
	boxHtml += "				</div>";
	boxHtml += "			</div>";
	boxHtml += "		</div>";
	boxHtml += '		<div class="row cl">';
	boxHtml += '			<label class="form-label col-md-3"><b>备注：</b></label>';
	boxHtml += "			<div class='col-md-8'>";
	boxHtml += '				<textarea class="textarea radius" placeholder="" rows="" cols="" name=""></textarea>';
	boxHtml += "			</div>";
	boxHtml += "		</div>";
	boxHtml += "	</form>";
	boxHtml += "</div>";
	layer.open({
		area: ['640px'],
		title:"添加用户",
		type: 1,
		skin: 'layui-layer-rim', //加上边框
		content: boxHtml,
		btn:["确定","取消"],
		yes:function(index){
			layer.close(index);
		}
	});
	
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
}

