<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 白发戴花君莫笑，岁月从不败美人
  Date: 2020/2/27
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>数据列表</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/footable/footable.core.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>视频标题列表</h5>
                </div>
                <div class="ibox-content">

                    <!--数据表顶部查询 开始
                        该区域可以将来存放 各种控件
                    -->

                    <!--数据表顶部查询 结束-->
                    <!--数据表开始-->
                    <div class="jqGrid_wrapper">
                        <table class="footable table table-stripped table-hover" data-page-size="8" data-filter=#filter>
                            <!--数据头 开始-->
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>上传用户</th>
                                <th>视频标题</th>
                                <th>上传时间</th>
                                <th>查看</th>
                                <th>状态</th>
                            </tr>
                            </thead>
                            <!--数据头 结束-->
                            <!--数据体 开始-->
                            <tbody>
                            <c:forEach items="${videoList}" var="videoInfo">
                                <tr class="gradeX">
                                    <td>${videoInfo.video_id}</td>
                                    <td>${videoInfo.business_username}</td>
                                    <td>${videoInfo.video_title}</td>
                                    <td>${videoInfo.video_date}</td>
                                    <td class="center">
                                        <button type="button" class="btn btn-primary"data-toggle="modal" data-target="#myModal"
                                                onclick="changeVideoSrc('${videoInfo.video_src}')" >
                                            查看</button></td>
                                    <td class="center">
                                        <button type="button" class="btn btn-primary"data-toggle="modal"
                                                onclick="restoreVideo('${videoInfo.video_id}')">
                                            恢复</button></td>
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
                    </div>
                    <p>&nbsp;</p>
                    <!--数据表结束-->
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    /*当点击按钮的时候，将对应的src添加到模态框中的video元素中*/
    function changeVideoSrc(src){
        $("#videoSrc").attr("src","${pageContext.request.contextPath}"+src);
    }
</script>
<script>
    /*点击按钮弹出confirm，若确认则修改status为 1*/
    function restoreVideo(video_id){

        var v = confirm("是否恢复该视频");
        if(v){
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/VideoController/restoreVideoByAdmin",
                data:{video_id:video_id},
                success: function(msg){
                    alert(msg.msg);
                }
            })
        }
    }
</script>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">视频查看</h4>
            </div>
            <div class="modal-body">
            <%--src:这个数据是动态的，被脚本设置的--%>
                <video id="videoSrc" src="" controls width="700" height="500" >
                </video>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
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
<script src="js/content.js?v=1.0.0"></script>
<script>
    $(document).ready(function() {
        $('.footable').footable();
        $('.footable2').footable();
    });

</script>

</body>

</html>