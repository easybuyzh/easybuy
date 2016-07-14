<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
	<jsp:include page="index-left.jsp"/>
	<div class="main">
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<c:forEach var="user" items="${userlist}">
				<tr>
					<td class="first w4 c">${user.getEuUserId()}</td>
					<td class="w1 c">${user.getEuUserName()}</td>
					<td class="w2 c">${user.getEuSex()}</td>
					<td>${user.getEuEmail()}</td>
					<td class="w4 c">${user.getEuMobile()}</td>
					<td class="w1 c"><a href="/ManageUserModify.Servlet?euuserid=${user.getEuUserId()}">修改</a> <a href="/ManageUser.Servlet?eudelete=true&euuserid=${user.getEuUserId()}">删除</a></td>
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
