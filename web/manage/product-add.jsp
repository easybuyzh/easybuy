<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
    <jsp:include page="index-left.jsp"/>
    <div class="main">
        <h2>添加商品</h2>
        <div class="manage">
            <form action="/ManageProductAdd.Servlet"  method="post" enctype="multipart/form-data">
                <table class="form">
                    <tr>
                        <td class="field">商品名称：</td>
                        <td><input type="text" class="text" name="epname" value="" onfocus="FocusItem(this)" onblur="CheckItem(this);"/></td>
                    </tr>
                    <tr>
                        <td class="field">所属分类：</td>
                        <td>
                            <select name="epcid">

                                <c:forEach var="procat1" items="${productcategorylist}">
                                    <c:if test="${procat1.getEpcParentId() == '0'}">
                                        <option value="${procat1.getEpcId()}">${procat1.getEpcName()}</option>
                                        <c:forEach var="procat2" items="${productcategorylist}">
                                            <c:if test="${procat2.getEpcParentId() == procat1.getEpcId()}">
                                                <option value="${procat2.getEpcId()}">└ ${procat2.getEpcName()}</option>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">商品图片：</td>
                        <td><input type="file" class="text" name="photo" /></td>
                    </tr>
                    <tr>
                        <td class="field">商品价格：</td>
                        <td><input type="text" class="text tiny" name="epprice" onfocus="FocusItem(this)" onblur="CheckItem(this);"/> 元</td>
                    </tr>
                    <tr>
                        <td class="field">是否为特价商品：</td>
                        <td><input type="radio" name="epbargain" value="0" checked="checked"/>否
                            <input type="radio" name="epbargain" value="1"/>是
                        </td>
                    </tr>
                    <tr>
                        <td class="field">商品特价：</td>
                        <td><input type="text" class="text tiny" name="epbaprice" /></td>
                    </tr>
                    <tr>
                        <td class="field">库存：</td>
                        <td><input type="text" class="text tiny" name="epstock" onfocus="FocusItem(this)" onblur="CheckItem(this);"/></td>
                    </tr>
                    <tr>
                        <td class="field">条码号：</td>
                        <td><input type="text" class="text" name="epbarcode_"  onfocus="FocusItem(this)" onblur="CheckItem(this);"/></td>
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
