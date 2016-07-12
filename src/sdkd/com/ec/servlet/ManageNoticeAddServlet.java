package sdkd.com.ec.servlet;

import sdkd.com.ec.service.TableService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangjiwen on 2016/7/12.
 */
@WebServlet(name = "ManageNoticeAddServlet")
public class ManageNoticeAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String notice_title = request.getParameter("notice_title");
        String notice_content = request.getParameter("notice_content");
        if (notice_title != null) {
            new TableService().insertNotice(notice_title, notice_content);
            request.getRequestDispatcher("manage/manage-result.jsp").forward(request, response);
            return ;
        }
        response.sendRedirect("manage/notice-add.jsp");
    }


}
