package sdkd.com.ec.servlet;

import sdkd.com.ec.service.TableService;
import sdkd.com.ec.service.impl.UploadService;
import sdkd.com.ec.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/10.
 */
@MultipartConfig(location = "C:\\Users\\zhaoshuai\\Desktop\\easybuy\\web\\images\\product")
public class ManageProductAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EpName = Utils.JspStringFormat(request.getParameter("epname"));
        String EpPrice = request.getParameter("epprice");
        String EpBargain = request.getParameter("epbargain");
        String EpBaPrice = request.getParameter("epbaprice");
        String EpStock = request.getParameter("epstock");
        String EpBarCode = request.getParameter("epbarcode_");
        String EpProductIcon = request.getParameter("photo");

        if (EpName != null) {
            List<String> params = new ArrayList<String>();
            List<String> columnName = new ArrayList<String>();

            params.add(EpName);
            columnName.add("ep_name");
            params.add(EpPrice);
            columnName.add("ep_price");
            params.add(EpBargain);
            columnName.add("ep_bargain");
            params.add(EpBaPrice);
            columnName.add("ep_ba_price");
            params.add(EpStock);
            columnName.add("ep_stock");
            params.add(EpBarCode);
            columnName.add("ep_bar_code");
            params.add(upload(request,response));
            columnName.add("ep_product_icon");
            new TableService().insertProduct(columnName,params);

            response.sendRedirect("/manage/manage-result.jsp");
            return ;
        }
        request.setAttribute("productcategorylist",new TableService().getProductCategoryTable());
        request.getRequestDispatcher("/manage/product-add.jsp").forward(request,response);
    }
    public String upload(HttpServletRequest request, HttpServletResponse  response)throws ServletException, IOException{
        Part part = request.getPart("photo");
        if(part.getSize() == 0) {
            return "1.jpg";
        }
        String header = part.getHeader("Content-Disposition");
        String fileName = header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
        part.write(fileName);
        return fileName;
    }
}
