package sdkd.com.ec.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhaoshuai on 2016/7/7.
 */
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setAttribute("selected","首页");
           request.getSession().removeAttribute("userName");
           if(request.getSession().getAttribute("ismanager")!=null)
                 request.getSession().removeAttribute("ismanager");
           request.getRequestDispatcher("/Index.Servlet").forward(request,response);
    }
}
