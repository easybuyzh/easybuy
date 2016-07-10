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
@WebServlet(name = "ManageNewsAddServlet")
public class ManageNewsAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EnTitle = request.getParameter("entitle");
        String EnContent = request.getParameter("encontent");
        if (EnTitle != null) {
            new TableService().insertNews(EnTitle, EnContent);
            request.getRequestDispatcher("manage/manage-result.jsp").forward(request, response);
            return ;
        }
        response.sendRedirect("manage/news-add.jsp");
    }
}
