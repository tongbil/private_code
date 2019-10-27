$(function(){
	//datatable表格
	$('.table-sort').dataTable({
		"bStateSave": false, //状态保存
		"bLengthChange":false,
		"searching":false,
		'ordering'  :false,
		"aLengthMenu": [[8, 16, 24, -1], [8, 16, 24, "All"]]
	});
});