<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
    <jsp:include page="index-left.jsp"/>
    <div class="main">
        <h2>修改商品</h2>
        <div class="manage">
            <form action="/ManageProductModify.Servlet" method="post" enctype="multipart/form-data">
                <table class="form" >
                    <tr>
                        <td class="field">商品名称：</td>
                        <td><input type="text" class="text" name="epname" value="${product.getEpName()}"/></td>
                    </tr>
                    <tr>
                        <td class="field">所属分类：</td>
                        <td>
                            <select name="epcid">
                                <c:forEach var="procat1" items="${productcategorylist}">
                                    <c:if test="${procat1.getEpcParentId() == '0'}">
                                        <c:if test="${procat1.getEpcId() == product.getEpcId()}">
                                            <option value="${procat1.getEpcId()}"
                                                    selected="selected">${procat1.getEpcName()}</option>
                                        </c:if>
                                        <c:if test="${procat1.getEpcId() != product.getEpcId()}">
                                            <option value="${procat1.getEpcId()}">${procat1.getEpcName()}</option>
                                        </c:if>
                                        <c:forEach var="procat2" items="${productcategorylist}">
                                            <c:if test="${procat2.getEpcParentId() == procat1.getEpcId()}">
                                                <c:if test="${procat2.getEpcId() == product.getEpcId()}">
                                                    <option value="${procat2.getEpcId()}"
                                                            selected="selected">└${procat2.getEpcName()}</option>
                                                </c:if>
                                                <c:if test="${procat2.getEpcId() != product.getEpcId()}">
                                                    <option value="${procat2.getEpcId()}">
                                                        └${procat2.getEpcName()}</option>
                                                </c:if>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">商品ID：</td>
                        <td><input type="text" class="text tiny" name="epid" value="${product.getEpId()}" readonly="readonly"/> </td>
                    </tr>
                    <tr>
                        <td class="field">商品图片：</td>
                        <td><input type="file" class="text" name="photo" value="${product.getEpProductIcon()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">商品价格：</td>
                        <td><input type="text" class="text tiny" name="epprice" value="${product.getEpPrice()}"/> 元</td>
                    </tr>
                    <tr>
                        <td class="field">是否为特价商品：</td>
                        <c:if test="${product.getEpBargain() == '1'}">
                            <td><input type="radio" name="epbargain" value="0"/>否
                                <input type="radio" name="epbargain" value="1" checked="checked"/>是
                            </td>
                        </c:if>
                        <c:if test="${product.getEpBargain() == '0'}">
                            <td><input type="radio" name="epbargain" value="0" checked="checked"/>否
                                <input type="radio" name="epbargain" value="1"/>是
                            </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td class="field">商品特价：</td>
                        <td><input type="text" class="text tiny" name="epbaprice" value="${product.getEpBaPrice()}"/>元
                        </td>
                    </tr>
                    <tr>
                        <td class="field">库存：</td>
                        <td><input type="text" class="text tiny" name="epstock" value="${product.getEpStock()}"/></td>
                    </tr>
                    <tr>
                        <td class="field">条码号：</td>
                        <td><input type="text" class="text" name="epbarcode" value="${product.getEpBarCode()}"/></td>
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
