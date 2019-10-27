<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="static/akehu/mainFile/h-ui/css/H-ui.min.css"  rel="stylesheet" type="text/css">
    <link href="static/akehu/mainFile/h-ui.admin/css/H-ui.admin.css"  rel="stylesheet" type="text/css">
    <link href="static/akehu/jsPlugin/icheck/icheck.css"  rel="stylesheet" type="text/css">
    <link href="static/akehu/font-awesome-4.7.0/css/font-awesome.min.css"  rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="static/akehu/css/productBaseInfo.css"/>
    <link href="static/akehu/css/bootstrap.min.css" rel="stylesheet">

</head>
<style>
    . label {
        width: 100px;
    }

</style>
<body>
<div class="page-container">
    <div class="row cl">
            <div class="text-l pd-20 bg-1 bk-gray radius">
                主题:<span class="c-red">${email.title}</span><br/>
                        发件人:<span class="c-red">${email.fName}</span><br/>
                        时间:<span class="c-red"> ${email.time}</span><br/>
                        收件人:<span id="sName" class="c-red">${email.sName }</span><br/>
                        抄送:<span id="csong" class="c-red"> ${email.cName}</span>
        </div>
    </div>
    <div  id="files" class="row cl">
        <h4 >附件:</h4>
        <div  class="text-l pd-20 bg-1 bk-gray radius">

             <c:forEach items="${files}" var="file" varStatus="status" >
                 <span  class="file_name" data-value="${file.id}">${file.fileName } <i style="cursor:pointer" title="下载" onclick="down('${file.fileId }')" class="fa fa-download fa-fw"  lang="${file.id}"></i> <i style="cursor:pointer" class="fa fa-file-pdf-o fa-fw" title="预览" onclick="whatchPDF('${file.fileId }')"></i> </span>
            </c:forEach>

        </div>
    </div>
    <div class="row cl">
  
         <div class="text-l pd-20 bg-1 bk-gray radius">
               <textarea id="summary" name="summary" cols="" rows="" disabled class="textarea " placeholder=""
			                                          datatype="*10-100" dragonfly="true"
			                                          style="height:430px">${email.content }</textarea>
        </div> 
    </div>
    <input type="hidden"  id="emailId" value=""/>
</div>
<script type="text/javascript" src="static/akehu/jsPlugin/jquery-1.11.0.min.js" ></script>
<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js" ></script>
<script type="text/javascript" src="static/akehu/jsPlugin/icheck/jquery.icheck.min.js" ></script>
<script src="static/akehu/jsPlugin/bootstrap.min.js" type="text/javascript"></script>
<script src="static/akehu/jsPlugin/datePicker/WdatePicker.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() {
    users();
    var emailId='${email.id}';
    $("#emailId").val(emailId);
    var co=$("#summary").val();

	 if(co.indexOf("html")!=-1){
		 var stars =co.split('<html>')
		$("#summary").val(stars[0]); 
	 }else{
		 console.log(co+"?");
		 var stars =co.split('<div')
		$("#summary").val(stars[0]); 
	 }
	 
   
   });
   function users() {
       var asFile ='${files}';
       if(asFile!=null && asFile!="" && asFile!='[]'){
           $("#files").show();
       }else{
           $("#files").hide();
       }
  
}
   //下载
   function down(id){
       location.href = "../fileManager/downloadFile.htm?fileId=" + id;
   }

   //预览
   function whatchPDF(id){    
       var	pathURL="../fileManager/look.htm?fileId=" + id;
       window.open(pathURL);  
   }
   
   function getInfo(){	
		var as="1";
		var formData = new FormData();
		if($("#files").is(":hidden")){
			as="0";
		}		
			
			formData.append("as",as);	
			formData.append("emailId",$("#emailId").val());
			return formData; 
		}

</script>
</body>
</html>
