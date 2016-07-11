<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="position" class="wrap">
	您现在的位置：<a href="/Index.Servlet">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<div class="shadow">
			<em class="corner lb"></em>
			<em class="corner rt"></em>
			<div class="box">
				<div class="msg">

					<c:choose>
						<c:when test="${cartempty == null && commitfailed == null}">
							<p>恭喜：购买成功！</p>
						</c:when>
						<c:when test="${cartempty == 'true'}">
							<p>您还没有选购任何商品，赶快去选购吧!!</p>
						</c:when>
						<c:otherwise>
							<p>抱歉您提交的订单失败!</p>
						</c:otherwise>
					</c:choose>
					<p>正在进入首页...</p>
					<script type="text/javascript">
						setTimeout("location.href='/Index.Servlet'", 3000);
					</script>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
