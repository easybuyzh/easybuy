package sdkd.com.ec.servlet;

import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.service.TableService;
import sdkd.com.ec.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        String QueryByEpcId = request.getParameter("querybyepcid");
        String QueryByEpName = request.getParameter("querybyepname");

        List<EbProduct> productList = new TableService().getProductTable();
        if(QueryByEpcId != null && QueryByEpcId.length() > 0){
                request.setAttribute("nowcategoryid",QueryByEpcId);
               productList = new TableService().getProductListByCategory(QueryByEpcId);
        }  else if(QueryByEpName != null && QueryByEpName.length() > 0){
               productList = new TableService().getProductListByEpName(QueryByEpName);
        }

        setPageInfo(request,response,productList,"/ManageProduct.Servlet"); // 设置分页信息

        if (EpDelete != null) {
            new TableService().deleteProductByEpId(EpId);
            response.sendRedirect("/ManageProduct.Servlet");
            return;
        }
        request.setAttribute("selected", "商品");
        request.setAttribute("productcategorylist",new TableService().getProductCategoryTable());
        request.getRequestDispatcher("/manage/product.jsp").forward(request, response);
    }

    protected void setPageInfo(HttpServletRequest request, HttpServletResponse response, List<EbProduct> all, String url) throws ServletException, IOException {
        String page = request.getParameter("page");
        PageUtil<EbProduct> pageUtil = new PageUtil<EbProduct>(10);
        String nowPage = "1";
        if (page != null) nowPage = page;
        Integer pageCount = pageUtil.getPageCount(all);
        String pageUrl = url;
        request.setAttribute("nowpage", nowPage);
        request.setAttribute("pagecount", pageCount);
        request.setAttribute("pageurl", pageUrl);
        request.setAttribute("productlist", pageUtil.getSpecificPageList(all, Integer.valueOf(nowPage)));
    }
}
