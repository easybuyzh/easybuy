<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
    <jsp:include page="index-left.jsp"/>
    <div class="main">
        <h2>添加分类</h2>
        <div class="manage">
            <form action="/ManageProductClassAdd.Servlet">
                <table class="form">
                    <tr>
                        <td class="field">父分类：</td>
                        <td>
                            <select name="epcparentid">
                                <option value="0" selected="selected">根栏目</option>
                                    <c:forEach var="rpc" items="${rootproductcategorylist}">
                                        <option value="${rpc.getEpcId()}">${rpc.getEpcName()}</option>
                                    </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">分类名称：</td>
                        <td><input type="text" class="text" name="epcname" value=""/></td>
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
