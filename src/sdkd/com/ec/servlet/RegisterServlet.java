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
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = Utils.JspStringFormat(request.getParameter("userName"));
        String passWord = Utils.JspStringFormat(request.getParameter("passWord"));
        String hint = null;
        if (checkVerycode(request, response) == false) hint = "验证码错误";
        if (new TableService().RegisterUser(userName, passWord) == false) hint = "注册失败，用户名已存在";
        if (hint != null) {
            request.setAttribute("selected", "首页");
            request.setAttribute("hint", hint);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        request.setAttribute("selected", "首页");
        request.getSession().setAttribute("userName", userName);
        request.getRequestDispatcher("reg-result.jsp").forward(request, response);
    }

    private boolean checkVerycode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String veryCode = request.getParameter("veryCode");
        String googlecode = request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY).toString();
        return (googlecode.compareTo(veryCode) == 0);
    }
}
