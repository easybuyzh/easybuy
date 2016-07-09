package sdkd.com.ec.servlet;

import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.service.TableService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/7.
 */
@WebServlet(name = "ProductListServlet")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productlist",new TableService().getProductListByCategory(request.getParameter("id")));
        request.setAttribute("productcategorylist",new TableService().getProductCategoryTable());
        request.setAttribute("parentid",request.getParameter("id"));
        request.setAttribute("category",request.getParameter("category"));
        System.out.println(request.getParameter("id") + " --  " + request.getParameter("category"));

        request.getRequestDispatcher("product-list.jsp").forward(request,response);
    }
}
