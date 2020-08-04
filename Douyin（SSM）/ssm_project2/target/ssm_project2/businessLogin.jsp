<%--
  Created by IntelliJ IDEA.
  User: 10072
  Date: 2020/2/20
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>
            <img src="${pageContext.request.contextPath}/img/douyinlogo.jpg" width="150">
            <!--    <h1 class="logo-name">h</h1> -->

        </div>
        <h3 id="returnmsg">${msg}</h3>


        <form class="m-t" role="form" method="post">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="用户名" required="" id="business_username">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" required="" id="business_pass_word">
            </div>
            <button id="gologin" type="button" class="btn btn-primary block full-width m-b">登 录</button>


            <p class="text-muted text-center">
                <a href="${pageContext.request.contextPath}/index.jsp"><small>管理员登录</small></a>|
                <a href="login.html#"><small>忘记密码了？</small></a>|
                <a href="register.html">注册一个新账号</a>
            </p>

        </form>
    </div>
</div>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
<script>
    //给按钮绑定点击事件
    $("#gologin").click(function(){
        var business_username = $("#business_username").val();
        var business_pass_word = $("#business_pass_word").val();

        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/BusinessLoginController/login",
            data: "business_username="+business_username+"&business_pass_word="+business_pass_word,
            success: function(msg){
                /*alert( "Data Saved: " + msg );*/

                var result = msg.result;
                if(result == true){
                    //登录成功，跳转页面
                    location.href="${pageContext.request.contextPath}/page/main.jsp";

                }else{
                    if(msg.falseType == 1){
                        //密码有问题，el表达式提示页面效果
                        $("#returnmsg").html(msg.msg);

                    }else if(msg.falseType == 2){
                        //账户不存在，弹出提示框，是否创建账户
                        var r = confirm(msg.msg);
                        if(r == true)
                        {
                            //表示客户要创建账户
                            $.ajax({
                                type: "POST",
                                url: "${pageContext.request.contextPath}/BusinessLoginController/register",
                                data: "business_username="+business_username+"&business_pass_word="+business_pass_word,
                                success: function(msg){
                                    /*alert( "Data Saved: " + msg.result );*/
                                    location.href="${pageContext.request.contextPath}/page/main.jsp";
                                }
                            });

                        }else{
                            //表示客户不做任何操作

                        }

                    }
                }




            }
        });



    })


</script>



</body>

</html>

