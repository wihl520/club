<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--时间的转换--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--引入自定义的分页标签--%>
<%@ taglib prefix="sys" uri="/WEB-INF/sys.tld" %>


<jsp:include page="/WEB-INF/views/includes/head.jsp"></jsp:include>
<!-- iCheck for checkboxes and radio inputs -->
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
        </section>
    </div>

    <jsp:include page="/WEB-INF/views/includes/copyRight.jsp"></jsp:include>

    <jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
</div>
</body>
</html>
