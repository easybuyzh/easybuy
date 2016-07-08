package sdkd.com.ec.servlet;

import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.service.TableService;
import sdkd.com.ec.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhaoshuai on 2016/7/6.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = Utils.JspStringFormat(request.getParameter("userName"));
        String passWord = Utils.JspStringFormat(request.getParameter("passWord"));

        if(new TableService().RegisterUser(userName,passWord) == true){
            //注册成功
            request.getSession().setAttribute("userName",userName);
            request.getRequestDispatcher("reg-result.jsp").forward(request,response);
        }  else {
            //注册失败
            request.setAttribute("hint","注册失败，可能原因是用户名已存在");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }
}
