package sdkd.com.ec.servlet;

import javafx.scene.control.Tab;
import sdkd.com.ec.model.EbNotice;
import sdkd.com.ec.model.EbOrderView;
import sdkd.com.ec.model.EbUser;
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
 * Created by zhaoshuai on 2016/7/10.
 */
@WebServlet(name = "ManageUserServlet")
public class ManageUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EuDelete = request.getParameter("eudelete");
        String EuId = request.getParameter("euuserid");
        setPageInfo(request,response,new TableService().getUserTable(),"/ManageUser.Servlet");
        if (EuDelete != null) {
            new TableService().deleteUserByEuUserId(EuId);
            response.sendRedirect("/ManageUser.Servlet");
            return;
        }
        request.setAttribute("selected","用户");
        request.getRequestDispatcher("manage/user.jsp").forward(request,response);
    }
    protected void setPageInfo(HttpServletRequest request, HttpServletResponse response, List<EbUser> all, String url) throws ServletException, IOException {
        String page = request.getParameter("page");
        PageUtil<EbUser> pageUtil = new PageUtil<EbUser>(10);
        String nowPage = "1";
        if (page != null) nowPage = page;
        Integer pageCount = pageUtil.getPageCount(all);
        String pageUrl = url;
        request.setAttribute("nowpage", nowPage);
        request.setAttribute("pagecount", pageCount);
        request.setAttribute("pageurl", pageUrl);
        request.setAttribute("userlist", pageUtil.getSpecificPageList(all, Integer.valueOf(nowPage)));
    }
}
