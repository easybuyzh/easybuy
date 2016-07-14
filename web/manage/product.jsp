<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
    <jsp:include page="index-left.jsp"/>
    <div class="main">
        <h2>商品管理</h2>
        <div class="manage">
            <div class="search">
                <form method="get" action="/ManageProduct.Servlet">
                    类别：<select name="querybyepcid">
                    <c:choose>
                        <c:when test="${nowcategoryid == null}">
                            <option value=""
                                    selected="selected">未选择</option>
                        </c:when>
                        <c:otherwise>
                            <option value="">未选择</option>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach var="procat1" items="${productcategorylist}">
                        <c:if test="${procat1.getEpcParentId() != 0}">
                            <c:if test="${procat1.getEpcId() == nowcategoryid}">
                                <option value="${procat1.getEpcId()}"
                                        selected="selected">└${procat1.getEpcName()}</option>
                            </c:if>
                            <c:if test="${procat1.getEpcId() !=nowcategoryid}">
                                <option value="${procat1.getEpcId()}">
                                    └${procat1.getEpcName()}</option>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </select>
                    商品名：<input type="text" class="text" name="querybyepname"/>
                    <label class="ui-blue">
                        <input type="submit" name="submit" value="查询"/>
                    </label>
                </form>
            </div>
            <table class="list">
                <tr>
                    <th>ID</th>
                    <th>商品名称</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="product" items="${productlist}">
                    <tr>
                        <td class="first w4 c">${product.getEpId()}</td>
                        <td class="thumb"><img width="60" height="60"
                                               src="../images/product/${product.getEpProductIcon()}"/>
                            <a href="../ProductView.Servlet?id=${product.getEpId()}" target="_blank">
                                    ${product.getEpName()}</a>
                        </td>
                        <td class="w1 c">
                            <a href="/ManageProductModify.Servlet?epid=${product.getEpId()}">修改</a>
                            <a href="/ManageProduct.Servlet?epdelete=true&epid=${product.getEpId()}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
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
