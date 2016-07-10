<%--
  Created by IntelliJ IDEA.
  User: SDUST-132
  Date: 2016/7/4
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
    <%@include file="index-left.jsp" %>
    <div class="main">
        <div class="price-off">
            <h2>今日特价</h2>
            <ul class="product clearfix">
                <c:forEach var="product" items="${bargainlist}">
                    <li>
                        <dl>
                            <dt><a href="/ProductView.Servlet?id=${product.getEpId()}"><img
                                    src="images/product/${product.getEpProductIcon()}"/></a></dt>
                            <dd class="title"><a href="/ProductView.Servlet?id=${product.getEpId()}">${product.getEpName()}</a></dd>
                            <dd class="price">原价:${product.getEpPrice()} , 折扣价: ${product.getEpBaPrice()}</dd>
                        </dl>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <jsp:include page="index-side.jsp"/>
        <div class="spacer clear"></div>
        <div class="hot">
            <h2>热卖推荐</h2>
            <ul class="product clearfix">
                <c:forEach var="product" items="${hotlist}">
                    <li>
                        <dl>
                            <dt><a href="/ProductView.Servlet?id=${product.getEpId()}"><img
                                    src="images/product/${product.getEpcProductIcon()}"/></a></dt>
                            <dd class="title"><a href="/ProductView.Servlet?id=${product.getEpId()}" target="_blank">${product.getEpName()}</a></dd>
                            <dd class="price">￥${product.getEpPrice()} , view : ${product.getEpViewCount()}</dd>
                        </dl>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
