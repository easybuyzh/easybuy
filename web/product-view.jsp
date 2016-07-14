<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="position" class="wrap">
	您现在的位置：<a href="/Index.Servlet">易买网</a>
	<c:if test="${category!=null}">
		&gt; <a href="/ProductList.Servlet?id=${parentid}&category=${category}">${category}</a>
	</c:if>
	&gt;商品详情
</div>
<div id="main" class="wrap">
	<jsp:include page="index-left.jsp"/>
	<div id="product" class="main">
		<h1>${product.getEpName()}</h1>
		<div class="infos">
			<div class="thumb"><img width="250" height="250" src="images/product/${product.getEpProductIcon()}" /></div>
			<div class="buy">
				<p>商城价：<span class="price">￥${product.getEpPrice()}</span></p>
				<p>库　存：${product.getEpStock()}</p>
				<div class="button">
					<input type="button" name="button" value="" onclick="window.location.href='/Shopping.Servlet?productid=${product.getEpId()}'" />
					<a href="#">放入购物车</a>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品简介</strong></h2>
			<div class="text">
				${product.getEpDescription()}<br/>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
