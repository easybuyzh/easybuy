<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<div class="wrap">
    <div id="shopping">
        <div class="shadow">
            <em class="corner lb"></em>
            <em class="corner rt"></em>
            <div class="box">
                <div class="msg">
                    <p>Access Denied</p>
                    <p>非管理员拒绝访问</p>
                    <p>3秒后自动进入首页...</p>
                    <script type="text/javascript">
                        setTimeout("location.href='/Index.Servlet'", 3000);
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="footer">
    Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

