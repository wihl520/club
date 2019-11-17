<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" uri="/WEB-INF/sys.tld" %>
<jsp:include page="/WEB-INF/views/includes/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/static/plugin/adminLTE/plugins/iCheck/all.css">
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="/WEB-INF/views/includes/nav.jsp"></jsp:include>

    <jsp:include page="/WEB-INF/views/includes/side.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                订单管理
            </h1>
            <c:if test="${not empty message }">
                <br>
                <div class="alert alert-success alert-dismissible ">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        ${message}
                </div>
            </c:if>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box">
                        <form action="/list" method="post" id="searchForm">
                        <div class="box-header with-border">
                                <div class="box-header with-border">
                                    <h3 class="box-title">高级搜索</h3>
                                    <input type="hidden" name="current" id="current" value="${page.current}"/>
                                    <input type="hidden" name="pageSize" id="pageSize" value="${page.pageSize}"/>
                                </div>
                               <%-- <div class="box-body">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <input type="text" class="form-control" placeholder="用户" name="username" value="${user.username}">
                                        </div>
                                        <div class="col-xs-3">
                                            <input type="text" class="form-control" placeholder="手机号码" name="phone" value="${user.phone}">
                                        </div>
                                        <div class="col-xs-3">
                                            <input type="text" class="form-control" placeholder="邮件地址" name="email" value="${user.email}">
                                        </div>
                                        <div class="col-xs-3">
                                            <button type="submit" class="btn btn-info"><i class="fa fa-search"></i> 搜索</button>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <button onclick="deleteMutil()" type="button" class="btn btn-danger" data-toggle="modal" data-target="#mutile-modal">
                                                <i class="fa fa-remove"></i> 删除
                                            </button>
                                        </div>
                                    </div>--%>
                                    <button onclick="deleteMutil()" type="button" class="btn btn-danger" data-toggle="modal" data-target="#mutile-modal">
                                        <i class="fa fa-remove"></i> 删除
                                    </button>
                                </div>
                                <!-- /.box-body -->

                        </div>
                        </form>
                        <!-- /.box-header -->
                        <div class="box-body ">
                            <table class="table table-bordered">
                                <tr>
                                    <th style="...">
                                        <input  class="minimal" type="checkbox" id="checkAll" onclick="checkAll()"/>
                                    </th>
                                    <th style="width: 10px">序号</th>
                                    <th>会员的Id</th>
                                    <th>用户</th>
                                    <th>缴费时间</th>
                                    <th >续费金额</th>
                                    <th >续费天数</th>
                                    <th >续费方式 </th>
                                    <th>操作</th>
                                </tr>


                                 <c:forEach items="${list}" var="order" varStatus="status">
                                     <tr>
                                         <td>
                                            <input class="minimal" type="checkbox" name="userCheck" value="${order.id}">
                                         </td>
                                         <td>${status.index+1}.</td>
                                         <td>${order.memberId}</td>
                                         <td>${order.name}</td>
                                         <td><fmt:formatDate value="${order.payDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                                         <td>${order.payAmount}</td>
                                         <td>${order.totalDay}</td>
                                         <td>${order.payWay}</td>
                                         <td>
                                             <button onclick="toForm('${order.id}')" class="btn btn-primary">
                                                 <i class="fa fa-edit"></i> 编辑
                                             </button>
                                             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                             <button onclick="openModal('${order.id}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-danger">
                                                 <i class="fa fa-remove"></i> 删除
                                             </button>
                                         </td>
                                     </tr>
                                 </c:forEach>


                            </table>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer clearfix">
                           <%-- <sys:page count="200" countPerPage="10" current="7"></sys:page>--%>
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


!--这是删除前的警告模态框-->
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
                <button onclick="deleteUser()" type="button" class="btn btn-outline">确认</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!--这是删除前的警告模态框-->
<div class="modal modal-danger fade in" id="mutile-modal" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span></button>
                <h4 class="modal-title">删除提示</h4>
            </div>
            <div class="modal-body">
                <p>您确定要删除这些数据吗？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">取消</button>
                <button onclick="confirmDeleteMutil()" type="button" class="btn btn-outline">确认</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
</div>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
<script type="text/javascript" src="/static/plugin/adminLTE/plugins/iCheck/icheck.min.js"></script>
<script type="text/javascript">
    function page(current) {
        //current跳转到哪一页  pageSize每页的条数
        //当你点第4页的时候，current=4


        /* var pageSize=$("#pageSize").val();
         window.location.href="/user/list?current="+current+"&pageSize="+pageSize;*/
        $("#current").val(current);
        $("#searchForm").submit();
    }

    function deleteUser() {
        var id=$("#deleteId").val();
        window.location.href="/delete?id="+id;
    }

    function openModal(id) {
        $("#deleteId").val(id);
    }

    function toForm(id) {
        window.location.href="/form?id="+id;
    }

</script>
<%--<script type="text/javascript">
    //这是跳转的逻辑
    function page(current) {
        //current跳转到哪一页  pageSize每页的条数
        //当你点第4页的时候，current=4


       /* var pageSize=$("#pageSize").val();
        window.location.href="/user/list?current="+current+"&pageSize="+pageSize;*/
        $("#current").val(current);
        $("#searchForm").submit();
    }

    function toForm(id) {
        window.location.href="/user/form?id="+id;
    }

    function deleteUser() {
        var id=$("#deleteId").val();
        window.location.href="/user/delete?id="+id;
    }

    function openModal(id) {
        $("#deleteId").val(id);
    }--%>
<script type="text/javascript">
    //要删除的id
    var idArray='';
    function deleteMutil() {
        idArray='';//不加这一条，前面的删除会影响后面的
        $("input[name='userCheck']:checked").each(function () {
            idArray+=","+$(this).val();
        });
    }
    //确认干掉
    function confirmDeleteMutil() {
        $.ajax({
            url:'/deleteMutil',
            type:'post',
            data:{ids:idArray},
            success:function () {
                alert("删除成功！");
                window.location.reload();
            }
        });
    }
</script>


<script type="text/javascript">

    //当页面加载完后，searchForm下面所有的input 输入框都加上一个onchange事件，当内容改变的时候，让当前页码改为1
    $(function () {
        $("#searchForm").find("input").change(function () {
            $("#current").val(1);
        });

        //初始化icheck
        $('input[type="checkbox"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });

        //用icheck全选
        $('#checkAll').on('ifChecked', function(event){
            $("input[name='userCheck']").iCheck('check');
        });

        //用icheck反选
        $('#checkAll').on('ifUnchecked', function(event){
            $("input[name='userCheck']").iCheck('uncheck');
        });
    });
</script>
</body>