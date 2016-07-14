package sdkd.com.ec.servlet;

import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNotice;
import sdkd.com.ec.service.TableService;
import sdkd.com.ec.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/9.
 */
@WebServlet(name = "ManageNewsServlet")
public class ManageNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EnDelete = request.getParameter("endelete");
        String EnId = request.getParameter("enid");
        setPageInfo(request,response,new TableService().getNewsTable(),"/ManageNews.Servlet");
        if (EnDelete != null) {
            new TableService().deleteNewsByEnId(EnId);
            response.sendRedirect("/ManageNews.Servlet");
            return;
        }
        request.setAttribute("selected","新闻");
        request.getRequestDispatcher("manage/news.jsp").forward(request, response);
    }
    protected void setPageInfo(HttpServletRequest request, HttpServletResponse response, List<EbNews> all, String url) throws ServletException, IOException {
        String page = request.getParameter("page");
        PageUtil<EbNews> pageUtil = new PageUtil<EbNews>(10);
        String nowPage = "1";
        if (page != null) nowPage = page;
        Integer pageCount = pageUtil.getPageCount(all);
        String pageUrl = url;
        request.setAttribute("nowpage", nowPage);
        request.setAttribute("pagecount", pageCount);
        request.setAttribute("pageurl", pageUrl);
        request.setAttribute("newslist", pageUtil.getSpecificPageList(all, Integer.valueOf(nowPage)));
    }
}
