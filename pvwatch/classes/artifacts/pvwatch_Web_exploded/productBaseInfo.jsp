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
		<link href="static/akehu/css/H-ui.doc.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="static/akehu/css/iconfont.min.css"/>
	<link href="static/akehu/css/iconfont.css" rel="stylesheet" type="text/css">
	<style>
		#cc:hover{
			
		}
	</style>	

	</head>

	<body>
		<div class="page-container">
			<div class="row cl">
				<div class="col-md-12 col-xs-12">
					<form class="form form-horizontal">
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl"><span class="c-red">*</span>药品名称：</label>
							<input type="hidden" class="input-text" id="drugId" value="${product.productID}"/>
							<input type="hidden" id="mahCode" value="${product.mahId}">
							<input type="text" class="input-text inputNewCss" value="${product.productName}"  id="productName" name="productName">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl"><span class="c-red">*</span>通用名称（中文）：</label>
							<input type="text" class="input-text inputNewCss" value="${product.genericChineseName}"  id="genericChineseName" name="genericChineseName">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">通用名称（英文）：</label>
							<input type="text" class="input-text inputNewCss" value="${product.genericEnglishName}" id="genericEnglishName" name="genericEnglishName">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">商品名称（中文）：</label>
							<input type="text" class="input-text inputNewCss" value="${product.brandChineseName}" id="brandChineseName" name="brandChineseName">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">商品名称（英文）：</label>
							<input type="text" class="input-text inputNewCss" value="${product.brandEnglishName}" id="brandEnglishName" name="brandEnglishName">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label  class="form-label textl"><span class="c-red">*</span>药品分类：</label>
							
								<select name="" onclick="tru();"  style="width:150px;" class="select" id="drugClass">
								
								</select>
						<ul style="  display:none  ;width:150px;z-index:999" id="fi"  class="dropDown-menu menu radius box-shadow">
							<li id="one" class=""><a href="#" ><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">中药</font></font><i class="arrow Hui-iconfont"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></i></a>
								<ul class="menu" style="z-index:10">
									<li class=""><a onclick="c0(0)" href="javascript:void(0);" ><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span  id="z0">1类</span></font></font></a></li>
									<li><a  onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z1">2类</span ></font></font></a></li>
									<li><a  onclick="c0(2)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z2">3类</span ></font></font></a></li>
									<li><a  onclick="c0(3)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z3">4类</span></font></font></a></li>
									<li><a  onclick="c0(4)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z4">5类</span></font></font></a></li>
									<li><a onclick="c0(5)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z5">6类</span></font></font></a></li>
									<li><a onclick="c0(6)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z6">6.1类</span></font></font></a></li>
									<li><a onclick="c0(7)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z7">6.2类</span></font></font></a></li>
									<li><a onclick="c0(8)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z8">6.3类</span></font></font></a></li>
									<li><a onclick="c0(9)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z9">7类</span></font></font></a></li>
									<li><a onclick="c0(10)"href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z10">8类</span></font></font></a></li>
									<li><a onclick="c0(11)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">9类</span></font></font></a></li>

								</ul>
					</li>
					<li id="tuo" class=""><a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">生物制品</font></font><i class="arrow Hui-iconfont"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></i></a>
						<ul class="menu">
							<li id="tuos" class=""><a href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">治疗用生物制品</font></font><i class="arrow Hui-iconfont"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></i></a>
								<ul class="menu" style="z-index:10">
									<li    class=""><a onclick="c0(12)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z12">治疗用1类</span></font></font></a></li>
									<li><a onclick="c0(13)"  href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z13">治疗用2类</span></font></font></a></li>
									<li><a  onclick="c0(14)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z14">治疗用3类</span></font></font></a></li>
									<li><a onclick="c0(15)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z15">治疗用4类</span></font></font></a></li>
									<li><a  onclick="c0(16)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z16">治疗用5类</span></font></font></a></li>
									<li><a  onclick="c0(17)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z17">治疗用6类</span></font></font></a></li>
									<li><a  onclick="c0(18)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z18">治疗用7类</span></font></font></a></li>
									<li><a onclick="c0(19)"  href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z19">治疗用8类</span></font></font></a></li>
									<li><a onclick="c0(20)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z20">治疗用9类</span></font></font></a></li>
									<li><a onclick="c0(21)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z21">治疗用10类</span></font></font></a></li>
									<li><a onclick="c0(22)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z22">治疗用11类</span></font></font></a></li>
									<li><a onclick="c0(23)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z23">治疗用12类</span></font></font></a></li>
									<li><a onclick="c0(24)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z24">治疗用13类</span></font></font></a></li>
									<li><a onclick="c0(25)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z25">治疗用14类</span></font></font></a></li>
									<li><a onclick="c0(26)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z26">治疗用15类</span></font></font></a></li>
								</ul>
							</li>
							<li id="tuoes" class=""><a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">预防用生物制品</font></font><i class="arrow Hui-iconfont"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></i></a>
								<ul class="menu" style="z-index:10">
									<li  class=""><a onclick="c0(27)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z27">预防用1类</span></font></font></a></li>
									<li><a  onclick="c0(28)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z28">预防用2类</span></font></font></a></li>
									<li><a onclick="c0(29)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z29">预防用3类</span></font></font></a></li>
									<li><a onclick="c0(30)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z30">预防用4类</span></font></font></a></li>
									<li><a onclick="c0(31)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z31">预防用5类</span></font></font></a></li>
									<li><a onclick="c0(32)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z32">预防用6类</span></font></font></a></li>
									<li><a onclick="c0(33)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z33">预防用7类</span></font></font></a></li>
									<li><a onclick="c0(34)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z34">预防用8类</span></font></font></a></li>
									<li><a onclick="c0(35)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z35">预防用9类</span></font></font></a></li>
									<li><a onclick="c0(36)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z36">预防用10类</span></font></font></a></li>
									<li><a onclick="c0(37)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z37">预防用11类</span></font></font></a></li>
									<li><a onclick="c0(38)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z38">预防用12类</span></font></font></a></li>
									<li><a onclick="c0(39)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z39">预防用13类</span></font></font></a></li>
									<li><a onclick="c0(40)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z40">预防用14类</span></font></font></a></li>
									<li><a onclick="c0(41)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z41">预防用15类</span></font></font></a></li>
								</ul>
							</li>
						</ul>
					</li>
					<li id="three" class=""><a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">化学</font></font><i class="arrow Hui-iconfont"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></i></a>
						<ul class="menu" style="z-index:10">
							<li id="threes" class=""><a href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">新注册分类(2016年)</font></font><i class="arrow Hui-iconfont"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></i></a>
								<ul class="menu" style="z-index:10">
									<li class=""><a  onclick="c0(42)"  href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z42">化学药品第1类</span></font></font></a></li>
									<li ><a onclick="c0(43)"  href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z43">化学药品第2.1类</span></font></font></a></li>
									<li><a  onclick="c0(44)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z44">化学药品第2.2类</span></font></font></a></li>
									<li><a onclick="c0(45)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z45">化学药品第2.3类</span></font></font></a></li>
									<li><a onclick="c0(46)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z46">化学药品第2.4类</span></font></font></a></li>
									<li><a onclick="c0(47)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z47">化学药品第3类</span></font></font></a></li>
									<li><a onclick="c0(48)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z48">化学药品第4类</span></font></font></a></li>
									<li><a onclick="c0(49)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z49">化学药品第5.1类</span></font></font></a></li>
									<li><a onclick="c0(50)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z50">化学药品第5.2类</span></font></font></a></li>
								</ul>
							</li>
							<li id="threees" class=""><a href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">原注册分类(2007年)</font></font><i class="arrow Hui-iconfont"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></i></a>
								<ul class="menu" style="z-index:10">
									<li  class=""><a href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第1.1类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第1.2类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第1.3类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第1.4类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第1.5类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第1.6类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第2类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第3.1类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第3.2类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第3.3类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第3.4类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第4类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第5类</span></font></font></a></li>
									<li><a onclick="c0(1)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z11">原化学药品第6类</span></font></font></a></li>
								</ul>
							</li>
						</ul>
					</li>
					<li ><a href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">其他</font></font></a></li>
				</ul>	
						</div>
							
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">本企业产品编码：</label>
							<input type="text" class="input-text inputNewCss" value="${product.productCode}"  id="productCode" name="productCode">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">MPIDVersion：</label>
							<input type="text" class="input-text inputNewCss" value="${product.mpIDVersion}" id="mpIDVersion" name="mpIDVersion">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">药物识别符MPID：</label>
							<input type="text" class="input-text inputNewCss" value="${product.mpID}" id="mpID" name="mpID">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">PhPIDVersion：</label>
							<input type="text" class="input-text inputNewCss" value="${product.phpIDVersion}" id="phpIDVersion" name="phpIDVersion">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">药品识别符PhPID：</label>
							<input type="text" class="input-text inputNewCss" value="${product.phpID}" id="phpID" name="phpID">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">获得国家代码：</label>
							<input type="text" class="input-text inputNewCss" value="${product.obtainedCountry}"  id="obtainedCountry" name="obtainedCountry">
						</div>
					<div class="col-sm-3 col-xs-12 mt-5" style="margin-top: 15px;">
						<div class="skin-minimal mt-1">
			    				<div class="radio-box ">
									<input type="checkbox" id="researchProduct" name="researchProduct" value="1" <c:if test="${product.researchProduct == '1'}">checked="checked"</c:if>>
									<label for="researchProduct">研究药品</label>
								</div>
							</div>
					</div>
			
						<div class="col-sm-3 col-xs-12 mt-5" style="margin-top: 15px;">
						 <div class="skin-minimal mt-1">
			    				<div class="radio-box ">
									<input type="checkbox" id="blinded1" name="blinded1" value="1" <c:if test="${product.blinded == '1'}">checked="checked"</c:if>>
									<label for="blinded">设盲产品</label>
								</div>
							</div>
					  </div>
						
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl"><span class="c-red">*</span>国产/进口：</label>
							<div class="skin-minimal mt-1">
			    				<div class="radio-box ">
									<input type="checkbox" id="domestic1" name="domestic1" value="1" <c:if test="${product.domestic == '1'}">checked="checked"</c:if>>
									<label for="igj1">国产</label>
								</div>
			    				<div class="radio-box ">
									<input type="checkbox" id="domestic" name="domestic" value="2" <c:if test="${product.domestic == '2'}">checked="checked"</c:if>>
									<label for="igj2">进口</label>
								</div>
							</div>
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">上市持有人许可授权号：</label>
							<input type="text" class="input-text inputNewCss" value="${product.authorisationNumber}" id="authorisationNumber" name="authorisationNumber">
						</div>
						
						
						<input type="hidden" class="input-text inputNewCss" value="${product.authorisationCountry}" name="xkmc">
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">上市许可申请国家：</label>
							<span class="select-box"> 
								<select name="authorisationCountry" id="authorisationCountry"  class="select" onchange="getCode($(this))" >
									
								</select>
							</span> 
						</div>
						
	 					<input type="hidden" class="input-text inputNewCss" value="${product.holderName}" name="aabb">
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl"><span class="c-red">*</span>上市许可持有人名称：</label>
							<span class="select-box"> 
								<select name="holderName" id="holderName"  class="select" >
									
								</select>
							</span> 
						</div>
						
						
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl"><span class="c-red">*</span>剂型：</label>
							<input type="hidden" class="input-text inputNewCss" value="${product.dosageForm}" name="dosage">
							<span class="select-box"> 
								<select name="DoseForm" id="DoseForm"  class="select" >
								</select>
							</span> 
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							 <label class="form-label textl"><span class="c-red">*</span>规格：</label>
							 <input type="text" class="input-text inputNewCss" value="${product.strength}"  id="strength" name="strength"> 
						</div>
						
						<div class="col-sm-3 col-xs-12 mt-5">
							 <label class="form-label textl">最小包装规格：</label>
							 <input type="text" class="input-text inputNewCss" value="${product.miniPackingSpecification}"  id="miniPackingSpecification" name="miniPackingSpecification"> 
						</div>
						
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">给药途径：</label>
							<input type="hidden" class="input-text inputNewCss" value="${product.approach}" name="roach">
							<span class="select-box">
								<select name="DrugAdministrationRoute" class="select" id="DrugAdministrationRoute" >
									 
								</select>
							</span>
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl"><span class="c-red">*</span>批准文号：</label>
							<div style="display:flex">
							<input type="text" class="input-text inputNewCss" value="国药准字"  style="width:60px"/>
							<input  type="text" class="input-text inputNewCss" value="${product.cfdadrugCode}"  id="CFDADrugCode" name="CFDADrugCode">
							</div>
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl"><span class="c-red">*</span>生产厂家：</label>
							<input type="text" class="input-text inputNewCss" value="${product.manufacturer}" id="manufacturer" name="manufacturer">
						</div>
					
					 <div class="col-sm-3 col-xs-12 mt-5" style="margin-top: 25px;padding-bottom:5px">
						<div class="skin-minimal mt-1">
			    			<div class="radio-box ">
								<input type="checkbox" id="essentialDrug" name="essentialDrug" value="1" style=" margin-left: 10px;" <c:if test="${product.essentialDrug == '1'}">checked="checked"</c:if>>
								<label for="isReported1"><span class="c-red">*</span>是否国家基本药物</label>
						 	</div>
						</div>
					 </div>
					 <!--adds  -->
					  <div class="col-sm-3 col-xs-12 mt-5" style="margin-top: 25px;padding-bottom:5px">
						<div class="skin-minimal mt-1">
			    			<div class="radio-box ">
								<input type="checkbox" id="newMedicine" name="newMedicine" value="1" style=" margin-left: 10px;" <c:if test="${product.newMedicine == '1'}">checked="checked"</c:if>>
								<label for="newMedicine1"><span class="c-red">*</span>是否创新药</label>
						 	</div>
						</div>
					 </div>
						
					  <div class="col-sm-3 col-xs-12 mt-5" style="margin-top: 25px;padding-bottom:5px">
							<div class="skin-minimal mt-1">
			    				 <div class="radio-box ">
									<input type="checkbox" id="medicareDrug" name="medicareDrug" value="1" style=" margin-left: 10px;" <c:if test="${product.medicareDrug == '1'}">checked="checked"</c:if>>
									<label for="ylbx1"><span class="c-red">*</span>国家医疗保险药品</label>
						 		</div>
							</div>
					  </div>
				
						
					  <div class="col-sm-3 col-xs-12 mt-5" style="margin-top: 25px;padding-bottom:5px">
					  		<div class="skin-minimal mt-1">
			    				 <div class="radio-box ">
									<input type="checkbox" id="otc" name="otc" value="1" style=" margin-left: 10px;" <c:if test="${product.otc == '1'}">checked="checked"</c:if>>
									<label for="fcfy1">国家非处方药</label>
								 </div>
							</div>
					  </div>
						
					  <div class="col-sm-3 col-xs-12 mt-5" style="padding-top:20px;padding-bottom:5px">
					  	<div class="skin-minimal mt-1">
			    			 <div class="radio-box ">
								<input type="checkbox" id="protective" name="protective" value="1" style=" margin-left: 10px;"<c:if test="${product.protective == '1'}">checked="checked"</c:if>>
								<label for="zybhpz1"><span class="c-red">*</span>中药保护品种</label>
							 </div>
						</div>
					 </div>
					 
					 <!--adds  -->
					  <div class="col-sm-3 col-xs-12 mt-5" style="padding-top:20px;padding-bottom:5px">
					  	<div class="skin-minimal mt-1">
			    			 <div class="radio-box ">
								<input type="checkbox" id="dbaFeedback" name="dbaFeedback" value="1" style=" margin-left: 10px;"<c:if test="${product.dbaFeedback == '1'}">checked="checked"</c:if>>
								<label for="dbaFeedback1"><span class="c-red">*</span>是否申请数据反馈</label>
							 </div>
						</div>
					 </div>
					
					 
					
					 
					 	<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">浓度：</label>
							<input type="text" class="input-text inputNewCss" value="${product.concentration}" id="concentration" name="concentration">
						</div>
						
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl"><span class="c-red">*</span>注册日期：</label>
							<input type="text" class="input-text inputNewCss" value="${product.registerDate}" id="registerDate" name="registerDate">
						</div>
						
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl"><span class="c-red">*</span>批准文号注册日期：</label>
							<input type="text" class="input-text inputNewCss" value="${product.cfdaRegistrationDate}" id="cfdaRegistrationDate" name="cfdaRegistrationDate">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">国际诞生日：</label>
							<input type="text" class="input-text inputNewCss" value="${product.nationalDate}"  id="nationalDate" name="nationalDate">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5" style="margin-left:-4px;">
							<label class="form-label textl">新药检测截至时间：</label>
							<input type="text" class="input-text inputNewCss" value="${product.deadline}"  id="deadline" name="deadline">
						</div>
						<div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl">首次再注册时间：</label>
							<input type="text" class="input-text inputNewCss" value="${product.reRegisterDate}"  id="reRegisterDate" name="reRegisterDate">
						</div>
						
					 <div class="col-sm-3 col-xs-12 mt-5" style="margin-top: 25px;">
						 <div class="skin-minimal mt-1">
			    			<div class="radio-box ">
								<input type="checkbox" id="daersStatus" name="daersStatus" value="1" style=" margin-left: 10px;" <c:if test="${product.daersStatus == '1'}">checked="checked"</c:if>>
								<label for="zbxtzt1">同步直报系统状态</label>
							</div>
						</div>
					 </div>
					 <!--adds  -->
					 
					 <div class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl"><span class="c-red">*</span>OTC标记：</label>
							<div class="skin-minimal mt-1">
			    				<div class="radio-box ">
									<input type="checkbox" id="otcstamp" name="otcstamp" value="1" <c:if test="${product.otcstamp == '1'}">checked="checked"</c:if>>
									<label for="otcstamp1">OTC</label>
								</div>
			    				<div class="radio-box ">
									<input type="checkbox" id="otcstamp1" name="otcstamp1" value="2" <c:if test="${product.otcstamp == '2'}">checked="checked"</c:if>>
									<label for="otcstamp2">非OTC</label>
								</div>
								<div class="radio-box ">
									<input type="checkbox" id="otcstamp2" name="otcstamp2" value="3" <c:if test="${product.otcstamp == '3'}">checked="checked"</c:if>>
									<label for="otcstamp3">双跨</label>
								</div>
							</div>
						</div>
						  <!--adds  -->
						 <div  class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl"><span class="c-red">*</span>OTC类型：</label>
							<div class="skin-minimal mt-1">
			    				<div class="radio-box ">
									<input type="checkbox" id="otctype" name="otctype" value="1" <c:if test="${product.otctype == '1'}">checked="checked"</c:if>>
									<label for="otctype1">甲类</label>
								</div>
			    				<div class="radio-box ">
									<input type="checkbox" id="otctype" name="otctype" value="2" <c:if test="${product.otctype == '2'}">checked="checked"</c:if>>
									<label for="otctype2">乙类</label>
								</div>
								
							</div>
						</div>
					
						<div class="col-sm-3 col-xs-12 mt-5" >
							<input type="hidden" class="input-text inputNewCss" value="${product.viewOrder}" id="viewOrder" name="viewOrder">
						</div>
						<!--adds  -->
						 <div style="margin-left:40px;margin-right:800px" class="col-sm-3 col-xs-12 mt-5">
							<label class="form-label textl"><span class="c-red">*</span>辅料信息：</label>
							<input type="text" style="width:1000px;height:60px" class="input-text inputNewCss" value="${product.trims}"  id="trims" name="trims">
						</div>
						<!--adds  -->
						 <div class="col-sm-3 col-xs-12 mt-5"  style="margin-left:40px">
							<label class="form-label textl">备注：</label>
							<input type="text" style="width:1000px;height:60px" class="input-text inputNewCss" value="${product.remark}"  id="remark" name="remark">
						</div>
						
			
						
					</form>
				</div>
			</div>
			<div class="row cl mt-15">
				<div class="col-xs-12 text-c">
					<button type="button" class="btn btn-success" onclick="edit()"><i class="fa fa-save"></i> 保存</button>
				</div>
			</div>
				
		</div>
		
		<script type="text/javascript" src="static/akehu1/jquery/jquery-1.11.0.min.js" ></script>
		<script type="text/javascript" src="static/js/jquery.ztree.core.js" ></script>
		<script type="text/javascript" src="static/js/jquery.ztree.excheck.js" ></script>
		<script type="text/javascript" src="static/js/jquery.ztree.exedit.js" ></script>
		<script type="text/javascript" src="static/akehu/jsPlugin/laydate/laydate.js" ></script>
		<script type="text/javascript" src="static/akehu/jsPlugin/icheck/jquery.icheck.min.js" ></script>
		<script type="text/javascript" src="static/akehu/jsPlugin/layer-v3.0.1/layer/layer.js" ></script>
		<script type="text/javascript">
		var companyInfo=null;
		var beforeHolderName;
		$(function () {
		    $("#tuo").hover(
		    function(){
		        $(this).addClass("open");
		    },
		    function(){
		        $(this).removeClass("open");
		    });

		});
		$(function () {
		    $("#tuos").hover(
		    function(){
		        $(this).addClass("open");
		    },
		    function(){
		        $(this).removeClass("open");
		    });

		});
		$(function () {
		    $("#tuoes").hover(
		    function(){
		        $(this).addClass("open");
		     
		    },
		    function(){
		        $(this).removeClass("open");
		    });

		});
		$(function () {
		    $("#one").hover(
		    function(){
		        $(this).addClass("open");
		    },
		    function(){
		        $(this).removeClass("open");
		    });

		});
		$(function () {
		    $("#three").hover(
		    function(){
		        $(this).addClass("open");
		    },
		    function(){
		        $(this).removeClass("open");
		    });

		});
		$(function () {
		    $("#threes").hover(
		    function(){
		        $(this).addClass("open");
		    },
		    function(){
		        $(this).removeClass("open");
		    });

		});
		$(function () {
		    $("#threees").hover(
		    function(){
		        $(this).addClass("open");
		    },
		    function(){
		        $(this).removeClass("open");
		    });

		});
		function tru(){
			
			$("#fi").css("display","block");
		}
		
		
		function c0(obj){			
			for(var i=0;i<51;i++){
				if(obj == i){
					var sa=$("#z"+i);
					var option="";
					option+='<option style="display:none" selected value="'+sa.text()+'">'+sa.text()+'</option>';
					$("#drugClass").html(option);			
					$("#fi").css("display","none");	
				}
						
			}
		
		}
		
		
		$(function(){
			getCurrentUser();
			var selectValue = $("#DoseForm").attr("name");
			var selectValue2 =$("#DrugAdministrationRoute").attr("name");
			var paramEn = {"paramEn":selectValue};
			var paramEn2 ={"paramEn":selectValue2};
			$.ajax({
				url:"../basedata/keepController.do",
				type:"post",
				dataType:"json",
				data:paramEn,
				async:false,
				success:function(data){
					var html="";
					var value = data.content;
					value = JSON.parse(value);
					html+="<option value=''>-请选择-</option>";
					var jix = $("input[name='dosage']").val();
					for(var i=0;i<value.DoseForm.length;i++){
						var selected = "";
						if(jix==value.DoseForm[i].parameterTitle){
							selected = "selected='selected'";
						}
						html+="<option "+selected+"   value='"+value.DoseForm[i].parameterTitle+"'>"+value.DoseForm[i].parameterTitle+"</option>";
					}
					$("#DoseForm").html(html);
				}
			});
			
			
			$.ajax({
				url:"../basedata/keepController.do",
				type:"post",
				dataType:"json",
				data:paramEn2,
				async:false,
				success:function(data){
					var html2="";
					var value = data.content;
					value = JSON.parse(value);
					var approch = $("input[name='roach']").val();
					html2+="<option value=''>-请选择-</option>";
					for(var i=0;i<value.DrugAdministrationRoute.length;i++){
						var selected = "";
						if(approch==value.DrugAdministrationRoute[i].parameterTitle){
							selected = "selected='selected'";
						}
						html2+="<option   "+selected+" value='"+value.DrugAdministrationRoute[i].parameterTitle+"'>"+value.DrugAdministrationRoute[i].parameterTitle+"</option>";
					}
					$("#DrugAdministrationRoute").html(html2);
				}
			});
			
			
			getLicenseHolderCode();
			
			$.ajax({
				url:"../basedata/getAllCountry.htm",
				dataType:"json",
				async:false,
				success:function(data){
					html4="";
					var xkmc = $("input[name='xkmc']").val();
					html4+="<option value=''>-请选择-</option>";
					for(var c=0;c<data.length;c++){
						var selected = "";
						if(xkmc==data[c].CountryChineseName){
							selected = "selected='selected'";
						}
						html4+="<option "+selected+" value='"+data[c].CountryChineseName+"' name='"+data[c].CountryCode+"' >"+data[c].CountryChineseName+"</option>";
					}
					$("#authorisationCountry").html(html4)
				}
			});
		});
		
		function getLicenseHolderCode(){
			var mahId=$("#mahCode").val();
			var html3="";
			html3+="<option value=''>-请选择-</option>";
			if(companyValue!=null && companyValue!=""){
				for(var p=0;p<companyValue.length;p++){
					var selected = "";
					if(companyValue[p].hodelStatus==1){
						if(mahId==companyValue[p].caseIDCode){
							selected = "selected='selected'";
						}
						html3+="<option "+selected+" value='"+companyValue[p].caseIDCode+"' name='"+companyValue[p].caseIDCode+"'>"+companyValue[p].companyFullName+"</option>";
					}
				}
			}
			$("#holderName").html(html3);
			beforeHolderName=$("#holderName option:selected").text();
		}
		
			function getCode(item){
			
			var x=item[0].selectedIndex;
			var aa=item.children(":eq("+x+")").attr("name");
			$("#obtainedCountry").attr("value",aa);
			}
			
			
			$(function(){
				$('.skin-minimal input').iCheck({
					checkboxClass: 'icheckbox-blue',
					radioClass: 'iradio-blue',
					increaseArea: '20%'
				});
				
				laydate.render({elem:"#registerDate"});
				laydate.render({elem:"#cfdaRegistrationDate"});
				laydate.render({elem:"#nationalDate"});
				laydate.render({elem:"#deadline"});
				laydate.render({elem:"#reRegisterDate"});
			});
			
			function edit(){
				/* 把所有的初始值变成2，如果选择了，会变成1 */ //1代表选中，2代表没选中(国产/进口除外 0代表都没选)
				var researchProduct='2';
				var blinded='2';
				var domestic='0';
				var essentialDrug='2';
				var medicareDrug='2';
				var otc='2';
				var protective='2';
				var daersStatus='0';
				$("input[type='checkbox']").each(function(){
					if(this.checked){
						var thId = this.id;
						if(thId.indexOf("researchProduct")>=0){
							researchProduct=this.value;
						}else if(thId.indexOf("blinded")>=0){
							blinded=this.value;
						}else if(thId.indexOf("domestic")>=0){
							domestic=this.value;//进口
						} else if(thId.indexOf("domestic1")>=0){
							domestic=this.value;//国产
						}else if(thId.indexOf("essentialDrug")>=0){
							essentialDrug=this.value;
						}else if(thId.indexOf("otc")>=0){
							otc=this.value;
						}else if(thId.indexOf("protective")>=0){
							protective=this.value;
						}else if(thId.indexOf("daersStatus")>=0){
							daersStatus=this.value;
						}else if(thId.indexOf("medicareDrug")>=0){
							medicareDrug=this.value;
						}else{
							
						}
					}
				});
				var drugId = $("#drugId").val();
				
				var afterHolderName=$("#holderName option:selected").text();
				if($("#productName").val()==null || $("#productName").val()==""){
					layer.msg("请输入药品名称!!");
					return false;
				}else if($("#genericChineseName").val()==null || $("#genericChineseName").val()==""){
					layer.msg("请输入通用名称!!");
					return false;
				}else if($("#drugClass").val()==null || $("#drugClass").val()==""){
					layer.msg("请选择药品分类!!");
					return false;
				}else if($("#holderName").val()==null || $("#holderName").val()==""){
					layer.msg("请选择上市许可证持有人!!");
					return false;
				}else if($("#DoseForm").val()==null || $("#DoseForm").val()==""){
					layer.msg("请选择剂型!!");
					return false;
				}else if($("#CFDADrugCode").val()==null || $("#CFDADrugCode").val()==""){
					layer.msg("请输入批准文号!!");
					return false;
				}else if($("#manufacturer").val()==null || $("#manufacturer").val()==""){
					layer.msg("请输入生产厂家!!");
					return false;
				}else if($("#registerDate").val()==null || $("#registerDate").val()==""){
					layer.msg("请输入注册日期!!");
					return false;
				}else if($("#cfdaRegistrationDate").val()==null || $("#cfdaRegistrationDate").val()==""){
					layer.msg("请输入批准文号注册日期!!");
					return false;
				}else{
					$.ajax({
						type:"post",
						url:"../basedata/updateProduct.do",
						data:{
							"productID":drugId,
							"productName":$("#productName").val(),
							"brandChineseName":$("#brandChineseName").val(),
							"brandEnglishName":$("#brandEnglishName").val(),
							"genericChineseName":$("#genericChineseName").val(),
							"genericEnglishName":$("#genericEnglishName").val(),
							"drugClass":$("#drugClass").val(),
							"productCode":$("#productCode").val(),
							"mpIDVersion":$("#mpIDVersion").val(),
							"mpID":$("#mpID").val(),
							"phpIDVersion":$("#phpIDVersion").val(),
							"phpID":$("#phpID").val(),
							"obtainedCountry":$("#obtainedCountry").val(),
							"researchProduct":researchProduct,
							"blinded":blinded,
							"domestic":domestic,
							"authorisationNumber":$("#authorisationNumber").val(),
							"authorisationCountry":$("#authorisationCountry").val(),
							"holderName":$("#holderName").val(),
							/* "holderNameCode":$("#holderName").attr("name"); */
							"dosageForm":$("#DoseForm").val(),
							"strength":$("#strength").val(),
							"approach":$("#DrugAdministrationRoute").val(),
							"cfdadrugCode":$("#CFDADrugCode").val(),
							"manufacturer":$("#manufacturer").val(),
							"concentration":$("#concentration").val(),
							"essentialDrug":essentialDrug,
							"medicareDrug":medicareDrug,
							"otc":otc,
							"protective":protective,
							"registerDate":$("#registerDate").val(),
							"nationalDate":$("#nationalDate").val(),
							"deadline":$("#deadline").val(),
							"reRegisterDate":$("#reRegisterDate").val(),
							"daersStatus":daersStatus,
							"viewOrder":$("#viewOrder").val(),
							"afterHolderName":afterHolderName,
							"beforeHolderName":beforeHolderName,
							"userInfo":getUserInfo(),
							"miniPackingSpecification":$("#miniPackingSpecification").val(),
							"cfdaRegistrationDate":$("#cfdaRegistrationDate").val()
							},
						success:function(msg){
							if(msg == 'true') {
								layer.msg("保存成功");
							}else {
								layer.msg("保存失败");
							}
							
						}
					});
				}
			}
			
			
			function getCurrentUser(){
				$.ajax({
					url :  "../../system/getSession",
				    type:"post",
				    async:false,
				    success:function(data){
				    	if(data!=null&&data!=undefined&&data!="null"&&data!=""){
				    		sessionStorage.setItem("userInfo", JSON.stringify(data));
				    		data = JSON.parse(data);
					    	if(data.companyInfo!=null && data.companyInfo!=""){
					    		companyValue = data.companyInfo;
					    		companyValue = JSON.parse(companyValue);
					    	}
				    	}else{
				    		parent.layer.alert("获取用户信息失败,请重新登录！" , {
								icon:2
							},function(){
								window.parent.location.href="/system/login?bs=1";
								  parent.layer.closeAll();
							});
				    	}
				    }
				});
			}
			
			function getUserInfo() {
				return sessionStorage.getItem("userInfo");
			}
		</script>
	</body>
</html>
