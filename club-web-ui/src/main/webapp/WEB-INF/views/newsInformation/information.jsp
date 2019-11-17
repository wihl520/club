<%--
  Created by IntelliJ IDEA.
  User: 耿钊
  Date: 2018/10/31
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zxx">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta content="" name="description">
    <meta content="" name="keywords">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="HandheldFriendly" content="true">
    <meta content="telephone=no" name="format-detection">

    <!--[if (gt IE 9)|!(IE)]><!-->
    <!-- custom CSS -->
    <link href="/static/news/css/main.css" rel="stylesheet" type="text/css" />
    <!-- END custom CSS -->
    <!--<![endif]-->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <title>新闻详情</title>
</head>
<body style="background-color: lavender">
<!-- Header -->
<!-- header slider -->
<div class="wrapper">
    <article class="container articles">
        <div class="row">

            <div class="col-sm-12 col-md-9 article_text">
                <div class="current">
                    <h1 class="text-center yel_line current__title">${newsPushList.newsTitle}</h1>
                    <img src="/static/news/img/content/article2.jpg" alt="img" class="current__img">
                    <blockquote class="quote current__quote">${newsPushList.newsContent}</blockquote>
                </div>
            </div>

            <div class="col-sm-9 col-md-8 col-lg-6 comments">
                <p class="comments__title">评论</p>
                <c:forEach items="${commentList}" var="info">
                <div class="comments__media">
                    <div class="media-middle">
                        <i class="media-object" style="background-image: url('/static/news/img/content/comment.png')"></i>
                        <div class="comm_info">
                            <h4 class="media-heading">${info.name}</h4>
                        </div>
                    </div>
                    <p class="media-body">${info.commentContent}</p>
                </div>
                </c:forEach>
                <div class="comments__form">
                    <form action="#" method="POST">

                        <div class="form-group">
                            <textarea name="text" id="input" class="form-control" rows="7" required="required"></textarea>
                        </div>
                        <button type="submit" class="btn btn-comment">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </article>
</div>
<!-- Footer -->
<footer class="footer slate_gray">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <p>&copy; Copyright &copy; 2013.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a> - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a></p>
            </div>
        </div>
    </div>
</footer>
<!-- END Footer -->
<!-- All JavaScript libraries -->
<script src="/static/news/js/jquery.min.js"></script>
<script src="/static/news/js/bootstrap.min.js"></script>
<!-- Custom JavaScript -->
<script src="/static/news/js/main.js"></script>
</body>
</html>


