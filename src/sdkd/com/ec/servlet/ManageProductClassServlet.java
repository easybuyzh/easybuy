package sdkd.com.ec.servlet;

import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbProductCategory;
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
@WebServlet(name = "ManageProductClassServlet")
public class ManageProductClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String EpcDelete = request.getParameter("epcdelete");
        String EpcId = request.getParameter("epcid");

        setPageInfo(request,response,new TableService().getProductCategoryTable(),"/ManageProductClass.Servlet");
        if (EpcDelete != null) {
            new TableService().deleteProductCategoryByEpcId(EpcId);
            response.sendRedirect("/ManageProductClass.Servlet");
            return;
        }
        request.setAttribute("selected","分类");
        request.getRequestDispatcher("/manage/productClass.jsp").forward(request, response);
    }
    protected void setPageInfo(HttpServletRequest request, HttpServletResponse response, List<EbProductCategory> all, String url) throws ServletException, IOException {
        String page = request.getParameter("page");
        PageUtil<EbProductCategory> pageUtil = new PageUtil<EbProductCategory>(50);
        String nowPage = "1";
        if (page != null) nowPage = page;
        Integer pageCount = pageUtil.getPageCount(all);
        String pageUrl = url;
        request.setAttribute("nowpage", nowPage);
        request.setAttribute("pagecount", pageCount);
        request.setAttribute("pageurl", pageUrl);
        //System.out.println(nowPage + " &&&&&&&&&&&&&& "  + all.size() + " -- " + pageUtil.getSpecificPageList(all, Integer.valueOf(nowPage)).size());
        request.setAttribute("productcategorylist", all);
    }
}
