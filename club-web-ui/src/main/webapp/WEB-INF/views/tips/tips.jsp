<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>教你健身吧</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">



    <link rel="stylesheet" href="/static/tips/reset.css">
    <link rel="stylesheet" href="/static/tips/index.css">
    <link rel="stylesheet" href="/static/tips/lrtk.css">
    <script type="text/javascript" src="/static/tips/jquery.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/tips/includes/header.jsp"/>
<div class="branch-main">
    <!-- 焦点图 -->
    <div class="slide_container">
        <ul class="rslides" id="slider">
            <li>
                <img src="/static/tips/img/lunbo1.jpg" alt="">
            </li>
            <li>
                <img src="/static/tips/img/lunbo2.jpg" alt="">
            </li>
            <li>
                <img src="/static/tips/img/lunbo3.jpg" alt="">
            </li>
        </ul>
    </div>
    <!-- 焦点图 -->
    <div class="clearfix"></div>
</div>
<div class="clearfix"></div>

<div class="as-pinwheel-header">
    <h2>教你健身吧</h2>
    <p>关注健身，更关注身体，教你健身吧为你愉快健身服务</p>
   <a href="/tips/plan"><img src="/static/tips/img/shoubi2.jpg" width="300" alt=""></a>
    <a href="/tips/tip"> <img src="/static/tips/img/tu22.jpg" width="300" alt=""></a>
   <a href="/tips/yingyang"><img src="/static/tips/img/tu33.png" width="300" alt=""></a>
    <img src="/static/tips/img/timg.jpg" width="100%" alt="">
</div>
</div>
<jsp:include page="/WEB-INF/views/tips/includes/footer.jsp"/>
<script type="text/javascript" src="/static/tips/index.js"></script>
<script src="/static/tips/responsiveslides.min.js"></script>
<script src="/static/tips/slide.js"></script>
</body>
</html>