<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" uri="/WEB-INF/sys.tld" %>
<jsp:include page="/WEB-INF/views/includes/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/static/plugins/adminLTE/plugins/iCheck/all.css">
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="/WEB-INF/views/includes/nav.jsp"></jsp:include>

    <jsp:include page="/WEB-INF/views/includes/side.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
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
            <div class="box box-primary box-info-search" style="display:none;">
                <div class="col-md-12">
                    <form action="/member/list" method="get" id="searchForm">
                        <div class="box ">
                            <div class="box-header with-border">
                                <h3 class="box-title">高级搜索</h3>
                                <input type="hidden" name="current" id="current" value="${page.current}"/>
                                <input type="hidden" name="pageSize" id="pageSize" value="${page.pageSize}"/>
                            </div>
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" name="email" class="form-control" value="${member.email}" placeholder="邮件地址">
                                    </div>
                                    <div class="col-xs-3">
                                        <input type="text" name="name" class="form-control" value="${member.name}" placeholder="用户名">
                                    </div>
                                    <div class="col-xs-3">
                                        <input type="text" name="phone" class="form-control" value="${member.phone}" placeholder="电话号码">
                                    </div>
                                    <div class="col-xs-3">
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <button type="submit" class="btn btn-info"><i class="fa fa-search"></i> 搜索</button>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->

                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">用户列表</h3>
                        </div>

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="row" style="padding-left: 20px;padding-top: 10px">
                                    <a href="/member/from" type="button" class="btn btn-success"><i class="fa fa-plus-circle"></i>新增</a>
                                    <button onclick="deleteMutil()" type="button" class="btn btn-danger" data-toggle="modal" data-target="#mutile-modal">
                                        <i class="fa fa-remove"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-primary" onclick="$('.box-info-search').css('display')=='none'?$('.box-info-search').show('fast'):$('.box-info-search').hide('fast')"><i class='fa fa-fw fa-search'></i>搜索</button>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body ">
                            <table id="dataTable" class="table table-bordered">
                                <thead>
                                <tr>
                                    <th> <input class="minimal" type="checkbox" id="checkAll" ></th>
                                    <th >ID</th>
                                    <th>用户名</th>
                                    <th>邮件地址</th>
                                    <th>性别</th>
                                    <th >电话</th>
                                    <th >教练编号 </th>
                                    <th >年龄 </th>
                                    <th >计划文本 </th>
                                    <th >锻炼部位 </th>
                                    <th >是否是教练 </th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!--data 对象 -->
                                <c:set var="data" value="${result.data.list}"></c:set>
                                <c:set var="page" value="${result.data}"></c:set>

                                <c:forEach items="${data}" var="member" varStatus="status">
                                    <tr>
                                        <td><input class="minimal" type="checkbox" name="userCheck" value="${member.id}"></td>
                                        <td>${status.index+1}</td>
                                        <td>${member.name}</td>
                                        <td>${member.email}</td>
                                        <td>${member.sex}</td>
                                        <td>${member.phone}</td>
                                        <td>${member.coachId}</td>
                                        <td>${member.age}</td>
                                        <td> <a href="${member.plan}" target="_blank">查看</a></td>
                                        <td>${member.wantBuild}</td>
                                        <td>${member.isCoach}</td>
                                        <td>
                                            <button type="button" class='btn btn-sm btn-default' onclick="showDetail('${member.id}')"><i class='fa fa-fw fa-search' title='查看'></i></button>
                                            <button type="button" class='btn btn-sm btn-info' onclick="toForm('${member.id}')"><i class='fa fa-fw fa-edit' title='编辑'></i></button>
                                            <button onclick="openModal('${member.id}')" type="button" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#modal-danger">
                                                <i class="fa fa-remove" title='删除'></i>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer clearfix">

                            <%--<sys:page count="200" countPerPage="10" current="7"></sys:page>--%>
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

<script type="text/javascript">
    //这是跳转的逻辑
    function page(current) {
        //current跳转到哪一页  pageSize每页的条数
        //当你点第4页的时候，current=4
        $("#current").val(current);
        //window.location.href="/user/list?current="+current+"&pageSize="+pageSize;
        $("#searchForm").submit();
    }
    function toForm(id) {
        window.location.href="/member/from?id="+id;
    }

    function deleteUser() {
        var id=$("#deleteId").val();
        window.location.href="/member/delete?id="+id;
    }
    function openModal(id) {
        $("#deleteId").val(id);
    }
    function checkAll() {
        //在高版本jqeury里面，获取控件自身的属性用prop,自定义的属性用attr
        var check=$("#checkAll").prop("checked");
        if(check){
            $("input[name='userCheck']").prop("checked",true);
        }else {
            $("input[name='userCheck']").prop("checked",false);
        }

    }
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
            url:'/member/deleteMutil',
            type:'post',
            data:{ids:idArray},
            success:function () {
                alert("删除成功！");
                window.location.reload();
            }
        });
    }
</script>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
<script type="text/javascript" src="/static/plugins/adminLTE/plugins/iCheck/icheck.min.js"></script>
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
<script>
    $(function () {
        $("#dataTable").DataTable({
            "paging": true,
            "info": true,
            "processing": true,
            "searching": false,
            "ordering": false,
            "lengthChange": false,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        })
    });
    function showDetail(id) {
        $.ajax({
            "url":"/member/detail?id="+id,
            "type":"get",
            "dataType":"html",
            success:function (data) {
                $("#modal-default-body").html(data);
                $("#modal-default").modal("show")
            }
        });

    }
</script>
</body>