package com.qixin.ssh.controller;
import com.alibaba.fastjson.JSON;
import com.qixin.common.*;
import com.qixin.ssh.model.EmailVo;
import com.qixin.ssh.model.MailAccept;
import com.qixin.ssh.model.Semail;
import com.qixin.ssh.model.SemailFile;
import com.qixin.ssh.services.MailtService;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;
import com.sun.mail.util.MailSSLSocketFactory;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.*;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;



@Controller
public class MailtController {
    private MailtService mailtService;
    public MailtService getMailtService() {
        return mailtService;
    }
    public void setMailtService(MailtService mailtService) {
        this.mailtService = mailtService;
    }
    public void init(){
        System.out.println("最新");
    }
    //读取数据库配置
    @RequestMapping(value = "/getMailAccept")
    @ResponseBody
    public MailAccept getMailAccept(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	MailAccept mailAccept=mailtService.mailDeploy();//Deploy();
    			if(mailAccept!=null){
    				
    				return mailAccept;
    			}else{
    				return null;
    			}    		
    }
    //保存或修改数据库配置
    @RequestMapping(value = "/saveMailAccept")
    @ResponseBody
    public String saveMailAccept(HttpServletRequest request, HttpServletResponse response,String mailAccount,
    		String mailPassword,String mailHost,String mailPort) throws Exception{
    	  MailAccept mailAccept = new MailAccept();
    	  mailAccept.setId(1);
    	  mailAccept.setEmilName(mailAccount);
    	  mailAccept.setEmilPassword(mailPassword);
    	  mailAccept.setPort(mailPort);
    	  mailAccept.setServer(mailHost);
    	  mailtService.SavemailDeploy(mailAccept);
    	
    		return "保存成功";
    }

    //获取已读邮件
    @RequestMapping(value = "/oldReader")
    @ResponseBody
    public String oldReader(HttpServletRequest request, HttpServletResponse response, String userId) throws Exception{
    	MailAccept mailAccept=mailtService.mailDeploy();
    	
        List<Semail> listMal=mailtService.oldReader(mailAccept.getEmilName());
        EmojiRecovery2 emojiRecovery2 = new EmojiRecovery2();
        for(int i=0;i<listMal.size();i++){
        	if(listMal.get(i).getTitle()!=null && !listMal.get(i).getTitle().equals("")){
   			 listMal.get(i).setTitle(emojiRecovery2.emojiRecovery2(listMal.get(i).getTitle()));
    		}
    		if(listMal.get(i).getContent()!=null && !listMal.get(i).getContent().equals("")){
    			listMal.get(i).setContent(emojiRecovery2.emojiRecovery2(listMal.get(i).getContent()));
    		}
        //	System.out.println("转义前"+listMal.get(i).getTitle()+">>>>>>>>>>");
        //	listMal.get(i).setContent(emojiRecovery2.emojiRecovery2(listMal.get(i).getContent()));
        //	listMal.get(i).setTitle(emojiRecovery2.emojiRecovery2(listMal.get(i).getTitle()));
        //	System.out.println("转义后"+listMal.get(i).getTitle()+">>>>>>>>>>");
        }
	
        AjaxListData ajaxListData =new AjaxListData();
        ajaxListData.setItems(listMal);

        String jsonEnd = JSONObjectTool.getJson(ajaxListData);
        return jsonEnd;
    }
  //获取未读邮件
    @RequestMapping(value = "/localMail")
    @ResponseBody
    public String localMail(HttpServletRequest request, HttpServletResponse response, String userId) throws Exception{
    	MailAccept mailAccept=mailtService.mailDeploy();
    	List<Semail> listMal=mailtService.listMails(mailAccept.getEmilName());
    	EmojiRecovery2 emojiRecovery2 = new EmojiRecovery2();
    	
    		 for(int i=0;i<listMal.size();i++){
    			 if(listMal.get(i).getTitle()!=null && !listMal.get(i).getTitle().equals("")){
        			 listMal.get(i).setTitle(emojiRecovery2.emojiRecovery2(listMal.get(i).getTitle()));
         		}
         		if(listMal.get(i).getContent()!=null && !listMal.get(i).getContent().equals("")){
         			listMal.get(i).setContent(emojiRecovery2.emojiRecovery2(listMal.get(i).getContent()));
         		}
    	        //	System.out.println("转义前"+listMal.get(i).getTitle()+">>>>>>>>>>");
    	        //	listMal.get(i).setContent(emojiRecovery2.emojiRecovery2(listMal.get(i).getContent()));
    	        //	listMal.get(i).setTitle(emojiRecovery2.emojiRecovery2(listMal.get(i).getTitle()));
    	        //	System.out.println("转义后"+listMal.get(i).getTitle()+">>>>>>>>>>");
    	        }
    	
    	
        AjaxListData ajaxListData =new AjaxListData();
        ajaxListData.setItems(listMal);

        String jsonEnd = JSONObjectTool.getJson(ajaxListData);
        return jsonEnd;
    }
    //获取已搜入邮件
    @RequestMapping(value = "/srMail")
    @ResponseBody
    public String srMail(HttpServletRequest request, HttpServletResponse response,String userId) throws Exception{
    	MailAccept mailAccept=mailtService.mailDeploy();
    	List<Semail> listMal=mailtService.srMail(mailAccept.getEmilName());
    	EmojiRecovery2 emojiRecovery2 = new EmojiRecovery2();
    	 for(int i=0;i<listMal.size();i++){
    		if(listMal.get(i).getTitle()!=null && !listMal.get(i).getTitle().equals("")){
    			 listMal.get(i).setTitle(emojiRecovery2.emojiRecovery2(listMal.get(i).getTitle()));
     		}
     		if(listMal.get(i).getContent()!=null && !listMal.get(i).getContent().equals("")){
     			listMal.get(i).setContent(emojiRecovery2.emojiRecovery2(listMal.get(i).getContent()));
     		}
		      
	        //	System.out.println("转义前"+listMal.get(i).getTitle()+">>>>>>>>>>");
	        	//listMal.get(i).setContent(emojiRecovery2.emojiRecovery2(listMal.get(i).getContent()));
	        //	listMal.get(i).setTitle(emojiRecovery2.emojiRecovery2(listMal.get(i).getTitle()));
	        //	System.out.println("转义后"+listMal.get(i).getTitle()+">>>>>>>>>>");
	        }
    	
        AjaxListData ajaxListData =new AjaxListData();
        ajaxListData.setItems(listMal);
        String jsonEnd = JSONObjectTool.getJson(ajaxListData);
        return jsonEnd;
    }
    
