<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="position" class="wrap">
	您现在的位置：<a href="/Index.Servlet">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="/Shopping.Servlet?CommitOrder=CommitOrder">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<c:forEach var="product" items="${shoppingcartlist}">
					<tr id="product_id_1">
						<td class="thumb"><img width="50" height="50" src="images/product/${product.getEpProductIcon()}" /><a href="/ProductView.Servlet?id=${product.getEcaProductId()}">${product.getEpName()}</a></td>
						<td class="price" id="price_id_1">
							<span>￥${product.getEpPrice() * product.getEcaProductCount()}</span>
							<input type="hidden" value="${product.getEpPrice()}" />
						</td>
						<td class="number">
							<dl>
								<dt><input id="number_id_1" type="text" name="number" value="${product.getEcaProductCount()}" /></dt>
								<dd onclick="reloadPrice(1,true);">修改</dd>
							</dl>
						</td>
						<td class="delete"><a href="#" onclick="javascript:delShopping(1)">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
			<div class="button"><input type="submit" value=""  onclick="location.href='/Shopping.Servlet?CommitOrder=CommitOrder'"/></div>
	</div>
	<script type="text/javascript">
		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
	</script>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
