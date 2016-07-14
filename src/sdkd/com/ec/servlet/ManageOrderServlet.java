package sdkd.com.ec.servlet;

import sdkd.com.ec.model.EbOrder;
import sdkd.com.ec.model.EbOrderView;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.service.TableService;
import sdkd.com.ec.util.PageUtil;
import sdkd.com.ec.util.Utils;

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
@WebServlet(name = "ManageOrderServlet")
public class ManageOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eodelete = request.getParameter("eodelete");
        String eoid = request.getParameter("eoid");
        String QueryByEoId = request.getParameter("querybyeoid");
        String QueryByEuUserId = new TableService().getUserIdByUserName(request.getParameter("querybyusername"));

        List<EbOrderView> orderList = new TableService().getOrderViews();
        if (QueryByEoId != null && QueryByEoId.length() > 0) {
            orderList= new TableService().getOrderViewByEoId(QueryByEoId);
        } else if (QueryByEuUserId != null && QueryByEuUserId.length() > 0) {
            orderList = new TableService().getOrderViewByUserId(QueryByEuUserId);
        }
        setPageInfo(request,response,orderList);

        if (eodelete != null) {
            new TableService().deleteOrderByEoId(eoid);
            request.getRequestDispatcher("/manage/manage-result.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("manage/order.jsp").forward(request, response);
    }
    protected void setPageInfo(HttpServletRequest request, HttpServletResponse response , List<EbOrderView> all) throws ServletException, IOException {
        String page = request.getParameter("page");
        PageUtil<EbOrderView> pageUtil = new PageUtil<EbOrderView>(10);
        String nowPage = "1";
        if (page != null) nowPage = page;
        Integer pageCount = pageUtil.getPageCount(all);
        //System.out.println(pageCount + " **********8 ");
        String pageUrl = "/ManageOrder.Servlet";
        request.setAttribute("nowpage",nowPage);
        request.setAttribute("pagecount",pageCount);
        request.setAttribute("pageurl",pageUrl);
        request.setAttribute("orderlist", pageUtil.getSpecificPageList(all,Integer.valueOf(nowPage)));
    }
}
