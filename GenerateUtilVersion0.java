package com.google.demoForIdea.takeFile;

import com.nj_profit.rest.bo.*;

import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateUtil {

    public static final String baseXmlPath = "D:\\poin\\workspace2\\nj_profit\\src\\main\\resources\\META-INF\\orm\\sqlserverhx\\";
    public static final String baseHtmlPath = "D:\\poin\\workspace2\\nj_profit\\src\\main\\webapp\\htmlRoot\\src-server-manager\\";
    public static final String baseJsPath = "D:\\poin\\workspace2\\nj_profit\\src\\main\\webapp\\htmlRoot\\src-server-manager\\js\\";

    public static final String baseSrcPath = "D:\\poin\\workspace2\\nj_profit\\src\\main\\java\\com\\nj_profit\\rest\\";
    public static final String basePackage = "com.njcebbank";
    public static final String mapperPath = "hexindao";
    public static final String serviceImplPath = "impl";
    public static final String servicePath = "service";
    public static final String controllerPath = "resource";
    public static final String voPath = "vo";

    public static void main(String[] args)throws Exception{
        Comment comment = new Comment();
        comment.setAuthor("wangjiaming");
        comment.setCreateTime(new Date());
        comment.setDesc("");

        Map<String,Class> map = new HashMap<>();
        //map.put("kj_server_config",KjServerConfig.class);
        //map.put("kj_server_log",KjServerLog.class);
        //map.put("kj_system_patch",KjSystemPatch.class);
        //map.put("kj_version_config",KjVersionConfig.class);
        //map.put("kj_version_type",KjVersionType.class);
        //map.put("kj_patch_config",KjPatchConfig.class);

        for (Map.Entry<String,Class> entry : map.entrySet()){
            Class clazz = entry.getValue();
            generateController(clazz,comment);
            generateVo(clazz,comment);
            String servicePath = generateService(clazz,comment);
            String mapperPath = generateMapper(clazz,comment);
            generateServiceImpl(clazz,servicePath,mapperPath,comment);
            generateMapperXml(clazz,mapperPath,entry.getKey());
            //generateSql();
            generateHtml(clazz);
            generateJs(clazz);
        }
    }

    private static void generateJs(Class c) {
        String entityName = GenerateUtil.getClassName(c);
        String lowerEntityName = GenerateUtil.firstLowerCase(entityName);
        String jsName = lowerEntityName+".js";
        List<ClassField> fieldList = GenerateUtil.getFieldList(c);
        GenerateBuffer gb = GenerateBuffer.getInstance();
        gb.appendSRN("$(function () {");
        gb.appendT(1).appendSRN("var queryUrl  = '/webapi/"+lowerEntityName+"/list';");
        gb.appendT(1).appendSRN("var insertUrl = '/webapi/"+lowerEntityName+"/insert';");
        gb.appendT(1).appendSRN("var updateUrl = '/webapi/"+lowerEntityName+"/update';");
        gb.appendT(1).appendSRN("var detailUrl = '/webapi/"+lowerEntityName+"/detail';");
        gb.appendT(1).appendSRN("var deleteUrl = '/webapi/"+lowerEntityName+"/deleteFakeIds';").appendRN();
        gb.appendT(1).appendSRN("var $table = $('#dataTable');");
        gb.appendT(1).appendSRN("var $searchFormBtn = $('#search-form-btn');").appendRN();
        gb.appendT(1).appendSRN("var $selectForm = $('#selectForm');").appendRN();
        gb.appendT(1).appendSRN("var $insertForm = $('#insertForm');");
        gb.appendT(1).appendSRN("var $insertOperator = $('#insertOperator');");
        gb.appendT(1).appendSRN("var $insertModal = $('#insertModal');");
        gb.appendT(1).appendSRN("var $insertSubmit = $('#submit-insert');").appendRN();
        gb.appendT(1).appendSRN("var $updateForm = $('#updateForm');");
        gb.appendT(1).appendSRN("var $updateOperator = $('#updateOperator');");
        gb.appendT(1).appendSRN("var $updateModal = $('#updateModal');");
        gb.appendT(1).appendSRN("var $updateSubmit = $('#submit-update');").appendRN();
        gb.appendT(1).appendSRN("var $deleteOperator = $('#deleteOperator');");
        gb.appendT(1).appendSRN("var $deleteModal = $('#deleteModal');");
        gb.appendT(1).appendSRN("var $deleteSubmit = $('#submit-delete');").appendRN();

        gb.appendT(1).appendSRN("$table.bootstrapTable({");
        gb.appendT(2).appendSRN("method : 'post',");
        gb.appendT(2).appendSRN("contentType : 'application/x-www-form-urlencoded',//post�������Ҫ");
        gb.appendT(2).appendSRN("url : queryUrl,");
        gb.appendT(2).appendSRN("striped : true,//������ʾ��ɫ");
        gb.appendT(2).appendSRN("pageNumber : 1,//��ʼ�����ص�һҳ");
        gb.appendT(2).appendSRN("pagination : true,//�Ƿ��ҳ");
        gb.appendT(2).appendSRN("sidePagination : 'client',//server��clientΪǰ�η�ҳ");
        gb.appendT(2).appendSRN("pageSize : 10,");
        gb.appendT(2).appendSRN("pageList : [10,20,50,100],");
        gb.appendT(2).appendSRN("showRefresh : true,//ˢ�°�ť");
        gb.appendT(2).appendSRN("search : false,");
        gb.appendT(2).appendSRN("cache : false,");
        gb.appendT(2).appendSRN("sortable : true,");
        gb.appendT(2).appendSRN("sortOrder : 'asc',");
        gb.appendT(2).appendSRN("clickToSelect : true,");
        gb.appendT(2).appendSRN("queryParams : function(params){");
        gb.appendT(3).appendSRN("var param = {};");
        for(ClassField field : fieldList){
            if(field.getFieldComment()!=null){
                String name = field.getFieldName();
                gb.appendT(3).appendSRN("var "+name+" = $('#"+name+"').val();");
                gb.appendT(3).appendSRN("if("+name+"){"+name+" = "+name+".trim();}");
                gb.appendT(3).appendSRN("param."+name+" = "+name+";");
            }
        }
        gb.appendT(3).appendSRN("return h5_encryp(JSON.stringify(param));");
        gb.appendT(2).appendSRN("},");
        gb.appendT(2).appendSRN("responseHandler:function(result){");
        gb.appendT(3).appendSRN("return h5_decrypt(result);");
        gb.appendT(2).appendSRN("},");
        gb.appendT(2).appendSRN("columns:[");
        gb.appendT(3).appendSRN("{checkbox:true},");
        for(ClassField field : fieldList){
            if(field.getFieldComment()!=null){
                gb.appendT(3).appendSRN("{field:'"+field.getFieldName()+"',title:'"+field.getFieldComment()+"', align: 'center',sortable:true},");
            }
        }
        gb.appendT(3).appendSRN("{field:'operate',title:'����',align: 'center',width: 60,formatter: btnGroup,");
        gb.appendT(4).appendSRN("events:{");
        gb.appendT(5).appendSRN("'click #selectOperator':function(event,value,row,index){ selectOperator(row.id); }");
        gb.appendT(4).appendSRN("}");
        gb.appendT(3).appendSRN("}");
        gb.appendT(2).appendSRN("]");
        gb.appendT(1).appendSRN("});").appendRN();

        gb.appendT(1).appendSRN("function btnGroup(){");
        gb.appendT(2).appendSRN("var htmlStr = '';");
        gb.appendT(2).appendSRN("htmlStr += '<a href=\"#\" class=\"btn btn-info\"   id=\"selectOperator\" data-toggle=\"modal\" data-target=\"#selectModal\" title=\"�鿴\" style=\"font-size: 12px;\"><span class=\"glyphicon glyphicon-search\" style=\"margin-right:0;\"></span></a>';");
        gb.appendT(2).appendSRN("return htmlStr;");
        gb.appendT(1).appendSRN("}").appendRN();

        gb.appendT(1).appendSRN("//������ѯ");
        gb.appendT(1).appendSRN("$searchFormBtn.click(function () {");
        gb.appendT(2).appendSRN("refreshTable();");
        gb.appendT(1).appendSRN("});").appendRN();

        gb.appendT(1).appendSRN("//ˢ�±��");
        gb.appendT(1).appendSRN("function refreshTable() {");
        gb.appendT(2).appendSRN("$table.bootstrapTable('refresh',{url:queryUrl});");
        gb.appendT(1).appendSRN("}").appendRN();

        gb.appendT(1).appendSRN("//�ύ��ť����");
        gb.appendT(1).appendSRN("function submitDisabled($btn){");
        gb.appendT(2).appendSRN("$btn.attr('disabled',true);");
        gb.appendT(1).appendSRN("}").appendRN();

        gb.appendT(1).appendSRN("//�ύ��ťȡ������");
        gb.appendT(1).appendSRN("function submitDisabledCancel($btn){");
        gb.appendT(2).appendSRN("$btn.attr('disabled',false);");
        gb.appendT(1).appendSRN("}").appendRN();

        gb.appendT(1).appendSRN("//ģ̬������");
        gb.appendT(1).appendSRN("$(\"button[type='reset']\").click(function () {");
        gb.appendT(2).appendSRN("$(this).closest('.modal-footer').siblings('.modal-body').find('form')[0].reset();");
        gb.appendT(1).appendSRN("});").appendRN();

        gb.appendT(1).appendSRN("var bootstrapValidators = {");
        gb.appendT(2).appendSRN("message: '����ֵ���Ϸ�',");
        gb.appendT(2).appendSRN("feedbackIcons: {valid:'glyphicon glyphicon-ok', invalid:'glyphicon glyphicon-remove', validating:'glyphicon glyphicon-refresh'},");
        gb.appendT(2).appendSRN("fields: {");
        for(ClassField field : fieldList){
            if(field.getFieldComment()!=null){
                gb.appendT(3).appendSRN(field.getFieldName()+": {trigger:'change',validators: {notEmpty: {message: '������"+field.getFieldComment()+"'}}},");
            }
        }
        gb.appendT(2).appendSRN("},");
        gb.appendT(2).appendSRN("excluded: [':disabled']");
        gb.appendT(1).appendSRN("};").appendRN();

        gb.appendT(1).appendSRN("//�����ú���ʽ���");
        gb.appendT(1).appendSRN("function formReset($form){");
        gb.appendT(2).appendSRN("$form[0].reset();");
        gb.appendT(2).appendSRN("$form.data('bootstrapValidator').destroy();");
        gb.appendT(2).appendSRN("$form.data('bootstrapValidator',null);");
        gb.appendT(2).appendSRN("$form.bootstrapValidator(bootstrapValidators);");
        gb.appendT(1).appendSRN("}").appendRN();

        gb.appendT(1).appendSRN("// ��ʼ��inputУ��");
        gb.appendT(1).appendSRN("$insertForm.bootstrapValidator(bootstrapValidators);");
        gb.appendT(1).appendSRN("$updateForm.bootstrapValidator(bootstrapValidators);").appendRN();

        gb.appendT(1).appendSRN("//�鿴����");
        gb.appendT(1).appendSRN("function selectOperator(rowId){");
        gb.appendT(2).appendSRN("var param = {};");
        gb.appendT(2).appendSRN("param.id = rowId;");
        gb.appendT(2).appendSRN("detail($selectForm,param);");
        gb.appendT(1).appendSRN("}").appendRN();

        gb.appendT(1).appendSRN("//��ʾ����ģ̬��");
        gb.appendT(1).appendSRN("$insertOperator.click(function () {");
        gb.appendT(2).appendSRN("$insertModal.modal();");
        gb.appendT(1).appendSRN("});").appendRN();

        gb.appendT(1).appendSRN("//�������ύ");
        gb.appendT(1).appendSRN("$insertSubmit.click(function () {");
        gb.appendT(2).appendSRN("submitDisabled($insertSubmit);");
        gb.appendT(2).appendSRN("var bv = $insertForm.data('bootstrapValidator');");
        gb.appendT(2).appendSRN("bv.validate();");
        gb.appendT(2).appendSRN("if (bv.isValid()) {");
        gb.appendT(3).appendSRN("var data = getFormData($insertForm);");
        gb.appendT(3).appendSRN("$.ajax({");
        gb.appendT(4).appendSRN("url: insertUrl,");
        gb.appendT(4).appendSRN("type: 'post',");
        gb.appendT(4).appendSRN("data: h5_encryp(JSON.stringify(data)),");
        gb.appendT(4).appendSRN("dataType: 'json',");
        gb.appendT(4).appendSRN("contentType: 'application/json',");
        gb.appendT(4).appendSRN("success: function (data) {");
        gb.appendT(5).appendSRN("data = h5_decrypt(data);");
        gb.appendT(5).appendSRN("SystemMessageShow(data);");
        gb.appendT(5).appendSRN("$insertModal.modal('hide');");
        gb.appendT(5).appendSRN("submitDisabledCancel($insertSubmit);");
        gb.appendT(5).appendSRN("formReset($insertForm);");
        gb.appendT(5).appendSRN("refreshTable();");
        gb.appendT(4).appendSRN("},");
        gb.appendT(4).appendSRN("error: function (e) {");
        gb.appendT(5).appendSRN("SystemMessageShow(SystemErrorMessage);");
        gb.appendT(5).appendSRN("submitDisabledCancel($insertSubmit);");
        gb.appendT(4).appendSRN("}");
        gb.appendT(3).appendSRN("});");
        gb.appendT(2).appendSRN("}else{");
        gb.appendT(3).appendSRN("submitDisabledCancel($insertSubmit);");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("});").appendRN();

        gb.appendT(1).appendSRN("//�ر�����ģ̬��");
        gb.appendT(1).appendSRN("$insertModal.on('hide.bs.modal',function () {");
        gb.appendT(2).appendSRN("submitDisabledCancel($insertSubmit);");
        gb.appendT(1).appendSRN("});").appendRN();

        gb.appendT(1).appendSRN("//��ʾ����ģ̬��");
        gb.appendT(1).appendSRN("$updateOperator.click(function () {");
        gb.appendT(2).appendSRN("var list = $table.bootstrapTable('getAllSelections');");
        gb.appendT(2).appendSRN("if(list.length === 1){");
        gb.appendT(3).appendSRN("$updateForm[0].reset();");
        gb.appendT(3).appendSRN("$updateModal.modal();");
        gb.appendT(2).appendSRN("}else if(list.length > 1){");
        gb.appendT(3).appendSRN("SystemMessageShow('��ѡ��һ������!');");
        gb.appendT(2).appendSRN("}else{");
        gb.appendT(3).appendSRN("SystemMessageShow('��ѡ����Ҫ�༭������!');");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("});").appendRN();

        gb.appendT(1).appendSRN("//���±��ύ");
        gb.appendT(1).appendSRN("$updateSubmit.click(function () {");
        gb.appendT(2).appendSRN("submitDisabled($updateSubmit);");
        gb.appendT(2).appendSRN("var bv = $updateForm.data('bootstrapValidator');");
        gb.appendT(2).appendSRN("bv.validate();");
        gb.appendT(2).appendSRN("if (bv.isValid()) {");
        gb.appendT(3).appendSRN("var data = getFormData($updateForm);");
        gb.appendT(3).appendSRN("$.ajax({");
        gb.appendT(4).appendSRN("url: updateUrl,");
        gb.appendT(4).appendSRN("type: 'post',");
        gb.appendT(4).appendSRN("data: h5_encryp(JSON.stringify(data)),");
        gb.appendT(4).appendSRN("dataType: 'json',");
        gb.appendT(4).appendSRN("contentType: 'application/json',");
        gb.appendT(4).appendSRN("success: function (data) {");
        gb.appendT(5).appendSRN("data = h5_decrypt(data);");
        gb.appendT(5).appendSRN("SystemMessageShow(data);");
        gb.appendT(5).appendSRN("$updateModal.modal('hide');");
        gb.appendT(5).appendSRN("submitDisabledCancel($updateSubmit);");
        gb.appendT(5).appendSRN("formReset($insertForm);");
        gb.appendT(5).appendSRN("refreshTable();");
        gb.appendT(4).appendSRN("},");
        gb.appendT(4).appendSRN("error: function (e) {");
        gb.appendT(5).appendSRN("SystemMessageShow(SystemErrorMessage);");
        gb.appendT(5).appendSRN("submitDisabledCancel($updateSubmit);");
        gb.appendT(4).appendSRN("}");
        gb.appendT(3).appendSRN("});");
        gb.appendT(2).appendSRN("}else{");
        gb.appendT(3).appendSRN("submitDisabledCancel($updateSubmit);");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("});").appendRN();

        gb.appendT(1).appendSRN("$updateModal.on('show.bs.modal',function () {");
        gb.appendT(2).appendSRN("var list = $table.bootstrapTable('getAllSelections');");
        gb.appendT(2).appendSRN("var param = {};");
        gb.appendT(2).appendSRN("param.id = list[0].id;");
        gb.appendT(2).appendSRN("detail($updateForm,param);");
        gb.appendT(1).appendSRN("});").appendRN();

        gb.appendT(1).appendSRN("$updateModal.on('hide.bs.modal',function () {");
        gb.appendT(2).appendSRN("submitDisabledCancel($updateSubmit);");
        gb.appendT(1).appendSRN("});").appendRN();

        gb.appendT(1).appendSRN("function detail($updateForm,param) {");
        gb.appendT(2).appendSRN("$.ajax({");
        gb.appendT(3).appendSRN("type: 'post',");
        gb.appendT(3).appendSRN("url: detailUrl,");
        gb.appendT(3).appendSRN("dataType: 'json',");
        gb.appendT(3).appendSRN("cache:false,");
        gb.appendT(3).appendSRN("data: h5_encryp(JSON.stringify(param)),");
        gb.appendT(3).appendSRN("contentType: 'application/json',");
        gb.appendT(3).appendSRN("success: function (data) {");
        gb.appendT(4).appendSRN("data = h5_decrypt(data);");
        gb.appendT(4).appendSRN("setFormData($updateForm,data.data);");
        gb.appendT(3).appendSRN("}");
        gb.appendT(2).appendSRN("});");
        gb.appendT(1).appendSRN("}").appendRN();

        gb.appendT(1).appendSRN("//���ñ���ֵ");
        gb.appendT(1).appendSRN("function setFormData($form,data){");
        gb.appendT(2).appendSRN("$form.find(\"input[name='id']\").val(data.id);");
        for(ClassField field : fieldList){
            if(field.getFieldComment()!=null) {
                gb.appendT(2).appendSRN("$form.find(\"input[name='"+field.getFieldName()+"']\").val(data."+field.getFieldName()+");");
            }
        }
        gb.appendT(1).appendSRN("}").appendRN();

        gb.appendT(1).appendSRN("//��ȡ����ֵ");
        gb.appendT(1).appendSRN("function getFormData($form){");
        gb.appendT(2).appendSRN("var data = {};");
        gb.appendT(2).appendSRN("data.id = $form.find(\"input[name='id']\").val();");
        for(ClassField field : fieldList){
            if(field.getFieldComment()!=null) {
                gb.appendT(2).appendSRN("data."+field.getFieldName()+" = $form.find(\"input[name='"+field.getFieldName()+"']\").val();");
            }
        }
        gb.appendT(2).appendSRN("return data;");
        gb.appendT(1).appendSRN("}").appendRN();

        //ѡ������ɾ��
        gb.appendT(1).appendSRN("//��ȡ����ֵ");
        gb.appendT(1).appendSRN("$deleteOperator.click(function () {");
        gb.appendT(2).appendSRN("var list = $table.bootstrapTable('getAllSelections');");
        gb.appendT(2).appendSRN("if(list && list.length > 0){");
        gb.appendT(3).appendSRN("$deleteModal.modal();");
        gb.appendT(2).appendSRN("}else{");
        gb.appendT(3).appendSRN("SystemMessageShow('��ѡ����Ҫɾ��������!');");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("});").appendRN();

        //ɾ�������ύ
        gb.appendT(1).appendSRN("$deleteSubmit.click(function () {");
        gb.appendT(2).appendSRN("submitDisabled($deleteSubmit);");
        gb.appendT(2).appendSRN("var list = $table.bootstrapTable('getAllSelections');");
        gb.appendT(2).appendSRN("var ids = [];");
        gb.appendT(2).appendSRN("if(list){");
        gb.appendT(3).appendSRN("for(var i=0;i<list.length;i++){");
        gb.appendT(4).appendSRN("ids.push(list[i].id);");
        gb.appendT(3).appendSRN("}");
        gb.appendT(2).appendSRN("}");
        gb.appendT(2).appendSRN("if(ids && ids.length>0){");
        gb.appendT(3).appendSRN("var param = {ids:ids.toString()};");
        gb.appendT(3).appendSRN("$.ajax({");
        gb.appendT(4).appendSRN("type: 'get',");
        gb.appendT(4).appendSRN("url: deleteUrl,");
        gb.appendT(4).appendSRN("dataType: 'json',");
        gb.appendT(4).appendSRN("data: h5_encryp(param),");
        gb.appendT(4).appendSRN("success: function (data) {");
        gb.appendT(5).appendSRN("data = h5_decrypt(data);");
        gb.appendT(5).appendSRN("SystemMessageShow(data);");
        gb.appendT(5).appendSRN("$deleteModal.modal('hide');");
        gb.appendT(5).appendSRN("submitDisabledCancel($deleteSubmit);");
        gb.appendT(5).appendSRN("refreshTable();");
        gb.appendT(4).appendSRN("}");
        gb.appendT(3).appendSRN("});");
        gb.appendT(2).appendSRN("}else{");
        gb.appendT(3).appendSRN("SystemMessageShow('��ѡ����Ҫɾ��������!');");
        gb.appendT(3).appendSRN("submitDisabledCancel($deleteSubmit);");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("});").appendRN();

        //ɾ��ģ̬������
        gb.appendT(1).appendSRN("$deleteModal.on('hide.bs.modal',function () {");
        gb.appendT(2).appendSRN("$(this).find(\"input[name='id']\").val('');");
        gb.appendT(2).appendSRN("submitDisabledCancel($deleteSubmit);");
        gb.appendT(1).appendSRN("});").appendRN();

        gb.appendSRN("});");
        String path = baseJsPath+jsName;
        generateFile(path,gb.toString());
    }

    public static String generateHtml(Class c) {
        String entityName = GenerateUtil.getClassName(c);
        String lowerEntityName = GenerateUtil.firstLowerCase(entityName);
        String htmlName = lowerEntityName+".html";
        String jsName = lowerEntityName+".js";

        List<ClassField> fieldList = GenerateUtil.getFieldList(c);
        GenerateBuffer gb = GenerateBuffer.getInstance();
        gb.appendSRN("<!DOCTYPE html>");
        gb.appendSRN("<html>");
        //head
        gb.appendSRN("<head>");
        gb.appendT(1).appendSRN("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">");
        gb.appendT(1).appendSRN("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\" />");
        gb.appendT(1).appendSRN("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>");
        gb.appendT(1).appendSRN("<title></title>");
        gb.appendT(1).appendSRN("<script type=\"text/javascript\" src=\"/source/importBase.js\"></script>");
        gb.appendT(1).appendSRN("<style>");
        gb.appendT(2).appendSRN("html,legend{font-size: 16px!important;}");
        gb.appendT(2).appendSRN("table thead th{background-color: #eee;}");
        gb.appendT(2).appendSRN("#insertOperator,#updateOperator,#deleteOperator{margin-right: 6px;}");
        gb.appendT(2).appendSRN(".glyphicon{margin-right: 5px;}");
        gb.appendT(2).appendSRN(".form-control-feedback{margin-right: 12px!important;}");
        gb.appendT(2).appendSRN(".label-text{text-align: right;line-height: 36px;}");
        gb.appendT(2).appendSRN("button{border:0!important;background-color: #a04dc0!important;color: #fff!important;min-width: 90px!important;}");
        gb.appendT(2).appendSRN(".button-theme{border:0!important;background-color: #a04dc0!important;color: #fff!important;min-width: 90px!important;}");
        gb.appendT(1).appendSRN("</style>");
        gb.appendSRN("</head>");
        gb.appendSRN("<body class=\"poin-right-body\">");
        //������
        gb.appendT(1).appendSRN("<!-- ������ -->");
        gb.appendT(1).appendSRN("<ol class=\"breadcrumb\">");
        gb.appendT(2).appendSRN("<li><i class=\"glyphicon glyphicon-th-large\"></i>&nbsp;&nbsp;��ǰλ��</li>");
        gb.appendT(2).appendSRN("<li><a href=\"#\"></a></li>");
        gb.appendT(2).appendSRN("<li><a href=\"#\"></a></li>");
        gb.appendT(1).appendSRN("</ol>");
        //������
        gb.appendT(1).appendSRN("<!-- ������ -->");
        gb.appendT(1).appendSRN("<div id=\"server_search\" class=\"panel-default panel\">");
        gb.appendT(2).appendSRN("<div class=\"panel-body poin-panel\">");
        gb.appendT(3).appendSRN("<LEGEND><span class=\"glyphicon glyphicon-search\"></span>����</LEGEND>");
        gb.appendT(3).appendSRN("<form id=\"form\" class=\"form-horizontal\">");
        gb.appendT(4).appendSRN("<div class=\"continer\">");
        gb.appendT(5).appendSRN("<div class=\"row poin-row\">");
        for (ClassField field : fieldList){
            if(field.getFieldComment()!=null){
                String name = field.getFieldName();
                gb.appendT(6).appendSRN("<label class=\"control-label col-lg-1 col-md-1 col-sm-1 col-xs-1\" name=\""+name+"Label\" for=\""+name+"\" id=\""+name+"Label\">"+field.getFieldComment()+":</label>");
                gb.appendT(6).appendSRN("<div class=\"form-group col-lg-3 col-md-3 col-sm-3 col-xs-3\">");
                gb.appendT(7).appendSRN("<input placeholder=\"������...\" autocomplete=\"off\" autofocus=\"off\" type=\"text\" class=\"form-control\" id=\""+name+"\" name=\""+name+"\">");
                gb.appendT(6).appendSRN("</div>");
            }
        }
        gb.appendT(5).appendSRN("</div>");
        gb.appendT(5).appendSRN("<div class=\"row poin-row\">");
        gb.appendT(6).appendSRN("<div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center\">");
        gb.appendT(7).appendSRN("<button id=\"search-form-btn\" value=\"button\" type=\"button\" class=\"poin-btn-lg btn-primary btn\" autocomplete=\"off\" autofocus=\"off\"><span class=\"glyphicon glyphicon-search\"></span>����</button>");
        gb.appendT(7).appendSRN("<button id=\"reset-form-btn\" value=\"reset\" type=\"reset\" class=\"poin-btn-lg btn-danger btn\" autocomplete=\"off\" autofocus=\"off\"><span class=\"glyphicon glyphicon-repeat\"></span>����</button>");
        gb.appendT(6).appendSRN("</div>");
        gb.appendT(5).appendSRN("</div>");
        gb.appendT(4).appendSRN("</div>");
        gb.appendT(3).appendSRN("</form>");
        gb.appendT(2).appendSRN("</div>");
        gb.appendT(1).appendSRN("</div>");
        //�����б�
        gb.appendT(1).appendSRN("<!-- �����б� -->");
        gb.appendT(1).appendSRN("<div class=\"panel-default panel\">");
        gb.appendT(2).appendSRN("<div class=\"panel-body\">");
        gb.appendT(3).appendSRN("<div style=\"float: left;margin-top: 10px;\">");
        gb.appendT(4).appendSRN("<button id=\"insertOperator\" value=\"button\" type=\"button\" class=\"poin-btn-lg btn-primary btn\" autocomplete=\"off\" autofocus=\"off\"><span class=\"glyphicon glyphicon-plus\"></span>����</button>");
        gb.appendT(4).appendSRN("<button id=\"updateOperator\" value=\"button\" type=\"button\" class=\"poin-btn-lg btn-info btn\" autocomplete=\"off\" autofocus=\"off\"><span class=\"glyphicon glyphicon-edit\"></span>�༭</button>");
        gb.appendT(4).appendSRN("<button id=\"deleteOperator\" value=\"button\" type=\"button\" class=\"poin-btn-lg btn-danger btn\" autocomplete=\"off\" autofocus=\"off\"><span class=\"glyphicon glyphicon-trash\"></span>ɾ��</button>");
        gb.appendT(3).appendSRN("</div>");
        gb.appendT(3).appendSRN("<table id=\"dataTable\" style=\"table-layout: fixed;min-width:100%;\"></table>");
        gb.appendT(2).appendSRN("</div>");
        gb.appendT(1).appendSRN("</div>");
        //����modal
        gb.appendT(1).appendSRN("<!-- ����modal -->");
        gb.appendT(1).appendSRN("<div class=\"modal fade\" id=\"insertModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"insertModalLabel\">");
        gb.appendT(2).appendSRN("<div class=\"modal-dialog\" style=\"width: 80%\" role=\"document\">");
        gb.appendT(3).appendSRN("<div class=\"modal-content\">");
        gb.appendT(4).appendSRN("<div class=\"modal-header\">");
        gb.appendT(5).appendSRN("<button type=\"button\" class=\"btn-delete close\" data-dismiss=\"modal\" aria-label=\"close\"><span aria-hidden=\"true\">&times;</span></button>");
        gb.appendT(5).appendSRN("<h4 class=\"modal-title\" id=\"insertModalLabel\">����</h4>");
        gb.appendT(4).appendSRN("</div>");
        gb.appendT(4).appendSRN("<div class=\"modal-body\">");
        gb.appendT(5).appendSRN("<form id=\"insertForm\" method=\"post\" enctype =\"multipart/form-data\">");
        gb.appendT(6).appendSRN("<input class=\"form-control\" type=\"hidden\" name=\"id\" readonly/>");
        gb.appendT(6).appendSRN("<div class=\"row\">");
        for (ClassField field : fieldList){
            if(field.getFieldComment()!=null){
                String name = field.getFieldName();
                gb.appendT(7).appendSRN("<label class=\"control-label label-text col-lg-2 col-md-2 col-sm-2 col-xs-2\"><span class=\"k12_star\">* </span>"+field.getFieldComment()+":</label>");
                gb.appendT(7).appendSRN("<div class=\"form-group col-lg-4 col-md-4 col-sm-4 col-xs-4\">");
                gb.appendT(8).appendSRN("<input placeholder=\"������...\" autocomplete=\"off\" autofocus=\"off\" type=\"text\" class=\"form-control\" name=\""+name+"\">");
                gb.appendT(7).appendSRN("</div>");
            }
        }
        gb.appendT(6).appendSRN("</div>");
        gb.appendT(5).appendSRN("</form>");
        gb.appendT(4).appendSRN("</div>");
        gb.appendT(4).appendSRN("<div class=\"modal-footer\">");
        gb.appendT(5).appendSRN("<button type=\"reset\" class=\"btn btn-default\" type=\"reset\">����</button>");
        gb.appendT(5).appendSRN("<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">�ر�</button>");
        gb.appendT(5).appendSRN("<button type=\"button\" class=\"btn btn-primart\" id=\"submit-insert\">����</button>");
        gb.appendT(4).appendSRN("</div>");
        gb.appendT(3).appendSRN("</div>");
        gb.appendT(2).appendSRN("</div>");
        gb.appendT(1).appendSRN("</div>");
        //����modal
        gb.appendT(1).appendSRN("<!-- ����modal -->");
        gb.appendT(1).appendSRN("<div class=\"modal fade\" id=\"selectModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"selectModalLabel\">");
        gb.appendT(2).appendSRN("<div class=\"modal-dialog\" style=\"width: 80%\" role=\"document\">");
        gb.appendT(3).appendSRN("<div class=\"modal-content\">");
        gb.appendT(4).appendSRN("<div class=\"modal-header\">");
        gb.appendT(5).appendSRN("<button type=\"button\" class=\"btn-delete close\" data-dismiss=\"modal\" aria-label=\"close\"><span aria-hidden=\"true\">&times;</span></button>");
        gb.appendT(5).appendSRN("<h4 class=\"modal-title\" id=\"selectModalLabel\">����</h4>");
        gb.appendT(4).appendSRN("</div>");
        gb.appendT(4).appendSRN("<div class=\"modal-body\">");
        gb.appendT(5).appendSRN("<form id=\"selectForm\" method=\"post\" enctype =\"multipart/form-data\">");
        gb.appendT(6).appendSRN("<input class=\"form-control\" type=\"hidden\" name=\"id\" readonly/>");
        gb.appendT(6).appendSRN("<div class=\"row\">");
        for (ClassField field : fieldList){
            if(field.getFieldComment()!=null){
                String name = field.getFieldName();
                gb.appendT(7).appendSRN("<label class=\"control-label label-text col-lg-2 col-md-2 col-sm-2 col-xs-2\"><span class=\"k12_star\">* </span>"+field.getFieldComment()+":</label>");
                gb.appendT(7).appendSRN("<div class=\"form-group col-lg-4 col-md-4 col-sm-4 col-xs-4\">");
                gb.appendT(8).appendSRN("<input placeholder=\"������...\" autocomplete=\"off\" autofocus=\"off\" type=\"text\" class=\"form-control\" name=\""+name+"\" disabled readonly>");
                gb.appendT(7).appendSRN("</div>");
            }
        }
        gb.appendT(6).appendSRN("</div>");
        gb.appendT(5).appendSRN("</form>");
        gb.appendT(4).appendSRN("</div>");
        gb.appendT(3).appendSRN("</div>");
        gb.appendT(2).appendSRN("</div>");
        gb.appendT(1).appendSRN("</div>");
        //����modal
        gb.appendT(1).appendSRN("<!-- ����modal -->");
        gb.appendT(1).appendSRN("<div class=\"modal fade\" id=\"updateModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"updateModalLabel\">");
        gb.appendT(2).appendSRN("<div class=\"modal-dialog\" style=\"width: 80%\" role=\"document\">");
        gb.appendT(3).appendSRN("<div class=\"modal-content\">");
        gb.appendT(4).appendSRN("<div class=\"modal-header\">");
        gb.appendT(5).appendSRN("<button type=\"button\" class=\"btn-delete close\" data-dismiss=\"modal\" aria-label=\"close\"><span aria-hidden=\"true\">&times;</span></button>");
        gb.appendT(5).appendSRN("<h4 class=\"modal-title\" id=\"updateModalLabel\">�޸�</h4>");
        gb.appendT(4).appendSRN("</div>");
        gb.appendT(4).appendSRN("<div class=\"modal-body\">");
        gb.appendT(5).appendSRN("<form id=\"updateForm\" method=\"post\" enctype =\"multipart/form-data\">");
        gb.appendT(6).appendSRN("<input class=\"form-control\" type=\"hidden\" name=\"id\" readonly/>");
        gb.appendT(6).appendSRN("<div class=\"row\">");
        for (ClassField field : fieldList){
            if(field.getFieldComment()!=null){
                String name = field.getFieldName();
                gb.appendT(7).appendSRN("<label class=\"control-label label-text col-lg-2 col-md-2 col-sm-2 col-xs-2\"><span class=\"k12_star\">* </span>"+field.getFieldComment()+":</label>");
                gb.appendT(7).appendSRN("<div class=\"form-group col-lg-4 col-md-4 col-sm-4 col-xs-4\">");
                gb.appendT(8).appendSRN("<input placeholder=\"������...\" autocomplete=\"off\" autofocus=\"off\" type=\"text\" class=\"form-control\" name=\""+name+"\">");
                gb.appendT(7).appendSRN("</div>");
            }
        }
        gb.appendT(6).appendSRN("</div>");
        gb.appendT(5).appendSRN("</form>");
        gb.appendT(4).appendSRN("</div>");
        gb.appendT(4).appendSRN("<div class=\"modal-footer\">");
        gb.appendT(5).appendSRN("<input type=\"hidden\" name=\"id\">");
        gb.appendT(5).appendSRN("<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">�ر�</button>");
        gb.appendT(5).appendSRN("<button type=\"button\" class=\"btn btn-primart\" id=\"submit-update\">����</button>");
        gb.appendT(4).appendSRN("</div>");
        gb.appendT(3).appendSRN("</div>");
        gb.appendT(2).appendSRN("</div>");
        gb.appendT(1).appendSRN("</div>");
        //ɾ��modal
        gb.appendT(1).appendSRN("<!-- ɾ��modal -->");
        gb.appendT(1).appendSRN("<div class=\"modal fade\" id=\"deleteModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"deleteModalLabel\">");
        gb.appendT(2).appendSRN("<div class=\"modal-dialog\" role=\"document\">");
        gb.appendT(3).appendSRN("<div class=\"modal-content\">");
        gb.appendT(4).appendSRN("<div class=\"modal-header\">");
        gb.appendT(5).appendSRN("<button type=\"button\" class=\"btn-delete close\" data-dismiss=\"modal\" aria-label=\"close\"><span aria-hidden=\"true\">&times;</span></button>");
        gb.appendT(5).appendSRN("<h4 class=\"modal-title\" id=\"deleteModalLabel\">ɾ��</h4>");
        gb.appendT(4).appendSRN("</div>");
        gb.appendT(4).appendSRN("<div class=\"modal-body\">ȷ��ɾ��ѡ���������</div>");
        gb.appendT(4).appendSRN("<div class=\"modal-footer\">");
        gb.appendT(5).appendSRN("<input type=\"hidden\" name=\"id\">");
        gb.appendT(5).appendSRN("<button type=\"button\" class=\"btn-delete btn btn-default\" data-dismiss=\"modal\">�ر�</button>");
        gb.appendT(5).appendSRN("<button type=\"button\" class=\"btn btn-primart\" id=\"submit-delete\">ȷ��</button>");
        gb.appendT(4).appendSRN("</div>");
        gb.appendT(3).appendSRN("</div>");
        gb.appendT(2).appendSRN("</div>");
        gb.appendT(1).appendSRN("</div>");

        gb.appendT(1).appendSRN("<script src=\"js/"+jsName+"\"></script>");
        gb.appendSRN("</body>");
        gb.appendSRN("</html>");

        String path = baseHtmlPath+htmlName;
        generateFile(path,gb.toString());
        return null;
    }

    public static String generateVo(Class c,Comment comment) {
        String entityName = GenerateUtil.getClassName(c);
        String lowerEntityName = GenerateUtil.firstLowerCase(entityName);
        String voName = entityName+"Vo";
        GenerateBuffer gb = GenerateBuffer.getInstance();
        gb.appendPackage(basePackage+"."+voPath).appendRN();
        gb.appendImport(c);
        gb.appendRN();
        gb.appendSRN("public class "+voName+" extends "+entityName+" {").appendRN().appendSRN("}");

        String path = baseSrcPath+voPath+"\\"+voName+".java";
        generateFile(path,gb.toString());
        return basePackage+"."+voPath+"."+voName;
    }

    public static String generateController(Class c,Comment comment){
        String entityName = GenerateUtil.getClassName(c);
        String lowerEntityName = GenerateUtil.firstLowerCase(entityName);
        String controllerName = entityName+"Resource";
        String serviceName = entityName+"Service";
        String lowerServiceName = GenerateUtil.firstLowerCase(serviceName);
        GenerateBuffer gb = GenerateBuffer.getInstance();
        gb.appendPackage(basePackage+"."+controllerPath).appendRN();
        gb.appendImport(c,List.class);
        gb.appendImport("org.apache.log4j.Logger");
        gb.appendImport("javax.annotation.Resource");
        gb.appendImport("javax.servlet.http.HttpServletRequest");
        gb.appendImport("javax.ws.rs.core.Context");
        gb.appendImport("com.nj_profit.rest.vo.ResponseVo");
        gb.appendImport("org.springframework.stereotype.Component");
        gb.appendImport("javax.ws.rs.Path");
        gb.appendImport("javax.ws.rs.POST");
        gb.appendImport("javax.ws.rs.GET");
        gb.appendImport("javax.ws.rs.Produces");
        gb.appendImport("javax.ws.rs.QueryParam");
        gb.appendImport(basePackage+"."+servicePath+"."+serviceName);

        gb.appendRN();
        gb.appendDesc(comment,DescType.CLASS,0);
        gb.appendSRN("@Component");
        gb.appendSRN("@Path(\"/"+lowerEntityName+"\")");
        gb.appendSRN("public class "+controllerName+" extends BaseResource {").appendRN();
        gb.appendT(1).appendSRN("private static final Logger LOGGER = Logger.getLogger("+controllerName+".class);").appendRN();
        gb.appendT(1).appendSRN("@Resource");
        gb.appendT(1).appendSRN("private "+serviceName+" "+lowerServiceName+";").appendRN();
        gb.appendT(1).appendSRN("@Context");
        gb.appendT(1).appendSRN("private HttpServletRequest request;").appendRN();
        //�б�
        gb.appendT(1).appendSRN("@Log");
        gb.appendT(1).appendSRN("@POST");
        gb.appendT(1).appendSRN("@Path(\"/list\")");
        gb.appendT(1).appendSRN("@Produces({ \"application/json\" })");
        gb.appendT(1).appendSRN("public ResponseVo list("+entityName+" "+lowerEntityName+") {");
        gb.appendT(2).appendSRN("try {");
        gb.appendT(3).appendSRN("List<"+entityName+"> list = "+lowerServiceName+".selectList("+lowerEntityName+");");
        gb.appendT(3).appendSRN("return Response.success(\"��ѯ�ɹ�\",list);");
        gb.appendT(2).appendSRN("} catch (Exception e) {");
        gb.appendT(3).appendSRN("LOGGER.error(\"��ѯʧ��\", e);");
        gb.appendT(3).appendSRN("return Response.error(e);");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("}").appendRN();
        //����
        gb.appendT(1).appendSRN("@Log");
        gb.appendT(1).appendSRN("@POST");
        gb.appendT(1).appendSRN("@Path(\"/detail\")");
        gb.appendT(1).appendSRN("@Produces({ \"application/json\" })");
        gb.appendT(1).appendSRN("public ResponseVo detail("+entityName+" "+lowerEntityName+") {");
        gb.appendT(2).appendSRN("try {");
        gb.appendT(3).appendSRN("if("+lowerEntityName+".getId() == null){");
        gb.appendT(4).appendSRN("return Response.failed(\"ID����Ϊ��!\");");
        gb.appendT(3).appendSRN("}");
        gb.appendT(3).appendSRN(lowerEntityName+" = "+lowerServiceName+".selectOne("+lowerEntityName+");");
        gb.appendT(3).appendSRN("return Response.success(\"��ѯ�ɹ�\","+lowerEntityName+");");
        gb.appendT(2).appendSRN("} catch (Exception e) {");
        gb.appendT(3).appendSRN("LOGGER.error(\"��ѯʧ��\", e);");
        gb.appendT(3).appendSRN("return Response.error(e);");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("}").appendRN();
        //����
        gb.appendT(1).appendSRN("@Log");
        gb.appendT(1).appendSRN("@POST");
        gb.appendT(1).appendSRN("@Path(\"/insert\")");
        gb.appendT(1).appendSRN("@Produces({ \"application/json\" })");
        gb.appendT(1).appendSRN("public ResponseVo insert("+entityName+" "+lowerEntityName+") {");
        gb.appendT(2).appendSRN("try {");
        gb.appendT(3).appendSRN("int i = "+lowerServiceName+".insert("+lowerEntityName+");");
        gb.appendT(3).appendSRN("if(i>0){");
        gb.appendT(4).appendSRN("return Response.success();");
        gb.appendT(3).appendSRN("}");
        gb.appendT(3).appendSRN("return Response.failed();");
        gb.appendT(2).appendSRN("} catch (Exception e) {");
        gb.appendT(3).appendSRN("LOGGER.error(\"����ʧ��\", e);");
        gb.appendT(3).appendSRN("return Response.error(e);");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("}").appendRN();
        //����
        gb.appendT(1).appendSRN("@Log");
        gb.appendT(1).appendSRN("@POST");
        gb.appendT(1).appendSRN("@Path(\"/update\")");
        gb.appendT(1).appendSRN("@Produces({ \"application/json\" })");
        gb.appendT(1).appendSRN("public ResponseVo update("+entityName+" "+lowerEntityName+") {");
        gb.appendT(2).appendSRN("try {");
        gb.appendT(3).appendSRN("if("+lowerEntityName+".getId() == null){");
        gb.appendT(4).appendSRN("return Response.failed(\"ID����Ϊ��!\");");
        gb.appendT(3).appendSRN("}");
        gb.appendT(3).appendSRN("int i = "+lowerServiceName+".updateById("+lowerEntityName+");");
        gb.appendT(3).appendSRN("if(i>0){");
        gb.appendT(4).appendSRN("return Response.success();");
        gb.appendT(3).appendSRN("}");
        gb.appendT(3).appendSRN("return Response.failed();");
        gb.appendT(2).appendSRN("} catch (Exception e) {");
        gb.appendT(3).appendSRN("LOGGER.error(\"����ʧ��\", e);");
        gb.appendT(3).appendSRN("return Response.error(e);");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("}").appendRN();
        //ɾ��
        gb.appendT(1).appendSRN("@Log");
        gb.appendT(1).appendSRN("@GET");
        gb.appendT(1).appendSRN("@Path(\"/delete\")");
        gb.appendT(1).appendSRN("@Produces({ \"application/json\" })");
        gb.appendT(1).appendSRN("public ResponseVo delete(@QueryParam(\"id\") Long id) {");
        gb.appendT(2).appendSRN("try {");
        gb.appendT(3).appendSRN("if(id == null){");
        gb.appendT(4).appendSRN("return Response.failed(\"ID����Ϊ��!\");");
        gb.appendT(3).appendSRN("}");
        gb.appendT(3).appendSRN("int i = "+lowerServiceName+".delete(id);");
        gb.appendT(3).appendSRN("if(i>0){");
        gb.appendT(4).appendSRN("return Response.success();");
        gb.appendT(3).appendSRN("}");
        gb.appendT(3).appendSRN("return Response.failed();");
        gb.appendT(2).appendSRN("} catch (Exception e) {");
        gb.appendT(3).appendSRN("LOGGER.error(\"ɾ��ʧ��\", e);");
        gb.appendT(3).appendSRN("return Response.error(e);");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("}").appendRN();
        //����ɾ��
        gb.appendT(1).appendSRN("@Log");
        gb.appendT(1).appendSRN("@GET");
        gb.appendT(1).appendSRN("@Path(\"/deleteIds\")");
        gb.appendT(1).appendSRN("@Produces({ \"application/json\" })");
        gb.appendT(1).appendSRN("public ResponseVo deleteIds(@QueryParam(\"ids\") String ids) {");
        gb.appendT(2).appendSRN("try {");
        gb.appendT(3).appendSRN("if(ids == null || \"\".equals(ids)){");
        gb.appendT(4).appendSRN("return Response.failed(\"ID����Ϊ��!\");");
        gb.appendT(3).appendSRN("}");
        gb.appendT(3).appendSRN("String[] idList = ids.split(\",\");");
        gb.appendT(3).appendSRN("for(String id : idList){");
        gb.appendT(4).appendSRN("int i = "+lowerServiceName+".delete(Long.valueOf(id));");
        gb.appendT(3).appendSRN("}");
        gb.appendT(3).appendSRN("return Response.success();");
        gb.appendT(2).appendSRN("} catch (Exception e) {");
        gb.appendT(3).appendSRN("LOGGER.error(\"����ɾ��ʧ��\", e);");
        gb.appendT(3).appendSRN("return Response.error(e);");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("}").appendRN();
        //αɾ��
        gb.appendT(1).appendSRN("@Log");
        gb.appendT(1).appendSRN("@GET");
        gb.appendT(1).appendSRN("@Path(\"/deleteFake\")");
        gb.appendT(1).appendSRN("@Produces({ \"application/json\" })");
        gb.appendT(1).appendSRN("public ResponseVo deleteFake(@QueryParam(\"id\") Long id) {");
        gb.appendT(2).appendSRN("try {");
        gb.appendT(3).appendSRN("if(id == null){");
        gb.appendT(4).appendSRN("return Response.failed(\"ID����Ϊ��!\");");
        gb.appendT(3).appendSRN("}");
        gb.appendT(3).appendSRN("int i = "+lowerServiceName+".deleteFake(id);");
        gb.appendT(3).appendSRN("if(i>0){");
        gb.appendT(4).appendSRN("return Response.success();");
        gb.appendT(3).appendSRN("}");
        gb.appendT(3).appendSRN("return Response.failed();");
        gb.appendT(2).appendSRN("} catch (Exception e) {");
        gb.appendT(3).appendSRN("LOGGER.error(\"ɾ��ʧ��\", e);");
        gb.appendT(3).appendSRN("return Response.error(e);");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("}").appendRN();
        //����ɾ��
        gb.appendT(1).appendSRN("@Log");
        gb.appendT(1).appendSRN("@GET");
        gb.appendT(1).appendSRN("@Path(\"/deleteFakeIds\")");
        gb.appendT(1).appendSRN("@Produces({ \"application/json\" })");
        gb.appendT(1).appendSRN("public ResponseVo deleteFakeIds(@QueryParam(\"ids\") String ids) {");
        gb.appendT(2).appendSRN("try {");
        gb.appendT(3).appendSRN("if(ids == null || \"\".equals(ids)){");
        gb.appendT(4).appendSRN("return Response.failed(\"ID����Ϊ��!\");");
        gb.appendT(3).appendSRN("}");
        gb.appendT(3).appendSRN("String[] idList = ids.split(\",\");");
        gb.appendT(3).appendSRN("for(String id : idList){");
        gb.appendT(4).appendSRN("int i = "+lowerServiceName+".deleteFake(Long.valueOf(id));");
        gb.appendT(3).appendSRN("}");
        gb.appendT(3).appendSRN("return Response.success();");
        gb.appendT(2).appendSRN("} catch (Exception e) {");
        gb.appendT(3).appendSRN("LOGGER.error(\"����ɾ��ʧ��\", e);");
        gb.appendT(3).appendSRN("return Response.error(e);");
        gb.appendT(2).appendSRN("}");
        gb.appendT(1).appendSRN("}").appendRN();

        gb.appendSRN("}");

        String path = baseSrcPath+controllerPath+"\\"+controllerName+".java";
        generateFile(path,gb.toString());
        return basePackage+"."+controllerPath+"."+controllerName;
    }

    public static String generateService(Class c,Comment comment){
        String entityName = GenerateUtil.getClassName(c);
        String lowerEntityName = GenerateUtil.firstLowerCase(entityName);
        String serviceName = entityName+"Service";
        GenerateBuffer gb = GenerateBuffer.getInstance();
        gb.appendPackage(basePackage+"."+servicePath).appendRN();
        gb.appendImport(c,List.class);
        gb.appendDesc(comment,DescType.CLASS,0);

        gb.appendSRN("public interface "+serviceName+"{");
        gb.appendDesc(comment,DescType.SELECT,1);
        gb.appendT(1).appendSRN("List<"+entityName+"> selectList("+entityName+" "+lowerEntityName+");").appendRN();
        gb.appendT(1).appendSRN(""+entityName+" selectOne("+entityName+" "+lowerEntityName+");").appendRN();
        gb.appendDesc(comment,DescType.INSERT,1);
        gb.appendT(1).appendSRN("int insert("+entityName+" "+lowerEntityName+");").appendRN();
        gb.appendDesc(comment,DescType.INSERT_BATCH,1);
        gb.appendT(1).appendSRN("int insertBatch(List<"+entityName+"> list);").appendRN();
        gb.appendDesc(comment,DescType.UPDATE,1);
        gb.appendT(1).appendSRN("int updateById("+entityName+" "+lowerEntityName+");").appendRN();
        gb.appendDesc(comment,DescType.DELETE_FAKE,1);
        gb.appendT(1).appendSRN("int deleteFake(Long id);").appendRN();
        gb.appendDesc(comment,DescType.DELETE,1);
        gb.appendT(1).appendSRN("int delete(Long id);").appendRN();
        gb.appendSRN("}");
        String path = baseSrcPath+servicePath+"\\"+serviceName+".java";
        generateFile(path,gb.toString());
        return basePackage+"."+servicePath+"."+serviceName;
    }

    public static String generateServiceImpl(Class c,String serviceUrl,String mapperUrl,Comment comment){
        String entityName = GenerateUtil.getClassName(c);
        String lowerEntityName = GenerateUtil.firstLowerCase(entityName);
        String serviceImplName = entityName+"ServiceImpl";
        String serviceName = entityName+"Service";
        String mapperName = entityName+"Mapper";
        String lowerMapperName = GenerateUtil.firstLowerCase(mapperName);
        GenerateBuffer gb = GenerateBuffer.getInstance();
        gb.appendPackage(basePackage+"."+servicePath+"."+serviceImplPath).appendRN();
        gb.appendImport(c,List.class);
        gb.appendImport("org.springframework.stereotype.Service");
        gb.appendImport("javax.annotation.Resource");
        gb.appendImport("org.apache.log4j.Logger");
        gb.appendImport(serviceUrl);
        gb.appendImport(mapperUrl);
        gb.appendDesc(comment,DescType.CLASS,0);

        gb.appendSRN("@Service");
        gb.appendSRN("public class "+serviceImplName+" implements "+serviceName+"{").appendRN();
        gb.appendT(1).appendSRN("private static final Logger LOGGER = Logger.getLogger("+serviceImplName+".class);");
        gb.appendT(1).appendSRN("@Resource");
        gb.appendT(1).appendSRN("private "+mapperName+" "+lowerMapperName+";");
        gb.appendDesc(comment,DescType.SELECT,1);
        gb.appendT(1).appendSRN("public List<"+entityName+"> selectList("+entityName+" "+lowerEntityName+"){");
        gb.appendT(2).appendSRN("return "+lowerMapperName+".selectList("+lowerEntityName+");");
        gb.appendT(1).appendSRN("}");
        gb.appendT(1).appendSRN("public "+entityName+" selectOne("+entityName+" "+lowerEntityName+"){");
        gb.appendT(2).appendSRN("return "+lowerMapperName+".selectOne("+lowerEntityName+");");
        gb.appendT(1).appendSRN("}");
        gb.appendDesc(comment,DescType.INSERT,1);
        gb.appendT(1).appendSRN("public int insert("+entityName+" "+lowerEntityName+"){");
        gb.appendT(2).appendSRN("return "+lowerMapperName+".insert("+lowerEntityName+");");
        gb.appendT(1).appendSRN("}");
        gb.appendDesc(comment,DescType.INSERT_BATCH,1);
        gb.appendT(1).appendSRN("public int insertBatch(List<"+entityName+"> list){");
        gb.appendT(2).appendSRN("return "+lowerMapperName+".insertBatch(list);");
        gb.appendT(1).appendSRN("}");
        gb.appendDesc(comment,DescType.UPDATE,1);
        gb.appendT(1).appendSRN("public int updateById("+entityName+" "+lowerEntityName+"){");
        gb.appendT(2).appendSRN("return "+lowerMapperName+".updateById("+lowerEntityName+");");
        gb.appendT(1).appendSRN("}");
        gb.appendDesc(comment,DescType.DELETE_FAKE,1);
        gb.appendT(1).appendSRN("public int deleteFake(Long id){");
        gb.appendT(2).appendSRN("return "+lowerMapperName+".deleteFake(id);");
        gb.appendT(1).appendSRN("}");
        gb.appendDesc(comment,DescType.DELETE,1);
        gb.appendT(1).appendSRN("public int delete(Long id){");
        gb.appendT(2).appendSRN("return "+lowerMapperName+".delete(id);");
        gb.appendT(1).appendSRN("}");
        gb.appendSRN("}");
        String path = baseSrcPath+servicePath+"\\"+serviceImplPath+"\\"+serviceImplName+".java";
        generateFile(path,gb.toString());
        return basePackage+"."+servicePath+"."+serviceImplPath+"."+serviceImplName;
    }

    public static String generateMapper(Class c,Comment comment){
        String entityName = GenerateUtil.getClassName(c);
        String lowerEntityName = GenerateUtil.firstLowerCase(entityName);
        String mapperName = entityName+"Mapper";
        GenerateBuffer gb = GenerateBuffer.getInstance();
        gb.appendPackage(basePackage+"."+mapperPath).appendRN();
        gb.appendImport(c,List.class);
        //gb.appendImport("org.apache.ibatis.annotations.Mapper");
        gb.appendDesc(comment,DescType.CLASS,0);

        //gb.appendSRN("@Mapper");
        gb.appendSRN("public interface "+mapperName+"{");
        gb.appendDesc(comment,DescType.SELECT,1);
        gb.appendT(1).appendSRN("List<"+entityName+"> selectList("+entityName+" "+lowerEntityName+");").appendRN();
        gb.appendT(1).appendSRN(""+entityName+" selectOne("+entityName+" "+lowerEntityName+");").appendRN();
        gb.appendDesc(comment,DescType.INSERT,1);
        gb.appendT(1).appendSRN("int insert("+entityName+" "+lowerEntityName+");").appendRN();
        gb.appendDesc(comment,DescType.INSERT_BATCH,1);
        gb.appendT(1).appendSRN("int insertBatch(List<"+entityName+"> list);").appendRN();
        gb.appendDesc(comment,DescType.UPDATE,1);
        gb.appendT(1).appendSRN("int updateById("+entityName+" "+lowerEntityName+");").appendRN();
        gb.appendDesc(comment,DescType.DELETE_FAKE,1);
        gb.appendT(1).appendSRN("int deleteFake(Long id);").appendRN();
        gb.appendDesc(comment,DescType.DELETE,1);
        gb.appendT(1).appendSRN("int delete(Long id);").appendRN();
        gb.appendSRN("}");
        String path = baseSrcPath+mapperPath+"\\"+mapperName+".java";
        generateFile(path,gb.toString());
        return basePackage+"."+mapperPath+"."+mapperName;
    }

    public static void generateMapperXml(Class c,String mapperName,String tableName){
        String entityName = GenerateUtil.getClassName(c);
        String mapperXmlName = entityName+".mapper.xml";
        List<ClassField> fieldList = GenerateUtil.getFieldList(c);
        List<String> columnList = new ArrayList<>();

        GenerateBuffer gb = GenerateBuffer.getInstance();
        gb.appendSRN("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        gb.appendSRN("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >");
        gb.appendSRN("<mapper namespace=\""+mapperName+"\" >");
        //resultmap
        gb.appendT(1).appendSRN("<resultMap type=\""+c.getName()+"\" id=\"baseResultMap\">");
        for (ClassField field : fieldList) {
            String column = field.getSqlColumn();
            columnList.add(column);
            gb.appendT(2).appendSRN("<result column=\""+column+"\" property=\""+field.getFieldName()+"\" />");
        }
        gb.appendT(1).appendSRN("</resultMap>").appendRN();
        //basecolumn
        gb.appendT(1).appendSRN("<sql id=\"baseColumn\">");
        for (int i = 0; i < columnList.size(); i++) {
            gb.appendT(2).append(columnList.get(i));
            if(i!=columnList.size()-1){
                gb.append(",");
            }
            gb.appendRN();
        }
        gb.appendT(1).appendSRN("</sql>").appendRN();
        //basecondition
        gb.appendT(1).appendSRN("<sql id=\"baseCondition\">");
        gb.appendT(2).appendSRN("<where>");
        for (ClassField field : fieldList) {
            if ("java.lang.String".equalsIgnoreCase(field.getFieldType())) {
                gb.appendT(3).appendSRN("<if test=\"" + field.getFieldName() + " != null and "+field.getFieldName()+" !='' \" >and " + field.getSqlColumn() + " = #{" + field.getFieldName() + "}</if>");
            } else {
                gb.appendT(3).appendSRN("<if test=\"" + field.getFieldName() + " != null\" >and " + field.getSqlColumn() + " = #{" + field.getFieldName() + "}</if>");
            }
        }
        gb.appendT(2).appendSRN("</where>");
        gb.appendT(1).appendSRN("</sql>").appendRN();
        //selectList
        gb.appendT(1).appendSRN("<select id=\"selectList\" resultMap=\"baseResultMap\" parameterType=\""+c.getName()+"\">");
        gb.appendT(2).appendSRN("select <include refid=\"baseColumn\"></include>");
        gb.appendT(2).appendSRN("from "+tableName);
        gb.appendT(2).appendSRN("<include refid=\"baseCondition\"></include>");
        gb.appendT(1).appendSRN("</select>").appendRN();
        //selectOne
        gb.appendT(1).appendSRN("<select id=\"selectOne\" resultMap=\"baseResultMap\" parameterType=\""+c.getName()+"\">");
        gb.appendT(2).appendSRN("select <include refid=\"baseColumn\"></include>");
        gb.appendT(2).appendSRN("from "+tableName);
        gb.appendT(2).appendSRN("<include refid=\"baseCondition\"></include>");
        gb.appendT(1).appendSRN("</select>").appendRN();
        //insert
        gb.appendT(1).appendSRN("<insert id=\"insert\" useGeneratedKeys=\"true\" keyProperty=\"id\" parameterType=\""+c.getName()+"\">");
        gb.appendT(2).appendSRN("insert into "+tableName);
        gb.appendT(2).appendSRN("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >");
        for (ClassField field : fieldList) {
            gb.appendT(3).appendSRN("<if test=\""+field.getFieldName()+" != null\" >"+field.getSqlColumn()+",</if>");
        }
        gb.appendT(2).appendSRN("</trim>");
        gb.appendT(2).appendSRN("<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >");
        for (ClassField field : fieldList) {
            gb.appendT(3).appendSRN("<if test=\""+field.getFieldName()+" != null\" >#{"+field.getFieldName()+"},</if>");
        }
        gb.appendT(2).appendSRN("</trim>");
        gb.appendT(1).appendSRN("</insert>").appendRN();
        //insertbatch
        gb.appendT(1).appendSRN("<insert id=\"insertBatch\" parameterType=\"java.util.List\">");
        gb.appendT(2).appendSRN("insert into "+tableName+"(");
        for (int i = 0; i < fieldList.size(); i++) {
            gb.appendT(3).append(fieldList.get(i).getSqlColumn());
            if(i!=fieldList.size()-1){
                gb.append(",");
            }
            gb.appendRN();
        }
        gb.appendT(2).appendSRN(") values ");
        gb.appendT(2).appendSRN("<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\"> (");
        for (int i = 0; i < fieldList.size(); i++) {
            gb.appendT(3).append("#{item."+fieldList.get(i).getFieldName()+"}");
            if(i!=fieldList.size()-1){
                gb.append(",");
            }
            gb.appendRN();
        }
        gb.appendT(2).appendSRN(")");
        gb.appendT(2).appendSRN("</foreach>");
        gb.appendT(1).appendSRN("</insert>").appendRN();

        //update
        gb.appendT(1).appendSRN("<update id=\"updateById\" parameterType=\""+c.getName()+"\">");
        gb.appendT(2).appendSRN("update "+tableName);
        gb.appendT(2).appendSRN("<set>");
        for (ClassField field : fieldList) {
            if("id".equals(field.getFieldName())){
                continue;
            }
            gb.appendT(3).appendSRN("<if test=\""+field.getFieldName()+" != null\">"+field.getSqlColumn()+" = #{"+field.getFieldName()+"},</if>");
        }
        gb.appendT(2).appendSRN("</set>");
        gb.appendT(2).appendSRN("where id=#{id}");
        gb.appendT(1).appendSRN("</update>").appendRN();

        //fake delete
        gb.appendT(1).appendSRN("<update id=\"deleteFake\" parameterType=\"java.lang.Long\">");
        gb.appendT(2).appendSRN("update "+tableName+" set del_flag = 1");
        gb.appendT(2).appendSRN("where id = #{id}");
        gb.appendT(1).appendSRN("</update>").appendRN();
        //delete
        gb.appendT(1).appendSRN("<delete id=\"delete\" parameterType=\"java.lang.Long\">");
        gb.appendT(2).appendSRN("delete from "+tableName);
        gb.appendT(2).appendSRN("where id = #{id}");
        gb.appendT(1).appendSRN("</delete>").appendRN();

        gb.appendSRN("</mapper>");
        generateFile(baseXmlPath + mapperXmlName,gb.toString());
    }

    public static void generateFile(String path,String content){
        //System.out.println("�����ļ�·����"+path);
        //System.out.println("�����ļ����ݣ�\r\n"+content);
        File file = new File(path);
        boolean flag = FileUtils.createFile(file);
        if(flag){
            System.out.println("�����ļ�  ��"+path);
            FileUtils.writeFile(file,content);
        }else{
            System.out.println("�ļ��Ѵ��ڣ�"+path);
        }
    }

    public static List<ClassField> getFieldList(Class c) {
        List<ClassField> list = new ArrayList<>();
        Field[] fields = c.getDeclaredFields();
        ClassField classField = null;
        for (Field field:fields) {
            String fieldName = field.getName();
            if("serialVersionUID".equalsIgnoreCase(fieldName)){
                continue;
            }
            classField = new ClassField();
            String typeName = field.getGenericType().getTypeName();
            classField.setFieldName(fieldName);
            classField.setSqlColumn(GenerateUtil.humpToLine(fieldName));
            classField.setFieldType(typeName);
            classField.setSqlType(null);
            if(field.isAnnotationPresent(com.google.demoForIdea.takeFile.Comment.class)){
               com.google.demoForIdea.takeFile.Comment comment = field.getAnnotation(com.google.demoForIdea.takeFile.Comment.class);
                classField.setFieldComment(comment.value());
            }
            list.add(classField);
        }
        return list;
    }

    private static Pattern humpToLinePattern = Pattern.compile("[A-Z]");
    private static String humpToLine(String str){
        Matcher matcher = humpToLinePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()){
            matcher.appendReplacement(sb,"_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    //��ȡ����
    public static String getClassName(Class c){
        String[] names = c.getName().split("\\.");
        return names[names.length-1];
    }
    //����ĸСд
    private static String firstLowerCase(String str) {
        char[] chars = str.toCharArray();
        chars[0]+=32;
        return String.valueOf(chars);
    }
}

class FileUtils{
    //�����ļ�
    public static boolean createFile(File file){
        boolean flag = false;
        try {
            if(!file.exists()){
                file.createNewFile();
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    //д�ļ�
    public static void writeFile(File file,String content){
        try (FileWriter writer = new FileWriter(file); BufferedWriter out = new BufferedWriter(writer)){
            out.write(content);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //���ļ�
    public static void readFile(File file,String content){
        try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)){
            String line;
            while ((line = br.readLine())!=null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class GenerateBuffer{
    private volatile static GenerateBuffer generateBuffer = null;
    private static StringBuffer sb = null;
    public static final String rn = "\r\n";
    public static final String t1 = "\t";
    public static final String blank = " ";
    public static final String fh = ";";
    private GenerateBuffer(){}
    public static GenerateBuffer getInstance(){
        if(generateBuffer==null){
            synchronized (GenerateBuffer.class){
                if(generateBuffer==null){
                    generateBuffer = new GenerateBuffer();
                }
            }
        }
        sb = new StringBuffer();
        return generateBuffer;
    }

    public GenerateBuffer append(String str){
        sb.append(str);
        return this;
    }
    public GenerateBuffer appendBlank(String str){
        sb.append(blank).append(str).append(blank);
        return this;
    }
    public GenerateBuffer appendT(int i){
        for (int j = 0; j < i; j++) {
            sb.append(t1);
        }
        return this;
    }
    public GenerateBuffer appendRN(){
        sb.append(rn);
        return this;
    }
    public GenerateBuffer appendSRN(String str){
        sb.append(str).append(rn);
        return this;
    }
    public GenerateBuffer appendImport(Class... cla){
        for (Class c : cla){
            append("import ").appendSRN(c.getName()+fh);
        }
        return this;
    }
    public GenerateBuffer appendPackage(String str) {
        append("package ").appendSRN(str+fh);
        return this;
    }
    public GenerateBuffer appendImport(String name){
        append("import ").appendSRN(name+fh);
        return this;
    }
    public GenerateBuffer appendDesc(Comment comment,DescType type,int i){
        appendT(i).appendSRN("/**");
        appendT(i).append(" * ");
        if(DescType.CLASS.equals(type)){
            appendSRN(comment.getDesc()==null?"":comment.getDesc());
            appendT(i).appendSRN(" * @author     : "+comment.getAuthor());
            appendT(i).appendSRN(" * @createTime : "+comment.getCreateTime());
        }else{
            appendSRN(type.getName());
        }
        appendT(i).appendSRN(" */");
        return this;
    }
    @Override
    public String toString() {
        return sb.toString();
    }

    public void appendTry(int i ,String... strs) {
        appendT(i).appendSRN("");
    }
}
enum DescType{
    CLASS(""),
    SELECT("����������ѯ"),
    INSERT("����"),
    INSERT_BATCH("��������"),
    UPDATE("����ID����"),
    DELETE("����IDɾ��"),
    DELETE_FAKE("����IDαɾ��");
    private String name;
    DescType(String name){this.name = name;}
    public String getName() {
        return name;
    }
}
class ClassField{
    private String fieldName;
    private String fieldValue;
    private String fieldType;
    private String sqlColumn;
    private String sqlType;
    private String fieldComment;
    public ClassField() {}

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getSqlColumn() {
        return sqlColumn;
    }

    public void setSqlColumn(String sqlColumn) {
        this.sqlColumn = sqlColumn;
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    public String getFieldComment() {
        return fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
    }
}

class Comment{
    private String author;
    private String desc;
    private String createTime;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.createTime = sdf.format(createTime);
    }
}