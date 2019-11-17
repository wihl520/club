<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>教练信息</title>
        <!-- Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="keywords" content="Multi Tabs Resume Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!-- //Meta-Tags -->
		<!-- Custom-Style-Sheet -->
		<link rel="stylesheet" href="static/coachInfo/css/style.css" type="text/css" media="all">
		<!-- //Custom-Style-Sheet -->
		
		<!-- Fonts -->
		<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" type="text/css" media="all">
		<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Montserrat:400,700"			   type="text/css" media="all">
		<!-- //Fonts -->
		
		<!-- Default-JavaScript --><script type="text/javascript" src="static/coachInfo/js/jquery.min.js"></script>
    </head>
    <body>
	<a href="index.html" class="logo">

    	<h1><img src="static/images/Clublogo.jpg" alt="Clublogo" /></a>健身俱乐部 教练</h1>

		<div class="containerw3layouts-agileits">

			<div id="verticalTab" class="resp-vtabs w3-agile" style="display: block; width: 100%; margin: 0px;">

				<ul class="resp-tabs-list agileits-w3layouts">
					<li class="resp-tab-item"><span>教练信息</span></li>
					<li class="resp-tab-item"><span>旗下学员</span></li>
				</ul>

				<div class="resp-tabs-container">

					<div class="resp-tab-content">
						<div class="agileabout">
							<div class="agileabout-image w3-agileits">
								<img src="static/coachInfo/images/man.jpg" alt="W3layouts">
							</div>
							<div class="agileabout-info">
								<ul>
									<li><div class="li1">姓名</div><div class="li2">:</div><div class="li3">${Coach.name}</div><div class="clearfix"></div></li>
									<c:choose>
										<c:when test="${Coach.sex == 1}">
											<li><div class="li1">性别</div><div class="li2">:</div><div class="li3">男</div><div class="clearfix w3-agileits"></div></li>
										</c:when>
										<c:otherwise>
											<li><div class="li1">性别</div><div class="li2">:</div><div class="li3">女</div><div class="clearfix w3-agileits"></div></li>
										</c:otherwise>
									</c:choose>
									<li><div class="li1">年龄</div><div class="li2">:</div><div class="li3">${Coach.age}</div><div class="clearfix"></div></li>
									<li><div class="li1">籍贯</div><div class="li2 ">:</div><div class="li3">${Coach.address}</div><div class="clearfix"></div></li>
									<li><div class="li1">电话号码</div><div class="li2 ">:</div><div class="li3">${Coach.phone}</div><div class="clearfix"></div></li>
									<li><div class="li1 agileinfo">电子邮箱</div><div class="li2 ">:</div><div class="li3">${Coach.email}</div><div class="clearfix"></div></li>
									<c:choose>
										<c:when test="${member == null}">
											<li><div class="li3"><input type="button"  onclick="plogin()" style="font-size: 18px;border: solid #05c2f9 1px;" value="预约"></input></div><div class="clearfix"></div></li>
										</c:when>
										<c:otherwise>
											<li><div class="li3"><input type="button"  onclick="reqest()" style="font-size: 18px;border: solid #05c2f9 1px;" value="预约"></input></div><div class="clearfix"></div></li>
										</c:otherwise>
									</c:choose>
								</ul>
							</div>
							<div class="clear"></div>
						</div>
					</div>

					<div class="resp-tab-content">
						<div class="work">
							<div class="work-info agileits-w3layouts">
								<c:forEach items="${Stu}" var="stu">
								<p>${stu.name}</p>
								<p>&nbsp; &nbsp; &nbsp; </p>
								</c:forEach>
							</div>
						</div>
					</div>

					<div class="clear"></div>

				</div>
				<div class="clear w3-agile"></div>

			</div>

		</div>

		<div class="w3lsfooteragileits">
			<p> &copy; 2017 Multi Tabs Resume. All Rights Reserved | Design by <a href="http://w3layouts.com" target="=_blank">W3layouts</a></p>
		</div>



		<!-- Necessary-JavaScript-Files-&-Links -->

			<!-- Tabs-JavaScript -->
				<script src="static/coachInfo/js/easyResponsiveTabs.js"></script>
				<script type="text/javascript">
					$(document).ready(function () {
						$('#horizontalTab').easyResponsiveTabs({
							type: 'default',
							width: 'auto',
							fit: true,
							closed: 'accordion',
							activate: function(event) {
								var $tab = $(this);
								var $info = $('#tabInfo');
								var $name = $('span', $info);
								$name.text($tab.text());
								$info.show();
							}
						});
						$('#verticalTab').easyResponsiveTabs({
							type: 'vertical',
							width: 'auto',
							fit: true
						});
					});
                    function plogin(){
                        alert("请先登录！");
                        window.location = "/membertologin";
                    }
				</script>
			<!-- //Tabs-JavaScript -->


		<!-- //Necessary-JavaScript-Files-&-Links -->
 	</body>
</html>