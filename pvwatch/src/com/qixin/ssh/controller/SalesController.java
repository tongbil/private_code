package com.qixin.ssh.controller;

import com.qixin.common.AjaxListData;
import com.qixin.common.AjaxPageListData;
import com.qixin.common.JSONObjectTool;
import com.qixin.ssh.model.Sales;
import com.qixin.ssh.services.SalesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SalesController {
    private SalesService salesService;

    public SalesService getSalesService() {
        return salesService;
    }

    public void setSalesService(SalesService salesService) {
        this.salesService = salesService;
    }

    public void init() {
        System.out.println("最新");
    }/*获取所有销量维护*/

    @RequestMapping(value = "/getAllListSales")
    @ResponseBody
    public String getAllListSales(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Sales> list = salesService.getList();
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(list);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*获取通用名称		*/

    @RequestMapping(value = "/blfyName")
    @ResponseBody
    public String salesName(HttpServletRequest request, HttpServletResponse response, String obj) throws Exception {
        List<Object[]> lists = salesService.getSalesName(obj);
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(lists);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*selProduct获取通用名称规格和批准文号	*/

    @RequestMapping(value = "/selProduct")
    @ResponseBody
    public String selProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Object[]> lists = salesService.getProduct();
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(lists);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*获取搜索销量维护*/

    @RequestMapping(value = "/selectSales")
    @ResponseBody
    public String selectSales(HttpServletRequest request, HttpServletResponse response, String qiyeId, String proName, String strength, String starTime, String endTime) throws Exception {/*时间格式*/
        java.util.Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (starTime != null && !starTime.equals("")) date = dateFormat.parse(starTime);
        java.util.Date dates = null;
        if (endTime != null && !endTime.equals("")) dates = dateFormat.parse(endTime);
        List<Object[]> list = salesService.getOneSales(qiyeId, proName, strength, date, dates);
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(list);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*获取省*/

    @RequestMapping(value = "/getSheng")
    @ResponseBody
    public String getSheng(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Object[]> lists = salesService.getSheng();
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(lists);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*获取市*/

    @RequestMapping(value = "/selShi")
    @ResponseBody
    public String selShi(HttpServletRequest request, HttpServletResponse response, String obj) throws Exception {
        List<Object[]> lists = salesService.getShi(obj);
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(lists);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*新增 录入数据*/

    @RequestMapping(value = "/saveSales")
    @ResponseBody
    public String saveSales(HttpServletRequest request, HttpServletResponse response, String productId0, String name0, String numbers0, String danwei0, String outtime0, String adress0, String productId1, String name1, String numbers1, String danwei1, String outtime1, String adress1, String productId2, String name2, String numbers2, String danwei2, String outtime2, String adress2, String productId3, String name3, String numbers3, String danwei3, String outtime3, String adress3, String productId4, String name4, String numbers4, String danwei4, String outtime4, String adress4, String productId5, String name5, String numbers5, String danwei5, String outtime5, String adress5, String productId6, String name6, String numbers6, String danwei6, String outtime6, String adress6, String productId7, String name7, String numbers7, String danwei7, String outtime7, String adress7, String productId8, String name8, String numbers8, String danwei8, String outtime8, String adress8, String productId9, String name9, String numbers9, String danwei9, String outtime9, String adress9, String productId10, String name10, String numbers10, String danwei10, String outtime10, String adress10, String productId11, String name11, String numbers11, String danwei11, String outtime11, String adress11, String productId12, String name12, String numbers12, String danwei12, String outtime12, String adress12, String productId13, String name13, String numbers13, String danwei13, String outtime13, String adress13, String productId14, String name14, String numbers14, String danwei14, String outtime14, String adress14) throws Exception {
        System.out.println("S");
        if (productId0.equals("")) productId0 = "-1";
        if (productId1.equals("")) productId1 = "-1";
        if (productId2.equals("")) productId2 = "-1";
        if (productId3.equals("")) productId3 = "-1";
        if (productId4.equals("")) productId4 = "-1";
        if (productId5.equals("")) productId5 = "-1";
        if (productId6.equals("")) productId6 = "-1";
        if (productId7.equals("")) productId7 = "-1";
        if (productId8.equals("")) productId8 = "-1";
        if (productId9.equals("")) productId9 = "-1";
        if (productId10.equals("")) productId10 = "-1";
        if (productId11.equals("")) productId11 = "-1";
        if (productId12.equals("")) productId12 = "-1";
        if (productId13.equals("")) productId13 = "-1";
        if (productId14.equals("")) productId14 = "-1";
        String[] split = name0.split(",");
        java.util.Date date = null;
        if (name0.equals("")) name0 = "-1,-1,-1";
        if (outtime0 != null && !outtime0.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = dateFormat.parse(outtime0);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales = new Sales();
        sales.setProductId(productId0);
        sales.setProName(split[0]);
        sales.setCFDACode(split[2]);
        sales.setNumbers(numbers0);
        sales.setAdress(adress0);
        sales.setIntime(new Date());
        sales.setOuttime(date);
        sales.setStrength(split[1]);
        sales.setDanwei(danwei0);
        if (name1.equals("")) name1 = "-1,-1,-1";
        String[] split1 = name1.split(",");
        java.util.Date date1 = null;
        if (outtime1 != null && !outtime1.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date1 = dateFormat.parse(outtime1);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales1 = new Sales();
        sales1.setProductId(productId1);
        sales1.setProName(split1[0]);
        sales1.setCFDACode(split1[2]);
        sales1.setNumbers(numbers1);
        sales1.setAdress(adress1);
        sales1.setIntime(new Date());
        sales1.setOuttime(date1);
        sales1.setStrength(split1[1]);
        sales1.setDanwei(danwei1);
        if (name2.equals("")) name2 = "-1,-1,-1";
        String[] split2 = name2.split(",");
        java.util.Date date2 = null;
        if (outtime2 != null && !outtime2.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date2 = dateFormat.parse(outtime2);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales2 = new Sales();
        sales2.setProductId(productId2);
        sales2.setProName(split2[0]);
        sales2.setCFDACode(split2[2]);
        sales2.setNumbers(numbers2);
        sales2.setAdress(adress2);
        sales2.setIntime(new Date());
        sales2.setOuttime(date2);
        sales2.setStrength(split2[1]);
        sales2.setDanwei(danwei2);
        if (name3.equals("")) name3 = "-1,-1,-1";
        String[] split3 = name3.split(",");
        java.util.Date date3 = null;
        if (outtime3 != null && !outtime3.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date3 = dateFormat.parse(outtime3);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales3 = new Sales();
        sales3.setProductId(productId3);
        sales3.setProName(split3[0]);
        sales3.setCFDACode(split3[2]);
        sales3.setNumbers(numbers3);
        sales3.setAdress(adress3);
        sales3.setIntime(new Date());
        sales3.setOuttime(date3);
        sales3.setStrength(split3[1]);
        sales3.setDanwei(danwei3);
        if (name4.equals("")) name4 = "-1,-1,-1";
        String[] split4 = name4.split(",");
        java.util.Date date4 = null;
        if (outtime14 != null && !outtime4.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date4 = dateFormat.parse(outtime4);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales4 = new Sales();
        sales4.setProductId(productId4);
        sales4.setProName(split4[0]);
        sales4.setCFDACode(split4[2]);
        sales4.setNumbers(numbers4);
        sales4.setAdress(adress4);
        sales4.setIntime(new Date());
        sales4.setOuttime(date4);
        sales4.setStrength(split4[1]);
        sales4.setDanwei(danwei4);
        if (name5.equals("")) name5 = "-1,-1,-1";
        String[] split5 = name5.split(",");
        java.util.Date date5 = null;
        if (outtime5 != null && !outtime5.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date5 = dateFormat.parse(outtime5);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales5 = new Sales();
        sales5.setProductId(productId5);
        sales5.setProName(split5[0]);
        sales5.setCFDACode(split5[2]);
        sales5.setNumbers(numbers5);
        sales5.setAdress(adress5);
        sales5.setIntime(new Date());
        sales5.setOuttime(date5);
        sales5.setStrength(split5[1]);
        sales5.setDanwei(danwei5);
        if (name6.equals("")) name6 = "-1,-1,-1";
        String[] split6 = name6.split(",");
        java.util.Date date6 = null;
        if (outtime6 != null && !outtime6.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date6 = dateFormat.parse(outtime6);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales6 = new Sales();
        sales6.setProductId(productId6);
        sales6.setProName(split6[0]);
        sales6.setCFDACode(split6[2]);
        sales6.setNumbers(numbers6);
        sales6.setAdress(adress6);
        sales6.setIntime(new Date());
        sales6.setOuttime(date6);
        sales6.setStrength(split6[1]);
        sales6.setDanwei(danwei6);
        if (name7.equals("")) name7 = "-1,-1,-1";
        String[] split7 = name7.split(",");
        java.util.Date date7 = null;
        if (outtime7 != null && !outtime7.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date7 = dateFormat.parse(outtime7);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales7 = new Sales();
        sales7.setProductId(productId7);
        sales7.setProName(split7[0]);
        sales7.setCFDACode(split7[2]);
        sales7.setNumbers(numbers7);
        sales7.setAdress(adress7);
        sales7.setIntime(new Date());
        sales7.setOuttime(date7);
        sales7.setStrength(split7[1]);
        sales7.setDanwei(danwei7);
        if (name8.equals("")) name8 = "-1,-1,-1";
        String[] split8 = name8.split(",");
        java.util.Date date8 = null;
        if (outtime8 != null && !outtime8.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date8 = dateFormat.parse(outtime8);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales8 = new Sales();
        sales8.setProductId(productId8);
        sales8.setProName(split8[0]);
        sales8.setCFDACode(split8[2]);
        sales8.setNumbers(numbers8);
        sales8.setAdress(adress8);
        sales8.setIntime(new Date());
        sales8.setOuttime(date8);
        sales8.setStrength(split8[1]);
        sales8.setDanwei(danwei8);
        if (name9.equals("")) name9 = "-1,-1,-1";
        if (name10.equals("")) name10 = "-1,-1,-1";
        if (name11.equals("")) name11 = "-1,-1,-1";
        if (name12.equals("")) name12 = "-1,-1,-1";
        if (name13.equals("")) name13 = "-1,-1,-1";
        if (name14.equals("")) name14 = "-1,-1,-1";
        String[] split9 = name9.split(",");
        java.util.Date date9 = null;
        if (outtime9 != null && !outtime9.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date9 = dateFormat.parse(outtime9);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales9 = new Sales();
        sales9.setProductId(productId9);
        sales9.setProName(split9[0]);
        sales9.setCFDACode(split9[2]);
        sales9.setNumbers(numbers9);
        sales9.setAdress(adress9);
        sales9.setIntime(new Date());
        sales9.setOuttime(date9);
        sales9.setStrength(split9[1]);
        sales9.setDanwei(danwei9);
        String[] split10 = name10.split(",");
        java.util.Date date10 = null;
        if (outtime14 != null && !outtime10.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date10 = dateFormat.parse(outtime10);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales10 = new Sales();
        sales10.setProductId(productId10);
        sales10.setProName(split10[0]);
        sales10.setCFDACode(split10[2]);
        sales10.setNumbers(numbers10);
        sales10.setAdress(adress10);
        sales10.setIntime(new Date());
        sales10.setOuttime(date10);
        sales10.setStrength(split10[1]);
        sales10.setDanwei(danwei10);
        String[] split11 = name11.split(",");
        java.util.Date date11 = null;
        if (outtime11 != null && !outtime11.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date11 = dateFormat.parse(outtime14);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales11 = new Sales();
        sales11.setProductId(productId11);
        sales11.setProName(split11[0]);
        sales11.setCFDACode(split11[2]);
        sales11.setNumbers(numbers11);
        sales11.setAdress(adress11);
        sales11.setIntime(new Date());
        sales11.setOuttime(date11);
        sales11.setStrength(split11[1]);
        sales11.setDanwei(danwei11);
        String[] split12 = name12.split(",");
        java.util.Date date12 = null;
        if (outtime12 != null && !outtime12.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date12 = dateFormat.parse(outtime12);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales12 = new Sales();
        sales12.setProductId(productId12);
        sales12.setProName(split12[0]);
        sales12.setCFDACode(split12[2]);
        sales12.setNumbers(numbers12);
        sales12.setAdress(adress12);
        sales12.setIntime(new Date());
        sales12.setOuttime(date12);
        sales12.setStrength(split12[1]);
        sales12.setDanwei(danwei12);
        String[] split13 = name13.split(",");
        java.util.Date date13 = null;
        if (outtime13 != null && !outtime13.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date13 = dateFormat.parse(outtime13);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales13 = new Sales();
        sales13.setProductId(productId13);
        sales13.setProName(split13[0]);
        sales13.setCFDACode(split13[2]);
        sales13.setNumbers(numbers13);
        sales13.setAdress(adress13);
        sales13.setIntime(new Date());
        sales13.setOuttime(date13);
        sales13.setStrength(split13[1]);
        sales13.setDanwei(danwei13);
        String[] split14 = name14.split(",");
        java.util.Date date14 = null;
        if (outtime14 != null && !outtime14.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date14 = dateFormat.parse(outtime14);
            } catch (ParseException e) {/* TODO Auto-generated catch block*/
                e.printStackTrace();
            }
        }
        Sales sales14 = new Sales();
        sales14.setProductId(productId14);
        sales14.setProName(split14[0]);
        sales14.setCFDACode(split14[2]);
        sales14.setNumbers(numbers14);
        sales14.setAdress(adress14);
        sales14.setIntime(new Date());
        sales14.setOuttime(date14);
        sales14.setStrength(split14[1]);
        sales14.setDanwei(danwei0);
        List<Sales> list = new ArrayList<Sales>();
        list.add(sales);
        list.add(sales1);
        list.add(sales2);
        list.add(sales3);
        list.add(sales4);
        list.add(sales5);
        list.add(sales6);
        list.add(sales7);
        list.add(sales8);
        list.add(sales9);
        list.add(sales10);
        list.add(sales11);
        list.add(sales12);
        list.add(sales13);
        list.add(sales14);
        boolean flag = false;
        for (int i = 0; i < list.size(); i++)
            if (!list.get(i).getProductId().equals("-1")) flag = salesService.saveSales(list.get(i));
        String jsonString = JSONObjectTool.getJson(flag);
        System.out.println(jsonString);
        return jsonString;
    }

    @RequestMapping(value = "salesJump")
    public ModelAndView showBatchInfoPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return new ModelAndView("salesJump");
    }
}
