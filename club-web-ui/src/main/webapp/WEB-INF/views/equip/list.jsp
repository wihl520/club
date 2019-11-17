<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>器材选择</title>
        <link rel="stylesheet" type="text/css" href="static/list/css/style.css">
    </head>
    <body>
    	<div class="banner_x center">
			<a href="index" target="_blank"><div class="logo fl"></div></a>
			
			<div class="wdgwc fl ml40">健身器材</div>
			<div class="dlzc fr">
				<ul>
					<li><a>用户：${member.name}</a></li>
					<li><a href="/membertologin">登录</a></li>
					<li>|</li>
					<li><a href="/LogoutUser">注销</a></li>	
				</ul>
				
			</div>
			<div class="clear"></div>
		<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl">
						
					</div>
					<div class="sub_top fl">器械名称</div>
					<div class="sub_top fl">使用者ID</div>
					<div class="sub_top fl">状态</div>
					<div class="sub_top fl">是否损坏</div>
					<div class="sub_top fr">操作</div>
					<div class="clear"></div>
				</div>
				<c:forEach items="${result}" var="appliance">
				<div class="content2 center">
					<div class="sub_content fl ">
						
					</div>
					<div class="sub_content fl"><img src="static/list/image/${appliance.pic}"></div>
					<div class="sub_content fl ft20">${appliance.name}</div>
					<div class="sub_content fl ">${appliance.userId}</div>
					
					<c:choose>
                        <c:when test="${appliance.state==1}">
                        	<div class="sub_content fl">使用中</div>
                        </c:when>
                        <c:otherwise>
                            <div class="sub_content fl">空闲</div>
                        </c:otherwise>
                    </c:choose>
                    
                    <c:choose>
                        <c:when test="${appliance.flag==1}">
                        	<div class="sub_content fl">良好</div>
                        </c:when>
                        <c:otherwise>
                            <div class="sub_content fl">损坏</div>
                        </c:otherwise>
                    </c:choose>
                    
                    <c:choose>
                        <c:when test="${appliance.state==1}">
							<c:choose>
								<c:when test="${member.id==appliance.userId}">
									<div class="sub_content fl"><a href="/back?id=${appliance.id}&categoryId=${appliance.parent.id}">归还</a></div>
								</c:when>
								<c:otherwise>
									<div class="sub_content fl"></div>
								</c:otherwise>
							</c:choose>
                        </c:when>
                        <c:otherwise>
                        	<div class="sub_content fl"><a href="/use?id=${appliance.id}&memberId=${member.id}&categoryId=${appliance.parent.id}">使用</a></div>
                        </c:otherwise>
                    </c:choose>

					<div class="clear"></div>
				</div>
				</c:forEach>
			</div>
		</div>
			
		</div>
 	</body>
</html>