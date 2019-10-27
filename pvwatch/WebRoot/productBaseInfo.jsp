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
		
						<%-- <div class="col-sm-3 col-xs-12 mt-5">
							<label  class="form-label textl"><!-- <span class="c-red">*</span> -->药品分类：</label>							
							
								<select name="" onclick="tru();"  style="width:150px;" class="select" id="drugClass">
								 <option style="display:none" value="" <c:if test="${product.drugClass == ''}">selected="selected"</c:if>></option>
								 <option style="display:none" value="1类" <c:if test="${product.drugClass == '1类'}">selected="selected"</c:if>>1类</option>
								 <option style="display:none" value="2类" <c:if test="${product.drugClass == '2类'}">selected="selected"</c:if>>2类</option>
								 <option style="display:none" value="3类" <c:if test="${product.drugClass == '3类'}">selected="selected"</c:if>>3类</option>
								 <option style="display:none" value="4类" <c:if test="${product.drugClass == '4类'}">selected="selected"</c:if>>4类</option>
								 <option style="display:none" value="5类" <c:if test="${product.drugClass == '5类'}">selected="selected"</c:if>>5类</option>
								 <option style="display:none" value="6类" <c:if test="${product.drugClass == '6类'}">selected="selected"</c:if>>6类</option>
								 <option style="display:none" value="6.1类" <c:if test="${product.drugClass == '6.1类'}">selected="selected"</c:if>>6.1类</option>
								 <option style="display:none" value="6.2类" <c:if test="${product.drugClass == '6.2类'}">selected="selected"</c:if>>6.2类</option>
								 <option style="display:none" value="6.3类" <c:if test="${product.drugClass == '6.3类'}">selected="selected"</c:if>>6.3类</option>
								 <option style="display:none" value="7类" <c:if test="${product.drugClass == '7类'}">selected="selected"</c:if>>7类</option>
								 <option style="display:none" value="8类" <c:if test="${product.drugClass == '8类'}">selected="selected"</c:if>>8类</option>
								 <option style="display:none" value="9类" <c:if test="${product.drugClass == '9类'}">selected="selected"</c:if>>9类</option>
								 <option style="display:none" value="治疗用1类" <c:if test="${product.drugClass == '治疗用1类'}">selected="selected"</c:if>>治疗用1类</option>
								 <option style="display:none" value="治疗用2类" <c:if test="${product.drugClass == '治疗用2类'}">selected="selected"</c:if>>治疗用2类</option>
								 <option style="display:none" value="治疗用3类" <c:if test="${product.drugClass == '治疗用3类'}">selected="selected"</c:if>>治疗用3类</option>
								 <option style="display:none" value="治疗用4类" <c:if test="${product.drugClass == '治疗用4类'}">selected="selected"</c:if>>治疗用4类</option>
								 <option style="display:none" value="治疗用5类" <c:if test="${product.drugClass == '治疗用5类'}">selected="selected"</c:if>>治疗用5类</option>
								 <option style="display:none" value="治疗用6类" <c:if test="${product.drugClass == '治疗用6类'}">selected="selected"</c:if>>治疗用6类</option>
								 <option style="display:none" value="治疗用7类" <c:if test="${product.drugClass == '治疗用7类'}">selected="selected"</c:if>>治疗用7类</option>
								 <option style="display:none" value="治疗用8类" <c:if test="${product.drugClass == '治疗用8类'}">selected="selected"</c:if>>治疗用8类</option>
								 <option style="display:none" value="治疗用9类" <c:if test="${product.drugClass == '治疗用9类'}">selected="selected"</c:if>>治疗用9类</option>
								 <option style="display:none" value="治疗用10类" <c:if test="${product.drugClass == '治疗用10类'}">selected="selected"</c:if>>治疗用10类</option>
								 <option style="display:none" value="治疗用11类" <c:if test="${product.drugClass == '治疗用11类'}">selected="selected"</c:if>>治疗用11类</option>
								 <option style="display:none" value="治疗用12类" <c:if test="${product.drugClass == '治疗用12类'}">selected="selected"</c:if>>治疗用12类</option>
								 <option style="display:none" value="治疗用13类" <c:if test="${product.drugClass == '治疗用13类'}">selected="selected"</c:if>>治疗用13类</option>
								 <option style="display:none" value="治疗用14类" <c:if test="${product.drugClass == '治疗用14类'}">selected="selected"</c:if>>治疗用14类</option>
								 <option style="display:none" value="治疗用15类" <c:if test="${product.drugClass == '治疗用15类'}">selected="selected"</c:if>>治疗用15类</option>
								 <option style="display:none" value="预防用1类" <c:if test="${product.drugClass == '预防用1类'}">selected="selected"</c:if>>预防用1类</option>
								 <option style="display:none" value="预防用2类" <c:if test="${product.drugClass == '预防用2类'}">selected="selected"</c:if>>预防用2类</option>
								 <option style="display:none" value="预防用3类" <c:if test="${product.drugClass == '预防用3类'}">selected="selected"</c:if>>预防用3类</option>
								 <option style="display:none" value="预防用4类" <c:if test="${product.drugClass == '预防用4类'}">selected="selected"</c:if>>预防用4类</option>
								 <option style="display:none" value="预防用5类" <c:if test="${product.drugClass == '预防用5类'}">selected="selected"</c:if>>预防用5类</option>
								 <option style="display:none" value="预防用6类" <c:if test="${product.drugClass == '预防用6类'}">selected="selected"</c:if>>预防用6类</option>
								 <option style="display:none" value="预防用7类" <c:if test="${product.drugClass == '预防用7类'}">selected="selected"</c:if>>预防用7类</option>
								 <option style="display:none" value="预防用8类" <c:if test="${product.drugClass == '预防用8类'}">selected="selected"</c:if>>预防用8类</option>
								 <option style="display:none" value="预防用9类" <c:if test="${product.drugClass == '预防用9类'}">selected="selected"</c:if>>预防用9类</option>
								 <option style="display:none" value="预防用10类" <c:if test="${product.drugClass == '预防用10类'}">selected="selected"</c:if>>预防用10类</option>
								 <option style="display:none" value="预防用11类" <c:if test="${product.drugClass == '预防用11类'}">selected="selected"</c:if>>预防用11类</option>
								 <option style="display:none" value="预防用12类" <c:if test="${product.drugClass == '预防用12类'}">selected="selected"</c:if>>预防用12类</option>
								 <option style="display:none" value="预防用13类" <c:if test="${product.drugClass == '预防用13类'}">selected="selected"</c:if>>预防用13类</option>
								 <option style="display:none" value="预防用14类" <c:if test="${product.drugClass == '预防用14类'}">selected="selected"</c:if>>预防用14类</option>
								 <option style="display:none" value="预防用15类" <c:if test="${product.drugClass == '预防用15类'}">selected="selected"</c:if>>预防用15类</option>
								 <option style="display:none" value="化学药品第1类" <c:if test="${product.drugClass == '化学药品第1类'}">selected="selected"</c:if>>化学药品第1类</option>
								 <option style="display:none" value="化学药品第2.1类" <c:if test="${product.drugClass == '化学药品第2.1类'}">selected="selected"</c:if>>化学药品第2.1类</option>
								 <option style="display:none" value="化学药品第2.2类" <c:if test="${product.drugClass == '化学药品第2.2类'}">selected="selected"</c:if>>化学药品第2.2类</option>
								 <option style="display:none" value="化学药品第2.3类" <c:if test="${product.drugClass == '化学药品第2.3类'}">selected="selected"</c:if>>化学药品第2.3类</option>
								 <option style="display:none" value="化学药品第2.4类" <c:if test="${product.drugClass == '化学药品第2.4类'}">selected="selected"</c:if>>化学药品第2.4类</option>
								 <option style="display:none" value="化学药品第3类" <c:if test="${product.drugClass == '化学药品第3类'}">selected="selected"</c:if>>化学药品第3类</option>
								 <option style="display:none" value="化学药品第4类" <c:if test="${product.drugClass == '化学药品第4类'}">selected="selected"</c:if>>化学药品第4类</option>
								 <option style="display:none" value="化学药品第5.1类" <c:if test="${product.drugClass == '化学药品第5.1类'}">selected="selected"</c:if>>化学药品第5.1类</option>
								 <option style="display:none" value="化学药品第5.2类" <c:if test="${product.drugClass == '化学药品第5.2类'}">selected="selected"</c:if>>化学药品第5.2类</option>
						         <option style="display:none" value="原化学药品第1.1类" <c:if test="${product.drugClass == '原化学药品第1.1类'}">selected="selected"</c:if>>原化学药品第1.1类</option>
						         <option style="display:none" value="原化学药品第1.2类" <c:if test="${product.drugClass == '原化学药品第1.2类'}">selected="selected"</c:if>>原化学药品第1.2类</option>
						         <option style="display:none" value="原化学药品第1.3类" <c:if test="${product.drugClass == '原化学药品第1.3类'}">selected="selected"</c:if>>原化学药品第1.3类</option>
						         <option style="display:none" value="原化学药品第1.4类" <c:if test="${product.drugClass == '原化学药品第1.4类'}">selected="selected"</c:if>>原化学药品第1.4类</option>
						         <option style="display:none" value="原化学药品第1.5类" <c:if test="${product.drugClass == '原化学药品第1.5类'}">selected="selected"</c:if>>原化学药品第1.5类</option>
						         <option style="display:none" value="原化学药品第1.6类" <c:if test="${product.drugClass == '原化学药品第1.6类'}">selected="selected"</c:if>>原化学药品第1.6类</option>
						         <option style="display:none" value="原化学药品第2类" <c:if test="${product.drugClass == '原化学药品第2类'}">selected="selected"</c:if>>原化学药品第2类</option>
						         <option style="display:none" value="原化学药品第3.1类" <c:if test="${product.drugClass == '原化学药品第3.1类'}">selected="selected"</c:if>>原化学药品第3.1类</option>
						         <option style="display:none" value="原化学药品第3.2类" <c:if test="${product.drugClass == '原化学药品第3.2类'}">selected="selected"</c:if>>原化学药品第3.2类</option>
						         <option style="display:none" value="原化学药品第3.3类" <c:if test="${product.drugClass == '原化学药品第3.3类'}">selected="selected"</c:if>>原化学药品第3.3类</option>
						         <option style="display:none" value="原化学药品第3.4类" <c:if test="${product.drugClass == '原化学药品第3.4类'}">selected="selected"</c:if>>原化学药品第3.4类</option>
						         <option style="display:none" value="原化学药品第4类" <c:if test="${product.drugClass == '原化学药品第4类'}">selected="selected"</c:if>>原化学药品第4类</option>
						         <option style="display:none" value="原化学药品第5类" <c:if test="${product.drugClass == '原化学药品第5类'}">selected="selected"</c:if>>原化学药品第5类</option>
						         <option style="display:none" value="原化学药品第6类" <c:if test="${product.drugClass == '原化学药品第6类'}">selected="selected"</c:if>>原化学药品第6类</option>
						         <option style="display:none" value="其他" <c:if test="${product.drugClass == '其他'}">selected="selected"</c:if>>其他</option>
								 
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
						<ul class="menu"  style="z-index:20">
							<li id="tuos" class="" style="z-index:20"><a href="javascript:void(0);" style="z-index:20"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">治疗用生物制品</font></font><i class="arrow Hui-iconfont"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></i></a>
								<ul class="menu" style="z-index:20">
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
								<ul class="menu" style="z-index:22">
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
						<ul class="menu" style="z-index:33">
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
							<li id="threees" class=""><a  href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">原注册分类(2007年)</font></font><i class="arrow Hui-iconfont"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></i></a>
								<ul class="menu" style="z-index:10">
									<li  class=""><a onclick="c0(51)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z51">原化学药品第1.1类</span></font></font></a></li>
									<li><a onclick="c0(52)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z52">原化学药品第1.2类</span></font></font></a></li>
									<li><a onclick="c0(53)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z53">原化学药品第1.3类</span></font></font></a></li>
									<li><a onclick="c0(54)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z54">原化学药品第1.4类</span></font></font></a></li>
									<li><a onclick="c0(55)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z55">原化学药品第1.5类</span></font></font></a></li>
									<li><a onclick="c0(56)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z56">原化学药品第1.6类</span></font></font></a></li>
									<li><a onclick="c0(57)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z57">原化学药品第2类</span></font></font></a></li>
									<li><a onclick="c0(58)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z58">原化学药品第3.1类</span></font></font></a></li>
									<li><a onclick="c0(59)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z59">原化学药品第3.2类</span></font></font></a></li>
									<li><a onclick="c0(60)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z60">原化学药品第3.3类</span></font></font></a></li>
									<li><a onclick="c0(61)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z61">原化学药品第3.4类</span></font></font></a></li>
									<li><a onclick="c0(62)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z62">原化学药品第4类</span></font></font></a></li>
									<li><a onclick="c0(63)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z63">原化学药品第5类</span></font></font></a></li>
									<li><a onclick="c0(64)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z64">原化学药品第6类</span></font></font></a></li>
								</ul>
							</li>
						</ul>
					</li>
					<li ><a onclick="c0(65)" href="javascript:void(0);"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><span id="z65">其他</span></font></font></a></li>
				</ul>	
						</div> --%>
						
						 <div class="col-sm-3 col-xs-12 mt-5" style="margin-top: 25px;padding-bottom:5px">
					  		<div class="skin-minimal mt-1">
			    				 <div class="radio-box ">
									<label for="fcfy1"><span style="color:red">*</span>OTC标记:</label>
								 </div>
									<input type="checkbox" onclick="otc1()"  id="otc1" name="otc" value="1" style=" <c:if test="${product.otc == '1'}">checked="checked"</c:if>>
									<label for="fcfy1"><span  style="color:red">*</span>OTC</label>
									<input type="checkbox" onclick="otc2()"  id="otc2"  name="otc" value="2" style="  <c:if test="${product.otc == '2'}">checked="checked"</c:if>>
									<label for="fcfy1"><span style="color:red">*</span>非OTC</label>
									<input type="checkbox"  onclick="otc3()"  id="otc3"  name="otc" value="3" style=" <c:if test="${product.otc == '3'}">checked="checked"</c:if>>
									<label for="fcfy1"><span style="color:red">*</span>双跨</label>
							</div>
					 	 </div>
					 	  
					 	
					 		 <div id="otcTypesSelected" class="col-sm-3 col-xs-12 mt-5" style="margin-top: 25px;padding-bottom:5px">
			    				 <div class="radio-box ">
								<span style="color:red">*</span>OTC类型:	<input type="checkbox"  name="otc" value="1" style=" margin-left: 10px;" <c:if test="${product.otc == '1'}">checked="checked"</c:if>>
									<label for="fcfy1">甲类</label>
								 </div>
			    				 <div class="radio-box ">
									<input type="checkbox" id="otc" name="otc" value="2" style=" margin-left: 10px;" <c:if test="${product.otc == '2'}">checked="checked"</c:if>>
									<label for="fcfy1">乙类</label>
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
		$(function () {
			$("#otcTypesSelected").hide();
			
			
			
		    $("#tuo").hover(
		    function(){
		        $(this).addClass("open");
		    },
		    function(){
		        $(this).removeClass("open");
		    });
		    
		});
		
		function otc1(){
				$("#otcTypesSelected").show();
				$('#otc2').removeAttr('checked');
				$('#otc3').removeAttr('checked');
		}
		function otc2(){
			$("#otcTypesSelected").hide();
			$('#otc1').removeAttr('checked');
			$('#otc3').removeAttr('checked');
		}
		function otc3(){
			$("#otcTypesSelected").show();
			$('#otc1').removeAttr('checked');
			$('#otc2').removeAttr('checked');
		}
		
		
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
				for(var i=0;i<66;i++){
					if(obj == i){
						var sa=$("#z"+i);
						var option="";
						option+='<option style="display:none" selected value="'+sa.text()+'">'+sa.text()+'</option>';
						$("#drugClass").html(option);			
						$("#fi").css("display","none");	
					}
							
				}
			
			}
		
	
		</script>
	</body>
</html>
