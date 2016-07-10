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
@WebServlet(name = "ManageProductClassModifyServlet")
public class ManageProductClassModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EpcParentId = request.getParameter("epcparentid");
        String EpcId = request.getParameter("epcid");
        String EpcName = request.getParameter("epcname");
        System.out.println(EpcParentId + " ^^^^^^ " + EpcName + " ^^^ " + EpcId);
        if (EpcParentId != null) {
            new TableService().updateProductCategoryByEpcId(EpcId, EpcName, EpcParentId);
            response.sendRedirect("/manage/manage-result.jsp");
            return;
        }
        request.setAttribute("rootproductcategorylist",new TableService().getRootProductCategory());
        request.setAttribute("productcategory", new TableService().getProductCategory(EpcId));
        request.getRequestDispatcher("/manage/productClass-modify.jsp").forward(request, response);
    }
}
