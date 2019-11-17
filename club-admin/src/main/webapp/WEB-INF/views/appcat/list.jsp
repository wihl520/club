<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" uri="/WEB-INF/sys.tld" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/includes/head.jsp"></jsp:include>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="/WEB-INF/views/includes/nav.jsp"></jsp:include>

    <jsp:include page="/WEB-INF/views/includes/side.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                器材管理
            </h1>


        </section>

        <!-- Main content -->
        <section class="content">
            <%--提示信息回显--%>
            <c:if test="${not empty message }">
                <br>
                <div class="alert alert-success alert-dismissible ">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        ${message}
                </div>
            </c:if>
            <c:if test="${not empty failMessage }">
                <br>
                <div class="alert alert-danger alert-dismissible ">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        ${failMessage}
                </div>
            </c:if>

            <%--高级搜索框--%>
            <div class="row">
                <div class="col-md-12">
                    <form action="/appcat/list" method="get" id="searchForm">
                    <div class="box ">
                        <div class="box-header with-border">
                            <h3 class="box-title">高级搜索</h3>
                            <input type="hidden" name="current" id="current" value="${page.current}"/>
                            <input type="hidden" name="pageSize" id="pageSize" value="${page.pageSize}"/>
                        </div>
                        <div class="box-body">
                            <div class="row">
                                <div class="col-xs-3">
                                    <input type="text" name="name" class="form-control" value="${appcat.name}" placeholder="器材类名">
                                </div>

                                <div class="col-xs-3">
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-info"><i class="fa fa-search"></i> 搜索</button>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->

                    </div>
                    </form>
                </div>
            </div>

            <%--展示列表--%>
            <div class="row">
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">分类列表</h3>
                        </div>

                        <!-- /.box-header -->
                        <div class="box-body ">
                            <table class="table table-bordered">
                                <tr>
                                    <th style="width: 10px">序号</th>
                                    <th>器材类名</th>
                                    <th>所属类别</th>
                                    <th >图片地址</th>
                                    <th >器材描述</th>
                                    <th >使用方式</th>
                                    <th >器材的锻炼要点</th>
                                 <%-- <th >创建时间</th>
                                    <th >更新时间 </th>--%>
                                    <th >操作</th>
                                </tr>
                                <!--data 对象 -->

                                <c:forEach items="${list}" var="appcat" varStatus="status">
                                <tr>
                                    <td>${status.index+1}.</td>
                                    <td>${appcat.name}</td>
                                    <td>${appcat.parent.name}</td>
                                    <td><a href="${appcat.pic}" target="_blank">查看</a></td>
                                    <td>${appcat.describe}</td>
                                    <td>
                                        <c:if test="${fn:length(appcat.mode) > 8}">${fn:substring(appcat.mode, 0, 8)}...</c:if>
                                        <c:if test="${fn:length(appcat.mode) <= 8}">${appcat.mode}</c:if>
                                        <%--${appcat.mode}--%>
                                    </td>
                                    <td>
                                        <c:if test="${fn:length(appcat.play) > 8}">${fn:substring(appcat.play, 0, 8)}...</c:if>
                                        <c:if test="${fn:length(appcat.play) <= 8}">${appcat.play}</c:if>
                                           <%-- ${appcat.play}--%>
                                    </td>
                                   <%-- <td>${appcat.video}</td>--%>
                                    <%--<td><fmt:formatDate value="${appcat.created}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                                    <td><fmt:formatDate value="${appcat.updated}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>--%>
                                    <td>
                                        <button onclick="toForm('${appcat.id}')" class="btn btn-primary">
                                            <i class="fa fa-edit"></i> 编辑
                                        </button>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button onclick="openModal('${appcat.id}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-danger">
                                            <i class="fa fa-remove"></i> 删除
                                        </button>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button onclick="toAddSubNode('${appcat.id}')" type="button" class="btn btn-default" >
                                            <i class="fa fa-plus"></i> 子分类/器材
                                        </button>
                                    </td>
                                </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <!-- /.box-body -->
                        <%--使用自定义分页标签--%>
                        <div class="box-footer clearfix">
                            <%--<sys:page count="200" countPerPage="10" current="7"></sys:page>--%>
                            <ul class="pagination pagination-sm no-margin pull-right">
                                <sys:page count="${page.count}" current="${page.current}" pageSize="${page.pageSize}"></sys:page>
                            </ul>
                        </div>
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="/WEB-INF/views/includes/copyRight.jsp"></jsp:include>
        <!-- Add the sidebar's background. This div must be placed
             immediately after the control sidebar -->
        <%--<div class="control-sidebar-bg"></div>--%>
    </div>

</div>
<!--这是删除前的警告模态框-->
<div class="modal modal-danger fade in" id="modal-danger" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span></button>
                <h4 class="modal-title">删除提示</h4>
            </div>
            <div class="modal-body">
                <p>您确定要删除这条数据吗？</p>
                <input type="hidden" id="deleteId" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">取消</button>
                <button onclick="deleteAppcat()" type="button" class="btn btn-outline">确认</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<script type="text/javascript">
    function toAddSubNode(id) {
        window.location.href="/appcat/toAddSubNode?id="+id;
    }
    //这是跳转的逻辑
    function page(current) {
        //current跳转到哪一页  pageSize每页的条数
        //当你点第4页的时候，current=4
        $("#current").val(current);
        //window.location.href="/user/list?current="+current+"&pageSize="+pageSize;
        $("#searchForm").submit();
    }
    function toForm(id) {
        window.location.href="/appcat/form?id="+id;
    }

    function deleteAppcat() {
        var id=$("#deleteId").val();
        window.location.href="/appcat/delete?id="+id;
    }

    function openModal(id) {
        $("#deleteId").val(id);
    }
</script>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>

<script type="text/javascript">

    //当页面加载完后，searchForm下面所有的input 输入框都加上一个onchange事件，当内容改变的时候，让当前页码改为1
    $(function () {
        $("#searchForm").find("input").change(function () {
            $("#current").val(1);
        });
    });
</script>