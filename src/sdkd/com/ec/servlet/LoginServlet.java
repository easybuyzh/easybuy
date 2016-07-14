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
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //已登录的情况下点击该链接会
        if (request.getSession().getAttribute("userName") != null) {
            response.sendRedirect("/Index.Servlet");
            return;
        }

        String userName = Utils.JspStringFormat(request.getParameter("userName"));
        String passWord = Utils.JspStringFormat(request.getParameter("passWord"));
        String hint = null;
        if (checkVerycode(request, response) == false) hint = "验证码错误";
        if (new TableService().IsUserExists(userName, passWord) == false) hint = "用户名或密码错误";
        if (hint != null) {
            request.setAttribute("selected", "首页");
            request.setAttribute("hint",hint);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }


        if ("shoppingservlet".equals((String) request.getSession().getAttribute("comfrom"))) {
            doShoppingLogin(request, response);
            return;
        }
        doNormalLogin(request, response);
    }

    protected void doNormalLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("selected", "首页");
        String userName = Utils.JspStringFormat(request.getParameter("userName"));
        request.getSession().setAttribute("userName", userName);
        int userRole = Integer.valueOf((new TableService().getUserByUserName(userName).getEuRole()));
        if (userRole == 1) {
            request.getSession().setAttribute("ismanager", "true");
        }
        request.getRequestDispatcher("/Index.Servlet").forward(request, response);
    }

    protected void doShoppingLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("selected", "首页");
        String userName = Utils.JspStringFormat(request.getParameter("userName"));
        request.getSession().setAttribute("userName", userName);
        request.getSession().removeAttribute("comfrom");
        int userRole = Integer.valueOf((new TableService().getUserByUserName(userName).getEuRole()));
        if (userRole == 1) {
            request.getSession().setAttribute("ismanager", "true");
        }
        request.getRequestDispatcher("/Shopping.Servlet").forward(request, response);
        //问什么这里只能使用重定向才能跳转过去
    }

    private boolean checkVerycode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String veryCode = request.getParameter("veryCode");
        String googlecode = request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY).toString();
        return (googlecode.compareTo(veryCode) == 0);
    }
}

