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
        request.setAttribute("productcategorylist",new TableService().getProductCategoryTable());
        request.setAttribute("parentid",request.getParameter("id"));
        request.setAttribute("category",request.getParameter("category"));
        String userName = (String)request.getSession().getAttribute("userName");
        if(userName!=null){
            request.setAttribute("recentbrowselist",new TableService().getRecentBrowseList(userName));
        }

        String EpcId =  request.getParameter("id");
        String Page = request.getParameter("page");
        if(Page == null || Integer.valueOf(Page) == 0) Page = "1";
        int PageCount = new TableService().getProductListPageCountByCategory(EpcId);
        if(Integer.valueOf(Page) > PageCount) Page = String.valueOf(PageCount);
        request.setAttribute("pagecount",PageCount);
        request.setAttribute("pageurl","/ProductList.Servlet");
        request.setAttribute("productlist",new TableService().getProductListByCategoryInSpecificPage(EpcId , Integer.valueOf(Page)));
        request.setAttribute("nowpage",Page);

        request.setAttribute("id",EpcId);
        request.getRequestDispatcher("product-list.jsp").forward(request,response);

    }
}
