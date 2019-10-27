package com.qixin.ssh.controller;

import com.qixin.common.AjaxBeanData;
import com.qixin.common.AjaxListData;
import com.qixin.common.AjaxPageListData;
import com.qixin.common.JSONObjectTool;
import com.qixin.ssh.model.Reference;
import com.qixin.ssh.services.ReferenceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class ReferenceController {
    private ReferenceService referenceService;

    public ReferenceService getReferenceService() {
        return referenceService;
    }

    public void setReferenceService(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    public void init() {
        System.out.println("最新");
    }/*获取通用名称		*/

    @RequestMapping(value = "/blfyName1")
    @ResponseBody
    public String salesName1(HttpServletRequest request, HttpServletResponse response, String obj) throws Exception {
        List<Object[]> lists = referenceService.getName(obj);
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(lists);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*获取不良反应		*/

    @RequestMapping(value = "/blfy")
    @ResponseBody
    public String blfy(HttpServletRequest request, HttpServletResponse response, String obj) throws Exception {
        List<Object[]> lists = referenceService.getblfy(obj);
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(lists);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*获取所有的数据表	*/

    @RequestMapping(value = "/getAllblfy")
    @ResponseBody
    public String getAllblfy(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Object[]> lists = referenceService.getAllblfy();
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(lists);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*删除数据*/

    @RequestMapping(value = "/delRe")
    @ResponseBody
    public String del(HttpServletRequest request, HttpServletResponse response, String batchId) throws Exception {
        System.out.println("555544444444444444445");
        int batchIds = Integer.parseInt(batchId);
        boolean delUserInfo = referenceService.deleteInfo(batchIds);
        AjaxBeanData list = new AjaxBeanData();
        list.setResult(delUserInfo + "");
        String jsonString = JSONObjectTool.getJson(list);
        return jsonString;
    }/*模糊搜索*/

    @RequestMapping(value = "/seclittle")
    @ResponseBody
    public String seclittle(HttpServletRequest request, HttpServletResponse response, String qiyeId, String proName, String zccf, String blName) throws Exception {
        List<Object[]> list = referenceService.seclittle(qiyeId, proName, zccf, blName);
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(list);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*获取所有的组成成分*/

    @RequestMapping(value = "/zccf")
    @ResponseBody
    public String zccf(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Object[]> lists = referenceService.zccf();
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(lists);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*新增*/

    @RequestMapping(value = "/saveRef")
    @ResponseBody
    public String selectSaveOne(HttpServletRequest request, HttpServletResponse response, String content, String genericFunction, String zccf, String blNameCode, String blName, String userid, String zhujian) throws Exception {
        if (zhujian.equals("-1")) {
            Reference reference = new Reference();
            reference.setContent(content);
            reference.setProductName(genericFunction);
            reference.setElement(zccf);
            reference.setEventName(blName);
            reference.setEventCode(blNameCode);
            reference.setCreateTime(new Date());
            reference.setUserId(Integer.parseInt(userid));
            boolean flag = referenceService.saveRef(reference);
            List<Object[]> lists = referenceService.sid();
            AjaxListData ajaxPageListData = new AjaxPageListData();
            ajaxPageListData.setItems(lists);
            String jsonString = JSONObjectTool.getJson(ajaxPageListData);
            return jsonString;
        } else {
            Reference reference = new Reference();
            reference.setContent(content);
            reference.setProductName(genericFunction);
            reference.setElement(zccf);
            reference.setEventName(blName);
            reference.setEventCode(blNameCode);
            reference.setCreateTime(new Date());
            reference.setUserId(Integer.parseInt(userid));
            reference.setId(Integer.parseInt(zhujian));
            boolean flag = referenceService.updateRef(reference);
            AjaxBeanData list = new AjaxBeanData();
            list.setResult(flag + "");
            String jsonString = JSONObjectTool.getJson(list);
            return jsonString;
        }
    }/*获取修改跳转的对象*/

    @RequestMapping(value = "/selectRefone")
    @ResponseBody
    public String selectRefone(HttpServletRequest request, HttpServletResponse response, String obj) throws Exception {
        List<Object[]> list = referenceService.selectRefone(Integer.parseInt(obj));
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(list);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        return jsonString;
    }/*跳转新增页面*/

    @RequestMapping(value = "reFerence.htm")
    public ModelAndView reFerence(HttpServletRequest request, HttpServletResponse response, Model model) {
        return new ModelAndView("insertreFerence");
    }/*跳转修改页面*/

    @RequestMapping(value = "upreFerence.htm")
    public ModelAndView upreFerence(HttpServletRequest request, HttpServletResponse response, Model model, String obj) throws Exception {
        List<Object[]> list = referenceService.selectRefone(Integer.parseInt(obj));
        AjaxListData ajaxPageListData = new AjaxPageListData();
        ajaxPageListData.setItems(list);
        String jsonString = JSONObjectTool.getJson(ajaxPageListData);
        ModelAndView mav = new ModelAndView("upreFerence");
        request.setAttribute("list", jsonString);
        return mav;
    }/*第一次起跳这个页面*/

    @RequestMapping(value = "firstjump.htm")
    public ModelAndView firstjump(HttpServletRequest request, HttpServletResponse response, Model model, String obj) {
        System.out.println("ddddd");
        return new ModelAndView("fuwenben");
    }
}
