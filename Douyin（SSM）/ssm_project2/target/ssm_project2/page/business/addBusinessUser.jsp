<%--
  Created by IntelliJ IDEA.
  User: 10072
  Date: 2020/2/25
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>添加数据模板页面</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-sm-4">
        <h2>查看&编辑商户信息</h2>
        <ol class="breadcrumb">
            <li>
                <a href="index.html">商户</a>
            </li>
            <li>
                <strong>查看&编辑商户信息</strong>
            </li>
        </ol>
    </div>
    <div class="col-sm-8">
        <div class="title-action">
            <a href="add_date_model.html" class="btn btn-primary">活动区域</a>
        </div>
    </div>
</div>

<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <form method="get" class="form-horizontal" action="${pageContext.request.contextPath}/BusinessUserController/updateBusinessUser">

                        <div class="form-group">
                            <label class="col-sm-2 control-label">登录名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="business_username" id="business_username">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <%----%>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">商家名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="business_info_name" id="business_info_name">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <%----%>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">法人姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="business_info_legal_persion" id="business_info_legal_persion">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <%----%>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">联系方式</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="business_info_legal_persion_tel" id="business_info_legal_persion_tel">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <%----%>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">密码</label>

                            <div class="col-sm-10">
                                <input type="password" class="form-control" name="business_pass_word" id="business_pass_word">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <%----%>

                        <%----%>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">保存内容</button>
                                <button class="btn btn-white" type="reset">取消</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/js/content.js?v=1.0.0"></script>

<script>
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/BusinessUserController/getBusinessUserInfo",
        success: function(msg){
            $("#business_username").val(msg.business_username);
            $("#business_info_name").val(msg.business_info_name);
            $("#business_info_legal_persion").val(msg.business_info_legal_persion);
            $("#business_info_legal_persion_tel").val(msg.business_info_legal_persion_tel);
            $("#business_pass_word").val(msg.business_pass_word);


        }
    });

    var returnmsg = "${msg}";
    if(returnmsg != ""){
        alert(returnmsg);
    }

</script>
