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
				<form method="get">
					订单号：<input type="text" class="text" name="orderId" /> 订货人：<input type="text" class="text" name="userName" /> <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
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
					<td class="w1 c">${order.getEoUserId()}</td>
					<td>${order.getEuAddress()}</td>
					<td class="w1 c">${order.getEoStatus()}</td>
					<td class="w1 c">
						<a href="/ManageOrderModify.Servlet?eoid=${order.getEoId()}">修改</a>
						<a href="/ManageOrder.Servlet?eoid=${order.getEoId()}&eodelete=true">删除</a>
					</td>
					</tr>
				</c:forEach>
			</table>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="#">上一页</a></li>
					<li class="current">1</li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">下一页</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
