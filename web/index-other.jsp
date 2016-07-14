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
        <div class="product-list">
            <c:if test="${productlist.size() > 0}">
                <jsp:include page="page.jsp"/>
            </c:if>
            <div class="clear"></div>
            <ul class="product clearfix">
                <c:if test="${productlist.size() == 0}">
                    <%--<img width="500" height="220" src="images/product/emptycart.jpg"/></a> --%>
                    <h1>没有找到您需要的商品哦..</h1>
                </c:if>
                <c:forEach var="product" items="${productlist}">
                    <li>
                        <dl>
                            <dt><a href="/ProductView.Servlet?id=${product.getEpId()}">
                                <img src="images/product/${product.getEpProductIcon()}"/></a>
                            </dt>
                            <dd class="title"><a href="/ProductView.Servlet?id=${product.getEpId()}">${product.getEpName()}</a></dd>
                            <c:choose>
                            <c:when test="${product.getEpBargain()=='1'}">
                                <dd class="price">原价:${product.getEpPrice()} , 折扣价: ${product.getEpBaPrice()}</dd>
                            </c:when>
                            <c:otherwise>
                                <dd class="price">价格:${product.getEpPrice()}</dd>
                            </c:otherwise>
                            </c:choose>
                        </dl>
                    </li>
                </c:forEach>
            </ul>
            <div class="clear"></div>
            <c:if test="${productlist.size() > 0}">
                <jsp:include page="page.jsp"/>
            </c:if>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

