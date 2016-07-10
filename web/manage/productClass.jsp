<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
    <jsp:include page="index-left.jsp"/>
    <div class="main">
        <h2>分类管理</h2>
        <div class="manage">
            <table class="list">
                <tr>
                    <th>ID</th>
                    <th>分类名称</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="procat1" items="${productcategorylist}">
                    <c:if test="${procat1.getEpcParentId() == '0'}">
                        <tr>
                            <td class="first w4 c">${procat1.getEpcId()}</td>
                            <td>${procat1.getEpcName()}</td>
                            <td class="w1 c">
                                <a href="/ManageProductClassModify.Servlet?epcid=${procat1.getEpcId()}">修改</a>
                                <a href="/ManageProductClass.Servlet?epcdelete=true&epcid=${procat1.getEpcId()}">删除</a>
                            </td>
                        </tr>
                        <c:forEach var="procat2" items="${productcategorylist}">
                            <c:if test="${procat2.getEpcParentId() == procat1.getEpcId()}">
                                <tr>
                                    <td class="first w4 c">${procat2.getEpcId()}</td>
                                    <td class="childClass">${procat2.getEpcName()}</td>
                                    <td class="w1 c">
                                        <a href="/ManageProductClassModify.Servlet?epcid=${procat2.getEpcId()}">修改</a>
                                        <a href="/ManageProductClass.Servlet?epcdelete=true&epcid=${procat2.getEpcId()}">删除</a>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </c:forEach>

            </table>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