    //获取回收邮件
    @RequestMapping(value = "/hsMail")
    @ResponseBody
    public String hsMail(HttpServletRequest request, HttpServletResponse response, String userId) throws Exception{
    	MailAccept mailAccept=mailtService.mailDeploy();
    	List<Semail> listMal=mailtService.hsEmail(mailAccept.getEmilName());
    	EmojiRecovery2 emojiRecovery2 = new EmojiRecovery2();
    	 for(int i=0;i<listMal.size();i++){
    		 if(listMal.get(i).getTitle()!=null && !listMal.get(i).getTitle().equals("")){
    			 listMal.get(i).setTitle(emojiRecovery2.emojiRecovery2(listMal.get(i).getTitle()));
     		}
     		if(listMal.get(i).getContent()!=null && !listMal.get(i).getContent().equals("")){
     			listMal.get(i).setContent(emojiRecovery2.emojiRecovery2(listMal.get(i).getContent()));
     		}
	        	//System.out.println("转义前"+listMal.get(i).getTitle()+">>>>>>>>>>");
	        	//listMal.get(i).setContent(emojiRecovery2.emojiRecovery2(listMal.get(i).getContent()));
	        	//listMal.get(i).setTitle(emojiRecovery2.emojiRecovery2(listMal.get(i).getTitle()));
	        	//System.out.println("转义后"+listMal.get(i).getTitle()+">>>>>>>>>>");
	        }
        AjaxListData ajaxListData =new AjaxListData();
        ajaxListData.setItems(listMal);
        String jsonEnd = JSONObjectTool.getJson(ajaxListData);
        return jsonEnd;
    }
    
    //获取网络邮件
    @RequestMapping(value = "/selectMail")
    @ResponseBody
    public String selectMail(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="userId",required=false)String userId,@RequestParam(value="userName",required=false)String userName) throws Exception{
    	  AjaxListData ajaxListData = new AjaxListData();
    	if(userName==null||userName.equals("")){
    			userName="系统";
    		}
    	MailAccept mailAccept=mailtService.mailDeploy();
    	
    	if(mailAccept==null ||  StringUtils.isBlank(mailAccept.getEmilName()) || StringUtils.isBlank(mailAccept.getEmilPassword()) || StringUtils.isBlank(mailAccept.getPort()) || StringUtils.isBlank(mailAccept.getServer())){
    		
    		return   "失败";
    	}
    	File dir = new File("c:\\mailtmp");
        //如果文件夹不存在则创建
        if  (!dir .exists()  && !dir .isDirectory())
            dir.mkdir();
      List<Semail> semailsMap2=imapDear(mailAccept.getEmilName(),mailAccept.getEmilPassword(),mailAccept.getServer());
      List<Semail> semailsMap3=new ArrayList<>();
      if(semailsMap2.size()==0){
      	  ajaxListData.setItems(null);
          ajaxListData.setResult("null");
          String jsonString = JSONObjectTool.getJson(ajaxListData);
          return jsonString;
    	}else{
    		for  ( int  i  =   0 ; i  <  semailsMap2.size(); i ++ )  {       
      			if(!mailtService.getTimes(semailsMap2.get(i).getTime(),userName)){
      				semailsMap3.add(semailsMap2.get(i));
      			}
      	      }        
    		if(semailsMap3==null || semailsMap3.size()==0){
    			System.out.println("删除进来了");
    			 ajaxListData.setItems(null);
    	          ajaxListData.setResult("null");
    	          String jsonString = JSONObjectTool.getJson(ajaxListData);
    	          return jsonString;
    		}
    	}
        //下面走pop3协议 准备连接服务器的会话信息
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "pop3");       // 协议
        props.setProperty("mail.pop3.port", mailAccept.getPort());             // 端口
        props.setProperty("mail.pop3.host", mailAccept.getServer());    // pop3服务器
        // 开启debug调试，以便在控制台查看
