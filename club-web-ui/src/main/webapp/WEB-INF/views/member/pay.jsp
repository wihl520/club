<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>支付页面</title>

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

			<!--订单 -->
			<div class="concent">
				<div id="payTable">
					<h3>确认支付信息</h3>
					<div class="cart-table-th">
						<div class="wp">

							<div class="th th-sum">
								<div class="td-inner">会员名</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">续费天数</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">续费金额</div>
							</div>

						</div>
					</div>
					<div class="clear"></div>
					<tr class="item-list">
						<div class="bundle  bundle-last">

							<div class="bundle-main">

								<ul class="item-content clearfix" id="cart">
									<div class="pay-phone">
										<li class="td td-sum">
											<div class="item-info">
												<div class="item-basic-info">
													<a href="#" class="item-title J_MakePoint"
														data-point="tbcart.8.11">${member.name}</a>
												</div>
											</div>
										</li>
										<li class="td td-price">
											<div class="item-price price-promo-promo">
												<div class="price-content">
													<div class="price-line">
														<em class="price-original"></em>
													</div>
													<div class="price-line">
														<em class="J_Price price-now" id="priceNow"
															tabindex="0">30/1月</em>
													</div>

												</div>
											</div>
										</li>
									</div>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<span class="phone-title">月数</span>
												<div class="sl">
													<input class="min am-btn" name="" type="button" value="-" id="jian" />
													<input class="text_box" id="count" type="text" value="1" style="width: 30px; text-align: center;" />
													<input	class="add am-btn" name="" type="button" value="+"	id="addnum" />
													<input type="hidden"  value="30" />
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											<em tabindex="0" class="J_ItemSum number"id="singlePrice">30.00</em>
										</div>
									</li>


								<%--</ul>--%>
									<%--<ul id="cart">--%>
										<%--<li>--%>
											<%--每月单价:<p class="good_price">￥&nbsp;29.99</p>--%>
											<%--<p class="num"><br>--%>
												<%--&lt;%&ndash;<input class="cutnum" name="" type="button" value="-" id="jian" />&ndash;%&gt;--%>
												<%--<span class="cutnum">-</span>--%>
												<%--<input class="nownum" type="text" value="1">--%>
												<%--<span class="addnum" >+</span><br>--%>
												<%--总额:<p class="good_total">￥&nbsp;29.99</p>--%>
											<%--</p>--%>

										<%--</li>--%>
									<%--</ul>--%>

							</div>
								<div class="clear"></div>

						</div>
					</tr>
				</div>
				<div class="clear"></div>
				
				<!--支付方式-->
				<div class="logistics">
					<h3>选择支付方式</h3>
					<ul class="pay-list">
						<li class="pay card"><img src="static/pay/images/wangyin.jpg" />银联<span
							id="银联"></span></li>
						<li class="pay qq"><img src="static/pay/images/weizhifu.jpg" />微信<span
							id="微信"></span></li>
						<li class="pay taobao"><img src="static/pay/images/zhifubao.jpg" />支付宝<span
							id="支付宝"></span></li>
					</ul>
				</div>
				<div class="clear"></div>


				<!--信息 -->
				<div class="order-go clearfix">
					<div class="pay-confirm clearfix">
						<div class="box">
							<div tabindex="0" id="holyshit267" class="realPay">
								<em class="t">实付款：</em> <span class="price g_price "> <span>¥30</span>
									<em class="style-large-bold-red " id="J_ActualFee">${sa}</em>
								</span>
							</div>

							<div id="holyshit268" class="pay-address">

								<p class="buy-footer-address">
									<span class="buy-line-title buy-line-title-type">暂时可支付方式：微信</span>
									<span class="buy--address-detail" id="send"> </span>
								</p>

							</div>
						</div>
						<form action="/paymoney" method="post" id="form">
						<div id="holyshit269" class="submitOrder">
							<div class="go-btn-wrap">
								<a  id="go" class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
							</div>

								<input type="hidden" name="memberId" value="${member.id}" id="id" />
								<input type="hidden" name="payAmount" value="30" id="express" />
								<input type="hidden" name="payWay" value="微信" id="paytype" />
								<input type="hidden" name="totalDay" value="30"  />
						</div>
						</form>
						<div class="clear"></div>
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