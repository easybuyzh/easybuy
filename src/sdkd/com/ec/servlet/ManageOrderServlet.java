package sdkd.com.ec.servlet;

import sdkd.com.ec.service.TableService;
import sdkd.com.ec.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhaoshuai on 2016/7/10.
 */
@WebServlet(name = "ManageOrderServlet")
public class ManageOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eodelete = request.getParameter("eodelete");
        String eoid = request.getParameter("eoid");
        String QueryByEoId = request.getParameter("querybyeoid");
        String QueryByEuUserId = new TableService().getUserIdByUserName(request.getParameter("querybyusername"));
        if (eodelete != null) {
            new TableService().deleteOrderByEoId(eoid);
            request.getRequestDispatcher("/manage/manage-result.jsp").forward(request, response);
            return;
        }
        if (QueryByEoId != null && QueryByEoId.length() > 0) {
            request.setAttribute("orderlist", new TableService().getOrderViewByEoId(QueryByEoId));
        } else if (QueryByEuUserId != null && QueryByEuUserId.length() > 0) {
            request.setAttribute("orderlist", new TableService().getOrderViewByUserId(QueryByEuUserId));
        } else {
            request.setAttribute("orderlist", new TableService().getOrderViews());
        }
        request.getRequestDispatcher("manage/order.jsp").forward(request, response);
    }
}
