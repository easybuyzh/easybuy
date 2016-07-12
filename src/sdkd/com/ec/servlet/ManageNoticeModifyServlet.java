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
@WebServlet(name = "ManageNoticeModifyServlet")
public class ManageNoticeModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String NoticeContent = request.getParameter("noticecontent");
        String NoticeTitle = request.getParameter("noticetitle");
        String NoticeId = request.getParameter("noticeid");
       // System.out.println(NoticeId+"+++++++++++");

        if (NoticeContent != null) {
            new TableService().updateNoticeByNoticeId(NoticeId, NoticeTitle,NoticeContent);
            request.getRequestDispatcher("manage/manage-result.jsp").forward(request, response);
            return;
        }
        request.setAttribute("notice",new TableService().getNoticeByNoticeId(NoticeId));
        System.out.println(NoticeId+"+++++++++++");

        request.getRequestDispatcher("manage/notice-modify.jsp").forward(request,response);

    }
}
