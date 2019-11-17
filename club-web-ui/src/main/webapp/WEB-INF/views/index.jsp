<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
		<meta charset="utf-8" />
		<title>俱乐部管理系统</title>
		<meta name="description" content="" />
		<meta name="author" content="" />
		<!--// Mobile Metas //-->
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
		<!--// Stylesheets //-->
		<link rel="stylesheet" href="static/css/base.css" />
		<link rel="stylesheet" href="static/css/skeleton.css" />
		<link rel="stylesheet" href="static/css/layout.css" />
		<link rel="stylesheet" href="static/css/style.css" />
		
		<link rel="stylesheet" type="text/css" href="css/color.css" title="styles7" media="screen" />
		<link rel="alternate stylesheet" type="text/css" href="static/css/red.css" title="styles1" media="screen" />
		<link rel="alternate stylesheet" type="text/css" href="static/css/blue.css" title="styles2" media="screen" />
		<link rel="alternate stylesheet" type="text/css" href="static/css/gray.css" title="styles3" media="screen" />
		<link rel="alternate stylesheet" type="text/css" href="static/css/orange.css" title="styles4" media="screen" />
		<link rel="alternate stylesheet" type="text/css" href="static/css/green.css" title="styles5" media="screen" />
		<link rel="alternate stylesheet" type="text/css" href="static/css/orange-red.css" title="styles6" media="screen" />
		<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<!--// Favicons //-->
		<link rel="shortcut icon" href="static/images/favicon.ico" />
		<link rel="rockit-touch-icon" href="static/images/touch-icon.png" alt="" />
		<link rel="rockit-touch-icon" sizes="72x72" href="static/images/touch-icon-72x72.png" alt="" />
		<link rel="rockit-touch-icon" sizes="114x114" href="static/images/touch-icon-114x114.png" alt="" />
		<!--// Javascript //-->
		<script type="text/javascript" src="static/js/jquery.min.js"></script>
		<script type="text/javascript" src="static/js/styleswitch.js"></script>
		<script type="text/javascript" src="static/js/animatedcollapse.js"></script>
		<script type="text/javascript" src="static/js/jquery.infinite-carousel.js"></script>
		<script type="text/javascript" src="static/js/ddsmoothmenu.js"></script>
		<script type="text/javascript" src="static/js/jquery.nivo.slider.js"></script>
		<script type="text/javascript" src="static/js/scrolltopcontrol.js"></script>
		<script type="text/javascript" src="static/js/tabs.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
	<body>

		<!-- Outer Wrapper Start -->
		<div id="outer-wrapper">
			<!-- Header Start -->
		    <div id="header">
		    	<span class="top-bar">&nbsp;</span>
		    	<div class="in">
		            <!-- Container Start -->
		            <div class="container">
		                <!-- Logo Start -->
		                <div class="five columns left">
		                    <a href="index.html" class="logo"><img src="static/images/Clublogo.jpg" alt="Clublogo" /></a>
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


		                            <li><a href="/membertopersonalcenter">我的信息</a></li>
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
		                        <li><a href="#">时刻表</a></li>
		                        <li><a href="#">班级</a>
		                        	<ul>
		                                <li><a href="classes.html">Classes</a></li>
		                                <li><a href="class-detail.html">Class Detail</a></li>
		                            </ul>
		                        </li>
		                        <li><a href="/tips/main">叫你健身吧</a>
		                        	<ul>
		                                <li><a href="gallery-two-column.html">Two Column</a></li>
		                                <li><a href="gallery-three-column.html">Three Column</a></li>
		                                <li><a href="gallery-four-column.html">Four Column</a></li>
		                            </ul>
		                        </li>
		                        <li><a href="/team">教练团队</a>
		                        	<ul>
		                                <li><a href="#">子目录一</a></li>
		                                <li><a href="#">子目录二</a></li>
		                            </ul>
		                        </li>
		                        <li><a href="#">新闻公告</a></li>
		                        <li><a href="#">关于我们</a></li>
		                        <li><a href="/jlzp">教练招聘</a></li>
		                    </ul>
		                    <div class="clear"></div>
		                </div>
		            </div>
		            <!-- Navigation End -->
		            <div class="clear"></div>
		        </div>
		    </div>
		    <!-- Header End -->
		    <div class="clear"></div>
		    <div class="inner">
		        <div class="inner shadow">
		        	<!-- Banner Start -->
		            <div id="banner" class="row">
		                <div class="slider-wrapper theme-default">
		                    <div id="slider" class="nivoSlider">
		                        <a href="#"><img src="static/images/yaling.jpg" title="#banner1" alt="哑铃" /></a>
		                        <a href="#"><img src="static/images/xinxingpaobuji.jpg" title="#banner2" alt="新型跑步机" /></a>
		                        <a href="#"><img src="static/images/quanji.jpg" title="#banner3" alt="拳击" /></a>
		                    </div>
		                    <!-- Banner Caption Start -->
		                    <div id="banner1" class="nivo-html-caption">
		                        <h1 class="title backcolr">哑铃</h1>
		                        <div class="clear"></div>
		                        <div class="banner-text">
		                        	<p>
		                            	增强肌肉力量训练的简单器材。<br />
		                            	轻哑铃的重量有6、8、12、16磅（1磅=0.4536千克）等。<br/>
		                            	重哑铃的重量有10、15、30千克等。
		                            </p>
		                        </div>
		                    </div>
		    				<!-- Banner Caption End -->
		                    <!-- Banner Caption Start -->
		                    <div id="banner2" class="nivo-html-caption">
		                        <h1 class="title backcolr">新型跑步机</h1>
		                        <div class="clear"></div>
		                        <div class="banner-text">
		                        	<p>
		                            	新进新型跑步机，新的跑步训练.
		                            </p>
		                        </div>
		                    </div>
		                    <!-- Banner Caption End -->
		                    <!-- Banner Caption Start -->
		                    <div id="banner3" class="nivo-html-caption">
		                        <h1 class="title backcolr">拳击</h1>
		                        <div class="clear"></div>
		                        <div class="banner-text">
		                        	<p>
		                            	拳击（英文：boxing;pugilism，法文：Boxe）是戴拳击手套进行格斗的运动项目。<br/>
		                            	现已开放拳击健身，更有专业指导。
		                            </p>
		                        </div>
		                    </div>
		                    <!-- Banner Caption End -->
		                </div>
		            </div>
		            <!-- Banner End -->
		            <div class="clear"></div>
		            <!-- Container Start -->
		            <div class="container row">
		            	<!-- Event Counter Start -->
		            	<div class="one-third column small-banners">
		                	<a href="#" class="thumb"><img src="static/images/img1.jpg" alt="" /></a>
		                    <div class="sub-capt">
		                        <h1><a href="#">篮球&nbsp; <br />&nbsp;激情澎湃&nbsp;</a></h1>
		                        <p>
		                            	篮球，英文（basketball），起源于美国马萨诸塞州，是1891年12月21日由詹姆斯·奈史密斯创造，是奥运会核心比赛项目，是以手为中心的身体对抗性体育运动   。
		                        </p>
		                    </div>
		                </div>
		                <!-- Event Counter End -->
		                <!-- Just Arrived Start -->
		                <div class="one-third column small-banners">
		                	<a href="#" class="thumb"><img src="static/images/zuqiu.jpg" alt="" /></a>
		                    <div class="sub-capt">
		                        <h1><a href="#">足球&nbsp;<br />&nbsp;活力四射</a></h1>
		                        <p>
		                            	足球（football）， 有“世界第一运动”的美誉，是全球体育界最具影响力的单项体育运动。标准的足球比赛由两队各派10名球员与1名守门员，总共22人，在长方形的草地球场上对抗、防守、进攻。
		                        </p>
		                    </div>
		                </div>
		                <!-- Just Arrived End -->
		                <!-- Twitter Start -->
		                <div class="one-third column small-banners">
		                	<a href="#" class="thumb"><img src="static/images/wushu.jpg" alt="" /></a>
		                    <div class="sub-capt">
		                        <h1><a href="#">武术&nbsp;<br />&nbsp;中国功夫</a></h1>
		                        <p>
		                            	武术是古代军事战争一种传承的技术。习武可以强身健体，亦可以防御敌人进攻。习武之人以“制止侵袭”为技术导向、引领修习者进入认识人与自然、社会客观规律的传统教化（武化）方式，是人类物质文明的导向和保障。
		                        </p>
		                    </div>
		                </div>
		                <!-- Twitter End -->
		            </div>
		            <!-- Banners End -->
		            <div class="container row">
		            	<!-- Two Third Column Start -->
		            	<div class="two-thirds column left">
		                	<!-- Tabs Section Start -->
		                    <div class="tab-section">
		                    	<div class="tab-head">
		                            <div class="tab_menu_container">
		                                <ul id="tab_menu">  
		                                    <li><a class="" rel="tab-news">新闻</a></li>
		                                    <li><a class="" rel="tab-blogs">公告</a></li>
		                                </ul>
		                                <div class="clear"></div>
		                            </div>
		                        </div>
								<div class="tab_container">
									<div class="tab_container_in">
										<!-- Gym News Start -->
										<div id="tab-news" class="tab-list">
											<c:forEach items="${listPush}" var="container">
												<ul class="news-list">
													<li class="active nopad-top">
														<div class="thumb">
															<a href="#"><img src="images/img4.jpg" alt="" /></a>
														</div>
														<h3><a href="/newsInformation/information?id=${container.id}" class="colr">${container.newsTitle}</a></h3>
														<p>
																${container.newsContent}
														</p>

													</li>
												</ul>
											</c:forEach>
										</div>
										<div class="clear"></div>
									</div>
								</div>
		                    </div>
		                    <!-- Tabs Section End -->
		                </div>
		                <!-- Two Third Column End -->
		                	<!-- One Third Column Start -->
			                <div class="one-third column left">
			                	<div class="box-small">
			                    	<h2 class="heading">下一步</h2>
			                        <!-- Upcoming Classes Start -->
			                        <div class="upcoming-classes">
		                            <div class="thumb">
		                            	<a href="#"><img src="static/images/img5.jpg" alt="" /></a>
		                                <span>俱乐部计划</span>
		                            </div>
		                            <ul class="classes">
		                            	<li>
		                                	<span class="clock">&nbsp;</span>
		                                    <h4><a href="#">运动一</a></h4>
		                                    <p>09:00 - 13:00</p>
		                                </li>
		                                <li>
		                                	<span class="clock">&nbsp;</span>
		                                    <h4><a href="#">运动二</a></h4>
		                                    <p>09:00 - 13:00</p>
		                                </li>
		                                <li>
		                                	<span class="clock">&nbsp;</span>
		                                    <h4><a href="#">运动三</a></h4>
		                                    <p>09:00 - 13:00</p>
		                                </li>
		                                <li>
		                                	<span class="clock">&nbsp;</span>
		                                    <h4><a href="#">运动四</a></h4>
		                                    <p>09:00 - 13:00</p>
		                                </li>
		                                <li>
		                                	<span class="cal">&nbsp;</span>
		                                    <h4><a href="#">详细</a></h4>
		                                </li>
		                            </ul>
		                        </div>
		                        <!-- Upcoming Classes End -->
		                        <div class="clear"></div>
		                    </div>
		                </div>
		                <!-- One Third Column End -->
		            </div>
		            <div class="clear"></div>
					<div class="container row hidemobile">
		            	<div class="sixteen columns">
		                	<!-- Fitness Classes Start -->
		                	<div class="prod-sec">
		                    	<div class="prod-head">
		                        	<h2>健身器材</h2>
		                            <div class="prod-controls">
		                            	<a id="classPrevious">&nbsp;</a>
		                                <a id="classNext">&nbsp;</a>
		                            </div>
		                            <div class="clear"></div>
		                        </div>
		                        <div id="classes-list">
									<ul>
										<c:forEach items="${appcatList}" var="appcats">
											<li>
												<div class="thumb">
													<a href="/equipment?id=${appcats.cattegoryId}"><img src="static/index/images/${appcats.pic}" alt="" /></a>
													<span>${appcats.name}</span>
												</div>
												<h2><a href="#">${appcats.describe}</a></h2>
												<p>${appcats.mode}</p>
											</li>
										</c:forEach>
									</ul>
		                        </div>
		                    </div>
		                    <!-- Fitness Classes End -->
		                </div>
		            </div>
		            <div class="clear"></div>
		            <!-- Footer Widgets Section Start -->
		            <div id="footer-widgets" class="container hidemobile">
		            	<!-- Widget Container Start -->
		            	<div class="one-third column">
		                	<!-- Contact Info Start -->
		                	<div class="widget contact-info">
		                    	<h2 class="widget-head">Contact Info</h2>
		                        <p class="nopad-top">1234 12th St. loiuce Street NW3rd Floor St No 1 Newyork NY 12345</p>
		                        <p class="bold">
		                        	Call Now : (900) 1-234-567-8910<br />
									Email: info@yourcompany.com<br />
		                        </p>
		                        <p class="timing colr bold">
		                        	Daily Timing: 06:00 to 21:00<br />
									Sunday: 09:00 to 18:00<br />
		                        </p>
		                    </div>
		                    <!-- Contact Info End -->
		                    <!-- Follow Us Start -->
		                    <div class="widget followus">
		                    	<ul>
		                        	<li><p>Follow Us</p></li>
		                        	<li><a href="#"><img src="static/images/share-facebook.png" alt="" /></a></li>
		                            <li><a href="#"><img src="static/images/share-twitter.png" alt="" /></a></li>
		                            <li><a href="#"><img src="static/images/share-vimeo.png" alt="" /></a></li>
		                            <li><a href="#"><img src="static/images/share-linkedin.png" alt="" /></a></li>
		                            <li><a href="#"><img src="static/images/share-youtube.png" alt="" /></a></li>
		                        </ul>
		                    </div>
		                    <!-- Follow Us End -->
		                </div>
		                <!-- Widget Container End -->
		                <!-- Widget Container Start -->
		                <div class="one-third column">
		                	<!-- Twitter Start -->
		                	<div class="widget twitter">
		                    	<h2 class="widget-head">Gym Tweets</h2>
		                        <ul>
		                        	<li>
		                            	<a href="#" class="colr">@tamasgergocs</a> Thanks for posting the photo Tamás! Let us know what you think about the book's content! #smbook <span>About a Minute Ago</span>
		                            </li>
		                            <li>
		                            	<a href="#" class="colr">@tamasgergocs</a> Thanks for posting the photo Tamás! Let us know what you think about the book's content! #smbook <span>About a Minute Ago</span>
		                            </li>
		                        </ul>
		                        <a href="#" class="follow">Follow Us On Twitter</a>
		                    </div>
		                    <!-- Twitter End -->
		                </div>
		                <!-- Widget Container End -->
		                <!-- Widget Container Start -->
		                <div class="one-third column">
		                	<!-- Text Widget Start -->
		                	<div class="widget text-widget">
		                    	<h2 class="widget-head">Membership Promotions</h2>
		                        <h1 class="colr">GET 25% DiSCount</h1>
		                        <p>
		                        	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla tincidunt fringilla suscipit. Praesent dapibus risus mauris. Cras libero nunc, vestibulum eu rutrum sagittis, dapibus non justo. Praesent dapibus risus mauris. Cras libero nunc
		                        </p>
		                        <a href="#" class="buttontwo">MEMBERSHIP PLANS</a>
		                    </div>
		                    <!-- Text Widget End -->
		                </div>
		                <!-- Widget Container End -->
		                <div class="clear"></div>
		            </div>
		            <!-- Footer Widgets Section End -->
		        </div>
		        <div class="clear"></div>
		    </div>
		</div>
		<!-- Outer Wrapper End -->
		<!-- Footer Start -->
		<div style="text-align: center">
			<jsp:include page="includes/copyRight.jsp" ></jsp:include>
		</div>

		<!-- Footer End -->
	
	</body>
</html>