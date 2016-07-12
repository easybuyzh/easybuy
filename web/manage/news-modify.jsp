<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
	<jsp:include page="index-left.jsp"/>
	<div class="main">
		<h2>修改新闻</h2>
		<div class="manage">
			<form action="/ManageNewsModify.Servlet">
				<table class="form">
					<tr>
						<td class="field">新闻ID:</td>
						<td><input type="text" class="text" name="enid" value="${news.getEnId()}"  readonly="readonly"/></td>
					</tr>
					<tr>
						<td class="field">新闻标题：</td>
						<td><input type="text" class="text" name="entitle" value="${news.getEnTitle()}" /></td>
					</tr>
					<tr>
						<td class="field">新闻内容：</td>
						<td><textarea name="encontent">${news.getEnContent()}</textarea></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="enbutton" value="" />submit</label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
