package sdkd.com.ec.servlet;

import sdkd.com.ec.model.EbComment;
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
@WebServlet(name = "ManageGuestBookModifyServlet")
public class ManageGuestBookModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //if(new TableService().isManager((String)request.getSession().getAttribute("userName")) == false){
           // response.sendRedirect("/accessdenied.jsp");
            //非管理员拒绝访问
         //   return ;
       // }
        String EcId = request.getParameter("ecid");
        String EcReply = request.getParameter("ecreply");
        String EcDelete = request.getParameter("ecdelete");
        String EcRevoke = request.getParameter("ecrevoke");
        if(EcRevoke != null){
            new TableService().DeleteCommentReply(EcId);
            request.getRequestDispatcher("/ManageGuestBook.Servlet").forward(request,response);
            return ;
        }
        if(EcDelete != null){
               new TableService().deleteCommentByEcId(EcId);
               request.getRequestDispatcher("/ManageGuestBook.Servlet").forward(request,response);
               return ;
        }
        if (EcReply != null) {
            new TableService().ReplyComment(EcId, EcReply);
            request.getRequestDispatcher("manage/manage-result.jsp").forward(request, response);
            return;
        }
        request.setAttribute("comment", new TableService().getCommentByEcId(EcId));
        request.getRequestDispatcher("manage/guestbook-modify.jsp").forward(request, response);
    }

}
