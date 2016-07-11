package sdkd.com.ec.servlet;

import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.model.EbRecentBrowse;
import sdkd.com.ec.service.TableService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("newslist",new TableService().getNewsTable());
        request.setAttribute("productslist",new TableService().getProductTable());
        request.setAttribute("bargainlist",new TableService().getBargainProductList());
        request.setAttribute("hotlist",new TableService().getHotProductList());
        request.setAttribute("productcategorylist",new TableService().getProductCategoryTable());
        request.setAttribute("noticelist",new TableService().getNoticeTable());

        String userName = (String)request.getSession().getAttribute("userName");
        if(userName != null){
            List<EbRecentBrowse> all = new TableService().getRecentBrowseList(userName);
            //System.out.println(all.get(0).getErProductName() + "%%%%%%%%^^^^^^^^^^^^");
            request.setAttribute("recentbrowselist",new TableService().getRecentBrowseList(userName));
        }
        //跳转
        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }
}
