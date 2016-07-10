<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
    <jsp:include page="index-left.jsp"/>
    <div class="main">
        <h2>修改订单</h2>
        <div class="manage">
            <form action="/ManageOrderModify.Servlet">
                <table class="form">
                    <tr>
                        <td class="field">订单ID：</td>
                        <td><input type="text" class="text" name="eoid" value="${order.getEoId()}"
                                   readonly="readonly"/></td>
                    </tr>
                    <tr>
                        <td class="field">订购人姓名：</td>
                        <td><input type="text" class="text" name="name" value="${order.getEuUserName()}"
                                   readonly="readonly"/></td>
                    </tr>
                    <tr>
                        <td class="field">邮寄地址：</td>
                        <td><input type="text" class="text" name="name" value="${order.getEuAddress()}"
                                   readonly="readonly"/></td>
                    </tr>
                    <tr>
                        <td class="field">邮寄状态:</td>
                        <td><input type="text" class="text" name="eostatus" value="${order.getEoStatus()}"
                                   /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><label class="ui-blue"><input type="submit" name="submit" value="更新"/></label></td>
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
