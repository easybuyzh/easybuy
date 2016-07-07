<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaoshuai
  Date: 2016/7/7
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="left-side">
    <div class="news-list">
        <h4>最新公告</h4>
        <ul>
            <c:forEach var="no" items="${noticelist}">
                <li><a href="/NoticeView.Servlet?id=${no.getNoticeId()}" target="_blank">${no.getNoticeTitle()}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="spacer"></div>a
    <div class="news-list">
        <h4>新闻动态</h4>
        <ul>
            <c:forEach var="news" items="${newslist}">
                <li><a href="/Newsview.Servlet?id=${news.enId}" target="_blank">${news.enTitle}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>

