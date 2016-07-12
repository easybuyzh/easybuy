package sdkd.com.ec.servlet;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.service.TableService;
import sdkd.com.ec.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/10.
 */
@WebServlet(name = "ManageUserAddServlet")
public class ManageUserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EuUserName = request.getParameter("euusername");
        String EuPassword =request.getParameter("eupassword");
        String EuSex = request.getParameter("eusex");
        String EuBirthday = request.getParameter("birthyear") + "-" +  request.getParameter("birthmonth") + "-" + request.getParameter("birthday");
        String EuMobile = request.getParameter("eumobile");
        String EuEmail = request.getParameter("euemail");

        List<String> columnName = new ArrayList<String>();
        List<String> params = new ArrayList<String>();

        columnName.add("eu_user_name");
        params.add(EuUserName);

        columnName.add("eu_password");
        params.add(EuPassword);

        columnName.add("eu_sex");
        params.add(EuSex);

        columnName.add("eu_birthday");
        params.add(EuBirthday);

        columnName.add("eu_mobile");
        params.add(EuMobile);

        columnName.add("eu_email");
        params.add(EuEmail);

        if(EuUserName != null){
            if(new TableService().getUserIdByUserName(EuUserName) != null){
                request.setAttribute("managefailed","添加新用户失败，用户名已存在");
            }  else  {
                new TableService().InsertUser(columnName,params);
            }
            request.getRequestDispatcher("/manage/manage-result.jsp").forward(request,response);
            return ;
        }
        response.sendRedirect("/manage/user-add.jsp");
    }
}
