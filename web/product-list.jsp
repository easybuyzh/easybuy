<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="header.jsp"/>
<div id="position" class="wrap">
    您现在的位置：<a href="/Index.Servlet">易买网</a> &gt; ${category}
</div>
<div id="main" class="wrap">
    <jsp:include page="index-left.jsp"/>
    <div class="main">
        <div class="product-list">
            <jsp:include page="page.jsp"/>
            <div class="clear"></div>
            <ul class="product clearfix">
                <c:forEach var="product" items="${productlist}">
                    <li>
                        <dl>
                            <dt>
                                <a href="/ProductView.Servlet?id=${product.getEpId()}&category=${category}&parentid=${parentid}"><img
                                        src="images/product/${product.getEpcProductIcon()}"/></a></dt>
                            <dd class="title">
                                <a href="/ProductView.Servlet?id=${product.getEpId()}&category=${category}&parentid=${parentid}"
                                >${product.getEpName()}</a></dd>
                            <dd class="price">${product.getEpPrice()}</dd>
                        </dl>
                    </li>
                </c:forEach>
            </ul>
            <div class="clear"></div>
            <jsp:include page="page.jsp"/>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
