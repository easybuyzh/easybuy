<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="position" class="wrap">
	您现在的位置：<a href="/Index.Servlet">易买网</a> &gt; 在线留言
</div>
<div id="main" class="wrap">
	<jsp:include page="index-left.jsp"/>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
				<c:forEach var="comment" items="${commentlist}">
				<li>
					<dl>
						<dt>${comment.getEcContent()}</dt>
						<dd class="author">网友：${comment.getEcNickName()} <span class="timer">${comment.getEcCreateTime()}</span></dd>
						<dd>${comment.getEcReply()}</dd>
					</dl>
				</li>
				</c:forEach>

			</ul>
			<div class="clear"></div>
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
			<div id="reply-box">
				<form id="CommentForm" method="post" action="/Insert.Comment.Servlet" onsubmit="return checkForm(this)">
					<table>
						<tr>
							<td class="field" aria-readonly="true">昵称：</td>
							<td><input class="text" type="text" name="guestName" value="${sessionScope.get("userName")}" readonly/></td>
						</tr>
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="guestContent"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
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
