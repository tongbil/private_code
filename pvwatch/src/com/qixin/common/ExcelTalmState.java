package com.qixin.common;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;


public class ExcelTalmState extends AbstractExcelView
{

	@Override
	public void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
//		List<Map<String, String>> heaherList = (List<Map<String, String>>) model.get("heaherList");
//		List<AdrReportForList> dataList = (List<AdrReportForList>) model.get("dataList");
//
//		String fileName = model.get("fileName").toString();
//
//		CellStyle headStyle = getCellStyle(workbook, 1);
//		CellStyle dataStyle = getCellStyle(workbook, 2);
//		HSSFSheet sheet = workbook.createSheet("sheet1");
//		sheet.setDefaultColumnWidth(20);
//
//		for (int i = 0; i < heaherList.size(); i++)
//		{
//			Map<String, String> heaherMap = heaherList.get(i);
//			Set<String> heaherSet = heaherMap.keySet();
//			Iterator<String> heahers = heaherSet.iterator();
//			while (heahers.hasNext())
//			{
//				HSSFCell cell = getCell(sheet, 0, i);
//				cell.setCellStyle(headStyle);
//				cell.setCellValue(heaherMap.get(heahers.next()));
//			}
//		}
//
//		for (int j = 0; j < dataList.size(); j++)
//		{
//			AdrReportForList adr  =dataList.get(j);
//			Map<String, String> dataMap = getValue(adr);
//			
//			for (int i = 0; i < heaherList.size(); i++)
//			{
//				String header = "";
//				Map<String, String> heaherMap = heaherList.get(i);
//				Set<String> heaherSet = heaherMap.keySet();
//				Iterator<String> heahers = heaherSet.iterator();
//				while (heahers.hasNext())
//				{
//					header = heahers.next();
//				}
//				
//				if (dataMap.containsKey(header))
//				{
//					HSSFCell cell = getCell(sheet, j + 1, i);
//					Object obj = dataMap.get(header);
//					cell.setCellStyle(dataStyle);
//					if(header.equalsIgnoreCase("DEGREE")){
//						// 报告类型1一般，2严重，3新的 一般，4新的严重
//						cell.setCellValue(obj == null ? "" : (obj.toString().equals("1")?"一般":(obj.toString().equals("2")?"严重":(obj.toString().equals("3")?"新的一般":(obj.toString().equals("4")?"新的严重":"")))));
//					}else if(header.equalsIgnoreCase("ISDOWN")){
//						cell.setCellValue(obj == null ? "" : (obj.toString().equals("1")?"已下载":"未下载"));
//					}else{
//					
//					cell.setCellValue(obj == null ? "" : obj.toString());
//					}
//				}
//			}
//		}
//
//		response.setContentType("application/vnd.ms-excel");
//		response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8")
//				+ ".xls");
//		OutputStream ouputStream = response.getOutputStream();
//		workbook.write(ouputStream);
//		ouputStream.flush();
//		ouputStream.close();
//	}
//
//	private static CellStyle getCellStyle(Workbook workbook, int type)
//	{
//		CellStyle cellStyle = workbook.createCellStyle();
//		Font font = workbook.createFont();
//		if (type == 1)
//		{
//			font.setFontName("宋体");
//			font.setFontHeightInPoints((short) 12);
//			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
//
//			cellStyle.setFont(font);
//
//			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
//			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
//
//			cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
//			cellStyle.setBorderRight(CellStyle.BORDER_THIN);
//			cellStyle.setBorderTop(CellStyle.BORDER_THIN);
//			cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
//			cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
//			cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
//			cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
//			cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
//
//			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
//			cellStyle.setFillForegroundColor((short) 22);
//		}
//		else if (type == 2)
//		{
//			font.setFontName("宋体");
//			font.setFontHeightInPoints((short) 12);
//			font.setBoldweight(Font.BOLDWEIGHT_NORMAL);
//
//			cellStyle.setFont(font);
//
//			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
//			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
//
//			cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
//			cellStyle.setBorderRight(CellStyle.BORDER_THIN);
//			cellStyle.setBorderTop(CellStyle.BORDER_THIN);
//			cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
//			cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
//			cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
//			cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
//			cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
//		}
//		return cellStyle;
//	}
//	
//	
//	
//	public static Map getValue(Object thisObj)  
//	  {  
//	    Map map = new HashMap();  
//	    Class c;  
//	    try  
//	    {  
//	      c = Class.forName(thisObj.getClass().getName());  
//	      Method[] m = c.getMethods();  
//	      for (int i = 0; i < m.length; i++)  
//	      {  
//	        String method = m[i].getName();  
//	        if (method.startsWith("get"))  
//	        {  
//	          try{  
//	          Object value = m[i].invoke(thisObj);  
//	          if (value != null)  
//	          {  
//	            String key=method.substring(3);  
//	            key=key.substring(0,1).toUpperCase()+key.substring(1);  
//	            map.put(key.toUpperCase(), value);  
//	          }  
//	          }catch (Exception e) {  
//	            // TODO: handle exception  
//	            System.out.println("error:"+method);  
//	          }  
//	        }  
//	      }  
//	    }  
//	    catch (Exception e)  
//	    {  
//	      // TODO: handle exception  
//	      e.printStackTrace();  
//	    }  
	    //return map;  
	  }  
}
