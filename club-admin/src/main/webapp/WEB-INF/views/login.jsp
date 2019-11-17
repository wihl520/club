<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台系统登录</title>
    <link href="/static/plugins/loginplugin/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <link href="/static/plugins/loginplugin/css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />

    <!-- iCheck -->
    <link rel="stylesheet" href="/static/plugins/adminLTE/plugins/iCheck/square/blue.css">

    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" type="text/css" href="/static/plugins/adminLTE/plugins/iCheck/all.css">

    <script type="text/javascript" src="/static/plugins/loginplugin/js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="/static/plugins/loginplugin/js/jquery.SuperSlide.js"></script>
    <%--其判断的js--%>
    <script type="text/javascript" src="/static/plugins/loginplugin/js/Validform_v5.3.2_min.js"></script>

</head>

<body>


<div class="header">
    <h1 class="headerLogo"><a title="后台管理系统" target="_blank" href="#"><img alt="logo" src="/static/plugins/loginplugin/images/Clublogo.jpg"></a></h1>
    <div class="headerNav">
        <a target="_blank" href="#">企业官网</a>
        <a target="_blank" href="#">关于我们</a>
        <a target="_blank" href="#">开发团队</a>
        <a target="_blank" href="#">意见反馈</a>
        <a target="_blank" href="#">帮助</a>
    </div>
</div>

<div class="banner">

    <div class="login-aside">
        <div id="o-box-up"></div>
        <div id="o-box-down"  style="table-layout:fixed;">
            <div class="error-box">
                ${message}
            </div>

            <form class="registerform"action="/admin/adminlogin" method="post">
                <div class="fm-item">
                    <label  class="form-label">健身后台系统登陆：</label>
                    <input name="userName" type="text" placeholder="输入账号"   <c:if test="${not empty user.userName}">value="${user.userName}"</c:if> id="username" class="i-text"  >
                    <div class="ui-form-explain"></div>
                </div>

                <div class="fm-item">
                    <label  class="form-label">登陆密码：</label>
                    <input name="password" type="password" placeholder="输入密码"   <c:if test="${not empty user.password}">value="${user.password}"</c:if>  id="password" class="i-text"  >
                    <div class="ui-form-explain"></div>
                </div>

                <div class="fm-item pos-r">
                    <label  class="form-label">验证码</label>
                    <input name="verificationcode" type="text" placeholder="输入验证码"  id="yzm" class="i-text yzm" nullmsg="请输入验证码！" >
                    <div class="ui-form-explain"> <img id="verificationcode" class="yzm-img" /></div>
                </div>

                <div class="fm-item ">
                    <label  class="form-label"></label>
                    <input type="submit"  value="" tabindex="4" id="send-btn" class="btn-login">
                    <div class="ui-form-explain"></div>
                </div>
                <%--<label class="remember" for="remember" style="color: #edeada" >--%>
                    <%--<input type="checkbox" id="remember" name="remember"  />记住我--%>
                <%--</label>--%>
                <%--<label class="remember" for="remember" style="color: #edeada" >--%>
                    <%--<input type="checkbox"  name="autologin"  id="checkautologin" onclick="checkAll()" />自动登录--%>
                <%--</label>--%>

                <div class="checkbox icheck">
                    <label>
                        <input type="checkbox" name="remember" id="remember"  ${userDto.remember==true?"checked='checked'":""}> 记住我
                    </label>
                    <label>
                        <input type="checkbox" name="autologin" id="autologin"   ${userDto.autologin==true?"checked='checked'":""} > 自动登录
                    </label>
                </div>
            </form>
        </div>
    </div>

    <div class="bd">
        <ul>
            <li style="background:url(/static/plugins/loginplugin/themes/theme-pic1.jpg)  #CCE1F3 center 0 no-repeat;"><a target="_blank" href="#"></a></li>
            <li style="background:url(/static/plugins/loginplugin/themes/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"><a target="_blank" href="#"></a></li>
        </ul>
    </div>

    <div class="hd"><ul></ul></div>
</div>
<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>


<div class="banner-shadow"></div>

<div class="footer">
    <p>Copyright &copy; 2018.Company name All rights reserved.More Templates <a href="#" target="_blank" title="健身俱乐部">健身俱乐部</a> - Collect from <a href="#" title="俱乐部首页" target="_blank">俱乐部首页</a></p>
</div>

<!-- iCheck -->
<script src="/static/plugins/adminLTE/plugins/iCheck/icheck.min.js"></script>


<script type="text/javascript">
    /*刷新验证码*/
    function refrashVCode(){
        $("#verificationcode").attr("src","/admin/kaptcha?d+"+new Date());
    }
    $(function () {
        refrashVCode();
        $("#verificationcode").click(function () {
            refrashVCode();
        });
    });
    //复选
    $(function () {
        $("#autologin").click(function () {
           $("#remember").attr("checked",true);
        });
    })

</script>
</body>
</html>

