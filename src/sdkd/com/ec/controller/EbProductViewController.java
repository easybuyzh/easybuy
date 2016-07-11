package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.service.TableService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhangjiwen on 2016/7/6.
 */
@WebServlet(name = "EbProductViewController")
public class EbProductViewController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        new TableService().ViewProductForOneTime(request.getParameter("id"));
        //增加产品的浏览量
        String userName = (String)request.getSession().getAttribute("userName");
        if(userName != null){
            //在用户登录状态需要记录用户最近的浏览记录
            new TableService().RecordBrowse(userName , request.getParameter("id"));
        }

        request.setAttribute("product", new TableService().getProductById(request.getParameter("id")));
        request.setAttribute("newslist",new TableService().getNewsTable());
        request.setAttribute("noticelist",new TableService().getNoticeTable());
        request.setAttribute("productcategorylist",new TableService().getProductCategoryTable());
        request.setAttribute("parentid",request.getParameter("parentid"));
        request.setAttribute("category",request.getParameter("category"));
        if(userName!=null){
             request.setAttribute("recentbrowselist",new TableService().getRecentBrowseList(userName));
        }

        //跳转
        request.getRequestDispatcher("/product-view.jsp").forward(request, response);
    }
}
