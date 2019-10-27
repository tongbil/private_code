package com.qixin.ssh.controller;

import com.qixin.common.AjaxBeanData;
import com.qixin.common.AjaxListData;
import com.qixin.common.AjaxPageListData;
import com.qixin.common.JSONObjectTool;
import com.qixin.ssh.model.Numpro;
import com.qixin.ssh.services.NumproService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NumproController {
    private NumproService numproService;

    public NumproService getNumproService() {
        return numproService;
    }

    public void setNumproService(NumproService numproService) {
        this.numproService = numproService;
    }

    public void init() {
        System.out.println("最新");
    }/*根据id获取产品的信息*/

    @RequestMapping(value = "/getProduct")
    @ResponseBody
    public String getProduct(HttpServletRequest request, HttpServletResponse response, String companyId) throws Exception {
        List<Object[]> lists = numproService.getForcomany(companyId);
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(lists);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*根据产品获取数量的信息*/

    @RequestMapping(value = "/getNumber")
    @ResponseBody
    public String getNumber(HttpServletRequest request, HttpServletResponse response, String productid) throws Exception {
        int productids = Integer.parseInt(productid);
        Numpro number = numproService.getFornumber(productids);
        AjaxBeanData ajaxBeanData = new AjaxBeanData();
        ajaxBeanData.setData(number);
        String jsonString = JSONObjectTool.getJson(ajaxBeanData);
        return JSONObjectTool.getJson(jsonString);
    }/*新增或修改走这个方法 录入数据*/

    @RequestMapping(value = "/saveNum")
    @ResponseBody
    public String saveNum(HttpServletRequest request, HttpServletResponse response, String pro0, String productName0, String num0, String pro0s, String pro1, String productName1, String num1, String pro1s, String pro2, String productName2, String num2, String pro2s, String pro3, String productName3, String num3, String pro3s, String pro4, String productName4, String num4, String pro4s, String pro5, String productName5, String num5, String pro5s, String pro6, String productName6, String num6, String pro6s, String pro7, String productName7, String num7, String pro7s, String pro8, String productName8, String num8, String pro8s, String pro9, String productName9, String num9, String pro9s, String pro10, String productName10, String num10, String pro10s, String pro11, String productName11, String num11, String pro11s, String pro12, String productName12, String num12, String pro12s, String pro13, String productName13, String num13, String pro13s, String pro14, String productName14, String num14, String pro14s, String pro15, String productName15, String num15, String pro15s, String pro16, String productName16, String num16, String pro16s, String pro17, String productName17, String num17, String pro17s, String pro18, String productName18, String num18, String pro18s, String pro19, String productName19, String num19, String pro19s) throws Exception {
        List<Numpro> list = new ArrayList<Numpro>();/**/
        Numpro oNumpro = new Numpro();
        if (pro0 != null && !pro0.equals("") && pro0s != null && !pro0s.equals("")) {
            System.out.println(pro0s);
            oNumpro.setProductId(Integer.valueOf(pro0));
            oNumpro.setNumber(Integer.valueOf(pro0s));
        } else {
            oNumpro.setProductId(-1);
            oNumpro.setNumber(-1);
        }
        oNumpro.setProduName(productName0);
        oNumpro.setNumProId(Integer.parseInt(num0));/**/
        Numpro oNumpro1 = new Numpro();
        if (pro1 != null && !pro1.equals("") && pro1s != null && !pro1s.equals("")) {
            oNumpro1.setProductId(Integer.valueOf(pro1));
            oNumpro1.setNumber(Integer.valueOf(pro1s));
        } else {
            oNumpro1.setProductId(-1);
            oNumpro1.setNumber(-1);
        }
        oNumpro1.setProduName(productName1);
        oNumpro1.setNumProId(Integer.parseInt(num1));/**/
        Numpro oNumpro2 = new Numpro();
        if (pro2 != null && !pro2.equals("") && pro2s != null && !pro2s.equals("")) {
            oNumpro2.setProductId(Integer.valueOf(pro2));
            oNumpro2.setNumber(Integer.valueOf(pro2s));
        } else {
            oNumpro2.setProductId(-1);
            oNumpro2.setNumber(-1);
        }
        oNumpro2.setProduName(productName2);
        oNumpro2.setNumProId(Integer.parseInt(num2));/**/
        Numpro oNumpro3 = new Numpro();
        if (pro3 != null && !pro3.equals("") && pro3s != null && !pro3s.equals("")) {
            oNumpro3.setProductId(Integer.valueOf(pro3));
            oNumpro3.setNumber(Integer.valueOf(pro3s));
        } else {
            oNumpro3.setProductId(-1);
            oNumpro3.setNumber(-1);
        }
        oNumpro3.setProduName(productName3);
        oNumpro3.setNumProId(Integer.parseInt(num3));/**/
        Numpro oNumpro4 = new Numpro();
        if (pro4 != null && !pro4.equals("") && pro4s != null && !pro4s.equals("")) {
            oNumpro4.setProductId(Integer.valueOf(pro4));
            oNumpro4.setNumber(Integer.valueOf(pro4s));
        } else {
            oNumpro4.setProductId(-1);
            oNumpro4.setNumber(-1);
        }
        oNumpro4.setProduName(productName4);
        oNumpro4.setNumProId(Integer.parseInt(num4));/**/
        Numpro oNumpro5 = new Numpro();
        if (pro5 != null && !pro5.equals("") && pro5s != null && !pro5s.equals("")) {
            oNumpro5.setProductId(Integer.valueOf(pro5));
            oNumpro5.setNumber(Integer.valueOf(pro5s));
        } else {
            oNumpro5.setProductId(-1);
            oNumpro5.setNumber(-1);
        }
        oNumpro5.setProduName(productName5);
        oNumpro5.setNumProId(Integer.parseInt(num5));/**/
        Numpro oNumpro6 = new Numpro();
        if (pro6 != null && !pro6.equals("") && pro6s != null && !pro6s.equals("")) {
            oNumpro6.setProductId(Integer.valueOf(pro6));
            oNumpro6.setNumber(Integer.valueOf(pro6s));
        } else {
            oNumpro6.setProductId(-1);
            oNumpro6.setNumber(-1);
        }
        oNumpro6.setProduName(productName6);
        oNumpro6.setNumProId(Integer.parseInt(num6));/**/
        Numpro oNumpro7 = new Numpro();
        if (pro7 != null && !pro7.equals("") && pro7s != null && !pro7s.equals("")) {
            oNumpro7.setProductId(Integer.valueOf(pro7));
            oNumpro7.setNumber(Integer.valueOf(pro7s));
        } else {
            oNumpro7.setProductId(-1);
            oNumpro7.setNumber(-1);
        }
        oNumpro7.setProduName(productName7);
        oNumpro7.setNumProId(Integer.parseInt(num7));/**/
        Numpro oNumpro8 = new Numpro();
        if (pro8 != null && !pro8.equals("") && pro8s != null && !pro8s.equals("")) {
            oNumpro8.setProductId(Integer.valueOf(pro8));
            oNumpro8.setNumber(Integer.valueOf(pro8s));
        } else {
            oNumpro8.setProductId(-1);
            oNumpro8.setNumber(-1);
        }
        oNumpro8.setProduName(productName8);
        oNumpro8.setNumProId(Integer.parseInt(num8));/**/
        Numpro oNumpro9 = new Numpro();
        if (pro9 != null && !pro9.equals("") && pro9s != null && !pro9s.equals("")) {
            oNumpro9.setProductId(Integer.valueOf(pro9));
            oNumpro9.setNumber(Integer.valueOf(pro9s));
        } else {
            oNumpro9.setProductId(-1);
            oNumpro9.setNumber(-1);
        }
        oNumpro9.setProduName(productName9);
        oNumpro9.setNumProId(Integer.parseInt(num9));/**/
        Numpro oNumpro10 = new Numpro();
        if (pro10 != null && !pro10.equals("") && pro10s != null && !pro10s.equals("")) {
            oNumpro10.setProductId(Integer.valueOf(pro10));
            oNumpro10.setNumber(Integer.valueOf(pro10s));
        } else {
            oNumpro10.setProductId(-1);
            oNumpro10.setNumber(-1);
        }
        oNumpro10.setProduName(productName0);
        oNumpro10.setNumProId(Integer.parseInt(num10));/**/
        Numpro oNumpro11 = new Numpro();
        if (pro11 != null && !pro11.equals("") && pro11s != null && !pro11s.equals("")) {
            oNumpro11.setProductId(Integer.valueOf(pro11));
            oNumpro11.setNumber(Integer.valueOf(pro11s));
        } else {
            oNumpro11.setProductId(-1);
            oNumpro11.setNumber(-1);
        }
        oNumpro11.setProduName(productName11);
        oNumpro11.setNumProId(Integer.parseInt(num11));/**/
        Numpro oNumpro12 = new Numpro();
        if (pro12 != null && !pro12.equals("") && pro12s != null && !pro12s.equals("")) {
            oNumpro12.setProductId(Integer.valueOf(pro12));
            oNumpro12.setNumber(Integer.valueOf(pro12s));
        } else {
            oNumpro12.setProductId(-1);
            oNumpro12.setNumber(-1);
        }
        oNumpro12.setProduName(productName12);
        oNumpro12.setNumProId(Integer.parseInt(num12));/**/
        Numpro oNumpro13 = new Numpro();
        if (pro13 != null && !pro13.equals("") && pro13s != null && !pro13s.equals("")) {
            oNumpro13.setProductId(Integer.valueOf(pro13));
            oNumpro13.setNumber(Integer.valueOf(pro13s));
        } else {
            oNumpro13.setProductId(-1);
            oNumpro13.setNumber(-1);
        }
        oNumpro13.setProduName(productName13);
        oNumpro13.setNumProId(Integer.parseInt(num13));/**/
        Numpro oNumpro14 = new Numpro();
        if (pro14 != null && !pro14.equals("") && pro14s != null && !pro14s.equals("")) {
            oNumpro14.setProductId(Integer.valueOf(pro14));
            oNumpro14.setNumber(Integer.valueOf(pro14s));
        } else {
            oNumpro14.setProductId(-1);
            oNumpro14.setNumber(-1);
        }
        oNumpro14.setProduName(productName0);
        oNumpro14.setNumProId(Integer.parseInt(num14));/**/
        Numpro oNumpro15 = new Numpro();
        if (pro15 != null && !pro15.equals("")) {
            oNumpro15.setProductId(Integer.valueOf(pro15));
            oNumpro15.setNumber(Integer.valueOf(pro15s));
        } else {
            oNumpro15.setProductId(-1);
            oNumpro15.setNumber(-1);
        }
        oNumpro15.setProduName(productName15);
        oNumpro15.setNumProId(Integer.parseInt(num15));/**/
        Numpro oNumpro16 = new Numpro();
        if (pro16 != null && !pro16.equals("")) {
            oNumpro16.setProductId(Integer.valueOf(pro16));
            oNumpro16.setNumber(Integer.valueOf(pro16s));
        } else {
            oNumpro16.setProductId(-1);
            oNumpro16.setNumber(-1);
        }
        oNumpro16.setProduName(productName16);
        oNumpro16.setNumProId(Integer.parseInt(num16));/**/
        Numpro oNumpro17 = new Numpro();
        if (pro17 != null && !pro17.equals("")) {
            oNumpro17.setProductId(Integer.valueOf(pro17));
            oNumpro17.setNumber(Integer.valueOf(pro17s));
        } else {
            oNumpro17.setProductId(-1);
            oNumpro17.setNumber(-1);
        }
        oNumpro17.setProduName(productName17);
        oNumpro17.setNumProId(Integer.parseInt(num17));/**/
        Numpro oNumpro18 = new Numpro();
        if (pro18 != null && !pro18.equals("")) {
            oNumpro18.setProductId(Integer.valueOf(pro18));
            oNumpro18.setNumber(Integer.valueOf(pro18s));
        } else {
            oNumpro18.setProductId(-1);
            oNumpro18.setNumber(-1);
        }
        oNumpro18.setProduName(productName0);
        oNumpro18.setNumProId(Integer.parseInt(num18));/**/
        Numpro oNumpro19 = new Numpro();
        if (pro19 != null && !pro19.equals("")) {
            oNumpro19.setProductId(Integer.valueOf(pro19));
            oNumpro19.setNumber(Integer.valueOf(pro19s));
        } else {
            oNumpro19.setProductId(-1);
            oNumpro19.setNumber(-1);
        }
        oNumpro19.setProduName(productName19);
        oNumpro19.setNumProId(Integer.parseInt(num19));
        list.add(oNumpro);
        list.add(oNumpro1);
        list.add(oNumpro2);
        list.add(oNumpro3);
        list.add(oNumpro4);
        list.add(oNumpro5);
        list.add(oNumpro6);
        list.add(oNumpro7);
        list.add(oNumpro8);
        list.add(oNumpro9);
        list.add(oNumpro10);
        list.add(oNumpro11);
        list.add(oNumpro12);
        list.add(oNumpro13);
        list.add(oNumpro14);
        list.add(oNumpro15);
        list.add(oNumpro16);
        list.add(oNumpro17);
        list.add(oNumpro18);
        list.add(oNumpro19);
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumProId() == 0 && list.get(i).getProductId() > 0 && list.get(i).getNumber() > 0)
                flag = numproService.saveNum(list.get(i));
            if (list.get(i).getNumProId() > 0 && list.get(i).getNumber() > 0 && list.get(i).getNumProId() > 0)
                flag = numproService.updateNum(list.get(i));
        }
        String jsonString = JSONObjectTool.getJson(flag);
        return jsonString;
    }

    @RequestMapping(value = "numberLay.htm")
    public ModelAndView numberPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return new ModelAndView("jump");
    }
}
