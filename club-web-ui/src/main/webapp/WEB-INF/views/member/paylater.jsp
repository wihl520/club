<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>支付完成页面</title>

    <link href="static/pay/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"type="text/css" />
    <link href="static/pay/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="static/pay/css/cartstyle.css" rel="stylesheet" type="text/css" />
    <link href="static/pay/css/jsstyle.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="static/pay/css/layout.css" />
    <link rel="stylesheet" href="static/pay/css/style.css" />

    <script type="text/javascript" src="static/pay/js/jquery-1.8.2.js"></script>

    <script type="text/javascript">
        $(function(){
            $("ul[class='pay-list'] li").each(function(){
                $(this).click(function(){
                    $("ul[class='pay-list'] li").removeClass("selected");
                    $(this).addClass("selected");

                    var paytype = $(this).children("span").attr("id");
                    $("#paytype").val(paytype);
                })
            })

            $("#go").click(function(){
                $("#form").submit();
            })
        })

        function jian(id) {
            var count = parseInt(document.getElementById("count").value)-1;
            location.href="ShopCarServlet?action=update&count="+count+"&id="+id;
        }

        function jia(id) {
            var count = parseInt(document.getElementById("count").value)+1;
            location.href="ShopCarServlet?action=update&count="+count+"&id="+id;
        }
    </script>
</head>

<body>
<div class="concent">
    <!-- Header Start -->
    <div id="header">
        <div class="in">
            <!-- Container Start -->
            <div class="container">
                <!-- Logo Start -->
                <div class="five columns left">
                    <a href="index.html" class="logo"><img src="static/pay/images/Clublogo.jpg" alt="logo" /></a>
                </div>
                <!-- Logo End -->
            </div>
        </div>
    </div>
    <div class="paycont">
        <div class="clear"></div>


        <div class="take-delivery">
            <div class="status">
                <h2>您已成功付款</h2>
                <div class="successInfo">
                    <ul>
                        <li>付款金额<em>¥30.00</em></li>
                        <div class="user-info">
                            <p>收货人：梦的俱乐部</p>
                            <p>联系电话：188775441111</p>
                            <p>收货地址：广东省 广州市 天河区 **号</p>
                        </div>
                        请认真核对您的收货信息，如有错误请联系客服

                    </ul>
                    <div class="option">
                        <span class="info">您可以</span>
                        <a href="#" class="J_MakePoint"><span>已成功续期</span></a>
                    </div>
                </div>
            </div>
        </div>

        <div class="clear"></div>
    </div>
</div>
<!-- Footer Start -->
<jsp:include page="/WEB-INF/views/member/include/footer.jsp"></jsp:include>
<!-- Footer End -->
<script src="/static/js/cart.js" type="text/javascript" charset="utf-8"></script>
<script src="/static/js/jquery-1.10.1.min.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>