//		        props.setProperty("mail.debug", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
       
        props.put("mail.pop3.ssl.enable", "true");
        props.put("mail.pop3.ssl.socketFactory", sf);
        
        // 创建Session实例对象
        Session session = Session.getDefaultInstance(props);//.getInstance(props);

        Store store = session.getStore("pop3");
        store.addConnectionListener(new ConnectionListener() {
            @Override
            public void opened(ConnectionEvent connectionEvent) {
                System.out.println("Opened");
            }

            @Override
            public void disconnected(ConnectionEvent connectionEvent) {
                System.out.println("disconnected");
            }

            @Override
            public void closed(ConnectionEvent connectionEvent) {
                System.out.println("disconnected");
            }
        });
        		boolean flagPd=true;
        		try {
        			
        			 store.connect(mailAccept.getEmilName(), mailAccept.getEmilPassword());
        			
				} catch (Exception e) {
					// TODO: handle exception
					 AjaxListData ajaxListData1 = new AjaxListData();
					 ajaxListData1.setResult(!flagPd+"");
					  String jsonString = JSONObjectTool.getJson(ajaxListData1);
				        return jsonString;
				}
        // 获得收件箱
        Folder folder = store.getFolder("INBOX");
        /* Folder.READ_ONLY：只读权限
         * Folder.READ_WRITE：可读可写（可以修改邮件的状态）
         */
        folder.open(Folder.READ_WRITE); //打开收件箱
        
        // 由于POP3协议无法获知邮件的状态,所以getUnreadMessageCount得到的是收件箱的邮件总数
      //  System.out.println("未读邮件数: " + folder.getUnreadMessageCount());

        // 由于POP3协议无法获知邮件的状态,所以下面得到的结果始终都是为0
      //  System.out.println("删除邮件数: " + folder.getDeletedMessageCount());
       // System.out.println("新邮件: " + folder.getNewMessageCount());

        // 获得收件箱中的邮件总数
      //  System.out.println("邮件总数: " + folder.getMessageCount());

        // 得到收件箱中的所有邮件,并解析
        Message[] messages = folder.getMessages();
        //获取所有本地
      //  List<Semail> semailsLocalAll =mailtService.localAll(mailAccept.getEmilName());
       List<EmailVo> emailVos=  parseMessage(userName,"-1",semailsMap3,messages);
     //   List<EmailVo> emailVos=  parseMessage("-1",semailsLocalAll,messages);
        boolean addEmailFile=false;
         EmojiConvert1 emojiConvert1 = new EmojiConvert1();
        
       
       // String url =ProUtils.getProperty("serviceUrl");
        if(emailVos!=null && emailVos.size()>0){
            //总邮件遍历
            for(int i=0;i<emailVos.size();i++){
                System.out.println(emailVos.size()+"我拿到总邮件");
                //入库添加
                /*	try {*/
           		System.out.println("开始入库>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
           		if(emailVos.get(i).getSemail().getTitle()!=null && !emailVos.get(i).getSemail().getTitle().equals("")){
           			emailVos.get(i).getSemail().setTitle(emojiConvert1.emojiConvert1(emailVos.get(i).getSemail().getTitle()));
           		}
           		if(emailVos.get(i).getSemail().getContent()!=null && !emailVos.get(i).getSemail().getContent().equals("")){
           			emailVos.get(i).getSemail().setContent(emojiConvert1.emojiConvert1(emailVos.get(i).getSemail().getContent()));
           		}
           		Semail semail=mailtService.addEmail(emailVos.get(i).getSemail());
           			  if(emailVos.get(i).getListFile()!=null&& emailVos.get(i).getListFile().size()>0 ){
                             for(int j=0;j<emailVos.get(i).getListFile().size();j++){
                           	  
                                 System.out.println("我要拿到的每个邮件的名字>>>"+emailVos.get(i).getListFile().get(j).getFileName());
                                 File file = new File("c:\\mailtmp\\"+emailVos.get(i).getListFile().get(j).getFileName());
                                 Map<String, Object> params = new HashMap<String, Object>();
                                 params.put("file", file);
                                 params.put("folderFullName", "/邮箱/");
                                 //拿出管理员Id
                                // sysUser userId2 = mailtService.userId();
                                 params.put("userId", userId==null||userId.equals("")?"1":userId);
                                 String uploadFileResult = HttpUtilss.doPost("http://localhost:8181/fileManager/uploadFile.htm", null, params,
                                         "multipart/form-Data");
                               /*  if(uploadFileResult!=null && !uploadFileResult.equals("")){*/
                                	 JSONObject jsonObject = new JSONObject(uploadFileResult);
                                	 System.out.println(jsonObject.get("data"));
                                     JSONObject jsonObject2 = new JSONObject(jsonObject.get("data").toString());
                                     System.out.println(jsonObject2.get("fileId"));
                                     emailVos.get(i).getListFile().get(j).setMailId(semail.getId()+"");
                                     emailVos.get(i).getListFile().get(j).setFileId(jsonObject2.get("fileId").toString());
                                     addEmailFile = mailtService.addEmailFile(emailVos.get(i).getListFile().get(j));
                                 }
                                 
                            /*     
                             }*/
                         }
              
              
                		
					/*} catch (Exception e) {
						// TODO: handle exception
						continue;
					}*/
                	
				
              
            }//》》》
        }
        //释放资源
        folder.close(true);
        store.close();
       // boolean flags=mailtService.disEmail();
        //List<SemailFile> ls=mailtService.listFileLocal();
      
        List<Semail> semails =mailtService.listMail(mailAccept.getEmilName());
         EmojiRecovery2 emojiRecovery2 = new	EmojiRecovery2();
        //转义出来
        for(int i=0;i<semails.size();i++){
        	if(semails.get(i).getContent()!=null && !semails.get(i).getContent().equals("")){
        		semails.get(i).setContent(emojiRecovery2.emojiRecovery2(semails.get(i).getContent()));
        	}
        	//System.out.println("转义前"+semails.get(i).getTitle()+">>>>>>>>>>");
        	if(semails.get(i).getTitle()!=null && !semails.get(i).getTitle().equals("")){
        		semails.get(i).setTitle(emojiRecovery2.emojiRecovery2(semails.get(i).getTitle()));
        	}
        
        	//System.out.println("转义后"+semails.get(i).getTitle()+">>>>>>>>>>");
        }
        //删除文件夹
        deleteDir(dir);
        ajaxListData.setItems(semails);
        ajaxListData.setResult(addEmailFile+"");
        String jsonString = JSONObjectTool.getJson(ajaxListData);
        return jsonString;
    }

    //获取imap协议下的未读
    public  List<Semail> imapDear(String mailname,String mailPassword,String mailServer) throws MessagingException, IOException {
    	if(mailServer.indexOf(".qq.")== -1 ){
    		return null;
    	}
    	
        ArrayList<Semail> list =new ArrayList<>();
        String user = mailname;// 邮箱的用户名
        String password = mailPassword; // 邮箱的密码
        String serverDs="";
        if(mailServer.indexOf(".exmail.qq.")!=-1){
            serverDs+="imap.exmail.qq.com";
        }
        if(mailServer.indexOf("pop.qq.")!=-1){
            serverDs+="imap.qq.com";
        }
       
        Properties prop = System.getProperties();
        prop.put("mail.store.protocol", "imap");
        prop.put("mail.imap.host", serverDs);

        Session session = Session.getInstance(prop);

        int total = 0;
        IMAPStore store = (IMAPStore) session.getStore("imap"); // 使用imap会话机制，连接服务器
        store.connect(user, password);
        IMAPFolder folder = (IMAPFolder) store.getFolder("INBOX"); // 收件箱
        folder.open(Folder.READ_WRITE);
        // 获取总邮件数
        total = folder.getMessageCount();
        System.out.println("-----------------共有邮件：" + total
                + " 封--------------");
      /*  System.out.println("-----------------共有邮件：" + total
                + " 封--------------");*/
        // 得到收件箱文件夹信息，获取邮件列表
     //   System.out.println("未读邮件数：" + folder.getUnreadMessageCount());
        Message[] messages = folder.getMessages();
        //时间格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i=0;i<messages.length;i++) {
            Semail semail = new Semail();
        //    System.out.println("发送时间：" + sdf.format(messages[i].getSentDate()));
       //     System.out.println("主题：" + messages[i].getSubject());
          //  System.out.println("内容：" + messages[i].getContent());
          //  Flags flags = messages[i].getFlags();
           /* if (!flags.contains(Flags.Flag.SEEN)){
                //System.out.println("这是一封已读邮件");
                semail.setTime(sdf.format(messages[i].getSentDate()));
                semail.setTitle(messages[i].getSubject());
                list.add(semail);
                System.out.println("未读邮件");
            }*/
             if(messages[i].getSubject()!=null){
            	 if( messages[i].getSubject().indexOf("不良反应")!=-1 ||messages[i].getSubject().indexOf("报告")!=-1){
            		 semail.setTime(sdf.format(messages[i].getSentDate()));
                     semail.setTitle(messages[i].getSubject());
                     System.out.println(messages[i].getSubject()+"我的主题");
                     list.add(semail);
            	 }
             }
             
          //  System.out.println("========================================================");
         //   System.out.println("========================================================");
            //每封邮件都有一个MessageNumber，可以通过邮件的MessageNumber在收件箱里面取得该邮件
       //     messageNumber = messages[i].getMessageNumber();
        }
    	System.out.println(list.size()+"过滤");
    	
      //  Message message = folder.getMessage(messageNumber);
      //  System.out.println(message.getContent()+message.getContentType());
        // 释放资源
        if (folder != null)
            folder.close(true);
        if (store != null)
            store.close();
        
       
      
        return list;
        
      
    }



    /**
     * 解析邮件
     * @param messages 要解析的邮件列表
     */
    public  List<EmailVo> parseMessage(String userId,String number,List<Semail> semailsMaps2,Message...messages) throws MessagingException, IOException {
    		
    		
    		//是QQ邮箱走这个方法
    		System.out.println("进来》》》》》》》》》》》》》》》》");
        if (messages == null || messages.length < 1)
            throw new MessagingException("未找到要解析的邮件!");
        ArrayList<EmailVo> list = new ArrayList<>();
        boolean isContainerAttachment=false;
      //  System.out.println(semailsMaps2.size()+"长度");
        int as= semailsMaps2.size();
        System.out.println(as+"我最终的长度");
        // 解析所有邮件
        for (int i = 0, count = messages.length; i < count; i++) {
            MimeMessage msg = (MimeMessage) messages[i];
            String timesString=getSentDate(msg, null);
           // System.out.println(timesString+"sj");
            //判断本地已经有的未读文件
            for(int p = 0; p < semailsMaps2.size(); p++){
                if(!semailsMaps2.get(p).getTime().equals(timesString)){
                	
                    continue;
                }else{
                    if(as== 0){
                        return list;
                    }
                    as--;
                }
            //    System.out.println("------------------解析ddddd第" + msg.getMessageNumber() + "封邮件-------------------- ");
           //     System.out.println("主题: " + getSubject(msg));
          //      System.out.println("发件人: " + getFrom(msg));
          //      System.out.println("收件人：" + getReceiveAddress(msg, null)+"????????");
          //      System.out.println("发送时间：" + getSentDate(msg, null));
          //      System.out.println("是否已读：" + isSeen(msg));
         //       System.out.println("邮件优先级：" + getPriority(msg));
         //       System.out.println("是否需要回执：" + isReplySign(msg));
         //       System.out.println("邮件大小：" + msg.getSize() * 1024 + "kb");
               
                	   isContainerAttachment = isContainAttachment(msg);
                	   // System.out.println(isContainerAttachment);
				
             
          //      System.out.println("是否包含附件：" + isContainerAttachment);
                StringBuffer content = new StringBuffer(30);
               
                	  getMailTextContent(msg, content);
				
              
               // String str = content.toString();
               // System.out.println("邮件正文：" + (str.length() > 100 ? str.substring(0,100) + "..." : str));

                	

                //开始入库
                EmailVo emilvo =new EmailVo();
                Semail semail =new Semail();
               
                	String  sName=getReceiveAddress(msg, null);
				System.out.println(sName);
				
				if(sName.indexOf(",")!=-1){
					 String[] split = sName.split(",");
					 if(sName.split(",").length>1){
                         semail.setcName(sName.substring(sName.indexOf(",")+1,sName.length()));
                         semail.setsName(split[0]);
                     }
				}else{
                    semail.setcName("无");
                    semail.setsName(sName);
                }
               
                	  semail.setTitle(semailsMaps2.get(p).getTitle());
                	  System.out.println("标题"+semailsMaps2.get(p).getTitle());
				
            	  semail.setfName(getFrom(msg));
            	  System.out.println("发件人"+getFrom(msg));
			
                //收件的人
                if(userId!=null){
                	 semail.setSjUser(userId);
                }else{
                	
                	 semail.setSjUser("系统");
                }
                Date date = new Date();
                //时间格式化
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //收件的时间
                semail.setSjTime(sdf.format(date));
                semail.setStatus("1");
               
                	 semail.setTime(getSentDate(msg, null));
                	 System.out.println("收件时间"+getSentDate(msg, null));
				
               
                
              
                	 if(content.length()>0){
                  	   semail.setContent(content.substring(0,content.length()));
                  	   
                  	   System.out.println("内容"+content);
                     }
				
              
                
                semail.setReader("未读");
            
                	 emilvo.setSemail(semail);
				
               
                
                if (isContainerAttachment) {
                	
                		 saveAttachment(emilvo,msg, "c:\\mailtmp\\");  //保存附件
					
                   
                }
               
                	  list.add(emilvo);
				
              
                //执行回收内存
                //emilvo=null;
               // semail=null;
              //System.gc();
                
                System.out.println("------------------第" + msg.getMessageNumber() + "封邮件解析结束-------------------- ");
                System.out.println();
           }
        }//>>>
        return list;


    }

    /**
     * 获得邮件主题
     * @param msg 邮件内容
     * @return 解码后的邮件主题
     */
    public  String getSubject(MimeMessage msg) throws UnsupportedEncodingException, MessagingException {
        if(msg.getSubject()!=null){
            return MimeUtility.decodeText(msg.getSubject());
        }else{
            return null;
        }

    }
    //删除文件夹
    public  boolean deleteDir(File dir)  {
    	 if (dir.isDirectory()) {
 	        String[] children = dir.list();
 	   
 	        for (int i=0; i<children.length; i++) {
 	            boolean success = deleteDir(new File(dir, children[i]));
 	            if (!success) {
 	                return false;
 	            }
 	        }
 	    }
 	    // 目录此时为空，可以删除
 	    return dir.delete();
 	}

   

    /**
     * 获得邮件发件人
     * @param msg 邮件内容
     * @return 姓名 <Email地址>
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public  String getFrom(MimeMessage msg) throws MessagingException, UnsupportedEncodingException {
        String from = "";
        Address[] froms = msg.getFrom();
        if (froms.length < 1)
            throw new MessagingException("没有发件人!");

        InternetAddress address = (InternetAddress) froms[0];
        String person = address.getPersonal();
        if (person != null) {
            person = MimeUtility.decodeText(person) + " ";
        } else {
            person = "";
        }
        from = person + "<" + address.getAddress() + ">";

        return from;
    }

    /**
     * 根据收件人类型，获取邮件收件人、抄送和密送地址。如果收件人类型为空，则获得所有的收件人
     * <p>Message.RecipientType.TO  收件人</p>
     * <p>Message.RecipientType.CC  抄送</p>
     * <p>Message.RecipientType.BCC 密送</p>
     * @param msg 邮件内容
     * @param type 收件人类型
     * @return 收件人1 <邮件地址1>, 收件人2 <邮件地址2>, ...
     * @throws MessagingException
     */
    public  String getReceiveAddress(MimeMessage msg, Message.RecipientType type) throws MessagingException {
        StringBuffer receiveAddress = new StringBuffer();
        Address[] addresss = null;
        if (type == null) {
            addresss = msg.getAllRecipients();
        } else {
            addresss = msg.getRecipients(type);
        }

        if (addresss == null || addresss.length < 1)
            return "收件人为空.";
        for (Address address : addresss) {
            InternetAddress internetAddress = (InternetAddress)address;
            receiveAddress.append(internetAddress.toUnicodeString()).append(",");
        }

        receiveAddress.deleteCharAt(receiveAddress.length()-1); //删除最后一个逗号

        return receiveAddress.toString();
    }

    /**
     * 获得邮件发送时间
     * @param msg 邮件内容
     * @return yyyy年mm月dd日 星期X HH:mm
     * @throws MessagingException
     */
    public  String getSentDate(MimeMessage msg, String pattern) throws MessagingException {
        Date receivedDate = msg.getSentDate();
        if (receivedDate == null)
            return "";

        if (pattern == null || "".equals(pattern))
            pattern = "yyyy-MM-dd HH:mm:ss";

        return new SimpleDateFormat(pattern).format(receivedDate);
    }

    /**
     * 判断邮件中是否包含附件
     * @param //msg 邮件内容
     * @return 邮件中存在附件返回true，不存在返回false
     * @throws MessagingException
     * @throws IOException
     */
    public  boolean isContainAttachment(Part part) throws MessagingException, IOException {
        boolean flag = false;
        if (part.isMimeType("multipart/*")) {
            MimeMultipart  multipart = (MimeMultipart) part.getContent();
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                String disp = bodyPart.getDisposition();
                if (disp != null && (disp.equalsIgnoreCase(Part.ATTACHMENT) || disp.equalsIgnoreCase(Part.INLINE))) {
                    flag = true;
                } else if (bodyPart.isMimeType("multipart/*")) {
                    flag = isContainAttachment(bodyPart);
                } else {
                    String contentType = bodyPart.getContentType();
                    if (contentType.indexOf("application") != -1) {
                        flag = true;
                    }

                    if (contentType.indexOf("name") != -1) {
                        flag = true;
                    }
                }

                if (flag) break;
            }
        } else if (part.isMimeType("message/rfc822")) {
        		flag=true;
           //flag = isContainAttachment((Part)part.getContent());
        }
        return flag;
    }
    /**
     * 判断邮件是否已读  www.2cto.com
     * @param msg 邮件内容
     * @return 如果邮件已读返回true,否则返回false
     * @throws MessagingException
     */
    public  boolean isSeen(MimeMessage msg) throws MessagingException {
        return msg.getFlags().contains(Flags.Flag.SEEN);
    }

    /**
     * 判断邮件是否需要阅读回执
     * @param msg 邮件内容
     * @return 需要回执返回true,否则返回false
     * @throws MessagingException
     */
    public  boolean isReplySign(MimeMessage msg) throws MessagingException {
        boolean replySign = false;
        String[] headers = msg.getHeader("Disposition-Notification-To");
        if (headers != null)
            replySign = true;
        return replySign;
    }

    /**
     * 获得邮件的优先级
     * @param msg 邮件内容
     * @return 1(High):紧急  3:普通(Normal)  5:低(Low)
     * @throws MessagingException
     */
    public  String getPriority(MimeMessage msg) throws MessagingException {
        String priority = "普通";
        String[] headers = msg.getHeader("X-Priority");
        if (headers != null) {
            String headerPriority = headers[0];
            if (headerPriority.indexOf("1") != -1 || headerPriority.indexOf("High") != -1)
                priority = "紧急";
            else if (headerPriority.indexOf("5") != -1 || headerPriority.indexOf("Low") != -1)
                priority = "低";
            else
                priority = "普通";
        }
        return priority;
    }

    /**
     * 获得邮件文本内容
     * @param part 邮件体
     * @param content 存储邮件文本内容的字符串
     * @throws MessagingException
     * @throws IOException
     */
    public  void getMailTextContent(Part part, StringBuffer content) throws MessagingException, IOException {
        //如果是文本类型的附件，通过getContent方法可以取到文本内容，但这不是我们需要的结果，所以在这里要做判断
        boolean isContainTextAttach = part.getContentType().indexOf("name") > 0;
        if (part.isMimeType("text/*") && !isContainTextAttach) {
            content.append(part.getContent().toString());
        } else if (part.isMimeType("message/rfc822")) {
            getMailTextContent((Part)part.getContent(),content);
        } else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                getMailTextContent(bodyPart,content);
            }
        }
    }

    /**
     * 保存附件
     * @param part 邮件中多个组合体中的其中一个组合体
     * @param destDir  附件保存目录
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public  void saveAttachment(EmailVo emailVo,Part part, String destDir) throws UnsupportedEncodingException, MessagingException,
            FileNotFoundException, IOException {
    	
    	
    	
        List<SemailFile> semailFiles =new ArrayList<>();
        if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();    //复杂体邮件
            //复杂体邮件包含多个邮件体
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                //获得复杂体邮件中其中一个邮件体
                BodyPart bodyPart = multipart.getBodyPart(i);
                //某一个邮件体也有可能是由多个邮件体组成的复杂体
                String disp = bodyPart.getDisposition();
                if (disp != null && (disp.equalsIgnoreCase(Part.ATTACHMENT) || disp.equalsIgnoreCase(Part.INLINE))) {
                    InputStream is = bodyPart.getInputStream();
                    semailFiles.add(saveFile(emailVo,is, destDir, decodeText(bodyPart.getFileName())));
                } else if (bodyPart.isMimeType("multipart/*")) {
                    saveAttachment(emailVo,bodyPart,destDir);
                } else {
                    String contentType = bodyPart.getContentType();
                    if (contentType.indexOf("name") != -1 || contentType.indexOf("application") != -1) {
                        semailFiles.add( saveFile(emailVo,bodyPart.getInputStream(), destDir, decodeText(bodyPart.getFileName())));
                    }
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            saveAttachment(emailVo,(Part) part.getContent(),destDir);
        }

        emailVo.setListFile(semailFiles);
    }

    /**
     * 读取输入流中的数据保存至指定目录
     * @param is 输入流
     * @param fileName 文件名
     * @param destDir 文件存储目录
     * @throws FileNotFoundException
     * @throws IOException
     */
    private  SemailFile  saveFile(EmailVo emailVo, InputStream is, String destDir, String fileName)
            throws FileNotFoundException, IOException {
       System.out.println("文件名字:" +fileName);
       int lastIndexOf2 = fileName.lastIndexOf(".");
		if(fileName.substring(lastIndexOf2,lastIndexOf2+2).equalsIgnoreCase(".B")){
			String substring3 = fileName.substring(0, lastIndexOf2);
			 fileName = substring3+".jpg";
	   	}
       if(fileName.indexOf("/")!=-1){
    	   	System.out.println("来了老弟");
    	   	int lastIndexOf = fileName.lastIndexOf("/");
    	   	System.out.println(lastIndexOf+"位置");
    	   	String substring = fileName.substring(lastIndexOf+1, fileName.length());
    	   	System.out.println(substring+"最后生成");
    	   	fileName=substring;
    	   	int lastIndexOf3 = fileName.lastIndexOf(".");
    		if(fileName.substring(lastIndexOf3,lastIndexOf3+2).equalsIgnoreCase(".B")){
    			String substring3 = fileName.substring(0, lastIndexOf3);
    			 fileName = substring3+".jpg";
    	   	}
       }
       //fileName="6c66f4c39a3b0d0c19038cd4c29ba81f.jpg";
        //文件入库
        SemailFile semailFile = new SemailFile();
        semailFile.setFileName(fileName);

        BufferedInputStream bis = new BufferedInputStream(is);
        
        	  BufferedOutputStream bos = new BufferedOutputStream(
                      new FileOutputStream(new File(destDir + fileName)));
        	 
        	   int len = -1;
        	   //报错的地方.读取read意外到达文件末尾 
                while ((len = bis.read()) != -1) {
                    bos.write(len);
    			}
                bos.flush();
                bos.close();
                bis.close();
                return semailFile;
		
      
     
    }

    /**
     * 文本解码
     * @param encodeText 解码MimeUtility.encodeText(String text)方法编码后的文本
     * @return 解码后的文本
     * @throws UnsupportedEncodingException
     */
    public  String decodeText(String encodeText) throws UnsupportedEncodingException {
        if (encodeText == null || "".equals(encodeText)) {
            return "";
        } else {
            return MimeUtility.decodeText(encodeText);
        }
    }


    //删除邮件
    @RequestMapping(value = "/delEmail")
    @ResponseBody
    public String delEmail(HttpServletRequest request, HttpServletResponse response,String id,String value,String userId,String userName) throws Exception{
       Semail semail= mailtService.delEmail(Integer.parseInt(id),value,userId);
      /* String url =ProUtils.getProperty("serviceUrl");
       	List<SemailFile> list =mailtService.upFiles(semail.getId());
       	if(list!=null && !list.equals("")){
       		for (int i = 0; i < list.size(); i++) {
       			HttpUtilss.doGet(url+"/fileManager/hsFarfile.htm?fileId="+list.get(i).getFileId());	
			}
       	}*/
       	
        AjaxBeanData ajaxBeanData = new AjaxBeanData();
        ajaxBeanData.setResult("true");
        String json = JSONObjectTool.getJson(ajaxBeanData);
        return  json;
    }
    //回收站恢复邮件
    
    @RequestMapping(value = "/updateDel")
    @ResponseBody
    public String updateDel(HttpServletRequest request, HttpServletResponse response,String id,String value) throws Exception{
     boolean flag= mailtService.updelEmail(Integer.parseInt(id));
     /*  String url =ProUtils.getProperty("serviceUrl");
       	List<SemailFile> list =mailtService.upFiles(semail.getId());
       	if(list!=null && !list.equals("")){
       		for (int i = 0; i < list.size(); i++) {
       			HttpUtilss.doGet(url+"/fileManager/hsFarfile.htm?fileId="+list.get(i).getFileId());	
			}
       	}
       	*/
        AjaxBeanData ajaxBeanData = new AjaxBeanData();
        ajaxBeanData.setResult(flag+"");
        String json = JSONObjectTool.getJson(ajaxBeanData);
        return  json;
    }
    //报告调接口
    @RequestMapping(value = "/upMailReport")
    @ResponseBody
    public String upMailReport(HttpServletRequest request, HttpServletResponse response,String emailId,String reportId,String userId,String bgCode) throws Exception{
     boolean flag= mailtService.upMailReport(emailId,reportId,userId,bgCode);
    
        AjaxBeanData ajaxBeanData = new AjaxBeanData();
        ajaxBeanData.setResult(flag+"");
        String json = JSONObjectTool.getJson(ajaxBeanData);
        return  json;
    }
    
   
  //跳到邮箱详情页面
   
    @RequestMapping(value="emailJump")
    public ModelAndView emailJumps(HttpServletRequest request, HttpServletResponse response, Model model, String id) throws Exception{
        Semail semail = mailtService.upRead(Integer.parseInt(id));
       // System.out.println("Srport转义前:"+semail.getTitle());
        EmojiRecovery2 emojiRecovery2 = new	EmojiRecovery2();
        if(semail.getTitle()!=null && !semail.getTitle().equals("")){
        	 semail.setTitle(emojiRecovery2.emojiRecovery2(semail.getTitle()));
        }
        if(semail.getContent()!=null && !semail.getContent().equals("")){
       	 semail.setContent(emojiRecovery2.emojiRecovery2(semail.getContent()));
        }
   	
   	// System.out.println("Srport转义后:"+semail.getTitle());
   
        List<SemailFile> fileList =mailtService.upFiles(Integer.parseInt(id));
        AjaxBeanData ajaxBeanData = new AjaxBeanData();
        ajaxBeanData.setData(semail);
        String json = JSONObjectTool.getJson(ajaxBeanData);
        ModelAndView mav=new ModelAndView("emailJump");
        //取出邮件
        com.alibaba.fastjson.JSONObject parse = (com.alibaba.fastjson.JSONObject) JSON.parse(json);
        com.alibaba.fastjson.JSONObject data = (com.alibaba.fastjson.JSONObject)parse.get("data");
        //拿出文件
        ArrayList objects = new ArrayList();
        if(fileList !=null && fileList.size() >0){
            for(int i=0;i<fileList.size();i++){
                objects.add(fileList.get(i));
            }
        }
        request.setAttribute("email", data);
        request.setAttribute("files", objects);
        return mav;

    }
    //跳到邮箱页面
    @RequestMapping(value="mail.htm")
	public ModelAndView mail(HttpServletRequest request, HttpServletResponse response,Model model){
	
		return new ModelAndView("mail");
	}
  //跳到邮箱配置页面
    @RequestMapping(value="mailConfig.htm")
	public ModelAndView mailConfig(HttpServletRequest request, HttpServletResponse response,Model model){
	
		return new ModelAndView("acceptmailConfig");
	}
    
    //跳到邮箱搜入调报告接口
   
    @RequestMapping(value="Srport.htm")
	public ModelAndView srport(HttpServletRequest request, HttpServletResponse response,Model model,String emailId,@RequestParam(value="reportId",required=false)String reportId) throws Exception{
    	 
    	 Semail semail = mailtService.upRr(Integer.parseInt(emailId));
    	
    	 AjaxBeanData ajaxBeanData = new AjaxBeanData();
         ajaxBeanData.setData(semail);
         String json = JSONObjectTool.getJson(ajaxBeanData);
         //取出邮件
         com.alibaba.fastjson.JSONObject parse = (com.alibaba.fastjson.JSONObject) JSON.parse(json);
         com.alibaba.fastjson.JSONObject data = (com.alibaba.fastjson.JSONObject)parse.get("data");
    	//获取当前邮件id所有的文件
    	List<SemailFile> upFiles = mailtService.upFiles(Integer.parseInt(emailId));  			
    	//拿出文件
        ArrayList objects = new ArrayList();
        if(upFiles !=null && upFiles.size() >0){
            for(int i=0;i<upFiles.size();i++){
                objects.add(upFiles.get(i));
            }
        }
        if(reportId!=null && !reportId.equals("")){
        	  request.setAttribute("reportId", reportId);     
        }else{
        	 request.setAttribute("reportId", "-1");     
        }
        request.setAttribute("email", data);     
        request.setAttribute("files", objects); 
		return new ModelAndView("addMailLiteratureListPage");
	}
  //跳到邮箱配置页面
    @RequestMapping(value="mailConfigVo.htm")
	public String mailConfigVo(HttpServletRequest request, HttpServletResponse response,SdProposeOrder sdProposeOrder){
    		
		return false+"";
	}

}