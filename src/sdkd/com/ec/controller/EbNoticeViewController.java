package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNoticeDao;
import sdkd.com.ec.model.EbNotice;
import sdkd.com.ec.service.TableService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhangjiwen on 2016/7/7.
 */
@WebServlet(name = "EbNoticeViewController")
public class EbNoticeViewController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EbNoticeDao dao = new EbNoticeDao();
        List<EbNotice> list = dao.getNotice();
        EbNotice notice = null;
        for(EbNotice notice1 : list) {
            if(notice1.getNoticeId().equals("" + id)) {
                notice = notice1;
                break;
            }
        }
        request.setAttribute("notice",notice);
        request.setAttribute("newslist",new TableService().getNewsTable());
        request.setAttribute("noticelist",new TableService().getNoticeTable());
        //跳转
        request.getRequestDispatcher("/notice-view.jsp").forward(request, response);
    }
}
