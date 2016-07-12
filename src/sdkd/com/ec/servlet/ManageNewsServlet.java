package sdkd.com.ec.servlet;

import sdkd.com.ec.service.TableService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        if (EnDelete != null) {
            new TableService().deleteNewsByEnId(EnId);
            response.sendRedirect("/ManageNews.Servlet");
            return;
        }
        request.setAttribute("newslist", new TableService().getNewsTable());
        request.getRequestDispatcher("manage/news.jsp").forward(request, response);
    }
}
