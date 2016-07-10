package sdkd.com.ec.servlet;

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
@WebServlet(name = "ManageOrderModifyServlet")
public class ManageOrderModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String EoId = request.getParameter("eoid");
          String EoStatus = request.getParameter("eostatus");
          if(EoStatus!=null){
                 new TableService().updateOrderByEoId(EoId,EoStatus);
                 request.getRequestDispatcher("/manage/manage-result.jsp").forward(request,response);
                 return;
          }
          request.setAttribute("order",new TableService().getOrderViewByOrderID(EoId));
          request.getRequestDispatcher("/manage/order-modify.jsp").forward(request,response);
    }
}
