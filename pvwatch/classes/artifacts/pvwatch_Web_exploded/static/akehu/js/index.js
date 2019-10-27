$(function(){
//	setScroll();
//	$(window).on("resize",setScroll);

/**************************************右侧弹出菜单暂时隐藏开始************************************************
	var relVal = "";
	$(".Hui-aside").find("li").each(function(){
		$(this).mousemove(function(){
			relVal = $(this).attr("rel");
			if(relVal!="" && relVal!=null && relVal!=undefined){
				$(this).children().addClass("activeCurr");
				var posit = $(this).offset();
				var positionX = posit.left+128;
				var positionY = posit.top-17;
				var html = "";
				var jsonObj = eval("menuJosn."+relVal);
				if(jsonObj.length==1){
					positionY = posit.top-1;
					$(".arrowLeft").css("top","6px")
				}else{
					$(".arrowLeft").css("top","21px")
				}
				for(var i=0;i<jsonObj.length;i++){
					html += "<li><a href='javascript:void(0)' _href='"+jsonObj[i].menuName+"' hrefSrc='"+jsonObj[i].menuUrl+"'>"+jsonObj[i].menuName+"</a></li>"
				}
				$("#jpRel").html(html);
				$("#thirdList").css({"left":positionX+"px","top":positionY+"px"}).show();
				
				$("#jpRel").children().each(function(){
					$(this).children().click(function(){
						var jumpUrl = $(this).attr("hrefSrc");
						var jumpTitle = $(this).attr("_href");
						creatIframe(jumpUrl,jumpTitle);
					});
				});
			}
		}).mouseout(function(){
			$(this).children().removeClass("activeCurr");
			$("#thirdList").hide();
		});
	});
	
	$("#thirdList").mouseover(function(){
		var obj = $("li[rel='"+relVal+"']");
		obj.children().addClass("activeCurr");
		var posit = obj.offset();
		var positionX = posit.left+128;
		var positionY = posit.top-17;
		var jsonObj = eval("menuJosn."+relVal);
		if(jsonObj.length==1){
			positionY = posit.top-1;
			$(".arrowLeft").css("top","6px")
		}else{
			$(".arrowLeft").css("top","21px")
		}
		$(this).css({"left":positionX+"px","top":positionY+"px"}).show();
	}).mouseout(function(){
		$("li[rel='"+relVal+"']").children().removeClass("activeCurr");
		$(this).hide();
	});



	//右侧菜单点击跳转iframe
	$("#jpRel").children().each(function(){
		$(this).children().click(function(){
			var jumpUrl = $(this).attr("hrefSrc");
			creatIframe(jumpUrl,"");
		});
	});
**************************************右侧弹出菜单暂时隐藏结束************************************************/
/*	
	//显示隐藏
	$("#showdisTask").click(function(){
		var relAttr = $(this).attr("rel");
		if(relAttr=="0"){
			$(this).attr("rel","1");
			$(this).children().text("隐藏窗口栏");
			var topWindow=$(window.parent.document);
			var taballwidth=0,
				$tabNav = topWindow.find(".acrossTab"),
				$tabNavWp = topWindow.find(".Hui-tabNav-wp"),
				$tabNavitem = topWindow.find(".acrossTab li"),
				$tabNavmore =topWindow.find(".Hui-tabNav-more");
			if (!$tabNav[0]){return}
			$tabNavitem.each(function(index, element) {
		        taballwidth+=Number(parseFloat(133+60))
		    });
			$tabNav.width(taballwidth+25);
			var w = $tabNavWp.width();
			if(taballwidth+25>w){
				$tabNavmore.show()}
			else{
				$tabNavmore.hide();
				$tabNav.css({left:0})
			}
			$("#Hui-tabNav").show();
			$("#iframe_box").css("top","34px");
		}else{
			$(this).attr("rel","0");
			$(this).children().text("显示窗口栏");
			$("#Hui-tabNav").hide();
			$("#iframe_box").css("top","0");
		}
	});
*/	
	
	//注销
	$("#loginout").click(function(){
		layer.confirm('你确定要退出系统么？', {
			time: 0, //不自动关闭
			btn: ['确定', '取消'],
			icon: 3,
			yes: function(index){
				layer.close(index);
			    location.href="login.html";
			}
		});
	});
	
	//意见反馈
	$("#yijian").click(function(){
		var boxHtml = "";
		boxHtml += "<div class='page-container'>";
		boxHtml += '	<form class="form form-horizontal" id="form-article-add">';
		boxHtml += '		<div class="row cl">';
		boxHtml += '			<label class="form-label col-md-3"><b>请填写反馈意见：</b></label>';
		boxHtml += "			<div class='col-md-8'>";
		boxHtml += '				<textarea class="textarea radius" placeholder="" rows="" cols="" name=""></textarea>';
		boxHtml += "			</div>";
		boxHtml += "		</div>";
		boxHtml += '		<div class="row cl">';
		boxHtml += '			<label class="form-label col-md-3"><b>手机号：</b></label>';
		boxHtml += "			<div class='col-md-8'>";
		boxHtml += '				<input type="text" placeholder="" class="input-text radius size-M">';
		boxHtml += "			</div>";
		boxHtml += "		</div>";
		boxHtml += '		<div class="row cl">';
		boxHtml += '			<label class="form-label col-md-3"><b>邮箱：</b></label>';
		boxHtml += "			<div class='col-md-8'>";
		boxHtml += '				<input type="text" placeholder="" class="input-text radius size-M">';
		boxHtml += "			</div>";
		boxHtml += "		</div>";
		boxHtml += '		<div class="row cl">';
		boxHtml += "			<div class='col-md-10 c-danger col-md-offset-2 f-12'>";
		boxHtml += '				请填写您的邮箱或者手机号，方便我们处理完能够第一时间通知您。';
		boxHtml += "			</div>";
		boxHtml += "		</div>";
		boxHtml += "	</form>";
		boxHtml += "</div>";
		layer.open({
			area: ['640px'],
			title:"请填写意见反馈",
			type: 1,
			skin: 'layui-layer-rim', //加上边框
			content: boxHtml,
			btn:["确定","取消"],
			yes:function(index){
				layer.close(index);
			}
		});
	});
	
	//消息查看
	$(".msgView").each(function(){
		$(this).click(function(e){
			e.preventDefault();
			var relid = $(this).attr("data-rel");		//获取文章id
			parent.layer.open({
				title:$(this).text(),
			  	type: 2,
			  	area: ['50%', '50%'],
			  	fixed: false, //不固定
			  	maxmin: false,
			  	move:false,
			  	content: 'articleDetail.html?id='+relid
			});
		});
	});
});




