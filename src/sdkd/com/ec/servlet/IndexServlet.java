package sdkd.com.ec.servlet;

import javafx.scene.control.Tab;
import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.model.EbRecentBrowse;
import sdkd.com.ec.service.TableService;
import sdkd.com.ec.util.PageUtil;
import sdkd.com.ec.util.Pair;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("newslist", new TableService().getNewsTable());
        request.setAttribute("productlist", new TableService().getProductTable());
        request.setAttribute("bargainlist", new TableService().getBargainProductList());
        request.setAttribute("hotlist", new TableService().getHotProductList());
        request.setAttribute("productcategorylist", new TableService().getProductCategoryTable());
        request.setAttribute("noticelist", new TableService().getNoticeTable());
        request.setAttribute("selected", "首页");

        String userName = (String) request.getSession().getAttribute("userName");
        if (userName != null) {
            List<EbRecentBrowse> all = new TableService().getRecentBrowseList(userName);
            request.setAttribute("recentbrowselist", new TableService().getRecentBrowseList(userName));
        }

        if (request.getParameter("general") != null) {
            doGeneral(request, response);
            return;
        }
        if (request.getParameter("bargain") != null) {
            doBargain(request,response);
            return;
        }
        //跳转
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGeneral(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String SearchContent = request.getParameter("searchcontent");
        PageUtil<EbProduct> pageUtil = new PageUtil<EbProduct>();
        Integer pageCount = pageUtil.getPageCount(new TableService().getProductTable());
        String nowPage = "1";
        String Selected = "百货";
        String page = request.getParameter("page");
        if(page != null) nowPage = page;
        request.setAttribute("pageurl", "/Index.Servlet?general=true");
        request.setAttribute("nowpage", nowPage);
        request.setAttribute("pagecount", pageCount);
        request.setAttribute("selected", Selected);
        if(SearchContent != null){
            request.setAttribute("pagecount", pageUtil.getPageCount(new TableService().searchProductByKeyWord(SearchContent)));
            request.setAttribute("productlist",new TableService().searchProductByKeyWord(SearchContent));
        }  else {
            request.setAttribute("productlist", pageUtil.getSpecificPageList(new TableService().getProductTable(), Integer.valueOf(nowPage)));
        }
        request.getRequestDispatcher("/index-other.jsp").forward(request, response);
    }
    protected void doBargain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageUtil<EbProduct> pageUtil = new PageUtil<EbProduct>();
        Integer pageCount = pageUtil.getPageCount(new TableService().getAllBargainProductList());
        String nowPage = "1";
        String Selected = "特价";
        String page = request.getParameter("page");
        if(page != null) nowPage = page;
        request.setAttribute("pageurl", "/Index.Servlet?bargain=true");
        request.setAttribute("nowpage", nowPage);
        request.setAttribute("pagecount", pageCount);
        request.setAttribute("selected", Selected);
        request.setAttribute("productlist", pageUtil.getSpecificPageList(new TableService().getAllBargainProductList(), Integer.valueOf(nowPage)));
        request.getRequestDispatcher("/index-other.jsp").forward(request, response);
    }
}
