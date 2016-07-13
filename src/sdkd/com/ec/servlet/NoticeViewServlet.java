package sdkd.com.ec.servlet;

import sdkd.com.ec.service.TableService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhaoshuai on 2016/7/13.
 */
@WebServlet(name = "NoticeViewServlet")
public class NoticeViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("notice", new TableService().getNoticeByEnId(request.getParameter("id")));
        request.setAttribute("newslist",new TableService().getNewsTable());
        request.setAttribute("noticelist",new TableService().getNoticeTable());
        request.getRequestDispatcher("/notice-view.jsp").forward(request, response);
    }
}
