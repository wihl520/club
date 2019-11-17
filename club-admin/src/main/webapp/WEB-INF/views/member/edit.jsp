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
            <c:if test="${not empty errorMessage }">
                <br>
                <div class="alert alert-danger  alert-dismissible ">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        ${errorMessage}
                </div>
            </c:if>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- general form elements -->
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">编辑用户</h3>
                            </div>
                            <!-- /.box-header -->
                            <%--form start--%>
                            <form method="post" action="/member/edit">

                                <div class="form-group">
                                    <label for="name">用户名</label>
                                    <input type="hidden" name="id" <c:if test="${member.id!=null}">value="${member.id}"</c:if> >
                                    <input type="text" maxlength="10" minlength="3" required value="${member.name}" class="form-control" id="name" name="name" placeholder="用户名">
                                </div>

                                <div class="form-group">
                                    <label >邮箱地址</label>
                                    <input type="email" class="form-control" value="${member.email}" required name="email" id="exampleInputEmail1" placeholder="电子邮件">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputEmail1">性别</label>
                                    <input type="text" class="form-control" value="${member.sex}" name="sex" id="sex" placeholder="性别">
                                </div>

                                <%--<div class="form-group">--%>
                                <%--<label for="exampleInputEmail1">性别</label>--%>
                                <%--&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;--%>
                                <%--<label class="radio-inline">--%>
                                <%--<input type="radio" name="sexselect" value="男" <c:if test="${member.sex eq 1}">checked</c:if>>男</label>--%>
                                <%--<label class="radio-inline">--%>
                                <%--<input type="radio" name="sexselect" value="女" <c:if test="${member.sex eq 0 }">checked</c:if>>女</label>--%>
                                <%--</div>--%>

                                <div class="form-group">
                                     <label for="exampleInputEmail1">用户等级</label>
                                     <input type="text" class="form-control" value="${member.level}" name="level" id="level" placeholder="用户等级">
                                </div>
                                <div class="form-group">
                                    <label for="phone">电话号码</label>
                                    <input type="text" class="form-control" value="${member.phone}" id="phone" name="phone" placeholder="电话号码">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">教练编号</label>
                                    <input type="text" class="form-control" value="${member.coachId}" name="coachId" id="coachId" placeholder="教练编号">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">头像地址</label>
                                    <input type="text" class="form-control" value="${member.pic}" name="pic" id="pic" placeholder="头像地址">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">用户地址</label>
                                    <input type="text" class="form-control" value="${member.address}" name="address" id="address" placeholder="用户地址">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputEmail1">年龄</label>
                                    <input type="text" class="form-control" value="${member.age}" name="age" id="age" placeholder="年龄">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">计划文本</label>
                                    <input type="text" class="form-control" value="${member.plan}" name="plan" id="plan" placeholder="计划文本">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">锻炼位置</label>
                                    <input type="text" class="form-control" value="${member.wantBuild}" name="wantBuild" id="wantBuild" placeholder="锻炼位置">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">身份</label>
                                    <input type="text" class="form-control" value="${member.isCoach}" name="isCoach" id="isCoach" placeholder="是否是教练">
                                </div>

                                <div class="box-footer">
                                    <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                                    <input type="submit" name="submit" class="submit"  value="提交">
                                </div>
                            </form>
                            <%-- form end --%>
                        </div>
                        <!-- /.box -->

                    </div>

                </div>

            </section>
        </section>

        <!-- Main content -->

        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="/WEB-INF/views/includes/copyRight.jsp"></jsp:include>

</div>

</div>
</body>


<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>

