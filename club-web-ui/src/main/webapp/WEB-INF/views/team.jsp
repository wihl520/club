<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8" />
    <title>教练团队</title>
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--// Mobile Metas //-->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <!--// Stylesheets //-->
    <link rel="stylesheet" href="static/css/base.css" />
    <link rel="stylesheet" href="static/css/skeleton.css" />
    <link rel="stylesheet" href="static/css/layout.css" />
    <link rel="stylesheet" href="static/css/style.css" />

    <link rel="stylesheet" type="text/css" href="static/css/color.css" title="styles7" media="screen" />
    <link rel="alternate stylesheet" type="text/css" href="static/css/red.css" title="styles1" media="screen" />
    <link rel="alternate stylesheet" type="text/css" href="static/css/blue.css" title="styles2" media="screen" />
    <link rel="alternate stylesheet" type="text/css" href="static/css/gray.css" title="styles3" media="screen" />
    <link rel="alternate stylesheet" type="text/css" href="static/css/orange.css" title="styles4" media="screen" />
    <link rel="alternate stylesheet" type="text/css" href="static/css/green.css" title="styles5" media="screen" />
    <link rel="alternate stylesheet" type="text/css" href="static/css/orange-red.css" title="styles6" media="screen" />
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <!--// Favicons //-->
    <link rel="shortcut icon" href="static/images/favicon.ico" />
    <link rel="rockit-touch-icon" href="static/images/touch-icon.png" alt="" />
    <link rel="rockit-touch-icon" sizes="72x72" href="static/images/touch-icon-72x72.png" alt="" />
    <link rel="rockit-touch-icon" sizes="114x114" href="static/images/touch-icon-114x114.png" alt="" />
    <!--// Javascript //-->
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <script type="text/javascript" src="static/js/styleswitch.js"></script>
    <script type="text/javascript" src="static/js/animatedcollapse.js"></script>
    <script type="text/javascript" src="static/js/jquery.infinite-carousel.js"></script>
    <script type="text/javascript" src="static/js/ddsmoothmenu.js"></script>
    <script type="text/javascript" src="static/js/jquery.nivo.slider.js"></script>
    <script type="text/javascript" src="static/js/scrolltopcontrol.js"></script>
    <script type="text/javascript" src="static/js/tabs.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

<!-- Outer Wrapper Start -->
<div id="outer-wrapper">
    <!-- Header Start -->
    <%@include file="../../static/include/head.jsp"%>
    <!-- Header End -->
    <div class="clear"></div>
    <div class="inner">
        <div class="inner shadow">
            <!-- Banner Start -->
            <div id="subpage-banner" class="row">
                <a href="#"><img src="static/images/sub-banner3.jpg" alt="" /></a>
            </div>
            <!-- Banner End -->
            <div class="clear"></div>
            <!-- Container Start -->
            <!-- Banners End -->
            <div class="container row">
                <!-- Two Third Column Start -->
                <div class="sixteen columns">
                    <h2 class="heading">教练信息</h2>
                    <div class="in-sec">

                        <!-- Plans Start -->

                        <c:forEach items="${coachList}" var="Coach">
                            <div class="package">
                                <div class="in-sec">
                                    <div class="thumb">
                                        <a href="#"><img src="static/images/${Coach.pic}" alt="" /></a>
                                    </div>
                                    <div class="desc">
                                        <h2 class="upper white">姓名：${Coach.name}</h2>
                                        <c:choose>
                                            <c:when test="${Coach.sex == '1'}">
                                                <h5 class="upper white"style="color: #000000;">性别：男</h5>
                                            </c:when>
                                            <c:otherwise>
                                                <h5 class="upper white"style="color: #000000;">性别：女</h5>
                                            </c:otherwise>
                                        </c:choose>
                                        <h5 class="upper white"style="color: #000000;">年龄：${Coach.age}</h5>
                                        <p>
                                            技能<a href="#" class="colr">:${Coach.plan}</a>,
                                        </p>
                                        <h5 class="upper white"style="color: #000000;">邮箱：${Coach.email}</h5>
                                        <ul class="bullets">
                                            <li><a>咨询:${Coach.phone}</a></li>
                                            <li><a href="/findcoachInfo?id=${Coach.id}" class="colr">预约</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- Plans End -->
                        </c:forEach>
                    </div>
                    <div class="clear"></div>
                </div>
                <!-- Two Third Column End -->
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- Outer Wrapper End -->
<!-- Footer Start -->
<jsp:include page="/WEB-INF/views/member/include/footer.jsp"></jsp:include>
<!-- Footer End -->

</body>
</html>