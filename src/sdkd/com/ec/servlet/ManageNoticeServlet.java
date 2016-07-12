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
@WebServlet(name = "ManageNoticeServlet")
public class ManageNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String NoticeDelete = request.getParameter("noticedelete");
        String NoticeCreateTime = request.getParameter("noticecreatetime");
        if (NoticeDelete != null) {
            new TableService().deleteNoticeByNoticeCreateTime(NoticeCreateTime);
            response.sendRedirect("/ManageNotice.Servlet");
            return;
        }
        request.setAttribute("noticelist", new TableService().getNoticeTable());
        request.getRequestDispatcher("manage/notice.jsp").forward(request, response);

    }
}
