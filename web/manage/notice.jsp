<%--
  Created by IntelliJ IDEA.
  User: zhangjiwen
  Date: 2016/7/12
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
    <jsp:include page="index-left.jsp"/>
    <div class="main">
        <h2>公告管理</h2>
        <div class="manage">
            <table class="list">
                <tr>
                    <th>创建时间</th>
                    <th>公告标题</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="notice" items="${noticelist}">
                    <tr>
                        <td class="first w4 c">${notice.getNoticeTime()}</td>
                        <td>${notice.getNoticeTitle()}</td>
                        <td class="w1 c"><a href="/ManageNoticeModify.Servlet?noticeid=${notice.getNoticeId()}">修改</a> <a href="/ManageNotice.Servlet?noticedelete=true&noticecreatetime=${notice.getNoticeTime()}">删除</a></td>
                    </tr>
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
