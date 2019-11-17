<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" uri="/WEB-INF/sys.tld" %>
<jsp:include page="/WEB-INF/views/includes/head.jsp"></jsp:include>

<%--<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>--%>
<%--<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>--%>
<%--<script type="text/javascript">--%>
<%--$(function () {--%>
<%--$("#form").validate();--%>
<%--});--%>
<%--</script>pattern="/^1[3,5,7,8]\d{9}$/"--%>



<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="/WEB-INF/views/includes/nav.jsp"></jsp:include>

    <jsp:include page="/WEB-INF/views/includes/side.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                会员期限表编辑
            </h1>
            <c:if test="${not empty errorMessage }">
                <br>
                <div class="alert alert-danger alert-dismissible ">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        ${errorMessage}
                </div>
            </c:if>
            <%--<ul id='myTree' class='ztree'>--%>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">用户编辑</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" action="/deadline/update" method="post" id="form">

                            <div class="box-body">
                                <div class="form-group">
                                    <label for="memberId">会员的id</label>
                                    <input type="text" readonly="readonly" class="form-control" name="memberId"  value="${deadline.memberId}" id="memberId" placeholder="会员的id">
                                    <input type="hidden" name="id" value="${deadline.id}">
                                </div>


                                <div class="form-group">
                                    <label for="name">会员</label>
                                    <input type="text"  readonly="readonly"  required class="form-control" name="name" value="${deadline.name}"id="name" placeholder="会员">
                                </div>

                                <div class="form-group">
                                    <label for="registDate">注册日期</label>
                                   <%-- <<fmt:formatDate value="${order.payDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>--%>
                                    <input type="text"  readonly="readonly"  class="form-control" id="registDate" name="registDate" value="${regist}" placeholder="注册日期">
                                </div>

                                <div class="form-group">
                                    <label for="beginDate">会员开启的时间</label>
                                    <input type="text" readonly="readonly"  class="form-control form_datetime" id="beginDate" name="beginDate" value="${begin}"placeholder="会员开启的时间">
                                </div>
                                <div class="form-group">
                                    <label for="totalDay">剩余的天数</label>
                                    <input type="text"    class="form-control" id="totalDay" name="totalDay" value="${deadline.totalDay}"placeholder="剩余的天数">
                                </div>

                                <div class="form-group">
                                    <label for="restStatus">休课状态</label>
                                    <c:choose>
                                        <c:when test="${deadline.restStatus==1}">
                                            <input type="text"  class="form-control" id="restStatus" name="restStatus" value="休课中" placeholder="会员开启的时间">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text"   class="form-control" id="restStatus" name="restStatus" value="上课中"placeholder="会员开启的时间">
                                        </c:otherwise>
                                    </c:choose>

                                </div>

                            </div>


                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">提交</button>
                            </div>
                        </form>
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

<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<!-- iCheck 1.0.1 -->
<script src="/static/plugin/adminLTE/plugins/iCheck/icheck.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#form").validate();
    });
</script>
<script type="text/javascript">

    // function submitForm() {
    //     var password=$("#password").val();
    //     password=password.trim();
    //     if(password==''){
    //         alert("密码不能为空！");
    //         return;
    //     }
    //     if(password.length<6 || password.length>20){
    //         alert("密码长度不可以少于6位，不能超过20位");
    //         return;
    //     }
    //     var username=$("#username").val();
    //     username=username.trim();
    //     if(username==''){
    //         alert("用户名不能为空！");
    //         return;
    //     }
    //     if(username.length<3 || username.length>10){
    //         alert("用户名长度不可以少于3位，不能超过10位");
    //         return;
    //     }
    //     var phone=$("#phone").val();
    //     phone=phone.trim();
    //     if(!checkPhone(phone)){
    //         alert("电话号码格式不正确！")
    //         return;
    //     }
    //     $("#form").submit();
    // }
    function checkPhone(str){
        var re = /^1\d{10}$/;
        if(re.test(str)){
            return true;
        }else{
            return false;
        }
    }
</script>

