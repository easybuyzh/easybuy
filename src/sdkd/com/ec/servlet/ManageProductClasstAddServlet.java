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
@WebServlet(name = "ManageProductClasstAddServlet")
public class ManageProductClasstAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EpcName = request.getParameter("epcname");
        String EpcParentId = request.getParameter("epcparentid");
        if (EpcName != null) {
            new TableService().insertProductCategory(EpcName, EpcParentId);
            request.getRequestDispatcher("/manage/manage-result.jsp").forward(request, response);
            return;
        }
        request.setAttribute("rootproductcategorylist",new TableService().getRootProductCategory());
        request.getRequestDispatcher("/manage/productClass-add.jsp").forward(request, response);
    }
}
