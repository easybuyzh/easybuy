package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbNoticeDao;
import sdkd.com.ec.model.EbNotice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjiwen on 2016/7/7.
 */
@WebServlet(name = "EbNoticeController")
public class EbNoticeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EbNoticeDao ebNoticeDao =new EbNoticeDao();
        List<EbNotice> list =ebNoticeDao.getNotice();
        request.setAttribute("ebnoticelist",list);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