function addBorder(obj){
	obj.addClass("curr").mouseout(function(){obj.removeClass("curr")});
}
function addBg(obj){
	obj.parent().parent().children().each(function(){
		$(this).children().each(function(){
			if($(this).hasClass("ccurr")){
				$(this).removeClass("ccurr");
			};
		});
	});
	obj.addClass("ccurr");
}

//function setScroll(){
//	var windowHeight = $(window).height()-45;
//	$(".Hui-aside").css("height",windowHeight+"px");
//	$(".Hui-aside").slimScroll({
//		width:'198px',
//      height: windowHeight,
//      size: '5px'
//  });
//}


















		
		
//		layer.open({ 
//			title:"选择添加信息",
//			fixed:false,
//			resize:false,
//			scrollbar:false,
//			type: 1,
//			area: ['800px', '340px'], 	//宽高
//			content: html,
//			btn:["确定","取消"],
//			yes:function(index){
//				layer.close(index);
//				var title = "个例上报";
//				$(".page-container").children().each(function(){
//					$(this).children().each(function(){
//						if($(this).hasClass("ccurr")){
//							title = $(this).children().eq(1).children().eq(0).text();
//						}
//					});
//				});
//				var newIndex = layer.open({
//					type: 2,
//					title: title,
//					content: "glAdd.html"
//				});
//				layer.full(newIndex);
//			}
//		});
	
	//鼠标悬停产生右侧菜单
//	$("#aaa,#thirdList").mouseover(function(){
//		$("#aaa").children().addClass("active");
//		var posit = $("#aaa").offset();
//		var positionX = posit.left+157;
//		var positionY = posit.top-27;
//		$("#thirdList").css({"left":positionX+"px","top":positionY+"px"}).show();
//	}).mouseout(function(){
//		$("#aaa").children().removeClass("active");
//		$("#thirdList").hide();
//	});