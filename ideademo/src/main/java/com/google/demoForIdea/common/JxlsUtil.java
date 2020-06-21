package com.google.demoForIdea.common;

import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.command.EachCommand;
import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JxlsUtil {
	static {
		// 添加自定义指令（可覆盖jxls原指令）
		XlsCommentAreaBuilder.addCommandMapping("image", ImageCommand.class);
		XlsCommentAreaBuilder.addCommandMapping("each", EachCommand.class);
		XlsCommentAreaBuilder.addCommandMapping("merge", MergeCommand.class);
		//XlsCommentAreaBuilder.addCommandMapping("link", LinkCommand.class);
	}
	/** jxls模版文件目录 */
	//private final static String TEMPLATE_PATH = "excel/";

	/**
	 * 导出到Excel
	 */
	public static void export2Excel(InputStream is, OutputStream os, Map<String, Object> model) throws IOException {
		Context context = PoiTransformer.createInitialContext();
		if (model != null) {
			for (String key : model.keySet()) {
				context.putVar(key, model.get(key));
			}
		}
		JxlsHelper jxlsHelper = JxlsHelper.getInstance();
		Transformer transformer = jxlsHelper.createTransformer(is, os);
		// 获得配置
		JexlExpressionEvaluator evaluator = (JexlExpressionEvaluator) transformer.getTransformationConfig().getExpressionEvaluator();
		// 设置静默模式，不报警告
		// evaluator.getJexlEngine().setSilent(true);
		// 函数强制，自定义功能
		Map<String, Object> funcs = new HashMap<String, Object>();
		funcs.put("utils", new JxlsUtil()); // 添加自定义功能
	  // evaluator.getJexlEngine().setFunctions(funcs);
		// 必须要这个，否者表格函数统计会错乱
		jxlsHelper.setUseFastFormulaProcessor(false).setDeleteTemplateSheet(true).processTemplate(context, transformer);
	}
	// 日期格式化
	public String dateFormat(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat dateFmt = new SimpleDateFormat(pattern);
		return dateFmt.format(date);
	}
	// 返回第一个不为空的对象
	public Object defaultIfNull(Object... objs) {
		for (Object o : objs) {
			if (o != null)
				return o;
		}
		return null;
	}
	// if判断
	public Object ifelse(boolean b, Object o1, Object o2) {
		return b ? o1 : o2;
	}
}
