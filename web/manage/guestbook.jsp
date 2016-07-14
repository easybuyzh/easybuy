<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
    <jsp:include page="index-left.jsp"/>
    <div class="main">
        <h2>留言管理</h2>
        <div class="manage">
            <div class="search">
                <form method="get" action="/ManageGuestBook.Servlet">
                    姓名:<input type="text" class="text" name="querybyecnickname"/>
                    <label class="ui-blue">
                        <input type="submit" name="submit" value="查询"/>
                    </label>
                </form>
            </div>
            <table class="list">
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>留言内容</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="comment" items="${commentlist}">
                    <tr>
                        <td class="first w4 c">${comment.getEcId()}</td>
                        <td class="w1 c">${comment.getEcNickName()}</td>
                        <td>${comment.getEcContent()}</td>
                        <c:choose>
                            <c:when test="${comment.getEcReply() == null}">
                                <td class="w1 c">未回复</td>
                                <td class="110px c">
                                    <a href="/ManageGuestBookModify.Servlet?ecid=${comment.getEcId()}">查看</a>
                                    <a href="/ManageGuestBookModify.Servlet?ecid=${comment.getEcId()}">回复</a>
                                    <a href="/ManageGuestBookModify.Servlet?ecdelete=true&ecid=${comment.getEcId()}">删除</a>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td class="w1 c">已回复</td>
                                <td class=" width:110px; c">
                                    <a href="/ManageGuestBookModify.Servlet?ecid=${comment.getEcId()}">查看</a>
                                    <a href="/ManageGuestBookModify.Servlet?ecid=${comment.getEcId()}&ecrevoke=true">撤销</a>
                                    <a href="/ManageGuestBookModify.Servlet?ecdelete=true&ecid=${comment.getEcId()}">删除</a>
                                </td>
                            </c:otherwise>
                        </c:choose>
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
