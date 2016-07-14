<%--
  Created by IntelliJ IDEA.
  User: zhaoshuai
  Date: 2016/7/11
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<form action="kaptchatest" method="post">
    <img title = "点我换一张" alt="" src="yzm" style="cursor:pointer;" onclick="changeVerifyCode();">
    <input type="text" name="yzm">
    <br>
    <input type="submit" value="测试验证码">
</form>
</html>
