<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>会员登录</title>
    <link rel="stylesheet" type="text/css" href="/static/login/css/login.css">
    <script src="/static/login/js/jquery-1.11.3.min.js" ></script>
</head>
<body>
<!-- login -->
<div class="top center">
    <div class="logo center">
        <a href="/index" target="_blank"><img src="/static/login/image/Clublogo.jpg" alt="logo图片"></a>
    </div>
</div>
<form  method="post" action="/realLogin" class="form center">
    <div class="login">
        <div class="login_center">
            <div class="login_top">
                <div class="left fl">会员登录</div>
                <div class="right fr">您还不是我们的会员？<a href="/membertoregist" target="_self">立即注册</a></div>
                <div class="clear"></div>
                <div class="xian center"></div>
            </div>
            <div class="login_main center">
                <div class="error-box">
                    ${message}
                </div>
                <div class="username">用户名:&nbsp;
                    <input class="shurukuang" type="text" name="name" placeholder="请输入你的用户名"/></div>
                <div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;
                    <input class="shurukuang" type="password" name="password" placeholder="请输入你的密码"/></div>
                <div class="username">
                    <div class="left fl">验证码:&nbsp;
                        <input class="yanzhengma" type="text" name="verificationcode" placeholder="请输入验证码"/></div>
                    <div class="right fl">
                        <img id="verificationcode"></div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="login_submit">
                <input class="submit" type="submit" name="submit" value="立即登录" >
            </div>

            <div class="checkbox icheck" style="text-align: center">
                <label>
                    <input type="checkbox" name="remember" id="remember"  ${userDto.remember==true?"checked='checked'":""}> 记住我
                </label>
                <label>
                    <input type="checkbox" name="autologin" id="autologin"   ${userDto.autologin==true?"checked='checked'":""} > 自动登录
                </label>

            </div>

        </div>
    </div>
</form>
<footer>
    <div class="copyright">广州 | 千峰 | JavaEE | 常见问题</div>
    <div class="copyright">健身CLUB版权所有-广ICP备10046666-<img src="/static/login/image/ghs.png" alt="">广公网安备11010803030154号-广ICP证110618号</div>
</footer>
<script type="text/javascript">
    function refrashVCode(){
        $("#verificationcode").attr("src","/kaptcha?d+"+new Date());
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
