<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaoshuai
  Date: 2016/7/7
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>易买网 - 首页</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>

<div id="header" class="wrap">
    <div id="logo"><img src="images/logo.gif"/></div>
    <div class="help">
        <c:if test="${ismanager == 'true'}">
            <a href="/manage/index.jsp">进入后台管理页面</a>
        </c:if>
        <c:if test="${userName!=null}">
            <c:if test="${ismanager == 'true'}">
                <a href="#">管理员: ${userName}</a>
            </c:if>
            <c:if test="${ismanager == null}">
                <a href="#">用户: ${userName}</a>
            </c:if>
        </c:if>
        <a href="/Shopping.Servlet" class="shopping">购物车</a>

        <c:if test="${userName==null}">
            <a href="login.jsp">登录</a>
            <a href="register.jsp">注册</a>
        </c:if>

        <c:if test="${userName!=null}">
            <a href="/Comment.Servlet">留言</a>
            <a href="/Logout.Servlet">注销</a>
        </c:if>
        <form action="/Index.Servlet" method="GET">
            商品搜索: <input type="text" name="searchcontent"/>
            <input type="submit" name="general" value="搜索" />
        </form>
    </div>
    <div class="navbar">
        <ul class="clearfix">
            <c:choose>
                <c:when test="${selected == '首页'}">
                    <li class="current"><a href="Index.Servlet">首页</a></li>
                    <li><a href="/Index.Servlet?general=true">百货</a></li>
                    <li><a href="/Index.Servlet?bargain=true">促销</a></li>
                </c:when>
                <c:when test="${selected == '百货'}">
                    <li><a href="Index.Servlet">首页</a></li>
                    <li class="current"><a href="/Index.Servlet?general=true">百货</a></li>
                    <li><a href="/Index.Servlet?bargain=true">促销</a></li>
                </c:when>
                <c:when test="${selected == '特价'}">
                    <li><a href="Index.Servlet">首页</a></li>
                    <li><a href="/Index.Servlet?general=true">百货</a></li>
                    <li class="current"><a href="/Index.Servlet?bargain=true">促销</a></li>
                </c:when>
            </c:choose>
        </ul>
    </div>
</div>
<div id="childNav">
    <div class="wrap">
        <ul class="clearfix">
            <c:forEach var="item" items="${productcategorylist}">
                <c:if test="${item.getEpcParentId()!=0}">
                    <li><a href="/ProductList.Servlet?id=${item.getEpcId()}">${item.getEpcName()}</a></li>
                </c:if>
            </c:forEach>
        </ul>
    </div>
</div>
