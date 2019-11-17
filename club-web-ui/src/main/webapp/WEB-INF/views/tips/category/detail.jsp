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
            <h3>${tip.title}</h3>
            <div>
                ${tip.content}
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/tips/includes/footer.jsp"/>
<script type="text/javascript" src="/static/tips/index.js"></script>
</body>
</html>