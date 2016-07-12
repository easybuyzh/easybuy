<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
    <jsp:include page="index-left.jsp"/>
    <div class="main">
        <h2>修改公告</h2>
        <div class="manage">
            <form action="/ManageNoticeModify.Servlet">
                <table class="form">
                    <tr>
                        <td class="field">公告ID:</td>
                        <td><input type="text" class="text" name="noticeid" value="${notice.getNoticeId()}"  readonly="readonly"/></td>
                    </tr>
                        <td class="field">公告标题：</td>
                        <td><input type="text" class="text" name="noticetitle" value="${notice.getNoticeTitle()}" /></td>
                    </tr>
                    <tr>
                        <td class="field">公告内容：</td>
                        <td><textarea name="noticecontent">${notice.getNoticeContent()}</textarea></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><label class="ui-blue"><input type="submit" name="noticeid" value="${notice.getNoticeId()}" />submit</label></td>
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
