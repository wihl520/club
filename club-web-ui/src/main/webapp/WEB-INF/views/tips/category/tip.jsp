<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>健身贴士</title>
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

        <li><a href="javascript:void(0)">健身贴士</a></li>

        <li><a href="/tips/yingyang">营养更健康</a></li>

    </ul>
    <div class="clearfix"></div>
</div>
<div class="information-main">
    <div class="information-content">
        <div class="information-title">
            <h3>健身贴士</h3>
        </div>
        <c:forEach items="${list}" var="tip">
            <div class="information-img-1">
                <a href="hppt://localhost:8082/tip/goByTipId?id=${tip.id}" target="_blank">
                    <img src="hppt://localhost:8081/tip/picShow?FileName=${tip.pic}" alt="">
                    <input type="hidden" name="id" id="id" value="${tip.id}">
                    <h2>${tip.title}</h2>
                    <p>${tip.subTitle}</p>
                    <span><fn:formatDate value="${tip.created}" pattern="yyyy-MM-dd" /></span>
                </a>
            </div>
        </c:forEach>
        <div class="information-img-1">
            <a href="/tips/towanshenjie" target="_blank">
                <img src="/static/tips/img/wanshenjie.jpg" alt="">
                <h2>万圣节，健身推出广州深圳...</h2>
                <p>Halloween is coming！一年一度的万圣节驾到，健身万圣狂欢趴即将开启，我们势必将惊喜、优惠、好玩进行到底，想加入一起“搞鬼搞马”？快来看看健身即日起—2018.10.31“鬼咁优惠”万圣节系列活动</p>
                <span>2018-10-24</span>
            </a>
        </div>
        <div class="information-img-1">
            <a href="/tips/tobanka" target="_blank">
                <img src="/static/tips/img/banka.jpg" alt="">
                <h2>健身推出周卡！限量！只要...</h2>
                <p>你有没有这样的烦恼呢？一直想去健身，却因为价格犹犹豫豫，既羡慕着别人的好身材，又狠不下心办一张健身房的年卡，就这样一年又过去了</p>
                <span>2018-10-30</span>
            </a>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/tips/includes/footer.jsp"/>
<script type="text/javascript" src="/static/tips/index.js"></script>
</body>
</html>
