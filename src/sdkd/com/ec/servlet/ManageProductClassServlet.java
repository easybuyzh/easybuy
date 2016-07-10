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
@WebServlet(name = "ManageProductClassServlet")
public class ManageProductClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EpcDelete = request.getParameter("epcdelete");
        String EpcId = request.getParameter("epcid");
        if (EpcDelete != null) {
            new TableService().deleteProductCategoryByEpcId(EpcId);
            response.sendRedirect("/ManageProductClass.Servlet");
            return;
        }
        request.setAttribute("productcategorylist", new TableService().getProductCategoryTable());
        request.getRequestDispatcher("/manage/productClass.jsp").forward(request, response);
    }
}
