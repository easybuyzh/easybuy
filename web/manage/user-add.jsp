<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
    <jsp:include page="index-left.jsp"/>
    <div class="main">
        <h2>新增用户</h2>
        <div class="manage">
            <form action="/ManageUserAdd.Servlet">
                <table class="form">
                    <tr>
                        <td class="field">用户名：</td>
                        <td><input type="text" class="text" name="euusername" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">密码：</td>
                        <td><input type="text" class="text" name="eupassword" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">性别：</td>
                        <td><input type="radio" name="sex" value="男" checked="checked"/>男 <input type="radio" name="sex"
                                                                                                 value="女"/>女
                        </td>
                    </tr>
                    <tr>
                        <td class="field">出生日期：</td>
                        <td>
                            <select name="birthyear">
                                <c:forEach var="x" begin="1960" end="2016" step="1">
                                    <option value="${x}">${x}</option>
                                </c:forEach>
                            </select>年
                            <select name="birthmonth">
                                <c:forEach var="x" begin="1" end="12" step="1">
                                    <option value="${x}">${x}</option>
                                </c:forEach>
                            </select>月
                            <select name="birthday">
                                <c:forEach var="x" begin="1" end="31" step="1">
                                    <option value="${x}">${x}</option>
                                </c:forEach>
                            </select>日
                        </td>
                    </tr>
                    <tr>
                        <td class="field">手机号码：</td>
                        <td><input type="text" class="text" name="eumobile" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">送货地址：</td>
                        <td><input type="text" class="text" name="euaddress" value=""/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><label class="ui-blue"><input type="submit" name="submit" value="添加"/></label></td>
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
