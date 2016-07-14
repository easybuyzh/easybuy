<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
使用 page 默认 servlet 传递来的参数 ： pagecount 总页数 nowpage 代表当前页 pageurl 点击跳转到的连接
          默认项servlet传递的参数为 : page  代表请求显示第几页
--%>
<div class="pager">
    <ul class="clearfix">
        <li><a href="${pageurl}?id=${id}&page=${Math.max(nowpage - 1 , 1)}">上一页</a></li>
        <c:forEach var="x" begin="1" end="${pagecount}" step="1">
            <c:choose>
                <c:when test="${nowpage == x}">
                    <li class="current">${x}</li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageurl}?id=${id}&page=${x}">${x}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${nowpage + 1 > pagecount}">
            <li><a href="${pageurl}?id=${id}&page=${pagecount}">下一页</a></li>
        </c:if>
        <c:if test="${nowpage + 1 <= pagecount}">
            <li><a href="${pageurl}?id=${id}&page=${nowpage + 1}">下一页</a></li>
        </c:if>
    </ul>
</div>
