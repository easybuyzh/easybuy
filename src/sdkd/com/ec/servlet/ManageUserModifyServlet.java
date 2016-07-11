package sdkd.com.ec.servlet;

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
@WebServlet(name = "ManageUserModifyServlet")
public class ManageUserModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EuUserName = request.getParameter("euusername");
        String EuPassword = request.getParameter("eupassword");
        String EuSex = request.getParameter("eusex");
        String EuBirthday = request.getParameter("birthyear") + "-" +  request.getParameter("birthmonth") + "-" + request.getParameter("birthday");
        String EuMobile = request.getParameter("eumobile");
        String EuEmail = request.getParameter("euemail");
        String EuAddress = request.getParameter("euaddress");

        //System.out.println(request.getParameter("euusername") + " ****" +  Utils.JspStringFormat(request.getParameter("euusername")));

        String EuId = request.getParameter("euuserid");

        List<String> params = new ArrayList<String>();
        params.add(EuUserName);
        params.add(EuPassword);
        params.add(EuSex);
        params.add(EuBirthday);
        params.add(EuMobile);
        params.add(EuEmail);
        params.add(EuAddress);

        if(EuUserName != null){
            new TableService().updateUserByUserId(EuId,params);
            response.sendRedirect("manage/manage-result.jsp");
            return ;
        }

        request.setAttribute("user",new TableService().getUserByUserId(EuId));
        request.getRequestDispatcher("manage/user-modify.jsp").forward(request,response);
    }
}
