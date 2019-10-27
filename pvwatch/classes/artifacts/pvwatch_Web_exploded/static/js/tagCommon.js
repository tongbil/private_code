$(document).ready(function() {
	loadTag();
});

/** 加载界面标签，获取自定义内容 */
function loadTag() {
	var tags = $("div[option='tag']");
	var size = tags.size();
	if (size != 0) {
		var codes = "";
		$.each(tags, function(index, node) {
			if (index == size - 1) {
				codes = codes + "'" + $(node).attr("code") + "'";
			} else {
				codes = codes + "'" + $(node).attr("code") + "',";
			}
		});
		$.post("/base/tagInfo/seachTag", {
			"codes" : codes
		}, function(data) {
			var res = $.parseJSON(data);
			if (res.result == 'success') {
				var head = $(document).find("head");
				$.each(res.data, function(index, node) {
					var tagCode = node.tagCode;
					var appendCss = node.appendCss;
					var appendHtml = node.appendHtml;
					var cssPath = node.cssPath;
					var jsPath = node.jsPath;
					var tag = $("div[code='" + tagCode + "']");
					if (appendCss != null && appendCss != '') {
						tag.addClass(appendCss);
					}
					if (appendHtml != null && appendHtml != '') {
						tag.append(appendHtml);
					}
					if (cssPath != null && cssPath != '') {
						head.append("<link rel='stylesheet' href='" + cssPath
								+ "' />");
					}
					if (jsPath != null && jsPath != '') {
						head.append("<script src='" + jsPath + "'></script>");
					}
				});
			}
		});
	}
}