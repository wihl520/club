<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="/static/login/css/login.css">
    <script src="/static/login/js/jquery-1.11.3.min.js" ></script>
</head>
<body >
<div background="/static/login/image/21636799_021137490000_2.jpg" >
<form  method="post" action="regist">
    <div class="regist" >
        <div class="regist_center" >
            <div class="regist_top">
                <div class="left fl">会员注册 </div>
                <div class="right fr"><a href="/index" target="_self"><img src="static/images/Clublogo.jpg" alt="Clublogo" />健身俱乐部</a></div>
                <div class="clear"></div>
                <div class="xian center"></div>
            </div>
            <div class="regist_main center">
                <div class="error-box" style="color: red;font-family: 华文楷体">
                    ${userDto.message}
                </div>

                <div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;
                    <input class="shurukuang" type="text" id="name" value="${member.name}" name="name" placeholder="请输入你的用户名"/>
                    <span>请不要输入汉字</span></div>
                <div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;
                    <input class="shurukuang" type="password" id="password" value="${member.password}"   name="password" placeholder="请输入你的密码"/>
                    <span>请输入6位以上字符</span></div>

                <div class="username">确认密码:&nbsp;&nbsp;
                    <input class="shurukuang" type="password" id="repassword" value="${member.password}" name="repassword" placeholder="请确认你的密码"/>
                    <span>两次密码要输入一致哦</span></div>
                <div class="username">电子&nbsp;&nbsp;邮箱&nbsp;&nbsp;
                    <input class="shurukuang" type="text" name="email" value="${member.email}"  id="email" placeholder="请填写电子邮箱"/>
                    <span>填写下电子邮箱！！！</span></div>
                <div class="username">
                    <div class="left fl">验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;
                        <input class="yanzhengma" type="text" name="verificationcode" id="newcode" placeholder="验证码"/></div>
                    <div class="right fl">
                              <img id="verificationcode"></div>
                    <div class="clear"></div>
                </div>
                <div class="username">
                    <div class="left fl">电&nbsp;子&nbsp;邮&nbsp;箱&nbsp;验&nbsp;证&nbsp;码:&nbsp;
                        <input class="yanzhengma" type="text" name="emailcode"  placeholder="电子邮箱验证码"/>
                        <input type="button" value="获取邮箱验证" id="getemailcode"  />
                    </div>
                    <div class="right fl"> <img id="emailcode"></div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="regist_submit">
                <input class="submit" type="submit" name="submit" value="立即注册" >
            </div>

        </div>
    </div>
</form>
</div>
<footer>
    <div class="copyright">广州 | 千峰 | JavaEE | 常见问题</div>
    <div class="copyright">健身CLUB版权所有-广ICP备10046666-<img src="/static/login/image/ghs.png" alt="">广公网安备11010803030154号-广ICP证110618号</div>
</footer>
<script type="text/javascript">
    function refrashVCode(){
        //验证码
        $("#verificationcode").attr("src","/kaptcha?d+"+new Date());
    }
    $(function () {
        refrashVCode();
        $("#verificationcode").click(function () {
            refrashVCode();
        });
    });
    $(function () {
        $("#getemailcode").click(function () {
            var name =   $("#name").val();
            var email =   $("#email").val();
            var password =   $("#password").val();
            var repassword =   $("#repassword").val();
           var newcode =   $("#newcode").val();
//                alert(name+"----"+email+"----"+newcode+password+"----"+repassword);
           window.location.href ="/getemailcode?newcode="+newcode+"&email="+email+"&name="+name+"&password="+password+"&repassword="+repassword;
        });
    });


</script>
</body>
</html>
