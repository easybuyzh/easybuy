<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
	<jsp:include page="index-left.jsp"/>
	<div class="main">
		<h2>修改用户</h2>
		<div class="manage">
			<form action="/ManageUserModify.Servlet">
				<table class="form">
					<tr>
						<td class="field">用户ID：</td>
						<td><input type="text" class="text" name="euuserid" value="${user.getEuUserId()}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" class="text" name="euusername" value="${user.getEuUserName()}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="text" class="text" name="eupassword" value="${user.getEuPassword()}" /></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><input type="radio" name="eusex" value="男" checked="checked" />男 <input type="radio" name="eusex" value="女" />女</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
							<select name="birthyear">
								<option value="2000">2000</option>
								<option value="1999" selected="selected">1999</option>
							</select>年
							<select name="birthmonth">
								<option value="12">12</option>
								<option value="11" selected="selected">11</option>
							</select>月
							<select name="birthday">
								<option value="2">2</option>
								<option value="1" selected="selected">1</option>
							</select>日
						</td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="eumobile" value="${user.getEuMobile()}" /></td>
					</tr>
					<tr>
						<td class="field">邮箱:</td>
						<td><input type="text" class="text" name="euemail" value="${user.getEuEmail()}" /></td>
					</tr>
					<tr>
						<td class="field">送货地址：</td>
						<td><input type="text" class="text" name="euaddress" value="${user.getEuAddress()}" /></td>
					</tr>
					<tr>
						<td class="field">头像：</td>
						<td><input type="file" class="text" name="photo" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
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
