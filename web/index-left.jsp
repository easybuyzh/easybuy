<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaoshuai
  Date: 2016/7/7
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="lefter">
    <div class="box">
        <h2>商品分类</h2>
        <dl>
            <c:forEach var="procat1" items="${productcategorylist}">
                <c:if test="${procat1.getEpcParentId()==0}">
                    <dt>${procat1.getEpcName()}</dt>
                    <c:forEach var="procat2" items="${productcategorylist}">
                        <c:if test="${procat2.getEpcParentId()==procat1.getEpcId()}">
                            <li><a href="/ProductList.Servlet?id=${procat2.getEpcId()}&category=${procat2.getEpcName()}">${procat2.getEpcName()}</a></li>
                        </c:if>
                    </c:forEach>
                </c:if>
            </c:forEach>
        </dl>
    </div>
    <div class="spacer"></div>
    <div class="last-view">
        <h2>最近浏览</h2>
        <dl class="clearfix">
            <dt><img src="images/product/0_tiny.gif"/></dt>
            <dd><a href="product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a></dd>
            <dt><img src="images/product/0_tiny.gif"/></dt>
            <dd><a href="product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a></dd>
        </dl>
    </div>
</div>