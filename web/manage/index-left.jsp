<%--
  Created by IntelliJ IDEA.
  User: zhaoshuai
  Date: 2016/7/9
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="menu-mng" class="lefter">
    <div class="box">
        <dl>
            <dt>用户管理</dt>
            <dd><em><a href="/manage/user-add.jsp">新增</a></em><a href="/manage/user.jsp">用户管理</a></dd>
            <dt>商品信息</dt>
            <dd><em><a href="/manage/productClass-add.jsp">新增</a></em><a href="/manage/productClass.jsp">分类管理</a></dd>
            <dd><em><a href="/manage/product-add.jsp">新增</a></em><a href="/manage/product.jsp">商品管理</a></dd>
            <dt>订单管理</dt>
            <dd><a href="/manage/order.jsp">订单管理</a></dd>
            <dt>留言管理</dt>
            <dd><a href="/ManageGuestBook.Servlet">留言管理</a></dd>
            <dt>新闻管理</dt>
            <dd><em><a href="/ManageNewsAdd.Servlet">新增</a></em><a href="/ManageNews.Servlet">新闻管理</a></dd>
        </dl>
    </div>
</div>
