package com.qixin.ssh.controller;

import com.alibaba.fastjson.JSON;
import com.qixin.common.*;
import com.qixin.ssh.model.Batch;
import com.qixin.ssh.services.BatchService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BatchController {
    private static String fileName;
    private static String filepath = System.getProperty("user.dir") + "/";
    private BatchService batchService;

    public BatchService getBatchService() {
        return batchService;
    }

    public void setBatchService(BatchService batchService) {
        this.batchService = batchService;
    }

    public void init() {
        System.out.println("最新");
    }/*获取所有信息*/

    @RequestMapping(value = "/getAllList")
    @ResponseBody
    public String getAllList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Batch> list = batchService.getList();
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(list);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*根据生产批号,时间,通用名称获取信息*/

    @RequestMapping(value = "/selectBatchNum")
    @ResponseBody
    public String selectBatchNum(HttpServletRequest request, HttpServletResponse response, String batchNum, String starTime, String endTime, String productName) throws Exception {
        java.util.Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (starTime != null && !starTime.equals("")) date = dateFormat.parse(starTime);
        java.util.Date dates = null;
        if (endTime != null && !endTime.equals("")) dates = dateFormat.parse(endTime);
        List<Batch> list = batchService.getOneBatch(batchNum, date, dates, productName);
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(list);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*根据id获取详情的信息*/

    @RequestMapping(value = "/selectBatchId")
    @ResponseBody
    public String selectBatchId(HttpServletRequest request, HttpServletResponse response, String batchId) throws Exception {
        int batchIds = Integer.parseInt(batchId);
        Batch batch = batchService.getDetalsBatch(batchIds);
        AjaxBeanData ajaxBeanData = new AjaxBeanData();
        ajaxBeanData.setData(batch);
        String jsonString = JSONObjectTool.getJson(ajaxBeanData);
        return JSONObjectTool.getJson(jsonString);
    }/*input框模糊搜索*/

    @RequestMapping(value = "/search_batch")
    @ResponseBody
    public String search_batch(HttpServletRequest request, HttpServletResponse response, String batch) throws Exception {
        List<Object[]> batchs = batchService.getlikePici(batch);
        AjaxListData ajx = new AjaxPageListData();
        ajx.setItems(batchs);
        String jsonString = JSONObjectTool.getJson(ajx);
        System.out.println(jsonString);
        return JSONObjectTool.getJson(jsonString);
    }/*录入数据*/

    @RequestMapping(value = "/saveOne")
    @ResponseBody
    public String selectSaveOne(HttpServletRequest request, HttpServletResponse response, String batchNum, String productName, String CFDACode, String dosage, String strength, String manufactureTime, String number, String packaging, String manufacturer, String productId, String mahCode) throws Exception {
        java.util.Date date = null;
        if (manufactureTime != null && !manufactureTime.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat.parse(manufactureTime);
        }
        Batch batch = new Batch();
        batch.setBatchNum(batchNum);
        batch.setProductName(productName);
        batch.setCFDACode(CFDACode);
        batch.setDosage(dosage);
        batch.setStrength(strength);
        batch.setManufactureTime(date);
        batch.setNumber(Integer.parseInt(number));
        batch.setPackaging(packaging);
        batch.setProductId(Integer.parseInt(productId));
        batch.setMahId(mahCode);
        batch.setManufacturer(manufacturer);
        boolean flag = batchService.saveInfo(batch);
        AjaxBeanData list = new AjaxBeanData();
        list.setResult(flag + "");
        String jsonString = JSONObjectTool.getJson(list);
        return jsonString;
    }/*修改数据*/

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(HttpServletRequest request, HttpServletResponse response, String batchId, String batchNum, String productName, String CFDACode, String dosage, String strength, String manufactureTime, String number, String packaging, String manufacturer, String productId, String mahCode) throws Exception {
        java.util.Date date = null;
        if (manufactureTime != null && !manufactureTime.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat.parse(manufactureTime);
        }
        Batch batch = new Batch();
        batch.setBatchId(Integer.parseInt(batchId));
        batch.setBatchNum(batchNum);
        batch.setProductName(productName);
        batch.setCFDACode(CFDACode);
        batch.setDosage(dosage);
        batch.setStrength(strength);
        batch.setManufactureTime(date);
        batch.setNumber(Integer.parseInt(number));
        batch.setPackaging(packaging);
        batch.setMahId(mahCode);
        batch.setProductId(Integer.parseInt(productId));
        batch.setManufacturer(manufacturer);
        boolean flag = batchService.updateInfo(batch);
        AjaxBeanData list = new AjaxBeanData();
        list.setResult(flag + "");
        String jsonString = JSONObjectTool.getJson(list);
        return jsonString;
    }/*删除数据*/

    @RequestMapping(value = "/del")
    @ResponseBody
    public String del(HttpServletRequest request, HttpServletResponse response, String batchId) throws Exception {
        int batchIds = Integer.parseInt(batchId);
        boolean delUserInfo = batchService.deleteInfo(batchIds);
        AjaxBeanData list = new AjaxBeanData();
        list.setResult(delUserInfo + "");
        String jsonString = JSONObjectTool.getJson(list);
        return jsonString;
    }/*获取通用名称*/

    @RequestMapping(value = "/tName")
    @ResponseBody
    public String tName(HttpServletRequest request, HttpServletResponse response, String obj) throws Exception {
        List<Object[]> lists = batchService.getName(obj);
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(lists);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*获取批次号*/

    @RequestMapping(value = "/selPc")
    @ResponseBody
    public String selPc(HttpServletRequest request, HttpServletResponse response, String obj) throws Exception {
        List<Object[]> lists = batchService.getPici(obj);
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(lists);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*获取剂型,规格*/

    @RequestMapping(value = "/selJx")
    @ResponseBody
    public String selJx(HttpServletRequest request, HttpServletResponse response, String obj) throws Exception {
        List<Object[]> lists = batchService.getPiNum(obj);
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(lists);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }

    @RequestMapping(value = "/exportListDrug")
    @ResponseBody
    public void exportListDrug(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        try {
            HSSFWorkbook wb = new HSSFWorkbook();/* 标题定义*//* 标题定义*/
            HSSFCellStyle styleFont = wb.createCellStyle();
            HSSFCellStyle styleTitleLeft = wb.createCellStyle();
            HSSFCellStyle styleContent = wb.createCellStyle();
            HSSFCellStyle styleContentWrap = wb.createCellStyle();/* 表格样式定义*/
            HSSFFont font = wb.createFont();
            styleFont.setFont(font);/* 标题定义*/
            font = wb.createFont();
            font.setColor(HSSFColor.RED.index);
            HSSFSheet sheet = wb.createSheet("tangbiao生成的表");
            HSSFRow rowNumber = sheet.createRow(0);
            HSSFCell colTemp = rowNumber.createCell(0);
            colTemp.setCellStyle(styleTitleLeft);/*colTemp.setCellValue("国家下发报告编号");*/
            colTemp.setCellValue("批次号");
            colTemp = rowNumber.createCell(1);
            colTemp.setCellStyle(styleTitleLeft);/*colTemp.setCellValue("国家下发报告编号");*/
            colTemp.setCellValue("通用名称");
            colTemp = rowNumber.createCell(2);
            colTemp.setCellStyle(styleTitleLeft);/*colTemp.setCellValue("国家下发报告编号");*/
            colTemp.setCellValue("批准文号");
            colTemp = rowNumber.createCell(3);
            colTemp.setCellStyle(styleTitleLeft);/*colTemp.setCellValue("国家下发报告编号");*/
            colTemp.setCellValue("剂型");
            colTemp = rowNumber.createCell(4);
            colTemp.setCellStyle(styleTitleLeft);/*colTemp.setCellValue("国家下发报告编号");*/
            colTemp.setCellValue("规格");
            colTemp = rowNumber.createCell(5);
            colTemp.setCellStyle(styleTitleLeft);/*colTemp.setCellValue("国家下发报告编号");*/
            colTemp.setCellValue("生产日期");
            colTemp = rowNumber.createCell(6);
            colTemp.setCellStyle(styleTitleLeft);/*colTemp.setCellValue("国家下发报告编号");*/
            colTemp.setCellValue("数量");
            colTemp = rowNumber.createCell(7);
            colTemp.setCellStyle(styleTitleLeft);/*colTemp.setCellValue("国家下发报告编号");*/
            colTemp.setCellValue("包装单位");
            colTemp = rowNumber.createCell(8);
            colTemp.setCellStyle(styleTitleLeft);/*colTemp.setCellValue("国家下发报告编号");*/
            colTemp.setCellValue("生产企业");
            colTemp = rowNumber.createCell(9);
            colTemp.setCellStyle(styleTitleLeft);/*colTemp.setCellValue("国家下发报告编号");*/
            colTemp.setCellValue("企业标识");
            List<Batch> batchs = batchService.getList();
            if (batchs != null && batchs.size() > 0) for (int i = 0; i < batchs.size(); i++) {
                Batch batch = batchs.get(i);
                HSSFRow rowTemp = sheet.createRow(i + 1);/*rowTemp.setHeightInPoints(50);*/
                colTemp = rowTemp.createCell(0);
                colTemp.setCellStyle(styleContent);
                colTemp.setCellValue(batch.getBatchNum() == null ? "" : batch.getBatchNum().toString());
                colTemp = rowTemp.createCell(1);
                colTemp.setCellStyle(styleContent);
                colTemp.setCellValue(batch.getProductName() == null ? "" : batch.getProductName().toString());
                colTemp = rowTemp.createCell(2);
                colTemp.setCellStyle(styleContent);
                colTemp.setCellValue(batch.getCFDACode() == null ? "" : batch.getCFDACode().toString());
                colTemp = rowTemp.createCell(3);
                colTemp.setCellStyle(styleContent);
                colTemp.setCellValue(batch.getDosage() == null ? "" : batch.getDosage().toString());
                colTemp = rowTemp.createCell(4);
                colTemp.setCellStyle(styleContent);
                colTemp.setCellValue(batch.getStrength() == null ? "" : batch.getStrength().toString());
                colTemp = rowTemp.createCell(5);
                colTemp.setCellStyle(styleContent);
                colTemp.setCellValue(batch.getManufactureTime() == null ? "" : batch.getManufactureTime().toString());
                colTemp = rowTemp.createCell(6);
                colTemp.setCellStyle(styleContent);
                if (batch.getNumber() > 0) colTemp.setCellValue("我是自己是是是是是是");
                else colTemp.setCellValue("否");
                colTemp = rowTemp.createCell(7);
                colTemp.setCellStyle(styleContent);
                if (batch.getPackaging() == null) colTemp.setCellValue("");
                else colTemp.setCellValue("否");
                colTemp = rowTemp.createCell(8);
                colTemp.setCellStyle(styleContent);
                if (batch.getManufacturer() == null) colTemp.setCellValue("");
                else colTemp.setCellValue("否");
                colTemp = rowTemp.createCell(9);
                colTemp.setCellStyle(styleContent);
                colTemp.setCellValue(batch.getMahId() == null ? "" : batch.getMahId().toString());
            }
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("tangbiao生成的表", "UTF-8") + ".xls");
            OutputStream ouputStream = resp.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "showBatchListPage.htm")
    public ModelAndView showBatchListPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return new ModelAndView("selectAll");
    }

    @RequestMapping(value = "showBatchInfoPage.htm")
    public ModelAndView showBatchInfoPage(HttpServletRequest request, HttpServletResponse response, Model model, String obj) {
        return new ModelAndView("batchInfo");
    }

    @RequestMapping(value = "ces.htm")
    public ModelAndView ces(HttpServletRequest request, HttpServletResponse response, Model model, String obj) throws Exception {
        ModelAndView mav = new ModelAndView("batchInfo");
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(list);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        request.setAttribute("list", jsonString);
        return mav;
    }/*		@RequestMapping(value="postman.htm") @ResponseBody public String postman(HttpServletRequest request, HttpServletResponse response,@RequestBody  Batch batch) throws Exception{ List<String> list=new ArrayList<String>(); list.add("aaa"); list.add("bbb"); list.add("ccc"); list.add(batch.getBatchId()+""); AjaxListData ajaxPageListData = new AjaxPageListData(); ajaxPageListData.setItems(list); String jsonString = JSONObjectTool.getJson(ajaxPageListData); return  jsonString; }*//*产品入库*/

    @RequestMapping(value = "addAnticipationNeatFromExcl.htm")
    @ResponseBody
    public String addAnticipationNeatFromExcl(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "fileName") String fileName, @RequestParam(value = "mahId") String mahId) throws IOException, InvalidFormatException {
        List<String> strList = new ArrayList<String>();
        String newFileDir = filepath + "AnticipationNeatFile/" + fileName;
        File xx = new File(newFileDir);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Boolean rt = null;
        if (!xx.exists()) return "不存在";
        else {
            InputStream is = new FileInputStream(newFileDir);
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            System.out.println("进入导入");
            List<Batch> batchs = new ArrayList<Batch>();
            try {
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    Batch batch = new Batch();
                    batch.setMahId(mahId);
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    HSSFCell needInfo = null;
                    String tempCell = "";/*因为第一个字段是序号，并不需要导入，所以从第二个字段开始*/
                    needInfo = hssfRow.getCell(0);/*生产厂家*/
                    tempCell = needInfo == null ? "" : needInfo.toString().trim();
                    batch.setBatchNum(replaceStr(tempCell));/*第2个字段*/
                    needInfo = hssfRow.getCell(1);/*企业id*/
                    tempCell = needInfo == null ? "" : needInfo.toString().trim();
                    batch.setCFDACode(replaceStr(tempCell));/*第3个字段*/
                    needInfo = hssfRow.getCell(2);/*通用名称*/
                    tempCell = needInfo == null ? "" : needInfo.toString().trim();
                    batch.setProductName(replaceStr(tempCell));/*第4个字段*/
                    needInfo = hssfRow.getCell(3);/*批准文号*/
                    tempCell = needInfo == null ? "" : needInfo.toString().trim();
                    batch.setNumber(Integer.parseInt(replaceStr(tempCell)));
                    batchs.add(batch);
                }
                Boolean rt2 = batchService.addAnticipation(batchs);
                rt = rt2;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rt + "";
        }
    }

    public String replaceStr(String num) {
        int indexOf = num.indexOf(".");
        if (indexOf != -1) num = num.substring(0, indexOf);
        return num;
    }/*产品导入文件上传*/

    @RequestMapping(value = "uploadAnticipationNeatExcl")
    @ResponseBody
    public String uploadAnticipationNeatExcl(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file-1", required = false) MultipartFile file) {
        AjaxBeanData2 bean = new AjaxBeanData2();
        try {
            fileName = file.getOriginalFilename();
            String name = fileName.substring(0, fileName.lastIndexOf("."));
            String postfix = fileName.substring(fileName.lastIndexOf("."));
            String fileName1 = name + "_" + new Date().getTime() + postfix;
            File targetFile = new File(filepath + "AnticipationNeatFile", fileName1);
            if (!targetFile.exists()) targetFile.mkdirs();/* 保存*/
            file.transferTo(targetFile);
            bean.setLabel(fileName1);
            bean.setResult(fileName);
            bean.setResume("文件上传成功");
        } catch (Exception e) {
            bean.setLabel("bundle");
            bean.setResult("fail");
            bean.setResume("文件上传失败");
            e.printStackTrace();
        }
        return JSON.toJSONString(bean);
    }

}
