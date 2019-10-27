package com.qixin.ssh.controller;
import com.alibaba.fastjson.JSON;
import com.qixin.common.AjaxBeanData;
import com.qixin.common.AjaxListData;
import com.qixin.common.AjaxPageListData;
import com.qixin.common.HttpUtil;
import com.qixin.common.JSONObjectTool;
import com.qixin.ssh.model.Repetion;
import com.qixin.ssh.model.SdProposeOrder;
import com.qixin.ssh.services.RepetionService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class RepetionController {

	private RepetionService repetionService;

	public RepetionService getRepetionService() {
		return repetionService;
	}

	public void setRepetionService(RepetionService repetionService) {
		this.repetionService = repetionService;
	}

	public void init() {
		System.out.println("最新");
	}

		// 获取所有
		@RequestMapping(value = "/getAllRepetion")
		@ResponseBody
		public String getAllRepetion(HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			List<Repetion> allRepetion = repetionService.getAllRepetion();
			AjaxPageListData ajaxPageListData = new AjaxPageListData();
			ajaxPageListData.setItems(allRepetion);
			String json = JSONObjectTool.getJson(ajaxPageListData);
			return json;
		}
		//跳转
		@RequestMapping(value = "argumentUser.htm")
		@ResponseBody
		public ModelAndView argumentUser(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			return new ModelAndView("argumentUser");
		}

		// 获取所有用户
			@RequestMapping(value = "/getUser")
			@ResponseBody
			public String getUser(HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				List<Object[]> user = repetionService.getUser();
				AjaxPageListData ajaxPageListData = new AjaxPageListData();
				ajaxPageListData.setItems(user);
				String json = JSONObjectTool.getJson(ajaxPageListData);
				return json;
			}
		// 修改
		@RequestMapping(value = "/updateRepetion")
		@ResponseBody
		public void updateRepetion(HttpServletRequest request,
				HttpServletResponse response,String number,String content,String userName,String userid)
				throws Exception {
			AjaxBeanData ajaxBeanData = new AjaxBeanData();
			AjaxListData ajaxListData = new AjaxListData();
			AjaxListData ajaxListData2 = new AjaxListData();
			//先获取之前的数据
			List<Repetion> status = repetionService.getStatus();
			
			ajaxListData.setItems(status);
			String beforeJson = JSONObjectTool.getJson(ajaxListData);
			System.out.println(beforeJson+"之前的");
			//获取修改后的数据
			int count=0;
			if(number!=null&&!number.equals("")){
			Matcher m=Pattern.compile(",").matcher(number);
			while(m.find()){
			      count++;
			  }
			
				for(int i=0;i<count;i++){
					
					
					String[] split = number.split(",");
					System.out.println(count+"数量");
					System.out.println(split[i]+"id");
					//System.out.println(split[i]);
					 repetionService.updateRepetion(split[i]);
					//System.out.println(updateRepetion.getStatus());
				}
			}else{
				repetionService.updateRepetion(null);
			}
			List<Repetion> status2 = repetionService.getStatus();
			ajaxListData2.setItems(status2);
			String afterJson = JSONObjectTool.getJson(ajaxListData2);
			
			System.out.println(afterJson+"之后的");
			
			SdProposeOrder sdProposeOrder = new SdProposeOrder();
			sdProposeOrder.setAfterJson(afterJson);
			sdProposeOrder.setBeforeJson(beforeJson);
			sdProposeOrder.setObject("重复项设置");
			sdProposeOrder.setOptionType("修改");
			sdProposeOrder.setMahId(null);
			sdProposeOrder.setAuditorReason(content);
			sdProposeOrder.setProposerCreatTime(new Date());
			sdProposeOrder.setAuditorId(Integer.parseInt(userName));
			sdProposeOrder.setProposerId(Integer.parseInt("1"));
			sdProposeOrder.setUrl("../basedata/updateAubuffer?id=");
			ajaxBeanData.setData(sdProposeOrder);
			String json = JSONObjectTool.getJson(ajaxBeanData);
			
			
		//	HttpUtil.doGet("http://localhost:8181/basedata/updateAubuffer");
	         
	       
			//System.out.println(json);
		
		}

	
		
		// 周伟明审核完然后调我这个接口
				@RequestMapping(value = "/updateAubuffer")
				@ResponseBody
				public String  updateAubuffer(HttpServletRequest request,
						HttpServletResponse response,@RequestParam(value="afterJson",required=false) String  afterJson
						,SdProposeOrder sdProposeOrder){
							return  true+"";
				}
			
				// 获取所有
				@RequestMapping(value = "argument.htm")
				@ResponseBody
				public ModelAndView argument(HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					return new ModelAndView("argument");
				}

		// 得到所有状态
		@RequestMapping(value = "/getStatus")
		@ResponseBody
		public String getStatus(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			AjaxListData ajaxListData = new AjaxListData();
			List<Repetion> status = repetionService.getStatus();
			
			
			if (status != null && status.size() > 0) {
				// AjaxListData ajaxListData = new AjaxListData();
				ajaxListData.setItems(status);
				ajaxListData.setResult("true");
				String json = JSONObjectTool.getJson(ajaxListData);
				return json;
			} else {
				ajaxListData.setResult("flase");
				String json = JSONObjectTool.getJson(ajaxListData);
				return json;
			}
		}
		

}
