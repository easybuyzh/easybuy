<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
	<jsp:include page="index-left.jsp"/>
	<div class="main">
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">
				<form method="get" action="/ManageOrder.Servlet">
					订单号：<input type="text" class="text" name="querybyeoid" /> 订货人：<input type="text" class="text" name="querybyusername" /> <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
				</form>
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>发货地址</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach var="order" items="${orderlist}">
				<tr>
					<td class="first w4 c">${order.getEoId()}</td>
					<td class="w1 c">${order.getEuUserName()}</td>
					<td>${order.getEuAddress()}</td>
					<td class="w1 c">${order.getEoStatus()}</td>
					<td class="w1 c">
						<a href="/ManageOrderModify.Servlet?eoid=${order.getEoId()}">修改</a>
						<a href="/ManageOrder.Servlet?eoid=${order.getEoId()}&eodelete=true">删除</a>
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
