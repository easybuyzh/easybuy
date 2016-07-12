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
            <dd><em><a href="/ManageUserAdd.Servlet">新增</a></em><a href="/ManageUser.Servlet">用户管理</a></dd>
            <dt>商品信息</dt>
            <dd><em><a href="/ManageProductClassAdd.Servlet">新增</a></em><a href="/ManageProductClass.Servlet">分类管理</a></dd>
            <dd><em><a href="/ManageProductAdd.Servlet">新增</a></em><a href="/ManageProduct.Servlet">商品管理</a></dd>
            <dt>订单管理</dt>
            <dd><a href="/ManageOrder.Servlet">订单管理</a></dd>
            <dt>留言管理</dt>
            <dd><a href="/ManageGuestBook.Servlet">留言管理</a></dd>
            <dt>新闻管理</dt>
            <dd><em><a href="/ManageNewsAdd.Servlet">新增</a></em><a href="/ManageNews.Servlet">新闻管理</a></dd>
            <dt>公告管理</dt>
            <dd><em><a href="/ManageNoticeAdd.Servlet">新增</a></em><a href="/ManageNotice.Servlet">公告管理</a></dd>
        </dl>
    </div>
</div>
