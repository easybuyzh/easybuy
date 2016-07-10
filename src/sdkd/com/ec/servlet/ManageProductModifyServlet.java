package sdkd.com.ec.servlet;

import sdkd.com.ec.service.TableService;

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
@WebServlet(name = "ManageProductModifyServlet")
public class ManageProductModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EpId = request.getParameter("epid");
        String EpName = request.getParameter("epname");
        String EpcId = request.getParameter("epcid");
        String EpPrice = request.getParameter("epprice");
        String EpBargain = request.getParameter("epbargain");
        String EpBaPrice = request.getParameter("epbaprice");
        String EpStock = request.getParameter("epstock");
        String EpBarCode = request.getParameter("epbarcode");

        if (EpName != null) {
            List<String> params = new ArrayList<String>();
            List<String> columnName = new ArrayList<String>();

            params.add(EpName);
            columnName.add("ep_name");
            params.add(EpPrice);
            columnName.add("ep_price");
            params.add(EpcId);
            columnName.add("epc_id");
            params.add(EpBargain);
            columnName.add("ep_bargain");
            params.add(EpBaPrice);
            columnName.add("ep_ba_price");
            params.add(EpStock);
            columnName.add("ep_stock");
            params.add(EpBarCode);
            columnName.add("ep_bar_code");
            params.add(EpId);
            columnName.add("ep_id");

            for(int i = 0 ; i< columnName.size() ; i++){
                System.out.println(columnName.get(i) +  " --> " + params.get(i));
            }
            new TableService().updateProduct(columnName,params);

            response.sendRedirect("/manage/manage-result.jsp");
            return ;
        }

      //  System.out.println(new TableService().getProductById(EpId).getEpPrice() + " &&&& ");
        request.setAttribute("product",new TableService().getProductById(EpId));
        request.setAttribute("productcategorylist",new TableService().getProductCategoryTable());
        request.getRequestDispatcher("/manage/product-modify.jsp").forward(request,response);
    }
}
