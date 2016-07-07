package sdkd.com.ec.servlet;

import sdkd.com.ec.dao.impl.EbCommentDao;
import sdkd.com.ec.util.Format;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhaoshuai on 2016/7/6.
 */
@WebServlet(name = "InsertCommentServlet")
public class InsertCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guestName = Format.JspStringFormat(request.getParameter("guestName"));
        String guestContent =  Format.JspStringFormat(request.getParameter("guestContent"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();

        String nowTime = sdf.format(now);
        EbCommentDao te = new EbCommentDao();
        te.InsertComment(guestName , guestContent , nowTime);
        request.getRequestDispatcher("/Comment.Servlet").forward(request,response);
    }
}
