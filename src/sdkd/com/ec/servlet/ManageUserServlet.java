package sdkd.com.ec.servlet;

import javafx.scene.control.Tab;
import sdkd.com.ec.service.TableService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhaoshuai on 2016/7/10.
 */
@WebServlet(name = "ManageUserServlet")
public class ManageUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EuDelete = request.getParameter("eudelete");
        String EuId = request.getParameter("euuserid");
        System.out.println(EuDelete + " -- " + EuId);
        if (EuDelete != null) {
            new TableService().deleteUserByEuUserId(EuId);
            response.sendRedirect("/ManageUser.Servlet");
            return;
        }
        request.setAttribute("userlist",new TableService().getUserTable());
        request.getRequestDispatcher("manage/user.jsp").forward(request,response);
    }
}
