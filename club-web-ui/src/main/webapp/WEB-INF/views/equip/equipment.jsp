<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>器材</title>
    <link rel="stylesheet" type="text/css" href="/static/list/css/style.css">
</head>
<body>
<!-- start header -->
<header>
    <div class="top center">
      <%--  <div class="left fl">
            <ul>
                <li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
                <li>|</li>
                <li><a href="">MIUI</a></li>
                <li>|</li>
                <li><a href="">米聊</a></li>
                <li>|</li>
                <li><a href="">游戏</a></li>
                <li>|</li>
                <li><a href="">多看阅读</a></li>
                <li>|</li>
                <li><a href="">云服务</a></li>
                <li>|</li>
                <li><a href="">金融</a></li>
                <li>|</li>
                <li><a href="">小米商城移动版</a></li>
                <li>|</li>
                <li><a href="">问题反馈</a></li>
                <li>|</li>
                <li><a href="">Select Region</a></li>
                <div class="clear"></div>
            </ul>
        </div>--%>
        <div class="right fr">
          <%--  <div class="gouwuche fr"><a href="">购物车</a></div>--%>
            <div class="fr">
                <ul>
                    <li><a href="#" target="_blank">登录</a></li>
                    <li>|</li>
                    <li><a href="#" target="_blank" >注册</a></li>
                    <li>|</li>
                <%--    <li><a href="">消息通知</a></li>--%>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="./index.html" target="_blank"><div class="logo fl"></div></a>
    <a href=""><div class="ad_top fl"></div></a>
    <div class="nav fl">
        <%--<ul>
            <li><a href="">小米手机</a></li>
            <li><a href="">红米</a></li>
            <li><a href="">平板·笔记本</a></li>
            <li><a href="">电视</a></li>
            <li><a href="">盒子·影音</a></li>
            <li><a href="">路由器</a></li>
            <li><a href="">智能硬件</a></li>
            <li><a href="">服务</a></li>
            <li><a href="">社区</a></li>
        </ul>--%>
    </div>
   <%-- <div class="search fr">
        <form action="" method="post">
            <div class="text fl">
                <input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
            </div>
            <div class="submit fl">
                <input type="submit" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>--%>
</div>
<!-- end banner_x -->


<!-- xiangqing -->
<form action="post" method="">
    <div class="xiangqing">
        <div class="neirong w">
            <div class="xiaomi6 fl">健身俱乐部</div>
           <%-- <nav class="fr">
                <li><a href="">概述</a></li>
                <li>|</li>
                <li><a href="">变焦双摄</a></li>
                <li>|</li>
                <li><a href="">设计</a></li>
                <li>|</li>
                <li><a href="">参数</a></li>
                <li>|</li>
                <li><a href="">F码通道</a></li>
                <li>|</li>
                <li><a href="">用户评价</a></li>
                <div class="clear"></div>
            </nav>--%>
            <div class="clear"></div>
        </div>
    </div>
    <c:set var="info" value="${result.data}"></c:set>

    <div class="jieshao mt20 w">
        <div class="left fl"><img src="/static/image/${info.pic}"></div>
        <div class="right fr">
            <div class="h3 ml20 mt20">器材名称</div>
            <input type="hidden" name="categoryId" value="${info.id}">
            <div class="jianjie mr40 ml20 mt10">${info.name}</div>
            <%--<div class="jiage ml20 mt10">2499.00元</div>--%>
            <div class="ft20 ml20 mt20">${info.name}描述</div>
            <div class="xzbb ml20 mt10">
                <div class="banben fl">
                    <a>
                        <span>${info.describe}</span>
                       <%-- <span>2499元</span>--%>
                    </a>
                </div>
               <%-- <div class="banben fr">
                    <a>
                        <span>全网通版 6GB+128GB</span>
                        <span>2899元</span>
                    </a>
                </div>
                <div class="clear"></div>--%>
            </div>

            <%--<div class="xqxq mt20 ml20">
                <div class="top1 mt10">--%>
                    <div class="ft20 ml20 mt20">${info.name}的锻炼的要点</div>
                    <%--<div class="right1 fr">2499.00元</div>--%>
                    <div class="clear"></div>
              <%--  </div>--%>
                    <div class="bot mt20 ft20 ftbc">${info.play}</div>
            <%--</div>--%>


            <div class="ft20 ml20 mt20">${info.name}使用方式介绍</div>
            <div class="form-group">
               <div id="editor" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${info.mode}</div>
            </div>
            <a href="/list?categoryId=${info.id}" style="color: red">详细信息</a>
           <%-- <div class="xzbb ml20 mt10">
                <div class="banben">
                   <a>
                       &lt;%&ndash; <span class="yuandian"></span>&ndash;%&gt;


                    </a>
                </div>

            </div>
--%>


            <%--<div class="xiadan ml20 mt20">
                <input class="jrgwc"  type="button" name="jrgwc" value="立即选购" />
                <input class="jrgwc" type="button" name="jrgwc" value="加入购物车" />

            </div>--%>
        </div>
        <div class="clear"></div>
    </div>
</form>
<!-- footer -->
<footer class="mt20 center">

    <div class="mt20">健身俱乐部|FITNESS|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>

</footer>

</body>
</html>