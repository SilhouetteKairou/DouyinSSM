<%--
  Created by IntelliJ IDEA.
  User: 10072
  Date: 2020/2/25
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>冻结商户账户</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/footable/footable.core.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>商户列表</h5>
                </div>
                <div class="ibox-content">

                    <!--数据表顶部查询 开始
                        该区域可以将来存放 各种控件
                    -->

                    <!--数据表顶部查询 结束-->
                    <!--数据表开始-->
                    <div class="jqGrid_wrapper">
                        <form method="post" action="#">
                            <table class="footable table table-stripped table-hover" data-page-size="8" data-filter=#filter>
                                <!--数据头 开始-->
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>登录名</th>
                                    <th>商家名</th>
                                    <th>法人姓名</th>
                                    <th>联系方式</th>
                                    <%--                                <th></th>--%>
                                </tr>
                                </thead>
                                <!--数据头 结束-->
                                <!--数据体 开始-->
                                <tbody>
                                <c:forEach items="${businessList}" var="businessUser">
                                    <tr class="gradeX">
                                        <td>${businessUser.business_id}</td>
                                        <td>${businessUser.business_username}</td>
                                        <td>${businessUser.business_info_name}</td>
                                        <td class="center">${businessUser.business_info_legal_persion}</td>
                                        <td class="center">${businessUser.business_info_legal_persion_tel}</td>
                                    </tr>
                                </c:forEach>


                                </tbody>
                                <!--数据体 结束-->
                                <!--数据分页 开始-->
                                <tfoot>
                                <tr>
                                    <td colspan="5">
                                        <ul class="pagination pull-right"></ul>
                                    </td>
                                </tr>
                                </tfoot>
                                <!--数据分页 结束-->
                            </table>
                        </form>
                    </div>
                    <p>&nbsp;</p>
                    <!--数据表结束-->

                    <span >
                        请输入要冻结的商户序号：
                    <input type="text" name="business_id" id="business_id">
                    <button class="btn btn-primary" type="submit" onclick="click()">冻结账号</button>
                    </span>

                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${pageContext.request.contextPath}/js/plugins/footable/footable.all.min.js"></script>


<!--
    &lt;!&ndash; Peity &ndash;&gt;
    <script src="../js/plugins/peity/jquery.peity.min.js"></script>
    &lt;!&ndash; jqGrid &ndash;&gt;
    <script src="../js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
    <script src="../js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>
-->


<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/js/content.js?v=1.0.0"></script>
<script>
    $(document).ready(function() {
        $('.footable').footable();
        $('.footable2').footable();
    });

</script>

<script type="text/javascript">
    $(function click() {
        var business_id = $("#business_id").val();

    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/SystemUserController/freezeBusinessUser",
        data: "business_id="+business_id,
        success: function(data){
            alert("操作成功");

        }
    });

    }

    <%--var returnmsg = "${msg}";--%>
    <%--if(returnmsg != ""){--%>
    <%--    alert(returnmsg);--%>
    <%--}--%>

</script>

</body>

</html>


