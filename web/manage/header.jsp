<%@ page import="sdkd.com.ec.util.Utils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaoshuai
  Date: 2016/7/9
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>后台管理 - 易买网</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css"/>
    <script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="../images/logo.gif"/></div>
    <div class="help"><a href="/Index.Servlet ">返回前台页面</a></div>
    <div class="navbar">
        <ul class="clearfix">
            <c:choose>
                <c:when test="${selected == '公告'}">
                    <li><a href="/manage/index.jsp">首页</a></li>
                    <li><a href="/ManageUser.Servlet">用户</a></li>
                    <li><a href="/ManageProductClass.Servlet">分类</a></li>
                    <li><a href="/ManageProduct.Servlet">商品</a></li>
                    <li><a href="/ManageOrder.Servlet">订单</a></li>
                    <li><a href="/ManageGuestBook.Servlet">留言</a></li>
                    <li><a href="/ManageNews.Servlet">新闻</a></li>
                    <li class="current"><a href="/ManageNotice.Servlet">公告</a></li>
                </c:when>
                <c:when test="${selected == '用户'}">
                    <li><a href="/manage/index.jsp">首页</a></li>
                    <li class="current"><a href="/ManageUser.Servlet">用户</a></li>
                    <li><a href="/ManageProductClass.Servlet">分类</a></li>
                    <li><a href="/ManageProduct.Servlet">商品</a></li>
                    <li><a href="/ManageOrder.Servlet">订单</a></li>
                    <li><a href="/ManageGuestBook.Servlet">留言</a></li>
                    <li><a href="/ManageNews.Servlet">新闻</a></li>
                    <li><a href="/ManageNotice.Servlet">公告</a></li>
                </c:when>
                <c:when test="${selected == '分类'}">
                    <li><a href="/manage/index.jsp">首页</a></li>
                    <li><a href="/ManageUser.Servlet">用户</a></li>
                    <li class="current"><a href="/ManageProductClass.Servlet">分类</a></li>
                    <li><a href="/ManageProduct.Servlet">商品</a></li>
                    <li><a href="/ManageOrder.Servlet">订单</a></li>
                    <li><a href="/ManageGuestBook.Servlet">留言</a></li>
                    <li><a href="/ManageNews.Servlet">新闻</a></li>
                    <li><a href="/ManageNotice.Servlet">公告</a></li>
                </c:when>
                <c:when test="${selected == '商品'}">
                    <li><a href="/manage/index.jsp">首页</a></li>
                    <li><a href="/ManageUser.Servlet">用户</a></li>
                    <li><a href="/ManageProductClass.Servlet">分类</a></li>
                    <li class="current"><a href="/ManageProduct.Servlet">商品</a></li>
                    <li><a href="/ManageOrder.Servlet">订单</a></li>
                    <li><a href="/ManageGuestBook.Servlet">留言</a></li>
                    <li><a href="/ManageNews.Servlet">新闻</a></li>
                    <li><a href="/ManageNotice.Servlet">公告</a></li>
                </c:when>
                <c:when test="${selected == '订单'}">
                    <li><a href="/manage/index.jsp">首页</a></li>
                    <li><a href="/ManageUser.Servlet">用户</a></li>
                    <li><a href="/ManageProductClass.Servlet">分类</a></li>
                    <li><a href="/ManageProduct.Servlet">商品</a></li>
                    <li class="current"><a href="/ManageOrder.Servlet">订单</a></li>
                    <li><a href="/ManageGuestBook.Servlet">留言</a></li>
                    <li><a href="/ManageNews.Servlet">新闻</a></li>
                    <li><a href="/ManageNotice.Servlet">公告</a></li>
                </c:when>
                <c:when test="${selected == '留言'}">
                    <li><a href="/manage/index.jsp">首页</a></li>
                    <li><a href="/ManageUser.Servlet">用户</a></li>
                    <li><a href="/ManageProductClass.Servlet">分类</a></li>
                    <li><a href="/ManageProduct.Servlet">商品</a></li>
                    <li><a href="/ManageOrder.Servlet">订单</a></li>
                    <li class="current"><a href="/ManageGuestBook.Servlet">留言</a></li>
                    <li><a href="/ManageNews.Servlet">新闻</a></li>
                    <li><a href="/ManageNotice.Servlet">公告</a></li>
                </c:when>
                <c:when test="${selected == '新闻'}">
                    <li><a href="/manage/index.jsp">首页</a></li>
                    <li><a href="/ManageUser.Servlet">用户</a></li>
                    <li><a href="/ManageProductClass.Servlet">分类</a></li>
                    <li><a href="/ManageProduct.Servlet">商品</a></li>
                    <li><a href="/ManageOrder.Servlet">订单</a></li>
                    <li><a href="/ManageGuestBook.Servlet">留言</a></li>
                    <li class="current"><a href="/ManageNews.Servlet">新闻</a></li>
                    <li><a href="/ManageNotice.Servlet">公告</a></li>
                </c:when>
                <c:otherwise>
                    <li class="current"><a href="/manage/index.jsp">首页</a></li>
                    <li><a href="/ManageUser.Servlet">用户</a></li>
                    <li><a href="/ManageProductClass.Servlet">分类</a></li>
                    <li><a href="/ManageProduct.Servlet">商品</a></li>
                    <li><a href="/ManageOrder.Servlet">订单</a></li>
                    <li><a href="/ManageGuestBook.Servlet">留言</a></li>
                    <li><a href="/ManageNews.Servlet">新闻</a></li>
                    <li><a href="/ManageNotice.Servlet">公告</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>
<div id="childNav">
    <div class="welcome wrap">
        管理员${sessionScope.userName}您好，现在时间<%=Utils.getNowTimeInMysqlFormat()%>，欢迎回到管理后台。
    </div>
</div>
<div id="position" class="wrap">
    您现在的位置：<a href="/Index.Servlet">易买网</a> &gt; 管理后台
</div>
