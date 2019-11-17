<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>${tip.title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/tips/reset.css">
    <link rel="stylesheet" href="/static/tips/index.css">
    <script type="text/javascript" src="/static/tips/jquery.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/tips/includes/header.jsp"/>
<div class="info-nav">
    <ul>

        <li><a href="/tips/plan">健身计划P</a></li>

        <li><a href="/tips/tip">健身贴士</a></li>

        <li><a href="/tips/yingyang">营养更健康</a></li>

    </ul>
    <div class="clearfix"></div>
</div>
<div class="information-main">
    <div class="information-content">
        <div class="information-title">
            <h3> 万圣节，健身推出广州深圳通卡！仲有“鬼咁多”优惠和“捉鬼”游戏！</h3>
            <div>
                Exo me？“捉鬼”？没错！在“万鬼出没”的万圣节！！！
                怎少得了齐齐“捉鬼”呢！
                正如西方有“吸血鬼”、韩国有“丧尸”
                日本有“贞子”、中国有“僵尸”不同
                健身房的鬼也不一样！
                有
                “肥仔鬼”“瘦鬼”“饿死鬼”“懒鬼”
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/tips/includes/footer.jsp"/>
<script type="text/javascript" src="/static/tips/index.js"></script>
</body>
</html>