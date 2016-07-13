<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaoshuai
  Date: 2016/7/7
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="side">
    <div class="news-list">
        <h4>最新公告</h4>
        <ul>
            <c:forEach var="no" items="${noticelist}">
                <li><a href="/NoticeView.Servlet?id=${no.getNoticeId()}" target="_blank">${no.getNoticeTitle()}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="spacer"></div>
    <div class="news-list">
        <h4>新闻动态</h4>
        <ul>
            <c:forEach var="news1" items="${newslist}">
                <li><a href="/NewsView.Servlet?id=${news1.enId}" target="_blank">${news1.enTitle}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>
