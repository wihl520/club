<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
    <span class="top-bar">&nbsp;</span>
    <div class="in">
        <!-- Container Start -->
        <div class="container">
            <!-- Logo Start -->
            <div class="five columns left">
                <a href="/index" class="logo"><img src="static/index/images/Clublogo.jpg" alt="" /></a>
            </div>
            <!-- Logo End -->
            <div class="eleven columns right hidemobile">
                <div class="top-links">
                    <span class="leftnode">&nbsp;</span>
                    <!-- Top Links Start -->
                    <ul>
                        <c:choose>
                            <c:when test="${ not empty member}">
                                <li><a href="#" style="color: red;">你好，${member.name}</a> </li>|
                                <li><a href="/LogoutUser">注销</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="/membertologin" style="color: red;">你好，请登录</a></li>|
                                <li><a href="/membertoregist">注册</a></li>
                            </c:otherwise>
                        </c:choose>


                        <li><a href="#">我的信息</a></li>
                        <li><a href="#">我的计划</a></li>
                        <li>
                            <a href="javascript:animatedcollapse.toggle('search-box')">搜索</a>
                            <div id="search-box" fade="1">
                                <input name="" value="请输入" onfocus="if(this.value=='请输入') {this.value='';}" onblur="if(this.value=='') {this.value='请输入';}" type="text" class="bar">
                                <button class="go"></button>
                            </div>
                        </li>
                    </ul>
                    <!-- Top Links End -->
                </div>
                <!-- Message Box Start -->
                <div class="mesage-box">
                    <h4 class="white upper"></h4>
                    <a href="#" class="buttonone backcolr"><span>今日计划</span><span class="arrow">&nbsp;</span></a>
                </div>
                <!-- Message Box End -->
            </div>
        </div>
        <!-- Container End -->
        <!-- Navigation Start -->
        <div class="navigation">
            <div id="smoothmenu1" class="ddsmoothmenu">
                <ul>
                    <li class="current-menu-item"><a href="/index">首页</a></li>
                    <li><a href="#">器材</a>
                        <ul>
                            <li><a href="#">Blog</a></li>
                            <li><a href="#">Blog Detail</a></li>
                        </ul>
                    </li>
                    <li><a href="#" target="_blank">时刻表</a></li>
                    <li><a href="#" target="_blank">班级</a>
                        <ul>
                            <li><a href="classes.html">Classes</a></li>
                            <li><a href="class-detail.html">Class Detail</a></li>
                        </ul>
                    </li>
                    <li><a href="/tips/main" target="_blank">叫你健身吧</a>
                        <ul>
                            <li><a href="#">Two Column</a></li>
                            <li><a href="#">Three Column</a></li>
                            <li><a href="#">Four Column</a></li>
                        </ul>
                    </li>
                    <li><a href="/team" target="_blank">教练团队</a>
                    </li>
                    <li><a href="#" target="_blank">新闻公告</a></li>
                    <li><a href="#" target="_blank">关于我们</a></li>
                    <li><a href="jlzp" target="_blank">教练招聘</a></li>
                </ul>
                <div class="clear"></div>
            </div>
        </div>
        <!-- Navigation End -->
        <div class="clear"></div>
    </div>
</div>
