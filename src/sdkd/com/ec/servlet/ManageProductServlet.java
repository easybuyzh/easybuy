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
@WebServlet(name = "ManageProductServlet")
public class ManageProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EpDelete = request.getParameter("epdelete");
        String EpId = request.getParameter("epid");
        if (EpDelete != null) {
            new TableService().deleteProductByEpId(EpId);
            response.sendRedirect("/ManageProduct.Servlet");
            return;
        }
        request.setAttribute("productlist",new TableService().getProductTable());
        request.getRequestDispatcher("/manage/product.jsp").forward(request,response);
    }
}
